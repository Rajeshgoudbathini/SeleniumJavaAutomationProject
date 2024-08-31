package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccesPage {

	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Password')]")
	private WebElement Password;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement WarningOrSuccessMessage;
	
//Getters and setters
	public WebElement getPassword() {
		return Password;
	}

	public void setPassword(WebElement password) {
		Password = password;
	}

	//Constructor
	public LoginSuccesPage(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Methods
	public ChangePasswordPage ClickPassword() { 
		Password.click();
		return new ChangePasswordPage(driver);
	}
	public String SuccessMessage() { 
		String str = WarningOrSuccessMessage.getText();
		return str;
	}
	
	public String WarningMessage() { 
		String str = WarningOrSuccessMessage.getText();
		return str;
	}
}
