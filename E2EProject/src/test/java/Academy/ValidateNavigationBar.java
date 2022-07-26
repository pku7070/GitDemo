package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class ValidateNavigationBar extends base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(ValidateNavigationBar.class);
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver has initialized ");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
	}
	@Test
	public void basepageNavigation() throws IOException {

		
		LandingPage lp = new LandingPage(driver);
		// Compare the text inthe browser with the actual text
		Assert.assertTrue(lp.NavigationBar().isDisplayed());
		log.info("Successfully validate the requirements");
		
		

	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
