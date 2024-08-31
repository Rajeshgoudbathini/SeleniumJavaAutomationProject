package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {
WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	private WebElement RegisterAccountSuccessContinue;
	
//	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
//	private WebElement WarningOrSuccessMessage;
	

	//Constructor
	public SuccessPage(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Getters and Setters
	public WebElement getRegisterAccountSuccessContinue() {
		return RegisterAccountSuccessContinue;
	}
	public void setRegisterAccountSuccessContinue(WebElement registerAccountSuccessContinue) {
		RegisterAccountSuccessContinue = registerAccountSuccessContinue;
	}
	//Methods
	public AccountPage ClickContinue() { 
		RegisterAccountSuccessContinue.click();
        return new AccountPage(driver);
	}
	
}


