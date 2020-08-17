package com.qa.TestClass;

import java.util.Properties;

import javax.security.auth.login.CredentialException;

import org.aspectj.weaver.tools.Trace;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.PageClass;
import com.qa.ElementUtils.AppConstants;
import com.qa.ElementUtils.CredentialsManager;
import com.qa.hubSpot.basePage.BasePage;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class TestClass {
	
	BasePage b1;
	WebDriver driver;
	PageClass p1;
	Properties prop;
	CredentialsManager c1;
	
	
	@BeforeMethod
//	@Parameters({"browser"})
	@Parameters(value={"browser"})
	
	public void setUp(@Optional String browser) throws Exception
	
	{
		System.out.println(browser);
		String browserName=null;
		
	b1= new BasePage();
	
	 prop=b1.init_Properties();
	
	if(browser==null)
	{
		  browserName=prop.getProperty("browserName");
	 
	

	}

 else
 {
	 browserName=browser;
 }
		
	
	driver=b1.init_Browser(browserName);
	p1=new PageClass(driver);
	driver.get(prop.getProperty("url"));
	
	c1= new CredentialsManager(prop.getProperty("username"),prop.getProperty("password"));
	}
	
@Test
public void LoginCheck() throws InterruptedException
{
	p1.login(c1);
	String tittle=driver.getTitle();
	System.out.println("poorna"+tittle);
	Assert.assertEquals(tittle,AppConstants.PAGE_TITTLE);
	

}

@Test(enabled = false)
void invalidDataLogin(String userName,String Password) throws InterruptedException
{
	
	c1.setUserName(userName);
	c1.setPassWord(Password);
	p1.login(c1);
}



@DataProvider
public Object[][] inValidData()
{
	Object data[][]= {{"poorna","password"}};
	return data;
}

//@AfterTest
//public void quit()
//{
//	driver.quit();
//}
	

}
