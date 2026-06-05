package com.BlazeDemo.Pages.Components;

import com.BlazeDemo.Drivers.GuiDriver;
import com.BlazeDemo.Utils.DataReader.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegisterPage {
    private GuiDriver driver;
    private final String RegisterEndPoint = "/register";
    public RegisterPage(GuiDriver driver) {
        this.driver = driver;
    }


    //locators
    private final By EmailErrorMessage = By.xpath("//span[@id='Email-error']");
    private final By RegisterationConfirmMessage = By.xpath("//div[@class='result']");

    private final By FirstNameTextBoxRegister = By.xpath("//input[@id='FirstName']");
    private final By LastNameTextBoxRegister = By.xpath("//input[@id='LastName']");
    private final By EmailTextBoxRegister = By.xpath("//input[@id='Email']");
    private final By RegisterPasswordTextBox = By.xpath("//input[@id='Password']");
    private final By ConfirmPasswordTextBox = By.xpath("//input[@id='ConfirmPassword']");
    private final By RegistrationButton = By.xpath("//button[@id='register-button']");
    private final By ContinueButton = By.xpath("//a[.='Continue']");

    //Actions
    @Step("Navigate to registration page")
    public RegisterPage navigateToRegistrationPage() {
        driver.browser().navigateTo(PropertyReader.getProperty("BaseUrl_Web") +RegisterEndPoint);
        return this;
    }

    @Step("Fill Registration Form")
    public RegisterPage FillRegistrationForm(String FirstName, String LastName, String Email, String RegistrationPassword , String RegistrationConfirmPassword)
    {
        driver.element().type(FirstNameTextBoxRegister ,FirstName );
        driver.element().type(LastNameTextBoxRegister ,LastName );
        driver.element().type(EmailTextBoxRegister ,Email );
        driver.element().type(RegisterPasswordTextBox ,RegistrationPassword );
        driver.element().type(ConfirmPasswordTextBox ,RegistrationConfirmPassword );
        return this;
    }

    @Step("Fill partial registration data")
    public RegisterPage FillPartialRegistration (String FirstName, String LastName, String RegistrationPassword , String RegistrationConfirmPassword)
        {
            driver.element().type(FirstNameTextBoxRegister ,FirstName );
            driver.element().type(LastNameTextBoxRegister ,LastName );
            driver.element().type(RegisterPasswordTextBox ,RegistrationPassword );
            driver.element().type(ConfirmPasswordTextBox ,RegistrationConfirmPassword );
            return this;
        }

    @Step("Click on register button")
    public RegisterPage ClickOnRegistrationButton() {
        driver.element().click(RegistrationButton);
        return this;
    }

    //Validations
    @Step("Validate that i am in Registeration Page ")
    public RegisterPage ValidationAccountIsCreated () {
        driver.verification().isElementVisible(RegisterationConfirmMessage);
        return this;
    }

    @Step("Validate that I registered ")
    public RegisterPage ValidationLoggingIn () {
        driver.verification().isElementVisible(RegisterationConfirmMessage);
        return this;
    }
    @Step("Verify Registeration error message ")
    public RegisterPage VerifyRegisterationErrorMessage () {
        driver.verification().isElementVisible(EmailErrorMessage);
        return this;
    }
}