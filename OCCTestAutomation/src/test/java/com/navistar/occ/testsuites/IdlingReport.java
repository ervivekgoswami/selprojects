package com.navistar.occ.testsuites;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class IdlingReport {
	@Test
  public void LaunchIdlingReport() throws InterruptedException{
	  
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
			  driver.findElement(By.className("spIdling")).click();
			  
			  driver.findElement(By.id("UnitOrChassis")).sendKeys("");
			 
			 Select dateRdropdown = new Select(driver.findElement(By.id("ddlDateRange")));
			 dateRdropdown.selectByVisibleText("12 weeks");
		 
			 Select ddlCustomerLocations = new Select(driver.findElement(By.id("ddlCustomerLocations")));
			 ddlCustomerLocations.selectByVisibleText("L2 Beta - Mesilla Valley");
			 
			 Select ddlMakeList = new Select(driver.findElement(By.id("ddlMakeList")));
			 ddlMakeList.selectByVisibleText("International");
			
			 driver.findElement(By.id("btnIdlingReportFilter")).click();   //Click on Search button after entering selection criteria 
			 //driver.findElement(By.id("btnIdlingReportReset")).click();  //Click on Reset button
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 Thread.sleep(2000);
			 
			 List <WebElement> Row_count = driver.findElements(By.xpath("//*[@id='IdleReportGrid']/div/div[6]/div/table/tbody/tr[*]"));
			 int iRowCount = Row_count.size(); 
			  
			 List <WebElement> col_count = driver.findElements(By.xpath("//*[@id='IdleReportGrid']/div/div[6]/div/table/tbody/tr/td"));
			 int iColCount = col_count.size(); 
			 	
			 System.out.println("Number Of Rows = "+iRowCount);
			 System.out.println("Number Of Col = "+iColCount/6);
			 
			 String first_part = "//*[@id='IdleReportGrid']/div/div[6]/div/table/tbody/tr[";
			 String second_part = "]/td[";
			 String third_part = "]";
			 
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //wait until the webtable is loaded increase if table taking time
			 
			 String tIdlingTime = driver.findElement(By.xpath("//*[@id='TotalIdleTime']")).getText();
			 String[] tIdleTimeSplit = tIdlingTime.split(" ");
			 String tIdleTime = tIdleTimeSplit[0];
			 //double TotalNoOfIdleTime=Double.parseDouble(tIdleTime);
			 System.out.println(tIdleTime);
			 
			 String tIdlingMiles = driver.findElement(By.xpath("//*[@id='TotalIdleMiles']")).getText();
			 String[] tIdleMilesSplit = tIdlingMiles.split(" ");
			 String tIdleMile = tIdleMilesSplit[0];
			 //double TotalNoOfIdleMiles= Double.parseDouble(tIdleMile);
			 System.out.println(tIdleMile);
			 
			 String tIdlingDollar = driver.findElement(By.xpath("//*[@id='TotalIdleDollars']")).getText();
			 String[] tIdleDollarSplit = tIdlingDollar.split(" ");
			 String tIdleDollar = tIdleDollarSplit[1];
			 double TotalNoOfIdleDollar= Double.parseDouble(tIdleDollar);
			 System.out.println(TotalNoOfIdleDollar);
			 
			 ArrayList<String> IdlingMilesCountArray = new ArrayList<String>();
			 ArrayList<String> IdlingDollarCountArray = new ArrayList<String>();
			 double tIdlingMilesCount = 0;
			 double tIdlingDollarCount = 0;
			 
			 for(int i=1; i<=iRowCount; i++){
				 //for(int j=2; j<=7; j++){
					   //ArrayList<String> ar = new ArrayList<String>();
					   String IdlingMilesCount = first_part+i+second_part+5+third_part;
					   String IdlingMilesCountData = driver.findElement(By.xpath(IdlingMilesCount)).getText();
					   IdlingMilesCountArray.add(IdlingMilesCountData);
					   System.out.println("Array Size is:" +IdlingMilesCountArray.size());
					   Double[] doubleIdlingMilesarray=new Double[IdlingMilesCountArray.size()];
					   doubleIdlingMilesarray[i-1] = Double.parseDouble(IdlingMilesCountArray.get(i-1));
					   //System.out.println("Integer Table Value: "+doubleIdlingMilesarray[i-1]);
					   tIdlingMilesCount = tIdlingMilesCount + doubleIdlingMilesarray[i-1];
					   
					   
					   String IdlingDollarCount = first_part+i+second_part+6+third_part;
					   String IdlingDollarCountData = driver.findElement(By.xpath(IdlingDollarCount)).getText();
					   IdlingDollarCountArray.add(IdlingDollarCountData);
					   System.out.println("Array Size is:" +IdlingDollarCountArray.size());
					   Double[] doubleIdlingDollarArray=new Double[IdlingDollarCountArray.size()];
					   doubleIdlingDollarArray[i-1] = Double.parseDouble(IdlingDollarCountArray.get(i-1));
					   System.out.println(" Table Value: "+doubleIdlingDollarArray[i-1]);
					   tIdlingDollarCount = tIdlingDollarCount + doubleIdlingDollarArray[i-1];
				 } 
			 System.out.println(" Total Idling Miles Value: "+tIdlingMilesCount);
			 System.out.println(" Total Idline Dollar Value: "+tIdlingDollarCount);
			 
			 
			 
			 
			 
	  
  }
}
