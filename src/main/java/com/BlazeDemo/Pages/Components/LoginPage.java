package com.BlazeDemo.Pages.Components;

import com.BlazeDemo.Drivers.GuiDriver;
import com.BlazeDemo.Utils.DataReader.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    private GuiDriver driver;
    private final String LoginEndPoint = "/login";

    public LoginPage(GuiDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By LogInIcon = By.xpath("//a[.='Log in']");
    private final By EmailTextBoxLogin = By.xpath("//input[@id='Email']");
    private final By PasswordTextBoxLogin = By.xpath("//input[@id='Password']");
    private final By LoginButton = By.xpath("//button[@class='button-1 login-button']");
    private final By LogOutButton = By.xpath("//a[.='Log out']");
    private final By LoginErrorMessage = By.xpath("//div[@class='message-error validation-summary-errors']");

    //Actions
    @Step ("Navigate to login page")
    public LoginPage navigateToLoginPage() {
        driver.browser().navigateTo(PropertyReader.getProperty("BaseUrl_Web") +LoginEndPoint);
        return this;
    }
    @Step("Enter email in email text box")
    public LoginPage enterLoginEmail (String loginEmail) {
        driver.element().type(EmailTextBoxLogin, loginEmail);
        return this;
    }
    @Step("Enter password in password text box")
    public LoginPage enterLoginPassword (String LoginPassword) {
        driver.element().type(PasswordTextBoxLogin, LoginPassword);
        return this;
    }
    @Step("Click Login Button")
    public LoginPage ClickLoginButton () {
        driver.element().click(LoginButton);
        return this;
    }

    //validations
    @Step("Validate that I am logged in ")
    public LoginPage ValidationLoggingIn () {
        driver.verification().isElementVisible(LogOutButton);
        return this;
    }

    @Step("Verify Login error message ")
    public LoginPage VerifyLoginErrorMessage () {
        driver.verification().isElementVisible(LoginErrorMessage);
        return this;
    }
}