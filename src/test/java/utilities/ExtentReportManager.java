package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test
	String repoName; // methods

	public void onStart(ITestContext context) {
		// To set the Date and time in my Report
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		Date dt = new Date();
		String timeStamp = df.format(dt);
		repoName = "Test-Report-" + timeStamp + ".html";

		sparkReporter = new ExtentSparkReporter("./reports/" + repoName);// specify
																			// location
																			// of the
																			// report

		sparkReporter.config().setDocumentTitle("OpenCart Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("OpenCart Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub-Module", "Customer");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "kamesh");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));

	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getName()); // create a new entry in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s

	}

	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());

		try {

			// String imgPath=new BaseClass().captureScreen(result.getName());

			BaseClass bc = new BaseClass();
			String imgPath = bc.captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);// Add the ScreenShort to the Report

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
		test.log(Status.SKIP, result.getThrowable().getMessage());

	}

	public void onFinish(ITestContext context) {

		extent.flush();
	}

}
