package frameWork;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.MediaEntityBuilder;

public class ConfigMethods {
    @BeforeSuite
	public  void beforesuite(ITestContext ctx) {
	Data.suitName = ctx.getCurrentXmlTest().getSuite().getName();
		Logs.initializeLog();
		Utility_Methods.killProcess();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String fileName = "ExecutionLog_" + timeStamp+".log";
		String filePath = System.getProperty("user.dir")+"\\Logs\\"+fileName;
		File f = new File(filePath);
		System.setProperty("log.file", filePath);
		System.setProperty("log.parent.path", f.getParent());
		System.setProperty("log.file.name", FilenameUtils.getBaseName(f.getName()));
		Data.logger=LogManager.getRootLogger();
		
	}
    @AfterSuite
    public void aftersuite() {
    	Logs.finalizeReport();
    }
    @BeforeTest
    public void beforeTest(ITestContext ctx) {
    	Data.testName = ctx.getCurrentXmlTest().getName();
    	Data.mainTest= Data.reports.createTest(Data.testName);
    }
    @BeforeMethod
	public void BeforeMethod(Method method) {
    	Data.methodName = method.getName();
    	
    	Data.test = Data.mainTest.createNode(Data.methodName);
	}
    @AfterMethod
     public void writeReport(ITestResult result) {

		try {
    	if(result.getStatus()==ITestResult.FAILURE) {
    		Data.test.log(Data.status.FAIL, "testcase failed"+result.getName());
    		
				Data.test.log(Data.status.FAIL, "testcase failed"+result.getThrowable(), 
						MediaEntityBuilder.createScreenCaptureFromPath(Utility_Methods.captureScreenshot(Data.methodName)).build());
			} 
    	else if(result.getStatus()==ITestResult.SUCCESS) {
    		Data.test.log(Data.status.PASS, "testcase passed"+result.getName());
    		Data.test.log(Data.status.PASS, "testcase passed"+result.getThrowable(),
    				MediaEntityBuilder.createScreenCaptureFromPath(Utility_Methods.captureScreenshot(Data.methodName)).build());
    	}else if (result.getStatus()==ITestResult.SKIP) {
    		Data.test.log(Data.status.SKIP, "testcase skipped"+ result.getName());
    		Data.test.log(Data.status.SKIP, "testcase skipped"+ result.getThrowable(),
    				MediaEntityBuilder.createScreenCaptureFromPath(Utility_Methods.captureScreenshot(Data.methodName)).build());
 
    	}}catch (IOException e) {
			e.printStackTrace();
    	}
	
    }
    @AfterTest
    public void afterTest() {
    	Data.driver.close();
	}
    
	}
	
 