package componantTestingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Browser;

public class DynamicDropDownSpicejet {
	private WebDriver driver;
	@BeforeMethod
	  public void setUp() {
       	  System.out.println("Start test");
      	  driver =Browser.StartBrowser("Chrome", "https://www.spicejet.com/");
      	  //Wait wait=new FluentWait(driver).withTimeout(30,TimeUnit.SECONDS).pollingEvery(50,Tim).ignoring(NoSuchElementException.class);
      	 
	  }
	@Test()
	public void search() throws InterruptedException{
	
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
	}
	@AfterMethod
	public void burnDown() throws InterruptedException{
		Thread.sleep(1000);
      	driver.quit();
	}
}
