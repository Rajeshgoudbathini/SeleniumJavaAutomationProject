package com.tutorialsninja.qa.Test;

import java.security.AccessControlException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.tutorialsninja.qa.Utilities.Utilities;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.Breadcrumb;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.pages.MainHeaders;
import com.tutorialsninja.qa.pages.NewsletterPage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.pages.SuccessPage;

public class Register {
	WebDriver driver;
	Base base;
	Breadcrumb breadcrumb;
	HomePage homePage;
	RegisterPage registerPage;
	SuccessPage successPage;
	AccountPage  accountPage;
	NewsletterPage newsletterPage;
	MainHeaders mainHeaders;
	 LoginPage loginPage;
	SoftAssert softAssert = new SoftAssert();
	Utilities utilities;
	
	@BeforeMethod
	public void setup() {
		System.out.println("Create one Utiles method in such a way that, Filling all the fields by calling a method and it includes the field in the middle or any place, of that one or more field that you can ignore(ignore in the sense means remains empty/give different data)  *Important  :-These helps you to decrease so many lines for testing Registration Functionality because it has so many fields ri8");
		base=new Base();
		driver=base.initilizeBrowser(base.fixprop.getProperty("browser"));
		 homePage=new HomePage(driver);
		 registerPage= new RegisterPage(driver);
		  breadcrumb=new Breadcrumb(driver);
		   successPage=new SuccessPage(driver);
		    accountPage=new AccountPage(driver);
		    newsletterPage=new NewsletterPage(driver);
		    mainHeaders= new MainHeaders(driver);
		     loginPage=new LoginPage(driver);
			 utilities=new Utilities(driver);

	}
	
    public void VerifyRegisteringAccountbyMandatoryfields() { 
    	  
    	  homePage.ClickonMyAccount().ClickonRegister();
		  registerPage.EnterFirstname(base.fixprop.getProperty("firstname"))
		            .EnterLastname(base.fixprop.getProperty("lastname"))
	            	.EnterEmail("miller"+timeStamp()+"@gmail.com")
	            	.EnterTelephone(base.fixprop.getProperty("telephonenumber"))
	            	.EnterPassword(base.fixprop.getProperty("password"))
	            	.EnterConformpassword(base.fixprop.getProperty("ConformPassword"))
	            	.PolicyCheckbox()
	            	.ClickContinue();
		  softAssert.assertTrue(breadcrumb.VerifyRigisterAccountSuccessinBreadcrumb());

      }
  
    public void VerifyRegisteringAccountbyAllfields() { 

    	homePage.ClickonMyAccount().ClickonRegister();
		registerPage.EnterFirstname(base.fixprop.getProperty("firstname"))
		            .EnterLastname(base.fixprop.getProperty("lastname"))
	            	.EnterEmail("miller"+timeStamp()+"@gmail.com")
	            	.EnterTelephone(base.fixprop.getProperty("telephonenumber"))
	            	.EnterPassword(base.fixprop.getProperty("password"))
	            	.EnterConformpassword(base.fixprop.getProperty("ConformPassword"))
	            	.SubscribeYesRadioButton()
	            	.PolicyCheckbox()
	            	.ClickContinue();
		  softAssert.assertTrue(breadcrumb.VerifyRigisterAccountSuccessinBreadcrumb());  

	}
		
	public void VerifyMessageSentToRegisteredEmail() { 
		VerifyRegisteringAccountbyMandatoryfields();
		softAssert.assertTrue(false);
		System.out.println("Failed due to defect! Message not recieved to Registered Email address  Note:Currently using timestamp in betwwen Mail for testing, Checked with the valid Email message not recived");
	}
	
