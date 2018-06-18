package com.crm.qa.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public JavascriptExecutor js=(JavascriptExecutor)driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() throws Exception {

		prop = new Properties();
		prop.load(new FileInputStream(
				new File(System.getProperty("user.dir") + "/src/main/java/com/crm/qa/config/config.prop")));
	}

	public void initialization() throws Exception {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chromeDriver")) {
			System.setProperty("webdriver.chrome.driver", "//Users//ranjeethdidigum//Downloads//chromedriver");


			driver = new ChromeDriver();

		} else if (browserName.equals("firefoxDriver")) {

			System.setProperty("webdriver.gecko.driver", "//Users//ranjeethdidigum//Downloads//geckodriver");
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICit_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
