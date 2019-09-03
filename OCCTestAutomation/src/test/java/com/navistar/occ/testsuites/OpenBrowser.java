package com.navistar.occ.testsuites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenBrowser {
	public static WebDriver driver;
  @Test
  public static void LaunchBrowser() {
	  
	  
	     String service = "C:\\CaponeProject\\CapAllProjects\\OCCTestAutomation\\drivers\\geckodriver.exe";
		 System.setProperty("webdriver.gecko.driver", service);
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.get("https://evaluet.internationaldelivers.com/occwebqa/naviocc/Main/Landing");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.id("username")).sendKeys("yyy1k78");
		 driver.findElement(By.id("password")).sendKeys("Bismillah10!");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//input[@value='Log In']")).click();
	     driver.get("https://evaluet.internationaldelivers.com/occwebqa/naviocc/Main/Landing");
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  
  }

}
