package componantTestingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Browser;
public class MKGandhi {

	 private WebDriver driver; 
	@BeforeClass
	public void launch() {
		driver=Browser.StartBrowser("Chrome","https://google.com");
	}
	@Test
	public void Test1()
	{
		
		WebElement searchBox=driver.findElement(By.xpath("//input[@name='q']"));
		searchBox.sendKeys("mahatma gandhi" + Keys.RETURN);
		    String s= driver.getWindowHandle();
		    driver.switchTo().window(s);
		    
		    WebElement wiki=driver.findElement(By.xpath("//a[@href=\"https://en.wikipedia.org/wiki/Mahatma_Gandhi\"]"));
		    wiki.click();
		    String url=driver.getCurrentUrl();
		    Assert.assertEquals("https://en.wikipedia.org/wiki/Mahatma_Gandhi", url,"link not find");
	}
}
