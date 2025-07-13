package com.myprojectnew.cucumber.util;


import com.myprojectnew.testng.objects.*;
import com.myprojectnew.testng.util.DataHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.log4testng.Logger;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import static org.testng.AssertJUnit.assertEquals;

public class TestActions {

    private static final Logger logger = Logger.getLogger(TestActions.class);

    public WebDriver driver;

    JavascriptExecutor js;

    public CartPageObject cartPageObject;
    public ContactPageObject contactPageObject;
    public HomePageObjects homePage;
    public LoginSignUpPageObject loginSignUpPage;
    public ProductDetailsPageObject productDetailsPageObject;
    public ProductsPageObject productsPageObject;
    public TestCasePageObject testCasePageObject;

    WebDriverWait explicitWait;

    public DataHandle dataHandle;

    public ExtentReportNG reporter;

    public void initDependencies() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", Map.of("autofill.profile_enabled", false));
        driver = new ChromeDriver(options);
        logger.info("Launch browser");
        driver.manage().window().maximize();

        dataHandle = new DataHandle(System.getProperty("user.dir")+"/src/test/java/resources/TestData.xlsx");

        cartPageObject = new CartPageObject(driver);
        contactPageObject = new ContactPageObject(driver);
        homePage = new HomePageObjects(driver);
        loginSignUpPage = new LoginSignUpPageObject(driver);
        productDetailsPageObject = new ProductDetailsPageObject(driver);
        productsPageObject = new ProductsPageObject(driver);
        testCasePageObject = new TestCasePageObject(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }



