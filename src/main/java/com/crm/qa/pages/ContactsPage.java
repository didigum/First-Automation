package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.baseClass.TestBase;

public class ContactsPage extends TestBase {

	// Page Factory Or Object Repository
	@FindBy(xpath = "//input[contains(@name,'cs_name')]")
	WebElement enterNameInContactsPage;

	@FindBy(name="title")
	WebElement newContactSelXpath;

	@FindBy(id = "first_name")
	WebElement newContactSelFirstName;

	@FindBy(id = "surname")
	WebElement newContactSelLasttName;

	@FindBy(xpath = "//input[@value='Load From Company']//following-sibling::input[@class='button' and @value ='Save']")
	WebElement newContactSaveButton;

	public ContactsPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);

	}

	public void enterNameOnContactsPage() {

		enterNameInContactsPage.sendKeys("testingprofile");
	}

	public void enterNewContactDetails(String name, String ftName, String ltName) {
		
		

		Select sel = new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(name);
		newContactSelFirstName.sendKeys(ftName);
		newContactSelLasttName.sendKeys(ltName);
		newContactSaveButton.click();

	}

}
