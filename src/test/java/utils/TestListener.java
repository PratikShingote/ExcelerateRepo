package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	ScreenshotUtil su=new ScreenshotUtil();
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			su.takeScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			su.takeScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}

	
}