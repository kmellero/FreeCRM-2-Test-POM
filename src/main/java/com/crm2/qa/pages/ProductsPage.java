package com.crm2.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm2.qa.base.TestBase;

public class ProductsPage extends TestBase {

	@FindBy(xpath = "//a[@title='Products']")
	WebElement productsLinkPP;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLinkPP;

	@FindBy(xpath = "//td[contains(text(),'Products')]")
	WebElement productsLabel;

	@FindBy(xpath = "//input[@value='New Product' and @type='button']")
	public
	WebElement newProductBtn;

	@FindBy(id = "name")
	WebElement name;

	@FindBy(id = "cost")
	WebElement cost;

	@FindBy(id = "retail_value")
	WebElement retailValue;

	@FindBy(id = "wholesale")
	WebElement wholesale;

	@FindBy(id = "inventory_amount")
	WebElement inventoryAmount;

	@FindBy(name = "description")
	WebElement desc;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;

	// initializing the Page Objects
	public ProductsPage() { // constructor

		PageFactory.initElements(driver, this); // driver from TestBase class; this='ProductsPage'-above PageFactory
												// variables
	}

	public boolean verifyProductsLabel() {
		return productsLabel.isDisplayed();
	}

	public boolean verifyNewProductBtn() {
		return newProductBtn.isDisplayed();
	}

	public void selectProductByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]")).click();
	}

	//This is to get to Products (Deals->Products in dropdown list. 
	//Then to get Products list after saving in Product Page
	public ProductsPage clickOnProductsPP() {
		Actions action = new Actions(driver);
		action.moveToElement(dealsLinkPP).build().perform();
		productsLinkPP.click();
		return new ProductsPage();
	}
	public void createNewProduct(String pname, String pcost, String pretailVal, String pwholesaleVal,
			String pinventAmount, String pdesc) {

		name.clear();
		name.sendKeys(pname);
		cost.clear();
		cost.sendKeys(pcost);
		retailValue.clear();
		retailValue.sendKeys(pretailVal);
		wholesale.clear();
		wholesale.sendKeys(pwholesaleVal);
		inventoryAmount.clear();
		System.out.println("pinventAmount is " + pinventAmount);
		inventoryAmount.sendKeys(pinventAmount);  //decimal point added by either excel or field, needs integer
		desc.sendKeys(pdesc);
		saveBtn.click();  

	}
}
