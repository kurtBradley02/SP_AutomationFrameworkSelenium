package com.myprojectnew.cucumber.objects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductDetailsPageObject {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"quantity\"]")
    WebElement quantityField;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
    WebElement addToCart;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
    WebElement productNameIsVisible;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]")
    WebElement categoryIsVisible;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")
    WebElement priceIsVisible;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b")
    WebElement availabilityIsVisible;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b")
    WebElement conditionIsVisible;

    public WebElement getProductNameIsVisible() {
        return productNameIsVisible;
    }

    public WebElement getCategoryIsVisible() {
        return categoryIsVisible;
    }

    public WebElement getPriceIsVisible() {
        return priceIsVisible;
    }

    public WebElement getAvailabilityIsVisible() {
        return availabilityIsVisible;
    }

    public WebElement getConditionIsVisible() {
        return conditionIsVisible;
    }

    public WebElement getBrandIsVisible() {
        return brandIsVisible;
    }

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b")
    WebElement brandIsVisible;

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getQuantityField() {
        return quantityField;
    }

    public ProductDetailsPageObject(WebDriver driver) {


        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}