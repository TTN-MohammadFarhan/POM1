package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.nio.charset.Charset;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.RandomStringUtils;


public class AdminPage {
	WebDriver driver;
	
	By addButton=By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
	WebElement webElement;
	public  AdminPage(WebDriver driver) {
		this.driver=driver;
	}
	public String pageverify()
    {
		 webElement= driver.findElement(addButton);
                  return driver.findElement(addButton).getText();
     }
	public  String GeneratingRandomString() {
		 	int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 10;
		    Random random = new Random();

//		    String generatedString = random.ints(leftLimit, rightLimit + 1)
//		      .limit(targetStringLength)
//		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//		      .toString();
		   
		    //String generatedString = RandomStringUtils.randomAlphabetic(10);
		    
		    int length = 10;
		    boolean useLetters = true;
		    boolean useNumbers = false;
		    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);


	    return generatedString;
	 

	}

	 public void add() throws  InterruptedException
     {
    	 
         webElement.click();
		try {
			 driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][1]")).click();
             Robot rb;
			rb = new Robot();
			 rb.keyPress(KeyEvent.VK_DOWN);
             Thread.sleep(1000);
             rb.keyPress(KeyEvent.VK_DOWN);
             Thread.sleep(1000);
             rb.keyPress(KeyEvent.VK_ENTER);
             

             Thread.sleep(2000);
             WebElement w1 =driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
             w1.click();
             w1.sendKeys("h");
             Thread.sleep(10000);
//             WebDriverWait wd = new WebDriverWait(driver, 20);
//             wd.until(ExpectedConditions.visibilityOf(w1));
             rb.keyPress(KeyEvent.VK_DOWN);
             Thread.sleep(5000);
             rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
             //rb.keyPress(KeyEvent.VK_ENTER);
             Thread.sleep(5000);
             
             driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")).click();
             rb.keyPress(KeyEvent.VK_DOWN);
             Thread.sleep(2000);
             rb.keyPress(KeyEvent.VK_DOWN);
             Thread.sleep(2000);
             rb.keyPress(KeyEvent.VK_ENTER);
             driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(GeneratingRandomString());
            // Thread.sleep(2000);
             driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Admin@12345");
             driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Admin@12345");
             Thread.sleep(2000);
             driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
         
			} catch (AWTException e) {
				// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			}
        
          }
	 public String verifingSucessfulAddedUser()
	 {
		  return driver.findElement(addButton).getText();
	 }
	 
	 public void deletingRecord() {
		 
		 
		// Find the table element
		 WebElement table =  driver.findElement(By.xpath("//div[@role=\"rowgroup\"][2]"));

		 // Find the row and column numbers (starting from 1)
		 WebElement cell;
		 // Find the cell element in the specified row and column
		  cell = table.findElement(By.xpath("//div[@class='row'][" + 2 + "]"));

		 // Get the text content of the cell
		 String cellText = cell.getText();

//		 for(WebElement e : ElementList) {
//			  System.out.println(e.getText());
//			}
	 }


}
