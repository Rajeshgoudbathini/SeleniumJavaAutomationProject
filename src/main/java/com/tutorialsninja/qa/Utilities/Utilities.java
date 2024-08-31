package com.tutorialsninja.qa.Utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	WebDriver driver;
	Actions actions;
//	WebDriverWait wait;
	public Utilities(WebDriver driver){ 
		this.driver=driver;	
	    this.actions=new Actions(driver);

		}
	
	//Actions class
	public void rightClick(WebDriver driver,WebElement ele) { 
		actions.contextClick(ele).perform();
	}
	public WebDriver getdriver(WebDriver driver) { 
		return this.driver=driver;
	}
	public void NavigateUsingTAB1(WebElement element) { 
		WebElement currentElement = driver.switchTo().activeElement();
		while(!currentElement.equals(element)) { 
			actions.sendKeys(Keys.TAB).perform();
			currentElement=driver.switchTo().activeElement();
		}
	}
	  // Navigate to the element using TAB
    public void NavigateUsingTAB2(WebElement element) {
        WebElement currentElement = driver.switchTo().activeElement();
        long endTime = System.currentTimeMillis() + 10000; // 10 seconds timeout

        while (!currentElement.equals(element) && System.currentTimeMillis() < endTime) {
            actions.sendKeys(Keys.TAB).perform();
            try {
                Thread.sleep(300); // Short sleep to allow UI updates
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentElement = driver.switchTo().activeElement();
        }

        if (!currentElement.equals(element)) {
            throw new RuntimeException("Failed to navigate to the specified element.");
        }
    }

	public void NavigateUsingTABAndSendkeys(WebElement element,String value) { 
		NavigateUsingTAB2(element);
		actions.sendKeys(value).perform();
	}
	 // Navigate to the element using TAB key, wait for it to be clickable, and then click it
    public void NavigateUsingTABAndClick(WebElement element, long timeoutInSeconds) {
    	NavigateUsingTAB2(element);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element)); // Wait until element is clickable
        // Optionally, ensure the element is focused
        actions.moveToElement(element).click().perform();
        }
    // Helper method to print placeholder information
    public  void printPlaceholder(String fieldName, String placeholder) {
        if (placeholder != null && !placeholder.isEmpty()) {
            System.out.println(fieldName + " has placeholder: " + placeholder);
        } else {
            System.out.println(fieldName + " does not have a placeholder.");
        }       
    }
     
    public String beforeORafterFROMHTML(WebElement element) { 
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
             String script = "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');";
         	 String beforeContent = (String) js.executeScript(script, element);
         	 return beforeContent;
    }
}
