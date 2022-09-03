package com.TechMax.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetry implements IRetryAnalyzer {

	int count=0;
	int retryLimit=4;
	public boolean retry(ITestResult arg0) {
		if(count<retryLimit){
			count++;
			return true;
		}
		return false;
	}

}
