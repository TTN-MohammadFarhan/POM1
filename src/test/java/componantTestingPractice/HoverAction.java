package componantTestingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Browser;

public class HoverAction {
	private WebDriver driver;
	@BeforeClass
	public void lunch() {
	    
	    driver=Browser.StartBrowser("Chrome", "https://www.browserstack.com/"); 
	}
	
	@Test
	public void test() throws InterruptedException {
		  //Using Select class for selecting value from dropdown  
        
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,300)");

		Actions ac = new Actions(driver);

		WebElement live= driver.findElement(By. cssSelector("div.product-cards-wrapper--click a[title='Live']")); 
		ac.moveToElement(live).build().perform();

		Thread.sleep(3000);
		
		WebElement automate= driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='App Automate']"));
		automate.click();
		Thread.sleep(2000);
	}
	@AfterClass
	public void close()
	{
		driver.close();
	}
}