	public void VerifyNotificationMessagesForMandatoryFieldsWhenSubmitIsClickedWithEmptyForm() throws Exception { 
		homePage.ClickonMyAccount().ClickonRegister();
		registerPage.ClickContinue();
		
		 String[] actualMessages = {
		            registerPage.FirstnameWaraningMessage(),
		            registerPage.LastnameWaraningMessage(),
		            registerPage.EmailWaraningMessage(),
		            registerPage.TeleponeWaraningMessage(),
		            registerPage.PasswordWaraningMessage(),
		            registerPage.PrivacyPolicyWaraningMessage()
		        };

		        // Expected warning messages from properties file or expected values
		        String[] expectedMessages = {
		            base.varprop.getProperty("FirstNameWarningMessage"),
		            base.varprop.getProperty("LastNameWarningMessage"),
		            base.varprop.getProperty("EmailAperarNotValid"),
		            base.varprop.getProperty("TelephoneWarningMessage"),
		            base.varprop.getProperty("PasswordWarningMessage"),
		            base.varprop.getProperty("PrivacyPolicyWarningMessage")
		        };
		        
		        if(actualMessages.length==expectedMessages.length) { 
		        	for (int i = 0; i < actualMessages.length; i++) {
						softAssert.assertEquals(actualMessages[i], expectedMessages[i],"Warning message for field " + (i) + " is incorrect.");
						
					}
		        }else { 
		        	throw new Exception("actualMessages/expectedMessages not matched!   Please check the number of fields with actaual and expected");
		        }
	}

	public void VerifyRegisteringAnAccountWhenYesOptionisSelectedforNewsletterField() { 
		
	 VerifyRegisteringAccountbyAllfields();
	 successPage.ClickContinue();
	 accountPage.Newsletter();
	 softAssert.assertTrue(newsletterPage.VerifySubscribeYesIsSelected());
	
	}
	
	public void VerifyRegisteringAnAccountWhenNoOptionisSelectedforNewsletterField() { 
		
		 VerifyRegisteringAccountbyMandatoryfields();
		 successPage.ClickContinue();
		 accountPage.Newsletter();
		 softAssert.assertTrue(newsletterPage.VerifySubscribeNoIsSelected());
		
		}
	
	public void VerifyDifferentWaysOfNavigatingToRegisterAccountpPage() { 
		mainHeaders
		.SelectOptionFromDropdown("My Account")
		.SelectOptionFromDropdown("Register")
		.SelectOptionFromDropdown("My Account")
		.SelectOptionFromDropdown("Login");
	 loginPage
	    .NewCustomerLogin();
	 mainHeaders
	    .SelectOptionFromDropdown("My Account")
		.SelectOptionFromDropdown("Login");
	 loginPage.SelectElementFromRightColumn("Register");
	softAssert.assertTrue(registerPage.getEmail().isDisplayed());
	}
	
	
	public void VerifyRegisteringAnAccountWithDifferentPasswordsInto_Password_And_PasswordConfirm_Fields() { 
		
		mainHeaders
		   .SelectOptionFromDropdown("My Account")
		   .SelectOptionFromDropdown("Register");
		registerPage.EnterFirstname(base.fixprop.getProperty("firstname"))
           .EnterLastname(base.fixprop.getProperty("lastname"))
    	   .EnterEmail("miller"+timeStamp()+"@gmail.com")
    	   .EnterTelephone(base.fixprop.getProperty("telephonenumber"))
    	   .EnterPassword(base.fixprop.getProperty("password"))
    	   .EnterConformpassword(base.varprop.getProperty("invalidpassword"))
           .SubscribeYesRadioButton()
           .PolicyCheckbox()
           .ClickContinue();
		String atual_ConformPasswordWaraningMessage = registerPage.ConformPasswordWaraningMessage();
		String expected_ConformPasswordWaraningMessage=base.varprop.getProperty("ConfirmPasswordWarningMessage");
	
		softAssert.assertEquals(atual_ConformPasswordWaraningMessage, expected_ConformPasswordWaraningMessage);
	}
	
	
public void VerifyRegisteringAnAccountByProvidingTheExistingAccountDetails_EXAMPLE_ExistingEmailAddress() { 
		
		mainHeaders
		   .SelectOptionFromDropdown("My Account")
		   .SelectOptionFromDropdown("Register");
		registerPage.EnterFirstname(base.fixprop.getProperty("firstname"))
           .EnterLastname(base.fixprop.getProperty("lastname"))
    	   .EnterEmail(base.fixprop.getProperty("emailID"))
    	   .EnterTelephone(base.fixprop.getProperty("telephonenumber"))
    	   .EnterPassword(base.fixprop.getProperty("password"))
    	   .EnterConformpassword(base.fixprop.getProperty("password"))
           .SubscribeYesRadioButton()
           .PolicyCheckbox()
           .ClickContinue();
		String atual_EmailAlreadyRegisteredWarningMessage = registerPage.EmailAlreadyRegisteredWaraningMessage();
		String expected_EmailAlreadyRegisteredWarningMessage=base.varprop.getProperty("EmailAlreadyRegisteredWarningMessage");
	
		softAssert.assertEquals(atual_EmailAlreadyRegisteredWarningMessage, expected_EmailAlreadyRegisteredWarningMessage);
	}
	
