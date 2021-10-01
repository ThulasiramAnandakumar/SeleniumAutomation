package POM;

import java.security.Key;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Common_Locators 
{
	
	//Set driver
	public void set(String n,String drivername )
	{
		System.setProperty(n, drivername);	
	}
	
	//Set the Url
	public void url(WebDriver driver,String data)
	{
		driver.get(data);
	}
	
	public void Maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	//Pass Data using Id
	public WebElement id(WebDriver driver,String locator)
	{
		return driver.findElement(By.id(locator));
	}
	
	
	//pass data using name
	public WebElement name(WebDriver driver,String locator)
	{
		return driver.findElement(By.name(locator));
	}
	
	
	
	//pass data using Xpath
	public WebElement Xpath(WebDriver driver,String locator)
	{
		return driver.findElement(By.xpath(locator));
	}
	
	
	

	public void RobotClass																																																																											() throws AWTException 
	{
		Robot rb=new Robot();
	
		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);

	}
	

	
	
	

	
}
