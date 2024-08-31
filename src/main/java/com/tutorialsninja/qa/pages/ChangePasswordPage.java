package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	
   WebDriver driver;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement Password;
	@FindBy(xpath="//input[@name='confirm']")
	private WebElement ConformPassword;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement ContinueButton;
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement Continue;
	
	//Constructor
	public ChangePasswordPage(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public ChangePasswordPage fillPasswordField(String str) { 
		 Password.sendKeys(str);
		 return this;
	}
	public ChangePasswordPage fillConformPasswordField(String str) { 
		ConformPassword.sendKeys(str);
		 return this;
	}
	public LoginSuccesPage ClickContinueButton() { 
		ContinueButton.click();
		return new LoginSuccesPage(driver);
	}
	public HomePage ClickContinueAfterAccountLogout () { 
		 Continue.click();
		 return new HomePage(driver);
	}

}
