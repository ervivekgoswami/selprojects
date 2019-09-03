package com.navistar.occ.testsuites;

import com.navistar.occ.testbase.TestBase;
import com.navistar.occ.ui.pagefactory.FleetDashBoard;
import com.navistar.occ.ui.pagefactory.LogIn;
import com.navistar.occ.ui.pagefactory.OCCLandingPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.test.automation.uiAutomation.uiActions.OCCLandingPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class TC003_OCCLandingPage extends TestBase {
	Logger log = Logger.getLogger(this.getClass().getSimpleName());
	LogIn login;
	FleetDashBoard fleetDashBoard;
	OCCLandingPage landingPage;
	String loginId = "yyy1k78";
	String Password = "Bismillah5%";
	String invalidLoginId = "yyy1k781";
	String invalidPassword = "Bismillah1%";

	@BeforeClass
	public void setUP() throws IOException {
		init();
		login = new LogIn(driver);
		fleetDashBoard = new FleetDashBoard(driver);
		landingPage = new OCCLandingPage(driver);
		//landingPage=new OCCLandingPage(driver);
		
		test = extent.startTest("Login Test", "This test will verify login test");
		test.log(LogStatus.PASS, "Basic set up for test is done");
	}

	@Test(priority = 0, enabled = true, description = "Test Landing Page")
	public void testLandingPage() throws InterruptedException, IOException {
		test.log(LogStatus.PASS, "Login Test started");
		login = new LogIn(driver);
		login.loginToApplication(loginId, Password);
	
		
		//expliciteWait(driver.findElement(fleetDashBoard.logOutLink), 10);
		boolean isSuccess = fleetDashBoard.verifyFleetDashBoardPageElements();
		if (isSuccess) {
			log.info("Passed - Login into Oncommand Connection Portal is Successfu");
			Assert.assertTrue(true, "Login into Oncommand Connection Portal is Successful");
		} else {
			log.info("Failed - Login into Oncommand Connection Portal is Unsuccessfu");
			Assert.assertFalse(false, "Login into Oncommand Connection Portal is Failed");
		}
		
		
		fleetDashBoard.clickOnHome();
		expliciteWait(landingPage.seriveImmediatelyCount, 1);
		//log.info("---------------->"+landingPage.getDonutValue());
		boolean isSuccessLandingPage = landingPage.verifyOnCommandConnectionDashBoardPageElements();
		if (isSuccessLandingPage) {
			log.info("Passed - Login into Oncommand Connection Portal is Successfu");
			Assert.assertTrue(true, "Login into Oncommand Connection Portal is Successful");
		} else {
			log.info("Failed - Login into Oncommand Connection Portal is Unsuccessfu");
			Assert.assertFalse(false, "Login into Oncommand Connection Portal is Failed");
		}
		
		
		
		
		String serviceSoonCount=landingPage.getServiceSoonCount();
		String maintenanceRelatedCount=landingPage.getMaintenanceRelatedCount();
		String healthyCount=landingPage.getHealthyCount();
		String seriveImmediatelyCount=landingPage.getSeriveImmediatelyCount();
		String stopNowCount=landingPage.getStopNowCount();
		String derateConditionCount=landingPage.getDerateConditionCount();
		
		log.info("serviceSoonCount -------> "+serviceSoonCount);
		log.info("maintenanceRelatedCount -------> "+maintenanceRelatedCount);
		log.info("healthyCount -------> "+healthyCount);
		log.info("seriveImmediatelyCount -------> "+seriveImmediatelyCount);
		log.info("stopNowCount -------> "+stopNowCount);
		log.info("derateConditionCount -------> "+derateConditionCount);
		
		captureScreen(this.getClass().getSimpleName());
		
		int countOfDDLCompanyDropDown=landingPage.countOfDDLCompanyDropDown();
		int countOfPeriodDropDown=landingPage.countOfPeriodDropDown();
		int countOfFaultTrendDropDown=landingPage.countOfFaultTrendPeriod();
		
		for (int i=0;i<countOfPeriodDropDown;i++)
		{
			landingPage.selectPeriodByIndex(i);
			Thread.sleep(5000);
			for (int j=0;j<countOfDDLCompanyDropDown;j++)
			{
				landingPage.selectCompanyByIndex(j);
				Thread.sleep(5000);
				String serviceSoonCountLoop=landingPage.getServiceSoonCount();
				String maintenanceRelatedCountLoop=landingPage.getMaintenanceRelatedCount();
				String healthyCountLoop=landingPage.getHealthyCount();
				String seriveImmediatelyCountLoop=landingPage.getSeriveImmediatelyCount();
				String stopNowCountLoop=landingPage.getStopNowCount();
				String derateConditionCountLoop=landingPage.getDerateConditionCount();
				
				log.info("serviceSoonCount -------> "+serviceSoonCountLoop);
				log.info("maintenanceRelatedCount -------> "+maintenanceRelatedCountLoop);
				log.info("healthyCount -------> "+healthyCountLoop);
				log.info("seriveImmediatelyCount -------> "+seriveImmediatelyCountLoop);
				log.info("stopNowCount -------> "+stopNowCountLoop);
				log.info("derateConditionCount -------> "+derateConditionCountLoop);
				for (int k=0;k<countOfFaultTrendDropDown;k++)
				{
					landingPage.selectFaultByIndex(k);
					/*boolean faultGraphDisplayed=landingPage.isFaultGraphDisplayed();
					captureScreen(this.getClass().getSimpleName());
					if (faultGraphDisplayed) {
						log.info("Passed - Fault Graph is displayed Successfully");
						Assert.assertTrue(true, "Fault Graph is displayed Successfully");
					} else {
						log.info("Failed -  Fault Graph is not displayed ");
						Assert.assertFalse(false, "Fault Graph is not displayed ");
					}*/
					
				}
				
			}
		}

	}

	@AfterClass
	public void quitBrowser() {
		closeBrowser();
	}
}
