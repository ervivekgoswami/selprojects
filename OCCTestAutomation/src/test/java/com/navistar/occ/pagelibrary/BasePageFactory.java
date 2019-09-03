package com.navistar.occ.pagelibrary;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.navistar.occ.testbase.TestBase;



public class BasePageFactory extends TestBase
{

 public static BasePageFactory dashboardPage;
    public BasePageFactory()
    {
        PageFactory.initElements(driver, this);
        dashboardPage = this;
    }
    public static void NavigateHere()
    {
        dashboardPage = new BasePageFactory();
    }
    
    @FindBy(how = How.XPATH, using = "//*[@id='fbDockChatBuddylistNub']")
    public  WebElement ChatWindow;
    
    
    
    @FindBy(how = How.XPATH, using = "//*[@id='u_0_1v']/div/div/div[1]/ul/li']")
    public  List<WebElement> ChatWindowMember;
    
    public static void OpencChatWindow()
    {
     dashboardPage.ChatWindow.click();
     int a=dashboardPage.ChatWindowMember.size();
    }
}

