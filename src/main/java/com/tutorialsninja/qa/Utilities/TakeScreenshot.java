package com.tutorialsninja.qa.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
WebDriver driver;
	
	public void takeScreenshot() { 
		
		//TakesScreenshot sc=(TakesScreenshot)driver;
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
File destination = new File(System.getProperty("user.dir")+"\\Screenshot\\"+"newfile.png");
        try {
	FileUtils.copyFile(src, destination);
       } catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
        }
	}
}

