package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseClass.TestBase;

public class LoginPage extends TestBase {

	// Page Factory Or Object Repository
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signupButton;

	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement imageFinder;

	// Initializing the page objects
	public LoginPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

	// Actions on Login Page
	public String getTitleOfThePage() {
		return driver.getTitle();
	}

	public boolean checkTheImageLogo() {
		return imageFinder.isDisplayed();
	}

	public HomePage loginCrmPage(String us, String ps) throws Exception {
		username.sendKeys(us);
		password.sendKeys(ps);

		js.executeScript("arguments[0].click();", loginButton);
		return new HomePage();

	}

}
