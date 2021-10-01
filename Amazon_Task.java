package Practice_Automation;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.Common_Locators;

public class Amazon_Task 
{
	WebDriver d;
	Common_Locators ref=new Common_Locators();
	
	@BeforeTest
	public void LoadURL()
	{
		ref.set("webdriver.chrome.driver", "/home/qq383/Selenium/Driver/chromedriver");
		d=new ChromeDriver();
		System.out.println("Opening Browser");

		ref.url(d, "https://www.amazon.in/");

		ref.Maximize(d);
	}
	
	@BeforeMethod 
	void SearchProduct() throws InterruptedException
	{
		Thread.sleep(3000);
		ref.id(d,"twotabsearchtextbox").sendKeys("Ipad");
		ref.id(d, "nav-search-submit-button").click();
	}
	
	
	@Test
	public void ClickProduct()
	{
		 WebDriverWait wait=new WebDriverWait(d, 20);
		 
		//Click Ipad
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'2021 Apple iPad Pro with Apple M1 chip (11-inch/27')]")));
		ref.Xpath(d,"//span[contains(text(),'2021 Apple iPad Pro with Apple M1 chip (11-inch/27')]").click();
		
		System.out.println("Selected Ipad Pro 2021");
		
	}
	
	@AfterMethod
	void Buyprdouct()
	{
		String parent=d.getWindowHandle();
		Set<String> Window=d.getWindowHandles();
		
		ArrayList<String> tab=new ArrayList<String>(Window);
		d.switchTo().window(tab.get(1));
		
		

		
		 WebDriverWait wait=new WebDriverWait(d, 20);
		 
		 //Validate Title
		 String title=d.getTitle();
		 System.out.println(title);

		 
		String expected= d.findElement(By.xpath("//span[@id='productTitle']")).getText();
		
		Assert.assertEquals("2021 Apple iPad Pro with Apple M1 chip (11-inch/27.96 cm, Wi-Fi + Cellular, 128GB) - Space Grey (3rd Generation)", expected);
		
		
		
		//Select Gray color
		ref.Xpath(d,"//img[@alt='Space Grey']").click();
		
		System.out.println("Selected Grey Color ");
		
		//Click Buy now
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buyNow")));
		ref.id(d,"buyNow").click();
		
		System.out.println("Buy now is Clicked");
	}
	
	@AfterTest
	void Close()
	{
		
		System.out.println("Closing Browser");
		d.close();
		d.quit();
	}

}
