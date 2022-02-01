package com.banking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


//Listner Class used to generate extent reports

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@Override
	public void onStart(ITestContext testContext) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repname = "Test-Report-"+timeStamp+".html";
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\"+repname); //specify location
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "User-1");
		
		htmlreporter.config().setDocumentTitle("Banking Test Project"); //Title of the report
		htmlreporter.config().setReportName("Functional Test Report");  //name of the report
		//htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);  //location of the chart
		htmlreporter.config().setTheme(Theme.DARK);
		
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		
		logger = extent.createTest(tr.getName()); //create new entry in th report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		
		logger = extent.createTest(tr.getName()); //create new entry in th report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenShotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenShotPath);
		
		if(f.exists())
		{
			try {
				logger.fail("Screenshot is below: "+logger.addScreenCaptureFromPath(screenShotPath));
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		
		logger = extent.createTest(tr.getName()); //create new entry in th report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}

	@Override
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
	}
}
