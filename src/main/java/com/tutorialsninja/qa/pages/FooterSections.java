package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterSections {
	WebDriver driver;
	@FindBy(xpath="//a[text()='My Account']")
	private WebElement MyAccount;
	
//Constructor
	public FooterSections(WebDriver driver){ 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Methods
	public LoginPage ClickMyAccount() { 
		MyAccount.click();
		return new LoginPage(driver);
	}

}