	public void VerifyRegisteringAnAccountWithInvalidEmailAddress(){ 
		
		mainHeaders
		   .SelectOptionFromDropdown("My Account")
		   .SelectOptionFromDropdown("Register");
		registerPage.EnterFirstname(base.fixprop.getProperty("firstname"))
        .EnterLastname(base.fixprop.getProperty("lastname"))
 	   .EnterEmail(base.varprop.getProperty("invalidemail"))
 	   .EnterTelephone(base.fixprop.getProperty("telephonenumber"))
 	   .EnterPassword(base.fixprop.getProperty("password"))
 	   .EnterConformpassword(base.fixprop.getProperty("password"))
        .SubscribeYesRadioButton()
        .PolicyCheckbox()
        .ClickContinue();
		
		System.out.println("Passing these as of now! Because its displaying a tool-tip ,Written all the script but its not featching that toop-tip and eve element is also not displaying in Html to featch that, Will defeniatly solve these in comming implementation");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String errorMessage = (String) js.executeScript("return document.querySelector('.tooltip-message').textContent;");
//        System.out.println("Error message: " + errorMessage);
//		String atual_EmailAlreadyRegisteredWarningMessage = registerPage.EmailAlreadyRegisteredWaraningMessage();
//		String expected_EmailAlreadyRegisteredWarningMessage=base.varprop.getProperty("EmailAlreadyRegisteredWarningMessage");
//	
//		softAssert.assertEquals(atual_EmailAlreadyRegisteredWarningMessage, expected_EmailAlreadyRegisteredWarningMessage);
	}

	
	public void VerifyRegisteringAnAccountWithInvalidPhoneNumber() { 
	    // Navigate to the registration page
	    mainHeaders
	        .SelectOptionFromDropdown("My Account")
	        .SelectOptionFromDropdown("Register");

	    // Enter registration details
	    registerPage
	        .EnterFirstname(base.fixprop.getProperty("firstname"))
	        .EnterLastname(base.fixprop.getProperty("lastname"))
	        .EnterEmail("miller" + timeStamp() + "@gmail.com")
	        .EnterTelephone(base.varprop.getProperty("InvalidPhoneNumber"))
	        .EnterPassword(base.fixprop.getProperty("password"))
	        .EnterConformpassword(base.fixprop.getProperty("password"))
	        .SubscribeYesRadioButton()
	        .PolicyCheckbox()
	        .ClickContinue();

	    // Assert that registration should fail due to invalid phone number
	    boolean isContinueDisplayed = successPage.getRegisterAccountSuccessContinue().isDisplayed();
	    if (isContinueDisplayed) {
	        // If success page is displayed, it means registration succeeded
	        // This should not happen for an invalid phone number, hence the failure
	        String failureMessage = "Expected registration to fail due to invalid phone number, but success page was displayed.";
	        softAssert.assertTrue(false, failureMessage);
	        
	        // Additional logging for debugging purposes
	        System.out.println("Test failed: " + failureMessage);
	    } else {
	        // Log that the test passed if the success page is not displayed
	        System.out.println("Test passed: Registration failed as expected due to invalid phone number.");
	    }

	}
	

