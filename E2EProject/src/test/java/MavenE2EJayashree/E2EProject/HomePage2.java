package MavenE2EJayashree.E2EProject;
/** In this page, We are going to see how multiple test cases if it belongs to same page  can be combined and can be driven by single object declaration 
 * globally  Section 30: Selenium Framework
Optimization & Interview questions
 * 228. Demonstration on clubbing tests into
classes in framework*/
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;

public class HomePage2 extends Base {

	private static Logger log = LogManager.getLogger(HomePage2.class.getName());
	static WebDriver driver;
	Landing_Page_PageObjects lp;/* this obj exposes the methods present in loginPage class. lp gets a life when a new memory is allocated with
	in the first method */

	@BeforeTest
	public static void initializeDriver() throws IOException {
		

		driver = initializedriver(); /*we are bringing in the method present in baseclass. Where in we are using Chrome browser to open qaclickacademy.com*/

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize(); /*this maximizes the window size we created a new method called basepageNavigation.*/

	}

	@Test

	public void basehomePageNavigation() throws IOException, InterruptedException {
		// we created a new method called basepageNavigation.

		// driver =initializedriver(); // we are bringing in the method present in
		// baseclass. Where in we are using Chrome browser
		// to open qaclickacademy.com

		// driver.get(prop.getProperty("url"));// instead of hardcoding the url for
		// RahulShetty.com, we are passing url here.
		// we have defined the prop variable globally in base.java page so that variable
		// can be accessed by all classes extending
		// the base class.
		// driver.manage().window().maximize(); // this maximizes the window size

		// various obj pertaining to Login.
		lp= new Landing_Page_PageObjects(driver); /*We have declared the lp object globally so its accessible to other methods. But new Landing_Page_PageObjects(driver)
		should be within  the method  else the driver will not get initiated and the script will fail.*/
		
		String fc = lp.getTitle().getText();
		System.out.println(fc);

		Assert.assertEquals("Featured Courses13", fc);// TestNG validation
	}

	@Test
	private void linkDisplay() {

		Boolean boo = lp.getLink().isDisplayed();
		System.out.println(boo);
		log.info("I have getting the featured courses printed");

	}

	@Test
	private void textSwitch() {
		lp.getSwtichOnOff().click();
		// String switchtxt= lp.getSwtichOnOff().getText();
		System.out.println("Ok! I have clicked on switch text");

	}

	// Assert.assertTrue(boo);

	@AfterTest
	public void tearDown() {

		driver.close();
	}

}
