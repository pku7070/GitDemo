package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();

		// Never make the path Hard Coded
		// *** We can give System.getProperty("user.dir")
		// ----FileInputStream is a Data Driven testing part
		// FileInputStream fis = new
		// FileInputStream("C:\\Users\\ASUS\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		// ****mvn test -Dbrowser=chrome**** ---controlling the browser from the commands not from the codes
		// If business people want to run this in firefox then simply tell them to change Dbrowser as Firefox
		// One step we need to twik if u want to send your parameter through your maven command instead of wrirting in the test

		String browsername = System.getProperty("browser");
		// String browsername=prop.getProperty("browser");// ** for normal execution**

		System.out.println(browsername);
		/*if (browsername.contains("chrome")) {
			// execute in chrome
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(); */
		
		//Execute only in headless 
	/*	if(browsername.equals("chromeheadless")){
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		} */
	
		//  **** For both chrome and headless ****
		if (browsername.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			//Executing chrome in Headless mode
			if(browsername.contains("headless")) {
			
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options); 
			
		} else if (browsername.equals("firefox")) {
			// execute in firefox
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browsername.equals("edge")) {
			// exeute in edge
			System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	public String getscreenshotpath(String TestcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + TestcaseName + ".png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
	}

}
