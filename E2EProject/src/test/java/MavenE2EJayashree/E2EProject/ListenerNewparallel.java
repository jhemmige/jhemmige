

//This is for parallel test in extent reporting. 
//This test is failing while running . its better to run only Listerner New class since its sequential. 
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

public class ListenerNewparallel extends Base implements ITestListener {
	ExtentReports extRep= extentReportConfig.extentReporting();
	/**When static is declared, we can call method by class.method instead of creating an object for that class. This is then passed into a variable
	called extRep ( which is actually returned in extentReportconfig) and this variable takes ExtentReports as the returnType.*/
	
	ExtentTest test;
	public static WebDriver driver;
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	ThreadLocal<ExtentTest> local= new ThreadLocal<ExtentTest>(); //class in java to run the test parallelly. So where ever we are using test ( check 
	//ListernerNew, we will use local.
	@Override
	public void onTestStart(ITestResult result) {
		
		test = extRep.createTest(result.getMethod().getMethodName());

		local.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
	local.get().log(Status.PASS, "Yay!!! My tests have passed from ExtentReports_tests");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		local.get().fail(result.getThrowable());
		local.get().log(Status.FAIL, "oopsie daisee...tests failed");

		WebDriver driver = null;

		String testMethodName = result.getMethod().getMethodName();

		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstanceName());

		} catch (Exception e)

		{

		}

		try {
			local.get().addScreenCaptureFromPath( takeScreenshot(testMethodName, driver), result.getMethod().getMethodName()); 
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
