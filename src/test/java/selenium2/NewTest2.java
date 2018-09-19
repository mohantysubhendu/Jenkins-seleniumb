package selenium2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest2 {
	WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		 driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

//to verify dashboard is coming or not
  
 @Test  
 public void Dashboard() throws InterruptedException {
	    driver.get("https://admin-dev.salusconnect.io/#/login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys("rameshamr831+25@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ab123456");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"signInBtn\"]")).click();
		Thread.sleep(20000);
		String urlText = driver.getCurrentUrl();
		Thread.sleep(10000);
		System.out.println("We are on dashboard");
	    Assert.assertEquals(urlText, "https://admin-dev.salusconnect.io/#/deviceManagement/dashboard" );
		
		Thread.sleep(10000);
}
  
  
}
