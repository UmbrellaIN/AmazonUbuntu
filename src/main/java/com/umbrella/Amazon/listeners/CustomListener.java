package com.umbrella.Amazon.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.umbrella.Amazon.testCore.TestBase;
import org.testng.IRetryAnalyzer;

public class CustomListener  extends TestBase implements IRetryAnalyzer, ITestListener {
	public static final Logger log = Logger.getLogger(CustomListener.class.getName());
	private int retryCount = 0;
	private int maxRetryCount = 3;

	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			log("***************Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus())
					+ " for the " + (retryCount + 1) + " time(s).*******************");
			retryCount++;
			return true;
		}
		return false;
	}

	public String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAILURE";
		if (status == 3)
			resultName = "SKIP";
		return resultName;
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	public void onFinish(ITestContext arg0) {
		log.info("***********I am in on finish custom listener Test is finished:***************" + arg0.getName());
		Reporter.log("Test is finished:" + arg0.getName());
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		if(!result.isSuccess()){
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			String methodName = result.getName();

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/umbrella/Amazon/screenshots/";
				File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
				
				FileUtils.copyFile(scrFile, destFile);
				
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		log.info("***********I m in Custom Listener**********Test is skipped:********************" + arg0.getMethod().getMethodName());
		Reporter.log("Test is skipped:" + arg0.getMethod().getMethodName());
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
