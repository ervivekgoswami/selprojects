package com.navistar.occ.testsuites;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.navistar.occ.testsuites.OpenBrowser;;




public class TC008_DrivingReports extends OpenBrowser{
	
	@Test 
	public void TableIsPresent() throws InterruptedException{
		 driver.findElement(By.linkText("REPORTS")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.className("spDriver")).click();
		 
        //boolean ertext1 = driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button")).isDisplayed();
		 
		 if (driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button")).isDisplayed())
		 {
			 driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button")).click();
			 driver.navigate().refresh();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.findElement(By.linkText("REPORTS")).click();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.findElement(By.className("spDriver")).click();
			 
		 }
		 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //driver.findElement(By.className("spDriver")).click();
		 
		/* Select dateRdropdown = new Select(driver.findElement(By.id("ddlDateRange")));
		 dateRdropdown.selectByVisibleText("4 weeks");
	 
		 Select ddlCustomerLocations = new Select(driver.findElement(By.id("ddlCustomerLocations")));
		 ddlCustomerLocations.selectByVisibleText("Celadon");
		 driver.findElement(By.id("btnDrivingReportFilter")).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);*/
		
		boolean isPresent = driver.findElement(By.id("noDataTextBox")).isEnabled();
		if (isPresent)
		{
			Reportcapture();
		}
		else {
			System.out.println("Table not present");
		
		Reportcapture();
		}
	}
	
//@Test  
  public void Reportcapture() throws InterruptedException {
	    
		 //driver.findElement(By.linkText("REPORTS")).click();
		 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //driver.findElement(By.className("spDriver")).click();
		 //driver.findElement(By.id("UnitOrChassis")).sendKeys("");
		 
		 /*Select dateRdropdown = new Select(driver.findElement(By.id("ddlDateRange")));
		 dateRdropdown.selectByVisibleText("4 weeks");
	 
		 Select ddlCustomerLocations = new Select(driver.findElement(By.id("ddlCustomerLocations")));
		 ddlCustomerLocations.selectByVisibleText("L2 Beta - Mesilla Valley");
		 
		 Select ddlMakeList = new Select(driver.findElement(By.id("ddlMakeList")));
		 ddlMakeList.selectByVisibleText("International");
		
		 driver.findElement(By.id("btnDrivingReportFilter")).click();   //Click on Search button after entering selection criteria 
		 //driver.findElement(By.id("btnDrivingReportReset")).click();  //Click on Reset button
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 Thread.sleep(2000);*/
	     searchtable("4 weeks", "L2 Beta - Mesilla Valley", "International");
	     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 Thread.sleep(9000);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	     //searchtable(null, null, null);
	     WebElement mytable = driver.findElement(By.xpath("//*[@id='DrivingReportGrid']/div/div[6]/div/div/div[1]/div/table/tbody"));
	     //List <WebElement> Row_count = mytable.findElements(By.xpath("//*[@id='DrivingReportGrid']/div/div[6]/div/div/div[1]/div/table/tbody/tr[*]"));
		 List <WebElement> Row_count = mytable.findElements(By.tagName("tr"));
		 int iRowCount = Row_count.size(); 
		 
		 //List <WebElement> col_count = driver.findElements(By.xpath("//*[@id='DrivingReportGrid']/div/div[6]/div/div/div[1]/div/table/tbody/tr/td"));
		 List <WebElement> col_count =  mytable.findElements(By.tagName("td"));
		 int iColCount = col_count.size(); 
		 	
		 System.out.println("Number Of Rows = "+iRowCount);
		 System.out.println("Number Of Col = "+iColCount);
		 
		 String first_part = "//*[@id='DrivingReportGrid']/div/div[6]/div/div/div[1]/div/table/tbody/tr[";
		 String second_part = "]/td[";
		 String third_part = "]";
		 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); //wait until the webtable is loaded increase if table taking time
		 
		 String harshbraking = driver.findElement(By.xpath("//*[@id='TotalHarshBraking']")).getText();
		 String[] tHarshbrak = harshbraking.split(" ");
		 String tHarshevents = tHarshbrak[0];
		 int NoOfHarshEvents=Integer.parseInt(tHarshevents);
		 
		 String HarshAcc = driver.findElement(By.xpath("//*[@id='TotalHarshAcc']")).getText();
		 String[] tHarshAcc = HarshAcc.split(" ");
		 String tHarshAccEvents = tHarshAcc[0];
		 int NoOfHarshAccEvents=Integer.parseInt(tHarshAccEvents);
		 
		 System.out.println(NoOfHarshEvents);
		 System.out.println(NoOfHarshAccEvents);
		 /*ArrayList<String> ar = new ArrayList<String>(); 
		 String HarshBrakRow1 = first_part+1+second_part+5+third_part; 
		 String HarshBrakRow2 = first_part+2+second_part+5+third_part;//Get all the Hash Braking Items
		 String HarshBrakdata1 = driver.findElement(By.xpath(HarshBrakRow1)).getText();
		 ar.add(HarshBrakdata1);
		 String HarshBrakdata2 = driver.findElement(By.xpath(HarshBrakRow2)).getText();
		 ar.add(HarshBrakdata2);
		 Integer[] intarray=new Integer[ar.size()];
		 int sum = 0;
		 for (int k=0;k<=ar.size()-1;k++){
			 //System.out.println(ar.get(k));
			 intarray[k] = Integer.parseInt(ar.get(k));
			 System.out.println("Integer Table Value: "+intarray[k]);
			 sum = sum + intarray[k];
		 }
		 System.out.println("Sum of Integer Table Value: "+sum);*/
		 ArrayList<String> HarshBrakCountArray = new ArrayList<String>();
		 ArrayList<String> HarshAcceCountArray = new ArrayList<String>();
		 int tHarshBrakCount = 0;
		 int tHarshAcceCount = 0;
		 for(int i=1; i<=iRowCount-1; i++){
		 //for(int j=2; j<=7; j++){
			   //ArrayList<String> ar = new ArrayList<String>();
			   String HarshBrakCount = first_part+i+second_part+5+third_part;
			   String HarshBrakCountData = driver.findElement(By.xpath(HarshBrakCount)).getText();
			   HarshBrakCountArray.add(HarshBrakCountData);
			   //System.out.println("Array Size is:" +HarshBrakCountArray.size());
			   Integer[] intHarshBrakarray=new Integer[HarshBrakCountArray.size()];
			   intHarshBrakarray[i-1] = Integer.parseInt(HarshBrakCountArray.get(i-1));
			   //System.out.println("Integer Table Value: "+intHarshBrakarray[i-1]);
			   tHarshBrakCount = tHarshBrakCount + intHarshBrakarray[i-1];
			   
			   
			   String HarshAcceCount = first_part+i+second_part+6+third_part;
			   String HarshAcceCountData = driver.findElement(By.xpath(HarshAcceCount)).getText();
			   HarshAcceCountArray.add(HarshAcceCountData);
			   //System.out.println("Array Size is:" +HarshBrakCountArray.size());
			   Integer[] intHarshAcceArray=new Integer[HarshAcceCountArray.size()];
			   intHarshAcceArray[i-1] = Integer.parseInt(HarshAcceCountArray.get(i-1));
			   //System.out.println("Integer Table Value: "+intHarshAcceArray[i-1]);
			   tHarshAcceCount = tHarshAcceCount + intHarshAcceArray[i-1];
		 } 
		 System.out.println("Total HarshBraking Count(Events):"+tHarshBrakCount);
		 System.out.println("Total Harsh Acceleration(Events):"+tHarshAcceCount);
	
}
  public boolean searchtable(String sDate, String sLoaction, String sMake) throws InterruptedException{
	     
	     if(sDate!= null){
	     Select dateRdropdown = new Select(driver.findElement(By.id("ddlDateRange")));
		 dateRdropdown.selectByVisibleText(sDate);
	     }
	     if(sLoaction!= null){
		 Select ddlCustomerLocations = new Select(driver.findElement(By.id("ddlCustomerLocations")));
		 ddlCustomerLocations.selectByVisibleText(sLoaction);
	     }
	     if(sMake!= null){
		 Select ddlMakeList = new Select(driver.findElement(By.id("ddlMakeList")));
		 ddlMakeList.selectByVisibleText(sMake);
	     }
	     
		 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 Thread.sleep(5000);
		 driver.findElement(By.id("btnDrivingReportFilter")).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  return true;
  }
}
