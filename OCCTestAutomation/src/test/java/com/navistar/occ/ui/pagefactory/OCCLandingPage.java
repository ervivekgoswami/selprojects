package com.navistar.occ.ui.pagefactory;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.navistar.occ.testbase.TestBase;
//import com.test.automation.uiAutomation.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;
public class OCCLandingPage extends TestBase{
	Logger log = Logger.getLogger(this.getClass().getSimpleName());
	WebDriver driver;
	
	public static final String text_donut_derate_condition= "Derate Condition";
	public static final String text_donut_stop_now= "Stop Now";
	public static final String text_donut_service_immediately= "Service Immediately";
	public static final String text_donut_maintenance_related= "Maintenance Realted";
	public static final String text_donut_service_soon= "Service Soon";
	public static final String text_donut_healthy_vehicles= "Healthy Vehicles";
	
	// ******** VARIABLES FOR STORING COUNT OF DONUTS ****************
	public String DONUT_ALL_VEHICLES_SCAN_COUNT;
	public String DONUT_DERATE_CONDITION_COUNT;
	public String DONUT_STOP_NOW_COUNT;
	public String DONUT_SERVICE_IMMEDIATELY_COUNT;
	public String DONUT_MAINTENANCE_RELATED_COUNT;
	public String DONUT_SERVICE_SOON_COUNT;
	public String DONUT_HEALTHY_VEHICLES_COUNT;
	
	// ******** VARIABLES FOR STORING COUNT OF TEXTS ****************
	
	public String DERATE_CONDITION_COUNT;
	public String STOP_NOW_COUNT;
	public String SERVICE_IMMEDIATELY_COUNT;
	public String MAINTENANCE_RELATED_COUNT;
	public String SERVICE_SOON_COUNT;
	public String HEALTHY_VEHICLES_COUNT;
	
	// ******** VARIABLES FOR STORING COUNT OF EVENTS ****************
	
	public String IDLE_MILES_COUNT;
	public String DC_SI_COUNT;
	public String BRAKING_EVENTS_COUNT;
	public String ACCELERATING_EVENTS_COUNT;
	
	
	
	
	public OCCLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(how = How.XPATH, using = ".//*[@id='donut-charts']/svg[2]/g/path[1]")
    public  WebElement donut_type0_derateCondition;
    
    @FindBy(how = How.CSS, using = "#donut-charts > svg:nth-child(4) > g > path:nth-child(4)")
    public  WebElement donut_type0_derateCondition_cssSelector;
    
    //
	//WebDriver driver; //*[@id="spsvcsoonCount"]

