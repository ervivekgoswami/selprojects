package com.navistar.occ.testsuites;

import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.navistar.occ.testsuites.OpenBrowser;;

public class VehicleListDetails extends OpenBrowser{
@Test
  public void DetailCapture() {
		 
		 driver.findElement(By.linkText("VEHICLE LIST")).click();
		 
		 driver.findElement(By.xpath("//*[@id='divSearch']/div[1]/div/div[1]/div[1]/div/div/button")).click();
		 
		 //driver.findElement(By.id("All")).click();                  //Click on Select/Unselect All CheckBox
		 driver.findElement(By.id("ALEXAXXXX")).click();            //Click on Alexa Checkbox CheckBox
		 //driver.findElement(By.id("1304191")).click();				  //Click on L2 Beta - Mesilla Valley CheckBox
		 //driver.findElement(By.id("1304190")).click();				  //Click on L2 Beta - Norfolk CheckBox
		 //driver.findElement(By.id("CELADONXX")).click();			//Click on Celadon
		 //driver.findElement(By.id("410")).click();					 //Click on Celadon Sub CheckBox
		 //driver.findElement(By.id("IDEALEASE")).click();			//Click on Idealease CheckBox
		 //driver.findElement(By.id("405")).click();					  //Click on Idealease Sub CheckBox
		 //driver.findElement(By.id("REGIONALX")).click();			//Click on Regional
		 //driver.findElement(By.id("408")).click();					//Click on Regional International Corp
		 
		 driver.findElement(By.id("UnitOrChassis")).clear();
		 driver.findElement(By.id("UnitOrChassis")).sendKeys("Vivek");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//*[@id='divSearch']/div[1]/div/div[1]/div[1]/div/div/button")).click();
		 
		 driver.findElement(By.id("cbDerate")).click();
		 driver.findElement(By.id("cbSI")).click();
		 driver.findElement(By.id("cbMR")).click();
		 driver.findElement(By.id("cbSN")).click();
		 driver.findElement(By.id("cbSS")).click();
		 
		 Select dropdown = new Select(driver.findElement(By.id("ddlFaultList")));
		 dropdown.selectByVisibleText("Misfire");
		 /*List<WebElement> FaultList = dropdown.getOptions();
		 System.out.println(FaultList.size());
		 for (int j = 0; j < FaultList.size(); j++) {
		    }*/
		 
		 /*Select dropdown = new Select(driver.findElement(By.id("ddlMakeList")));
		 List<WebElement> dd = dropdown.getOptions();
		 System.out.println(dd.size());
		 for (int j = 0; j < dd.size(); j++) {
		        System.out.println(dd.get(j).getText());
		    }
		 Select engFamily = new Select(driver.findElement(By.id("ddlEngineFamily")));
		 List<WebElement> engFamilysize = engFamily.getOptions();
		 System.out.println(engFamilysize.size());
		 
		 Select zonelist = new Select(driver.findElement(By.id("ddlZoneList")));
		 List<WebElement> zolesize = zonelist.getOptions();
		 System.out.println(zolesize.size());
		 
		 driver.findElement(By.id("cbAutoRefresh")).click();
		 driver.findElement(By.id("cbDlrOnly")).click();
		 driver.findElement(By.id("cbTelematics")).click();
		 driver.findElement(By.id("cbActiveEngine")).click();
		 driver.findElement(By.id("cbActiveCode")).click();
		 driver.findElement(By.id("cbKnownLocation")).click();
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 //driver.findElement(By.id("btnReset")).click();
		 driver.findElement(By.id("report-date-range")).click();
		 driver.findElement(By.id("btnApply")).click();
		 
		 WebElement daterange = driver.findElement(By.cssSelector("body > div.daterangepicker.dropdown-menu.ltr.opensright > div.ranges > ul"));
		 List<WebElement> links = daterange.findElements(By.tagName("li"));
		 for (int i = 1; i < links.size(); i++)
		 {
			 String val = "Custom";
			 if (val.equals(links.get(i).getText()))
			 {
				 System.out.println(links.get(i).getText());
				 links.get(i).click();
				 driver.findElement(By.name("daterangepicker_start")).clear();
				 driver.findElement(By.name("daterangepicker_start")).sendKeys("09/30/2017");
				 driver.findElement(By.name("daterangepicker_end")).clear();
				 driver.findElement(By.name("daterangepicker_end")).sendKeys("10/30/2017");
				 driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/button[1]")).click();
				 break;
			 }
		     //System.out.println(links.get(i).getText());
		 }*/
		 
		 
		 
		 
		 

} 
}
