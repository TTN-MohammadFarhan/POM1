package componantTestingPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserTest {
	private WebDriver driver;
	@BeforeTest
	public void lunch() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Mohammad Farhan//Downloads//chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void Test() {
		driver.navigate().to("https://google.com");
	}
}
