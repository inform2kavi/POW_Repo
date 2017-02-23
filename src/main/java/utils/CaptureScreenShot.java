package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShot {	
	
	//Method to Capture Screenshot at the default Screenshot folder present in the Present Working directory
	public static void CaptureScreen(WebDriver driver) throws IOException
	{
		//To get the systemtime
		String systemtime = LocalDateTime.now().toString();
		
		//Creating the the pathname for the screenshot uniquely by generating the system time
		String pathname = "./Screenshots/"+systemtime+".jpg";
		
		//TypeCasting the driver to screenshot
		 TakesScreenshot screenshot=(TakesScreenshot) driver;
		 
		 //Saving the screenshot to a file
		  File file = screenshot.getScreenshotAs(OutputType.FILE);
		  
		  //Copying the file to the specified path using copyfile method of FileUtils
		  FileUtils.copyFile(file, new File(pathname));
	}
	
	//To save the screenshot in the path with calling test name in it.
	public static void CaptureScreen(WebDriver driver, String filename) throws IOException
	{
		String systemtime = LocalDateTime.now().toString();
		//Creating the pathname with calling test name and system time
		String pathname = "./Screenshots/"+filename+"_"+systemtime+".jpg";
		
		 TakesScreenshot screenshot=(TakesScreenshot) driver;
		  File file = screenshot.getScreenshotAs(OutputType.FILE);
		  
		  FileUtils.copyFile(file, new File(pathname));
	}
	
	//Save the screenshot with the testname and return the path, to attach with the logger file
	public static String returnCaptureScreen(WebDriver driver, String filename) throws IOException
	{
		String systemtime = LocalDateTime.now().toString();
		String pathname = "Screenshots/"+filename+"_"+systemtime+".jpg";
		 TakesScreenshot screenshot=(TakesScreenshot) driver;
		  File file = screenshot.getScreenshotAs(OutputType.FILE);
		  
		  String absPath = "/Users/sankavi/Documents/workspace/firstProject/"+pathname;
		  FileUtils.copyFile(file, new File(absPath));
		  return absPath;
	}
	

}
