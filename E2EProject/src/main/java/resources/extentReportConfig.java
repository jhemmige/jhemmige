package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportConfig {
	
	public static ExtentReports extRep; //object created out of the class so its accessible to other classes and its methods
	
	public static ExtentReports extentReporting() {
		
		///Users/jayashreehemmige/eclipse-workspace/E2EProject/reports/
		/** the code below can also be written as 
		 * ExtentSparkReporter eSR= new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/extentreports");
		 *  */
		ExtentSparkReporter eSR= new ExtentSparkReporter("/Users/jayashreehemmige/eclipse-workspace/E2EProject/reports/extentreports");
		eSR.config().setReportName("Jayashree's Automation Testing Result");
		
		eSR.config().setDocumentTitle("Jayashree_Report_Document_Title");
		
		 extRep= new ExtentReports();
		extRep.attachReporter(eSR);
		extRep.setSystemInfo("Jayashree Hemmige", "User");
		
		return extRep; // finally we can add return command so this returns extRep
		
	}

}
