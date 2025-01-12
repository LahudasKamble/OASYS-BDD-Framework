package com.mystore.utilities;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListernerClass implements ITestListener {

	ExtentSparkReporter htmlReportr;
	ExtentReports Reports;
	ExtentTest test;


	//to configure html report below method 

	public void configureReport() {

		ReadConfig readconfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.m.d.hh.mm.ss").format(new Date());
		String reportname = "DDFramework-" + timestamp+ ".html";

		htmlReportr = new ExtentSparkReporter(System.getProperty("user.dir") +"//Reports//"+ reportname);
		Reports = new ExtentReports();
		Reports.attachReporter(htmlReportr);

		//add system information/environment info to reports

		Reports.setSystemInfo("Machine :", "LenvoL480");
		Reports.setSystemInfo("OS", "Windows11");
		Reports.setSystemInfo("Browser :", readconfig.getbrowser());
		Reports.setSystemInfo("User Name:", "Lahu");

		// configuration to change look and fell of report

		htmlReportr.config().setDocumentTitle("Extent Listerner Report Demo");
		htmlReportr.config().setReportName("This Is My First report");
		htmlReportr.config().setTheme(Theme.DARK);


	}

	// onStart method is called when any test starts

	public void onStart(ITestContext Result) {

		configureReport();
		System.out.println("on Start method invoked");

	}

	// onFinish method is called after all tests are executed

	public void onFinish(ITestContext Result) {

		System.out.println("on Finished method invoked");
		Reports.flush(); //it is mandatory to call flush method to ensure information is written to the started reporter
	}



	// when test case get failed , this method is call

	public void onTestFailure(ITestResult Result) {

		System.out.println("Name of the method failed :" + Result.getName());
		test = Reports.createTest(Result.getName()); //create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of Failed test case is :" + Result.getName() , ExtentColor.RED));

		String Screenshotspath = System.getProperty("user.dir") + "//Screenshots//" + Result.getName() +".png";

		File Screenshotfile = new File(Screenshotspath);

		if(Screenshotfile.exists()) 
		{

			test.fail("Captured screenhsot is below :" + test.addScreenCaptureFromPath(Screenshotspath));
		}
	}


	// when test case get Skipped , this method is call

	public void onTestSkip(ITestResult Result) {

		System.out.println("Name of the method Skipped:" + Result.getName());
		test = Reports.createTest(Result.getName()); //create entry in html report
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of Skipped test case is :" + Result.getName() , ExtentColor.YELLOW));

	}

	// when test case get Started , this method is call

	public void onTestStart(ITestResult Result) {

		System.out.println("Name of Test method Started :" + Result.getName());
	}

	// when test case get Passed , this method is call

	public void onTestSuccess(ITestResult Result) {

		System.out.println("Name of the method Passed :" + Result.getName());
		test = Reports.createTest(Result.getName()); //create entry in html report
		test.log(Status.PASS, MarkupHelper.createLabel("Name of Passed test case is :" + Result.getName() , ExtentColor.GREEN));


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {


	}
}
