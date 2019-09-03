package com.navistar.occ.ui.pagefactory;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.navistar.occ.testbase.TestBase;
public class VehicleList extends TestBase {
	Logger log = Logger.getLogger(VehicleList.class.getName());
	WebDriver driver;

	public VehicleList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getUnitFromTableData() {
		return unitFromTableData;
	}

	public void setUnitFromTableData(String unitFromTableData) {
		this.unitFromTableData = unitFromTableData;
	}

	public String getUnitXpathFromTableData() {
		return unitXpathFromTableData;
	}

	public void setUnitXpathFromTableData(String unitXpathFromTableData) {
		this.unitXpathFromTableData = unitXpathFromTableData;
	}

	public String getChasisFromTableData() {
		return chasisFromTableData;
	}

	public void setChasisFromTableData(String chasisFromTableData) {
		this.chasisFromTableData = chasisFromTableData;
	}

	public String getChasisXpathFromTableData() {
		return chasisXpathFromTableData;
	}

	public void setChasisXpathFromTableData(String chasisXpathFromTableData) {
		this.chasisXpathFromTableData = chasisXpathFromTableData;
	}

	public String getTimeFromTableData() {
		return timeFromTableData;
	}

	public void setTimeFromTableData(String timeFromTableData) {
		this.timeFromTableData = timeFromTableData;
	}

	public String getTimeXpathFromTableData() {
		return timeXpathFromTableData;
	}

	public void setTimeXpathFromTableData(String timeXpathFromTableData) {
		this.timeXpathFromTableData = timeXpathFromTableData;
	}

	public String getCustomerFromTableData() {
		return customerFromTableData;
	}

	public void setCustomerFromTableData(String customerFromTableData) {
		this.customerFromTableData = customerFromTableData;
	}

	public String getCustomerXpathFromTableData() {
		return customerXpathFromTableData;
	}

	public void setCustomerXpathFromTableData(String customerXpathFromTableData) {
		this.customerXpathFromTableData = customerXpathFromTableData;
	}

	public String getLocationFromTableData() {
		return locationFromTableData;
	}

	public void setLocationFromTableData(String locationFromTableData) {
		this.locationFromTableData = locationFromTableData;
	}

	public String getLocationXpathTableData() {
		return locationXpathTableData;
	}

	public void setLocationXpathTableData(String locationXpathTableData) {
		this.locationXpathTableData = locationXpathTableData;
	}

	public String getCountsFromTableData() {
		return countsFromTableData;
	}

	public void setCountsFromTableData(String countsFromTableData) {
		this.countsFromTableData = countsFromTableData;
	}

	public String getCountsXpathFromTableData() {
		return countsXpathFromTableData;
	}

	public void setCountsXpathFromTableData(String countsXpathFromTableData) {
		this.countsXpathFromTableData = countsXpathFromTableData;
	}

	public String getHrFromTableData() {
		return hrFromTableData;
	}

	public void setHrFromTableData(String hrFromTableData) {
		this.hrFromTableData = hrFromTableData;
	}

	public String getHrXpathFromTableData() {
		return hrXpathFromTableData;
	}

	public void setHrXpathFromTableData(String hrXpathFromTableData) {
		this.hrXpathFromTableData = hrXpathFromTableData;
	}

	public String unitFromTableData;
	public String unitXpathFromTableData;
	public String chasisFromTableData;
	public String chasisXpathFromTableData;
	public String timeFromTableData;
	public String timeXpathFromTableData;
	public String customerFromTableData;
	public String customerXpathFromTableData;
	public String locationFromTableData;
	public String locationXpathTableData;
	public String countsFromTableData;
	public String countsXpathFromTableData;
	public String hrFromTableData;
	public String hrXpathFromTableData;
	
	
	public VehicleList(WebDriver driver,String unit, String unitXpath,String chasis,String chasisXpath, String time, String timeXpathFromTableData,String customer, String customerXpathFromTableData,String location,String locationXpath,String counts, String countsXpath,String hr,String hrXpath)
	{   
		this.driver=driver;
		this.unitFromTableData=unit;
		this.unitXpathFromTableData=unitXpath;
		this.chasisFromTableData=chasis;
		this.chasisXpathFromTableData=chasisXpath;
		this.timeFromTableData=time;
		this.timeXpathFromTableData=timeXpathFromTableData;
		this.customerFromTableData=customer;
		this.customerXpathFromTableData=customerXpathFromTableData;
		this.locationFromTableData=location;
		this.locationXpathTableData=locationXpath;
		this.countsFromTableData=counts;
		this.countsXpathFromTableData=countsXpath;
		this.hrFromTableData=hr;
		this.hrXpathFromTableData=hrXpath;
		
	}
	
