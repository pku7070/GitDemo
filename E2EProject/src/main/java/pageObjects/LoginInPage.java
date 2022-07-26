package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginInPage {

	public WebDriver driver;

	// public LoginInPage(WebDriver driver) {
	// this.driver = driver;
	// PageFactory.initElements(driver, this);
	// }

	By emailid = By.id("user_email");

	By password = By.id("user_password");

	By submit = By.name("commit");

	By forgotpassword = By.cssSelector("[href*='password/new']");

	public LoginInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement UserName() {
		return driver.findElement(emailid);
	}

	public WebElement Password() {
		return driver.findElement(password);
	}

	public WebElement Commit() {
		return driver.findElement(submit);
	}

	public ForgotPassword forgotpassword() {
		driver.findElement(forgotpassword).click();
		return new ForgotPassword(driver); //----New way--- ******return page object for ForgotPassword class here itself*****
	}
}
