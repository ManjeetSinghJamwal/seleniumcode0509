package day0909;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext context) {

		String reportpath = System.getProperty("user.dir") + "./src/test/resources/reports";
		sparkReporter = new ExtentSparkReporter(reportpath);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("ComputerName", "Local Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("TesterName", "Manjeet Singh Jamwal");
		extent.setSystemInfo("OS", "Window 11");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "TestCase PASSED is :" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "TestCase FAILED is :" + result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "TestCase SKIPPED is:" + result.getName());

	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}
}
