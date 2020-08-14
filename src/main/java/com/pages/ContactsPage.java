package com.pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ElementUtils.ElementUtils;
import com.qa.ElementUtils.JavaScriptUtils;
import com.qa.hubSpot.basePage.BasePage;

public class ContactsPage extends BasePage {
	
	WebDriver driver;
	
	By ContactPageClick=By.xpath("//a[@class='navSecondaryLink']/div");
	ElementUtils e1;
	JavaScriptUtils js;
	By createContact=By.xpath("//span[text()='Create contact']");
	By emailField=By.xpath("//input[@data-field='email']");
	By firstNameField=By.xpath("(//div[@class='private-form__input-wrapper']/input)[1]");
	By lastNameByField=By.xpath("//input[@data-field='lastname']");
	By createContactButton=By.xpath("//button[@class='uiButton private-button private-button--primary private-button--default private-loading-button private-button--primary private-button--non-link']");
	
	public ContactsPage(WebDriver driver) {
		
		this.driver = driver;
		 e1= new ElementUtils(driver);
		 js= new JavaScriptUtils(driver);
		 
	}
	public void ClickOnContact()
	{
//	WebElement element=	e1.doGetElement(ContactPageClick);
//		js.flash(element);
//		e1.doClick(ContactPageClick);
	//driver.findElement(ContactPageClick).click();
	}
	
	public void createContacts(String email,String firstName,String lastName)
	{
		
		
		System.out.println("dangerzone");
		e1.elementVisible(createContact);
		e1.doClick(createContact);
		//e1.elementVisible(emailField);
		e1.doSenKeys(emailField, email);
		e1.doSenKeys(firstNameField, firstName);
		e1.doSenKeys(lastNameByField, lastName);
		e1.doClick(createContactButton);
		//js.clickUsingJS(e1.doGetElement(createContactButton));
		
		
		
		
	}
	
	
	
	
	
	
		

}
