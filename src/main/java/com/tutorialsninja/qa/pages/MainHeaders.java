package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainHeaders {

	WebDriver driver;
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement MyAccount;
	
	@FindBy(xpath="//li/a[text()='Logout']")
	private WebElement Logout;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement LoginButton;
	
	
	public MainHeaders(WebDriver driver){ 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public MainHeaders ClickMyAccount() { 
		MyAccount.click();
		return this;
	}
	public MainHeaders LogoutFromAccountDropdown() { 
		ClickMyAccount();
		Logout.click();
		return this;
	}
	public ChangePasswordPage ClickLogout() { 	
		
		try {
			WebElement ele = driver.findElement(By.xpath("//a[text()='Logout']"));
			ele.click();
        }catch (Exception e) {
			e.printStackTrace();
		}
		return  new ChangePasswordPage(driver);
	}
	public MainHeaders SelectOptionFromDropdown(String dropdownOption) { 
		ClickMyAccount();	
		WebElement ele = driver.findElement(By.xpath("//a[text()='"+dropdownOption+"']"));
		ele.click();
		return this;
	}
}
