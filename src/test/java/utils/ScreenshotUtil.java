package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import javax.imageio.ImageIO;

public class ScreenshotUtil {
	WebDriver driver=new ChromeDriver();
	public String getCurrentTimeDate() {
		// Get the current date and time
		LocalDateTime localTImeDate = LocalDateTime.now();
		// Define the format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");// 2025_03_28_11_34_34
		// Format the current date and time
		String formattedNow = localTImeDate.format(formatter);// 2025_03_28_11_34_34
		// Print the formatted date and time
		System.out.println(formattedNow);
		return formattedNow;
	}
    	public void takeScreenshot() throws IOException {
    		
			Screenshot src = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
    		BufferedImage img = src.getImage();
    		ImageIO.write(img, "png", new File("src/ScreenShots/" + getCurrentTimeDate() + "_screenShotUsingAshot.png"));
    	}
}