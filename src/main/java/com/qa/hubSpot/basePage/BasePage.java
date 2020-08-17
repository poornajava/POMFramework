package com.qa.hubSpot.basePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.aspectj.util.FileUtil;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.beust.jcommander.Parameter;
import com.qa.ElementUtils.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	private static final int FILE = 0;
	//WebDriver driver;
	public static boolean highLightElement;
	Properties prop;
	ChromeOptions co;
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getdriver()
	{
		return tlDriver.get();
		
	}
	
	
	
	public WebDriver init_Browser(String browerName)
	
	{
		
		prop=init_Properties();
		co= new ChromeOptions();
		highLightElement=prop.getProperty("highLight").equals("yes")?true:false;
		System.out.println(highLightElement);
		if(browerName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Poorna\\Desktop\\DRIVER\\IEDriverServer.exe");
			tlDriver.set(new InternetExplorerDriver());
			
			
		}
		else
		{
			//System.setProperty("webdriver.ie.driver", "C:\\Users\\Poorna\\Desktop\\DRIVER\\IEDriverServer.exe");
			WebDriverManager.chromedriver().setup();
			org.openqa.selenium.chrome.ChromeOptions options=  co.getChromeOptions();
			tlDriver.set(new ChromeDriver(options));
			
		}
		
		return getdriver();
	}
	
	
	public Properties init_Properties()
	{
		 prop = new Properties();
		 String file = null;
		 String env=null;
		 try
		 {
		 env= System.getProperty("env");
		
		if(env.equals("qa"))
		{
		 file =".\\src\\main\\java\\com\\qa\\config\\qa.Properties";
			}
		else if(env.equals("stage"))
		{
			 file =".\\src\\main\\java\\com\\qa\\config\\stage.Properties";
		}
		
		 }
		catch(Exception e)
		{
			file =".\\src\\main\\java\\com\\qa\\config\\config.Properties";
		}
		
		
		try {
			FileInputStream f1 = new FileInputStream(file);
			try {
				prop.load(f1);
			} catch (IOException e) {
				System.out.println("please check config file path");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return prop;
		
		
	}
	
	
	public String getScreenshot()
	{
		File src=((TakesScreenshot)getdriver()).getScreenshotAs(OutputType.FILE);
		String path =System.getProperty("user.Dir")+"/screenshots"+System.currentTimeMillis()+"_"+".png";
		File destionation = new File(path);
		try {
			FileUtil.copyFile(src, destionation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
		
	}

}
