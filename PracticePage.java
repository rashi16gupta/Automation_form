package rashi.auto;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
public class PracticePage {
	
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver",  "C:/rashi/chromedriver/chromedriver.exe");
		driver = (WebDriver) new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		wait =new WebDriverWait(driver,50); 
		
		
	}
	
	@Test
  public void Test001_partialLink() {
		driver.findElement(By.xpath("//div/a[@title='Automation Practice Form']")).click();
		Assert.assertEquals("Demo Form for practicing Selenium Automation", driver.getTitle());
  }
	
	@Test
	  public void Test002_LinkTest() {
			driver.findElement(By.xpath("//div/a[@title='Automation Practice Table']")).click();
			Assert.assertEquals("http://toolsqa.com/automation-practice-table/", driver.getCurrentUrl());
	  }
	
	@Test
	  public void Test003_LinkTest() throws InterruptedException {
	  driver.navigate().back();
			driver.findElement(By.xpath("//div/input[@name='firstname']")).sendKeys("rashi");
			driver.findElement(By.xpath("//div/input[@name='lastname']")).sendKeys("gupta");
			driver.findElement(By.xpath("//div/input[@name='sex'][@value='Female']")).click();
			driver.findElement(By.xpath("//div/input[@name='exp'][@value='1']")).click();
					
					//DAte
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date = new Date();
					System.out.println(formatter.format(date));
					driver.findElement(By.id("datepicker")).sendKeys(formatter.format(date));
					driver.findElement(By.xpath("//div/input[@value='Automation Tester']")).click();
					
					//upload to be added here
					//driver.findElement(By.xpath("//input[starts-with(@id,'photo')]")).sendKeys(imgPath);
					
					driver.findElement(By.xpath("//a[contains(text(),'Selenium Automation Hybrid Framework')]")).click();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/input[@value='Selenium IDE']")));
			        
					
					//driver.findElement(By.xpath("//div/input[@value='Selenium IDE']")).click();
					driver.findElement(By.xpath("//div/select[@name='continents']")).click();
					//Thread.sleep(5000);
					driver.findElement(By.xpath("//div/select/option[contains(text(),'Asia')]")).click();
					driver.findElement(By.xpath("//div/select/option[contains(text(),'Navigation Commands')]")).click();
					driver.findElement(By.xpath("//div/button[@id='submit']")).click();
			//Assert.assertEquals("http://toolsqa.com/automation-practice-table/", driver.getCurrentUrl());
	  }
	
	
}

