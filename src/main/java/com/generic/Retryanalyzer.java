package com.generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryanalyzer  implements IRetryAnalyzer {
	 private static final int count = 3; // Maximum number of retry attempts

	    private int retryCount = 0;

	    @Override
	    public boolean retry(ITestResult result) {
	        if (retryCount <count) {
	            System.out.println("Retrying test: " + result.getName() + " for the " + (retryCount + 1) + " time.");
	            retryCount++;
	            return true; // Retry the test
	        }
	        return false; // Do not retry the test
	    }

}
