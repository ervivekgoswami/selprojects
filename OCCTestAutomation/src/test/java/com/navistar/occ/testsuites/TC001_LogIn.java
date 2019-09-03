package com.navistar.occ.testsuites;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.navistar.occ.testbase.TestBase;
import com.navistar.occ.ui.pagefactory.FleetDashBoard;
import com.navistar.occ.ui.pagefactory.LogIn;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;


public class TC001_LogIn extends TestBase {
	LogIn login;
	FleetDashBoard fleetDashBoard;
	String loginId = "yyy1k78";
	String Password = "Bismillah5%";
	String invalidLoginId = "yyy1k781";
	String invalidPassword = "Bismillah1%";

	@BeforeClass
	public void setUP() throws IOException {
		init();
		test = extent.startTest("Login Test", "This test will verify login test");
		test.log(LogStatus.PASS, "Basic set up for test is done");
		//test = extent.startTest("Login Test", "This test will verify login test");
		test.log(LogStatus.PASS, "Basic set up for test is done");
		test.log(LogStatus.PASS, "Login Test started");

	}

	@Test(priority = 0, enabled = true, description = "Test Registration with valid data")
	public void testLoginWithValidData() throws InterruptedException, IOException {
		
		login = new LogIn(driver);
		fleetDashBoard = new FleetDashBoard(driver);
		login.loginToApplication(loginId, Password);
		captureScreen(this.getClass().getSimpleName());
		expliciteWait((fleetDashBoard.logOutLink), 20);
		boolean isSuccess = fleetDashBoard.verifyFleetDashBoardPageElements();
		if (isSuccess) {
			System.out.println("Passed - Login into Oncommand Connection Portal is Successfu");
			Assert.assertTrue(true, "Login into Oncommand Connection Portal is Successful");
		} else {
			System.out.println("Failed - Login into Oncommand Connection Portal is Unsuccessfu");
			Assert.assertTrue(false, "Login into Oncommand Connection Portal is Failed");
		}
		
		System.out.println("Clicking on logout to complete the testcase");
		
		fleetDashBoard.clickOnLogout();
	}

	@AfterClass
	public void quitBrowser() {
		closeBrowser();
	}
}