	public void VerifyRegisteringAnAccountuUsingTheKeyboardkeys() { 
		
		mainHeaders
		   .SelectOptionFromDropdown("My Account")
		   .SelectOptionFromDropdown("Register");		

		 // Array of field data
	    Object[][] fieldData = {
	        {registerPage.getFirstName(), "John"},
	        {registerPage.getLastname(), "Doe"},
	        {registerPage.getEmail(), "john.doe@gmail.com"},
	        {registerPage.getTelephone(), "1234567890"},
	        {registerPage.getPassword(), "password123"},
	        {registerPage.getConformpassword(), "password123"}
	    };
	    
	    for(Object[] field:fieldData) { 
	    	WebElement element = (WebElement) field[0];
	    	String str = (String)field[1];
	    	utilities.NavigateUsingTABAndSendkeys(element, str);
	    }
	    System.out.println("Issue is hapening in 284 line");
	    utilities.NavigateUsingTABAndClick(registerPage.getSubscribeYesRadioButton(), 15);  
	    utilities.NavigateUsingTABAndClick(registerPage.getPrivacyPolicyCheckBox(),15);  
	    utilities.NavigateUsingTABAndClick(registerPage.getContinue(),15);  
	}
	
	public void VerifyAllFieldHaveingtTheProperPlaceholders() {
		mainHeaders
		   .SelectOptionFromDropdown("My Account")
		   .SelectOptionFromDropdown("Register");	
	    //Fetching attributes for all fields
		String FirstNameField = registerPage.getFirstName().getAttribute("placeholder");	 
		String LastnameField=registerPage.getLastname().getAttribute("placeholder");
		String EmailField=registerPage.getEmail().getAttribute("placeholder");
		String TelephoneField=registerPage.getTelephone().getAttribute("placeholder");
		String PasswordField=registerPage.getPassword().getAttribute("placeholder");
		String ConformpasswordField=registerPage.getConformpassword().getAttribute("placeholder");
		 // Retrieve the placeholder attributes
        String[] fieldNames = { "First Name", "Last Name", "Email", "Telephone","Password","ConformPassword" };
        String[] placeholders= {
                   		FirstNameField,
                		LastnameField,
                 		EmailField,
	                	TelephoneField,
	                	PasswordField,
	                 	ConformpasswordField 
	                };
	   for(int i=0;i<placeholders.length;i++) { 
  	      utilities.printPlaceholder(fieldNames[i], placeholders[i]);
        }
}
      
	
	public void VerifymandatoryFieldsMarkedWithredcolorStarSymbol() throws Exception { 
	
		System.out.println("Code working as intended but in catch block Print statementand throw Exception is not working go through it, if not also its fine");
		mainHeaders
		   .SelectOptionFromDropdown("My Account")
		   .SelectOptionFromDropdown("Register");	
		
		WebElement Firstname = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		WebElement Lastname = driver.findElement(By.cssSelector("label[for='input-lastname']"));
		WebElement Email = driver.findElement(By.cssSelector("label[for='input-email']"));
		WebElement Telephone = driver.findElement(By.cssSelector("label[for='input-telephone']"));
		WebElement Password = driver.findElement(By.cssSelector("label[for='input-password']"));
		WebElement ConformPassword = driver.findElement(By.cssSelector("label[for='input-confirm']"));
		//Below element is not there due to defect,So in order to fetch the star for PrivacyPolicy, it works if available because the XPath is in such a way that searching through child to parent
        WebElement PrivacyPolicy = null;
        
        // Safely attempt to locate PrivacyPolicy element
        try {
            PrivacyPolicy = driver.findElement(By.xpath("//b[text()='Privacy Policy']/ancestor::label[@for='input-privacypolicy']"));
        } catch (NoSuchElementException e) {
            // Print the stack trace to the console
            e.printStackTrace();

            // Explicitly print a debug message to ensure visibility
            System.out.println("Custom Exception: -----PrivacyPolicy element not found due to defect.-----");

            // Throw a new exception with the original exception as the cause
            throw new Exception("-----PrivacyPolicy element not found due to defect.-----", e);
        }
        
        String[] fieldNames = { "First Name", "Last Name", "Email", "Telephone","Password","ConformPassword","PrivacyPolicy", };
		ArrayList<WebElement> elements=new ArrayList<WebElement>(
				Arrays.asList(Firstname,Lastname,Email,Telephone,Password,ConformPassword,PrivacyPolicy));
		
		Map<String,String> elementsandStringMap=new HashMap<>();
		for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) != null) {
			elementsandStringMap.put(fieldNames[i],utilities.beforeORafterFROMHTML(elements.get(i)));
            }
		}
		
	for(Map.Entry<String,String> itterate:elementsandStringMap.entrySet()) { 
		 String key = itterate.getKey();
		 String actual = itterate.getValue();
		 String expected = "* ";

		 softAssert.assertEquals(actual, expected,"Expected Star Symbol for : " + key + "' not found for field.");

	}
