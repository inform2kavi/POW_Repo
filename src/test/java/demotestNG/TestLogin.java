package demotestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import utils.DataProviderClass;

public class TestLogin {
	WebDriver driver;
	
 @BeforeClass
 public void BeforeClassMethod()
	{
	System.setProperty("webdriver.chrome.driver","/Users/sankavi/bdriver/chromedriver");
	driver = new ChromeDriver();
	
	
}
  //@Test(dataProviderClass = DataProviderClass.class, dataProvider ="Logininputs")
  public void Login(String tcnum, String role, String url,String uname, String password) {
	  driver.get(url);
	  LoginPageObject loginobj = new LoginPageObject(driver);
	  loginobj.EnterUserName(uname);
	  loginobj.EnterPassword(password);
	  loginobj.ClickLoginButton();
	  Assert.assertTrue(loginobj.CheckValidLogin(role));
	  
  }
  
  @Test(dataProviderClass = DataProviderClass.class, dataProvider ="Logininputs")
  public void VerifyAllLogin(String uname, String pwd)
  {
	  driver.get("http://104.238.103.200:8080/POWNew/startadmin.do");
	  LoginPageObject loginobj = new LoginPageObject(driver);
	  loginobj.EnterUserName(uname);
	  loginobj.EnterPassword(pwd);
	  loginobj.ClickLoginButton();
	  
  }
  
  @AfterMethod
  public void Aftermethod(ITestResult result)
  {
	  if(result.isSuccess())
	  {
		 System.out.println("Test Succeeded");
	  }
	  else
	  {
		  System.out.println("Test Failed");
	  }
  }
  
  
  @AfterClass
  public void AfterClassMethod()
  {
	  System.out.println("AFter class");
	  driver.close();
  }
}
