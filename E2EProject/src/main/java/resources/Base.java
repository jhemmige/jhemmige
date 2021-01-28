
/** reason to create Base1 given there. */
package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Return;

public class Base {
	
	private static Logger log=	LogManager.getLogger(Base.class.getName());

	public  static WebDriver driver; // we are setting this driver as global level so its available to all the webdrivers and 
	//can be accessed in other classes as well ( instead of Webdriver driver = new ChromeDriver(); or new FirefoxDriver();
	
	public static Properties prop;
	

	public  static WebDriver initializedriver() throws IOException {

		prop= new Properties();  // properties class opens to various methods that's needed to access files located
		// in a different folder 
		System.getProperty("user.dir");  
		/**this gives the path of the project . So the path written below can be changed to 
		FileInputStream fis = new FileInputStream
				("/Users/jayashreehemmige/eclipse-workspace/E2EProject/src/main/java/resources/data1.properties"); This is a better way
				to write the code since there'll be other people using this code hence hard coding the path is not advisable *///we are passing the
		//path for the file using FileInputstream method. (right click data1.properties file to get the path)
		FileInputStream fis = new FileInputStream("/Users/jayashreehemmige/eclipse-workspace/E2EProject/src/main/java/resources/data1.properties" );
		prop.load(fis); //this method loads exposes the file 
		//prop.getProperty("url");
		

		String browserName = prop.getProperty("Browser");// getproperty method helps in accessing the obj present in data1.properties file
		
		//String browserName = System.getProperty("Browser"); // in this command line we are trying to use Maven to invoke chrome browser 
		//instead of using directly at the code level to invoke Chrome browser. Command for terminal is mvn test -DBrowser=Chrome
	
		//we are introducing loop command to get the browser we need
		
		
		if (browserName.contains("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "/Users/jayashreehemmige/Downloads/chromedriver");
			ChromeOptions options = new ChromeOptions(); 
			
			if (browserName.contains("headless")){
				
				options.addArguments("headless");
				
			}
			driver = new ChromeDriver(options );
		}

		else if (browserName.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();

			// Firefox code
//			System.setProperty("webdriver.chrome.driver", "/Users/jayashreehemmige/Documents/chromedriver");
//			driver = new ChromeDriver();
//			driver.get("https://twitter.com/home");

		}

		else if (browserName.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();

			// edge code
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// this gives enough time for execution to prevent from 
		//throwing any error due to selenium or obj loading.
		
		return driver;  // this command returns driver obj. 
		
	}
	
	public static String takeScreenshot(String testCaseName, WebDriver driver) 
	

	{

	TakesScreenshot src= (TakesScreenshot)driver ;
	
	File sorc=src.getScreenshotAs(OutputType.FILE);
	

String destinationFile = System.getProperty("user.dir") + "/reports/screenshots/" + testCaseName+ ".png" ;


	
		try {
			FileUtils.copyFile(sorc, new File (destinationFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
return destinationFile;

}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
}



