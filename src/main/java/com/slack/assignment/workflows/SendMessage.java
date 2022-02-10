package com.slack.assignment.workflows;
import com.slack.assignment.locators.WorkspaceMessageBox;
import com.slack.assignment.locators.WorkspaceSideBar;
import com.slack.assignment.utils.TestBase;

/***
 * This class contains methods that perform common workflows related to the send message functionality.
 * These workflows can be called in the testscripts to validate different usecases as per need.
 *
 */
public class SendMessage extends TestBase {


    /***
     * This method send message to a particular Channel in the slackworkspace.
     *
     */
    public static void  sendMessageToChannel(String channelId, String textMessage){
        WorkspaceSideBar.get().selectChannel(channelId);
        WorkspaceMessageBox.get().sendTextMessage(textMessage);
        waitForPageLoad(5);

    }


}
