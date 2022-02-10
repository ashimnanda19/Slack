package com.slack.assignment.workflows;

import com.slack.assignment.locators.*;
import com.slack.assignment.utils.TestBase;

/***
 * This class contains method that perform different workflows related to the sign In functionality.
 * These workflows can be  called in the testscripts to validate usecases as per need.
 *
 */
public class SignIn extends TestBase{

    /***
     * This workflow performs the login on WorkspaceUrlPage directly.
     * This method can be used only when the user is already on the WorkSpaceUrlPage.
     * @param email
     * @param password
     * @return
     */
    public static void  manualLogInOnWorkspaceUrlPage(String email, String password){
        WorkspaceUrlSignInPage.get().enterLoginEmail(email);
        WorkspaceUrlSignInPage.get().enterLoginPassword(password);
        WorkspaceUrlSignInPage.get().clickSignInButton();
        holdForNSeconds(10); // using generic hold here, because user is re-directed though multiple page loads.
        waitForVisibilityOfWebElement(WorkspaceMessageBox.path_messageInputBox,15);

    }


    /****
     * This workflow performs the manual login starting from Https://Slack.com and then follows the path
     * through SlackSignInPage, SlackWorkspaceSignInPage and finally WorkspaceUrlSignInPage.
     * @param workspaceUrl
     * @param email
     * @param password
     */

    public static void manualLogInSlackHomePage(String workspaceUrl, String email, String password){
        SlackHomePage.get().navbar_ClickSignInLink();
        SlackSignInPage.get().clickSignInManuallyLink();
        SlackWorkspaceSignInPage.get().enterWorkspaceUrl(workspaceUrl);
        manualLogInOnWorkspaceUrlPage(email,password);
    }



}
