package com.BlazeDemo.Utils.Actions;

import com.BlazeDemo.Utils.Logs.LogsManager;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private WebDriver driver;
    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }
    //maximize the browser window
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
    // Get the current URL
    public String getCurrentUrl() {
         String url = driver.getCurrentUrl();
         LogsManager.info("Current URL: " + url);
        return url;
     }
    // Get the page title
    public String getPageTitle() {
        return driver.getTitle();
    }
    // Navigate to a URL
    public void navigateTo(String url) {
        driver.get(url);
        LogsManager.info("Navigated to URL: " + url);
    }
    // Refresh the current page
    public void refreshPage() {
        driver.navigate().refresh();
    }
    // Navigate back
    public void navigateBack() {
        driver.navigate().back();
    }
    // Navigate forward
    public void navigateForward() {
        driver.navigate().forward();
    }
    // Delete all cookies
    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }
    //open a new tab
    public void openNewTab() {
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
    }
    //open a new window
    public void openNewWindow() {
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.WINDOW);
    }

    // Close the browser
    public void closeBrowser() {
        driver.quit();
    }

}