package com.greengrass.house;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.apache.tools.ant.DirectoryScanner;
import org.hibernate.Session;

public class AnyApp {

	public Obj appObj, mainObj;
	public Session session;
	public String appCd, typeos, slash; 
	public Message mess;
	public int dbgLvl;
	
	public AnyApp(String appCd) throws GGException {
		this.appCd=appCd;

		beginTrans();
		System.out.println("3.3.1");
		appObj = (Obj) this.session.bySimpleNaturalId(Obj.class).load(appCd);
		System.out.println("3.3.2");
		mainObj = (Obj) this.session.bySimpleNaturalId(Obj.class).load("GGH");
		System.out.println("3.3.3");
		
		if (appObj ==null){
			throw new GGException("App CD="+appCd+" doesn't suitable!");
		}

		//тип операционки
		this.typeos = mainObj.getStr("TYPEOS");
		System.out.println("3.3.4");

		//слэш в какую сторону - зависит от типа операционки
		if (this.typeos.equals("LINUX")) {
			slash = "/";
		} else {
			slash = "\\";
		}
		commitTrans();
		System.out.println("3.3.5");
        }

	//начать транзакцию, получить текущую сессию
	public void beginTrans() {
		this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		this.session.beginTransaction();
	}
	
	//закоммитить транзакцию
	public void commitTrans() {
		this.session.getTransaction().commit();
	}
	
	//откатить транзакцию
	public void rollbackTrans() {
		this.session.getTransaction().rollback();
	}

	public String readFileLine (String fname){
   	    try { 
       	    List<String> lines=Files.readAllLines(Paths.get(fname),
       		    StandardCharsets.UTF_8);
			if (dbgLvl > 2 ) {
	         mess("Reading from "+fname+", "+lines.get(0));
       	    }
       	    return lines.get(0);

   	    } catch (IOException e){
			if (dbgLvl > 2 ) {
	   	    	mess("Can't read file "+fname);
       	    }
	        return null;
   	    }

	}

	public void writeFileLine (String fname, Object val){
		String a=val.toString();

		try { 
       	    Files.write(Paths.get(fname), a.getBytes(),
       	         StandardOpenOption.CREATE,
       	         StandardOpenOption.TRUNCATE_EXISTING );
			if (dbgLvl > 2 ) {
       	    	mess("Writing to "+fname+", "+val);
       	    }
   	    } catch (IOException e){
			if (dbgLvl > 2 ) {
				mess("Can't write file "+fname);
    	    }
   	    }
	}
	
	//вспомогательная процедура сравнения свойств объектов
	public boolean isEquals(Object o1, Object o2) {
        if (o1 == null && o2 != null) {
        	return false;
        } else if (o1 != null && o2 == null) {
        	return false;
        } else if (o1 == null && o2 == null) {
        	return true;
        } else {
        	if (o1.equals(o2)) {
        		return true;
        	} else
        	{
        		return false;
        	}
        }
    }	

	//Функция проверки наличия директории! по шаблону
	public boolean existDirByPart(String fdir, final String fname) {

		DirectoryScanner scanner = new DirectoryScanner();
		scanner.setIncludes(new String[]{fname});
		scanner.setBasedir(new File(fdir));
		scanner.setCaseSensitive(false);
		scanner.scan();
		String[] files = scanner.getIncludedDirectories();
		if (files.length > 0) {
			  return true;	
		} else {
			  return false;
		}
	
	}	
	//Функция проверки наличия файла! по шаблону
	public boolean existFileByPart(String fdir, final String fname) {

		DirectoryScanner scanner = new DirectoryScanner();
		scanner.setIncludes(new String[]{fname});
		scanner.setBasedir(new File(fdir));
		scanner.setCaseSensitive(false);
		scanner.scan();
		String[] files = scanner.getIncludedFiles();
		if (files.length > 0) {
			  return true;	
		} else {
			  return false;
		}
	
	}	
	
	//Отправить в консоль сообщение
	public void mess(String txt) {
		/*	DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			ZonedDateTime dt = ZonedDateTime.now();
			System.out.println(dt.format(frmt)+' '+txt);*/
			if (dbgLvl > 0 ) {
				System.out.println(appCd+": "+txt);
			}
		}

	//Отправить в консоль сообщение
	public void mess(String txt, Integer dbg) {
		/*	DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			ZonedDateTime dt = ZonedDateTime.now();
			System.out.println(dt.format(frmt)+' '+txt);*/
			if (dbg > 0 ) {
				System.out.println(appCd+": "+txt);
			}
		}

	//Отправить в консоль важное сообщение
	public void messUrgnt(String txt) {
			System.out.println(appCd+": "+txt);
		}

	
}