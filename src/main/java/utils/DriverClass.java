package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass {
	
	public WebDriver InitDriver(WebDriver driver,String WhatDriver, String WhichPath)
	{
		if(driver!=null)
		{
			//Returns the driver if the driver is already instantiated
			return driver;
		}
		
		else
		{
			//Instantiate and returns the driver
			System.setProperty(WhatDriver,WhichPath);
			driver = new ChromeDriver();
			return driver;
		}
	}
	

}
