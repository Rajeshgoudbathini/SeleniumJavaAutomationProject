package com.tutorialsninja.qa.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.Utilities.AddLogs;
import com.tutorialsninja.qa.Utilities.Extent_Reporter;

public class listeners implements ITestListener {
	ExtentReports extentReport;
	ExtentTest eTest;
	    
	@Override
	public void onStart(ITestContext context) {
		 extentReport = Extent_Reporter.generate_ExtentReport();
	}
	//Adding a commeent to verify
	
	@Override
	public void onTestStart(ITestResult result) {
		String testname = result.getName();
		 eTest = extentReport.createTest(testname);
		 eTest.log(Status.INFO, testname+" Exceution started ");
		 AddLogs.setExtentTest(eTest);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testname = result.getName();
		eTest.log(Status.PASS, testname+" got successfully exceuted");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getName();
		
		
	WebDriver driver = null;
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchFieldException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   File Srcscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   String destination = System.getProperty("user.dir")+"\\Screenshot\\"+testname+".png";
	   try {
		FileUtils.copyFile(Srcscreenshot,new File(destination));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   eTest.addScreenCaptureFromPath(destination);
	   eTest.log(Status.INFO,result.getThrowable());
	   eTest.log(Status.FAIL, testname+" got Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname = result.getName();
		eTest.log(Status.INFO,result.getThrowable());
		eTest.log(Status.SKIP, testname+" got skiped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}
}
