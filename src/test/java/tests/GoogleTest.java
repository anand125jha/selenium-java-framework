package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.GooglePage;
public class GoogleTest extends BaseTest {
	@Test
	public void verifyGoogleSearchBox() throws InterruptedException {
		GooglePage google = new GooglePage();
		google.open();
		Assert.assertEquals(google.getTitle(), "Google");
	}
}
