package com.crm2.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm2.qa.base.TestBase;
import com.crm2.qa.pages.ContactsPage;
import com.crm2.qa.pages.DealsPage;
import com.crm2.qa.pages.HomePage;
import com.crm2.qa.pages.LoginPage;
import com.crm2.qa.pages.TasksPage;
import com.crm2.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	TestUtil testUtil;
	
	
	public HomePageTest() {       //HomePageTest constructor
		//1. it must call TestBase constructor first via super()
		//2. this gets all properties from TestBase constructor
		//3. only then it can call TestBase.initialization() method
		super();

	}
	//Test case: before-test1-after, and again before-test2-after, etc. 
	// =>independent runs, no cash, cookies, memory problems, as well as if cases are independent then
	// they should be run separately
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();  //to access LoginPage.login method
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}


	@Test   //(priority=n) remove from @Test. Otherwise, in Suite, only 1st test from each class is run
	public void homePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","Home page title not matched");  
		//msg if it fails, gives exp & obtained values as well
	}
	
	@Test
	public void verifyUserNameTest() {
		testUtil.switchToFrame();  //it is in the frame; needs to switch to this frame before locating element
		Assert.assertTrue(homePage.validateUserName());
	}
	
	@Test	
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactLink();
	}
	
	@Test
	public void verifyDealsLinkTest() {
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
