package StockDataMain;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class StockLists {
	

	public WebDriver driver;
	
	
	String StcokCodes;
	String StcokAlfa;
	String StcokFullForms;
	String CompanyUpdate;
	String[] CompanyData;
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
	
  @Test
  public void GetStockList() throws InterruptedException, FilloException {
	  
	  driver.findElement(By.xpath("//*[@id='wrap']/div/div[3]/div[1]/div[1]/div/h3[1]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='wrap']/div/div[3]/div[1]/div[1]/div/h3[2]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Listed Securities")).click();
	  
	  
	  WebElement SelectionFilter = driver.findElement(By.xpath("//*[@id='wrap']/div/div[3]/div[2]/div/div[2]/div/div/table"));
	  
	  Select sl = new Select(SelectionFilter.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStatus")));
	  sl.selectByValue("Active");
	  SelectionFilter.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
	  Thread.sleep(2000);
	  
	  WebElement pagination = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_gvData']/tbody/tr[1]/td/table"));
	  List<WebElement> PageCount = pagination.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_gvData']/tbody/tr[1]/td/table/tbody/tr/td"));
	  System.out.println("Rows in the Table are: "+PageCount.size());
	  
	  WebElement Stocktb = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_gvData']"));
	                                                    
	  List<WebElement> RowCount = Stocktb.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_gvData']/tbody/tr"));
	  System.out.println("Rows in the Table are: "+RowCount.size());
	 
	  for(int j=1;j<=PageCount.size()-2;j++) {
		  
		  if(j>1){
		  pagination.findElement(By.linkText(""+j+"")).click();
		  Thread.sleep(5000); 
		  }
		  
		  int i = 0;
	  for(i = 3; i<=RowCount.size()-1;i++) {
		  
		  WebElement StockCode = Stocktb.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_gvData']/tbody/tr["+i+"]/td[1]"));
		  WebElement StockALf = Stocktb.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_gvData']/tbody/tr["+i+"]/td[2]"));
		  WebElement StockFull = Stocktb.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_gvData']/tbody/tr["+i+"]/td[3]"));
		  
		  StcokCodes = StockCode.getText();
		  StcokAlfa = StockALf.getText();
		  StcokFullForms = StockFull.getText();	  
		  //System.out.println("Company Name: "+StcokCodes);	  
		  //System.out.println("Company Code: "+StcokAlfa);
		  //System.out.println("Company Update: " +StcokFullForms);
		  
		  Thread.sleep(3000);  
		  insert_StockData(StcokCodes,StcokAlfa,StcokFullForms);
	  	}	
	 }
  }
  
  public void insert_StockData(String companyData2,String companyData3,String cResult) throws FilloException {
	    
	  Fillo fillo=new Fillo();
	  Connection connection=fillo.getConnection(dbFile);
	  String strQuery="INSERT INTO StockDB(StockCode,StockAlfa,StockFullForm) VALUES('"+companyData2+"','"+companyData3+"','"+cResult+"')";
	  connection.executeUpdate(strQuery);
	  connection.close();	  
  }
}
