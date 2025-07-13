package com.myprojectnew.cucumber.util;

import com.aventstack.extentreports.Status;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    public static ExtentReportNG reporter;

    @Before
    public void prepareTest(Scenario scenario){
        reporter = new ExtentReportNG();

        String safeScenarioName = scenario.getName()
                .replaceAll("[\\\\/:*?\"<>|]", "_")
                .replaceAll("\\s+", "_");

        reporter.setUpCucumberExtent("report_" + safeScenarioName);

        reporter.test = reporter.extent.createTest(scenario.getName());
        reporter.test.log(Status.INFO, "Starting scenario: " + scenario.getName());
    }

    @After
    public void generateTest(Scenario scenario){
        if (reporter != null && reporter.test != null) {
            if (scenario.isFailed()) {
                reporter.test.fail("Scenario FAILED: " + scenario.getName());
            } else {
                reporter.test.pass("Scenario PASSED: " + scenario.getName());
            }
            reporter.tearDownExtent();
        }
    }
}
