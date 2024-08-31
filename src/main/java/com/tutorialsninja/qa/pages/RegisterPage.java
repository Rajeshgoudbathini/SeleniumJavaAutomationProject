package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	//Elements
		@FindBy(id="input-firstname")
		private WebElement firstName;
		
		@FindBy(id="input-lastname")
		private WebElement lastname;
		
		@FindBy(id="input-email")
		private WebElement Email;
		
		@FindBy(id="input-telephone")
		private WebElement Telephone;
		
		@FindBy(xpath="//input[@name='password']")
		private WebElement Password;
		
		@FindBy(xpath="//input[@name='confirm']")
		private WebElement Conformpassword;
		
		@FindBy(xpath="//label[@class=\"radio-inline\"]/input[@value='1']")
		private WebElement SubscribeYesRadioButton;
		
		@FindBy(xpath="//label[@class=\"radio-inline\"]/input[@value='0']")
		private WebElement SubscribeNoRadioButton;
		
		@FindBy(xpath="//input[@type='checkbox']")
		private WebElement PrivacyPolicyCheckBox;
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement Continue;
		
		@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
		private WebElement WaraningMessageFirstname;
		
		@FindBy(xpath="//input[@name='lastname']/following-sibling::div")
		private WebElement WaraningMessageLastname;
		
		@FindBy(xpath="//input[@name='email']/following-sibling::div")
		private WebElement WaraningMessageEmail;
		
		@FindBy(xpath="//input[@name='telephone']/following-sibling::div")
		private WebElement WaraningMessageTelephone;
		
		@FindBy(xpath="//input[@name='password']/following-sibling::div")
		private WebElement WaraningMessagePassword;
		
		@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
		private WebElement WaraningMessagePrivacyPolicy;
		
		@FindBy(xpath="//input[@type='password']/following-sibling::div")
		private WebElement WaraningMessageConformPassword;
		
		@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
		private WebElement WaraningMessageEmailAlreadyRegistered;
		
		//Getters and Setters
		
		public WebDriver getDriver() {
			return driver;
		}


		public void setDriver(WebDriver driver) {
			this.driver = driver;
		}


		public WebElement getFirstName() {
			return firstName;
		}


		public void setFirstName(WebElement firstName) {
			this.firstName = firstName;
		}


		public WebElement getLastname() {
			return lastname;
		}


		public void setLastname(WebElement lastname) {
			this.lastname = lastname;
		}


		public WebElement getEmail() {
			return Email;
		}


		public void setEmail(WebElement email) {
			Email = email;
		}


		public WebElement getTelephone() {
			return Telephone;
		}


		public void setTelephone(WebElement telephone) {
			Telephone = telephone;
		}


		public WebElement getPassword() {
			return Password;
		}


		public void setPassword(WebElement password) {
			Password = password;
		}


		public WebElement getConformpassword() {
			return Conformpassword;
		}


		public void setConformpassword(WebElement conformpassword) {
			Conformpassword = conformpassword;
		}


		public WebElement getSubscribeYesRadioButton() {
			return SubscribeYesRadioButton;
		}


		public void setSubscribeYesRadioButton(WebElement subscribeYesRadioButton) {
			SubscribeYesRadioButton = subscribeYesRadioButton;
		}


		public WebElement getSubscribeNoRadioButton() {
			return SubscribeNoRadioButton;
		}


		public void setSubscribeNoRadioButton(WebElement subscribeNoRadioButton) {
			SubscribeNoRadioButton = subscribeNoRadioButton;
		}


		public WebElement getPrivacyPolicyCheckBox() {
			return PrivacyPolicyCheckBox;
		}


		public void setPrivacyPolicyCheckBox(WebElement privacyPolicyCheckBox) {
			PrivacyPolicyCheckBox = privacyPolicyCheckBox;
		}


		public WebElement getContinue() {
			return Continue;
		}


		public void setContinue(WebElement continue1) {
			Continue = continue1;
		}


		public WebElement getWaraningMessageFirstname() {
			return WaraningMessageFirstname;
		}


		public void setWaraningMessageFirstname(WebElement waraningMessageFirstname) {
			WaraningMessageFirstname = waraningMessageFirstname;
		}


		public WebElement getWaraningMessageLastname() {
			return WaraningMessageLastname;
		}


		public void setWaraningMessageLastname(WebElement waraningMessageLastname) {
			WaraningMessageLastname = waraningMessageLastname;
		}


		public WebElement getWaraningMessageEmail() {
			return WaraningMessageEmail;
		}


		public void setWaraningMessageEmail(WebElement waraningMessageEmail) {
			WaraningMessageEmail = waraningMessageEmail;
		}


		public WebElement getWaraningMessageTelephone() {
			return WaraningMessageTelephone;
		}


		public void setWaraningMessageTelephone(WebElement waraningMessageTelephone) {
			WaraningMessageTelephone = waraningMessageTelephone;
		}


		public WebElement getWaraningMessagePassword() {
			return WaraningMessagePassword;
		}


		public void setWaraningMessagePassword(WebElement waraningMessagePassword) {
			WaraningMessagePassword = waraningMessagePassword;
		}


		public WebElement getWaraningMessagePrivacyPolicy() {
			return WaraningMessagePrivacyPolicy;
		}


		public void setWaraningMessagePrivacyPolicy(WebElement waraningMessagePrivacyPolicy) {
			WaraningMessagePrivacyPolicy = waraningMessagePrivacyPolicy;
		}


		//Constructor
		public RegisterPage(WebDriver driver) { 
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		//Methods
		public RegisterPage EnterFirstname(String firstname) {  
			firstName.sendKeys(firstname);
			return this;
		}
		
		public RegisterPage EnterLastname(String lastName) {  
			lastname.sendKeys(lastName);
			return this;
		}
		public RegisterPage EnterEmail(String email) {  
			Email.sendKeys(email);
			return this;

		}
		public RegisterPage EnterTelephone(String telePhone) {  
			Telephone.sendKeys(telePhone);
			return this;

		}
		public RegisterPage EnterPassword(String password) {  
			Password.sendKeys(password);
			return this;

		}
		public RegisterPage EnterConformpassword(String conformPassword) {  
			Conformpassword.sendKeys(conformPassword);
			return this;

		}

		public RegisterPage SubscribeYesRadioButton() {  
			SubscribeYesRadioButton.click();
			return this;

		}
		
		public RegisterPage SubscribeNoRadioButton() {  
			SubscribeNoRadioButton.click();
			return this;

		}
		public RegisterPage PolicyCheckbox() {  
			PrivacyPolicyCheckBox.click();
			return this;

		}
			
		public SuccessPage ClickContinue() {  
			Continue.click();
			return new SuccessPage(driver);
		}
		
		//Warning Messages
		public String FirstnameWaraningMessage() {  
		return	WaraningMessageFirstname.getText();
		}
		
		public String LastnameWaraningMessage() {  
			return	WaraningMessageLastname.getText();
			}
		public String EmailWaraningMessage() {  
			return	WaraningMessageEmail.getText();
			}
		public String TeleponeWaraningMessage() {  
			return	WaraningMessageTelephone.getText();
			}
		public String PasswordWaraningMessage() {  
			return	WaraningMessagePassword.getText();
			}
		public String PrivacyPolicyWaraningMessage() {  
			return	WaraningMessagePrivacyPolicy.getText();
			}
		public String ConformPasswordWaraningMessage() {  
			return	WaraningMessageConformPassword.getText();
			}
		public String EmailAlreadyRegisteredWaraningMessage() {  
			return	WaraningMessageEmailAlreadyRegistered.getText();
			}
	}

