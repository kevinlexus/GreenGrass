package com.ric.pp.mm.impl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.pp.mm.ParseMng;
import com.ric.pp.mm.ProjMng;
import com.ric.pp.model.Proj;

@Service
public class ParseMngImpl implements ParseMng {

	
	@Autowired
	ProjMng prjMng;
	
	/**
	 * Начать парсинг страницы
	 */
	public void parse() {
		  
		System.out.println("Started");
		System.setProperty("webdriver.chrome.driver", "C:\\install\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.fl.ru/projects/");

		WebElement combo = driver.findElement(By.id("comboe"));
		System.out.println(combo.getAttribute("value"));
		combo.click();
		combo.sendKeys("Программирование");
		combo.sendKeys(Keys.RETURN);
		combo.submit();
		
		for (int page=1; page<=100; page++) {
			System.out.println("Page:"+page);
			//List<WebElement> el = driver.findElements(By.xpath("//div[@class='b-post__txt ']/parent::*"));
			List<WebElement> el = driver.findElements(By.xpath("//div[@id[starts-with(.,'project-item')]]"));

			for (WebElement e : el) {
//				WebElement e3 = e.findElement(By.xpath(".//text()[preceding::*[div[@class='b-post__bold b-layout__txt_inline-block']] "
						//+ "and following::*[a[@class='b-post__link b-post__link_bold b-post__link_fontsize_11 b-post__link_color_4e "
						//+ "b-post__link_color_0f71c8_hover b-page__ipad b-page__iphone']]]"));
				WebElement e3 = e.findElement(By.xpath(".//div[@class='b-post__foot b-post__foot_padtop_15']"
						+ "/div[@class='b-post__txt b-post__txt_fontsize_11 b-post__txt_overflow_hidden']"));						
				//WebElement e4 = e3.findElement(By.xpath(".//[text()='${nbsp}']"));
			    
				System.out.println("==============#"+e3.getText()+"#============");
				

				List<WebElement> chldLst = e.findElements(By.xpath(".//*"));
				String txt = null;
				String attr = null;
				boolean flag = false;
				//par
				
				for (WebElement e2 : chldLst) {
					/*try {
					WebElement e3 = e2.findElement(By.xpath(".//div[3]")); //*[@id="project-item2928368"]/div[3]/div[1]/text()
					//for (WebElement e3 : chldLst2) {
					  System.out.println("==============#"+e3.getAttribute("class")+"#============");
					} catch (Exception ex) {
						
					}*/
					
					//}
					attr=e2.getAttribute("class");
				    System.out.println("class="+attr);
					if (flag==true) {
						flag=false;
					}
					if (attr!=null && attr.contains("b-post__txt")) { 
						txt = e2.getText();
					}
					if (attr!=null && attr.contains("b-post__bold b-layout__txt_inline-block")) {
						System.out.println(e2.getText());
						flag=true;
					}
					
					if (e2.getAttribute("id").contains("project-reason-")) {
						String strId = e2.getAttribute("id");
						Integer projId = Integer.valueOf(strId.substring(16,strId.length()));
						//if (prjMng.getProjByOuterId(projId) == null) {
							//Proj proj = new Proj(projId, 0, txt, page);
							//prjMng.addProj(proj);
							System.out.println(txt);
							System.out.println("Добавлен проект с id:"+e2.getAttribute("id"));
						//}
					}
					
					
					/*
					if (e2.getAttribute("class").contains("b-post__txt")) { 
						txt = e2.getText();
					}
					if (e2.getAttribute("id").contains("project-reason-")) {
						String strId = e2.getAttribute("id");
						Integer projId = Integer.valueOf(strId.substring(16,strId.length()));
						if (prjMng.getProjByOuterId(projId) == null) {
							Proj proj = new Proj(projId, 0, txt, page);
							prjMng.addProj(proj);
							System.out.println("Добавлен проект с id:"+e2.getAttribute("id"));
							System.out.println(txt);
						}
					}
					
					*/
				}				
				System.out.println("------");
			}
			try {
				WebElement nextLink = driver.findElement(By.id("PrevLink"));
				nextLink.click();
			} catch (Exception e1) {
				System.out.println("Ошибка во время нажатия на линк 'следующая'");
			}
			break;
		}
		
		System.out.println("Ended");
		

	}


}