package teaTesting;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class TestRunner {
	
	static ExtentReports extent;
	static ExtentTest test;
	@BeforeClass
	public static void setUp() {
		extent = new ExtentReports(Constants.REPORT_URL,true);
		
		
	}
	@AfterClass
	public static void tearDown() {
		extent.flush();
		
	}
	

}
