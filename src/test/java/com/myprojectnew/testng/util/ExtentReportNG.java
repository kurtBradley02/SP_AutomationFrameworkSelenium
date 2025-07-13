package com.myprojectnew.testng.util;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

    public ExtentReports extent;
    public ExtentTest test;

    public void setUpCucumberExtent(String testName) {
        String reportPath = "/Users/kurtjocson/IdeaProjects/MyProjectNew/reports/"+testName+".html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public void setUpExtent(String testName) {
        String reportPath = "/Users/kurtjocson/IdeaProjects/MyProjectNew/reports/"+testName+".html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public void tearDownExtent() {
        extent.flush();
    }

}