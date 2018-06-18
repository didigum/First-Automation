package com.crm.qa.testSuites;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.baseClass.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	DealsPage dealspage;
	ContactsPage contactspage;
	TasksPage taskspage;
	String sheetName = "task";

	public ContactsPageTest() throws Exception {
		super();

	}

	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		loginpage = new LoginPage();
		testUtil = new TestUtil();
		homepage = loginpage.loginCrmPage(prop.getProperty("loginUsername"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactspage = homepage.clickOnContacts();

	}

	@Test(priority = 1)
	public void enterName() throws Exception {
		contactspage.enterNameOnContactsPage();

	}

	/*@DataProvider
	public Object[][] getCRMTestdata() {

		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 2, dataProvider = "getCRMTestdata")
	public void enterNewContactList(String title, String firstName, String lastName) {
		homepage.clickOnNewContacts();
		contactspage.enterNewContactDetails(title, firstName, lastName);
	}*/

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
