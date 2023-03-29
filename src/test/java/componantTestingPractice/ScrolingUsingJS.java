package componantTestingPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import base.Browser;

public class ScrolingUsingJS {
 public static void main(String[] args) throws InterruptedException { 
        
		//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	    String baseURL = "https://demo.guru99.com/test/newtours/register.php";
	    WebDriver driver = Browser.StartBrowser("Chrome", baseURL);
		//driver.get(baseURL);
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name=\"country\"]")));
	    jse.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//select[@name=\"country\"]")));
	    jse.executeScript("window.scrollBy(0,-100)");
		Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByVisibleText("ANTARCTICA");
		Wait fluenwait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(30))
				.ignoring(Exception.class);
		WebElement webName=driver.findElement(By.xpath("//input[@name=\"firstName\"]"));
		fluenwait.until(ExpectedConditions.visibilityOf(webName));
		webName.sendKeys("Mohammad");
		fluenwait.wait(1000);
		
        //Thread.sleep(3000);
		driver.close();
		//Selecting Items in a Multiple SELECT elements
//		driver.get("http://jsbin.com/osebed/2");
//		Select fruits = new Select(driver.findElement(By.id("fruits")));
//		fruits.selectByVisibleText("Banana");
//		fruits.selectByIndex(1);
 }
}
 