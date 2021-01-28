/**214. Screenshots on failure- TestNG
Listeners
13min

215. How to send Driver object of
TestInstance to Listener on Test failure
 * 
 * 216. Extent reports on Generation on Test
Execution*/

//This is for sequential test in extent reporting. 
package MavenE2EJayashree.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.extentReportConfig;

public class ListenerNew extends Base implements ITestListener {
	ExtentReports extRep= extentReportConfig.extentReporting();
	/**When static is declared, we can call method by class.method instead of creating an object for that class. This is then passed into a variable
	called extRep ( which is actually returned in extentReportconfig) and this variable takes ExtentReports as the returnType.*/
	
	ExtentTest test;
	public static WebDriver driver;
	private static Logger log = LogManager.getLogger(HomePage.class.getName());

	@Override
	public void onTestStart(ITestResult result) {
		test = extRep.createTest(result.getMethod().getMethodName()); // testcase name should be dynamic.
		// extentReportConfig erc = new extentReportConfig();
		// extRep.createTest(result.getMethod().getMethodName()); // this step helps in
		// creating the TestCaseName

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String met = result.getMethod().getMethodName();
		log.info("yippee ...my tests passed. yolo this is from listener's class ");

		test.log(Status.PASS, "Yay!!! My tests have passed from ExtentReports_tests");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable());
		test.log(Status.FAIL, "oopsie daisee...tests failed");

		WebDriver driver = null;

		String testMethodName = result.getMethod().getMethodName();

		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstanceName());

		} catch (Exception e)

		{

		}

		try {
			test.addScreenCaptureFromPath( takeScreenshot(testMethodName, driver), result.getMethod().getMethodName()); 
			// above line if code is from extent report, where we are taking screenshot and showing it on the report
			Base tScrshot = new Base();
			tScrshot.takeScreenshot(testMethodName, driver);

		} catch (Exception e)

		{

			e.printStackTrace();

		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onFinish(ITestContext context) {
		
		extRep.flush();
	}

}