    @FindBy(how = How.XPATH, using = "//*[@id=\"spsvcsoonCount\"]")
    public  WebElement serviceSoonCount;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"spmaintenanceCount\"]")
    public  WebElement maintenanceRelatedCount;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"sphealthyCount\"]")
    public  WebElement healthyCount;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"spsvcimdeCount\"]")
    public  WebElement seriveImmediatelyCount;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"spstopnowCount\"]")
    public  WebElement stopNowCount;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"spderateCount\"]")
    public  WebElement derateConditionCount;
    
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Derate Condition')]")
    public  WebElement derateCondition;
    
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Stop Now')]")
    public  WebElement stopNow;
    
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Service Immediately')]")
    public  WebElement serviceImmediately;
    
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Service Soon')]")
    public  WebElement serviceSoon;
    
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Maintenance Related')]")
    public  WebElement maintenanceRelated;
    
    @FindBy(how = How.XPATH, using = "//*[@id='spIdleMiles']")  
    public  WebElement idleMiles;
    
    ////*[@id="spFaultTrend"]
    @FindBy(how = How.XPATH, using = "//*[@id='spFaultTrend']")  
    public  WebElement dcSITrends;
    
    ////*[@id="spBraking"]
    @FindBy(how = How.XPATH, using = "//*[@id='spBraking']")  
    public  WebElement brakingEvents;
    
    
    @FindBy(how = How.XPATH, using = "//*[@id='spAccelerating']")  
    public  WebElement acceleratingEvents;
    

    @FindBy(how = How.XPATH, using = "//*[@id=\"timechange\"]")
    public  WebElement period;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"ddlCompany\"]")
    public  WebElement ddlCompany;
    
  
    @FindBy(how = How.XPATH, using = "//*[@id=\"ddlFaultTrendPeriod\"]")
    public  WebElement faultTrendPeriod;
    //
	
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/div[6]/div[3]/div[3]/div/div/div/svg/rect")
    public  WebElement faultGraphElement;
    //
    
            
    @FindBy(how = How.XPATH, using = "//*[@id='donut-charts']/div[2]")
    public  WebElement donut_vehicle_with_scans;
    
    @FindBy(how = How.XPATH, using = "//*[@id='donut-charts']/svg[1]/g[2]/text")
    public  WebElement donut_type2_serviceImmediately_color;
    
    @FindBy(how = How.XPATH, using = "//*[@id='donut-charts']/svg[2]/g/path[2]")
    public  WebElement donut_type2_serviceImmediately;
    
  //*[@id="sidenavcollapse"]/li[6]/a
    @FindBy(how = How.XPATH, using = "//*[@id='sidenavcollapse']/li[6]/a")
    public  WebElement vehicleListMenu;
    
    @FindBy(how = How.LINK_TEXT, using = "REPORTS")
    public  WebElement reportsLink;
    
    @FindBy(how = How.CLASS_NAME, using = "spIdling")
    public  WebElement spIdling;
    
	
    //public By donut_type0_derateCondition = By.xpath("//*[@id=\"donut-charts\"]/svg[2]/g/path[1]");  ////*[@id="donut-charts"]/svg[2]/g/path[2]
    public By donut_type1_stopNow=By.xpath("//*[@id=\'donut-charts\']/svg[2]/g/path[2]");
    //public By donut_type2_serviceImmediately = By.xpath(".//*[@id='donut-charts']/svg[2]/g/path[2]");
    public By donut_type3_serviceSoon=By.xpath("//*[@id=\"donut-charts\"]/svg[2]/g/path[4]");
    public By donut_type4_mainRelated = By.xpath("//*[@id=\"donut-charts\"]/svg[2]/g/path[5]");
    public By donut_type5_healthyVehicles=By.xpath("//*[@id=\"donut-charts\"]/svg[2]/g/path[6]");
    
    public void clickOnReports()
    {
    	reportsLink.click();
    }
    
    public void clickOnIdlingReports()
    {
    	spIdling.click();
    }
    
    
    public String getServiceSoonCount()
    {
    	String serviceSoonCntText=serviceSoonCount.getText();
    	return serviceSoonCntText;
    }
    public String getMaintenanceRelatedCount()
    {
    	String maintRelatedCount=maintenanceRelatedCount.getText();
    	return maintRelatedCount;
    }
    public String getHealthyCount()
    {
    	String healthyCountText=healthyCount.getText();
    	return healthyCountText;
    }
    public String getSeriveImmediatelyCount()
    {
    	String seriveImmediatelyCountText=seriveImmediatelyCount.getText();
    	return seriveImmediatelyCountText;
    }
    public String getStopNowCount()
    {
    	String stopNowCountText=stopNowCount.getText();
    	return stopNowCountText;
    }
    public String getDerateConditionCount()
    {
    	String derateConditionCountText=derateConditionCount.getText();
    	return derateConditionCountText;
    }
    
    //**********Clicking href tags links on the page*******************************************************//
    
    public void clickDerateCondition()
    {
    	derateCondition.click();
    }
    
    public void clickStopNow()
    {
    	stopNow.click();
    }
    
    public void clickServiceImmediately()
    {
    	serviceImmediately.click();
    }
    
    public void clickMaintenanceRelated()
    {
    	maintenanceRelated.click();
    }
    
    public void clickServiceSoon()
    {
    	serviceSoon.click();
    }
    
    public void clickVehiclelist() {
		// TODO Auto-generated method stub
    	log.info("Clicking on Vehicle List Menu Item");
    	vehicleListMenu.click();
		
	}
	
    
    // ******** Selecting Dropdowns ************************
    
    public int countOfDDLCompanyDropDown()
    {
    	Select selectDropdown = new Select(ddlCompany);
    	//Get all the option from dropdown list and assign into List
        List<WebElement> listOptionDropdown = selectDropdown.getOptions();
       
        // Count the item dropdown list and assign into integer variable
        int dropdownCount = listOptionDropdown.size();
        log.info("countOfDDLCompanyDropDown -->"+dropdownCount);
        return dropdownCount;
    	
    }
    
    public void selectCompanyByIndex(int index)
    {
    	Select select = new Select(ddlCompany);
    	String sValue = select.getOptions().get(index).getText();
 		// Printing the stored value
    	log.info("Value of Drop Down Selected is "+sValue);
    	select.selectByIndex(index);    	
    }
    
    public int countOfPeriodDropDown()
    {
    	Select selectDropdown = new Select(period);
    	//Get all the option from dropdown list and assign into List
        List<WebElement> listOptionDropdown = selectDropdown.getOptions();
        
       
       
        // Count the item dropdown list and assign into integer variable
        int dropdownCount = listOptionDropdown.size();
        log.info("countOfPeriodDropDown -->"+dropdownCount);
        return dropdownCount;
    	
    }
    
    public void selectPeriodByIndex(int index)
    {
    	Select select = new Select(period);
    	select.selectByIndex(index);
    	
    }
    
    public int countOfFaultTrendPeriod()
    {
    	Select selectDropdown = new Select(faultTrendPeriod);
    	//Get all the option from dropdown list and assign into List
        List<WebElement> listOptionDropdown = selectDropdown.getOptions();
       
        // Count the item dropdown list and assign into integer variable
        int dropdownCount = listOptionDropdown.size();
        log.info("FaultTrendPeriod DropDown -->"+dropdownCount);
        return dropdownCount;
    	
    }
    
    public void selectFaultByIndex(int index)
    {
    	Select select = new Select(faultTrendPeriod);
    	select.selectByIndex(index);
    	
    }
    
    
    //************************************************************************
    
    public boolean isFaultGraphDisplayed()
    {
    	return faultGraphElement.isDisplayed();
    	
    	
    }
    
    public String getDonutValue()
    {
    	String donutVal=donut_type0_derateCondition.getText();
    	log.info(""+donutVal);
    	return donutVal;
    }
    
    
    //Select select = new Select(driver.findElement(By.xpath(".//*[@id='day']")));
    
	
    public boolean verifyOnCommandConnectionDashBoardPageElements() {
		try {
			log.info("checking if the title of message is displayed");
			boolean serviceSoonCountDisplayed = serviceSoonCount.isDisplayed();
			
			boolean derateConditionDisplayed=derateCondition.isDisplayed();
			boolean stopNowDisplayed=stopNow.isDisplayed();
			boolean serviceImmediatelyDisplayed=serviceImmediately.isDisplayed();
			boolean serviceSoonDisplayed=serviceSoon.isDisplayed();
			boolean maintenanceRelatedDisplayed=maintenanceRelated.isDisplayed();
			
			
			if (serviceSoonDisplayed && derateConditionDisplayed && stopNowDisplayed && serviceImmediatelyDisplayed && serviceSoonDisplayed && maintenanceRelatedDisplayed) {
				return true;
			}

			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
    // ******************
    
    public String getDonutTotalVehicleScans()
    {
    	String value = donut_vehicle_with_scans.getText();
    	log.info("getDonutTotalVehicleScans "+value);
    	String val =value.split("\n")[1];
 		log.info("getDonutTotalVehicleScans "+val);
 		return value;
    }
    
    public String getDonutValueOfLocator(String donutPixel)
    {
    	WebElement image = null;
    	if(donutPixel.equalsIgnoreCase(text_donut_derate_condition))
    	{
    		//#donut-charts > svg:nth-child(4) > g > path:nth-child(4)
    		image=driver.findElement(By.cssSelector("#donut-charts > svg:nth-child(4) > g > path:nth-child(4)"));
    	}
    	if(donutPixel.equalsIgnoreCase(text_donut_stop_now))
    	{
    		//#donut-charts > svg:nth-child(4) > g > path:nth-child(4)
    		image=driver.findElement(By.cssSelector("#donut-charts > svg:nth-child(4) > g > path:nth-child(5)"));
    	}
    	if(donutPixel.equalsIgnoreCase(text_donut_service_immediately))
    	{
    		//#donut-charts > svg:nth-child(4) > g > path:nth-child(4)
    		image=driver.findElement(By.cssSelector("#donut-charts > svg:nth-child(4) > g > path:nth-child(6)"));
    	}
    	if(donutPixel.equalsIgnoreCase(text_donut_service_soon))
    	{
    		//#donut-charts > svg:nth-child(4) > g > path:nth-child(4)
    		image=driver.findElement(By.cssSelector("#donut-charts > svg:nth-child(4) > g > path:nth-child(7)"));
    	}
    	if(donutPixel.equalsIgnoreCase(text_donut_maintenance_related))
    	{
    		//#donut-charts > svg:nth-child(4) > g > path:nth-child(4)
    		image=driver.findElement(By.cssSelector("#donut-charts > svg:nth-child(4) > g > path:nth-child(8)"));
    	}
    	if(donutPixel.equalsIgnoreCase(text_donut_healthy_vehicles))
    	{
    		//#donut-charts > svg:nth-child(4) > g > path:nth-child(4)
    		image=driver.findElement(By.cssSelector("#donut-charts > svg:nth-child(4) > g > path:nth-child(9)"));
    	}
       	//WebElement image=driver.findElement(By.cssSelector("#donut-charts > svg:nth-child(4) > g > path:nth-child(8)"));    	
    	Actions toolAct = new Actions(driver);
    	toolAct.moveToElement(image).build().perform();
 		String value = donut_vehicle_with_scans.getText().split("\n")[1];;
 		log.info("Donut value of "+donutPixel +" : "+value);
 		return value;
    }
    
    // ************** GETTING COUNTS OF ELEMENTS ****************************
    
    public String getIdleMilesCount()
    {
    	String value=idleMiles.getText();
    	return value;
    }
    
    public String getDISICount()
    {
    	String value=dcSITrends.getText();
    	return value;
    }
    
    public String getBrakingEventsCount()
    {
    	String value=brakingEvents.getText();
    	return value;
    }
    
    public String getAccelaratingEventsCount()
    {
    	String value=acceleratingEvents.getText();
    	return value;
    }
    
    
    //**************** GETTING COUNTS OF ALL ELEMEMTS DISPLAYED ON LANDING PAGE *******************
    
    public void getCountsOfLandingPage()
    {
    	// ******** VARIABLES FOR STORING COUNT OF DONUTS ****************
    	
    	DONUT_ALL_VEHICLES_SCAN_COUNT=getDonutTotalVehicleScans();
    	DONUT_DERATE_CONDITION_COUNT=getDonutValueOfLocator(text_donut_derate_condition);
    	DONUT_STOP_NOW_COUNT=getDonutValueOfLocator(text_donut_stop_now);
    	DONUT_SERVICE_IMMEDIATELY_COUNT=getDonutValueOfLocator(text_donut_service_immediately);
    	DONUT_MAINTENANCE_RELATED_COUNT=getDonutValueOfLocator(text_donut_maintenance_related);
    	DONUT_SERVICE_SOON_COUNT=getDonutValueOfLocator(text_donut_service_soon);
    	DONUT_HEALTHY_VEHICLES_COUNT=getDonutValueOfLocator(text_donut_healthy_vehicles);
    	
    	// ******** VARIABLES FOR STORING COUNT OF TEXTS ****************
    	
    	DERATE_CONDITION_COUNT=getDerateConditionCount();
    	STOP_NOW_COUNT=getStopNowCount();
    	SERVICE_IMMEDIATELY_COUNT=getSeriveImmediatelyCount();
    	MAINTENANCE_RELATED_COUNT=getMaintenanceRelatedCount();
    	SERVICE_SOON_COUNT=getServiceSoonCount();
    	HEALTHY_VEHICLES_COUNT=getHealthyCount();
    	
    	// ******** VARIABLES FOR STORING COUNT OF EVENTS ****************
    	
    	IDLE_MILES_COUNT=getIdleMilesCount();
    	DC_SI_COUNT=getDISICount();
    	BRAKING_EVENTS_COUNT=getBrakingEventsCount();
    	ACCELERATING_EVENTS_COUNT=getAccelaratingEventsCount();   	
    	
    	
    	log.info("*****************************************************************");
    	log.info(DONUT_ALL_VEHICLES_SCAN_COUNT);
    	log.info(DONUT_DERATE_CONDITION_COUNT);
    	log.info(DONUT_STOP_NOW_COUNT);
    	log.info(DONUT_SERVICE_IMMEDIATELY_COUNT);
    	log.info(DONUT_MAINTENANCE_RELATED_COUNT);
    	log.info(DONUT_SERVICE_SOON_COUNT);
    	log.info(DONUT_HEALTHY_VEHICLES_COUNT);
    	
    	log.info(DERATE_CONDITION_COUNT);
    	log.info(STOP_NOW_COUNT);
    	log.info(SERVICE_IMMEDIATELY_COUNT);
    	log.info(MAINTENANCE_RELATED_COUNT);
    	log.info(SERVICE_SOON_COUNT);
    	log.info(HEALTHY_VEHICLES_COUNT);
    	
    	log.info(IDLE_MILES_COUNT);
    	log.info(DC_SI_COUNT);
    	log.info(BRAKING_EVENTS_COUNT);
    	log.info(ACCELERATING_EVENTS_COUNT);
    	
    	log.info("*****************************************************************");
    }
	
	

}
