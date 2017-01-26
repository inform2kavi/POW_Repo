package demotestNG;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class Admin_ItemManagement extends BaseClass {
	
	//Locator_Admin_ItemManagement ObjLocatorClass;
	
  @BeforeClass
  public void BeforeClass() throws IOException
  {
	  BaseClass_BeforeClass(this.getClass().getSimpleName());
  }
	
@Test
  public void Login() 
  {
      logger = report.startTest("Admin Item Management");	
 	  String hostname = ReadProp.ReturnPropertyValue("host")+ReadProp.ReturnPropertyValue("admin",0);
 	  logger.log(LogStatus.INFO, "Loading...."+hostname);
      driver.get(hostname);  
	  LoginPageObject LoginObj = new LoginPageObject(driver);
	  LoginObj.EnterUserName(ReadProp.ReturnPropertyValue("admin",1));
	  LoginObj.EnterPassword(ReadProp.ReturnPropertyValue("admin",1));
	  LoginObj.ClickLoginButton();
	  boolean flag = LoginObj.CheckValidLogin("admin");
	  if(flag)
	  {
		  logger.log(LogStatus.PASS, "Login Successfull");
	  }
	  else
	  {
		  logger.log(LogStatus.FAIL, "Login UnSuccessfull");
	  }
	  Assert.assertTrue(flag);
  }

@Test(groups ="smoke", dependsOnMethods = "Login")
public void CheckAllLinks()
{
	
}

@AfterMethod
	public void AfterMethod(ITestResult result) throws IOException
	{
	   
		BaseClass_AfterMethod(result);
	}
	
	
	@AfterClass
	public void AfterClass()
	{
		BaseClass_AfterClass();
	}
}
