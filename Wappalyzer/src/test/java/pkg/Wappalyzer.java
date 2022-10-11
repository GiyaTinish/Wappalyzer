package pkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wappalyzer {
		
		WebDriver driver;
		
		@BeforeClass
		public void setup()
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.wappalyzer.com/");
			driver.manage().window().maximize();
		}

		@Test(priority = 1)
		public void clickResources()
		{
			driver.findElement(By.xpath("//div[@class='v-toolbar__content']/div[1]/div[1]/div[2]/button[2]")).click();
		}
		@Test(priority = 2)
		public void clickTechnologies()
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//div[@class='v-toolbar__content']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a/div[1]")).click();
		}
		@Test(priority = 3)
		public void search() throws InterruptedException  
		{
			WebElement elem = driver.findElement(By.xpath("//div[@class='container py-10 py-sm-12']/div[1]/div[2]/h2[2]"));
		
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elem);
			WebElement ele = driver.findElement(By.xpath("//div[@class='v-select__selections']"));
			
			ele.click();
			driver.findElement(By.xpath("//div[@role='listbox']/form[1]/div[1]/div[1]/div[1]/div[1]/input")).sendKeys("Wix");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@role='listbox']/div[1]")).click();

		}
		
		@Test(priority = 4)
		public void clickLead()
		{
			driver.findElement(By.xpath("//div[@class='v-alert__content']/a[1]")).click();
		}
	

}
