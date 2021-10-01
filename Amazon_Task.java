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
		ref.id(d,"twotabsearchtextbox").sendKeys("iphone13");
		ref.id(d, "nav-search-submit-button").click();
	}


	@Test
	public void ClickProduct()
	{
		WebDriverWait wait=new WebDriverWait(d, 20);

		//Click Ipad
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Apple iPhone 13 Mini (256GB) - Pink')]")));
		ref.Xpath(d,"//span[contains(text(),'Apple iPhone 13 Mini (256GB) - Pink')]").click();

		System.out.println("Selected iphone 13 Mini");

	}

	@AfterMethod
	void Buyprdouct()
	{
		String parent=d.getWindowHandle();
		Set<String> Window=d.getWindowHandles();

		ArrayList<String> tab=new ArrayList<String>(Window);
		d.switchTo().window(tab.get(1));




		WebDriverWait wait=new WebDriverWait(d, 20);

		//Get Title
		String title=d.getTitle();
		System.out.println(title);


		//Select Pink color
		ref.Xpath(d,"//img[@alt='Pink']").click();

		System.out.println("Selected pink Color ");
		String expected= d.findElement(By.xpath("//span[@id='productTitle']")).getText();

		Assert.assertEquals("Apple iPhone 13 Mini (256GB) - Pink", expected);





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
