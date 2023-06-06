package utils.listeners;

import base.BaseClass;
import helpers.ScreenShortHelpers;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener implements ITestListener {
    @Override
    public void onFinish(ITestContext result) {
        System.out.println("Đây là test case Finish : " + result.getName());

    }

    @Override
    public void onStart(ITestContext result) {
        System.out.println("Đây là test case Start : " + result.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Đây là test case Fail nhưng có case trước đó success : " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Đây là test case Fail : " + result.getName());
        try {
            ScreenShortHelpers.captureScreenshotFail(new BaseClass().getDriver(), result.getName());
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Đây là test case Skip : " + result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Đây là test case Start : " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Đây là test case Success : " + result.getName());
        try {
            ScreenShortHelpers.captureScreenshot(new BaseClass().getDriver(), result.getName());
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }

    }
}