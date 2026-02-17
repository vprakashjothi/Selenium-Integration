package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
private static ExtentReports extent;
private static ExtentTest test;
	public static void createTest(String testName) {
		ExtentSparkReporter reporter=new ExtentSparkReporter("reports/extentReport.html");
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		test=extent.createTest(testName);
		
	}
	public static void flushReport() {
        extent.flush();
    }
}
