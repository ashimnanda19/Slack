package com.slack.assignment.locators;

import com.slack.assignment.utils.Log;
import com.slack.assignment.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/***
 * This locator class/Page Class has the locators for all the different web elements on the home page of
 * slack.com
 * This is a page factory class which returns the WebElement objects.
 */

public class SlackHomePage extends TestBase {

    private static SlackHomePage testObj;
    WebDriver driver =  getDriver();

    public synchronized static SlackHomePage get() {
        if(testObj==null){
            testObj= new SlackHomePage();
            return testObj;
        }
        return testObj;
    }


    /***
     * Locators - By objects
     * These By objects are only for elements with Static locator paths
     */
    private By path_navbar_SignInLink = new By.ByCssSelector( "[data-qa=\"link_sign_in_nav\"]");



    /***
     * Initiating WebElements using the By objects
     *
     */
    public  WebElement navbar_SignInLink (){
        waitForVisibilityOfWebElement(path_navbar_SignInLink,5);
        WebElement navbar_SignInLink = driver.findElement(path_navbar_SignInLink);
        return navbar_SignInLink;
    }


    /****
     * This method waits for the visibility of SignIn Link on the Navigation bar  and then does click operation.
     */
    public void navbar_ClickSignInLink (){
        navbar_SignInLink().click();
        Log.info("Successfully clicked on the Sign In button.");

    }


    //Rest of the elements can be defined here based on location or sections. eg. footer, navbar, etc
    // This will help in managing the definition webElements within the code.




}
