package demotestNG;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.CaptureScreenShot;
import utils.DriverClass;
import utils.ReadProperties;

public class BaseClass {
	
	//Declaring global variables
	WebDriver driver=null;
	ExtentReports report = null;
	ExtentTest logger = null;
	ReadProperties ReadProp;
	
	//General before class method 
	@BeforeClass
	public void BaseClass_BeforeClass() throws IOException
	{
		
		//Instantiating object for reading property file
		ReadProp = new ReadProperties();
		
		//Setting system property for chrome driver
		DriverClass DriverClassObj = new DriverClass();
		driver = DriverClassObj.InitDriver(driver, ReadProp.ReturnPropertyValue("chromedriver", 0), ReadProp.ReturnPropertyValue("chromedriver", 1));
			
		//Instantiating Reports object with the class namein the path
		report = new ExtentReports("./Reports/"+this.getClass().getSimpleName()+".html");	
		
		
	}	
	
	
	@AfterMethod
	public void BaseClass_AfterMethod(ITestResult result) throws IOException
	{
		//Pass test actions
		if(result.isSuccess())
		{
			logger.log(LogStatus.PASS, result.getName()+" passed");
		}
		
		//Fail test actions
		else
		{
			
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			result.getThrowable().printStackTrace(pw);
			logger.log(LogStatus.FAIL, result.getName()+"Failed"+sw.toString());	
			String pathname = CaptureScreenShot.returnCaptureScreen(driver, result.getTestName());					
			logger.log(LogStatus.INFO,"please find attached screenshot"+logger.addScreenCapture(pathname));
			
		}
		report.endTest(logger);
		report.flush();
		
	}

	@AfterClass
	public void BaseClass_AfterClass()
	{
		driver.close();
	}
}