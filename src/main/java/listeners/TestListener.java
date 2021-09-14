package listeners;

import base.BaseTest;
import base.WebDriverConfig;
import helpers.ScreenshotHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static base.WebDriverConfig.driverThreadSafe;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("TEST FAILED!");
        ScreenshotHelper.takeScreenshot(driverThreadSafe.get());
    }
}
