package com.slack.assignment.workflows;

import com.slack.assignment.locators.WorkspaceHeader;
import com.slack.assignment.locators.WorkspaceMessagePane;
import com.slack.assignment.utils.TestBase;



public class SearchBar extends TestBase {


    /***
     * This method to search a querry and get text from first result.
     *
     */
    public static String getResults(String SearchQuery){
        WorkspaceHeader.get().clickOnSearchText();
        WorkspaceHeader.get().typeInSearchBar(SearchQuery);
        pressEnterKey(WorkspaceHeader.get().searchBarBox());
        waitForPageLoad(5);
        return WorkspaceMessagePane.get().firstResult().getText();

    }




}
