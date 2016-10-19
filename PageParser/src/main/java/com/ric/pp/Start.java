package com.ric.pp;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ric.pp.mm.ParseMng;
import com.ric.pp.mm.ProjMng;
import com.ric.pp.model.Proj;

@Component
public class Start {

	public void parse() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ParseMng parseMng = context.getBean(ParseMng.class);
		parseMng.parse();
		System.out.println("Start()");
	}
	
	public static void main(String[] args) {
		Start st = new Start();
		System.out.println("main-start");
		st.parse();
		System.out.println("main-end");
	}

}
