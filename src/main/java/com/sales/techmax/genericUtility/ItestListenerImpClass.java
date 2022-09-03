package com.sales.techmax.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListenerImpClass implements ITestListener{
	public void onTestFailure(ITestResult result)  {
		JavaUtility jLib=new JavaUtility();
		BaseClass bc=new BaseClass();
		String sdt = jLib.getSystemDateTime();
		String testName=result.getMethod().getMethodName();
		//EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sdriver);
		@SuppressWarnings("static-access")
		TakesScreenshot ts=(TakesScreenshot)bc.sdriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./ScrnShot/"+testName+"_"+sdt+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