	//@FindBy(xpath = "//*[@id='SubmitLogin']")

	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
	public WebElement loginId;

	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "/html/body/center/div/form/center/table/tbody/tr[3]/td[2]/input")
	public WebElement login;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"divSearch\"]/div[1]/div/div[1]/div[1]/div/div/button")
	public WebElement companylocation;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ALEXAXXXX\"]")
	public WebElement Alexacheckbox;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"UnitOrChassis\"]")
	public WebElement unit;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ddlZoneList\"]")
	public WebElement ZoneDropdown;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ddlMakeList\"]")
	public WebElement Vehiclemake;
	
	//Fault severity filter conditions
	@FindBy(how = How.XPATH, using ="//*[@id='cbDerate']")
	public WebElement Deratecondition;
	
	@FindBy(how = How.XPATH, using ="//*[@id='cbSN']")
	public WebElement Stopnow;
	
	@FindBy(how = How.XPATH, using ="//*[@id='cbSI']")
	public WebElement ServiceImmediatly;
	
	@FindBy(how = How.XPATH, using ="//*[@id='cbSS']")
	public WebElement Servicesoon;
	
	@FindBy(how = How.XPATH, using ="//*[@id='cbMR']")
	public WebElement maintenancerelated;
	
	@FindBy(how = How.XPATH, using ="//*[@id='cbAutoRefresh']")
	public WebElement autorefreshevery5min;
	
	//xpath for vehicle scan list
	
	 @FindBy(how = How.XPATH, using = "//*[contains(text(),'2032P')]")
	    public  WebElement unit2032P; 
	 
	// @FindBy(how = How.XPATH, using = "//*[contains(text(),'1935')]")
	    public  WebElement unit1935; 
	
	
	//This method will select International from the Dropdown
	public void selectVehicleMake()
	
	{
		Select select=new Select(Vehiclemake);
		List<WebElement> dd = select.getOptions();
		 System.out.println(dd.size());
		 for (int j = 0; j < dd.size(); j++) {
		        log.info("Vehicle Make ---> "+dd.get(j).getText());
		    }
		select.selectByVisibleText("International");
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ddlEngineFamily\"]")
	public WebElement Enginefamily;
	
	//Fault Severity filters
	
	@FindBy(how = How.XPATH, using = "//*[@id='cbSI']")
	public WebElement serviceimeediatly;
	
	//*[@id="btnApply"]
	@FindBy(how = How.XPATH, using = "//*[@id='btnApply']")
	public WebElement searchbutton;
	
	/**
	 * This method will enter email address to create an account text box. In Login
	 * Page
	 * 
	 * @param emailAddress
	 */
	public void enterLoginId(String loginIdValue) {
		log.info("entering login id of the account");
		loginId.sendKeys(loginIdValue);
	}

	public void enterPassword(String passwordValue) {
		log.info("entering password to login into application");
		password.sendKeys(passwordValue);
	}

	public void clickonLogInToAccount() {
		log.info("clicking on sign in button");
		login.click();
	}
	
	public void clickonCompanyLocation() {
		companylocation.click();
	
	}
	
	public void clickonAlexacheckbox() {
		Alexacheckbox.isSelected();
	
	}
	
	public void clickonunit() {
		unit.isSelected();
	
	}
	
	public void clickonZoneDropdown() {
		ZoneDropdown.click();
	
	}
	
	public void clickonVehiclemake() {
		Vehiclemake.click();
	
	}
	
	public void clickonEnginefamily() {
		Enginefamily.click();
	
	}
	
	public void clickonserviceimeediatly(){
		if(serviceimeediatly.isSelected() &&(maintenancerelated.isSelected() && (Stopnow.isSelected())) )
		{
			clickonsearchbutton();
		}
	
	}
	
	public void clickonsearchbutton() {
		searchbutton.click();
	
	}
	
	public void clickonDeratecondition() {
		Deratecondition.click();
	
	}
	
	public void clickonStopnow() {
		Stopnow.click();
	
	}

	public void clickonServiceImmediatly() {
		ServiceImmediatly.click();
	
	}
	
	public void clickonServicesoon() {
		Servicesoon.click();
	
	}
	
	public void clickonmaintenancerelated() {
		maintenancerelated.click();
	
	}
	
	public void clickonautorefreshevery5min() {
		autorefreshevery5min.click();
	
	}
	
	public void clickonunit2032P() {
		unit2032P.click();
	
	}
	
	
	
	
	
	/**
	 * This Method is used for login to application
	 */

	public void loginToApplication() {
		enterLoginId("yyy1k78");
		enterPassword("Bismillah5%");
		clickonLogInToAccount();
	}

	public void loginToApplication(String loginId, String Password) {
		System.out.println("Inside login application method");
		enterLoginId(loginId);
		enterPassword(Password);
		clickonLogInToAccount();
	}

	public void logout() {
		try {
			boolean isdisplayed = loginId.isDisplayed();
			if (isdisplayed) {
				loginId.click();
			}
		} catch (Exception e) {
			Assert.assertTrue(false, "sign out buttom is not displayed");
		}
	}
	
	public void openLinksinNewTab() throws InterruptedException, AWTException
	{
	
		VehicleList vehList=getRowFromTableDataSearch();	
		
        openVehicleDetails(vehList);	
		
		openUnit(vehList);	
		
		openHealthReportOfVehicle(vehList);
		
		openCurrentAddressofVehicle(vehList);		
				
		
		
		
	}
	
	public void openVehicleDetails(VehicleList vehList) throws AWTException, InterruptedException	{	
	    String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL+"t");
	    //driver.findElement(By.tagName("body")).sendKeys(selectLinkOpeninNewTab);		
	     
	    //Set<String> windows = driver.getWindowHandles();
	    //ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    //driver.switchTo().window(tabs.get(1)); //switches to new tab
	    driver.findElement(By.partialLinkText(vehList.getChasisFromTableData())).click();
	    //driver.switchTo().window(tabs.get(0)); // switch back to main screen 
		   
	}
	
   public void openHealthReportOfVehicle(VehicleList vehList) throws InterruptedException, AWTException	{	
	   
	    String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL+"t");
	    driver.findElement(By.tagName("body")).sendKeys(selectLinkOpeninNewTab);		
	     
	    Set<String> windows = driver.getWindowHandles();
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    int tabSise=tabs.size();
	    driver.switchTo().window(tabs.get(tabSise-1)); //switches to new tab
	    log.info("Opening in new tab"+vehList.getHrXpathFromTableData());
	    driver.get(vehList.getHrXpathFromTableData());
	    Thread.sleep(25000);
	    driver.switchTo().window(tabs.get(0)); // switch back to main screen  
	   
	}
	
	public void openUnit(VehicleList vehList)
	{      
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(0));
		    log.info(" ----> "+vehList.getUnitFromTableData());
		    log.info(" ----> "+vehList.getUnitXpathFromTableData());
		    driver.findElement(By.xpath("//*[contains(text(),'"+vehList.getUnitFromTableData()+"')]")).click();
		    //driver.findElement(By.xpath(vehList.getUnitXpathFromTableData())).click();  

	}
	
	public void openCurrentAddressofVehicle(VehicleList vehList) throws AWTException, InterruptedException
	{
		    String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL+"t");
		    driver.findElement(By.tagName("body")).sendKeys(selectLinkOpeninNewTab);		
		     
		    Set<String> windows = driver.getWindowHandles();
		    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    int tabSise=tabs.size();
		   
		    driver.switchTo().window(tabs.get(tabSise-1)); //switches to new tab
		    log.info("Opening in new tab"+vehList.getLocationXpathTableData());
		    driver.get(vehList.getLocationXpathTableData());
		    Thread.sleep(25000);
		    driver.switchTo().window(tabs.get(0)); // switch back to main screen 
		    

