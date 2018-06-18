package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseClass.TestBase;

public class RegistrationPage extends TestBase {

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "surname")
	WebElement lastName;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "email_confirm")
	WebElement emailConfirm;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "passwordconfirm")
	WebElement confirmPassword;

	@FindBy(name = "agreeTerms")
	WebElement clickOnAgreeTerms;

	@FindBy(id = "submitButton")
	WebElement clickOnSubmitButton;
	
	@FindBy(xpath = "//select[@id='payment_plan_id']/option[text() = 'Free Edition']")
	WebElement selectPaymentPlan;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement clickOnSignUpButton;

	// Initializing the page objects
	public RegistrationPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

	// Actions on Login Page
	public String getTitleOfThePage() {
		return driver.getTitle();
	}

	public LoginPage registerUser(String fN, String lN, String ema, String emaiConf, String un, String pass,
			String passConfir) throws Exception {
		js.executeScript("arguments[0].click();", clickOnSignUpButton);
		//clickOnSignUpButton.click();
		selectPaymentPlan.click();
		firstName.sendKeys(fN);
		lastName.sendKeys(lN);
		email.sendKeys(ema);
		emailConfirm.sendKeys(emaiConf);
		username.sendKeys(un);
		password.sendKeys(pass);
		confirmPassword.sendKeys(passConfir);
		clickOnAgreeTerms.click();
		clickOnSubmitButton.click();
		return new LoginPage();
	}
   
	

}
