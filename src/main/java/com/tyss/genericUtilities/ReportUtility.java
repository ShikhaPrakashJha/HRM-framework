package com.tyss.genericUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtility 
{
	private ExtentReports report;
	
	public void init(String filePath, String title, String reportName, String browserName)
	{
		ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
		spark.config().setDocumentTitle(title);
		spark.config().setReportName(reportName);
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", browserName);
		report.setSystemInfo("OS", System.getProperty("os.name"));
	}
	


		public void createTest(String testName)
		{
			ExtentTest test = report.createTest(testName);
			UtilityInstanceTransfer.setExtentTest(test);
		}
		public void fail(ExtentTest test, String message, Throwable errorMessage)
		{
			test.fail(message);
			test.fail(errorMessage);
			System.out.println(message);
		}
		public void addAuthor(ExtentTest test, String... names)
		{
			test.assignAuthor(names);
			
		}
		public void addCategory(ExtentTest test, String... names)
		{
			test.assignCategory(names);
			
		}

		public void pass(ExtentTest test, String message)
		{
			test.pass(message);
			System.out.println(message);
		}
		public void warn(ExtentTest test, Throwable message)
		{
			test.warning(message);
			System.out.println(message);
		}
		public void skip(ExtentTest test, String message, Throwable errorMessage)
		{
			test.skip(message);
			test.skip(errorMessage);
			System.out.println(message);
		}
		public void info(ExtentTest test, String message)
		{
			test.info(message);
			System.out.println(message);
		}
		
		public void attachScreenshot(ExtentTest test, String screenshotPath, String title, String strategy)
		{
			if(strategy.equalsIgnoreCase("base64"))
			{
				test.addScreenCaptureFromBase64String(screenshotPath, title);
			}
			else
			{
				test.addScreenCaptureFromPath(screenshotPath, title);
			}
		}
		public void saveReport()
		{
			report.flush();
		}
}
