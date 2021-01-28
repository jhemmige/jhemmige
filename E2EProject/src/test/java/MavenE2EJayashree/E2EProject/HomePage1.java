/** this is another way to invoke Base.java */

package MavenE2EJayashree.E2EProject;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import resources.Base;

public class HomePage1 {
	
	// Created an object for baseclass
	private static Logger log=	LogManager.getLogger(Base.class.getName());
	Base b = new Base();
	//WebDriver driver = b.driver;
	@BeforeTest

	public void  BrowserSetUp() throws IOException

	{

	// initialize the driver and hit the url "https://rahulshettyacademy.com/"

	b.initializedriver();

	b.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "getData")

	public void bpNavigation(String emailID, String Password, String text) throws IOException, InterruptedException

	{
		// initialize the driver and hit the url "https://rahulshettyacademy.com/"
		
		b.driver.get(b.prop.getProperty("url"));
		b.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// instead of hardcoding to get Rahushetty.com url directly, we are using the
		// data.properties file to get url.

		// calling the class landing page to click on SignIn
		Landing_Page_PageObjects lp = new Landing_Page_PageObjects(b.driver); // here we are passing the driver obj into the obj created.
		lp.signInPage().click();

		// calling the class login page to enter email ID/pwd details
		LogIn_Page_PageObjects lop = new LogIn_Page_PageObjects(b.driver);
		lop.getEmail().sendKeys(emailID);
		lop.getPwd().sendKeys(Password);
		lop.getLogInBtn().click();

		log.info("this message is from homePage1 that I created ..yaya!");

		//b.driver.close();

	}

	@DataProvider

	public Object[][] getData() {

		Object data[][] = new Object[4][3];

		data[0][0] = "j@gmail.com";

		data[0][1] = "j123";

		data[0][2] = "Unrestricted User";

		data[1][0] = "j1@gmail.com";

		data[1][1] = "j123";

		data[1][2] = "restricted User";

		data[2][0] = "j2@gmail.com";

		data[2][1] = "j123";

		data[2][2] = "limited User";

		data[3][0] = "j3@gmail.com";

		data[3][1] = "j123";

		data[3][2] = "limited User new ";

		return data;

	}
	
	@AfterTest

	public void tearDown()

	{

	    b.driver.close();

	}

}
