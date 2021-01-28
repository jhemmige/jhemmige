

package MavenE2EJayashree.E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage_new_PageObjects {
	
WebDriver driver;
By signIn= By.cssSelector("a[href*='sign_in']");

By OnOffSwitch= By.cssSelector("span[class='onoffswitch4-switch']");





public LandingPage_new_PageObjects(WebDriver driver) {
	this.driver =driver;
}

public WebElement getSwitch() {
	
return driver.findElement( OnOffSwitch);
	
 
}


public LogIn_Page_new_PageObjects signInPage() {
	
	driver.findElement(signIn).click();
	LogIn_Page_new_PageObjects lpnpo = new LogIn_Page_new_PageObjects(driver);
	return lpnpo;
	
	

	
}
	

}

