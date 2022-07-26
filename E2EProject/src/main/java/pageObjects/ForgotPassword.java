package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword{
	
public	 WebDriver driver;
	 
	// public LoginInPage(WebDriver driver) {
		// this.driver = driver;
		// PageFactory.initElements(driver, this);
	 //}
	
By emailid =By.id("user_email");
By sendMeInstruction = By.cssSelector("[type='submit']");




public ForgotPassword(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver = driver;
}

public WebElement email() {
	return driver.findElement(emailid);
}

public WebElement sendMeInstruction() {
	return driver.findElement(sendMeInstruction);
}
}
