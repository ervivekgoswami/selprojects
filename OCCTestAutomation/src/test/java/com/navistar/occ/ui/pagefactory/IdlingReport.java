package com.navistar.occ.ui.pagefactory;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.navistar.occ.testbase.TestBase;

public class IdlingReport extends TestBase {
	Logger log = Logger.getLogger(this.getClass().getSimpleName());
	WebDriver driver;

	public IdlingReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "UnitOrChassis")
	public WebElement UnitOrChassis;

	@FindBy(how = How.ID, using = "ddlDateRange")
	public WebElement ddlDateRange;

	@FindBy(how = How.ID, using = "ddlCustomerLocations")
	public WebElement ddlCustomerLocations;

	@FindBy(how = How.ID, using = "ddlMakeList")
	public WebElement ddlMakeList;

	@FindBy(how = How.ID, using = "btnIdlingReportFilter")
	public WebElement btnIdlingReportFilter;

	@FindBy(how = How.XPATH, using = "//*[@id='IdleReportGrid']/div/div[6]/div/table/tbody/tr[*]")
	public WebElement rowCountXpath;

	@FindBy(how = How.XPATH, using = "//*[@id='IdleReportGrid']/div/div[6]/div/table/tbody/tr/td")
	public WebElement colCountXpath;

	String first_part = "//*[@id='IdleReportGrid']/div/div[6]/div/table/tbody/tr[";
	String second_part = "]/td[";
	String third_part = "]";

	@FindBy(how = How.XPATH, using = "//*[@id='TotalIdleTime']")
	public WebElement totalIdleTime;

	@FindBy(how = How.XPATH, using = "//*[@id='TotalIdleMiles']")
	public WebElement totalIdleMiles;

	@FindBy(how = How.XPATH, using = "//*[@id='TotalIdleDollars']")
	public WebElement totalIdleDollars;

	public void sendChasisDetails() {
		UnitOrChassis.sendKeys("");
	}

	public void selectDDLDateRange() {
		Select dateRdropdown = new Select(ddlDateRange);
		dateRdropdown.selectByVisibleText("12 weeks");
	}

	public void selectDDLCustomerLocations() {
		Select ddlCustomerLocationsDropDown = new Select(ddlCustomerLocations);
		ddlCustomerLocationsDropDown.selectByVisibleText("L2 Beta - Mesilla Valley");
	}

	public void selectDDLMakeList() {
		Select ddlMakeListDropdown = new Select(ddlMakeList);
		ddlMakeListDropdown.selectByVisibleText("International");
	}

	public void clickOnbtnIdlingReportFilter() {
		btnIdlingReportFilter.click();
	}

	public int getRowsCoulumnCounts() {

		List<WebElement> Row_count = driver
				.findElements(By.xpath("//*[@id='IdleReportGrid']/div/div[6]/div/table/tbody/tr[*]"));
		int iRowCount = Row_count.size();

		List<WebElement> col_count = driver
				.findElements(By.xpath("//*[@id='IdleReportGrid']/div/div[6]/div/table/tbody/tr/td"));
		int iColCount = col_count.size();
		log.info("Number Of Rows = " + iRowCount);
		log.info("Number Of Col = " + iColCount / 6);

		String first_part = "//*[@id='IdleReportGrid']/div/div[6]/div/table/tbody/tr[";
		String second_part = "]/td[";
		String third_part = "]";
		return iRowCount;
	}

	public String getTotalIdleTime() {
		String tIdlingTime = totalIdleTime.getText();
		String[] tIdleTimeSplit = tIdlingTime.split(" ");
		String tIdleTime = tIdleTimeSplit[0];
		// double TotalNoOfIdleTime=Double.parseDouble(tIdleTime);
		log.info("Total Idle Time ---> "+tIdleTime );
		return tIdleTime;
	}
	
	public String getTotalIdleMiles() {
		String tIdlingMiles = totalIdleMiles.getText();
		String[] tIdleMilesSplit = tIdlingMiles.split(" ");
		 String tIdleMile = tIdleMilesSplit[0];
		 //double TotalNoOfIdleMiles= Double.parseDouble(tIdleMile);
		log.info("Total Idle Miles ---> "+tIdleMile );
		return tIdleMile;
	}
	
	public double getTotalIdleDollars() {
		String tIdlingDollar = totalIdleDollars.getText();
		String[] tIdleDollarSplit = tIdlingDollar.split(" ");
		 String tIdleDollar = tIdleDollarSplit[1];
		 double totalNoOfIdleDollar= Double.parseDouble(tIdleDollar);
		 log.info("TotalIdleDollars -----> "+totalNoOfIdleDollar);
		return totalNoOfIdleDollar;
	}
	
	public double getIdlingMilesCountFromSearch()
	{
		ArrayList<String> IdlingMilesCountArray = new ArrayList<String>();
		 ArrayList<String> IdlingDollarCountArray = new ArrayList<String>();
		 double tIdlingMilesCount = 0;
		 double tIdlingDollarCount = 0;
		 
		 for(int i=1; i<=getRowsCoulumnCounts(); i++){
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
		 }
		 return tIdlingMilesCount;
	}
	
	public double getIdlingDollarCountFromSearch()
	{
		ArrayList<String> IdlingMilesCountArray = new ArrayList<String>();
		 ArrayList<String> IdlingDollarCountArray = new ArrayList<String>();
		 double tIdlingMilesCount = 0;
		 double tIdlingDollarCount = 0;
		 
		 for(int i=1; i<=getRowsCoulumnCounts(); i++){
			 //for(int j=2; j<=7; j++){
				   //ArrayList<String> ar = new ArrayList<String>();
			   String IdlingDollarCount = first_part+i+second_part+6+third_part;
			   String IdlingDollarCountData = driver.findElement(By.xpath(IdlingDollarCount)).getText();
			   IdlingDollarCountArray.add(IdlingDollarCountData);
			   System.out.println("Array Size is:" +IdlingDollarCountArray.size());
			   Double[] doubleIdlingDollarArray=new Double[IdlingDollarCountArray.size()];
			   doubleIdlingDollarArray[i-1] = Double.parseDouble(IdlingDollarCountArray.get(i-1));
			   System.out.println(" Table Value: "+doubleIdlingDollarArray[i-1]);
			   tIdlingDollarCount = tIdlingDollarCount + doubleIdlingDollarArray[i-1];
		 }
		 return tIdlingDollarCount;
	}
	
	
	
	

}
