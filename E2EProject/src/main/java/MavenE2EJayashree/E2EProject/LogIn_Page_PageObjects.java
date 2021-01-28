//this has the pageobjects for login page - username/pwd details/submit button
package MavenE2EJayashree.E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_Page_PageObjects {
	
	WebDriver driver;
	
By emailID=	By.id("user_email");
//By.xpath("//*[text()='Login']");

By pwd = By.id("user_password");


By loginBtn= By.xpath("//input[@value='Log In']");





public LogIn_Page_PageObjects(WebDriver driver) {
	this.driver = driver;
}

public WebElement getEmail() {
	
	return driver.findElement(emailID);
	
}

public WebElement getPwd() {
	
	return driver.findElement(pwd);
	
}
public WebElement getLogInBtn() {
	
	return driver.findElement(loginBtn);
	
}



}
