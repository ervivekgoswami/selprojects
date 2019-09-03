package com.navistar.occ.testscripts;

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

import com.navistar.occ.pagelibrary.FleetDashBoard;
import com.navistar.occ.pagelibrary.LogIn;
import com.navistar.occ.pagelibrary.OCCLandingPage;
import com.navistar.occ.pagelibrary.SignIn;
import com.navistar.occ.testbase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class TC003_OCCLandingPage extends TestBase {
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
		//landingPage=new OCCLandingPage(driver);
		
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
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//expliciteWait(driver.findElement(fleetDashBoard.logOutLink), 10);
		System.out.println(OCCLandingPage.getDerateConditionCount());
		//expliciteWait(driver.findElement(fleetDashBoard.logOutLink), 10);
		//System.out.println("@@@@@@@@@@ "+landingPage.getDerateConditionCount());
	}

	@AfterClass
	public void quitBrowser() {
		closeBrowser();
	}
}
