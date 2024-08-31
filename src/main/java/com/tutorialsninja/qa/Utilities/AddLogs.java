package com.tutorialsninja.qa.Utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AddLogs {

	public static ExtentTest eTest;
	public static void setExtentTest(ExtentTest extentTest) { 
		eTest=extentTest;
	}
	
	public static void SetLogInfo(String message) { 
		
		if(eTest!= null) { 
			eTest.log(Status.INFO, message);
		}else { 
			System.out.println("ExtentTest is not set.Set any Info on test start in listeners class");
		}
	}
public static void Fail(String message) { 
		
		if(eTest!= null) { 
			eTest.log(Status.INFO, "Failed due to defect!");

			eTest.log(Status.FAIL, message);
		}else { 
			System.out.println("ExtentTest is not set.Set any Info on test start in listeners class");
		}
	}
}
