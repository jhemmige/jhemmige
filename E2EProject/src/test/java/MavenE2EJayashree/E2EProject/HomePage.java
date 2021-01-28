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
import org.testng.annotations.Test;
import resources.Base;

public class HomePage extends Base {
	

	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	static WebDriver  driver; // a local driver is created so that this class doesn't have to depend on the driver from Base Class. 'cos there are other
	//classes that is dependent on base driver.

	@BeforeTest
	public static void initDriver() throws IOException {

		driver = initializedriver(); // we are bringing in the method present in baseclass. Where in we are using
										// Chrome browser
		// to open qaclickacademy.com
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		log.info("browser initialized");
		log.info("Chrome browser getting initialized");

	}

	@Test(dataProvider = "getData")
	// base class can be accessed in a different class using extends method ( one
	// way to access a class and its methods)

	// the method should have the data provider variables passed as parameters else,
	// the method will not know what type of
	// variables data provider has

	public void base1PageNavigation(String emailID, String passWord, String text)
			throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize(); // this maximizes the window size
		// we created a new method called basepageNavigation.
		log.info("url is hit");

		Landing_Page_PageObjects lp = new Landing_Page_PageObjects(driver);// this obj exposes the methods present in loginPage class. LogIn
													// Page has

		// various obj pertaining to Login.

		lp.signInPage().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		LogIn_Page_PageObjects lop = new LogIn_Page_PageObjects(driver);

		lop.getEmail().sendKeys(emailID);
		lop.getPwd().sendKeys(passWord);
		lop.getLogInBtn().click();

		System.out.println(text);

		log.info("yay my print" + text);
		
	

	}

	@DataProvider

	public Object[][] getData() {

		// Object is similar to arrays
		// here the fist bracket is the rows
		// second bracket is for column
		// so, in the below case, the first row can hold 4 different sets of data.
		// and column can have 3 attributes of that data.
		// Since its an array, object starts from 0th index.

		// let's say there are 4 sets of data that needs to be passed and if I write new
		// Object[3][2], it'll throw
		// out of bound exception since the object bracket contains the actual numbers
		// and not index starting from 0.

		Object data[][] = new Object[4][3];

		data[0][0] = "asdf@gmail.com";
		data[0][1] = "jhemmige12333";
		data[0][2] = "Unrestricted User";
		data[1][0] = "asdf123@gmail.com";
		data[1][1] = "jhemmige123";
		data[1][2] = "restricted User";
		data[2][0] = "asdf1234@gmail.com";
		data[2][1] = "jhemmige123";
		data[2][2] = "limited User";
		data[3][0] = "asdf123454@gmail.com";
		data[3][1] = "jhemmige123";
		data[3][2] = "limited User new ";

		return data;

	}

	@AfterTest
	public void tearDown() {

		driver.close();

	}

}
