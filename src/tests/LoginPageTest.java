package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import frameWork.ConfigMethods;
import frameWork.Data;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginPageTest extends ConfigMethods {
	LoginPage loginpage;
	@BeforeTest
	public void launchingBrowser() {
		WebDriverManager.chromedriver().setup();
		Data.driver = new ChromeDriver();
		Data.driver.get("https://classic.crmpro.com");
		loginpage = new LoginPage();
	}
	@Test(priority = 3)
	public void Login() {
	loginpage.login("sudhananda123", "Test@1234");
	Data.logger.trace("ghc,,yyuf"); 
}
	@Test(priority = 1) 
	public void vaildateLogo() {
		boolean flag=loginpage.vaildateLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority = 2)
	public 	void vaidateTitle() {
    String title = loginpage.getloginPageTitile();
    System.out.println(title);
    Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");

	}
}