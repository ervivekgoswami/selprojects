package com.navistar.occ.pagelibrary;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.navistar.occ.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class LogIn extends TestBase{
	
	WebDriver driver;
	static Logger log = Logger.getLogger(LogIn.class.getName());
	
	
	//By loginId=By.xpath("//*[@id=\"username\"]");
	By loginId = By.id("username");
	//By password=By.xpath("//*[@id=\"password\"]");
	By password = By.id("password");
	By login=By.xpath("/html/body/center/div/form/center/table/tbody/tr[3]/td[2]/input");

	
	public LogIn(WebDriver driver){
		this.driver = driver;
	}
	/**
	 * This method will click on sign in link in login page
	 */
	/*public void clickonSignIn(){
		log.info("clicking on sign in link");
		
		try {
			driver.findElement(login).click();
			test.log(LogStatus.PASS, "Clicking on sing in Link");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.FAIL,"Clicking on sing in Link");
		}
	}*/
	
	/**
	 * This method will enter email address to create an account text box.
	 * In Login Page
	 * @param emailAddress
	 */
	public void enterLoginId(String loginIdValue){
		log.info("entering login id of the account");
		driver.findElement(loginId).sendKeys(loginIdValue);
	}
	
	public void enterPassword(String passwordValue){
		log.info("entering password to login into application");
		driver.findElement(password).sendKeys(passwordValue);
	}
	
	public void clickonLogInToAccount(){
		log.info("clicking on sign in button");
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.document.getElementByXPath('/html/body/center/div/form/center/table/tbody/tr[3]/td[2]/input').click()");
		//driver.findElement(By.partialLinkText("Log In")).click();
		driver.findElement(login).click();;
	}
	
	
	/**
	 * This Method is used for login to application
	 */

	public void loginToApplication(){
		enterLoginId("yyy1k78");
		enterPassword("Bismillah5%");
		clickonLogInToAccount();
	}
	
	public void loginToApplication(String loginId, String Password){
		enterLoginId(loginId);
		enterPassword(Password);
		clickonLogInToAccount();
	}
	
		
	public void logout(){
		try{
		boolean isdisplayed = driver.findElement(loginId).isDisplayed();
		if(isdisplayed){
			driver.findElement(loginId).click();
		}
		}
		catch(Exception e){
			Assert.assertTrue(false, "sign out buttom is not displayed");
		}
	}
}
