package componantTestingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Browser;

public class HandleMultipleKeys {

	private WebDriver driver;
	@BeforeClass
	public void lunch() {
	    
	    driver=Browser.StartBrowser("Chrome", "https://www.stqatools.com"); 
	}
	
	@Test
	public void test() throws InterruptedException {
		  //Using Select class for selecting value from dropdown  
        		 
		// Create object of Action class
		Actions action = new Actions(driver);
		 Thread.sleep(1000);
		// Sendkeys using Action class object
		// Send single key using sendkeys
		 driver.findElement(By.xpath("ele_path")).sendKeys(Keys.ENTER);
		 Thread.sleep(1000);
		 // Handle multiple keys using chord
		 driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		  
 
	}
	@AfterClass
	public void close() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}
}
