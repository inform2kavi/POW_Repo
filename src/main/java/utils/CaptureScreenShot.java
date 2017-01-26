package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShot {	
	
	public static void CaptureScreen(WebDriver driver) throws IOException
	{
		String systemtime = LocalDateTime.now().toString();
		String pathname = "./Screenshots/"+systemtime+".jpg";
		 TakesScreenshot screenshot=(TakesScreenshot) driver;
		  File file = screenshot.getScreenshotAs(OutputType.FILE);
		  //String systemtime = LocalDateTime.now().toString();
		  FileUtils.copyFile(file, new File(pathname));
	}
	
	public static void CaptureScreen(WebDriver driver, String filename) throws IOException
	{
		String systemtime = LocalDateTime.now().toString();
		String pathname = "./Screenshots/"+filename+"_"+systemtime+".jpg";
		 TakesScreenshot screenshot=(TakesScreenshot) driver;
		  File file = screenshot.getScreenshotAs(OutputType.FILE);
		  
		  FileUtils.copyFile(file, new File(pathname));
	}
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
