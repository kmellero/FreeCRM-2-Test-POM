package com.crm2.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm2.qa.base.TestBase;

public class LoginPage extends TestBase {
 
	//Page Factory or Object Repository OR   just defining different webelements on the page
	
	@FindBy(name="username")  //FindBy replaces driver.findElement... with Page Factory
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")  //or by @value='Login'
	WebElement loginBtn;
	
	@FindBy(xpath="//font[@color='red']")     // 'Sign up' link
	WebElement signUpLnk;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmLogo;
	
	//Initializing the Page Objects
	public LoginPage() {  //constructor
		
		PageFactory.initElements(driver, this);  //driver from TestBase class, above PageFactory vars of"this"=LoginPage
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginBtn.click();  //entering HomePage
		Thread.sleep(3000);
		
		return new HomePage();
	}
	
	public SignUpPage validateSignUpLink() throws InterruptedException {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		Thread.sleep(3000);
		signUpLnk.click();
		Thread.sleep(3000);
		return new SignUpPage();
	}
}
