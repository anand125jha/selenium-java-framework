package drivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void initDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		if(Boolean.parseBoolean(ConfigReader.getProperty(("headless")))){
			options.addArguments("--headless=new");
		}
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080");
		driver.set(new ChromeDriver(options));
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicitWait"))));
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
