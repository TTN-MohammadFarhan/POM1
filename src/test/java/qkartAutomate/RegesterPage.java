package qkartAutomate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegesterPage {
	private static final TimeUnit SECONDS = null;
	private static WebDriver driver;
    @BeforeTest
    void beforeTest() {
    	System.setProperty("webdriver.chrome.driver",
				"C://Users//Mohammad Farhan//Downloads//chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait driverWait=new WebDriverWait(driver,20);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://crio-qkart-frontend-qa.vercel.app/register");
    }
    @Test(priority = 1)
    void verifyinPage() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver,70);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),\"Back to explore\")]")));
    	WebElement webPage=driver.findElement(By.xpath("//*[contains(text(),\"Back to explore\")]"));
    	boolean pageTest=webPage.isDisplayed();
    	Assert.assertTrue(pageTest, "page is not present");
    	
    	Thread.sleep(3000);
    }
    @Test(priority = 2)
    void userName() throws InterruptedException {
    	Wait wait = new FluentWait(driver)
    			.withTimeout(30, SECONDS)
    			.pollingEvery(30, SECONDS)
    			.ignoring(Exception.class);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Enter Username\"]")));
    	driver.findElement(By.xpath("//input[@placeholder=\"Enter Username\"]")).sendKeys("farhan");
    	//Thread.sleep(5000);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"password\"]")));
    	driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("farhan123@");
    }
    @Test(priority = 3)
    void testingExplorButton() throws InterruptedException
    {
    	WebElement webPage=driver.findElement(By.xpath("//*[contains(text(),\"Back to explore\")]"));
    	webPage.click();
    	String pagetest=driver.findElement(By.xpath("//span[@class=\"hero-highlight\"]")).getText();
    	Assert.assertEquals(pagetest, "FASTEST DELIVERY");
    	//Thread.sleep(1000);
    	
    }
    @AfterTest
    void afterTest()
    {
    	driver.close();
    }
    
}
