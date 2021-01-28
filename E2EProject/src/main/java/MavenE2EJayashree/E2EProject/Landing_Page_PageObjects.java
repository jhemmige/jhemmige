/** In this we are creating an object for Login Page
 * First step : 
 * 1. Create a locator obj for LogIn link
 * 
 * 2. Create a method called logInPage and call that locator in step1. Now to call the locator, we need a driver. Hence we 
 * declare a driver globally. WebDriver driver in line 19.
 * 3. this class is called by HomePage . There we pass the driver in the object we create in HomePage.
 * logInPage lp = new logInPage(driver)
 * 4. This will prompt to create a constructor in LogInpage for it.
 *  
 *  */

package MavenE2EJayashree.E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Landing_Page_PageObjects {
	
WebDriver driver;
private By signIn= By.cssSelector("a[href*='sign_in']");
private By title= By.xpath("//h2[contains(text(),'Featured Courses')]");
private By link = By.linkText("Jobs");
private By OnOffSwitch= By.cssSelector("span[class='onoffswitch4-switch']");


//this constructor is created because HomePage has extended Base Class (which has the driver to invoke browser).So, LandingPage has no
//knowledge on driver.
public Landing_Page_PageObjects(WebDriver driver) {
	this.driver =driver;
}



public WebElement signInPage() {
	
return	driver.findElement(signIn);
	
	
}
public WebElement getTitle() {
	
return	driver.findElement(title);
	
	
}

public WebElement getLink() {
	
return	driver.findElement(link);
	
	
}

public WebElement getSwtichOnOff() {
	
return	driver.findElement(OnOffSwitch);
	

}
}
