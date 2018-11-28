package com.crm2.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm2.qa.util.WebEventListener;
import com.crm2.qa.util.TestUtil;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;


	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Hp\\eclipse-workspace\\FreeCRM-2-Test\\src\\main\\java\\com\\crm2\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		String userName = prop.getProperty("username");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium-ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} /*else if(browserName.equals("ff")) {   //change in config.properties
			System.setProperty("webdriver.firefox.driver", "C:\\Program Files\\Selenium-FirefoxDriver\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
		}*/
		// to log actions.  See also WebEventListener class in com.crm2.qa.util
		e_driver = new EventFiringWebDriver(driver);
		//Now create object of EventListenerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}