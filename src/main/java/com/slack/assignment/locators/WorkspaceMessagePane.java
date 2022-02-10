package com.slack.assignment.locators;

import com.slack.assignment.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WorkspaceMessagePane  extends TestBase {

    private static WorkspaceMessagePane testObj;
    WebDriver driver = getDriver();

    public synchronized static WorkspaceMessagePane get() {
        if(testObj==null){
            testObj= new WorkspaceMessagePane();
            return testObj;
        }
        return testObj;
    }

    /***
     * Locators - By objects
     * These By objects are only for elements with Static locator paths
     */
    private By path_lastMessageInCurrentGroup = new By.ByXPath("//div[contains(@class,'message--last')]");
    private By path_moreMessageActions = new By.ByXPath("//*[@data-qa=\"more_message_actions\"]");
    private By path_shareMessage = new By.ByXPath("//*[@data-qa=\"share_message_menu\"]");
    private By path_saveMessage = new By.ByXPath( "//*[@data-qa=\"save_message\"]");
    private By path_firstResult = new By.ByXPath(  "(//*[contains(@class,'p-rich_text_section')])[1]");
    private By path_firstResultSender = new By.ByXPath(  "(//*[contains(@class,'p-rich_text_section')])[1]/ancestor::div[contains(@class,'message__content')]//a");
    private By path_firstMessageSender = new By.ByXPath( "(//*[contains(@class,'text_section')])[1]/ancestor::div[contains(@class,'gutter__right')]//a[@target='_blank']");



    /***
     * Initiating WebElements using the By objects
     *
     */
    public  WebElement lastMessageInCurrentGroup (){
        waitForVisibilityOfWebElement(path_lastMessageInCurrentGroup,5);
        WebElement lastMessageInCurrentGroup = driver.findElement(path_lastMessageInCurrentGroup);
        return lastMessageInCurrentGroup;
    }

    public  WebElement moreMessageActions (){
        waitForVisibilityOfWebElement(path_moreMessageActions,5);
        WebElement moreMessageActions = driver.findElement(path_moreMessageActions);
        return moreMessageActions;
    }


    public  WebElement shareMessage (){
        waitForVisibilityOfWebElement(path_shareMessage,5);
        WebElement shareMessage = driver.findElement(path_shareMessage);
        return shareMessage;
    }

    public  WebElement saveMessage (){
        waitForVisibilityOfWebElement(path_saveMessage,10);
        WebElement saveMessage = driver.findElement(path_saveMessage);
        return saveMessage;
    }


    public  WebElement firstResult (){
        waitForVisibilityOfWebElement(path_firstResult,5);
        WebElement firstResult = driver.findElement(path_firstResult);
        return firstResult;
    }

    public  WebElement firstResultSender (){
        waitForVisibilityOfWebElement(path_firstResultSender,5);
        WebElement firstResultSender = driver.findElement(path_firstResultSender);
        return firstResultSender;
    }
    public  WebElement firstMessageSender (){
        waitForVisibilityOfWebElement(path_firstMessageSender,5);
        WebElement firstMessageSender = driver.findElement(path_firstMessageSender);
        return firstMessageSender;
    }





    // Generic methods for common actions that can be performed on WebElements

    public  void  hoverOnLastMessage (){
        hoverOnElement(lastMessageInCurrentGroup(),"LastMessage");
        waitForPageLoad(5);
    }

    public void openMoreMessageActionsMenu(){
        moreMessageActions().click();
        waitForPageLoad(5);

    }

    public void selectSaveMessage(){
        saveMessage().click();
        waitForPageLoad(5);
    }

    public void selectShareMessage(){
        shareMessage().click();
        waitForPageLoad(5);
    }








}
