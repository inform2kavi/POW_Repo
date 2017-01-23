package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {
	
	private WebDriver driver;
	private By username =  By.id("email");
	private By password = By.id("passowrd");
	private By loginbutton = By.id("loginbutton");
	
	public LoginPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void EnterUserName(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}
	
	public void EnterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void ClickLoginButton()
	{
		driver.findElement(loginbutton).click();
	}
	
	
	public boolean CheckValidLogin(String role)
	{
		boolean flag = false;
		System.out.println("Role ="+role);
		System.out.println(driver.getTitle().toLowerCase());
		if(driver.getTitle().toLowerCase().contains("dashboard"))
		{
			if(driver.getTitle().toLowerCase().contains(role.toLowerCase()))
			flag = true;
		}
		return flag;
	}
	

}
