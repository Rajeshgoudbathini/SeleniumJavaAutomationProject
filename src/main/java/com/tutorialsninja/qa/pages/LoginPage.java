package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
WebDriver driver;
Actions actions;

	@FindBy(id = "input-email")
	private WebElement EmailTextfield;
	@FindBy(xpath="//input[@type='password']")
	private WebElement PasswordTextfield;
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement Warningmessage;
	@FindBy(xpath="//div[@class='form-group']/child::a")
	private WebElement ForgotPassword;
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement Continue;

	
	//Getters and setters
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmailTextfield() {
		return EmailTextfield;
	}

	public void setEmailTextfield(WebElement emailTextfield) {
		EmailTextfield = emailTextfield;
	}

	public WebElement getPasswordTextfield() {
		return PasswordTextfield;
	}

	public void setPasswordTextfield(WebElement passwordTextfield) {
		PasswordTextfield = passwordTextfield;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		LoginButton = loginButton;
	}

	public WebElement getWarningmessage() {
		return Warningmessage;
	}

	public void setWarningmessage(WebElement warningmessage) {
		Warningmessage = warningmessage;
	}

	public WebElement getForgotPassword() {
		return ForgotPassword;
	}

	public void setForgotPassword(WebElement forgotPassword) {
		ForgotPassword = forgotPassword;
		
	}

	
	//Constructor to initilize elements every time when class is invoked
	public LoginPage(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	    actions=new Actions(driver);
	}
	
	//Input Fields	
	public LoginPage enterEmail(String email) { 
		EmailTextfield.sendKeys(email);;
		return this;
	}
	public LoginPage enterPasssword(String password) { 
		PasswordTextfield.sendKeys(password);
		return this;
	}
	
	//Buttons or Links
     public LoginSuccesPage ClickLoginButton() { 
		LoginButton.click();
  	  return new LoginSuccesPage(driver);    
	}
     public LoginPage ClickForgotpassword() { 
    	 ForgotPassword.click();
    	 return this;
 	}
     public LoginPage fillLoginCredentials(String email,String Password) { 
    	 enterEmail(email);
    	 enterPasssword(Password);	 
    	  return this;    
    }
     public RegisterAccountPage NewCustomerLogin() { 
    	 Continue.click(); 
    	  return new RegisterAccountPage(driver);    
    }
     
     public void SelectElementFromRightColumn(String Element) { 
    	   driver.findElement(By.xpath("//div[@class='list-group']/a[text()='"+Element+"']"));
    }
 //----------------------------------------------------------------------------------------------------------
     //Login using Keyboard controls
     public void NaviagteToTab(WebElement ele) {
       
    	WebElement currentElement = driver.switchTo().activeElement();
    	while(!currentElement.equals(ele)) { 
    		actions.sendKeys(Keys.TAB).perform();
    		currentElement=driver.switchTo().activeElement();
    	}
    	 
     }
     
     
  //--------------------------------------------------------------------------------------------------------
     //Warning Messages
     public String Warningmessage_Displayed() { 
    	return  Warningmessage.getText();
 	}
}
