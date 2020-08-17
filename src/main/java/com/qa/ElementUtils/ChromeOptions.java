package com.qa.ElementUtils;

import java.util.Properties;

import com.qa.hubSpot.basePage.BasePage;

public class ChromeOptions {
	
	org.openqa.selenium.chrome.ChromeOptions co;
	Properties prop;
	BasePage b1;
	
	public ChromeOptions() {
	
		b1= new BasePage();
		
		 prop=b1.init_Properties();
	}
	
	public org.openqa.selenium.chrome.ChromeOptions getChromeOptions() {
		co= new org.openqa.selenium.chrome.ChromeOptions();
		System.out.println("here...........");
		System.out.println(prop.getProperty("headless"));
		co.addArguments("--incognito");
		if(prop.getProperty("headless").equals("yes"))
		{
			co.addArguments("--headless");
			
		}
		return co;
		
	}
	
	
	
	
	
	
	
	
}
