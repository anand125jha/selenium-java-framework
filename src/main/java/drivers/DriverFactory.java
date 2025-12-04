package drivers;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void initDriver() {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void quitDriver() {
		if(driver.get()!=null) {
			driver.get().quit();
			driver.remove();
		}
	}
}
