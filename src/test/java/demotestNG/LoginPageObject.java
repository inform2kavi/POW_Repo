package demotestNG;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.omg.CORBA.SystemException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {
	
	private WebDriver driver;
	
	
	//Locating Username
	private By username =  By.id("email");
	
	//Locating Password
	private By password = By.id("password");
	
	//Locating login button
	private By loginbutton = By.id("loginbutton");
	
	//Locating admin
	private By admin = By.xpath("//a[contains(@class,'btn')][contains(@href,'admin')]");
	
	//Locating vendor
	private By vendor = By.xpath("//a[contains(@class,'btn')][contains(@href,'vendor')]");
	
	//Locating shop
    private By shop = By.xpath("//a[contains(@class,'btn')][contains(@href,'shop')]");
	
    //Locating  account
    private By account = By.xpath("//a[contains(@class,'btn')][contains(@href,'account')]");
	
	
	//Constructor
	public LoginPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Method Entering user name
	public void EnterUserName(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}
	
	//Method Entering password
	public void EnterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	//Method Clicking Login button
	public void ClickLoginButton()
	{
		driver.findElement(loginbutton).click();
	}
	
	//Method to clickAdmin
	public void ClickAdmin()
	{
		driver.findElement(admin).click();
	}
	
	//Method to clickvendor
	 public void ClickVendor()
	{
		 driver.findElement(vendor).click();
	}
	 
	//Method to clickshopt
	public void ClickShop()
	{
		driver.findElement(shop).click();
	}
		
	//Method to clickAdmin
	public void ClickAccount()
	{
		driver.findElement(account).click();
	}	
	
	//Method to verify valid login based on page source content and page title
	public boolean CheckValidLogin(String role)
	{
		boolean flag = false;
		
		//Validating the Login using Page title and Page source
		if(driver.getTitle().toLowerCase().contains("Dashboard".toLowerCase()))
		{
			if(driver.getPageSource().toLowerCase().contains(role.toLowerCase()))
			flag = true;
		}
		return flag;
	}
	
	//Method to verify valid login by checking the presence of particular message from excel in the page source
	public boolean CheckAllLogin(String Message) throws IOException
	{
		boolean flag = false;
		
		
		if(driver.getPageSource().toLowerCase().contains(Message))
		{
			
			flag = true && Pingcode();
			
		}
		
		else if(driver.findElement(By.id("divError")).getText().equals(Message))
		{
			
			flag = true && Pingcode();
		}
		
		return flag;
	}
	
	//Method to verify that the response code is 200
	public boolean Pingcode() throws IOException
	{
		boolean flag = false;
		String CurrentUrl = driver.getCurrentUrl();
		URL url = new URL(CurrentUrl);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.connect();
		
		if(connection.getResponseCode()==200)
		{
			flag=true;
		}
		return flag;
	}
	
	public void SelectURL(String role)
	{
		if(role.equals("admin"))
		{
			ClickAdmin();
		}
		
		if(role.equals("vendor"))
		{
			ClickVendor();
		}
		
		if(role.equals("shop"))
		{
			ClickShop();
		}
		if(role.equals("account"))
		{
			ClickAccount();
		}
		
	}

}
