package frameWork;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utility_Methods {
	public static void createFolder(String foldPath) {
		File f = new File(foldPath);
		if (!f.exists()) {
			f.mkdirs();
		}
	}
	public static String getTimeStamp() {
		String timeStamp = "";
		Date d = new Date();
		Calendar c =Calendar.getInstance();
		c.setTime(d);	    	
		timeStamp = timeStamp+c.get(Calendar.MONTH)+c.get(Calendar.DAY_OF_MONTH)+c.get(Calendar.HOUR)+c.get(Calendar.MINUTE)+c.get(Calendar.SECOND);


		return timeStamp;
	}
	public static void killProcess() {

		String killcmd="taskkill /F /IM ";
		for(int i=0;i<Data.process_to_terminate.length;i++) {
			try {
				Runtime.getRuntime().exec(killcmd+ Data.process_to_terminate[i]);
			} catch (IOException e) {
				System.out.println("Process : " + Data.process_to_terminate[i] + " could not be terminated.");
			}
		}

	}
	public static String captureScreenshot(String screenshotName) {
		screenshotName = screenshotName+getTimeStamp()+".png";	    	
		createFolder(System.getProperty("user.dir")+"\\Screenshots");
		String destPath = System.getProperty("user.dir")+"\\Screenshots\\"+screenshotName;

		TakesScreenshot ts = (TakesScreenshot) Data.driver;
		File image = ts.getScreenshotAs(OutputType.FILE);	    	
		try {
			FileUtils.moveFile(image, new File(destPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return destPath;
	}
}