package com.BlazeDemo.Pages.Components;

import com.BlazeDemo.Drivers.GuiDriver;
import com.BlazeDemo.Utils.DataReader.PropertyReader;
import com.BlazeDemo.Utils.Logs.LogsManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductsPage {
    private GuiDriver driver;

    public ProductsPage(GuiDriver driver) {
        this.driver = driver;
    }
    //variables
    private final String CartEndPoint = "/cart";

    //Locators

    private final By HtcPhoneProduct = By.xpath("//section[@class='product-grid home-page-product-grid']//a[.='HTC smartphone']");
    private final By AddToCartButton = By.xpath("//button[@class='button-1 add-to-cart-button']");
    private final By ProductAddedToCartSuccMessage = By.xpath("//p[@class='content']");
    private final By ProductQuantityTextBox = By.xpath("//input[@class='qty-input']");
    private final By ViewCartButton = By.xpath("//a[.='shopping cart']");
    private final By AgreeTermsCheckBox = By.xpath("//input[@id='termsofservice']");
    private final By CheckoutButton = By.xpath("//button[@id='checkout']");
    private final By ContinueBillingButton = By.xpath("//div[@id='billing-buttons-container']/button[@name='save']");
    private final By ContinueShippingButton = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    private final By ContinuePaymentButton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    private final By ContinuePaymentInfoButton = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    private final By ConfirmOrderButton = By.xpath("//button[@class='button-1 confirm-order-next-step-button']");
    private final By OrderConfirmationMessage = By.xpath("//h2[.='Your order has been successfully processed!']");
    private final By RemoveProductButton = By.xpath("//button[@class='remove-btn']");
    private final By EmptyCartMessage = By.xpath("//div[@class='no-data']");


    //dynamic Locator
   /*
    private By ProductName ( String productName){
        return  By.xpath("//div[@class='overlay-content']//p[.='"+productName+"']");
    }
    private By ProductPrice ( String productName){
        return  By.xpath("//div[@class='overlay-content']/p[.='"+productName+"']//preceding-sibling::h2");
    }

    */


    private By HoverOnProduct (String productName){
        return  By.cssSelector("[data-productid='18'] > .details [href='/htc-smartphone']");
    }
    private By AddToCartButton (String productName){
        return  By.xpath("//div[@class='productinfo text-center']/p[.='"+productName+"']//following-sibling::a");
    }
    private By ViewProduct (String productName){
        return  By.xpath("//p[.='"+productName+"']//following::div[@class='choose'][1]");
    }


    //Actions
    @Step("Navigate to products page")
    public ProductsPage navigateToHomePage() {
        driver.browser().navigateTo(PropertyReader.getProperty("BaseUrl_Web"));
        return this;
    }
    @Step("Choose a product")
    public ProductsPage ChooseProduct() {
        driver.element().click(HtcPhoneProduct);
        return this;
    }
    @Step("Click on Add To cart for a product")
    public ProductsPage clickAddToCartButton() {
        driver.element().click(AddToCartButton);
        return this;
    }
    @Step("Update Product Quantity in the Cart")
    public ProductsPage UpdateQuantity() {
        driver.element().type(ProductQuantityTextBox, "3");
        return this;
    }
    @Step("Click on Shopping Cart Button")
    public ProductsPage clickViewCartButton() {
        driver.browser().navigateTo(PropertyReader.getProperty("BaseUrl_Web") + CartEndPoint);
        return this;
    }

    @Step("Click on Checkout button")
    public ProductsPage CheckoutButton() {
        driver.element().click(AgreeTermsCheckBox).click(CheckoutButton);
        return this;
    }

    @Step("Confriming the order")
     public ProductsPage ConfirmingTheOrder() {
        driver.element().click(ContinueBillingButton).click(ContinueShippingButton).click(ContinuePaymentButton).click(ContinuePaymentInfoButton).click(ConfirmOrderButton);
        return this;
    }
    @Step("Remove a product from the cart")
    public ProductsPage RemoveProductFromCart() {
        driver.element().click(RemoveProductButton);
        return this;
    }

    //Validations
    @Step("Validate Adding Product To Cart ")
    public ProductsPage ValidationAddingProductToCart () {
        driver.verification().isElementVisible(ProductAddedToCartSuccMessage);
        return this;
    }

    @Step("Validate Order Confirmation")
    public ProductsPage ValidateOrderConfirmation() {
        driver.verification().isElementVisible(OrderConfirmationMessage);
        return this;
    }

    @Step("Validate Cart is Empty")
     public ProductsPage ValidateEmptyCart() {
        driver.verification().isElementVisible(EmptyCartMessage);
        return this;
    }

}