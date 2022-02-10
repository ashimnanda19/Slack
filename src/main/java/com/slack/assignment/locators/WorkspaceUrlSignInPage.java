package com.slack.assignment.locators;

import com.slack.assignment.utils.Log;
import com.slack.assignment.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkspaceUrlSignInPage extends TestBase {

    private static WorkspaceUrlSignInPage testObj;
    WebDriver driver = getDriver();
    public synchronized static WorkspaceUrlSignInPage get() {
        if(testObj==null){
            testObj= new WorkspaceUrlSignInPage();
            return testObj;
        }
        return testObj;
    }

    /***
     * Locators - By objects
     *
     */
    private  By path_loginPassword  = new By.ByCssSelector("[data-qa=\"login_password\"]");
    private  By path_loginEmail = new By.ByCssSelector("[data-qa=\"login_email\"]");
    private  By path_signInButton = new By.ByCssSelector("[data-qa=\"signin_button\"]");

    /***
     * Initiating WebElements using the By objects
     *
     */
    public  WebElement loginEmail (){
        waitForVisibilityOfWebElement(path_loginEmail,5);
        WebElement loginEmail = driver.findElement(path_loginEmail);
        return loginEmail;
    }

    public WebElement loginPassword (){
        waitForVisibilityOfWebElement(path_loginPassword,5);
        WebElement loginPassword = driver.findElement(path_loginPassword);
        return loginPassword;
    }

    public WebElement signInButton (){
        waitForVisibilityOfWebElement(path_signInButton,5);
        WebElement signInButton = driver.findElement(path_signInButton);
        return signInButton;
    }

    /***
     *  This method verifies the visibility of login email field and then enters the given value.
     * @param email
     */
    public void enterLoginEmail (String email){
        loginEmail().clear();
        loginEmail().sendKeys(email);
        Log.info("Successfully entered "+email+" in the login Email field.");
    }

    /****
     * This method waits for the visibility of password field and then enters the given value.
     * @param password
     */
    public void enterLoginPassword (String password){
        loginPassword().clear();
        loginPassword().sendKeys(password);
        Log.info("Successfully entered password in the login Password field at workspace Url Sign in page.");
    }

    /****
     * This method waits for the visibility of Sign In button and then does click operation.
     */
    public void clickSignInButton (){
        signInButton().click();
        Log.info("Successfully clicked on the Sign In button.");

    }




}
