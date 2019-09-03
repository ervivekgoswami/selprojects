package com.navistar.occ.pagelibrary;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.navistar.occ.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;
public class FleetDashBoard {
	WebDriver driver;
	static Logger log = Logger.getLogger(CreateAnAccount.class.getName());
	
    public By fleetDashBoardMsg = By.xpath("//*[@id=\"ctl00_ctl00_lblTitle\"]");
    public By homeHyperLink=By.xpath("//*[@id=\"navNavigationBar\"]/li[1]/a");
    public By logOutLink=By.xpath("//*[@id=\"ctl00_ctl00_lnkbtnLogout\"]");

    public FleetDashBoard(WebDriver driver){
		this.driver = driver;
	}
    
    public boolean verifyFleetDashBoardPageElements(){
		try{
			log.info("checking if the title of message is displayed");
			boolean fleetMsgDisplayed=driver.findElement(fleetDashBoardMsg).isDisplayed();
			boolean homeMenuDisplayed=driver.findElement(homeHyperLink).isDisplayed();
			boolean logoutButtonDisplayed=driver.findElement(logOutLink).isDisplayed();
			if(fleetMsgDisplayed && homeMenuDisplayed && logoutButtonDisplayed)	
			{
				return true;
			}
			
			else
			{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}
    
    public void clickOnHome(){
		log.info("clicking on Menu");
		driver.findElement(homeHyperLink).click();
	}
    public void clickOnLogout(){
		log.info("clicking on Logout");
		driver.findElement(logOutLink).click();
	}
    
}
