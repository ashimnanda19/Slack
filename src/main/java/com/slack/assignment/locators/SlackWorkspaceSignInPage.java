package com.slack.assignment.locators;

import com.slack.assignment.utils.Log;
import com.slack.assignment.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/***
 * This is the page factory class for https://slack.com/workspace-signin
 * This class helps in creating the objects of different WebElements present on this page
 * and also provided methods to perform different actions on them.
 *
 */

public class SlackWorkspaceSignInPage extends TestBase  {

    private static SlackWorkspaceSignInPage testObj;

    WebDriver driver = getDriver();
    public synchronized static SlackWorkspaceSignInPage get() {
        if(testObj==null){
            testObj= new SlackWorkspaceSignInPage();
            return testObj;
        }
        return testObj;
    }

    /***
     * Locators - By objects
     * These By objects are only for elements with Static locator paths
     */
    private By path_workspaceUrlField = new By.ByCssSelector("[data-qa=\"signin_domain_input\"]");
    private By path_continueButton = new By.ByCssSelector("[data-qa=\"submit_team_domain_button\"]");



    /***
     * Initiating WebElements using the By objects
     *
     */
    public  WebElement workspaceUrlField (){
        waitForVisibilityOfWebElement(path_workspaceUrlField,5);
        WebElement workspaceUrlField = driver.findElement(path_workspaceUrlField);
        return workspaceUrlField;
    }

    public  WebElement continueButton (){
        waitForVisibilityOfWebElement(path_continueButton,5);
        WebElement continueButton = driver.findElement(path_continueButton);
        return continueButton;
    }


    /***
     *  This method verifies the visibility of enter workspace's slack url field and then enters the given value.
     * @param workspaceUrl
     */
    public void enterWorkspaceUrl (String workspaceUrl){
        workspaceUrlField().clear();
        workspaceUrlField().sendKeys(workspaceUrl);
        Log.info("Successfully entered "+workspaceUrl+" in the login Email field.");

    }

    /****
     * This method waits for the visibility of Sign In button and then does click operation.
     */
    public void clickContinueButton (){
        continueButton().click();
        Log.info("Successfully clicked on the Continue button.");

    }


}
