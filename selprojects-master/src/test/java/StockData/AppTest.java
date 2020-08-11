package StockData;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;

import StockDataMain.StockMainClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

/**
 * Unit test for simple App.
 */
public class AppTest
{

	public WebDriver driver;
	String CompanyName;
	String CompanyUpdate;
	String[] CompanyData;
	String TimeAndate;
	String driverPath = "C:\\Users\\Jarvis\\Downloads\\Compressed\\Selenium All Setup\\WebDrivers\\chromedriver_2.38.exe";
	String urlA = "https://www.bseindia.com/corporates/ann.aspx?expandable=3";
	String dbFile = "C:\\Users\\Jarvis\\workspace\\StockDataProject\\StockData\\DataBase\\Master.xls";
	
	
	public AppTest(){
		System.setProperty("webdriver.chrome.driver", driverPath);
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get(urlA);	
	  }

	public WebDriver getdriver(){
	    if (driver == null){
	      driver = new ChromeDriver();
	      return driver;
	    }else{
	      return driver;
	    }
	  }
    @Test
	public void testApp()
    {
        System.out.println("Opening The TestApp");
        final long timeInterval = 6000;
        Runnable runnable = new Runnable(){
        public void run()
        {
        	while (true)
        	{try 
        	{
        		StockMainClass stm = new StockMainClass();
				stm.GetStockData();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FilloException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
        	
        }
        };
        Thread thread = new Thread(runnable);
    	thread.start();
       }
    }
        

