package com.navistar.occ.testsuites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.navistar.occ.testsuites.OpenBrowser;;

public class TC007_FuelTaxIfta {
  @Test
  public void FuelTaxDetails() {
	  //driver =  new OpenBrowser.driver;
	  
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
	     driver.get("https://evaluet.internationaldelivers.com/occwebqa/naviocc/Main/Vehicles");
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     driver.findElement(By.linkText("REPORTS")).click();
	     
	     driver.findElement(By.linkText("Fuel Tax (IFTA)")).click();
	  
	     Select ddlCustomerLocations = new Select(driver.findElement(By.id("ddlCustomerLocations")));
		 ddlCustomerLocations.selectByVisibleText("L2 Beta - Mesilla Valley");
		 
		 Select ddlMakeList = new Select(driver.findElement(By.id("ddlFilingPeriod")));
		 ddlMakeList.selectByVisibleText("July 1 - Sep 30");
		 
		 Select dateRdropdown = new Select(driver.findElement(By.id("ddlYear")));
		 dateRdropdown.selectByVisibleText("2017");
		 
		 driver.findElement(By.id("btnIFTAReportFilter")).click();   //Click on Search button after entering selection criteria 
		 //driver.findElement(By.id("btnIFTAReportReset")).click();  //Click on Reset button
	  
	  
	  
  }
}
