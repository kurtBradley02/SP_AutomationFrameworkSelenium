package com.myprojectnew.cucumber.util;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/Users/turks/OneDrive/Desktop/SP_AutomationFrameworkSelenium/src/test/java/com/myprojectnew/cucumber/features",
        glue = {"com.myprojectnew.cucumber.stepdefinitions",
                "com.myprojectnew.cucumber.util"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        tags="@This")
public class TestSingleRunner {

}
