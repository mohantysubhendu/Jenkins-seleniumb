package selenium.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
  /*
  @Test
  public void f() {
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }
*/
	
	
	WebDriver driver;
	
	  @BeforeClass
	  public void beforeClass() {
		 driver = new ChromeDriver();
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
/*	  
	  @Test
	  public void openSite(){
		  
		  		System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
			    String baseUrl = "http://demo.guru99.com/test/newtours/";
		        String expectedTitle = "Welcome: Mercury Tours";
		        String actualTitle = "";

		        // launch Fire fox and direct it to the Base URL
		        driver.get(baseUrl);

		        // get the actual value of the title
		        actualTitle = driver.getTitle();

		        
		         * compare the actual title of the page with the expected one and print
		         * the result as "Passed" or "Failed"
		         
		        if (actualTitle.contentEquals(expectedTitle)){
		            System.out.println("Test Passed!");
		        } else {
		            System.out.println("Test Failed");
		        }
		       
	  }*/
	  
	  //to verify the url
	  @Test
	  public void testUrl() throws InterruptedException
	  {
		  String baseUrl="https://admin-dev.salusconnect.io";
		  driver.get(baseUrl);
		  Thread.sleep(2000);
		  System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		  String url=driver.getCurrentUrl();
		  Assert.assertEquals(url,"https://admin-dev.salusconnect.io/#/login");
		  Thread.sleep(2000);
		  
	  }
	  
	  //to verify forgot password is working or not
	  @Test
	  public void verifyForgot_Password() throws InterruptedException
	  {
		  String baseUrl="https://admin-dev.salusconnect.io";
		  driver.get(baseUrl);
		  Thread.sleep(2000);
		  System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		  driver.findElement(By.linkText("Forgot password")).click();
		  String url=driver.getCurrentUrl();
		  Thread.sleep(2000);
		  Assert.assertEquals(url,"https://admin-dev.salusconnect.io/#/login/forgotPassword");
		  //driver.navigate().back();
	  }
	  
	  // to verify username and password is taking you to login page or not
	  
	  @Test
	  public void test_Login() throws InterruptedException
	  {
			System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
			Thread.sleep(2000);
			String baseUrl="https://admin-dev.salusconnect.io";
			 driver.get(baseUrl);
			 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys("rameshamr831+25@gmail.com");
			 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[2]/div/div[1]/input")).sendKeys("Ab123456");
			 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[4]/div/button")).click();
			 //Thread.sleep(2000);
			 
	  }
  
  
}
