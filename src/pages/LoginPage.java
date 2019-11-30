package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameWork.Data;
import frameWork.Event_methods;

public class LoginPage {
        @FindBy(xpath = "//img[@class='img-responsive']") WebElement Logo;
        @FindBy(name = "username") WebElement username;
        @FindBy(name = "password") WebElement password;
        @FindBy(xpath =  "//input[@class='btn btn-small']") WebElement Login;
        public LoginPage() {
        	PageFactory.initElements(Data.driver, this);
        	
        }
        public boolean vaildateLogo() {
			return Logo.isDisplayed();
        }
		public String getloginPageTitile() { 	
        	return Data.driver.getTitle();
        }
		public void login(String userName, String passWord) {
			username.sendKeys(userName);
			password.sendKeys(passWord);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Event_methods.clickElement(Login);
		} 
}
