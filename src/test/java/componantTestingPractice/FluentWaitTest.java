package componantTestingPractice;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import base.Browser;
public class FluentWaitTest {
	private WebDriver driver;
	@BeforeClass
	public void lunch() {
		 driver= Browser.StartBrowser("chrome", "https://google.com");
	}
	@Test
	public void Test() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("abcd"+ Keys.RETURN);
		//driver.findElement(By.linkText("See all Search settings")).click();
		
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.linkText("See all Search settings"));
			     }
			   });

		foo.click();
		//Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10)).ignoring(ElementNotInteractableException.class);
		
		Thread.sleep(2000);
		driver.navigate().back();
	}
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
	
}
