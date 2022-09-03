package com.TechMax.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ItestLisImpClass implements ITestListener {
	ExtentReports extentReporter ;
	ExtentTest test;
	public void onTestFailure(ITestResult result){
		test.log(Status.FAIL, result.getMethod().getMethodName()+"is failed" );
		test.log(Status.FAIL, result.getThrowable());
		test.fail( "Test is failed",MediaEntityBuilder.createScreenCaptureFromPath(WebDriverUtility.takeScreenShot()).build());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+"is passed" );
	}

	@Override
	public void onFinish(ITestContext arg0) {
		extentReporter.flush();
	}

	@Override
	public void onStart(ITestContext arg0) {
		
		ExtentSparkReporter extentSparkreports=new ExtentSparkReporter("./ExtentReports/"+ new JavaUtility().getSystemDateInIST()+".html");
		extentSparkreports.config().setDocumentTitle("TechMax-Reports");
		extentSparkreports.config().setTheme(Theme.DARK);
		extentSparkreports.config().setReportName("TechMax-SuiteExecution");
		extentReporter = new ExtentReports();
		extentReporter.attachReporter(extentSparkreports);
		extentReporter.setSystemInfo("Reporter", "Praveen");
		extentReporter.setSystemInfo("OS", "Windows-11");
		extentReporter.setSystemInfo("Browser", "chrome");
		extentReporter.setSystemInfo("URL", "http://192.168.0.190/domain/Sales_And_Inventory_System/pages/pos.php");

		
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP,result.getMethod().getMethodName()+"is skipped" );
		test.log(Status.SKIP, result.getThrowable());
	}



	@Override
	public void onTestStart(ITestResult result) {
		
		test = extentReporter.createTest(result.getMethod().getMethodName());
	}
//	String testCaseName = result.getMethod().getMethodName();
//	EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
//	JavaUtility jLib=new JavaUtility();
//	String date_time = jLib.getSystemDate();
//	File src = edriver.getScreenshotAs(OutputType.FILE);
//	File dst=new File("./Screenshot/"+testCaseName+date_time+".png");
//	try {
//		FileHandler.copy(src, dst);
//	} catch (IOException e) {
//		
//		e.printStackTrace();
//	}
	
}
