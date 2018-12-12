package framework.webdriver.reports;

import framework.utils.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class GenerateReport implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Logger.log(" Starting test: " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Logger.log(" Test passed: " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Logger.log(" Test failed: " + iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Logger.log(" Test ignored: " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Logger.log("+Begin test: " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Logger.log("-End test: " + iTestContext.getName());
    }
}
