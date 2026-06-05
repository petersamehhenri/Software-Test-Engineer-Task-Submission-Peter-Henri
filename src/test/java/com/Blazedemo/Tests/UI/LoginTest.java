package com.Blazedemo.Tests.UI;

import com.BlazeDemo.Pages.Components.NavigationBarComponent;
import com.BlazeDemo.Pages.Components.LoginPage;
import com.BlazeDemo.Utils.DataReader.JsonReader;
import com.Blazedemo.Tests.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Automation Task")
@Feature("UI User Management")
@Story("Login Functionality")
@Severity(SeverityLevel.CRITICAL)
@Owner("PETER")
public class LoginTest extends BaseTest {


    @Description("Successful Login with Valid Credentials")
    @Test
    public void ValidLogin() {
        new LoginPage(driver).navigateToLoginPage()
                .enterLoginEmail(TestData.getJsonData("LoginEmail"))
                .enterLoginPassword(TestData.getJsonData("LoginPassword"))
                .ClickLoginButton()
                .ValidationLoggingIn();
    }

    @Description("Login with Invalid Data")
    @Test
    public void InValidLogin() {
        new LoginPage(driver).navigateToLoginPage()
                .enterLoginEmail(TestData.getJsonData("LoginEmail"))
                .enterLoginPassword(TestData.getJsonData("InvalidPass"))
                .ClickLoginButton()
                .VerifyLoginErrorMessage();
    }


@BeforeClass(alwaysRun = true)
    public void PreConditions() {
        TestData = new JsonReader("Login_Data");
    }
    @BeforeMethod
    public void SetUp() {
        // driver already created in BaseTest
        new NavigationBarComponent(driver).navigate();
    }

    @AfterMethod
    public void TearDown() {
        driver.quitDriver();
    }
}