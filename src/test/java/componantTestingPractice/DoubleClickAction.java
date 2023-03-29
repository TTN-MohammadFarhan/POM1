package componantTestingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Browser;

public class DoubleClickAction {
	private WebDriver driver;
	@BeforeClass
	public void lunch() {
	    
	    driver=Browser.StartBrowser("Chrome", "https://www.browserstack.com/"); 
	}
	
	@Test
	public void test() {
		  //Using Select class for selecting value from dropdown  
				Actions a = new Actions(driver);


		//Double click on element

		WebElement trialaction = driver.findElement(By.xpath("//a[@id='free-trial-link-anchor']"));

		a.doubleClick(trialaction).perform();
	}
	@AfterClass
	public void close()
	{
		driver.close();
	}
}
