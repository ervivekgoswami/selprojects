package com.navistar.occ.ui.pagefactory;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.navistar.occ.testbase.TestBase;
public class ReportsPage extends TestBase {
	Logger log = Logger.getLogger(ReportsPage.class.getName());
	WebDriver driver;

	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='accordion']/div/div[1]/a")
	public WebElement Reports;
	
	@FindBy(how = How.XPATH, using = "//*[@id='collapseTwo']/div/ul/li[1]/a")
	public WebElement DrivingReport;
	
	@FindBy(how = How.XPATH, using = "//*[@id='collapseTwo']/div/ul/li[2]/a")
	public WebElement IdlingReport;
	
	@FindBy(how = How.XPATH, using = "//*[@id='collapseTwo']/div/ul/li[3]/a")
	public WebElement IftaReport;
	
	@FindBy(how = How.XPATH, using = "//*[@id='UnitOrChassis']")
	public WebElement SearchbyUnitChasis;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ddlDateRange']")
	public WebElement TimeperiodSelector;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ddlCustomerLocations']")
	public WebElement CompanyLocation;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ddlMakeList']]")
	public WebElement VehicalMake;
	
	@FindBy(how = How.XPATH, using = "//*[@id='btnDrivingReportFilter']")
	public WebElement SearchButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='btnDrivingReportReset']")
	public WebElement ResetButton;
	
	////*[@id="ddlReportExportType_title"]/span[1]
	
	@FindBy(how = How.XPATH, using = "//*[@id='ddlReportExportType_title']")
	public WebElement ExporttoExcelDropdown;
	
	
	////*[@id="ddlReportExportType_child"]/ul/li[2]/span
	@FindBy(how = How.XPATH, using = "//*[@id='ddlReportExportType_child']/ul/li[2]/span")
	public WebElement selectExportAsPDF;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ddlReportExportType_child']/ul/li[1]/span")
	public WebElement selectExportToExcel;
	
	//*[@id="ddlReportExportType_child"]/ul/li[1]/span
	
	////*[@id="ddlReportExportType_child"]/ul/li[2]
	
	
	

	
	@FindBy(how = How.XPATH, using = "//*[@id='btnReportExport']")
	public WebElement ExportButtton;
	
	//DropDown code
	
	public int countOfTimeperiodSelector()
    {
       Select selectDropdown = new Select(TimeperiodSelector);
       //Get all the option from dropdown list and assign into List
        List<WebElement> listOptionDropdown = selectDropdown.getOptions();
       
        // Count the item dropdown list and assign into integer variable
        int dropdownCount = listOptionDropdown.size();
        log.info("countOfTimeperiodSelector -->"+dropdownCount);
        return dropdownCount;
       
    }
	
	public void iterateDropdown() throws InterruptedException{
		
		int count=countOfTimeperiodSelector();
		for(int i=0;i<count;i++){
			selectTimeperiodByIndex(i);
			
			
		}
	}
	
    
    public void selectTimeperiodByIndex(int index) throws InterruptedException
    {
       Select select = new Select(TimeperiodSelector);
       String sValue = select.getOptions().get(index).getText();
             // Printing the stored value
       log.info("Value of Drop Down Selected is "+sValue);
       select.selectByIndex(index); 
       Thread.sleep(10000);
    }


	
	//This method will select Drivingeport from the ReportsDropdown
	public void selectReports()
	
	{
		Select select=new Select(Reports);
		select.selectByVisibleText("DrivingReport");
	}
	
public void selectReports1()
	
	{
		Select select=new Select(Reports);
		select.selectByVisibleText("IdlingReport");
	}
	
public void selectReports2()

{
	Select select=new Select(Reports);
	select.selectByVisibleText("IftaReport");
}	
	
//This method will select the type of file to Export

public void ExcelDropdown()

{
	
	Select select=new Select(ExporttoExcelDropdown);
	select.selectByVisibleText("Export to EXcel");
}

public void ExcelDropdown2()

{
	
	Select select=new Select(ExporttoExcelDropdown);
	select.selectByVisibleText("Export as PDF");
}



	
	 public void print_data(){
		 
		 ////*[@id="gridContainer"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[3]
		 
		 //Get number of rows In table.
		 int Row_count = driver.findElements(By.xpath("//*[@id='gridContainer']/div[1]/table/tbody/tr")).size();
		 System.out.println("Number Of Rows = "+Row_count);
		 
		 //Get number of columns In table.
		 int Col_count = driver.findElements(By.xpath("//*[@id='gridContainer']/div[1]/table/tbody/tr[1]/td")).size();
		 System.out.println("Number Of Columns = "+Col_count);
		 
		 //divided xpath In three parts to pass Row_count and Col_count values.
		 String first_part = "//*[@id='gridContainer']/div[1]/table/tbody/tr[";
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
		   System.out.print(Table_data +"  ");   
		  }
		   System.out.println("");
		   System.out.println("");  
		 } 
		 }



	public void clickonReports() {
		Reports.click();
		
		
		
	}



	public void clickonDrivingReport() {
		DrivingReport.click();
		
	}

	public void IdlingReport() {
		IdlingReport.click();	
		
	}

	public void IftaReport() {
		IftaReport.click();
		
	}



	public void clickonSearchbyUnitChasis() {
		
		SearchbyUnitChasis.click();
		
		
	}


	
	
	public void clickonTimeperiodSelector() {
		
		TimeperiodSelector.click();
	}



	public void clickonVehicalMake() {
		VehicalMake.click();
		
	}



	public void clickonCompanyLocation() {
		CompanyLocation.click();
		
	}



	public void clickonSearchButton() {
		
		SearchButton.click();
	}



	public void clickonResetButton() {
		ResetButton.click();
		
	}
	
	public void selectExporttoExcelDropdown() {
		ExporttoExcelDropdown.click();
			
	}
	
	public void selectExporttoExcel() {
	selectExportToExcel.click();
			
	}
	
	public void clickonExportasPDF() {
		selectExportAsPDF.click();
			
	}
	
	

	public void clickonExportButtton() {
		// TODO Auto-generated method stub
		ExportButtton.click();
	}

	
	
		
	}
	
	
		
	

