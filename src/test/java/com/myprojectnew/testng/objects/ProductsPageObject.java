package com.myprojectnew.testng.objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ProductsPageObject {

    WebDriver driver;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
    WebElement allProductsIsVisible;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]")
    WebElement productsListIsVisible;

    @FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
    WebElement firstProductViewProductsBtn;

    @FindBy(xpath = "a")
    WebElement productDetailPage;

    //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

    @FindBy(xpath = "a")
    WebElement detailIsVisible;

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

    @FindBy(xpath = "//*[contains(text(),'Brands')]")
    WebElement brandIsVisible;

    //6. Enter product name in search input and click search button

    @FindBy(xpath = "//*[@id=\"search_product\"]")
    WebElement productNameField;

    @FindBy(xpath = "//*[@id=\"submit_search\"]")
    WebElement searchBtn;

    //End 6. Enter product name in search input and click search button

    @FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div/h2")
    WebElement searchedProductIsVisible;

    @FindBy(xpath = "//*[contains(text(),'Searched Products')]")
    WebElement searchedProductTitleIsVisible;

    @FindBy(xpath = "//*[contains(text(),'Sleeveless')]")
    WebElement allProductsRelatedToSearchIsVisible;

    @FindBy(xpath = "a")
    WebElement womenDrpDwnBtnIsVisible;

    @FindBy(xpath = "a")
    WebElement womenCategoryDressBtn;

    @FindBy(xpath = "a")
    WebElement womenTopsProductsIsVisible;

    @FindBy(xpath = "a")
    WebElement menDrpDwnBtnIsVisible;

    @FindBy(xpath = "a")
    WebElement menCategoryJeansBtn;

    @FindBy(xpath = "a")
    WebElement menJeansProductsIsVisible;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/div[3]/h2")
    WebElement brandsIsVisible;

    @FindBy(xpath = "//*[contains(text(),'(6)')]")
    WebElement poloBtnTextLink;

    @FindBy(xpath = "a")
    WebElement brandPageIsVisible;

    @FindBy(xpath = "a")
    WebElement brandProductsIsVisible;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a\n")
    WebElement writeYourReviewIsVisible;

    //7. Enter name, email and review

    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement nameField;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailField;

    @FindBy(xpath = "//*[@id=\"review\"]")
    WebElement reviewField;

    @FindBy(xpath = "//*[@id=\"button-review\"]")
    WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"review-section\"]/div/div/span\n")
    WebElement thankYouForYourReviewIsVisible;

    @FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/h2")
    WebElement womenTopsProductIsVisible;

    @FindBy(xpath = "//*[@id='accordian']/div[2]/div[1]/h4/a")
    WebElement menCategoryBtn;

    @FindBy(xpath = "//*[@id=\"Men\"]/div/ul/li[1]/a")
    WebElement tshirtCategoryBtn;

    @FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/h2")
    WebElement tshirtCategoryIsVisible;

    @FindBy(xpath = "//*[@id=\"search_product\"]")
    WebElement cart;

    @FindBy(xpath = "//*[@id=\"search_product\"]")
    WebElement searchField;

    @FindBy(xpath = "//*[contains(text(),'Polo Products')]")
    WebElement poloProductsIsVisible;

    public List<WebElement> getAllProductsRelatedIsVisible() {
        return driver.findElements(By.xpath("//*[contains(text(),'Dress')]"));
    }

    public List<WebElement> getRelatedProductsIsVisible() {
        return driver.findElements(By.xpath("//*[contains(text(),'Dress')]"));
    }

    public WebElement getPoloProductsIsVisible() {
        return poloProductsIsVisible;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getTshirtCategoryIsVisible() {
        return tshirtCategoryIsVisible;
    }

    public WebElement getWomenTopsProductIsVisible() {
        return womenTopsProductIsVisible;
    }

    public WebElement getMenCategoryBtn() {
        return menCategoryBtn;
    }

    public WebElement getTshirtCategoryBtn() {
        return tshirtCategoryBtn;
    }

    public WebElement getAllProductsIsVisible() {
        return allProductsIsVisible;
    }

    public WebElement getProductsListIsVisible() {
        return productsListIsVisible;
    }

    public WebElement getFirstProductViewProductsBtn() {
        return firstProductViewProductsBtn;
    }

    public WebElement getProductDetailPage() {
        return productDetailPage;
    }

    public WebElement getDetailIsVisible() {
        return detailIsVisible;
    }

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

    public WebElement getProductNameField() {
        return productNameField;
    }

    public WebElement getSearchBtn() {
        return searchBtn;
    }

    public WebElement getSearchedProductIsVisible() {
        return searchedProductIsVisible;
    }

    public WebElement getAllProductsRelatedToSearchIsVisible() {
        return allProductsRelatedToSearchIsVisible;
    }


    public WebElement getSearchedProductTitleIsVisible() {
        return searchedProductTitleIsVisible;
    }

    public WebElement getWomenDrpDwnBtnIsVisible() {
        return womenDrpDwnBtnIsVisible;
    }

    public WebElement getWomenCategoryDressBtn() {
        return womenCategoryDressBtn;
    }

    public WebElement getWomenTopsProductsIsVisible() {
        return womenTopsProductsIsVisible;
    }

    public WebElement getMenDrpDwnBtnIsVisible() {
        return menDrpDwnBtnIsVisible;
    }

    public WebElement getMenCategoryJeansBtn() {
        return menCategoryJeansBtn;
    }

    public WebElement getMenJeansProductsIsVisible() {
        return menJeansProductsIsVisible;
    }

    public WebElement getBrandsIsVisible() {
        return brandsIsVisible;
    }

    public WebElement getPoloBtnTextLink() {
        return poloBtnTextLink;
    }

    public WebElement getBrandPageIsVisible() {
        return brandPageIsVisible;
    }

    public WebElement getBrandProductsIsVisible() {
        return brandProductsIsVisible;
    }

    public WebElement getWriteYourReviewIsVisible() {
        return writeYourReviewIsVisible;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getReviewField() {
        return reviewField;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getThankYouForYourReviewIsVisible() {
        return thankYouForYourReviewIsVisible;
    }

    public ProductsPageObject(WebDriver driver) {


        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


}
