package utils;

import org.openqa.selenium.WebDriver;
import drivers.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;

public class TestListener extends BaseTest implements ITestListener{
    ExtentReports extent = ExtentReporterManager.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       extentTest.get().log(Status.PASS, "Test Passed"); 
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        String testCaseName = result.getMethod().getMethodName();
        try {
            // Get driver from DriverFactory (safer than reflective access to test class fields)
            WebDriver driver = DriverFactory.getDriver();
            if (driver != null) {
                String filePath = getScreenshot(testCaseName, driver);
                extentTest.get().addScreenCaptureFromPath(filePath, testCaseName);
            } else {
                System.out.println("TestListener: WebDriver is null - cannot capture screenshot for " + testCaseName);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
