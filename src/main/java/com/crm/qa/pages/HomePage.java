package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseClass.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {
	

	// Page Factory Or Object Repository
	@FindBy(xpath = "//a[contains(@title,'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;

	@FindBy(xpath = "//a[contains(@title,'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(@title,'Tasks')]")
	WebElement tasksLink;

	@FindBy(xpath = "//td[contains(text(), 'User: Ranjeeth Didigum')]")
	WebElement verifyUsernameText;

	public HomePage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

	public ContactsPage clickOnContacts() throws Exception {
		contactsLink.click();
		return new ContactsPage();
	}

	public TasksPage clickOnTasks() {
		tasksLink.click();
		return new TasksPage();
	}

	public DealsPage clickOnDeals() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public String verifyUsernamePrinted() {
		String text = verifyUsernameText.getText();
		return text;
	}
	
	public void clickOnNewContacts() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		
	}
}





















