package com.indusface.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{
	
	
	public void onStart(ITestContext arg0) {
 
		log("About to begin executing  " + arg0.getName());
 
	}
 
	public void onFinish(ITestContext arg0) {
 
		log("End of executing class " + arg0.getName());
 
	}
	public void onTestStart(ITestResult tr) {
		log("Test Started....");
	}

	public void onTestSuccess(ITestResult tr) {

		log("Test '" + tr.getName() + "' PASSED");
		System.out.println(".....");
	}

	
	public void onTestFailure(ITestResult tr) {

		log("Test '" + tr.getName() + "' FAILED");
		System.out.println(".....");
		try {
			takeScreenShot(CommonUtil.getPropertyValue("ScreenShotPath"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
	public void onTestSkipped(ITestResult tr) {
		log("Test '" + tr.getName() + "' SKIPPED");
		System.out.println(".....");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	private void log(String methodName) {
		System.out.println(methodName);
	}

	private void log(IClass testClass) {
		System.out.println(testClass);
	}
	public void takeScreenShot(String destPath) throws IOException{
		File srcfile=((TakesScreenshot)Driver.driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(destPath);
		FileUtils.copyFile(srcfile, new File(destPath));
	}

}

