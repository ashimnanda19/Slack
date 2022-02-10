package com.slack.assignment.locators;

import com.slack.assignment.utils.Log;
import com.slack.assignment.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/***
 * This is the page factory class for https://slack.com/signin#/signin
 * This class helps in creating the objects of different webelements present on this page.
 *
 */

public class SlackSignInPage extends TestBase {

    private static SlackSignInPage testObj;
    WebDriver driver = getDriver();

    public synchronized static SlackSignInPage get() {
        if(testObj==null){
            testObj= new SlackSignInPage();
            return testObj;
        }
        return testObj;
    }

    /***
     * Locators - By objects
     * These By objects are only for elements with Static locator paths
     */
    private By path_emailField = new By.ByCssSelector("[data-qa=\"email_field\"]");
    private By path_signInWithEmailButton = new By.ByCssSelector( "[data-qa=\"submit_button\"]");
    private By path_signInManuallyLink = new By.ByLinkText( "sign in manually instead");


    /***
     * Initiating WebElements using the By objects
     *
     */
    public  WebElement emailField (){
        waitForVisibilityOfWebElement(path_emailField,5);
        WebElement emailField = driver.findElement(path_emailField);
        return emailField;
    }

    public  WebElement signInWithEmailButton (){
        waitForVisibilityOfWebElement(path_signInWithEmailButton,5);
        WebElement signInWithEmailButton = driver.findElement(path_signInWithEmailButton);
        return signInWithEmailButton;
    }


    public  WebElement signInManuallyLink (){
        waitForVisibilityOfWebElement(path_signInManuallyLink,5);
        WebElement signInManuallyLink = driver.findElement(path_signInManuallyLink);
        return signInManuallyLink;
    }



    /***
     *  This method verifies the visibility of login email field and then enters the given value.
     * @param email
     */
    public void enterLoginEmail (String email){

        emailField().clear();
        emailField().sendKeys(email);
        Log.info("Successfully entered "+email+" in the login Email field.");

    }


    /****
     * This method waits for the visibility of Sign In button and then does click operation.
     */
    public void clickSignInWithEmailButton (){
        signInWithEmailButton().click();
        Log.info("Successfully clicked on the Sign In with Email button.");

    }


    /****
     * This method waits for the visibility of sign In Manually Instead Link and then does click operation.
     */

    public void clickSignInManuallyLink (){
        signInManuallyLink().click();
        Log.info("Successfully clicked on the sign-in-manually-instead Link .");

    }




}
