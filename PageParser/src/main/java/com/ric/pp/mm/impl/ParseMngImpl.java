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
			List<WebElement> el = driver.findElements(By.xpath("//div[@class='b-post__txt ']/parent::*"));

			for (WebElement e : el) {
				List<WebElement> chldLst = e.findElements(By.xpath(".//*"));
				String txt = null;
				for (WebElement e2 : chldLst) {
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
				}				
			}
			try {
				WebElement nextLink = driver.findElement(By.id("PrevLink"));
				nextLink.click();
			} catch (Exception e1) {
				System.out.println("Ошибка во время нажатия на линк 'следующая'");
			}
			//break;
		}
		
		System.out.println("Ended");
		

	}


}