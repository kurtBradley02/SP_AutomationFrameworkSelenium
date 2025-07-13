package com.myprojectnew.cucumber.util;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

    public ExtentReports extent;
    public ExtentTest test;

    public void setUpCucumberExtent(String testName) {
        String reportPath = "C:/Users/turks/OneDrive/Desktop/SP_AutomationFrameworkSelenium/cucumber-extent-reports/"+testName+".html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public void tearDownExtent() {
        extent.flush();
    }

}