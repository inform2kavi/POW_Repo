package demotestNG;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.CaptureScreenShot;
import utils.ReadProperties;

public class BaseClass {
	
	WebDriver driver;
	ExtentReports report = null;
	ExtentTest logger = null;
	ReadProperties ReadProp;
	
	
	public void BaseClass_BeforeClass(String ClassName) throws IOException
	{
		ReadProp = new ReadProperties();
		System.setProperty(ReadProp.ReturnPropertyValue("chromedriver", 0),ReadProp.ReturnPropertyValue("chromedriver", 1));	
		driver = new ChromeDriver();		
		report = new ExtentReports("./Reports/"+ClassName+".html");	
		ExtentTest logger = null;
		
	}	
	
	public void BaseClass_BeforeMethod()
	{
		
	}
	
	public void BaseClass_AfterMethod(ITestResult result) throws IOException
	{
		if(result.isSuccess())
		{
			logger.log(LogStatus.PASS, result.getName()+" passed");
		}
		
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
	
	public void BaseClass_AfterClass()
	{
		driver.close();
	}
}