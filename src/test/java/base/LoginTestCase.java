package base;

import java.util.concurrent.TimeUnit;
import base.Browser;
import base.ScreenShot;
import pageObject.AdminPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import pageObject.HomePage;
public class LoginTestCase { 
					
               WebDriver driver;
               LoginPage lp;
               HomePage hp;
               AdminPage ap;
              int i = 0;
              // Launch of the given browser.
              @BeforeSuite
              public void browserlaunch()
              {
                             driver = Browser.StartBrowser("Chrome","https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
                             driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
                             lp = new LoginPage(driver);
                          hp = new HomePage(driver);
                          ap=new AdminPage(driver);
               }
             // Login to the Site.
             @Test(priority = 1)
             public void Login() throws InterruptedException
              {
              lp.loginToSite("Admin","admin123");
              Thread.sleep(1000);
              System.out.println();
              }
             // Verifing the Home Page.
             @Test(priority = 2)
             public void HomePageVerify()
             {
                            String HomeText = hp.pageverify();
                            Assert.assertEquals(HomeText, "Dashboard");
                            hp.admin();
              }
             
//             @Test(priority = 3)
//             public void AdminPageVerify()
//             {
//            	 String adminButton=ap.pageverify();
//            	 System.out.println(adminButton);
//            	 //Assert.assertEquals(adminButton, " Add ");
//             }
             
//             @Test(priority = 4)
//             public void addUser() throws InterruptedException
//              {
             
//                     ap.add();
//                     Thread.sleep(1000);
//               }
//             @Test(priority = 5)
//             public void VerifingSucessfulAddedUser() {
//            	 String pageElement=ap.verifingSucessfulAddedUser();
//            	 //Assert.assertEquals(pageElement, " Add ");
//             }
             
             
//             @Test(priority = 6)
//             public void removingUser() {
//            	 
//             }
//Taking Screen shot on test fail
//              @AfterMethod
//              public void screenshot(ITestResult result)
//              {
//                         i = i+1;
//                         String name = "ScreenShot";
//                         String x = name+String.valueOf(i);
//                        if(ITestResult.FAILURE == result.getStatus())
//                          {
//                                         ScreenShot.captureScreenShot(driver, x);
//                           }
//   }
  @AfterSuite
   public void closeBrowser()
   {
                  driver.close();
    }
}