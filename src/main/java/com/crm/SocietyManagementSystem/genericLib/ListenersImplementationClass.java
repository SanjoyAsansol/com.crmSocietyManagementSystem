package com.crm.SocietyManagementSystem.genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementationClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	
	public void onTestStart(ITestResult result) {
		//Execution Starts from here
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"--------> TestScript Execution Started");
		}

	
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"-----> Passed");
		Reporter.log(MethodName+"---->Test script execution Successful");
		}

	
	public void onTestFailure(ITestResult result) {
		
		String Failedscript= result.getMethod().getMethodName();
		String FS="FailedScript"+new JavaUtility().getSystemDateDataAndTimeFormat();
		
		EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.ListnerDriver);
		File sec = edriver.getScreenshotAs(OutputType.FILE);
		File dst= new File("./Screenshot/"+FS+".png");
		String filepath=dst.getAbsolutePath();
		try {
			FileUtils.copyFile(sec, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath);
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("--TestScript Execution failed--");
	}
	
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"-- Skipped");
		Reporter.log("--TestScript Execution skipped--");
		}

	public void onStart(ITestContext context) {
		//Configure the report
		ExtentSparkReporter htmlreport= new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-45 Extent Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Society Management System");
		
		report= new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("BaseURL", "http://rmgtestingserver:8888/");
		report.setSystemInfo("Reporter Name", "Sanjoy Mondal");
		}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}
}