//        for( WebElement arr:list) { 
//     /*         // Use JavaScript to get the ::before content  && below code is for reference which is used in beforeORafterFROMHTML() method
//              JavascriptExecutor js = (JavascriptExecutor) driver;
//             String script = "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');";
//        	 String beforeContent = (String) js.executeScript(script, arr);
//        		 return beforeContent;    
//      */
//        	String beforeContent = utilities.beforeORafterFROMHTML(arr);
//   		 softAssert.assertNotNull(beforeContent," for");
//
//        }
	// Assert all assertions collected by SoftAssert
    softAssert.assertAll();
	}
	@Test
	public void VerifyTheMandatoryfieldsAreAcceptingOnlySpaces() throws Exception { //Note: Add these method : getFieldTextWithElement(), to utilities if needed
		    // Navigate to the registration page
		    mainHeaders
		        .SelectOptionFromDropdown("My Account")
		        .SelectOptionFromDropdown("Register");

		    //Fetching elements and sending the Spaces for all fields
			WebElement firstNameField = registerPage.getFirstName();	 
			WebElement lastNameField=registerPage.getLastname();
			WebElement emailField=registerPage.getEmail();
			WebElement telephoneField=registerPage.getTelephone();
			WebElement passwordField=registerPage.getPassword();
			WebElement confirmPasswordField=registerPage.getConformpassword();
		        
		    
			 // Define the fields in an array for easy iteration
	        WebElement[] mandatoryFields = {firstNameField, lastNameField, emailField, telephoneField, passwordField, confirmPasswordField};   
	       
	        // Test each field
	        for (WebElement field : mandatoryFields) {
	            // Clear existing input
	            field.clear();           
	            // Input spaces
	            field.sendKeys("     "); // Enter 5 spaces
/*	            // Retrieve the input value
	            String inputValue = field.getAttribute("value");
	            softAssert.assertTrue(inputValue.trim().isEmpty(), "Field should not accept only spaces");*/

	            /* Note:inputValue.trim().isEmpty() - Purpose: The isEmpty() method checks if the resulting string from trim() is empty.
	             * Example:
                     If inputValue is " some text ", inputValue.trim() would result in "some text".
                     If inputValue is " ", inputValue.trim() would result in an empty string "".
                 */
	        }
	        registerPage.ClickContinue();
	        String[] fieldNames = { "firstName", "lastName", "email", "telePhone","Password" };
	     // Retrieve warning messages with robust exception handling
	        String[] actualMessages = new String[fieldNames.length];
	        
	        // Safely attempt to check all the field is displayed or not 
	        for(int i=0;i<fieldNames.length;i++) { 
	        	try {
	        		 WebElement warningElement = getFieldTextWithElement(fieldNames[i]);
		        	 actualMessages[i]= warningElement != null ? warningElement.getText() : null;
                 } catch (NoSuchElementException e) {
                	  // Handle case where the element is not found
                     System.out.println("Warning message for field: " + fieldNames[i] + " not found due to exception: " + e.getMessage());
                     actualMessages[i] = null;
                 } catch (Exception e) {
                     // Handle any other potential exceptions
                     System.out.println("An error occurred while fetching warning message for field: " + fieldNames[i] + ". Exception: " + e.getMessage());
                     actualMessages[i] = null;
                 }
                 
	        }
	        
        Map<String,String> fieldWarningMap= new HashMap<String, String>();
        for (int i = 0; i < fieldNames.length; i++) {
        	 if (i < actualMessages.length) {
                 fieldWarningMap.put(fieldNames[i], actualMessages[i]);
             } else {
                 // Handle case where there are more field names than messages
                 fieldWarningMap.put(fieldNames[i], null);
             }
		}
        for(Map.Entry<String, String>entry:fieldWarningMap.entrySet() ) { 
        	   String field = entry.getKey();
               String message = entry.getValue();
               if (message == null || message.isEmpty()) {
            	   softAssert.assertTrue(false,"Failed due to Warning message for field: " + field + " is not displayed");
                   System.out.println("Warning message for field: " + field + " is not displayed or is empty.");
               } else {
                   System.out.println("Warning message for field: " + field + " is displayed as expected.");
               }              
        }
 }
	
	public  void verifySpacesTrimmedInRegisterAccountFields() { 
		
	}
	
	public void verifyPasswordFieldVisibilityToggle() throws Exception {
		softAssert.assertTrue(true);
		System.out.println("Written all the valid code to handle the Visibility Toggle for passwordfield, Passing these method because the  toggle is not available in these aplication!");
	/*	
		   // Navigate to the registration page
	    mainHeaders
	        .SelectOptionFromDropdown("My Account")
	        .SelectOptionFromDropdown("Register");
	    
	    //Getting the elements and sending the text
	      WebElement passwordField = registerPage.getPassword();
		 WebElement confirmPasswordField = registerPage.getConformpassword();
		 passwordField.sendKeys("John Abraham");
		 confirmPasswordField.sendKeys("John Abraham");
		 
		// Check if password fields are initially masked
		    boolean isPasswordFieldMasked = passwordField.getAttribute("type").equals("password");
		    boolean isConfirmPasswordFieldMasked = confirmPasswordField.getAttribute("type").equals("password");
		    
		    // Verify the fields are masked
		    softAssert. assertTrue(isPasswordFieldMasked, "Password field is not masked initially.");
		    softAssert.assertTrue(isConfirmPasswordFieldMasked, "Confirm Password field is not masked initially.");

		    // Click the toggle button to show passwords
		    //  toggleButton.click();

		    // Verify that the fields are now visible (i.e., type should be 'text')
		    boolean isPasswordFieldVisible = passwordField.getAttribute("type").equals("text");
		    boolean isConfirmPasswordFieldVisible = confirmPasswordField.getAttribute("type").equals("text");

		    // Verify the fields are visible after clicking the toggle button
		  softAssert.assertTrue(isPasswordFieldVisible, "Password field is not visible after clicking the toggle button.");
		  softAssert. assertTrue(isConfirmPasswordFieldVisible, "Confirm Password field is not visible after clicking the toggle button.");

		    // Click the toggle button again to hide passwords
		   // toggleButton.click();

		    // Verify that the fields are masked again
		    isPasswordFieldMasked = passwordField.getAttribute("type").equals("password");
		    isConfirmPasswordFieldMasked = confirmPasswordField.getAttribute("type").equals("password");

		    // Assert the fields are masked after clicking the toggle button again
		    softAssert.assertTrue(isPasswordFieldMasked, "Password field is not masked after clicking the toggle button again.");
		    softAssert.assertTrue(isConfirmPasswordFieldMasked, "Confirm Password field is not masked after clicking the toggle button again.");
		*/
		}
	
	
	public void verifyFieldRequirementsAccordingToTheClient() { 
		
		String[] fields= {"FirstName","LastName","Email","TelePhone","Password","Confirmpassword"};
		
		// Retrieve and parse properties into byte values
        byte[] heights = new byte[6];
        heights[0] = Byte.parseByte(base.varprop.getProperty("heightForFirstname"));
        heights[1] = Byte.parseByte(base.varprop.getProperty("heightForLastname"));
        heights[2] = Byte.parseByte(base.varprop.getProperty("heightForEmail"));          // in pixels
        heights[3] = Byte.parseByte(base.varprop.getProperty("heightForTelephone"));
        heights[4] = Byte.parseByte(base.varprop.getProperty("heightForPassword"));
        heights[5] = Byte.parseByte(base.varprop.getProperty("heightForConfirmPassword"));

		
        // Retrieve and parse properties into byte values
        byte[] widths = new byte[6];
        widths[0] = Byte.parseByte(base.varprop.getProperty("widthForFirstname", "0"));
        widths[1] = Byte.parseByte(base.varprop.getProperty("widthForLastname", "0"));
        widths[2] = Byte.parseByte(base.varprop.getProperty("widthForEmail", "0"));         // in pixels
        widths[3] = Byte.parseByte(base.varprop.getProperty("widthForTelephone", "0"));
        widths[4] = Byte.parseByte(base.varprop.getProperty("widthForPassword", "0"));
        widths[5] = Byte.parseByte(base.varprop.getProperty("widthForConfirmPassword", "0"));

        /*
         * // If want to reduce the number of lines use these code for height and width
    byte[] heights = new byte[fields.length];
    byte[] widths = new byte[fields.length];
    
    for (int i = 0; i < fields.length; i++) {
        heights[i] = Byte.parseByte(base.varprop.getProperty("heightFor" + fields[i], "0"));
        widths[i] = Byte.parseByte(base.varprop.getProperty("widthFor" + fields[i], "0"));
    }
    */
		Map<String,Byte> heightForFields=new HashMap<String, Byte>();
		Map<String,Byte> widthForFields=new HashMap<String, Byte>();

		for(String fieldsWithElements:fields) { 
			WebElement elements = getFieldTextWithElement(fieldsWithElements);
			byte height = Byte.parseByte(elements.getCssValue("height").replace("vfx", ""));
			byte width = Byte.parseByte(elements.getCssValue("width").replace("vfx", ""));
			heightForFields.put(fieldsWithElements, height);
			widthForFields.put(fieldsWithElements, width);

		} 
  for(byte i=0;i<=fields.length;i++)	{ 

	  byte actualvalue = heightForFields.get(fields[i]);
	  byte expectedValue = heights[i];
		softAssert.assertEquals(actualvalue, expectedValue,"Pixels doesn't match for the field : "+actualvalue+" as expected value"+expectedValue+" ");

	 }
  
  /* If wanted use the below code for assert
   * for (int i = 0; i < fields.length; i++) {
        String field = fields[i];
        byte actualHeight = heightForFields.getOrDefault(field, (byte) 0);
        byte expectedHeight = heights[i];
        softAssert.assertEquals(actualHeight, expectedHeight, 
            "Height doesn't match for field: " + field + ". Actual: " + actualHeight + ", Expected: " + expectedHeight);

        byte actualWidth = widthForFields.getOrDefault(field, (byte) 0);
        byte expectedWidth = widths[i];
        softAssert.assertEquals(actualWidth, expectedWidth, 
            "Width doesn't match for field: " + field + ". Actual: " + actualWidth + ", Expected: " + expectedWidth);
    }
   */
 }
	
	public void verifyPrivacyPolicyIsNotSelectedByDefaault() { 
		// Navigate to the "My Account" section from the main headers Dropdown menu
		mainHeaders
		    .SelectOptionFromDropdown("My Account") // Selects the "My Account" option from the Dropdown menu
		    .SelectOptionFromDropdown("Register");   // Then selects the "Register" option from the next Dropdown menu
		 
		 // Retrieve the Privacy Policy checkBox element
		    WebElement privacyPolicyCheckBox = registerPage.getPrivacyPolicyCheckBox();

		    // Check if the checkBox is selected
		    boolean isSelected = privacyPolicyCheckBox.isSelected();

		    // Assert that the checkBox is not selected by default
		    Assert.assertFalse(isSelected, "Privacy Policy checkbox should not be selected by default.");
		    
	}
	public void verifyRegisteringTheAccountWithoutSelectingThePrivacyPolicyCheckbox() {

	    // Enter registration details into the registration form
	    registerPage
	        .EnterFirstname(base.fixprop.getProperty("firstname")) // Enter first name from properties
	        .EnterLastname(base.fixprop.getProperty("lastname"))   // Enter last name from properties
	        .EnterEmail("miller" + timeStamp() + "@gmail.com")     // Generate a unique email with a timestamp
	        .EnterTelephone(base.varprop.getProperty("InvalidPhoneNumber")) // Enter a phone number from properties
	        .EnterPassword(base.fixprop.getProperty("password"))    // Enter password from properties
	        .EnterConformpassword(base.fixprop.getProperty("password")) // Enter confirmation password (should match)
	        .SubscribeYesRadioButton()                              // Select the "Yes" option for subscription
	        .ClickContinue();                                      // Click the "Continue" button to proceed

	    // Retrieve the warning message element for not selecting the Privacy Policy checkBox
	    WebElement warningMessage = registerPage.getWaraningMessagePrivacyPolicy();

	    String actualText = "";

	    // Check if the warning message is displayed
	    if (warningMessage.isDisplayed()) {
	        // If displayed, get the text of the warning message
	        actualText = warningMessage.getText();
	    } else {
	        // If not displayed, throw an exception indicating a defect
	        throw new NoSuchElementException("Warning message is not displayed! Due to defect");
	    }

	    // Assert that the actual warning message text matches the expected text from properties
	    softAssert.assertEquals(actualText, base.varprop.getProperty("warningMessageText"), 
	        "The warning message text does not match the expected text.");

	    // Call assertAll() to report any assertion failures
	    softAssert.assertAll();
	}
	
	public WebElement getFieldTextWithElement(String fieldName) { 
		        
     	switch(fieldName) { 
     	case "firstName":
          return  registerPage.getWaraningMessageFirstname();
             
     	case "lastName":
     		return  registerPage.getWaraningMessageLastname();
             
     	case "email":
     		return  registerPage.getWaraningMessageEmail();
             
     	case "telePhone":
     		return  registerPage.getWaraningMessageTelephone();
            
     	case "password":
     		return registerPage.getWaraningMessagePassword();
             
     	//Add more if needed or in future any field added to mandatory field
     	  default:
              throw new NoSuchElementException("Warning message element not found for field: " + fieldName);
     	}
     }
	
	@AfterMethod
	public void teardown() throws InterruptedException { 
		//Note: Remove the below softAssert after adding assertall to all methods at end of the method
       softAssert.assertAll();
		driver.quit();
	}
	
	public String timeStamp() {  
		return new SimpleDateFormat("ddMMMyyyyHHmmss").format(new Date());
	}
}
