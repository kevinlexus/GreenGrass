package com.greengrass.evhandler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.greengrass.house.AnyApp;
import com.greengrass.house.EvQue;
import com.greengrass.house.GGException;
import com.greengrass.house.Obj;

public class GreenEvVoice implements Runnable{

	Thread t;
	private AnyApp app=null;
	Process p;

	public GreenEvVoice() {
		t = new Thread(this);//создать свой поток
		t.start();//запустить поток
	}

	private void waitForThr() {
	      //Ожидаем выполнения команды в другом потоке, выводим содержание ответа
	      new Thread(new Runnable() {
	          public void run() {
	              BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	              String line = null; 

	              try {
	                  while ((line = input.readLine()) != null) {
	                      System.out.println(line);
	                  }
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	      }).start();

	      try {
			p.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
	}
	
	//речевое сообщение
	public void say(String speechAnsi, //голосовое сообщение
					String keyAPI, //API ключ от Яндекс сервиса
					String arg, //Аргументы к Яндекс сервису
					String preSound, //звук, предворяющий сообщение
					int zone //зона в которой воспроизвести сообщение (1-первая, 2-вторая, 3-все)
					) throws ClientProtocolException, IOException {
			  String speechUTF =URLEncoder.encode(speechAnsi, "UTF-8");
			  String ff;
			  HttpClient httpclient = new DefaultHttpClient();
			  HttpGet httpget = new HttpGet("http://tts.voicetech.yandex.net/generate?text="+speechUTF+"&format=wav&lang=ru-RU"+
			    (arg!=null ? arg: "")+"&key="+keyAPI);
			  HttpResponse response = httpclient.execute(httpget);
			  HttpEntity entity = response.getEntity();
 		      if (entity != null) {
 		    	  if (response.getStatusLine().getStatusCode() ==200) {
 		    	  //Если код возврата ОК(200) то	  
			      InputStream instream = entity.getContent();
			      try {
			          BufferedInputStream bis = new BufferedInputStream(instream);
			          BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("/tmp/temp.wav")));
			          int inByte;
			          while ((inByte = bis.read()) != -1 ) {
			              bos.write(inByte);
			          }
			          bis.close();
			          bos.close();
			      } catch (IOException ex) {
			          throw ex;
			      } catch (RuntimeException ex) {
			          httpget.abort();
			          throw ex;
			      } finally {
			          instream.close();
			      }
			      httpclient.getConnectionManager().shutdown();
			  
			      //воспроизвести файл внешней утилитой
			      
			      
			      String playpar="";
			      //только не в режиме тревоги
			      switch (zone) {
				      case 1: playpar="remix 1 0";
				      break;
				      case 2: playpar="remix 0 1";
				      break;
			      }

			      if (preSound != null) {
				      if (preSound.length() > 0){
					      //предварительный звук
					      p = Runtime.getRuntime().exec("play /tmp/"+preSound+".wav "+playpar);
					      //Ожидаем выполнения команды в другом потоке, выводим содержание ответа
		 		    	  app.mess("execute 1: "+"play /tmp/"+preSound+".wav "+playpar);
					      waitForThr();
				      }
			      }
 		    	  
			      //голосовое сообщение
			      p = Runtime.getRuntime().exec("play /tmp/temp.wav "+playpar);
			      //Ожидаем выполнения команды в другом потоке, выводим содержание ответа
 		    	  app.mess("execute 2: "+"play /tmp/temp.wav "+playpar);
			      waitForThr();
			      
 		    	} else {
 	 		    	  app.messUrgnt("Error while getting speech API wav file: "+response.getStatusLine());
 					  app.messUrgnt("Error in url: http://tts.voicetech.yandex.net/generate?text="+speechUTF+"&format=wav&lang=ru-RU"+
 						        (arg!=null ? arg: "")+"&key="+keyAPI);
 		    	}
 		    		
			  } else {
				  app.messUrgnt("Can't get entity by URL!");
			  }
			 
		
	}
	
	public void run() {
		try {
			app = new AnyApp("GGV");
		} catch (GGException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Obj house, zone1, zone2;
		app.dbgLvl=3;
		app.messUrgnt("GGEvVoice started...");

		while (true) {
		app.beginTrans();
		app.session.update(app.mainObj);//обновить из сессии объект иначе - could not initialize proxy - no Session
		List<EvQue> ev = app.session.createQuery(
				"from EvQue where fk_to_obj =:fk_to_obj and cancel is null")
				.setParameter("fk_to_obj", app.appObj.getId()
						)
				.list();
		
		house = (Obj) app.session.bySimpleNaturalId(Obj.class).load("HOUSE");
		zone1 = (Obj) app.session.bySimpleNaturalId(Obj.class).load("ZONE1");
		zone2 = (Obj) app.session.bySimpleNaturalId(Obj.class).load("ZONE2");
		
		//обработать события
		for(EvQue e : ev) { 
			app.mess("SAY: "+e.getSpeech());
			
			app.session.update(house);
			app.session.update(zone1);
			app.session.update(zone2);
			
			//включение необходимой зоны звучания
			int zone=0;
			if (e.getAlarm()==0) { 
				if (zone1.is_on() && zone2.is_on()) { 
				  zone=3;
				} 
				else if  (zone1.is_on() && !zone2.is_on()) {
	  		      zone=1;
				}
				else if  (!zone1.is_on() && zone2.is_on()) {
	  		      zone=2;
				}
			} else {
			  zone=3; //в режиме тревоги - все зоны включены
			}
			
			//если не включен ночной режим или сообщение в режиме тревоги и выбрана зона звучания и дома кто то присутствует
			if ((e.getAlarm()==1) || ((house.getBool("NIGHT_MODE")==false) && (zone!=0) && (house.getBool("PEOPLE_EXIST")==true)  )) {  
			//Сообщить голосом
			try {
				say(e.getSpeech(), app.mainObj.getStr("YANDEX_API_KEY"), e.getArg(), e.getPresound(), zone);
			} catch (ClientProtocolException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			//Обработать сообщение
			e.proc();
			
		}
		app.commitTrans();

		try {
		    Thread.sleep(500);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
    	}		
	}
	
	

}
