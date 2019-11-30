package frameWork;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Data {
	 public static WebDriver driver;
	 public static final int IMPLICIT_WAIT =20;
	 public static Object[] process_to_terminate = {"chrome.exe","firefox.exe","iexplore.exe"};
	 public static Logger logger;
	 public static  ExtentHtmlReporter extentHtmlReporter;
	 public static ExtentReports reports;
	 public static String suitName;
	 public static String methodName;
	 public static String testName;
	 public static ExtentTest test;
	 public static ExtentTest mainTest;
	 public static Status status;
	 
}