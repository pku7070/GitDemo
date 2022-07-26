package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
public WebDriver driver;
// This is called Encapsulation object Oriented Principals in our framework
//  ****Variables should always be private so that no one can access it out of the class ****
By SignIn = By.cssSelector("a[href*='sign_in'] ");
By Course = By.cssSelector(" div[class='text-center'] h2");
By NavBar = By.cssSelector("div[role='navigation']");
By Header = By.cssSelector("div[class*='video-banner'] p");

public LandingPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver= driver;
}
// **** Accessible Method should always be public so that it can be easily accessed by other class so that it can execute the variable standards****
public WebElement LogIn() {
	return driver.findElement(SignIn);
}
public WebElement Fcourses() {
	return driver.findElement(Course);
}
public WebElement NavigationBar() {
	return driver.findElement(NavBar);

}
public WebElement ValidationHeader() {
	return driver.findElement(Header);
}
}
