package com.navistar.occ.ui.pagefactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.navistar.occ.testbase.TestBase;
public class LogIn extends TestBase {
	Logger log = Logger.getLogger(this.getClass().getSimpleName());
	WebDriver driver;

	public LogIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath = "//*[@id='SubmitLogin']")

	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
	public WebElement loginId;

	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "/html/body/center/div/form/center/table/tbody/tr[3]/td[2]/input")
	public WebElement login;

	/**
	 * This method will enter email address to create an account text box. In Login
	 * Page
	 * 
	 * @param emailAddress
	 */
	public void enterLoginId(String loginIdValue) {
		log.info("entering login id of the account");
		loginId.sendKeys(loginIdValue);
	}

	public void enterPassword(String passwordValue) {
		log.info("entering password to login into application");
		password.sendKeys(passwordValue);
	}

	public void clickonLogInToAccount() {
		log.info("clicking on sign in button");
		login.click();
	}

	/**
	 * This Method is used for login to application
	 */

	public void loginToApplication() {
		enterLoginId("yyy1k78");
		enterPassword("Bismillah5%");
		clickonLogInToAccount();
	}

	public void loginToApplication(String loginId, String Password) {
		System.out.println("Inside login application method");
		enterLoginId(loginId);
		enterPassword(Password);
		clickonLogInToAccount();
	}

	public void logout() {
		try {
			boolean isdisplayed = loginId.isDisplayed();
			if (isdisplayed) {
				loginId.click();
			}
		} catch (Exception e) {
			Assert.assertTrue(false, "sign out buttom is not displayed");
		}
	}
}
