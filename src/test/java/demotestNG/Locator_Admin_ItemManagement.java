package demotestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locator_Admin_ItemManagement {
	
	WebDriver driver;
	private By Home = By.xpath("//ul[contains(@class,'page-breadcrumb')]//child::li[a]");
	private By AddItem = By.id("addVendor");
	//private List <By> ActiveLinks= By.xpath("//div[contains(@class,'col-md-12')]//a");
	
	public Locator_Admin_ItemManagement(WebDriver driver)
	{
		this.driver   = driver;
	}
	
	public void ClickHome()
	{
		driver.findElement(Home).click();
	}
	
	public void ClickAddItem()
	{
		driver.findElement(AddItem).click();
	}
	

}
