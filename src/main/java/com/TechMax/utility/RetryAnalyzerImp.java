package com.TechMax.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImp implements IRetryAnalyzer{
	int counter=0;
	int retryLimit=2;  //RetryLimitCount is given by developer ,TE should not assume Limit
	public boolean retry(ITestResult result) {
		if(counter<retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
