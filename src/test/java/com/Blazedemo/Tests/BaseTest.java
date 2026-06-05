package com.Blazedemo.Tests;

import com.BlazeDemo.Drivers.GuiDriver;
import com.BlazeDemo.Drivers.WebDriverProvider;
import com.BlazeDemo.Utils.DataReader.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({com.BlazeDemo.listeners.TestNGListeners.class})
public class BaseTest implements WebDriverProvider {
    protected GuiDriver driver;
    protected JsonReader TestData;

    @BeforeMethod(alwaysRun = true)
    public void setUpBase() {
        driver = new GuiDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBase() {
        if (driver != null) {
            driver.quitDriver();
        }
    }
    @BeforeClass(alwaysRun = true)
    public void PreConditions() {
        TestData = new JsonReader("Register_Data");
    }
    @Override
    public WebDriver getWebDriver() {
        return driver.getDriver();
    }
}