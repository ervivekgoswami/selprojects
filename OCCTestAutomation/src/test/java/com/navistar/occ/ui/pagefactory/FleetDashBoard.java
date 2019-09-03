package com.navistar.occ.ui.pagefactory;

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

public class FleetDashBoard extends TestBase {
	Logger log = Logger.getLogger(this.getClass().getSimpleName());
	WebDriver driver;

	public FleetDashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_ctl00_lblTitle\"]")
	public WebElement fleetDashBoardMsg;

	@FindBy(how = How.XPATH, using = "//*[@id=\"navNavigationBar\"]/li[1]/a")
	public WebElement homeHyperLink;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_ctl00_lnkbtnLogout\"]")
	public WebElement logOutLink;

	public boolean verifyFleetDashBoardPageElements() {
		try {
			log.info("checking if the title of message is displayed");
			boolean fleetMsgDisplayed = fleetDashBoardMsg.isDisplayed();
			boolean homeMenuDisplayed = homeHyperLink.isDisplayed();
			boolean logoutButtonDisplayed = logOutLink.isDisplayed();
			if (fleetMsgDisplayed && homeMenuDisplayed && logoutButtonDisplayed) {
				return true;
			}

			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnHome() {
		log.info("clicking on Menu");
		homeHyperLink.click();
	}

	public void clickOnLogout() {
		log.info("clicking on Logout");
		logOutLink.click();
	}

}
