package com.crm2.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm2.qa.base.TestBase;
import com.crm2.qa.pages.HomePage;
import com.crm2.qa.pages.LoginPage;
import com.crm2.qa.pages.ProductsPage;
import com.crm2.qa.util.TestUtil;

public class ProductPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ProductsPage productsPage;
	String sheetName = "products";
	
	public ProductPageTest() {
		//1. it must call TestBase constructor first via super()
		//2. this gets all properties from TestBase constructor
		//3. only then it can call TestBase.initialization() method
		super();
	}
	
	@BeforeMethod
	public void setUp() {
			try {
				initialization();
				testUtil = new TestUtil();  //switchToFrame method
				loginPage = new LoginPage();  //login method
				homePage = new HomePage();		//ProductsPage, 	
				productsPage = new ProductsPage();  //createNewProduct method
				homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
				testUtil.switchToFrame();
				productsPage = homePage.clickOnProducts();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void productsLabelTest() {
		Assert.assertTrue(productsPage.verifyProductsLabel(),"Products label is missing");
	}
	
	@Test
	public void newProductBtnTest() {
		Assert.assertTrue(productsPage.verifyNewProductBtn(),"New Product button is missing");
	}

	@Test
	public void selectProductNameTest() {
		productsPage.selectProductByName("Ice breaker");
	}

	@DataProvider
	public Object[][] getCrm2TestData(){
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=1, dataProvider="getCrm2TestData")
	public void validateCreateNewProductTest(String na, String co, String retV, String whP, String invAm, String de) {
		try {
			homePage.clickOnProducts();
			productsPage.newProductBtn.click();
			Thread.sleep(2000);
			productsPage.createNewProduct(na, co, retV, whP, invAm, de);
			Thread.sleep(2000);
			productsPage.clickOnProductsPP();
			Thread.sleep(2000);
	
			String pName = driver.findElement(By.xpath("//a[contains(text(),'"+na+"')]")).getText();
			Assert.assertEquals(pName, na);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
