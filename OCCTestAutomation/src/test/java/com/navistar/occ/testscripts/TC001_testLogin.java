package com.navistar.occ.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.testng.asserts.Assertion;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.navistar.occ.pagelibrary.FleetDashBoard;
import com.navistar.occ.pagelibrary.LogIn;
import com.navistar.occ.pagelibrary.SignIn;
import com.navistar.occ.testbase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC001_testLogin extends TestBase {
	LogIn login;
	FleetDashBoard fleetDashBoard;
	String loginId="yyy1k78";
	String Password="Bismillah5%";
	String invalidLoginId="yyy1k781";
	String invalidPassword="Bismillah1%";

	@BeforeClass
	public void setUP() throws IOException {
		init();
		login = new LogIn(driver);
		fleetDashBoard=new FleetDashBoard(driver);
		test = extent.startTest("Login Test", "This test will verify login test");
		test.log(LogStatus.PASS, "Basic set up for test is done");
	}


	@Test(priority = 0, enabled = true, description = "Test Registration with valid data")
	public void testRegistraionWithValidData() throws InterruptedException{
		test.log(LogStatus.PASS, "Login Test started");
		login = new LogIn(driver);
		login.loginToApplication(loginId,Password);
		expliciteWait(driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_lnkbtnLogout\"]")), 5);		
		boolean isSuccess = fleetDashBoard.verifyFleetDashBoardPageElements();
		if(isSuccess){
			System.out.println("Passed - Login into Oncommand Connection Portal is Successfu");
			Assert.assertTrue( true,"Login into Oncommand Connection Portal is Successful");
		}
		else{
			System.out.println("Failed - Login into Oncommand Connection Portal is Unsuccessfu");
			Assert.assertTrue(false, "Login into Oncommand Connection Portal is Failed");	
		}
	}
	

	@AfterClass
	public void quitBrowser() {
		closeBrowser();
	}
}
