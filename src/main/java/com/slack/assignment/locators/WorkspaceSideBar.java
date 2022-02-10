package com.slack.assignment.locators;

import com.slack.assignment.utils.Log;
import com.slack.assignment.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/***
 * This class creates WebElements objects in the left side bar of Slack workspace
 * and provides functions to perform actions on them.
 *
 */

public class WorkspaceSideBar extends TestBase {
    private static WorkspaceSideBar testObj;
    WebDriver driver = getDriver();

    public synchronized static WorkspaceSideBar get() {
        if(testObj==null){
            testObj= new WorkspaceSideBar();
            return testObj;
        }
        return testObj;
    }

    /***
     * Locators - By objects
     * These By objects are only for elements with Static locator paths
     */
    private  By path_savedItems = new By.ByCssSelector("[data-qa-channel-sidebar-link-id=\"Psaved\"]");


    /***
     * Initiating WebElements with static path using the By objects
     *
     */
    public  WebElement savedItems (){
        waitForVisibilityOfWebElement(path_savedItems,5);
        WebElement savedItems = driver.findElement(path_savedItems);
        return savedItems;
    }


    /**
     * This is a dynamic web element, so the By locator object is created inside the method based on dynamic input.
     * @param channelId
     * @return
     */
    public  WebElement channel (String channelId){
        By channelPath = new By.ByCssSelector("#" + channelId + "> div");
        waitForVisibilityOfWebElement(channelPath,10);
        WebElement channel = driver.findElement(channelPath);
        return channel;
    }



    /***
     * This method selects a particular channel using unique ChannelID
     * @param channelId
     */
    public void selectChannel(String channelId) {
            channel(channelId).click();
            waitForPageLoad(5);
            Log.info("Successfully selected Channel with ID:" + channelId);
    }


    public void clickSavedItems() {
        savedItems().click();
        Log.info("Successfully clicked savedItems");
        waitForPageLoad(5);

    }






}
