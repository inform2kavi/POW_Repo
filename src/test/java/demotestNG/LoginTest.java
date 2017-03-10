package demotestNG;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utils.DataProviderClass;


public class LoginTest extends BaseClass {
	
	
	
  @Test(dataProviderClass = DataProviderClass.class, dataProvider = "Logininputs")
  public void VerifyAllLogin(String role, String uname, String pwd, String msg) throws IOException {
	 
	  LoginPageObject LoginObj = new LoginPageObject(driver);
	  
	    //Initiating logger object
	    logger = report.startTest("Verify user login page");
	 
		 
		 //Getting the homepage from the property file
		 String url = ReadProp.ReturnPropertyValue("homepage");
		 logger.log(LogStatus.INFO, "Loading homepage"+url);
		 driver.get(url);
		 
		 //Selecting the URL based on the role
		 LoginObj.SelectURL(role);
		 //System.out.println("The current url is = "+driver.getCurrentUrl());
		 logger.log(LogStatus.INFO, "Loading the "+role+ " homepage");
		 
		 //Passing the username to the locator
		 logger.log(LogStatus.INFO, "Entering Username = "+uname);
		 LoginObj.EnterUserName(uname); 
		   
		 //Passing the password to the locator
		 logger.log(LogStatus.INFO, "Entering Password = "+pwd);
		 LoginObj.EnterPassword(pwd);
		   
		 //Clicking the Login Button
		 logger.log(LogStatus.INFO, "Clicking the login button");
		 LoginObj.ClickLoginButton();
		   
		 //Verifying the login credentials
		 logger.log(LogStatus.INFO, "Verifying the Login for "+role);
		 Assert.assertTrue(LoginObj.CheckAllLogin(msg));
	
	  
  }
  
 
  

  
 
}
