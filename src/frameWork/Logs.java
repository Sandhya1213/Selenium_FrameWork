package frameWork;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Logs {
	public static void initializeLog() {
		Utility_Methods.createFolder(System.getProperty("user.dir")+"//Reports//");
		String fileName = Data.suitName+"_"+Utility_Methods.getTimeStamp()+".html";
		String file = System.getProperty("user.dir")+"//Reports//"+fileName;
		Data.extentHtmlReporter = new ExtentHtmlReporter(file);
		Data.extentHtmlReporter.config().setDocumentTitle("Results _ "+Data.suitName);
		Data.extentHtmlReporter.config().setTheme(Theme.STANDARD);
		Data.extentHtmlReporter.config().setReportName("Test Execution");
		
		Data.reports = new ExtentReports();
		Data.reports.attachReporter(Data.extentHtmlReporter);
	}
        public static void finalizeReport() {
        	Data.reports.flush();
        }
}
