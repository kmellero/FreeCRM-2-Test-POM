package com.crm2.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm2.qa.base.TestBase;

public class HomePage extends TestBase{

	
//	@FindBy(xpath="//td[contains(text(),'User: Kajetan Mellerowicz')]") 
	//it is in the frame, so needs first to TestUtil.switchToFrame in the test
	@FindBy(xpath = "//td[@class='headertext'][contains(.,'User: Kajetan Mellerowicz')]")
	@CacheLookup
	WebElement userNameLabel; 
	//if page is refreshed, elements become stale in CacheLookup (stale Exception). Don't use for
	// all elements
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(@title,'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
//	@FindBy(xpath="//a[contains(text(),'Done')]")  //to get FAILed test
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[@title='Products']")
	WebElement productsLink;
	
	//Initializing the Page Objects
	public HomePage() {  //constructor
				PageFactory.initElements(driver, this);  //driver from TestBase class, above PageFactory vars of"this"=HomePage
	}

	//Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
 
	public boolean validateUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();  //return next landing page TasksPage
		return new TasksPage();
	}
	
	
	//This is for creating NewContact from ContactLink- for data driven from excel scenario
	//mouse over Contacts, then click on displayed in dropdown list
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform(); //whenever using actions class must use build().perform();
		newContactLink.click();
		
	}
	
	//This is to get to Products (Deals->Products in dropdown list. Then to create New Products
	public ProductsPage clickOnProducts() {
		Actions action = new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		productsLink.click();
		return new ProductsPage();
	}
	
}
 