package com.navistar.occ.testsuites;

import com.navistar.occ.testbase.TestBase;
import com.navistar.occ.ui.pagefactory.FleetDashBoard;
import com.navistar.occ.ui.pagefactory.LogIn;
import com.navistar.occ.ui.pagefactory.OCCLandingPage;
import com.navistar.occ.ui.pagefactory.ReportsPage;
import com.navistar.occ.ui.pagefactory.VehicleList;

import org.openqa.selenium.By;
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

public class TC005_Reports extends TestBase {
	LogIn login;
	FleetDashBoard fleetDashBoard;
	OCCLandingPage landingPage;
	//VehicleList vehiclelist;
	ReportsPage reportsPage;
	String loginId = "yyy1k78";
	String Password = "Bismillah10!";
	String invalidLoginId = "yyy1k781";
	String invalidPassword = "Bismillah1%";

	@BeforeClass
	public void setUP() throws IOException {
		init();
		login = new LogIn(driver);
		fleetDashBoard = new FleetDashBoard(driver);
		landingPage=new OCCLandingPage(driver);
		//vehiclelist=new VehicleList(driver);
		reportsPage=new ReportsPage(driver);
		
		
		
		test = extent.startTest("Login Test", "This test will verify login test");
		test.log(LogStatus.PASS, "Basic set up for test is done");
	}

	@Test(priority = 0, enabled = true, description = "Test Landing Page")
	public void testLandingPage() throws InterruptedException {
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
		
		System.out.println("Clicking on logout to complete the testcase");
		fleetDashBoard.clickOnHome();
		
		System.out.println("Clicking on logout to complete the testcase");
		landingPage.clickVehiclelist();
		
		System.out.println("Clicking on logout to complete the testcase");
		
		
		reportsPage.clickonReports();
		reportsPage.clickonDrivingReport();
		Thread.sleep(30000);
		reportsPage.selectExporttoExcelDropdown();
		reportsPage.selectExporttoExcel();
		reportsPage.clickonExportButtton();
		Thread.sleep(20000);
		
		
/*		//reportsPage.ExporttoExcelDropdown();
		reportsPage.clickonExportasPDF();
		reportsPage.clickonExportButtton();
		
		
		reportsPage.iterateDropdown();
		reportsPage.clickonReports();
		reportsPage.IdlingReport();
		Thread.sleep(30000);
		reportsPage.clickonReports();
		reportsPage.IftaReport();
		
		reportsPage.clickonSearchbyUnitChasis();
		reportsPage.clickonTimeperiodSelector();
		reportsPage.clickonCompanyLocation();
		reportsPage.clickonVehicalMake();
		
		reportsPage.clickonSearchButton();
		reportsPage.clickonResetButton();
		
		
		
		waitForElement(driver, driver.findElement(By.xpath("//*[@id='gridContainer']/div[1]/table/tbody/tr")), 120);
		*/
		
		
	}

	@AfterClass
	public void quitBrowser() {
		closeBrowser();
	}
}
