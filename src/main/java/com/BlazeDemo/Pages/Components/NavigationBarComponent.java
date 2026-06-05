package com.BlazeDemo.Pages.Components;

import com.BlazeDemo.Drivers.GuiDriver;
import com.BlazeDemo.Utils.DataReader.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NavigationBarComponent {
    private final GuiDriver driver;
    //Initialize the driver obj
    public NavigationBarComponent(GuiDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By ProductsButton = By.cssSelector("a[href='/products']");
    private final By HomeButton = By.xpath("//img[@alt='nopCommerce demo store']");
    private final By MyAccountButton = By.xpath("//div[@class='header-links']//a[.='My account']");
    private final By LogOutButton = By.xpath("//a[.='Log out']");
    private final By WhishlistButton = By.xpath("//span[@class='wishlist-label']");
    private final By ShoppingCartButton = By.xpath("//span[@class='cart-label']");

    //Actions
    @Step("Navigate To Home Page")
    public NavigationBarComponent navigate() {
        driver.browser().navigateTo(PropertyReader.getProperty("BaseUrl_Web"));
        return this;
    }

    @Step("Click on Home Button")
    public NavigationBarComponent clickHomeButton() {
        driver.element().findElement(HomeButton).click();
        return this;
    }

}