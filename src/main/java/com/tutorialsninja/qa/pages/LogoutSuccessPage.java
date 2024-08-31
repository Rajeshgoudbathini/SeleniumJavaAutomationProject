package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutSuccessPage {
	  WebDriver driver;
		
		@FindBy(xpath="//a[text()='Continue']")
		private WebElement Continue;
		
		//Constructor
		public LogoutSuccessPage(WebDriver driver) { 
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
//Methods
		public HomePage ClickContinueAfterAccountLogout () { 
			 Continue.click();
			 return new HomePage(driver);
		}
}
