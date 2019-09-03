package com.navistar.occ.testsuites;

import com.navistar.occ.testbase.TestBase;
import com.navistar.occ.ui.pagefactory.FleetDashBoard;
import com.navistar.occ.ui.pagefactory.LogIn;
import com.navistar.occ.ui.pagefactory.OCCLandingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//mport com.test.automation.uiAutomation.uiActions.LogIn;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class TC004_Testing extends TestBase {
	LogIn login;
	FleetDashBoard fleetDashBoard;
	OCCLandingPage landingPage;
	String loginId = "yyy1k78";
	String Password = "Bismillah5%";
	String invalidLoginId = "yyy1k781";
	String invalidPassword = "Bismillah1%";
	JavascriptExecutor exe;

	@BeforeClass
	public void setUP() throws IOException {
		init();
		login = new LogIn(driver);
		fleetDashBoard = new FleetDashBoard(driver);
		landingPage = new OCCLandingPage(driver);
		 exe = (JavascriptExecutor)driver;
		test = extent.startTest("Login Test", "This test will verify login test");
		test.log(LogStatus.PASS, "Basic set up for test is done");
	}

	@Test(priority = 0, enabled = true, description = "Test Registration with valid data")
	public void testRegistraionWithValidData() throws InterruptedException {
		test.log(LogStatus.PASS, "Login Test started");
		login = new LogIn(driver);
		login.loginToApplication(loginId, Password);
		waitForElement(driver, fleetDashBoard.logOutLink, 90);
		fleetDashBoard.clickOnHome();	
		waitForElement(driver, landingPage.ddlCompany, 90);
		
		landingPage.getDonutTotalVehicleScans();
		
		landingPage.getCountsOfLandingPage();
    
		//exe.executeScript("arguments[0].value=\"testselenium\"", driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/div[2]/div/div[1]/form/div[1]/input")));
		
		//String return_value = (String) exe.executeScript("return driver.findElement(By.xpath('.//*[@id='donut-charts']/svg[2]/g/path[1]')).innerHTML");
		//log.info("return_value ----> "+return_value);
	}

	@AfterClass
	public void quitBrowser() {
		closeBrowser();
	}
}
