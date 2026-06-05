package com.BlazeDemo.Drivers;

import com.BlazeDemo.Utils.DataReader.PropertyReader;
import com.BlazeDemo.Utils.Logs.LogsManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.util.Arrays;

public class ChromeFactory extends AbstractDriver {

    private ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        options.setExperimentalOption(
                "excludeSwitches",
                Arrays.asList("enable-automation")
        );

        options.addArguments("--start-maximized");

        options.setExperimentalOption("useAutomationExtension", false);

        // Normalize execution type to avoid NPE
        String executionType = PropertyReader.safeGet("executionType", "Local");

        // Headless mode for LocalHeadless or Remote
        if (executionType.equalsIgnoreCase("LocalHeadless") ||
                executionType.equalsIgnoreCase("Remote")) {
            options.addArguments("--headless=new"); // new headless mode for modern Chrome
        }

        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return options;
    }

    @Override
    public WebDriver CreateDriver() {
        String executionType = PropertyReader.safeGet("executionType", "Local");

        if (executionType.equalsIgnoreCase("Local") || executionType.equalsIgnoreCase("LocalHeadless")) {
            return new ChromeDriver(getOptions());
        }
        else if (executionType.equalsIgnoreCase("Remote")) {
            try {
                return new RemoteWebDriver(
                        new URI("http://"
                                + PropertyReader.safeGet("remoteHost", "localhost")
                                + ":" + PropertyReader.safeGet("remotePort", "4444")
                                + "/wd/hub").toURL(),
                        getOptions()
                );
            } catch (Exception e) {
                LogsManager.error("Failed to create remote driver", e.getMessage());
                throw new RuntimeException(e);
            }
        }
        else {
            LogsManager.error("Invalid executionType: " + executionType);
            throw new RuntimeException("Invalid executionType: " + executionType);
        }
    }
}