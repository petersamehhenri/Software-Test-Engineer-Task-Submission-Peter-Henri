package com.Blazedemo.Tests.UI;

import com.BlazeDemo.Pages.Components.LoginPage;
import com.BlazeDemo.Pages.Components.NavigationBarComponent;
import com.BlazeDemo.Pages.Components.ProductsPage;
import com.BlazeDemo.Utils.DataReader.JsonReader;
import com.Blazedemo.Tests.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Epic("Automation Task")
@Feature("UI Products Management")
@Story("Shopping Cart")
@Severity(SeverityLevel.CRITICAL)
@Owner("PETER")
public class ProductsTest extends BaseTest {

    //@Description("Successful Login with Valid Credentials")

    @Description ("Add a Product to the Cart")
    @Test
    public void AddProduct() {
        new LoginPage(driver).navigateToLoginPage()
                .enterLoginEmail(TestData.getJsonData("LoginEmail"))
                .enterLoginPassword(TestData.getJsonData("LoginPassword"))
                .ClickLoginButton()
                .ValidationLoggingIn();
        new ProductsPage(driver).navigateToHomePage()
                .ChooseProduct()
                .clickAddToCartButton()
                .clickViewCartButton()
                .CheckoutButton()
                .ConfirmingTheOrder()
                .ValidateOrderConfirmation();
    }

    @Description ("Update Product Quantity in the Cart")
    @Test
    public void UpdateProductQuantity() {
        new LoginPage(driver).navigateToLoginPage()
                .enterLoginEmail(TestData.getJsonData("LoginEmail"))
                .enterLoginPassword(TestData.getJsonData("LoginPassword"))
                .ClickLoginButton()
                .ValidationLoggingIn();
        new ProductsPage(driver).navigateToHomePage()
                .ChooseProduct()
                .clickAddToCartButton()
                .clickViewCartButton()
                .UpdateQuantity();
    }

    @Description ("Remove a Product from the Cart")
    @Test
    public void RemoveProductFromCart() {
        new LoginPage(driver).navigateToLoginPage()
                .enterLoginEmail(TestData.getJsonData("LoginEmail"))
                .enterLoginPassword(TestData.getJsonData("LoginPassword"))
                .ClickLoginButton()
                .ValidationLoggingIn();
        new ProductsPage(driver).navigateToHomePage()
                .ChooseProduct()
                .clickAddToCartButton()
                .clickViewCartButton()
                .RemoveProductFromCart()
                .ValidateEmptyCart();
    }



    @BeforeClass(alwaysRun = true)
    public void PreConditions() {
        TestData = new JsonReader("Products_Data");
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

//zbtt el locators f product page