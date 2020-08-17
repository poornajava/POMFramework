package com.qa.ElementUtils;

import javax.swing.text.Document;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

	WebDriver driver;
	
	public JavaScriptUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public String getPageTitleUsingJS() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String tittle= js.executeScript("document.title").toString();
		return tittle;
		
	}
	
	public void refreshPageUsingJS() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
		
	}
	
	public String getBrowserInfoUsingJS()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String browserInfo=js.executeScript("navigator.userAgent").toString();
		return browserInfo;

	}
	
	
	public void clickUsingJS(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].click", element);

	}
	
	public void getPageInnerText()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.documentElement.innerText").toString();

		
	}
	
	public void sendKeysUsingJsByID(String Id,String text)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getWebElementById('"+Id+"').value='"+text+"'");
	}
	
	public void sendKeysUsingJsClassName(String className,String text)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getWebElementByName('"+className+"').value='"+text+"'");
	}
	
	public void scrollToUsingJS()
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight");
		

	}
	
	public  void scrollIntoView(WebElement element){
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
	    	js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }
	
	
	public  void flash(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i <  10; i++) {
            changeColor("rgb(0,200,0)", element,driver);//1
            changeColor(bgcolor, element,driver);//2
        }
    }
	
    public static void changeColor(String color, WebElement element, WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
    }
    
    
    public  void drawBorder(WebElement element){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

	
	
	
	
	
	
}
