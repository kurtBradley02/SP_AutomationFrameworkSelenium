package com.myprojectnew.cucumber.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestCasePageObject {

    WebDriver driver;

    public TestCasePageObject(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}