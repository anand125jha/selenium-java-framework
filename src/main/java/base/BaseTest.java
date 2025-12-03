package base;

import org.testng.annotations.*;

import drivers.DriverFactory;

public class BaseTest {
	@BeforeMethod
	public void setup() {
		DriverFactory.initDriver();
	}
	
	@AfterMethod 
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
