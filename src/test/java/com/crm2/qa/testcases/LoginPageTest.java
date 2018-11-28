package com.crm2.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm2.qa.base.TestBase;
import com.crm2.qa.pages.LoginPage;
import com.crm2.qa.pages.SignUpPage;
import com.crm2.qa.pages.HomePage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	SignUpPage signUpPage;
	
	public LoginPageTest() {       //LoginPageTest constructor
		//1. it must call TestBase constructor first via super()
		//2. this gets all properties from TestBase constructor
		//3. only then it can call TestBase.initialization() method
		super();

	}
	
	//Test case: before-test1-after, and again before-test2-after, etc. 
	// =>independent runs, no cash, cookies, memory problems, as well as if cases are independent then
	// they should be run separately
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test  //(priority=n) remove from @Test. Otherwise, in Suite, only 1st test from each class is run
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test
	public void crmLogoTest() {
		boolean flag = loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void loginTest() {
		try {
			System.out.println(prop.getProperty("username") + " " + prop.getProperty("password"));
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}
	
	@Test
	public void signUpLnk() throws InterruptedException {
		signUpPage = loginPage.validateSignUpLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
