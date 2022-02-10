package com.slack.assignment.locators;

import com.slack.assignment.utils.Log;
import com.slack.assignment.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkspaceMessageBox  extends TestBase {
    private static WorkspaceMessageBox testObj;
    WebDriver driver = getDriver();

    public synchronized static WorkspaceMessageBox get() {
        if(testObj==null){
            testObj= new WorkspaceMessageBox();
            return testObj;
        }
        return testObj;
    }

    /***
     * Locators - By objects
     * These By objects are only for elements with Static locator paths
     */
    public static By path_messageInputBox = new By.ByCssSelector( "[data-qa=\"message_input\"]");
    private By path_messageEditor = new By.ByXPath( "//*[@data-qa=\"message_input\"]/div");
    private By path_sendButton = new By.ByCssSelector("[data-qa=\"texty_send_button\"]");
    private By path_sendButtonOptions = new By.ByCssSelector("[data-qa=\"texty_send_button\"]");



    /***
     * Initiating WebElements using the By objects
     *
     */
    public  WebElement messageInputBox (){
        waitForVisibilityOfWebElement(path_messageInputBox,10);
        WebElement messageInputBox = driver.findElement(path_messageInputBox);
        return messageInputBox;
    }

    public  WebElement messageEditor (){
        waitForVisibilityOfWebElement(path_messageEditor,5);
        WebElement messageEditor = driver.findElement(path_messageEditor);
        return messageEditor;
    }


    public  WebElement sendButton (){
        waitForVisibilityOfWebElement(path_sendButton,5);
        WebElement sendButton = driver.findElement(path_sendButton);
        return sendButton;
    }

    public  WebElement sendButtonOptions (){
        waitForVisibilityOfWebElement(path_sendButtonOptions,5);
        WebElement sendButtonOptions = driver.findElement(path_sendButtonOptions);
        return sendButtonOptions;
    }


    /***
     * This method selects a particular channel using unique ChannelID
     * @param textMessage
     */
    public void sendTextMessage(String textMessage) {
        messageInputBox().click();
        Log.info("Clicked on Message Input Box");
        messageEditor().sendKeys(textMessage);
        Log.info("Entered Text in Message Input Box");
        sendButton().click();
        waitForPageLoad(5);
    }





}
