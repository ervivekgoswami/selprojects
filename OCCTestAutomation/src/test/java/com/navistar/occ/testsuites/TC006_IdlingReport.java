package com.navistar.occ.testsuites;

import com.navistar.occ.testbase.TestBase;
import com.navistar.occ.ui.pagefactory.FleetDashBoard;
import com.navistar.occ.ui.pagefactory.IdlingReport;
import com.navistar.occ.ui.pagefactory.LogIn;
import com.navistar.occ.ui.pagefactory.OCCLandingPage;
import com.navistar.occ.ui.pagefactory.VehicleList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
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

public class TC006_IdlingReport extends TestBase {
	LogIn login;
	FleetDashBoard fleetDashBoard;
	OCCLandingPage occLandingPage;
	IdlingReport idlingReport;
	VehicleList vehiclelist;
	String loginId = "yyy1k78";
	String Password = "Bismillah10!";
	String invalidLoginId = "yyy1k781";
	String invalidPassword = "Bismillah1%";

	@BeforeClass
	public void setUP() throws IOException {
		init();
		login = new LogIn(driver);
		fleetDashBoard = new FleetDashBoard(driver);
		occLandingPage=new OCCLandingPage(driver);
		vehiclelist=new VehicleList(driver);
		idlingReport=new IdlingReport(driver);
		
		test = extent.startTest("Login Test", "This test will verify login test");
		test.log(LogStatus.PASS, "Basic set up for test is done");
	}

	@Test(priority = 0, enabled = true, description = "Test Landing Page")
	public void testLandingPage() throws InterruptedException, AWTException {
		test.log(LogStatus.PASS, "Login Test started");
		login = new LogIn(driver);
		login.loginToApplication(loginId, Password);
	
		
		//expliciteWait(driver.findElement(fleetDashBoard.logOutLink), 10);
		boolean isSuccess = fleetDashBoard.verifyFleetDashBoardPageElements();
		if (isSuccess) {
			System.out.println("Passed - Login into Oncommand Connection Portal is Successfu");
			Assert.assertTrue(true, "Login into Oncommand Connection Portal is Successful");
		} else {
			System.out.println("Failed - Login into Oncommand Connection Portal is Unsuccessfu");
			Assert.assertTrue(false, "Login into Oncommand Connection Portal is Failed");
		}
		
		
		fleetDashBoard.clickOnHome();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://evaluet.internationaldelivers.com/occwebqa/naviocc/Main/Vehicles");
		
	   // expliciteWait(By.linkText("REPORTS"), 90);
		occLandingPage.clickOnReports();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		occLandingPage.clickOnIdlingReports();
		
		//idlingReport.sendChasisDetails();
		//idlingReport.selectDDLDateRange();
		//idlingReport.selectDDLCustomerLocations();
		//idlingReport.selectDDLMakeList();
		//idlingReport.clickOnbtnIdlingReportFilter();
		int count=idlingReport.getRowsCoulumnCounts();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String totalIdleTime=idlingReport.getTotalIdleTime();
		String totalIdleMiles=idlingReport.getTotalIdleMiles();
		double totalIdleDollars=idlingReport.getTotalIdleDollars();
		
		double idleMilesFromSearch=idlingReport.getIdlingMilesCountFromSearch();
		double idleDollarFromSearch=idlingReport.getIdlingDollarCountFromSearch();
		
		
		

	}

	@AfterClass
	public void quitBrowser() {
		closeBrowser();
	}
}
