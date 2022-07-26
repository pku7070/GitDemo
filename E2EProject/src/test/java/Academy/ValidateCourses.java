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

public class ValidateCourses extends base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(ValidateCourses.class);
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver has initialized ");
		driver.get(prop.getProperty("url"));
		log.info("navigated to HomePage");
	}
	@Test
	public void basepageNavigation() throws IOException {

	
		LandingPage lp = new LandingPage(driver);
		// Compare the text inthe browser with the actual text
		Assert.assertEquals(lp.Fcourses().getText(), "FEATURED COURSES123");
		log.info("Successfully validate text message");
		

	}
	@Test
	public void ValidateHeader() throws IOException {

		
		LandingPage lp = new LandingPage(driver);
		// Compare the text inthe browser with the actual text
		Assert.assertEquals(lp.ValidationHeader().getText(), "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("Successfully validate text message");
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