    public void endTest(){

        driver.quit();
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

    Alert alert;
    public void alertOkAccept(){
        alert = driver.switchTo().alert();
        alert.accept();
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

        logger.info("Navigate to url 'http://automationexercise.com'");
        driver.get("https://automationexercise.com/");

        logger.info("Verify that home page is visible successfully");
        assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");

    }

    public void navigateToLoginSignUpPage(){

        homePage = new HomePageObjects(driver);
        loginSignUpPage = new LoginSignUpPageObject(driver);

        logger.info("Click on 'Signup / Login' button");
        homePage.getSignUpLoginBtnTextLink().click();

        logger.info("Verify 'New User Signup!' is visible");
        setExplicitWait(loginSignUpPage.getNewUserSignUpIsVisible());
        assertEquals(loginSignUpPage.getNewUserSignUpIsVisible().isDisplayed(), true);

        logger.info("Verify 'Login to your account' is visible");
        setExplicitWait(loginSignUpPage.getLoginToYourAccountIsVisible());
        assertEquals(loginSignUpPage.getLoginToYourAccountIsVisible().isDisplayed(), true);

    }

    public String registerUser(List<String> userInfo){

        loginSignUpPage = new LoginSignUpPageObject(driver);

        String randomName = generateRandomString(10);
        String randomEmail = randomName.toLowerCase() + "@mail.com";

        logger.info("Enter name and email address");
        loginSignUpPage.getNameField().sendKeys(randomName);
        loginSignUpPage.getEmailAddressField().sendKeys(randomEmail);

        logger.info("Click 'Signup' button");
        loginSignUpPage.getSignUpBtn().click();

        setExplicitWait("//*[@id=\"form\"]/div/div/div/div/h2/b");
        logger.info("Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        assertEquals(loginSignUpPage.getEnterAccountInformationIsVisible().isDisplayed(), true);

        setExplicitWait(loginSignUpPage.getTitleMrFieldChkBox());

        logger.info("Fill details: Title, Name, Email, Password, Date of birth");
        loginSignUpPage.getTitleMrFieldChkBox().click();

        loginSignUpPage.getPasswordField().sendKeys(userInfo.get(0));

        scrollDown(200);

        setExplicitWait(loginSignUpPage.getSignUpForOurNewsLetterChkBox());
        logger.info("Select checkbox 'Sign up for our newsletter!");
        loginSignUpPage.getSignUpForOurNewsLetterChkBox().click();

        logger.info("Select checkbox 'Receive special offers from our partners!");
        loginSignUpPage.getReceiveSpecialOffersFromOurPartnersChkBox().click();

        logger.info("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
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

        logger.info("Verify that 'ACCOUNT CREATED!' is visible");
        loginSignUpPage.getCreateAccountBtn().click();

        setExplicitWait("//*[@id='form']/div/div/div/h2/b");
        assertEquals(loginSignUpPage.getAccountCreatedIsVisible().isDisplayed(), true);

        logger.info("Click 'Continue' button");
        loginSignUpPage.getContinueBtn().click();

        logger.info("Verify that 'Logged in as username' is visible\n");
        setExplicitWait("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
        assertEquals(loginSignUpPage.getLoggedInAsUsernameIsVisible().isDisplayed(), true);

        String result = randomName + ", " + randomEmail;

        return result;

    }

    public void login(String email){

        logger.info("Verify 'Login to your account' is visible");
        setExplicitWait("//*[contains(text(),'Login to your account')]");
        assertEquals(loginSignUpPage.getLoginToYourAccountIsVisible().isDisplayed(), true);

        logger.info("Enter correct email address and password");
        setExplicitWait("//*[@data-qa=\"login-email\"]");
        loginSignUpPage.getLoginEmailAddressField().sendKeys(email);
        loginSignUpPage.getPasswordField().sendKeys("test1234");

        logger.info("Click 'login' button");
        loginSignUpPage.getLoginBtn().click();

        logger.info("Verify that 'Logged in as username' is visible\n");
        setExplicitWait("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
        assertEquals(loginSignUpPage.getLoggedInAsUsernameIsVisible().isDisplayed(), true);

    }

    public void deleteAccount(){

        setExplicitWait("//*[contains(text(),'Delete Account')]");
        logger.info("Click 'Delete Account' button");
        loginSignUpPage.getDeleteBtn().click();

        setExplicitWait("//*[@data-qa=\"account-deleted\"]");
        logger.info("Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
        assertEquals(loginSignUpPage.getAccountDeletedIsVisible().isDisplayed(), true);

        loginSignUpPage.getContinueBtn().click();
    }


    public void orderFirstProduct(){

        homePage = new HomePageObjects(driver);
        cartPageObject = new CartPageObject(driver);

        scrollDown(500);

        logger.info("Add products to cart");
        hover(homePage.getFirstProduct());

        setExplicitWait("//p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]",5);
        homePage.getAddToCart().click();

        logger.info("Verify that cart page is displayed");
        setExplicitWait(homePage.getViewCart());
        homePage.getViewCart().click();

        boolean testUrl = driver.getCurrentUrl().equals("https://www.automationexercise.com/view_cart") || driver.getCurrentUrl().equals("https://automationexercise.com/view_cart") ? true : false;

        assertEquals(testUrl, true);

        logger.info("Click Proceed To Checkout");
        setExplicitWait(cartPageObject.getProceedToCheckoutBtn(), 5);
        cartPageObject.getProceedToCheckoutBtn().click();

    }

    public void checkoutFillDetails(List<String> checkoutInfo) {

        cartPageObject = new CartPageObject(driver);

        logger.info("Verify Address Details and Review Your Order");
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

        logger.info("Enter description in comment text area and click 'Place Order'");
        setExplicitWait(cartPageObject.getCommentTextAreaField());
        cartPageObject.getCommentTextAreaField().sendKeys("description");

        scrollDown(500);
        cartPageObject.getPlaceOrderBtn().click();

        logger.info("Enter payment details: Name on Card, Card Number, CVC, Expiration date");
        setExplicitWait(cartPageObject.getNameOnCardField());
        cartPageObject.getNameOnCardField().sendKeys(checkoutInfo.get(0));
        cartPageObject.getCardNumberField().sendKeys(checkoutInfo.get(1));
        cartPageObject.getCvcField().sendKeys(checkoutInfo.get(2));
        cartPageObject.getExpirationDateMonthField().sendKeys(checkoutInfo.get(3));
        cartPageObject.getExpirationDateYearField().sendKeys(checkoutInfo.get(4));

        logger.info("Click 'Pay and Confirm Order' button");
        scrollDown(500);
        cartPageObject.getPayAndConfirmBtn().click();

        logger.info(" Verify success message 'Your order has been placed successfully!'");
        setExplicitWait(cartPageObject.getYourOrderHasBeenPlacedSuccessfullyIsVisible());
        assertEquals(cartPageObject.getYourOrderHasBeenPlacedSuccessfullyIsVisible().isDisplayed(), true);
    }



}
