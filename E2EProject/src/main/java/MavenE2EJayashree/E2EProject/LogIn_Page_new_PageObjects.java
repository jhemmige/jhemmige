//this has the Page Object for Fogot password link ( that is present on login page)

package MavenE2EJayashree.E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

import resources.Base;

public class LogIn_Page_new_PageObjects  {
	
	WebDriver driver;
	
	public LogIn_Page_new_PageObjects(WebDriver driver) {
		
		this.driver= driver;
		
	}

	
	By forgotPwdLink= 	By.cssSelector("[href*='password/new']");
	
	

	
	
	public forgotPwd_page_PageObjects forgotPwd() {
		
		
	 driver.findElement(forgotPwdLink).click();
	 forgotPwd_page_PageObjects fpo = new forgotPwd_page_PageObjects(driver);
	 return fpo;

	
	
		
		
}
}
