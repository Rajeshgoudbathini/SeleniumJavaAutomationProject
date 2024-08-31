package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterPage {

WebDriver driver;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1' and @checked]")
	private WebElement SubscribeYesChecked;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='0' and @checked]")
	private WebElement SubscribeNoChecked;
	

	//Constructor
	public NewsletterPage(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Methods
	public boolean VerifySubscribeYesIsSelected() { 
		return SubscribeYesChecked.isSelected();
	}
	
	public boolean VerifySubscribeNoIsSelected() { 
		return SubscribeNoChecked.isSelected();
	}
	
}
