package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Breadcrumb {

	WebDriver driver;
	
	@FindBy(xpath="//ul[@class='breadcrumb']/li[3]/a[normalize-space(text())='Success']")
	private WebElement AccountCreationSuccess;
	
	public Breadcrumb(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean  VerifyRigisterAccountSuccessinBreadcrumb() { 
	return	AccountCreationSuccess.isDisplayed();
		
	}
}
