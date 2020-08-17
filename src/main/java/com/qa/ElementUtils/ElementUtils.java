package com.qa.ElementUtils;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubSpot.basePage.BasePage;

public class ElementUtils extends BasePage {
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	JavaScriptUtils js;
	
	
	public ElementUtils(WebDriver driver) {
		
		this.driver=driver;
		js=new JavaScriptUtils(driver);
	}

	/*
	 * Wait for element present
	 */
	public boolean elementPresent(By locator)
	{
		wait=new WebDriverWait(driver, AppConstants.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return true;
		
	}
	
	/*
	 * Wait for element visisble
	 */
	
	public void elementVisible(By locator)
	{
		
		wait=new WebDriverWait(driver, AppConstants.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	
	
	
	/*
	 * wait for page Tittle
	 */
	
	public boolean waitforPageTittle()
	{
		wait=new WebDriverWait(driver, AppConstants.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.titleIs(AppConstants.PAGE_TITTLE));
		return true;
	}
	
	
	/*
	 * doGetElement
	 * 
	 */
	
	public WebElement doGetElement(By locator)
	{
		WebElement element = null;
//		BasePage b1;
//		
//		b1= new BasePage();
//		prop=b1.init_Properties();
		//prop=b1.init_Properties();
		
		
		try
		
		{ 		
		 boolean b=elementPresent(locator);
		 if(b=true)
		 {
		 element=driver.findElement(locator);
		}
		 
		if(highLightElement)
		{
				js.flash(element);
			}
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println("Element not created");
	}
		
		return element;

	}
	
	
	
	
	public void doClick(By locator) {
		driver.findElement(locator).click();
	}
	
	public void doSenKeys(By locator,String Value)
	{
		WebElement element =doGetElement(locator);
		element.sendKeys(Value);
	}
	
	

}
