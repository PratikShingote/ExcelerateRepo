package utils;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver drv) {
        driver.set(drv);
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("STARTING TEST: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("PASSED TEST: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("FAILED TEST: " + result.getName());
        if (driver.get() != null) {
            String path = ScreenshotUtil.captureScreenshot(driver.get(), result.getName());
            saveScreenshot(path);
            logger.error("Screenshot captured at: " + path);
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] saveScreenshot(String path) {
        try {
            return java.nio.file.Files.readAllBytes(new java.io.File(path).toPath());
        } catch (Exception e) {
            return new byte[0];
        }
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("STARTING TEST SUITE: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("FINISHED TEST SUITE: " + context.getName());
    }
}