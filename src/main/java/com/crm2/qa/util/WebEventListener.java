package com.crm2.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm2.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}
	
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to: '" +url+ "'");
	}
	
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the: " + element.toString() + "'" 
				+  "before any change made");
	}
	
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value change to: " + element.toString()); 
	}
	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}
	
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back");
	}
	
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward");
	}
	
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}
	
	public void onException(Throwable error, WebDriver driver) {  //Throwable: exceptions & errors
		System.out.println("Exception occurred " + error);
		try {
			TestUtil.takeScreenshotAtEndOfTest();  //only when exception or error
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}
	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}
	
	//non overridden methods of WebListener class
	public void beforeScript(String script, WebDriver driver) {
	}
	
	public void afterScript(String script, WebDriver driver) {
	}
	
	public void beforeAlertAccept(WebDriver driver) {
	}

	public void afterAlertAccept(WebDriver driver) {
	}

	public void beforeAlertDissmis(WebDriver driver) {
	}
	
	public void afterAlertDissmis(WebDriver driver) {
	}
	
	public void beforeNavigateRefresh(WebDriver driver) {
	}
	
	public void afterNavigateRefresh(WebDriver driver) {
	}
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}
	
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}
	
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
	}
	public void afterGetText(WebElement element, WebDriver driver) {
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
	}
	
	public <X> void beforeGetScreenshotAs(OutputType<X> target){
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target){
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
