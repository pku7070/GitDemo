package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginInPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver; //when u declare any variable as static then if multiple class are accessing that variable then it will not create new object it will share the existing copy only.
	                         //When we are using static then we can not run the test in parallel and it leds to null pointer exception but sequential is possible and it takes less memory on your heap space
	                         // But in our case as we have provided local variable to each class the static is not going to affect our exeution
	public static Logger log =LogManager.getLogger(HomePage.class);
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
	}

	@Test(dataProvider = "getdata")
	public void basepageNavigation(String Username, String Password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
		LandingPage lp = new LandingPage(driver);
		lp.LogIn().click();
		log.info("clicked on login");
		LoginInPage li = new LoginInPage(driver);
		li.UserName().sendKeys(Username);
		log.info("username provided");
		li.Password().sendKeys(Password);
		log.info("password provided");
		log.info(text);
		li.Commit().click();
		log.info("clicked on login");
		
		//new method without creating new object ...calling it from login page
		ForgotPassword fp =li.forgotpassword();
		fp.email().sendKeys("rtyuii");
		fp.sendMeInstruction().click();
	}

	@DataProvider
	public Object[][] getdata() {
		// Row stands for how many different data types test should run
		// Column many values per each test
		// Array size is 2 and 3
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "Pku@qa.com";
		data[0][1] = "1234";
		data[0][2] = "unrestricted user";

		// 1st row
		data[1][0] = "Rshetty@qa.com";
		data[1][1] = "12345";
		data[1][2] = "restricted user";
		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
