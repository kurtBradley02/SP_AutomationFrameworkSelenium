package com.myprojectnew.testng.util;

import com.myprojectnew.testng.objects.*;
import com.myprojectnew.testng.objects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class StandAloneTests {

    WebDriver driver;

    JavascriptExecutor js;

    CartPageObject cartPageObject;
    ContactPageObject contactPageObject;
    HomePageObjects homePage;
    LoginSignUpPageObject loginSignUpPage;
    ProductDetailsPageObject productDetailsPageObject;
    ProductsPageObject productsPageObject;
    TestCasePageObject testCasePageObject;

    WebDriverWait explicitWait;

    public StandAloneTests(WebDriver driver){
        this.driver = driver;
    }

    //Reusables
    public void setExplicitWait(String locator){
        By loc = By.xpath(locator);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(loc));
    }

    public void setExplicitWait(String locator, int duration){
        By loc = By.xpath(locator);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(loc));
    }

    public void setExplicitWait(WebElement elem){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(d -> elem.isDisplayed());
    }

    public void setExplicitWait(List<WebElement> elems){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elems));
    }

    public void setExplicitWait(WebElement elem, int duration){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        explicitWait.until(d -> elem.isDisplayed());
    }

    public void alertWait(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void scrollDown(Integer distance){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+distance.toString()+")");
    }

    public void scrollUp(Integer distance){
        js = (JavascriptExecutor) driver;
        distance = distance * -1;
        js.executeScript("window.scrollBy(0,"+distance.toString()+")");
    }

    Actions action;
    public void hover(WebElement elem){
        action = new Actions(driver);
        action.moveToElement(elem).perform();
    }

    public String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    //Standalone tests

    public void initHomePage(){
        driver.get("https://automationexercise.com/");

        assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");

    }

    public void navigateToLoginSignUpPage(){

        homePage = new HomePageObjects(driver);
        loginSignUpPage = new LoginSignUpPageObject(driver);

        homePage.getSignUpLoginBtnTextLink().click();

        setExplicitWait(loginSignUpPage.getNewUserSignUpIsVisible());
        assertEquals(loginSignUpPage.getNewUserSignUpIsVisible().isDisplayed(), true);

        setExplicitWait(loginSignUpPage.getLoginToYourAccountIsVisible());
        assertEquals(loginSignUpPage.getLoginToYourAccountIsVisible().isDisplayed(), true);

    }

    public String registerUser(List<String> userInfo){

        loginSignUpPage = new LoginSignUpPageObject(driver);

        String randomName = generateRandomString(10);
        String randomEmail = randomName.toLowerCase() + "@mail.com";

        loginSignUpPage.getNameField().sendKeys(randomName);
        loginSignUpPage.getEmailAddressField().sendKeys(randomEmail);
        loginSignUpPage.getSignUpBtn().click();

        setExplicitWait("//*[@id=\"form\"]/div/div/div/div/h2/b");
        assertEquals(loginSignUpPage.getEnterAccountInformationIsVisible().isDisplayed(), true);

        setExplicitWait(loginSignUpPage.getTitleMrFieldChkBox());
        loginSignUpPage.getTitleMrFieldChkBox().click();

        loginSignUpPage.getPasswordField().sendKeys(userInfo.get(0));

        scrollDown(200);

        setExplicitWait(loginSignUpPage.getSignUpForOurNewsLetterChkBox());
        loginSignUpPage.getSignUpForOurNewsLetterChkBox().click();
        loginSignUpPage.getReceiveSpecialOffersFromOurPartnersChkBox().click();

        loginSignUpPage.getFirstNameField().sendKeys(userInfo.get(1));
        loginSignUpPage.getLastNameField().sendKeys(userInfo.get(2));
        loginSignUpPage.getCompanyField().sendKeys(userInfo.get(3));

        loginSignUpPage.getAddressField().sendKeys(userInfo.get(4));
        loginSignUpPage.getAddress2Field().sendKeys(userInfo.get(5));

        scrollDown(200);

        loginSignUpPage.getStateField().sendKeys(userInfo.get(6));
        loginSignUpPage.getCityField().sendKeys(userInfo.get(7));
        loginSignUpPage.getZipCode().sendKeys(userInfo.get(8));
        loginSignUpPage.getMobileNumber().sendKeys(userInfo.get(9));

        scrollDown(200);

        loginSignUpPage.getCreateAccountBtn().click();

        setExplicitWait("//*[@id='form']/div/div/div/h2/b");
        assertEquals(loginSignUpPage.getAccountCreatedIsVisible().isDisplayed(), true);

        loginSignUpPage.getContinueBtn().click();

        setExplicitWait("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
        assertEquals(loginSignUpPage.getLoggedInAsUsernameIsVisible().isDisplayed(), true);

        String result = randomName + ", " + randomEmail;

        return result;

    }

    public void login(String email){

        setExplicitWait("//*[contains(text(),'Login to your account')]");
        assertEquals(loginSignUpPage.getLoginToYourAccountIsVisible().isDisplayed(), true);

        setExplicitWait("//*[@data-qa=\"login-email\"]");
        loginSignUpPage.getLoginEmailAddressField().sendKeys(email);
        loginSignUpPage.getPasswordField().sendKeys("test1234");
        loginSignUpPage.getLoginBtn().click();

        setExplicitWait("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
        assertEquals(loginSignUpPage.getLoggedInAsUsernameIsVisible().isDisplayed(), true);

    }

    public void deleteAccount(){

        setExplicitWait("//*[contains(text(),'Delete Account')]");
        loginSignUpPage.getDeleteBtn().click();

        setExplicitWait("//*[@data-qa=\"account-deleted\"]");
        assertEquals(loginSignUpPage.getAccountDeletedIsVisible().isDisplayed(), true);

        loginSignUpPage.getContinueBtn().click();
    }


    public void orderFirstProduct() throws InterruptedException {

        homePage = new HomePageObjects(driver);
        cartPageObject = new CartPageObject(driver);

        scrollDown(500);

        hover(homePage.getFirstProduct());

        //setExplicitWait("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a",5);
        setExplicitWait("//p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]",5);
        homePage.getAddToCart().click();

        setExplicitWait(homePage.getViewCart());
        homePage.getViewCart().click();

        boolean testUrl = driver.getCurrentUrl().equals("https://www.automationexercise.com/view_cart") || driver.getCurrentUrl().equals("https://automationexercise.com/view_cart") ? true : false;

        assertEquals(testUrl, true);

        setExplicitWait(cartPageObject.getProceedToCheckoutBtn(), 5);
        cartPageObject.getProceedToCheckoutBtn().click();

    }

    public void checkoutFillDetails(List<String> checkoutInfo) {

        cartPageObject = new CartPageObject(driver);

        setExplicitWait(cartPageObject.getCheckoutAddressDelivery());
        assertEquals(cartPageObject.getCheckoutAddressDelivery().getText().equals("YOUR DELIVERY ADDRESS\nMr. Kurt Jocson\n" +
                "earth\n" +
                "earth\n" +
                "metro manila\n" +
                "las pinas metro manila 1747\n" +
                "India\n" +
                "09777716364"),true);

        setExplicitWait(cartPageObject.getCheckoutBillingDelivery());
        assertEquals(cartPageObject.getCheckoutBillingDelivery().getText().equals("YOUR BILLING ADDRESS\nMr. Kurt Jocson\n" +
                "earth\n" +
                "earth\n" +
                "metro manila\n" +
                "las pinas metro manila 1747\n" +
                "India\n" +
                "09777716364"),true);

        setExplicitWait(cartPageObject.getCheckoutReview());
        assertEquals(cartPageObject.getCheckoutReview().isDisplayed(), true);

        scrollDown(500);

        setExplicitWait(cartPageObject.getCommentTextAreaField());
        cartPageObject.getCommentTextAreaField().sendKeys("description");

        scrollDown(500);
        cartPageObject.getPlaceOrderBtn().click();

        setExplicitWait(cartPageObject.getNameOnCardField());
        cartPageObject.getNameOnCardField().sendKeys(checkoutInfo.get(0));
        cartPageObject.getCardNumberField().sendKeys(checkoutInfo.get(1));
        cartPageObject.getCvcField().sendKeys(checkoutInfo.get(2));
        cartPageObject.getExpirationDateMonthField().sendKeys(checkoutInfo.get(3));
        cartPageObject.getExpirationDateYearField().sendKeys(checkoutInfo.get(4));

        scrollDown(500);
        cartPageObject.getPayAndConfirmBtn().click();

        setExplicitWait(cartPageObject.getYourOrderHasBeenPlacedSuccessfullyIsVisible());
        assertEquals(cartPageObject.getYourOrderHasBeenPlacedSuccessfullyIsVisible().isDisplayed(), true);
    }



}
