package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ElementUtils.CredentialsManager;
import com.qa.ElementUtils.ElementUtils;
import com.qa.ElementUtils.JavaScriptUtils;
import com.qa.hubSpot.basePage.BasePage;

import io.qameta.allure.Step;

public class PageClass extends BasePage{
	
	
	WebDriver driver;
	By userNmae = By.xpath("//input[@id='username']");
	By password= By.id("password");
	By textverification=By.xpath("//div[text()='Poorna Sasiumar']");
	//By SignIn=By.xpath(xpathExpression);
	By loginButton=By.id("loginBtn");
	By contactsPage=By.id("nav-primary-contacts-branch");
	By contacts =By.id("nav-secondary-contacts");
	ElementUtils e1;
	CredentialsManager c1;
	JavaScriptUtils js;
	
	
	public PageClass(WebDriver driver) {
		this.driver=driver;
		e1=new ElementUtils(driver);
		js= new JavaScriptUtils(driver);
	}
	
	@Step("login with username:{0} and password{1}")//for allure reporting
	public ContactsPage login(CredentialsManager c1) throws InterruptedException
	
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		e1.doSenKeys(userNmae,c1.getUserName());
		WebElement usernew =e1.doGetElement(userNmae);
		//js.flash(usernew);
		//js.sendKeysUsingJsByID("username", c1.getUserName());
		e1.doSenKeys(password, c1.getPassWord());
	    e1.doClick(loginButton);
		//driver.findElement(loginButton).click();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    Thread.sleep(1000);
	   // e1.elementVisible(contactsPage);
	    e1.doClick(contactsPage);
	    e1.elementPresent(contacts);
	    e1.doClick(contacts);
	// return	new ContactsPage(driver);
	    return new ContactsPage(driver);
		
	}

	
}
