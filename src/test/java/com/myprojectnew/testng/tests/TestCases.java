package com.myprojectnew.testng.tests;

import com.myprojectnew.testng.util.BaseTest;
import com.myprojectnew.testng.util.Retry;
import org.openqa.selenium.WebElement;

import org.testng.annotations.*;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class TestCases extends BaseTest {

    @Test(priority = 1, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase01(){

        standAloneTests.initHomePage();

        standAloneTests.navigateToLoginSignUpPage();

        List<String> userInfo = dataHandle.getAllValuesInColumn(0, 1);

        standAloneTests.registerUser(userInfo);

        standAloneTests.deleteAccount();

    }

    @Test(priority = 2, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase02(){
        //Pre-req
        standAloneTests.initHomePage();
        standAloneTests.navigateToLoginSignUpPage();
        List<String> userInfo = dataHandle.getAllValuesInColumn(0, 1);
        String[] result = standAloneTests.registerUser(userInfo).split(", ");

        standAloneTests.setExplicitWait(loginSignUpPage.getLogoutBtn());
        loginSignUpPage.getLogoutBtn().click();
        //End of Pre-req

        standAloneTests.initHomePage();

        standAloneTests.navigateToLoginSignUpPage();

        standAloneTests.login(result[1]);

        standAloneTests.deleteAccount();
    }

    @Test(priority = 3, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase03(){

        standAloneTests.initHomePage();

        standAloneTests.navigateToLoginSignUpPage();

        List<String> incorrectInfo = dataHandle.getAllValuesInColumn(3, 1);

        loginSignUpPage.getLoginEmailAddressField().sendKeys(incorrectInfo.get(0));
        loginSignUpPage.getPasswordField().sendKeys(incorrectInfo.get(1));
        loginSignUpPage.getLoginBtn().click();

        standAloneTests.setExplicitWait("//*[@id=\"form\"]/div/div/div[1]/div/form/p");
        assertEquals(loginSignUpPage.getYourEmailAndPasswordIsIncorrectIsVisible().isDisplayed(), true);

    }

    @Test(priority = 4, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase04() throws InterruptedException{

        //Pre-req
        standAloneTests.initHomePage();
        standAloneTests.navigateToLoginSignUpPage();
        List<String> userInfo = dataHandle.getAllValuesInColumn(0, 1);
        String[] result = standAloneTests.registerUser(userInfo).split(", ");
        standAloneTests.setExplicitWait("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
        loginSignUpPage.getLogoutBtn().click();
        //End of Pre-req

        standAloneTests.initHomePage();

        standAloneTests.navigateToLoginSignUpPage();

        standAloneTests.login(result[1]);

        standAloneTests.setExplicitWait("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
        loginSignUpPage.getLogoutBtn().click();

        boolean testUrl = driver.getCurrentUrl().equals("https://automationexercise.com/login") || driver.getCurrentUrl().equals("https://www.automationexercise.com/login") ? true : false;

        assertEquals(testUrl, true);

        //Post-req
        standAloneTests.initHomePage();

        standAloneTests.navigateToLoginSignUpPage();

        standAloneTests.login(result[1]);
        standAloneTests.deleteAccount();
        //End of Post-req

    }

    @Test(priority = 5, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase05() throws InterruptedException{

        //Pre-req
        standAloneTests.initHomePage();
        standAloneTests.navigateToLoginSignUpPage();
        List<String> userInfo = dataHandle.getAllValuesInColumn(0, 1);
        String[] result = standAloneTests.registerUser(userInfo).split(", ");
        loginSignUpPage.getLogoutBtn().click();
        //End of Pre-req

        standAloneTests.initHomePage();

        standAloneTests.navigateToLoginSignUpPage();

        loginSignUpPage.getNameField().sendKeys(result[0]);
        loginSignUpPage.getEmailAddressField().sendKeys(result[1]);
        loginSignUpPage.getSignUpBtn().click();

        standAloneTests.setExplicitWait("//*[@id=\"form\"]/div/div/div[3]/div/form/p");
        assertEquals(loginSignUpPage.getEmailAddressAlreadyExistIsVisible().isDisplayed(), true);

        //Post-req
        standAloneTests.initHomePage();

        standAloneTests.navigateToLoginSignUpPage();

        standAloneTests.login(result[1]);
        standAloneTests.deleteAccount();
        //End of Post-req

    }

    @Test(priority = 6, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase06() throws InterruptedException{
        standAloneTests.initHomePage();

        homePage.getContactUsBtnTextLink().click();

        standAloneTests.setExplicitWait("//*[@id=\"contact-us-form\"]/div[5]/input");
        assertEquals(contactPageObject.getGetInTouchIsVisible().isDisplayed(), true);

        List<String> contactInfo = dataHandle.getAllValuesInColumn(1, 1);

        contactPageObject.getNameField().sendKeys(contactInfo.get(0));
        contactPageObject.getEmailField().sendKeys(contactInfo.get(1));
        contactPageObject.getSubjectField().sendKeys(contactInfo.get(2));
        contactPageObject.getMessageField().sendKeys(contactInfo.get(3));
        contactPageObject.getUploadFileBtn().sendKeys(System.getProperty("user.dir")+contactInfo.get(4));

        scrollDown(500);

        contactPageObject.getSubmitBtn().click();

        standAloneTests.alertWait();
        alertOkAccept();

        standAloneTests.setExplicitWait("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]");
        assertEquals(contactPageObject.getSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible().isDisplayed(), true);

        contactPageObject.getHomeBtn().click();

        boolean testUrl = driver.getCurrentUrl().equals("https://automationexercise.com/") || driver.getCurrentUrl().equals("https://www.automationexercise.com/") ? true : false;

        assertEquals(testUrl, true);
    }

    @Test(priority = 7, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase07() throws InterruptedException{

        standAloneTests.initHomePage();

        homePage.getTestCaseBtnTextLink().click();

        assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/test_cases");
    }

    @Test(priority = 8, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase08() throws InterruptedException{

        standAloneTests.initHomePage();

        homePage.getProductsBtnTextLink().click();
        assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/products");

        standAloneTests.setExplicitWait("/html/body/section[2]/div/div/div[2]/div/h2");
        assertEquals(productsPageObject.getAllProductsIsVisible().isDisplayed(), true);

        scrollDown(500);

        standAloneTests.setExplicitWait("/html/body/section[2]/div/div/div[1]");
        assertEquals(productsPageObject.getProductsListIsVisible().isDisplayed(), true);

        scrollDown(500);

        productsPageObject.getFirstProductViewProductsBtn().click();

        assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/product_details/1");
        
        standAloneTests.setExplicitWait("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b");
        assertEquals(productDetailsPageObject.getProductNameIsVisible().isDisplayed(), true);
        assertEquals(productDetailsPageObject.getCategoryIsVisible().isDisplayed(), true);
        assertEquals(productDetailsPageObject.getPriceIsVisible().isDisplayed(), true);
        assertEquals(productDetailsPageObject.getAvailabilityIsVisible().isDisplayed(), true);
        assertEquals(productDetailsPageObject.getConditionIsVisible().isDisplayed(), true);
        assertEquals(productDetailsPageObject.getBrandIsVisible().isDisplayed(), true);
    }

    @Test(priority = 9, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase09() throws InterruptedException{

        standAloneTests.initHomePage();

        homePage.getProductsBtnTextLink().click();

        assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/products");

        standAloneTests.setExplicitWait("/html/body/section[2]/div/div/div[2]/div/h2");
        assertEquals(productsPageObject.getAllProductsIsVisible().isDisplayed(), true);

        productsPageObject.getSearchField().sendKeys("Sleeveless");
        productsPageObject.getSearchBtn().click();

        scrollDown(500);

        standAloneTests.setExplicitWait("//*[contains(text(),'Searched Products')]");
        assertEquals(productsPageObject.getSearchedProductTitleIsVisible().isDisplayed(), true);

        standAloneTests.setExplicitWait(productsPageObject.getAllProductsRelatedToSearchIsVisible());
        assertEquals(productsPageObject.getAllProductsRelatedToSearchIsVisible().isDisplayed(), true);

    }

    @Test(priority = 10, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase10() throws InterruptedException{

        standAloneTests.initHomePage();

        scrollDown(10000);

        assertEquals(homePage.getSubscriptionIsVisible().isDisplayed(), true);

        homePage.getEmailAddressField().sendKeys("randomtest@mail.com");
        homePage.getArrowBtn().click();

        standAloneTests.setExplicitWait("//*[@id=\"success-subscribe\"]/div");
        assertEquals(homePage.getYouHaveBeenSuccessfullySubscribedIsVisible().isDisplayed(), true);
    }

    @Test(priority = 11, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase11() throws InterruptedException{

        standAloneTests.initHomePage();

        homePage.getCartBtnTextLink().click();

        scrollDown(1000);

        standAloneTests.setExplicitWait("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
        assertEquals(homePage.getSubscriptionIsVisible().isDisplayed(), true);

        homePage.getEmailAddressField().sendKeys("randomtest@mail.com");
        homePage.getArrowBtn().click();

        standAloneTests.setExplicitWait("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
        assertEquals(homePage.getYouHaveBeenSuccessfullySubscribedIsVisible().isDisplayed(), true);
    }

    @Test(priority = 12, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase12() throws InterruptedException{

        standAloneTests.initHomePage();

        scrollDown(500);

        hover(homePage.getFirstProduct());

        standAloneTests.setExplicitWait("//p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]");
        homePage.getAddToCart().click();

        standAloneTests.setExplicitWait(homePage.getContinueShopping(),5);
        homePage.getContinueShopping().click();

        standAloneTests.setExplicitWait(homePage.getSecondProduct());
        hover(homePage.getSecondProduct());

        homePage.getAddToCart2().click();

        standAloneTests.setExplicitWait(homePage.getViewCart());
        homePage.getViewCart().click();

        standAloneTests.setExplicitWait("//*[@id=\"product-1\"]/td[2]/h4/a");
        assertEquals(cartPageObject.getFirstProductIsVisible().isDisplayed(), true);
        assertEquals(cartPageObject.getSecondProductIsVisible().isDisplayed(), true);

        assertEquals(cartPageObject.getPrice1IsVisible().getText(), "Rs. 500");
        assertEquals(cartPageObject.getPrice2IsVisible().getText(), "Rs. 400");

        assertEquals(cartPageObject.getQuantity1IsVisible().getText(), "1");
        assertEquals(cartPageObject.getQuantity2IsVisible().getText(), "1");

        assertEquals(cartPageObject.getTotal1IsVisible().getText(), "Rs. 500");
        assertEquals(cartPageObject.getTotal2IsVisible().getText(), "Rs. 400");

    }

    @Test(priority = 13, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase13() throws InterruptedException{

        standAloneTests.initHomePage();

        scrollDown(500);

        homePage.getViewProduct().click();
        
        assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/product_details/1");

        scrollDown(500);

        productDetailsPageObject.getQuantityField().clear();
        productDetailsPageObject.getQuantityField().sendKeys("4");

        productDetailsPageObject.getAddToCart().click();

        standAloneTests.setExplicitWait(homePage.getViewCart());
        homePage.getViewCart().click();
        
        standAloneTests.setExplicitWait(cartPageObject.getQuantity1IsVisible());
        assertEquals(cartPageObject.getQuantity1IsVisible().getText(), "4");

    }

    @Test(priority = 14, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase14() throws InterruptedException{

        standAloneTests.initHomePage();

        standAloneTests.orderFirstProduct();

        cartPageObject.getRegisterLoginBtnTextLink().click();
        
        List<String> userInfo = dataHandle.getAllValuesInColumn(0, 1);
        standAloneTests.registerUser(userInfo);

        homePage.getCartBtnTextLink().click();

        boolean testUrl = driver.getCurrentUrl().equals("https://www.automationexercise.com/view_cart") || driver.getCurrentUrl().equals("https://automationexercise.com/view_cart") ? true : false;

        assertEquals(testUrl, true);

        standAloneTests.setExplicitWait(cartPageObject.getProceedToCheckoutBtn());
        cartPageObject.getProceedToCheckoutBtn().click();
        
        List<String> checkoutInfo = dataHandle.getAllValuesInColumn(4,1);
        
        standAloneTests.checkoutFillDetails(checkoutInfo);

        standAloneTests.deleteAccount();

    }

    @Test(priority = 15, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase15() throws InterruptedException{

        standAloneTests.initHomePage();

        standAloneTests.navigateToLoginSignUpPage();
        List<String> userInfo = dataHandle.getAllValuesInColumn(0, 1);
        standAloneTests.registerUser(userInfo);

        homePage.getHomeBtnTextLink().click();

        standAloneTests.orderFirstProduct();

        List<String> checkoutInfo = dataHandle.getAllValuesInColumn(4,1);
        
        standAloneTests.checkoutFillDetails(checkoutInfo);

        standAloneTests.deleteAccount();

    }

    @Test(priority = 16, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase16() throws InterruptedException{

        //Pre-req
        standAloneTests.initHomePage();
        standAloneTests.navigateToLoginSignUpPage();
        List<String> userInfo = dataHandle.getAllValuesInColumn(0, 1);
        String[] result = standAloneTests.registerUser(userInfo).split(", ");

        standAloneTests.setExplicitWait("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
        loginSignUpPage.getLogoutBtn().click();
        //End of Pre-req

        standAloneTests.initHomePage();

        standAloneTests.navigateToLoginSignUpPage();

        standAloneTests.login(result[1]);

        standAloneTests.orderFirstProduct();

        List<String> checkoutInfo = dataHandle.getAllValuesInColumn(4,1);
        
        standAloneTests.checkoutFillDetails(checkoutInfo);;

        standAloneTests.deleteAccount();
    }

    @Test(priority = 17, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase17() throws InterruptedException{

        standAloneTests.initHomePage();

        scrollDown(500);

        hover(homePage.getFirstProduct());

        standAloneTests.setExplicitWait("//p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]");
        homePage.getAddToCart().click();

        standAloneTests.setExplicitWait(homePage.getViewCart());
        homePage.getViewCart().click();

        boolean testUrl = driver.getCurrentUrl().equals("https://www.automationexercise.com/view_cart") || driver.getCurrentUrl().equals("https://automationexercise.com/view_cart") ? true : false;

        assertEquals(testUrl, true);

        standAloneTests.setExplicitWait(cartPageObject.getRemoveItem());
        cartPageObject.getRemoveItem().click();

        standAloneTests.setExplicitWait(cartPageObject.getCartIsEmptyIsVisible());
        assertEquals(cartPageObject.getCartIsEmptyIsVisible().isDisplayed(), true);

    }

    @Test(priority = 18, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase18() throws InterruptedException{

        standAloneTests.initHomePage();

        scrollDown(500);

        standAloneTests.setExplicitWait(homePage.getCategoryIsVisible());
        assertEquals(homePage.getCategoryIsVisible().isDisplayed(), true);

        homePage.getWomenCategoryBtn().click();

        standAloneTests.setExplicitWait(homePage.getWomenTopsCategoryBtn());
        homePage.getWomenTopsCategoryBtn().click();

        standAloneTests.setExplicitWait(productsPageObject.getWomenTopsProductIsVisible());

        boolean testUrl = driver.getCurrentUrl().equals("https://www.automationexercise.com/category_products/2") || driver.getCurrentUrl().equals("https://automationexercise.com/category_products/2") ? true : false;

        assertEquals(testUrl, true);

        assertEquals(productsPageObject.getWomenTopsProductIsVisible().isDisplayed(), true);

        productsPageObject.getMenCategoryBtn().click();

        standAloneTests.setExplicitWait(productsPageObject.getTshirtCategoryBtn());
        productsPageObject.getTshirtCategoryBtn().click();

        standAloneTests.setExplicitWait(productsPageObject.getTshirtCategoryIsVisible());
        assertEquals(productsPageObject.getTshirtCategoryIsVisible().isDisplayed(), true);

    }

    @Test(priority = 19, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase19() throws InterruptedException{

        standAloneTests.initHomePage();

        homePage.getProductsBtnTextLink().click();

        scrollDown(500);

        standAloneTests.setExplicitWait(productsPageObject.getBrandIsVisible());
        assertEquals(productsPageObject.getBrandIsVisible().isDisplayed(), true);

        productsPageObject.getPoloBtnTextLink().click();

        assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/brand_products/Polo");

        standAloneTests.setExplicitWait(productsPageObject.getBrandIsVisible());
        assertEquals(productsPageObject.getBrandIsVisible().isDisplayed(), true);

        productsPageObject.getPoloBtnTextLink().click();

        assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/brand_products/Polo");

    }

    @Test(priority = 20, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase20() throws InterruptedException{

        //Pre-req
        standAloneTests.initHomePage();
        standAloneTests.navigateToLoginSignUpPage();
        List<String> userInfo = dataHandle.getAllValuesInColumn(0, 1);
        String[] result = standAloneTests.registerUser(userInfo).split(", ");

        standAloneTests.setExplicitWait("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
        loginSignUpPage.getLogoutBtn().click();
        //End of Pre-req

        standAloneTests.initHomePage();

        homePage.getProductsBtnTextLink().click();

        scrollDown(200);

        standAloneTests.setExplicitWait(productsPageObject.getAllProductsIsVisible());
        assertEquals(productsPageObject.getAllProductsIsVisible().isDisplayed(), true);

        productsPageObject.getSearchField().sendKeys("Sleeveless");

        productsPageObject.getSearchBtn().click();

        standAloneTests.setExplicitWait(productsPageObject.getSearchedProductIsVisible());
        assertEquals(productsPageObject.getSearchedProductIsVisible().isDisplayed(), true);

        scrollDown(500);

        List<WebElement> elems = productsPageObject.getAllProductsRelatedIsVisible();

        assertEquals(elems.size() > 0, true);

        hover(homePage.getFirstProduct());

        standAloneTests.setExplicitWait("//p[text()='Sleeveless Dress']/following-sibling::a[contains(@class, 'add-to-cart')]");
        homePage.getSleevelessAddToCart().click();

        homePage.getContinueShopping().click();

        scrollDown(200);

        hover(homePage.getSecondProduct());

        standAloneTests.setExplicitWait(homePage.getSecondAddToCart());
        homePage.getSecondAddToCart().click();

        homePage.getContinueShopping().click();

        hover(homePage.getThirdProduct());

        standAloneTests.setExplicitWait(homePage.getThirdAddToCart());
        homePage.getThirdAddToCart().click();

        standAloneTests.setExplicitWait(homePage.getViewCart());
        homePage.getViewCart().click();

        assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/view_cart");

        standAloneTests.navigateToLoginSignUpPage();

        standAloneTests.login(result[1]);

        homePage.getCartBtnTextLink().click();

        scrollDown(500);

        elems = productsPageObject.getRelatedProductsIsVisible();

        assertEquals(elems.size() > 0, true);

        scrollUp(500);

        loginSignUpPage.getLogoutBtn().click();

        //Post-req
        standAloneTests.initHomePage();

        standAloneTests.navigateToLoginSignUpPage();

        standAloneTests.login(result[1]);
        standAloneTests.deleteAccount();
        //End of Post-req

    }

    @Test(priority = 21, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase21() throws InterruptedException{

        standAloneTests.initHomePage();

        homePage.getProductsBtnTextLink().click();

        standAloneTests.setExplicitWait(productsPageObject.getAllProductsIsVisible());
        assertEquals(productsPageObject.getAllProductsIsVisible().isDisplayed(), true);

        scrollDown(600);

        standAloneTests.setExplicitWait(productsPageObject.getFirstProductViewProductsBtn());
        productsPageObject.getFirstProductViewProductsBtn().click();

        scrollDown(500);

        standAloneTests.setExplicitWait(productsPageObject.getWriteYourReviewIsVisible());
        assertEquals(productsPageObject.getWriteYourReviewIsVisible().isDisplayed(), true);

        List<String> reviewInfo = dataHandle.getAllValuesInColumn(2, 1);

        standAloneTests.setExplicitWait(productsPageObject.getNameField());
        productsPageObject.getNameField().sendKeys(reviewInfo.get(0));
        productsPageObject.getEmailField().sendKeys(reviewInfo.get(1));
        productsPageObject.getReviewField().sendKeys(reviewInfo.get(2));

        productsPageObject.getSubmitBtn().click();

        standAloneTests.setExplicitWait(productsPageObject.getThankYouForYourReviewIsVisible());
        assertEquals(productsPageObject.getThankYouForYourReviewIsVisible().isDisplayed(), true);

    }

    @Test(priority = 22, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase22() throws InterruptedException{

        standAloneTests.initHomePage();

        scrollDown(1000);

        standAloneTests.setExplicitWait(homePage.getRecommendedItemsIsVisible());
        assertEquals(homePage.getRecommendedItemsIsVisible().isDisplayed(), true);

        homePage.getAddToCartRecommendedProductBtn().click();

        standAloneTests.setExplicitWait(homePage.getViewCart());
        homePage.getViewCart().click();

        standAloneTests.setExplicitWait(cartPageObject.getStylishDressOnCartIsVisible());
        assertEquals(cartPageObject.getStylishDressOnCartIsVisible().isDisplayed(), true);


    }


    @Test(priority = 23, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase23() throws InterruptedException{

        standAloneTests.initHomePage();

        standAloneTests.navigateToLoginSignUpPage();
        List<String> userInfo = dataHandle.getAllValuesInColumn(0, 1);
        standAloneTests.registerUser(userInfo);

        standAloneTests.orderFirstProduct();

        List<String> checkoutInfo = dataHandle.getAllValuesInColumn(4,1);
        
        standAloneTests.checkoutFillDetails(checkoutInfo);;

        standAloneTests.deleteAccount();

    }

    @Test(priority = 24, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase24() throws InterruptedException{

        standAloneTests.initHomePage();

        standAloneTests.orderFirstProduct();

        cartPageObject.getRegisterLoginBtnTextLink().click();
        
        List<String> userInfo = dataHandle.getAllValuesInColumn(0, 1);
        standAloneTests.registerUser(userInfo);

        homePage.getCartBtnTextLink().click();

        standAloneTests.setExplicitWait(cartPageObject.getProceedToCheckoutBtn());
        cartPageObject.getProceedToCheckoutBtn().click();

        List<String> checkoutInfo = dataHandle.getAllValuesInColumn(4,1);
        
        standAloneTests.checkoutFillDetails(checkoutInfo);;

        standAloneTests.setExplicitWait(cartPageObject.getDownloadInvoiceBtn());
        cartPageObject.getDownloadInvoiceBtn().click();

        cartPageObject.getContinueBtn().click();

        standAloneTests.deleteAccount();

    }

    @Test(priority = 25, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase25() throws InterruptedException{
        standAloneTests.initHomePage();

        scrollDown(10000);

        standAloneTests.setExplicitWait(homePage.getSubscriptionIsVisible());
        assertEquals(homePage.getSubscriptionIsVisible().isDisplayed(), true);

        standAloneTests.setExplicitWait(homePage.getArrowUpBtn());
        homePage.getArrowUpBtn().click();

        standAloneTests.setExplicitWait(homePage.getFullFledgedPracticeWebsiteForAutomationEngineersIsVisible());
        assertEquals(homePage.getFullFledgedPracticeWebsiteForAutomationEngineersIsVisible().isDisplayed(), true);
    }

    @Test(priority = 26, timeOut = 30000, retryAnalyzer =  Retry.class)
    public void testCase26() throws InterruptedException{
        standAloneTests.initHomePage();

        scrollDown(10000);

        standAloneTests.setExplicitWait(homePage.getSubscriptionIsVisible());
        assertEquals(homePage.getSubscriptionIsVisible().isDisplayed(), true);

        standAloneTests.setExplicitWait(homePage.getArrowUpBtn());
        scrollUp(10000);

        standAloneTests.setExplicitWait(homePage.getFullFledgedPracticeWebsiteForAutomationEngineersIsVisible());
        assertEquals(homePage.getFullFledgedPracticeWebsiteForAutomationEngineersIsVisible().isDisplayed(), true);
    }

}
