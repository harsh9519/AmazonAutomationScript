package AmazonAutomationScript.AmazonAutomationScript;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {
	
	public ExtentSparkReporter SparkerReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String RepName;

	@Override
	public void onStart(ITestContext testcontext) {
		
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		RepName = "TestReport" + timestamp + ".html";
		
		SparkerReporter = new ExtentSparkReporter("D:\\java eclipse selenium\\AmazonAutomationScript\\Reports\\"+RepName);
		SparkerReporter.config().setDocumentTitle("Amazon test report");
		SparkerReporter.config().setReportName("Amazon shopping test");
		SparkerReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(SparkerReporter);
		extent.setSystemInfo("Application", "Amazon");
		extent.setSystemInfo("Module", "Shopping");
		extent.setSystemInfo("Username", System.getProperty("user.dir"));
		extent.setSystemInfo("Environment", "QA");			
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+"got successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"got Failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"got skip");
	}


	@Override
	public void onFinish(ITestContext testcontext) {
		extent.flush();
		
		String pathofextentreport = System.getProperty("user.dir")+"\\Reports\\"+RepName;
		File extentreport = new File(pathofextentreport);
		
		try {
			Desktop.getDesktop().browse(extentreport.toURI());
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
