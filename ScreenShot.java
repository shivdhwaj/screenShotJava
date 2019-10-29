import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class ScreenShot {
	
	WebDriver driver;
	
	public static void main(String args[]) throws Exception {
		captureScreen("/home/user/Desktop/test.png");
	}

	public static void captureScreen(String fileName) throws Exception {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(fileName));

	}
	
	/**
	 * This method is used to take <b>Screenshot</b> of the current page.
	 * 
	 * @param driver : WebDriver object
	 */
	public static String takeScreenShot() {

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss");
		String fileName = "ScreenShot_" + datePattern.format(dateTime) + ".jpg";
		TakesScreenshot scr = (TakesScreenshot) driver;
		Path screenshot = Paths.get("Screenshot Path");
		Path source = scr.getScreenshotAs(OutputType.FILE).toPath();
		Path target = Paths.get("Screenshot Path" + fileName);
		try {
			System.out.println("Screen shot at " + "Screenshot Path");
			Reporter.log("Screen shot at " + "Screenshot Path" + "<br>");
			if (Files.notExists(screenshot))
				Files.createDirectory(screenshot);
			Files.copy(source, target);
		} catch (IOException e) {
			System.out.println("Unable to take screen shot");
			Reporter.log("Unable to take screen shot<br>");
			e.printStackTrace();
		}
		return "Screenshot Path" + fileName;

	}

	/**
	 * This method is used to take <b>Screenshot</b> of the current page.
	 * 
	 * @param driver : WebDriver object
	 * @param name : Screenshot file name
	 */
	public static String takeScreenShot(String name) {

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss");
		String fileName = name + "_" + datePattern.format(dateTime) + ".jpg";
		TakesScreenshot scr = (TakesScreenshot) driver;
		Path screenshot = Paths.get("Screenshot Path");
		Path source = scr.getScreenshotAs(OutputType.FILE).toPath();
		Path target = Paths.get("Screenshot Path" + fileName);
		try {
			System.out.println("Screen shot at " + "Screenshot Path");
			Reporter.log("Screen shot at " + "Screenshot Path" + "<br>");
			if (Files.notExists(screenshot))
				Files.createDirectory(screenshot);
			Files.copy(source, target);
		} catch (IOException e) {
			System.out.println("Unable to take screen shot");
			Reporter.log("Unable to take screen shot<br>");
			e.printStackTrace();
		}
		return "Screenshot Path" + fileName;

	}
}
