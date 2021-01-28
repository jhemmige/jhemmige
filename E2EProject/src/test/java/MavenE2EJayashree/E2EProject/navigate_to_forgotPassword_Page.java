package MavenE2EJayashree.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class navigate_to_forgotPassword_Page extends Base {
	
	private static Logger log = LogManager.getLogger(HomePage.class.getName());

	WebDriver driver;
	

	@BeforeTest

	public void intializenewdriver() throws IOException {

		driver = initializedriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void access_Fgtpwd_link() {
		
		/** commented code  below is replaced by new code in this page based on code optimization session 
		 * ref : 218. Optimizing Page objects feature with
smart way of objects creation Section 29: Framework building from
scratch- Real time Project

So, what's happening is - when a page leads to a new page, we are creating object of the new page in the same method and  returning the objects of the new page so
the various methods of that page can be accessed.
		 *  */
		 /* LandingPage_new_PageObjects lpnp = new LandingPage_new_PageObjects (driver);
		 * lpnp.signInPage().click();
		 * 
		 * LogIn_Page_new_PageObjects lpnpo  = new LogIn_Page_new_PageObjects lpnpo();
		 *lpnpo.forgotPwd().click();
		 *  
		 *  */
		

		LandingPage_new_PageObjects lpnp = new LandingPage_new_PageObjects (driver);
		lpnp.getSwitch().click();
		LogIn_Page_new_PageObjects lpnpo=	lpnp.signInPage();
		
		forgotPwd_page_PageObjects fpo= lpnpo.forgotPwd();
		fpo.getEmailInput().sendKeys("asdf@gmail.com");
		fpo.getclickSubmitBtn().click();
		
		log.info("Super! This is from navigate to forgot password page!");
		

	}
	



	@AfterTest
	
	public void tearDown() {
		
		
		driver.close();
	}

}
