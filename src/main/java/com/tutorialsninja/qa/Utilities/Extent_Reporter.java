package com.tutorialsninja.qa.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//public class ExtentReporter {
//
//    public  ExtentReports extentReports;
//
//    public  ExtentReports generate_Report() {
//        extentReports = new ExtentReports();
//        File file = new File(System.getProperty("user.dir") + "\\Reports\\report" + timestamp() + ".html");
//        ExtentSparkReporter reporter = new ExtentSparkReporter(file);
//        reporter.config().setTheme(Theme.DARK);
//        reporter.config().setDocumentTitle("Tutorialsninja Automation Project");
//        reporter.config().setTimeStampFormat("yyyy-MM-dd_HH:mm:ss");
//        extentReports.attachReporter(reporter);
//
//        Properties prop = new Properties();
//        try {
//        	FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\tutorialsninja\\qa\\config\\fixeddata.properties"));
//            prop.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        extentReports.setSystemInfo("Application Url", prop.getProperty("url"));
//        extentReports.setSystemInfo("Email used", prop.getProperty("emailID"));
//        extentReports.setSystemInfo("Password used", prop.getProperty("password"));
//        extentReports.setSystemInfo("Browser name", prop.getProperty("browser"));
//        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
//        extentReports.setSystemInfo("Operating System version", System.getProperty("os.version"));
//        extentReports.setSystemInfo("Author", System.getProperty("user.name"));
//
//        return extentReports;
//    }
//
//    public  void flush() {
//        if (extentReports != null) {
//            extentReports.flush();  // Write the report to the file
//        }
//    }
//
//    public static String timestamp() { 
//        return new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date());
//    }
//}

public class Extent_Reporter {
	
	public static ExtentReports generate_ExtentReport() { 
		
		ExtentReports extentReports=new ExtentReports();
		File file=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\eReport.html");
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
		
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setDocumentTitle("Tutorialsninja Test Automation");
		extentSparkReporter.config().setDocumentTitle("TN Automation Report");
		extentSparkReporter.config().setTimeStampFormat("dd//MM//yyyy hh:mm:ss");
		
		extentReports.attachReporter(extentSparkReporter);
		
		Properties Properties=new Properties();
		File file2=new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\tutorialsninja\\qa\\config\\fixeddata.properties");
		try {
			FileInputStream fileInputStream=new FileInputStream(file2);
			Properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentReports.setSystemInfo("Application url ", Properties.getProperty("url"));
		extentReports.setSystemInfo("Browser name ", Properties.getProperty("browser"));
		extentReports.setSystemInfo("Email used ", Properties.getProperty("emailID"));
		extentReports.setSystemInfo("Password used ", Properties.getProperty("password"));
		
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("Operating System version", System.getProperty("os.version"));
		extentReports.setSystemInfo("Author", System.getProperty("user.name"));
		
		return extentReports;
	}
}



//FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\tutorialsninja\\qa\\config\\fixeddata.properties"));
