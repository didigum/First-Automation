package com.crm.qa.testSuites;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseClass.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	DealsPage dealspage;
	ContactsPage contactspage;
	TasksPage taskspage;

	public HomePageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		loginpage = new LoginPage();
		testUtil = new TestUtil();
		homepage = loginpage.loginCrmPage(prop.getProperty("loginUsername"), prop.getProperty("password"));

	}

	@Test(priority = 0)
	public void validateLoginpageTitle() {

		String title = loginpage.getTitleOfThePage();
		assertEquals(title, "Free CRM software in the cloud powers sales and customer service", "Title is wrong");
	}

	@Test(priority = 1)
	public void validateUsernameText() {

		testUtil.switchToFrame();
		String verifiedText = homepage.verifyUsernamePrinted();
		Assert.assertEquals(verifiedText, "User: Ranjeeth Didigum", "The text was something");

	}

	@Test(priority = 2)
	public void clickOnDealsLink() {
		testUtil.switchToFrame();
		dealspage = homepage.clickOnDeals();
	}

	@Test(priority = 3)
	public void clickOnContactsLink() throws Exception {
		testUtil.switchToFrame();
		contactspage = homepage.clickOnContacts();
	}

	@Test(priority = 4)
	public void clickOnTasksLink() {
		testUtil.switchToFrame();
		taskspage = homepage.clickOnTasks();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

}
