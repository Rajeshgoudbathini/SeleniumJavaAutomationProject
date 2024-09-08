package com.tutorialsninja.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainHeaders {
    
    private WebDriverWait wait;
    private WebDriver driver;

    @FindBy(xpath = "//li[@class='dropdown']/a[@title='My Account']")
    private WebElement myAccount;
    
    @FindBy(xpath = "//li/a[text()='Logout']")
    private WebElement logout;
    
    @FindBy(xpath = "//a[text()='Login']")
    private WebElement loginButton;

    public MainHeaders(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait in the constructor
        PageFactory.initElements(driver, this);
    }

    public MainHeaders ClickMyAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
        return this;
    }

    public MainHeaders logoutFromAccountDropdown() {
        ClickMyAccount();
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
        return this;
    }

    public ChangePasswordPage clickLogout() {
        try {
            WebElement ele = driver.findElement(By.xpath("//a[text()='Logout']"));
            wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ChangePasswordPage(driver);
    }

    public MainHeaders SelectOptionFromDropdown(String dropdownOption) {
        WebElement ele = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a[text()='" + dropdownOption + "']"));
        wait.until(ExpectedConditions.visibilityOf(ele)).click();
        return this;
    }
}















































//----------------------------------------------------------------------------------------------------

//package com.tutorialsninja.qa.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class MainHeaders {
//	public WebDriverWait wait;
//	public WebDriver driver;
//	@FindBy(xpath="//li[@class='dropdown']/a[@title='My Account']")
//	private WebElement MyAccount;
//	
//	@FindBy(xpath="//li/a[text()='Logout']")
//	private WebElement Logout;
//	
//	@FindBy(xpath = "//a[text()='Login']")
//	private WebElement LoginButton;
//	
//	
//	public MainHeaders(WebDriver driver){ 
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
//	}
//	
//	public MainHeaders ClickMyAccount() { 
//		MyAccount.click();
//		return this;
//	}
//	public MainHeaders LogoutFromAccountDropdown() { 
//		ClickMyAccount();
//		Logout.click();
//		return this;
//	}
//	public ChangePasswordPage ClickLogout() { 	
//		
//		try {
//			WebElement ele = driver.findElement(By.xpath("//a[text()='Logout']"));
//			ele.click();
//        }catch (Exception e) {
//			e.printStackTrace();
//		}
//		return  new ChangePasswordPage(driver);
//	}
//	public MainHeaders SelectOptionFromDropdown(String dropdownOption,WebDriver driver) { 
//		ClickMyAccount();	
//		WebElement ele = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a[text()='"+dropdownOption+"']"));
//		 // Wait for the dropdown menu to be visible
//         wait = new WebDriverWait(driver, 10); // 10 seconds wait time
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']")));
//		ele.click();
//		return this;
//	}
//}
