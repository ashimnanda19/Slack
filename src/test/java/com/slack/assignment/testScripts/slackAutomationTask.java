package com.slack.assignment.testScripts;

import com.slack.assignment.locators.WorkspaceMessagePane;
import com.slack.assignment.locators.WorkspaceSideBar;
import com.slack.assignment.utils.Common;
import com.slack.assignment.utils.TestBase;
import com.slack.assignment.workflows.SearchBar;
import com.slack.assignment.workflows.SendMessage;
import com.slack.assignment.workflows.SignIn;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


@Listeners(com.slack.assignment.utils.Listener.class)
public class slackAutomationTask extends TestBase {
    SoftAssert softAssert;

    @BeforeMethod
    public void login ()  {
        softAssert = new SoftAssert();
        String email= property.getProperty("email");
        String password= property.getProperty("password");
        SignIn.manualLogInOnWorkspaceUrlPage(email,password);
    }


    @Test
    public void slackAssignmentTask() {
        String channelId=  property.getProperty("channelId");
        String userId=property.getProperty("userId");
        String hasStar="has:star";
        int count=0;
        String expectedMessage = Common.getRandomString(5)+Common.getTimeStamp();
        SendMessage.sendMessageToChannel(channelId,expectedMessage);
        WorkspaceMessagePane.get().hoverOnLastMessage();
        WorkspaceMessagePane.get().selectSaveMessage();

        String currentTopResult=SearchBar.getResults(hasStar);

        //Adding a while loop here because it takes some time for the recently saved message to appears in the search.
        //the loops checks for the recently saved message for max 5 times at interval of 2 seconds.
        while(!currentTopResult.equals(expectedMessage)&&count<5){
            holdForNSeconds(2);
            currentTopResult=SearchBar.getResults(hasStar);
            count++;
        }
        assertEquals(softAssert,expectedMessage,currentTopResult,"Starred message is available in the search result");
        assertEquals(softAssert,userId,WorkspaceMessagePane.get().firstResultSender().getAttribute("data-message-sender"),"Starred message is posted by the expected user id");
        WorkspaceSideBar.get().clickSavedItems();
        assertEquals(softAssert,expectedMessage,WorkspaceMessagePane.get().firstResult().getText(),"Starred message is available in saved item channel");
        assertEquals(softAssert,userId,WorkspaceMessagePane.get().firstMessageSender().getAttribute("data-message-sender"),"Starred message is posted by the expected user id in saved item channel");
        softAssert.assertAll();

    }




}
