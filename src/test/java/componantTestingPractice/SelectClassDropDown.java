package componantTestingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Browser;
public class SelectClassDropDown {

	private WebDriver driver;
	@BeforeClass
	public void lunch() {
	    
	    driver=Browser.StartBrowser("Chrome", "https://www.testandquiz.com/selenium/testing.html"); 
	}
	
	@Test
	public void test() {
		  //Using Select class for selecting value from dropdown  
        
		  Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));
		  dropdown.deselectByIndex(0);
		 // dropdown.selectByVisibleText("Database Testing"); 
	}
	@AfterClass
	public void close()
	{
		driver.close();
	}
}
