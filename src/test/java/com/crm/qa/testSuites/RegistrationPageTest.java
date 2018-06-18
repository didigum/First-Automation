package com.crm.qa.testSuites;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseClass.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RegistrationPage;

public class RegistrationPageTest extends TestBase {
	RegistrationPage rpt;
	LoginPage loginPage;

	public RegistrationPageTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		rpt = new RegistrationPage();
	}

	@Test
	public void registerCRMUser() throws Exception {

				rpt.registerUser(prop.getProperty("firstName"), prop.getProperty("lastName"),
				prop.getProperty("email"), prop.getProperty("emailConfirm"), prop.getProperty("registrationUserName"),
				prop.getProperty("password"), prop.getProperty("confirmPassword"));

	}

}
