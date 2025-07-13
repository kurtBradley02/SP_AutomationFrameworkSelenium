package com.myprojectnew.cucumber.objects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPageObject {

    WebDriver driver;

    //10. Verify their prices, quantity and total price

    @FindBy(xpath = "//*[@id=\"product-1\"]/td[3]/p")
    WebElement price1IsVisible;

    @FindBy(xpath = "//*[@id=\"product-2\"]/td[3]/p")
    WebElement price2IsVisible;

    @FindBy(xpath = "//*[@id=\"product-1\"]/td[4]/button")
    WebElement quantity1IsVisible;

    @FindBy(xpath = "//*[@id=\"product-2\"]/td[4]/button")
    WebElement quantity2IsVisible;

    @FindBy(xpath = "//*[@id=\"product-1\"]/td[5]/p")
    WebElement total1IsVisible;

    @FindBy(xpath = "//*[@id=\"product-2\"]/td[5]/p")
    WebElement total2IsVisible;


    @FindBy(xpath = "//*[@id=\"do_action\"]/div[1]/div/div/a")
    WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")
    WebElement registerLoginBtnTextLink;

    @FindBy(xpath = "//*[@id=\"address_delivery\"]")
    WebElement addressDetailsIsVisible;


    @FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea")
    WebElement commentTextAreaField;

    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
    WebElement placeOrderBtn;


    @FindBy(xpath = "//*[@data-qa=\"name-on-card\"]")
    WebElement nameOnCardField;

    @FindBy(xpath = "//*[@data-qa=\"card-number\"]")
    WebElement cardNumberField;

    @FindBy(xpath = "//*[@data-qa=\"cvc\"]")
    WebElement cvcField;

    @FindBy(xpath = "//*[@data-qa=\"expiry-month\"]")
    WebElement expirationDateMonthField;

    @FindBy(xpath = "//*[@data-qa=\"expiry-year\"]")
    WebElement expirationDateYearField;

    //End 16. Enter payment details: Name on Card, Card Number, CVC, Expiration date

    @FindBy(xpath = "//*[@data-qa=\"pay-button\"]")
    WebElement payAndConfirmBtn;

    @FindBy(xpath = "//*[contains(text(),'Your order has been confirmed')]")
    WebElement yourOrderHasBeenPlacedSuccessfullyIsVisible;


    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/a\n"
            + "")
    WebElement downloadInvoiceBtn;

    @FindBy(xpath="//*[@id=\"product-1\"]/td[2]/h4/a")
    WebElement firstProductIsVisible;

    @FindBy(xpath="//*[@id=\"product-2\"]/td[2]/h4/a")
    WebElement secondProductIsVisible;

    @FindBy(xpath="//*[@id=\"product-1\"]/td[6]/a")
    WebElement removeItem;

    @FindBy(xpath="//*[@id=\"empty_cart\"]/p/b")
    WebElement cartIsEmptyIsVisible;

    @FindBy(xpath="//*[@data-qa=\"continue-button\"]")
    WebElement continueBtn;

    @FindBy(xpath="//*[contains(text(),'Stylish Dress')]")
    WebElement stylishDressOnCartIsVisible;

    @FindBy(xpath = "//*[@id=\"address_delivery\"]")
    WebElement checkoutAddressDelivery;

    @FindBy(xpath = "//*[@id=\"address_invoice\"]")
    WebElement checkoutBillingDelivery;

    @FindBy(xpath = "//*[contains(text(),'Review')]")
    WebElement checkoutReview;

    public WebElement getCheckoutReview() {
        return checkoutReview;
    }

    public WebElement getCheckoutAddressDelivery() {
        return checkoutAddressDelivery;
    }

    public WebElement getCheckoutBillingDelivery() {
        return checkoutBillingDelivery;
    }

    public WebElement getAddressDetailsIsVisible() {
        return addressDetailsIsVisible;
    }

    public WebElement getStylishDressOnCartIsVisible() {
        return stylishDressOnCartIsVisible;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }

    public WebElement getRemoveItem() {
        return removeItem;
    }

    public WebElement getCartIsEmptyIsVisible() {
        return cartIsEmptyIsVisible;
    }

    public WebElement getSecondProductIsVisible() {
        return secondProductIsVisible;
    }

    public WebElement getFirstProductIsVisible() {
        return firstProductIsVisible;
    }


    public WebElement getPrice1IsVisible() {
        return price1IsVisible;
    }

    public WebElement getPrice2IsVisible() {
        return price2IsVisible;
    }

    public WebElement getQuantity1IsVisible() {
        return quantity1IsVisible;
    }

    public WebElement getQuantity2IsVisible() {
        return quantity2IsVisible;
    }


    public WebElement getProceedToCheckoutBtn() {
        return proceedToCheckoutBtn;
    }

    public WebElement getRegisterLoginBtnTextLink() {
        return registerLoginBtnTextLink;
    }

    public WebElement getAddressAndReviewOrderDetailsIsVisible() {
        return addressDetailsIsVisible;
    }


    public WebElement getCommentTextAreaField() {
        return commentTextAreaField;
    }

    public WebElement getPlaceOrderBtn() {
        return placeOrderBtn;
    }

    public WebElement getNameOnCardField() {
        return nameOnCardField;
    }

    public WebElement getCardNumberField() {
        return cardNumberField;
    }

    public WebElement getCvcField() {
        return cvcField;
    }

    public WebElement getExpirationDateMonthField() {
        return expirationDateMonthField;
    }

    public WebElement getExpirationDateYearField() {
        return expirationDateYearField;
    }

    public WebElement getPayAndConfirmBtn() {
        return payAndConfirmBtn;
    }

    public WebElement getYourOrderHasBeenPlacedSuccessfullyIsVisible() {
        return yourOrderHasBeenPlacedSuccessfullyIsVisible;
    }

    public WebElement getDownloadInvoiceBtn() {
        return downloadInvoiceBtn;
    }

    public CartPageObject(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


}
