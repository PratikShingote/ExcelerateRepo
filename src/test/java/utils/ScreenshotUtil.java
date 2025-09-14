package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + testName + "_" + timestamp + ".png";
        try {
            Files.createDirectories(new File("screenshots").toPath());
            Files.copy(srcFile.toPath(), new File(path).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}