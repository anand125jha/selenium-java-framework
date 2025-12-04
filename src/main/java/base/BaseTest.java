package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import drivers.DriverFactory;

public class BaseTest {
	@BeforeClass
	public void setup() {
		DriverFactory.initDriver();
	}
	
	@AfterClass
	public void tearDown() {
		DriverFactory.quitDriver();
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);	
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotsDir = System.getProperty("user.dir") + "/reports/screenshots/";
		File dir = new File(screenshotsDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String destinationFile = screenshotsDir + testCaseName + "_" + timeStamp + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
