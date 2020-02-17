package com.crm.qa.testSuites;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseClass.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage ;
	HomePage homepage;

	public LoginPageTest() throws Exception {
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		loginpage = new LoginPage();
		
	}
	
	
	@Test(priority =1)
	public void validateLoginpageTitle() {
		String title= loginpage.getTitleOfThePage();
		assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test
	public void loginTest() throws Exception {
		homepage = loginpage.loginCrmPage(prop.getProperty("loginUsername"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("\"\" +result.getName()") );
		}
		driver.quit();
	}


	

}
