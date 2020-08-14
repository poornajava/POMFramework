package com.qa.TestClass;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.ContactsPage;
import com.pages.PageClass;
import com.qa.ElementUtils.CredentialsManager;
import com.qa.ElementUtils.ElementUtils;
import com.qa.ElementUtils.ExcelUtils;
import com.qa.hubSpot.basePage.BasePage;

public class ContactsPageTest {
	
	WebDriver driver;
	BasePage b1;
	Properties prop;
	PageClass p1;
	ContactsPage c1;
	CredentialsManager c2;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		b1= new BasePage();
		prop=b1.init_Properties();
		String browsername=prop.getProperty("browserName");
		driver=b1.init_Browser(browsername);
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		p1=new PageClass(driver);
		c2= new CredentialsManager(prop.getProperty("username"),prop.getProperty("password"));
		c1=p1.login(c2);
		

	}
		
	@DataProvider
	public  Object[][] getData()	
	{
		System.out.println("here");
			Object data[][]=ExcelUtils.excelUtils("ContactsPage");
			System.out.println("out");
			return data;
			
		
	}
	
	
	@Test(dataProvider="getData")
	public void Click(String emailId,String firstName,String lastName )
	{
		
		c1.createContacts(emailId,firstName,lastName);
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}