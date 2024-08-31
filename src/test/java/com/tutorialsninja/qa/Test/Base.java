package com.tutorialsninja.qa.Test;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {

	public  Properties varprop;
	public  Properties fixprop;
	WebDriver driver;
	public Base() { 
		 varprop=new Properties();
		File basicfile=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\tutorialsninja\\qa\\config\\testdata\\basicdata.properties");
		
		 fixprop=new Properties();
		File fixedfile=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\tutorialsninja\\qa\\config\\fixeddata.properties");
		
		try {
			FileInputStream fis=new FileInputStream(basicfile);
			varprop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(fixedfile);
			fixprop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebDriver initilizeBrowser(String browser)  { 
		
		switch (browser.toLowerCase()) {
		case "chrome":
			 ChromeOptions options = new ChromeOptions();
		        // Add arguments to ChromeOptions
		        options.addArguments("--disable-web-security"); // Disable web security
		        options.addArguments("--user-data-dir=C:/ChromeDev"); // Specify user data directory
			driver=new ChromeDriver(options);
			break;
		case "edge":
			 EdgeOptions options1 = new EdgeOptions();

		        // Add arguments to ChromeOptions
			 options1.addArguments("--disable-web-security"); // Disable web security
			 options1.addArguments("--user-data-dir=C:/EdgeDev"); // Specify user data directory
			driver=new EdgeDriver(options1);
			break;
		case "firefox":
			FirefoxOptions options2 = new FirefoxOptions();

		        // Add arguments to ChromeOptions
			 options2.addArguments("--disable-web-security"); // Disable web security
		        options2.addArguments("--user-data-dir=C:/FirefoxDev"); // Specify user data directory
			driver=new FirefoxDriver(options2);
			break;
		default:
			System.out.println("Invalid browser : "+browser);
		throw new InvalidArgumentException("Please enter valid browsername");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(fixprop.getProperty("url"));
		return driver;
	}
}





