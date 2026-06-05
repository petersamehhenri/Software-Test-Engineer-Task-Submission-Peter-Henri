package com.Blazedemo.Tests.UI;

import com.BlazeDemo.Pages.Components.NavigationBarComponent;
import com.BlazeDemo.Pages.Components.RegisterPage;
import com.BlazeDemo.Utils.DataReader.JsonReader;
import com.BlazeDemo.Utils.WaitsAndTime.TimeManager;
import com.Blazedemo.Tests.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Epic("Automation Task")
@Feature("UI User Management")
@Story("User Registration")
@Severity(SeverityLevel.CRITICAL)
@Owner("PETER")
public class RegisterTest extends BaseTest {
    @Description("Successful Registration with Valid Data")
    @Test
    public void ValidRegister() {
       String reusedEmail = TestData.getJsonData("Email") + TimeManager.getSimpleTimeStamp() + "@gmail.com";

        new RegisterPage(driver).navigateToRegistrationPage().
                FillRegistrationForm(
                        TestData.getJsonData("FirstName"),
                        TestData.getJsonData("LastName"),
                        reusedEmail,
                        TestData.getJsonData("RegistrationPassword"),
                        TestData.getJsonData("RegistrationConfirmPassword"))
               .ClickOnRegistrationButton()
                .ValidationAccountIsCreated();
    }

    @Description("Registration Fails with Missing Required Fields")
    @Test
    public void InValidRegister() {
        new RegisterPage(driver).navigateToRegistrationPage().
                FillPartialRegistration(
                        TestData.getJsonData("FirstName"),
                        TestData.getJsonData("LastName"),
                        TestData.getJsonData("RegistrationPassword"),
                        TestData.getJsonData("RegistrationConfirmPassword"))
                .ClickOnRegistrationButton()
                .VerifyRegisterationErrorMessage();
    }

    @BeforeClass(alwaysRun = true)
    public void PreConditions() {
        TestData = new JsonReader("Register_Data");
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