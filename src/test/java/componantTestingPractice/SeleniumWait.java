package componantTestingPractice;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Browser;
public class SeleniumWait {
	private static WebDriver driver;
	@SuppressWarnings("unused")
	private WebElement webElement;
    public SeleniumWait() {
		driver=Browser.StartBrowser("Chrome","https://google.com");
		//250 milisecond is default polling frequency 
		WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.findElement(By.name("q")).sendKeys("Automation testing "+ Keys.RETURN);
		webElement = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcdef")));
		driver.findElement(By.name("abcd")).click();
		driver.quit();
	}
    public static void main(String... agrs)
    {
    	new SeleniumWait();
    }
}
