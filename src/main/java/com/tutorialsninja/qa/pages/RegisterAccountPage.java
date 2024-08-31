package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {

	WebDriver driver;
	
	@FindBy(xpath="//div[@class=\"list-group\"]/a[text()='Login']")       //Note: Change these Xpath 
	private WebElement Login;
	
	

	//Constructor
	public RegisterAccountPage(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Methods
	public LoginPage ClickOnLogin () { 
		Login.click();
		return new LoginPage(driver);
	}
}
