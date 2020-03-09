package StockDataMain;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import StockData.AppTest;

public class StockMainClass  {
	public WebDriver driver;
	
	String CompanyName;
	String CompanyUpdate;
	String[] CompanyData;
	String TimeAndate;
	String driverPath = "C:\\Users\\Jarvis\\Downloads\\Compressed\\Selenium All Setup\\WebDrivers\\chromedriver_2.38.exe";
	String url = "https://www.bseindia.com/corporates/ann.aspx?expandable=3";
	String dbFile = "C:\\Users\\Jarvis\\workspace\\StockDataProject\\StockData\\DataBase\\Master.xls";
		
@BeforeTest
public void setup() throws FilloException
{
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(url);	
}

 @Test (priority=1)
 public void GetStockData() throws InterruptedException, FilloException {
	 
	  WebElement sTable = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lblann']/table"));
	  List<WebElement> RowCount = sTable.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lblann']/table/tbody/tr/td[1]"));
	  
	  int j = 1;
	  int timevar = 3;
	  for(int i = 2; i<=RowCount.size();i++)
	  {
		  j=j+1;
		  WebElement CompName = sTable.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lblann']/table/tbody/tr["+i+"]/td[1]"));
		  WebElement CompUpdate = sTable.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lblann']/table/tbody/tr["+i+"]/td[2]"));
		  WebElement TimeUpdated = sTable.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lblann']/table/tbody/tr["+timevar+"]/td"));
		  CompanyName = CompName.getText();
		  CompanyData = CompanyName.split("-",3);
		  CompanyUpdate = CompUpdate.getText();	
		  TimeAndate = TimeUpdated.getText();
		  
		  String[] DesTime = TimeAndate.split("Exchange Disseminated Time", 19);
		  
		  System.out.println("Company Name: "+CompanyData[0]);	    
		  System.out.println("Company Code: "+CompanyData[1]);
		  System.out.println("Company Update: " +CompanyUpdate);
		  System.out.println("CompanyTimeandDate: " +DesTime[1]);
		  
		  if (Select_StockData(CompanyData[0].trim()) == true){
			  System.out.println("Stock Found: "+CompanyData[0]);
			  i= i+3;
			  timevar=timevar+4;
		  }
		  else 
		  {
			  System.out.println("Stock not Found: "+CompanyData[0]);
			  //i=i+1;
			  i= i+3;
			  timevar=timevar+4;
		  }
		  insert_StockData(CompanyData[0],DesTime[1],CompanyData[1],CompanyUpdate);
	  }	  
  }

  public void insert_StockData(String companyData2,String TimeAndDate,String companyData3,String cResult) throws FilloException {
	    
	  Fillo fillo=new Fillo();
	  Connection connection=fillo.getConnection(dbFile);
	  String strQuery="INSERT INTO StockUpdate(CompanyName,TimeAndDate,CompanyCode,Result) VALUES('"+companyData2+"','"+TimeAndDate+"','"+companyData3+"','"+cResult+"')";
	  connection.executeUpdate(strQuery);
	  connection.close();	  
  }
  
  public boolean Select_StockData(String StockName) throws FilloException {	  
	  
	  try
	  {
	  Fillo fillo=new Fillo();
	  Connection connection=fillo.getConnection(dbFile);
	  String strQuery="SELECT * FROM list WHERE StockName='"+StockName+"'";
	  Recordset recordset=connection.executeQuery(strQuery);
	  
	  String SSN = null;
	  
			  if (recordset.next()) {
		          do {
		        	  System.out.println(recordset.getField("SSN"));
		        	  SSN = recordset.getField("SSN");
		              }while(recordset.next());
		          recordset.close();
				  connection.close();
		          return true;
		      }
			  else {
				  recordset.close();
				  connection.close();
				  return false;
			  }
  } 
	  catch (Exception ex) {
      //ex.printStackTrace();
      return false;
  }  
  
  }
  
  
  @AfterTest
  public void teardown()
  {
	  //driver.close();
	  //driver.quit();
  }
}
