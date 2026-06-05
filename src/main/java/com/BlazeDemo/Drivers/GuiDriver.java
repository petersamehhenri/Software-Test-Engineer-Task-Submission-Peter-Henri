package com.BlazeDemo.Drivers;

import com.BlazeDemo.Utils.Actions.AlertActions;
import com.BlazeDemo.Utils.Actions.BrowserActions;
import com.BlazeDemo.Utils.Actions.ElementActions;
import com.BlazeDemo.Utils.Actions.FrameActions;
import com.BlazeDemo.Utils.DataReader.PropertyReader;
import com.BlazeDemo.Utils.Logs.LogsManager;
import com.BlazeDemo.Validations.Validation;
import com.BlazeDemo.Validations.Verification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class GuiDriver {
    private final String browser = PropertyReader.getProperty("browserType");
    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public GuiDriver() {
        // Use your custom Browser enum, not Selenium's
        LogsManager.info("GuiDriver started" + browser);
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        LogsManager.info("Browser: " + browserType.name());
        AbstractDriver abstractDriver = browserType.getDriverFactory();
        WebDriver driver = ThreadGuard.protect(abstractDriver.CreateDriver());
        driverThreadLocal.set(driver);
    }

    //return new obj for all classes I will use
    public Validation validation() {
        return new Validation(getDriver());
    }

    public Verification verification() {
        return new Verification (getDriver());
    }

    public AlertActions alert(){
        return new AlertActions(getDriver());
    }

    public FrameActions frame(){
        return new FrameActions(getDriver());
    }

    public BrowserActions browser(){
        return new BrowserActions(getDriver());
    }


    public ElementActions element() {
        return new ElementActions(getDriver());
    }



    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public void quitDriver() {
        driverThreadLocal.get().quit();
    }
}