package com.qc.testng.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestReportConfig {

	static ExtentReports extent;
	
	public static ExtentReports reportConfig() {
		String path = "test-output/ExtentReport.html";
		ExtentHtmlReporter report = new ExtentHtmlReporter(path);
		report.config().setDocumentTitle("TestNGFramework");
		report.config().setReportName("Extent Report");
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Host Name", "Queue Codes");
		extent.setSystemInfo("User Name", "Tanaji Shinde");
		return extent;
	}
}
