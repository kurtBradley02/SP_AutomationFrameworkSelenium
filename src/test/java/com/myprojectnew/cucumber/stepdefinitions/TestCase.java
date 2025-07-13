package com.myprojectnew.cucumber.stepdefinitions;

import com.myprojectnew.cucumber.util.TestActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestCase {

    private static final Logger logger = Logger.getLogger(TestCase.class);

    public TestActions actions;
    String[] result;

    @Given("Test Case One: Pre-Requirements")
    public void testCase1PreRequirements(){
        logger.info("Test Case One: Pre-requirements ");
    }

    @When("Test Case One: Steps")
    public void testCase1RegisterUser() throws IOException {

        actions = new TestActions();
        actions.initDependencies();
        actions.initHomePage();
        actions.navigateToLoginSignUpPage();
        List<String> userInfo = actions.dataHandle.getAllValuesInColumn(0, 1);
        actions.registerUser(userInfo);
        actions.deleteAccount();
    }

    @Then("Test Case One: Post-Requirements")
    public void testCase1PostRequirements() {
        logger.info("Test Case One: Post-requirements ");
        actions.endTest();
    }

    @Given("Test Case Two: Pre-Requirements")
    public void testCase2PreRequirements() throws IOException {
        logger.info("Test Case Two: Pre-requirements (Register User)");
        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();
        actions.navigateToLoginSignUpPage();
        List<String> userInfo = actions.dataHandle.getAllValuesInColumn(0, 1);
        result = actions.registerUser(userInfo).split(", ");

        actions.setExplicitWait(actions.loginSignUpPage.getLogoutBtn());
        actions.loginSignUpPage.getLogoutBtn().click();
    }

    @When("Test Case Two: Steps")
    public void testCase2LoginUserWithCorrectEmailAndPassword() {

        actions.initHomePage();

        actions.navigateToLoginSignUpPage();

        actions.login(result[1]);

        actions.deleteAccount();
    }

    @Then("Test Case Two: Post-Requirements")
    public void testCase2PostRequirements() {
        logger.info("Test Case Two: Post-Requirements");
        actions.endTest();
    }


    @Given("Test Case Three: Pre-Requirements")
    public void testCase3PreRequirements(){
        logger.info("Test Case Three: Pre-Requirements");
    }

    @When("Test Case Three: Steps")
    public void testCase3Steps()  throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        actions.navigateToLoginSignUpPage();

        List<String> incorrectInfo = actions.dataHandle.getAllValuesInColumn(3, 1);

        logger.info("Enter incorrect email address and password");
        actions.loginSignUpPage.getLoginEmailAddressField().sendKeys(incorrectInfo.get(0));
        actions.loginSignUpPage.getPasswordField().sendKeys(incorrectInfo.get(1));

        logger.info("Click 'login' button");
        actions.loginSignUpPage.getLoginBtn().click();

        logger.info("Verify error 'Your email or password is incorrect!' is visible");
        actions.setExplicitWait("//*[@id=\"form\"]/div/div/div[1]/div/form/p");
        assertEquals(actions.loginSignUpPage.getYourEmailAndPasswordIsIncorrectIsVisible().isDisplayed(), true);
    }

    @Then("Test Case Three: Post-Requirements")
    public void testCase3PostRequirements() {
        logger.info("Test Case Three: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Four: Pre-Requirements")
    public void testCase4PreRequirements() throws IOException {
        logger.info("Test Case Four: Pre-Requirements(Register User)");
        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();
        actions.navigateToLoginSignUpPage();
        List<String> userInfo = actions.dataHandle.getAllValuesInColumn(0, 1);
        result = actions.registerUser(userInfo).split(", ");
        actions.setExplicitWait("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
        actions.loginSignUpPage.getLogoutBtn().click();
    }

    @When("Test Case Four: Steps")
    public void testCase4Steps() {
        actions.initHomePage();

        actions.navigateToLoginSignUpPage();

        actions.login(result[1]);

        actions.setExplicitWait("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

        logger.info("Click 'Logout' button");
        actions.loginSignUpPage.getLogoutBtn().click();

        boolean testUrl = actions.driver.getCurrentUrl().equals("https://automationexercise.com/login") || actions.driver.getCurrentUrl().equals("https://www.automationexercise.com/login") ? true : false;

        logger.info("Verify that user is navigated to login page");
        assertEquals(testUrl, true);
    }

    @Then("Test Case Four: Post-Requirements")
    public void testCase4PostRequirements() {

        logger.info("Test Case Four: Post-Requirements(Delete User)");

        actions.initHomePage();

        actions.navigateToLoginSignUpPage();

        actions.login(result[1]);
        actions.deleteAccount();
        actions.endTest();
    }

    @Given("Test Case Five: Pre-Requirements")
    public void testCase5PreRequirements() throws IOException {

        logger.info("Test Case Five: Pre-Requirements(Register User)");

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();
        actions.navigateToLoginSignUpPage();
        List<String> userInfo = actions.dataHandle.getAllValuesInColumn(0, 1);
        result = actions.registerUser(userInfo).split(", ");
        actions.loginSignUpPage.getLogoutBtn().click();
    }

    @When("Test Case Five: Steps")
    public void testCase5Steps() {
        actions.initHomePage();

        actions.navigateToLoginSignUpPage();

        logger.info("Enter name and already registered email address");
        actions.loginSignUpPage.getNameField().sendKeys(result[0]);
        actions.loginSignUpPage.getEmailAddressField().sendKeys(result[1]);

        logger.info("Click 'Signup' button");
        actions.loginSignUpPage.getSignUpBtn().click();

        logger.info("Verify error 'Email Address already exist!' is visible");
        actions.setExplicitWait("//*[@id=\"form\"]/div/div/div[3]/div/form/p");
        assertEquals(actions.loginSignUpPage.getEmailAddressAlreadyExistIsVisible().isDisplayed(), true);    }

    @Then("Test Case Five: Post-Requirements")
    public void testCase5PostRequirements() {

        logger.info("Test Case Five: Post-Requirements(Delete user)");

        actions.initHomePage();

        actions.navigateToLoginSignUpPage();

        actions.login(result[1]);
        actions.deleteAccount();
        
        actions.endTest();
    }

    @Given("Test Case Six: Pre-Requirements")
    public void testCase6PreRequirements(){
        logger.info("Test Case Six: Pre-Requirements");

    }

    @When("Test Case Six: Steps")
    public void testCase6Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Click on 'Contact Us' button");
        actions.homePage.getContactUsBtnTextLink().click();

        logger.info("Verify 'GET IN TOUCH' is visible");
        actions.setExplicitWait("//*[@id=\"contact-us-form\"]/div[5]/input");
        assertEquals(actions.contactPageObject.getGetInTouchIsVisible().isDisplayed(), true);

        List<String> contactInfo = actions.dataHandle.getAllValuesInColumn(1, 1);

        logger.info("Enter name, email, subject and message");
        actions.contactPageObject.getNameField().sendKeys(contactInfo.get(0));
        actions.contactPageObject.getEmailField().sendKeys(contactInfo.get(1));
        actions.contactPageObject.getSubjectField().sendKeys(contactInfo.get(2));
        actions.contactPageObject.getMessageField().sendKeys(contactInfo.get(3));

        logger.info("Upload file");
        actions.contactPageObject.getUploadFileBtn().sendKeys(System.getProperty("user.dir")+contactInfo.get(4));

        actions.scrollDown(500);

        logger.info("Click 'Submit' button");
        actions.contactPageObject.getSubmitBtn().click();

        logger.info("Click OK button");
        actions.alertWait();
        actions.alertOkAccept();

        logger.info("Verify success message 'Success! Your details have been submitted successfully.' is visible");
        actions.setExplicitWait("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]");
        assertEquals(actions.contactPageObject.getSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible().isDisplayed(), true);

        logger.info("Click 'Home' button and verify that landed to home page successfully");
        actions.contactPageObject.getHomeBtn().click();

        boolean testUrl = actions.driver.getCurrentUrl().equals("https://automationexercise.com/") || actions.driver.getCurrentUrl().equals("https://www.automationexercise.com/") ? true : false;

        assertEquals(testUrl, true);    }

    @Then("Test Case Six: Post-Requirements")
    public void testCase6PostRequirements() {
        logger.info("Test Case Six: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Seven: Pre-Requirements")
    public void testCase7PreRequirements(){
        logger.info("Test Case Seven: Pre-Requirements");
    }

    @When("Test Case Seven: Steps")
    public void testCase7Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Click on 'Test Cases' button");
        actions.homePage.getTestCaseBtnTextLink().click();

        logger.info("Verify user is navigated to test cases page successfully");
        assertEquals(actions.driver.getCurrentUrl(),"https://automationexercise.com/test_cases");    }

    @Then("Test Case Seven: Post-Requirements")
    public void testCase7PostRequirements() {

        logger.info("Test Case Seven: Post-Requirements");

        actions.endTest();
    }

    @Given("Test Case Eight: Pre-Requirements")
    public void testCase8PreRequirements() throws IOException {
        logger.info("Test Case Eight: Pre-Requirements");
    }

    @When("Test Case Eight: Steps")
    public void testCase8Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Click on 'Products' button");
        actions.homePage.getProductsBtnTextLink().click();
        assertEquals(actions.driver.getCurrentUrl(),"https://automationexercise.com/products");

        logger.info("Verify user is navigated to ALL PRODUCTS page successfully");
        actions.setExplicitWait("/html/body/section[2]/div/div/div[2]/div/h2");
        assertEquals(actions.productsPageObject.getAllProductsIsVisible().isDisplayed(), true);

        actions.scrollDown(500);

        logger.info("The products list is visible");
        actions.setExplicitWait("/html/body/section[2]/div/div/div[1]");
        assertEquals(actions.productsPageObject.getProductsListIsVisible().isDisplayed(), true);

        actions.scrollDown(500);

        logger.info("Click on 'View Product' of first product");
        actions.productsPageObject.getFirstProductViewProductsBtn().click();

        logger.info("User is landed to product detail page");
        assertEquals(actions.driver.getCurrentUrl(),"https://automationexercise.com/product_details/1");

        logger.info("Verify that detail detail is visible: product name, category, price, availability, condition, brand");
        actions.setExplicitWait("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b");
        assertEquals(actions.productDetailsPageObject.getProductNameIsVisible().isDisplayed(), true);
        assertEquals(actions.productDetailsPageObject.getCategoryIsVisible().isDisplayed(), true);
        assertEquals(actions.productDetailsPageObject.getPriceIsVisible().isDisplayed(), true);
        assertEquals(actions.productDetailsPageObject.getAvailabilityIsVisible().isDisplayed(), true);
        assertEquals(actions.productDetailsPageObject.getConditionIsVisible().isDisplayed(), true);
        assertEquals(actions.productDetailsPageObject.getBrandIsVisible().isDisplayed(), true);    }

    @Then("Test Case Eight: Post-Requirements")
    public void testCase8PostRequirements() {
        logger.info("Test Case Eight: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Nine: Pre-Requirements")
    public void testCase9PreRequirements() throws IOException {
        logger.info("Test Case Nine: Pre-Requirements");
    }

    @When("Test Case Nine: Steps")
    public void testCase9Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Click on 'Products' button");
        actions.homePage.getProductsBtnTextLink().click();

        logger.info("Verify user is navigated to ALL PRODUCTS page successfully");
        assertEquals(actions.driver.getCurrentUrl(),"https://automationexercise.com/products");
        actions.setExplicitWait("/html/body/section[2]/div/div/div[2]/div/h2");
        assertEquals(actions.productsPageObject.getAllProductsIsVisible().isDisplayed(), true);

        logger.info("Enter product name in search input and click search button");
        actions.productsPageObject.getSearchField().sendKeys("Sleeveless");
        actions.productsPageObject.getSearchBtn().click();

        actions.scrollDown(500);

        logger.info("Verify 'SEARCHED PRODUCTS' is visible");
        actions.setExplicitWait("//*[contains(text(),'Searched Products')]");
        assertEquals(actions.productsPageObject.getSearchedProductTitleIsVisible().isDisplayed(), true);

        logger.info("Verify all the products related to search are visible");
        actions.setExplicitWait(actions.productsPageObject.getAllProductsRelatedToSearchIsVisible());
        assertEquals(actions.productsPageObject.getAllProductsRelatedToSearchIsVisible().isDisplayed(), true);
    }

    @Then("Test Case Nine: Post-Requirements")
    public void testCase9PostRequirements() {
        logger.info("Test Case Nine: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Ten: Pre-Requirements")
    public void testCase10PreRequirements() throws IOException {
        logger.info("Test Case Ten: Pre-Requirements");
    }

    @When("Test Case Ten: Steps")
    public void testCase10Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Scroll down to footer");
        actions.scrollDown(10000);

        logger.info("Verify text 'SUBSCRIPTION'");
        assertEquals(actions.homePage.getSubscriptionIsVisible().isDisplayed(), true);

        logger.info("Enter email address in input and click arrow button");
        actions.homePage.getEmailAddressField().sendKeys("randomtest@mail.com");
        actions.homePage.getArrowBtn().click();

        logger.info("Verify success message 'You have been successfully subscribed!' is visible");
        actions.setExplicitWait("//*[@id=\"success-subscribe\"]/div");
        assertEquals(actions.homePage.getYouHaveBeenSuccessfullySubscribedIsVisible().isDisplayed(), true);
    }

    @Then("Test Case Ten: Post-Requirements")
    public void testCase10PostRequirements() {
        logger.info("Test Case Ten: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Eleven: Pre-Requirements")
    public void testCase11PreRequirements() throws IOException {
        logger.info("Test Case Eleven: Pre-Requirements");
    }

    @When("Test Case Eleven: Steps")
    public void testCase11Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Click 'Cart' button");
        actions.homePage.getCartBtnTextLink().click();

        logger.info("Scroll down to footer");
        actions.scrollDown(1000);

        logger.info("Verify text 'SUBSCRIPTION'");
        actions.setExplicitWait("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
        assertEquals(actions.homePage.getSubscriptionIsVisible().isDisplayed(), true);

        logger.info("Enter email address in input and click arrow button");
        actions.homePage.getEmailAddressField().sendKeys("randomtest@mail.com");
        actions.homePage.getArrowBtn().click();

        logger.info("Verify success message 'You have been successfully subscribed!' is visible");
        actions.setExplicitWait("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
        assertEquals(actions.homePage.getYouHaveBeenSuccessfullySubscribedIsVisible().isDisplayed(), true);    }

    @Then("Test Case Eleven: Post-Requirements")
    public void testCase11PostRequirements() {

        logger.info("Test Case Eleven: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Twelve: Pre-Requirements")
    public void testCase12PreRequirements() throws IOException {
        logger.info("Test Case Twelve: Pre-Requirements");
    }

    @When("Test Case Twelve: Steps")
    public void testCase12Steps() throws IOException, InterruptedException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Click 'Products' button");
        actions.homePage.getProductsBtnTextLink().click();

        actions.scrollDown(500);

        logger.info("Hover over first product and click 'Add to cart'");
        actions.hover(actions.homePage.getFirstProduct());
        actions.setExplicitWait("//p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]");
        actions.homePage.getAddToCart().click();

        logger.info("Click 'Continue Shopping' button");
        actions.setExplicitWait(actions.homePage.getContinueShopping(),5);
        actions.homePage.getContinueShopping().click();

        logger.info("Hover over second product and click 'Add to cart'");
        actions.setExplicitWait(actions.homePage.getSecondProduct(), 5);
        actions.hover(actions.homePage.getSecondProduct());
        actions.scrollDown(500);
        actions.setExplicitWait(actions.homePage.getAddToCart2(), 5);
        actions.homePage.getAddToCart2().click();

        logger.info("Click 'View Cart' button");
        actions.setExplicitWait(actions.homePage.getViewCart());
        actions.homePage.getViewCart().click();

        logger.info("Verify both products are added to Cart");
        actions.setExplicitWait("//*[@id=\"product-1\"]/td[2]/h4/a");
        assertEquals(actions.cartPageObject.getFirstProductIsVisible().isDisplayed(), true);
        assertEquals(actions.cartPageObject.getSecondProductIsVisible().isDisplayed(), true);

        logger.info("Verify their prices, quantity and total price");
        assertEquals(actions.cartPageObject.getPrice1IsVisible().getText(), "Rs. 500");
        assertEquals(actions.cartPageObject.getPrice2IsVisible().getText(), "Rs. 400");

        assertEquals(actions.cartPageObject.getQuantity1IsVisible().getText(), "1");
        assertEquals(actions.cartPageObject.getQuantity2IsVisible().getText(), "1");

        assertEquals(actions.cartPageObject.getTotal1IsVisible().getText(), "Rs. 500");
        assertEquals(actions.cartPageObject.getTotal2IsVisible().getText(), "Rs. 400");

         }


    @Then("Test Case Twelve: Post-Requirements")
    public void testCase12PostRequirements() {
        logger.info("Test Case Twelve: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Thirteen: Pre-Requirements")
    public void testCase13PreRequirements() throws IOException {
        logger.info("Test Case Thirteen: Pre-Requirements");
    }

    @When("Test Case Thirteen: Steps")
    public void testCase13Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Click 'View Product' for any product on home page");
        actions.scrollDown(500);
        actions.homePage.getViewProduct().click();

        logger.info("Verify product detail is opened");
        assertEquals(actions.driver.getCurrentUrl(),"https://automationexercise.com/product_details/1");

        actions.scrollDown(500);

        logger.info("Increase quantity to 4");
        actions.productDetailsPageObject.getQuantityField().clear();
        actions.productDetailsPageObject.getQuantityField().sendKeys("4");

        logger.info("Click 'Add to cart' button");
        actions.productDetailsPageObject.getAddToCart().click();

        logger.info("Click 'View Cart' button");
        actions.setExplicitWait(actions.homePage.getViewCart());
        actions.homePage.getViewCart().click();

        logger.info("Verify that product is displayed in cart page with exact quantity");
        actions.setExplicitWait(actions.cartPageObject.getQuantity1IsVisible());
        assertEquals(actions.cartPageObject.getQuantity1IsVisible().getText(), "4");    }

    @Then("Test Case Thirteen: Post-Requirements")
    public void testCase13PostRequirements() {
        logger.info("Test Case Thirteen: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Fourteen: Pre-Requirements")
    public void testCase14PreRequirements() throws IOException {
        logger.info("Test Case Fourteen: Pre-Requirements");
    }

    @When("Test Case Fourteen: Steps")
    public void testCase14Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        actions.orderFirstProduct();

        logger.info("Click 'Register / Login' button");
        actions.cartPageObject.getRegisterLoginBtnTextLink().click();

        List<String> userInfo = actions.dataHandle.getAllValuesInColumn(0, 1);
        actions.registerUser(userInfo);

        logger.info("Click 'Cart' button");
        actions.homePage.getCartBtnTextLink().click();

        boolean testUrl = actions.driver.getCurrentUrl().equals("https://www.automationexercise.com/view_cart") || actions.driver.getCurrentUrl().equals("https://automationexercise.com/view_cart") ? true : false;

        assertEquals(testUrl, true);

        logger.info("Click 'Proceed To Checkout' button");
        actions.setExplicitWait(actions.cartPageObject.getProceedToCheckoutBtn());
        actions.cartPageObject.getProceedToCheckoutBtn().click();

        List<String> checkoutInfo = actions.dataHandle.getAllValuesInColumn(4,1);

        actions.checkoutFillDetails(checkoutInfo);

        actions.deleteAccount();
    }

    @Then("Test Case Fourteen: Post-Requirements")
    public void testCase14PostRequirements() {
        logger.info("Test Case Fourteen: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Fifteen: Pre-Requirements")
    public void testCase15PreRequirements() throws IOException {
        logger.info("Test Case Fifteen: Pre-Requirements");
    }

    @When("Test Case Fifteen: Steps")
    public void testCase15Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        actions.navigateToLoginSignUpPage();
        List<String> userInfo = actions.dataHandle.getAllValuesInColumn(0, 1);
        actions.registerUser(userInfo);

        actions.homePage.getHomeBtnTextLink().click();

        actions.orderFirstProduct();

        List<String> checkoutInfo = actions.dataHandle.getAllValuesInColumn(4,1);

        actions.checkoutFillDetails(checkoutInfo);

        actions.deleteAccount();    }

    @Then("Test Case Fifteen: Post-Requirements")
    public void testCase15PostRequirements() {
        logger.info("Test Case Fifteen: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Sixteen: Pre-Requirements")
    public void testCase16PreRequirements() throws IOException {

        logger.info("Test Case Sixteen: Pre-Requirements");

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();
        actions.navigateToLoginSignUpPage();
        List<String> userInfo = actions.dataHandle.getAllValuesInColumn(0, 1);
        result = actions.registerUser(userInfo).split(", ");

        actions.setExplicitWait("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
        actions.loginSignUpPage.getLogoutBtn().click();
    }

    @When("Test Case Sixteen: Steps")
    public void testCase16Steps() {
        actions.initHomePage();

        actions.navigateToLoginSignUpPage();

        actions.login(result[1]);

        actions.orderFirstProduct();

        List<String> checkoutInfo = actions.dataHandle.getAllValuesInColumn(4,1);

        actions.checkoutFillDetails(checkoutInfo);;

        actions.deleteAccount();    }

    @Then("Test Case Sixteen: Post-Requirements")
    public void testCase16PostRequirements() {
        logger.info("Test Case Sixteen: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Seventeen: Pre-Requirements")
    public void testCase17PreRequirements() throws IOException {

    }

    @When("Test Case Seventeen: Steps")
    public void testCase17Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        actions.scrollDown(500);

        logger.info("Add products to cart");
        actions.hover(actions.homePage.getFirstProduct());
        actions.setExplicitWait("//p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]");
        actions.homePage.getAddToCart().click();

        logger.info("Click 'Cart' button");
        actions.setExplicitWait(actions.homePage.getViewCart());
        actions.homePage.getViewCart().click();

        logger.info("Verify that cart page is displayed");
        boolean testUrl = actions.driver.getCurrentUrl().equals("https://www.automationexercise.com/view_cart") || actions.driver.getCurrentUrl().equals("https://automationexercise.com/view_cart") ? true : false;

        assertEquals(testUrl, true);

        logger.info("Click 'X' button corresponding to particular product");
        actions.setExplicitWait(actions.cartPageObject.getRemoveItem());
        actions.cartPageObject.getRemoveItem().click();

        logger.info("Verify that product is removed from the cart");
        actions.setExplicitWait(actions.cartPageObject.getCartIsEmptyIsVisible());
        assertEquals(actions.cartPageObject.getCartIsEmptyIsVisible().isDisplayed(), true);    }

    @Then("Test Case Seventeen: Post-Requirements")
    public void testCase17PostRequirements() {
        logger.info("Test Case Seventeen: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Eighteen: Pre-Requirements")
    public void testCase18PreRequirements() throws IOException {
        logger.info("Test Case Eighteen: Pre-Requirements");
    }

    @When("Test Case Eighteen: Steps")
    public void testCase18Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        actions.scrollDown(500);

        logger.info("Verify that categories are visible on left side bar");
        actions.setExplicitWait(actions.homePage.getCategoryIsVisible());
        assertEquals(actions.homePage.getCategoryIsVisible().isDisplayed(), true);

        logger.info("Click on 'Women' category");
        actions.homePage.getWomenCategoryBtn().click();

        logger.info("Click on any category link under 'Women' category, for example: Dress");
        actions.setExplicitWait(actions.homePage.getWomenTopsCategoryBtn());
        actions.homePage.getWomenTopsCategoryBtn().click();

        logger.info("Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'");
        actions.setExplicitWait(actions.productsPageObject.getWomenTopsProductIsVisible());
        boolean testUrl = actions.driver.getCurrentUrl().equals("https://www.automationexercise.com/category_products/2") || actions.driver.getCurrentUrl().equals("https://automationexercise.com/category_products/2") ? true : false;
        assertEquals(testUrl, true);
        assertEquals(actions.productsPageObject.getWomenTopsProductIsVisible().isDisplayed(), true);

        logger.info("On left side bar, click on any sub-category link of 'Men' category");
        actions.productsPageObject.getMenCategoryBtn().click();
        actions.setExplicitWait(actions.productsPageObject.getTshirtCategoryBtn());
        actions.productsPageObject.getTshirtCategoryBtn().click();

        logger.info("Verify that user is navigated to that category page");
        actions.setExplicitWait(actions.productsPageObject.getTshirtCategoryIsVisible());
        assertEquals(actions.productsPageObject.getTshirtCategoryIsVisible().isDisplayed(), true);    }

    @Then("Test Case Eighteen: Post-Requirements")
    public void testCase18PostRequirements() {
        logger.info("Test Case Eighteen: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Nineteen: Pre-Requirements")
    public void testCase19PreRequirements() throws IOException {

    }

    @When("Test Case Nineteen: Steps")
    public void testCase19Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Click on 'Products' button");
        actions.homePage.getProductsBtnTextLink().click();

        actions.scrollDown(500);

        logger.info("Verify that Brands are visible on left side bar");
        actions.setExplicitWait(actions.productsPageObject.getBrandIsVisible());
        assertEquals(actions.productsPageObject.getBrandIsVisible().isDisplayed(), true);

        logger.info("Click on any brand name");
        actions.productsPageObject.getPoloBtnTextLink().click();

        logger.info("Verify that user is navigated to brand page and brand products are displayed");
        assertEquals(actions.driver.getCurrentUrl(), "https://automationexercise.com/brand_products/Polo");

        logger.info("On left side bar, click on any other brand link");
        actions.setExplicitWait(actions.productsPageObject.getBrandIsVisible());
        assertEquals(actions.productsPageObject.getBrandIsVisible().isDisplayed(), true);

        actions.productsPageObject.getPoloBtnTextLink().click();

        logger.info("Verify that user is navigated to that brand page and can see products");
        assertEquals(actions.driver.getCurrentUrl(), "https://automationexercise.com/brand_products/Polo");    }

    @Then("Test Case Nineteen: Post-Requirements")
    public void testCase19PostRequirements() {
        logger.info("Test Case Nineteen: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Twenty: Pre-Requirements")
    public void testCase20PreRequirements() throws IOException {

        logger.info("Test Case Twenty: Pre-Requirements(Register User)");

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();
        actions.navigateToLoginSignUpPage();
        List<String> userInfo = actions.dataHandle.getAllValuesInColumn(0, 1);
        result = actions.registerUser(userInfo).split(", ");

        actions.setExplicitWait("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
        actions.loginSignUpPage.getLogoutBtn().click();
        
    }

    @When("Test Case Twenty: Steps")
    public void testCase20Steps() {
        actions.initHomePage();

        logger.info("Click on 'Products' button");
        actions.homePage.getProductsBtnTextLink().click();

        actions.scrollDown(200);

        logger.info("Verify user is navigated to ALL PRODUCTS page successfully");
        actions.setExplicitWait(actions.productsPageObject.getAllProductsIsVisible());
        assertEquals(actions.productsPageObject.getAllProductsIsVisible().isDisplayed(), true);

        logger.info("Enter product name in search input and click search button");
        actions.productsPageObject.getSearchField().sendKeys("Sleeveless");
        actions.productsPageObject.getSearchBtn().click();

        logger.info("Verify 'SEARCHED PRODUCTS' is visible");
        actions.setExplicitWait(actions.productsPageObject.getSearchedProductIsVisible());
        assertEquals(actions.productsPageObject.getSearchedProductIsVisible().isDisplayed(), true);

        actions.scrollDown(500);

        logger.info("Verify all the products related to search are visible");
        List<WebElement> elems = actions.productsPageObject.getAllProductsRelatedIsVisible();
        assertEquals(elems.size() > 0, true);

        logger.info("Add those products to cart");
        actions.hover(actions.homePage.getFirstProduct());
        actions.setExplicitWait("//p[text()='Sleeveless Dress']/following-sibling::a[contains(@class, 'add-to-cart')]");
        actions.homePage.getSleevelessAddToCart().click();
        actions.homePage.getContinueShopping().click();
        actions.scrollDown(200);
        actions.hover(actions.homePage.getSecondProduct());
        actions.setExplicitWait(actions.homePage.getSecondAddToCart());
        actions.homePage.getSecondAddToCart().click();
        actions.homePage.getContinueShopping().click();
        actions.hover(actions.homePage.getThirdProduct());
        actions.setExplicitWait(actions.homePage.getThirdAddToCart());
        actions.homePage.getThirdAddToCart().click();

        logger.info("Click 'Cart' button and verify that products are visible in cart");
        actions.setExplicitWait(actions.homePage.getViewCart());
        actions.homePage.getViewCart().click();
        assertEquals(actions.driver.getCurrentUrl(),"https://automationexercise.com/view_cart");
        elems = actions.productsPageObject.getRelatedProductsIsVisible();
        assertEquals(elems.size() > 0, true);

        logger.info("Click 'Signup / Login' button and submit login details");
        actions.navigateToLoginSignUpPage();
        actions.login(result[1]);

        logger.info("Again, go to Cart page");
        actions.homePage.getCartBtnTextLink().click();
        actions.scrollDown(500);

        logger.info("Verify that those products are visible in cart after login as well");
        elems = actions.productsPageObject.getRelatedProductsIsVisible();
        assertEquals(elems.size() > 0, true);
        actions.scrollUp(500);
        actions.loginSignUpPage.getLogoutBtn().click();
    }

    @Then("Test Case Twenty: Post-Requirements")
    public void testCase20PostRequirements() {
        logger.info("Test Case Twenty: Post-Requirements(Delete User)");
        actions.initHomePage();

        actions.navigateToLoginSignUpPage();

        actions.login(result[1]);
        actions.deleteAccount();
        actions.endTest();
    }

    @Given("Test Case Twenty-One: Pre-Requirements")
    public void testCase21PreRequirements() throws IOException {
        logger.info("Test Case Twenty-One: Pre-Requirements");
    }

    @When("Test Case Twenty-One: Steps")
    public void testCase21Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Click on 'Products' button");
        actions.homePage.getProductsBtnTextLink().click();

        logger.info("Verify user is navigated to ALL PRODUCTS page successfully");
        actions.setExplicitWait(actions.productsPageObject.getAllProductsIsVisible());
        assertEquals(actions.productsPageObject.getAllProductsIsVisible().isDisplayed(), true);

        actions.scrollDown(600);

        logger.info("Click on 'View Product' button");
        actions.setExplicitWait(actions.productsPageObject.getFirstProductViewProductsBtn());
        actions.productsPageObject.getFirstProductViewProductsBtn().click();

        actions.scrollDown(500);

        logger.info("Verify 'Write Your Review' is visible");
        actions.setExplicitWait(actions.productsPageObject.getWriteYourReviewIsVisible());
        assertEquals(actions.productsPageObject.getWriteYourReviewIsVisible().isDisplayed(), true);

        List<String> reviewInfo = actions.dataHandle.getAllValuesInColumn(2, 1);

        logger.info("Enter name, email and review");
        actions.setExplicitWait(actions.productsPageObject.getNameField());
        actions.productsPageObject.getNameField().sendKeys(reviewInfo.get(0));
        actions.productsPageObject.getEmailField().sendKeys(reviewInfo.get(1));
        actions.productsPageObject.getReviewField().sendKeys(reviewInfo.get(2));

        logger.info("Click 'Submit' button");
        actions.productsPageObject.getSubmitBtn().click();

        logger.info("Verify success message 'Thank you for your review.'");
        actions.setExplicitWait(actions.productsPageObject.getThankYouForYourReviewIsVisible());
        assertEquals(actions.productsPageObject.getThankYouForYourReviewIsVisible().isDisplayed(), true);
    }

    @Then("Test Case Twenty-One: Post-Requirements")
    public void testCase21PostRequirements() {
        logger.info("Test Case Twenty-One: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Twenty-Two: Pre-Requirements")
    public void testCase22PreRequirements() throws IOException {
        logger.info("Test Case Twenty-Two: Pre-Requirements");
    }

    @When("Test Case Twenty-Two: Steps")
    public void testCase22Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Scroll to bottom of page");
        actions.scrollDown(1000);

        logger.info("Verify 'RECOMMENDED ITEMS' are visible");
        actions.setExplicitWait(actions.homePage.getRecommendedItemsIsVisible());
        assertEquals(actions.homePage.getRecommendedItemsIsVisible().isDisplayed(), true);

        logger.info("Click on 'Add To Cart' on Recommended product");
        actions.homePage.getAddToCartRecommendedProductBtn().click();

        logger.info("Click on 'View Cart' button");
        actions.setExplicitWait(actions.homePage.getViewCart());
        actions.homePage.getViewCart().click();

        logger.info("Verify that product is displayed in cart page");
        actions.setExplicitWait(actions.cartPageObject.getStylishDressOnCartIsVisible());
        assertEquals(actions.cartPageObject.getStylishDressOnCartIsVisible().isDisplayed(), true);    }

    @Then("Test Case Twenty-Two: Post-Requirements")
    public void testCase22PostRequirements() {
        logger.info("Test Case Twenty-Two: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Twenty-Three: Pre-Requirements")
    public void testCase23PreRequirements() throws IOException {
        logger.info("Test Case Twenty-Three: Pre-Requirements");
    }

    @When("Test Case Twenty-Three: Steps")
    public void testCase23Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        actions.navigateToLoginSignUpPage();
        List<String> userInfo = actions.dataHandle.getAllValuesInColumn(0, 1);
        actions.registerUser(userInfo);

        actions.orderFirstProduct();

        List<String> checkoutInfo = actions.dataHandle.getAllValuesInColumn(4,1);

        actions.checkoutFillDetails(checkoutInfo);;

        actions.deleteAccount();    }

    @Then("Test Case Twenty-Three: Post-Requirements")
    public void testCase23PostRequirements() {
        logger.info("Test Case Twenty-Three: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Twenty-Four: Pre-Requirements")
    public void testCase24PreRequirements() throws IOException {

    }

    @When("Test Case Twenty-Four: Steps")
    public void testCase24Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        actions.orderFirstProduct();

        logger.info("Click 'Register / Login' button");
        actions.cartPageObject.getRegisterLoginBtnTextLink().click();

        List<String> userInfo = actions.dataHandle.getAllValuesInColumn(0, 1);
        actions.registerUser(userInfo);

        logger.info("Click 'Cart' button");
        actions.homePage.getCartBtnTextLink().click();

        logger.info("Click Proceed To Checkout");
        actions.setExplicitWait(actions.cartPageObject.getProceedToCheckoutBtn());
        actions.cartPageObject.getProceedToCheckoutBtn().click();
        List<String> checkoutInfo = actions.dataHandle.getAllValuesInColumn(4,1);

        actions.checkoutFillDetails(checkoutInfo);;

        logger.info("Click 'Download Invoice' button and verify invoice is downloaded successfully.");
        actions.setExplicitWait(actions.cartPageObject.getDownloadInvoiceBtn());
        actions.cartPageObject.getDownloadInvoiceBtn().click();

        logger.info("Click 'Continue' button");
        actions.cartPageObject.getContinueBtn().click();

        actions.deleteAccount();    }

    @Then("Test Case Twenty-Four: Post-Requirements")
    public void testCase24PostRequirements() {
        logger.info("Test Case Twenty-Four: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Twenty-Five: Pre-Requirements")
    public void testCase25PreRequirements() throws IOException {
        logger.info("Test Case Twenty-Five: Pre-Requirements");
    }

    @When("Test Case Twenty-Five: Steps")
    public void testCase25Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Scroll down page to bottom");
        actions.scrollDown(10000);

        logger.info(". Verify 'SUBSCRIPTION' is visible");
        actions.setExplicitWait(actions.homePage.getSubscriptionIsVisible());
        assertEquals(actions.homePage.getSubscriptionIsVisible().isDisplayed(), true);

        logger.info("Click on arrow at bottom right side to move upward");
        actions.setExplicitWait(actions.homePage.getArrowUpBtn());
        actions.homePage.getArrowUpBtn().click();

        logger.info("Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        actions.setExplicitWait(actions.homePage.getFullFledgedPracticeWebsiteForAutomationEngineersIsVisible());
        assertEquals(actions.homePage.getFullFledgedPracticeWebsiteForAutomationEngineersIsVisible().isDisplayed(), true);    }

    @Then("Test Case Twenty-Five: Post-Requirements")
    public void testCase25PostRequirements() {
        logger.info("Test Case Twenty-Five: Post-Requirements");
        actions.endTest();
    }

    @Given("Test Case Twenty-Six: Pre-Requirements")
    public void testCase26PreRequirements() throws IOException {
        logger.info("Test Case Twenty-Six: Pre-Requirements");
    }

    @When("Test Case Twenty-Six: Steps")
    public void testCase26Steps() throws IOException {

        actions = new TestActions();
        actions.initDependencies();

        actions.initHomePage();

        logger.info("Scroll down page to bottom");
        actions.scrollDown(10000);

        logger.info("Verify 'SUBSCRIPTION' is visible");
        actions.setExplicitWait(actions.homePage.getSubscriptionIsVisible());
        assertEquals(actions.homePage.getSubscriptionIsVisible().isDisplayed(), true);

        logger.info("Scroll up page to top");
        actions.setExplicitWait(actions.homePage.getArrowUpBtn());
        actions.scrollUp(10000);

        logger.info("Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        actions.setExplicitWait(actions.homePage.getFullFledgedPracticeWebsiteForAutomationEngineersIsVisible());
        assertEquals(actions.homePage.getFullFledgedPracticeWebsiteForAutomationEngineersIsVisible().isDisplayed(), true);    }

    @Then("Test Case Twenty-Six: Post-Requirements")
    public void testCase26PostRequirements() {
        logger.info("Test Case Twenty-Six: Post-Requirements");
        actions.endTest();
    }

}
