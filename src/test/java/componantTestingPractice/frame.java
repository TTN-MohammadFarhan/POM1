package componantTestingPractice;

import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import base.Browser;
public class frame   {
public static void main(String[] args) throws NoSuchElementException, InterruptedException{
	    WebDriver driver = Browser.StartBrowser("Chrome", "https://demo.guru99.com/test/guru99home/");
	   // driver.get("https://demo.guru99.com/test/guru99home/");  
	   // driver.manage().window().maximize();
	    Set<String> s=null;
	    int size = driver.findElements(By.tagName("iframe")).size();
	  
	for(int i=0; i<=size; i++){
	    driver.switchTo().frame(i);
	    int total=driver.findElements(By.xpath("html/body/a/img")).size();
	    
		System.out.println(total);
	    driver.switchTo().defaultContent(); //switching back from the iframe
	    
	    if(total==1)
	    {
	    	Thread.sleep(1000);
	    	//Commented the code for finding the index of the element
		    driver.switchTo().frame(i); //Switching to the frame
			System.out.println("********We are switched to the iframe*******");
			driver.findElement(By.xpath("//img[@src=\"Jmeter720.png\"]")).click();
			 s=driver.getWindowHandles();
			break;
	    }
	 }
	if(!s.isEmpty())            
	driver.switchTo().window(s.stream().collect(Collectors.toList()).get(0));
		
		//Clicking the element in line with Advertisement
	    System.out.println("*********We are done***************");
	        }
	    }