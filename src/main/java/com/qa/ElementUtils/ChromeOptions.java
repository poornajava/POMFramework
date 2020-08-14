package com.qa.ElementUtils;

import java.util.Properties;

public class ChromeOptions {
	
	org.openqa.selenium.chrome.ChromeOptions co;
	Properties prop;
	
	public ChromeOptions() {
	
		prop= new Properties();
	}
	
	public org.openqa.selenium.chrome.ChromeOptions getChromeOptions() {
		co= new org.openqa.selenium.chrome.ChromeOptions();
		co.addArguments("--incognito");
		if(prop.getProperty("headless").equals("yes"))
		{
			co.addArguments("--headless");
			
		}
		return co;
		
	}
	
	
	
	
	
	
	
	
}
