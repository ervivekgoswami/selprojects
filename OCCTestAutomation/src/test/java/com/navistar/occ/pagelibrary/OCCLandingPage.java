package com.navistar.occ.pagelibrary;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.navistar.occ.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;
public class OCCLandingPage extends BasePageFactory{
	public static OCCLandingPage occLandingPage;
	
	
    public OCCLandingPage()
    {
        PageFactory.initElements(driver, this);
        occLandingPage = this;
    }
    public static void NavigateHere()
    {
    	occLandingPage = new OCCLandingPage();
    }
    
    public static void implictWait()
    {
    	
    }
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"donut-charts\"]/svg[2]/g/path[1]")
    public  WebElement donut_type0_derateCondition;
    
    @FindBy(how = How.CSS, using = "#donut-charts > svg:nth-child(4) > g > path:nth-child(4)")
    public  WebElement donut_type0_derateCondition_cssSelector;
    
    //
	//WebDriver driver;
	static Logger log = Logger.getLogger(CreateAnAccount.class.getName());
	
	
    //public By donut_type0_derateCondition = By.xpath("//*[@id=\"donut-charts\"]/svg[2]/g/path[1]");
    public By donut_type1_stopNow=By.xpath("//*[@id=\"donut-charts\"]/svg[2]/g/path[2]");
    public By donut_type2_serviceImmediately = By.xpath("//*[@id=\"donut-charts\"]/svg[2]/g/path[3]");
    public By donut_type3_serviceSoon=By.xpath("//*[@id=\"donut-charts\"]/svg[2]/g/path[4]");
    public By donut_type4_mainRelated = By.xpath("//*[@id=\"donut-charts\"]/svg[2]/g/path[5]");
    public By donut_type5_healthyVehicles=By.xpath("//*[@id=\"donut-charts\"]/svg[2]/g/path[6]");
	public OCCLandingPage(WebDriver driver){
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public static String getDerateConditionCount(){
		log.info("OCCLandingPage login and accessing the dash board elements");
		//boolean displayed=driver.findElement(donut_type0_derateCondition).isDisplayed();
		/*boolean displayed=occLandingPage.donut_type0_derateCondition
		System.out.println("displayed....."+displayed);*/
		String value=occLandingPage.donut_type0_derateCondition_cssSelector.getText();
		return value;
	}
	
	
	

}
