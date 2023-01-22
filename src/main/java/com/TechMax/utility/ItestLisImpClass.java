package com.TechMax.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ItestLisImpClass implements ITestListener  {
	ExtentReports extentReporter;
	ExtentTest test;

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName() + "is failed");
		test.log(Status.FAIL, result.getThrowable());
		String path = WebDriverUtility.takeScreenShot(BaseClass.sdriver,result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName() + "is passed");
	}

	public void onFinish(ITestContext arg0) {
		test.log(Status.INFO, "Browser is closed");
		extentReporter.flush();
	}

	public void onStart(ITestContext arg0) {

		ExtentSparkReporter extentSparkreports = new ExtentSparkReporter(
				"./ExtentReports/" + new JavaUtility().getSystemDateInIST() + ".html");
		extentSparkreports.config().setDocumentTitle("Redbus-Reports");
		extentSparkreports.config().setTheme(Theme.DARK);
		extentSparkreports.config().setReportName("BusCountMatchingTo");
		extentSparkreports.config().setTimelineEnabled(true);
		extentReporter = new ExtentReports();
		extentReporter.attachReporter(extentSparkreports);
		extentReporter.setSystemInfo("Reporter", "venkat");
		extentReporter.setSystemInfo("OS", "Windows-10");
		extentReporter.setSystemInfo("Browser", "chrome");
		extentReporter.setSystemInfo("URL", "http://www.Redbus.in");

	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, result.getMethod().getMethodName() + "is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestStart(ITestResult result) {

		test = extentReporter.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "Browser is lanched");
		
		
	}
	// String testCaseName = result.getMethod().getMethodName();
	// EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
	// JavaUtility jLib=new JavaUtility();
	// String date_time = jLib.getSystemDate();
	// File src = edriver.getScreenshotAs(OutputType.FILE);
	// File dst=new File("./Screenshot/"+testCaseName+date_time+".png");
	// try {
	// FileHandler.copy(src, dst);
	// } catch (IOException e) {
	//
	// e.printStackTrace();
	// }

}
