package com.slack.assignment.locators;

import com.slack.assignment.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WorkspaceHeader extends TestBase {

    private static WorkspaceHeader testObj;
    WebDriver driver = getDriver();

    public synchronized static WorkspaceHeader get() {
        if(testObj==null){
            testObj= new WorkspaceHeader();
            return testObj;
        }
        return testObj;
    }


    /***
     * Locators - By objects
     * These By objects are only for elements with Static locator paths
     */
    private By path_topNavSearchBarButton = new By.ByXPath( "//*[@data-qa=\"top_nav_search\"]");
    private By path_searchBarBox = new By.ByXPath( "//*[@data-qa=\"focusable_search_input\"]//p");
    private By path_clearButton=new By.ByXPath("//button[@label='Clear']");


    /***
     * Initiating WebElements using the By objects
     *
     */
    public  WebElement topNavSearchBarButton (){
        waitForVisibilityOfWebElement(path_topNavSearchBarButton,5);
        WebElement topNavSearchBarButton = driver.findElement(path_topNavSearchBarButton);
        return topNavSearchBarButton;
    }

    public  WebElement searchBarBox (){
        waitForVisibilityOfWebElement(path_searchBarBox,5);
        WebElement searchBarBox = driver.findElement(path_searchBarBox);
        return searchBarBox;
    }
    public  WebElement clearSearchBar(){
        waitForVisibilityOfWebElement(path_clearButton,5);
        WebElement clearSearchBar = driver.findElement(path_clearButton);
        return clearSearchBar;

    }


    // Generic methods for common actions that can be performed on webelements

    public void clickOnSearchText (){
        topNavSearchBarButton().click();
        waitForPageLoad(5);
    }

    public void typeInSearchBar(String text){
        searchBarBox().click();
        searchBarBox().clear();
        searchBarBox().sendKeys(text);
        waitForPageLoad(5);
    }



}
