package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
@FindBy(xpath = "//a[@title='My Account']")
	private WebElement MyAccount;

@FindBy(xpath = "//a[text()='Login']")
private WebElement LoginButton;

@FindBy(xpath="//a[text()='My Account']")
private WebElement FooterMyAccount;

@FindBy(xpath="//a[text()='Register']")
private WebElement Register;

	public WebElement getMyAccount() {
	return MyAccount;
}

public void setMyAccount(WebElement myAccount) {
	MyAccount = myAccount;
}

public WebElement getLoginButton() {
	return LoginButton;
}

public void setLoginButton(WebElement loginButton) {
	LoginButton = loginButton;
}

	public HomePage(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage ClickonMyAccountAndSelectLogin() { 
		MyAccount.click();
		LoginButton.click();
		return this;
	}
	public HomePage ClickonMyAccount() { 
		MyAccount.click();
		System.out.println("Note: Change all the element that can be accessed from topheader/container and change the script where the omePage is used at the begining  *Important and lots of modifications must be done for all the scripts if changed,Take a full day task on these and modify");
		return this;
	}
	
	public HomePage ClickonLogin() { 
		LoginButton.click();
		return this;
	}
	public RegisterPage ClickonRegister() { 
        Register.click();
		return new RegisterPage(driver);
	}
	public LoginPage ClickOnMyaccountInFooter() { 
		FooterMyAccount.click();
		return new LoginPage(driver);
	}
}
