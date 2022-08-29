package com.TechMax.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestLisImpClass implements ITestListener {
	
	public void onTestFailure(ITestResult result){
		String testCaseName = result.getMethod().getMethodName();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		JavaUtility jLib=new JavaUtility();
		String date_time = jLib.getSystemDate();
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshot/"+testCaseName+date_time+".png");
		try {
			FileHandler.copy(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
