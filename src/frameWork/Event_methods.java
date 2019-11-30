package frameWork;

import java.time.Duration;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Event_methods {

	public static boolean waitforElement_to_enable(WebElement element, int timeOut) {
		boolean isElementEnabled=false;

		try {
		WebDriverWait wait = new WebDriverWait(Data.driver, timeOut);
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.pollingEvery(Duration.ofMillis(200));
		 isElementEnabled=true;
		}catch(Exception e){
			 isElementEnabled=true;
			System.out.println("element " + element.toString() + "' is not enabled even after waiting for :" + timeOut
					+ " seconds.");
		}
       return isElementEnabled;  
	}
	public static boolean waitforElement_to_visible(WebElement element, int timeOut) {
		boolean isElementEnabled=false;


		try {
		WebDriverWait wait = new WebDriverWait(Data.driver, timeOut);
        element = wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.pollingEvery(Duration.ofMillis(200));
		 isElementEnabled=true;
		}catch(Exception e) {
			 isElementEnabled=false;
			 System.out.println("element " + element.toString() + "' is not enabled even after waiting for :" + timeOut
						+ " seconds.");
			
          }
		return isElementEnabled;
          }
	public static void clickElement(WebElement element) {
		if(element!=null) {
			if(waitforElement_to_enable(element, 20)) {
				if(waitforElement_to_visible(element, 20)) {
					element.click();
				}else {
					Assert.assertFalse(true, "Element "+element.toString()+"is not visible till"+20+"seconds");
				}
					
				}else {
					Assert.assertFalse(true,"Element"+element.toString()+"is not enabled till"+20+"seconds");
				}
					
				}else {
					Assert.assertFalse(true,"Element is not found");
				}
		}
			}
          
