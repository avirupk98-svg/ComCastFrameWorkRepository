package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.BaseTest.BaseClass;

public class ListenerImplClass implements ITestListener, ISuiteListener
{
	ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
	public ExtentReports report;
	public static ExtentTest test;
	
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		
		//Configuring the Extent Report
		spark.config().setDocumentTitle("Detailed Report");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		// Adding the environment information and create Test
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Wondows 10");
		report.setSystemInfo("BROWSER", "Chrome 100");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		
		System.out.println("Report BackUp");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " Start");
		String testName=result.getMethod().getMethodName();
		test=report.createTest(testName); //Doubt what will happen if we just write report.createTest(testName)
		
		test.log(Status.INFO, testName+ "Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.PASS,result.getMethod().getMethodName()+ " End");
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String time=new Date().toString().replace(":","_");
		
		
//		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sdriver);
//		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
//		String time=new Date().toString().replace(" ", "_").replace(":", "_");
//		
//		try {
//			FileUtils.copyFile(srcFile, new File ("./Screenshots/"+testName+"+"+time+".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		String testName=result.getMethod().getMethodName();
		
		TakesScreenshot eDriver= (TakesScreenshot) BaseClass.sdriver;
				String filePath= eDriver.getScreenshotAs(OutputType.BASE64);
				
				test.addScreenCaptureFromBase64String(filePath, testName + "_" + time);
				
				test.log(Status.FAIL,result.getMethod().getMethodName()+ " Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
