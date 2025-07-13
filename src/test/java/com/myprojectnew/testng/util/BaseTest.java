package com.myprojectnew.testng.util;


import com.myprojectnew.testng.objects.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class BaseTest {

    public WebDriver driver;

    public JavascriptExecutor js;

    public ExtentReportNG reporter;
    public ITestResult result;

    public DataHandle dataHandle;

    public CartPageObject cartPageObject;
    public ContactPageObject contactPageObject;
    public HomePageObjects homePage;
    public LoginSignUpPageObject loginSignUpPage;
    public ProductDetailsPageObject productDetailsPageObject;
    public ProductsPageObject productsPageObject;
    public TestCasePageObject testCasePageObject;

    public StandAloneTests standAloneTests;

    @BeforeTest
    public void init() throws IOException {

        dataHandle = new DataHandle(System.getProperty("user.dir")+"/src/test/java/resources/TestData.xlsx");

        List<String> config = dataHandle.getAllValuesInColumn(5,1);

        String browserType = config.getFirst();

        switch (browserType){
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", Map.of("autofill.profile_enabled", false));
                driver = new ChromeDriver(options);
            break;
            case "Safari":
                driver = new SafariDriver();
            break;
        }

        driver.manage().window().maximize();

        js = (JavascriptExecutor) driver;

        cartPageObject = new CartPageObject(driver);
        contactPageObject = new ContactPageObject(driver);
        homePage = new HomePageObjects(driver);
        loginSignUpPage = new LoginSignUpPageObject(driver);
        productDetailsPageObject = new ProductDetailsPageObject(driver);
        productsPageObject = new ProductsPageObject(driver);
        testCasePageObject = new TestCasePageObject(driver);

        standAloneTests = new StandAloneTests(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void endTest(ITestContext context) {
        driver.close();
        driver.quit();
    }

    @BeforeMethod(timeOut = 5000)
    public void initBrowserSession(ITestResult result){
        reporter = new ExtentReportNG();
        reporter.setUpExtent(result.getMethod().getMethodName());
        driver.manage().deleteAllCookies();
    }

    @AfterMethod(timeOut = 5000)
    public void endBrowserSession(ITestResult result){
        driver.manage().deleteAllCookies();
        reporter.test = reporter.extent.createTest(result.getMethod().getMethodName());

        if(result.getStatus() == ITestResult.SUCCESS){
            reporter.test.pass("Test Passed");
        }else if(result.getStatus() == ITestResult.FAILURE){
            reporter.test.fail("Test Failed: "+result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
            reporter.test.skip("Test Skipped"+result.getThrowable());
        }
        reporter.tearDownExtent();
    }

    //Reusable actions
    public void scrollDown(Integer distance) throws InterruptedException {
        Thread.sleep(500);
        js.executeScript("window.scrollBy(0,"+distance.toString()+")");
    }

    public void scrollUp(Integer distance){
        distance = distance * -1;
        js.executeScript("window.scrollBy(0,"+distance.toString()+")");
    }

    Select sel;
    public Select dropdown(WebElement elem){
        sel = new Select(elem);
        return sel;
    }

    Alert alert;
    public void alertOkAccept(){
        alert = driver.switchTo().alert();
        alert.accept();
    }

    Actions action;
    public void hover(WebElement elem){
        action = new Actions(driver);
        action.moveToElement(elem).perform();
    }

}
