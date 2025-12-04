package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.GooglePage;

public class GoogleTest extends BaseTest {
	GooglePage google;

	@BeforeClass
	public void initPage() {
		google = new GooglePage();
	}

	@Test
	public void verifyHomePage() throws InterruptedException {
		google.open();
		Assert.assertEquals(google.getTitle(), "Google");
	}


}