/*		   //To open a new tab         
		   Robot r = new Robot();                          
		   r.keyPress(KeyEvent.VK_CONTROL); 
		   r.keyPress(KeyEvent.VK_T); 
		   r.keyRelease(KeyEvent.VK_CONTROL); 
		   r.keyRelease(KeyEvent.VK_T);    
		   //To switch to the new tab
		   //To navigate to new link/URL in 2nd new tab
		   //driver.get(vehList.getHrXpathFromTableData());
*/		  
		 
		   //driver.switchTo().window(winHandleBefore);
		   
		   
	
	        
	}
	
	public VehicleList getRowFromTableDataSearch()
	{
		VehicleList rowData=null;

		 
		 //Get number of rows In table.
		 int Row_count = driver.findElements(By.xpath("//*[@id='gridContainer']/div/div[6]/div/div/div[1]/div/table/tbody/tr")).size();
		 log.info("**********************************************************");
		 log.info("Number Of Rows = "+Row_count);
		 
		 //Get number of columns In table.
		 int Col_count = driver.findElements(By.xpath("//*[@id='gridContainer']/div/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td")).size();
		 log.info("Number Of Columns = "+Col_count);
		 
		 //divided xpath In three parts to pass Row_count and Col_count values.
		 String first_part = "//*[@id='gridContainer']/div/div[6]/div/div/div[1]/div/table/tbody/tr[";
		 String second_part = "]/td[";
		 String third_part = "]";
		 
		 //Used for loop for number of rows.
		 for (int i=1; i<=1; i++){
		  //Used for loop for number of columns.
		  for(int j=1; j<=Col_count; j++){
		   //Prepared final xpath of specific cell as per values of i and j.
		   String final_xpath = first_part+i+second_part+j+third_part;
		   //Will retrieve value from located cell and print It.
		   String colVal = driver.findElement(By.xpath(final_xpath)).getText();
		   
		   
		   if(j==1)
		   {	 unitFromTableData=colVal;
		         String attrVal=driver.findElement(By.xpath(final_xpath)).getAttribute("href");
				 unitXpathFromTableData=final_xpath;				 
		   }
		   if(j==2)
		   {	 chasisFromTableData=colVal;
		         chasisXpathFromTableData=final_xpath;				 
		   }
		   if(j==3)
		   {	 timeFromTableData=colVal;
		         timeXpathFromTableData=final_xpath;				 
		   }
		   if(j==4)
		   {	 customerFromTableData=colVal;
		   customerXpathFromTableData=final_xpath;				 
		   }
		   
		   if(j==5)
		   {	 locationFromTableData=colVal;
		         String attrVal=driver.findElement(By.xpath(final_xpath+"//a")).getAttribute("href");
		         locationXpathTableData=attrVal;				 
		   }
		   if(j==6)
		   {	 countsFromTableData=colVal;
		         countsXpathFromTableData=final_xpath;				 
		   }
		   if(j==7)
		   {	 hrFromTableData=colVal;
		   String attrVal=driver.findElement(By.xpath(final_xpath+"//a")).getAttribute("href");
		   hrXpathFromTableData=attrVal;				 
		   }
		   
		   
		   log.info(colVal +"  ");   
		  }
		  log.info("");
		  log.info("");  
		 } 
		 
		 log.info("**********************************************************");
			
		 log.info("...."+unitFromTableData);
		 log.info("...."+unitXpathFromTableData);
		 log.info("...."+chasisFromTableData);
		 log.info("...."+chasisXpathFromTableData);
		 log.info("...."+timeFromTableData);
		 log.info("...."+timeXpathFromTableData);
		 log.info("...."+customerFromTableData);
		 log.info("...."+customerXpathFromTableData);
		 log.info("...."+locationFromTableData);
		 log.info("...."+locationXpathTableData);
		 log.info("...."+countsFromTableData);
		 log.info("...."+countsXpathFromTableData);
		 log.info("...."+hrFromTableData);
		 log.info("...."+hrXpathFromTableData);
		 
		 rowData=new VehicleList(driver, unitFromTableData, unitXpathFromTableData, chasisFromTableData, chasisXpathFromTableData, timeFromTableData, 
				 timeXpathFromTableData, customerFromTableData, customerXpathFromTableData, locationFromTableData, locationXpathTableData, countsFromTableData, 
				 countsXpathFromTableData, hrFromTableData, hrXpathFromTableData);
		 return rowData;
		 
		 }
	 public void getTableDataOfSearch(){
		 
		 //Get number of rows In table.
		 int Row_count = driver.findElements(By.xpath("//*[@id='gridContainer']/div/div[6]/div/div/div[1]/div/table/tbody/tr")).size();
		 log.info("**********************************************************");
		 log.info("Number Of Rows = "+Row_count);
		 
		 //Get number of columns In table.
		 int Col_count = driver.findElements(By.xpath("//*[@id='gridContainer']/div/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td")).size();
		 log.info("Number Of Columns = "+Col_count);
		 
		 //divided xpath In three parts to pass Row_count and Col_count values.
		 String first_part = "//*[@id='gridContainer']/div/div[6]/div/div/div[1]/div/table/tbody/tr[";
		 String second_part = "]/td[";
		 String third_part = "]";
		 
		 //Used for loop for number of rows.
		 for (int i=1; i<=Row_count; i++){
		  //Used for loop for number of columns.
		  for(int j=1; j<=Col_count; j++){
		   //Prepared final xpath of specific cell as per values of i and j.
		   String final_xpath = first_part+i+second_part+j+third_part;
		   //Will retrieve value from located cell and print It.
		   String Table_data = driver.findElement(By.xpath(final_xpath)).getText();
		   log.info(Table_data +"  ");   
		  }
		  log.info("");
		  log.info("");  
		 } 
		 
		 log.info("**********************************************************");
		 
		 }
	
		
	}

