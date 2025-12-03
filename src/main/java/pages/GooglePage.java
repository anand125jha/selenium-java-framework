package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import drivers.DriverFactory;

public class GooglePage {
	private WebDriver driver;
	private By searchBox = By.cssSelector("input[type='search']");
	
	public GooglePage () {
		this.driver = DriverFactory.getDriver();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void open() {
        driver.get("https://www.google.com");
    }
	
	public void Search(String query) {
		driver.findElement(searchBox).sendKeys(query + Keys.ENTER);
	}
}
