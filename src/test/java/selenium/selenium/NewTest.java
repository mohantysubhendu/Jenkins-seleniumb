package selenium.selenium;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

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
		// System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		  System.setProperty("webdriver.chrome.driver","/Users/Shared/Jenkins/Home/chromedriver");
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
		  Thread.sleep(4000);
		  driver.get(baseUrl);
		  Thread.sleep(4000);
		 // System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		  String url=driver.getCurrentUrl();
		  Assert.assertEquals(url,"https://admin-dev.salusconnect.io/#/login");
		  Thread.sleep(2000);
		  
	  }
	  
	  //to verify forgot password is working or not
	  @Test
	  public void erifyForgot_Password() throws InterruptedException
	  {
		  String baseUrl="https://admin-dev.salusconnect.io";
		  driver.get(baseUrl);
		//  System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		//  driver.findElement(By.linkText("Forgot password")).click();
		  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[3]/div/a")).click();
		  String url=driver.getCurrentUrl();
		  Thread.sleep(10000);
		  Assert.assertEquals(url,"https://admin-dev.salusconnect.io/#/login/forgotPassword");
		  Thread.sleep(10000);
		  driver.navigate().back();
	  }
	  
  // to verify username and password is taking you to login page or not
	  
	  @Test
	  public void test_Login() throws InterruptedException, FileNotFoundException, IOException
	  {
			//System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
			//Thread.sleep(2000);
			String baseUrl="https://admin-dev.salusconnect.io/#/login";
			driver.get(baseUrl);
			 Thread.sleep(2000);
			 
			 java.io.File file= new java.io.File("config.properties");
			 Properties prop = new Properties();
			 prop.load(new FileInputStream(file));
			 ArrayList<String> ls1 = new ArrayList<String>();
			 ls1.add(prop.getProperty("salus.us1"));
			 ls1.add(prop.getProperty("salus.pas1"));
		
			 
		     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys(ls1.get(0));
			 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[2]/div/div[1]/input")).sendKeys(ls1.get(1));
			 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[4]/div/button")).click();	
			 System.out.println("in login methodddddddd");
			 Thread.sleep(10000);		
			
	  }
	  

	  
	  // to verify the fields in login page
	  
	  @Test
	  public void checkFields() {
		  if((driver.findElements(By.tagName("form")) != null) && (driver.findElements(By.tagName("input")) != null)) {
			    System.out.println("email and password fields are present");
		  }else
			    System.out.println("email and password fields are not present");
	  }


	
	// to verify the profile name is present or not
	
	  
		@Test
		 public void profieName() throws InterruptedException, FileNotFoundException, IOException{
		 	driver.get("https://admin-dev.salusconnect.io/#/login");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys("rameshamr831+25@gmail.com");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ab123456");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"signInBtn\"]")).click();
			Thread.sleep(10000);
			WebElement textIndiaWebElement= driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/div[8]/button/span[1]"));
			String innerText= textIndiaWebElement.getText();
			System.out.println("Inner text is :"+innerText);
			java.io.File file= new java.io.File("config.properties");
			Properties prop = new Properties();
			prop.load(new FileInputStream(file));
			ArrayList<String> ls = new ArrayList<String>();
			ls.add(prop.getProperty("salus.profileName1"));
			ls.add(prop.getProperty("salus.profileName2"));
			
			if(ls.contains(innerText)){
				System.out.println("profile is correct");
			}else {
				System.out.println("profiel is incorrect");
			}
			
			Assert.assertEquals(innerText, "chitti");
			Thread.sleep(10000);
			driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/div[7]/a")).click();
			
	 	 }
		
		
		// to read datas from config.properties file
		
	/*	@Test
		public void readData() throws InterruptedException 
		{
			driver.navigate().to("https://admin-dev.salusconnect.io/#/login");
			Thread.sleep(10000);
			System.out.println("IIIIIIIIIIIIIIIIIIIII am in readData()");
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys("rameshamr831+25@gmail.com");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ab123456");
			Thread.sleep(10000);
			WebElement profileName= driver.findElement(By.cssSelector("#profileDropdown > span.text.ng-binding"));
			Thread.sleep(10000);
			String innerText= profileName.getText();
			System.out.println("Inner text is :"+innerText);
			
		}
	  */
	/*  //to verify the profile name is present or not
 
	  @Test
	  public void test_profileName() throws InterruptedException
	  {
		
			System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
			Thread.sleep(2000);
			String baseUrl="https://admin-dev.salusconnect.io";
			 driver.get(baseUrl);
			 //Assert.assertEquals("Facility Management", driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/div[2]/a")).getText());
			 WebElement  btn = driver.findElement(By.className("text ng-binding"));
			 String name=btn.getText();
			 System.out.println(name);
			 
	  }*/
  
	  
  
}
