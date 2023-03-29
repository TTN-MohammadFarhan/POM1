package componantTestingPractice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.Browser;
public class DataProviderTest {
   	WebDriver driver;
  	@DataProvider(name = "test-data")
  	public Object[][] dataProvFunc(){
        	return new Object[][]{
              	{"Selenium","Delhi"},{"QTP","Bangalore"},{"LoadRunner","Chennai"}
        	};
  	}
  	@BeforeMethod
  	  public void setUp() {
         	  System.out.println("Start test");
        	  driver =Browser.StartBrowser("Chrome", "https://www.google.com");
        	  //Wait wait=new FluentWait(driver).withTimeout(30,TimeUnit.SECONDS).pollingEvery(50,Tim).ignoring(NoSuchElementException.class);
        	 
  	  }
  	@Test(dataProvider ="test-data")
  	public void search(String keyWord1, String keyWord2){
  		driver.findElement(By.name("q")).sendKeys(keyWord1 + " "+ keyWord2 + Keys.ENTER);
  	}
  	@AfterMethod
  	public void burnDown() throws InterruptedException{
  		Thread.sleep(1000);
        	driver.quit();
  	}
}