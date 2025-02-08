package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;

import driver.Browser;
import pages.LoginPage;
import utility.DataReader;

@Listeners(ChainTestListener.class)
public abstract class TestBase {
	
	protected WebDriver driver;		
    private int implicitWaitTimeInSeconds = DataReader.getIntValue("implicitWaitTimeInSeconds", "config");
	
	@BeforeMethod
	public void setUp() {
		driver = Browser.initialize();
		driver.get(DataReader.getStringValue("url", "Config"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTimeInSeconds));
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		Browser.quitDriver();
	}

	 public void login(String username, String password) {
	        LoginPage loginPage = new LoginPage();
	        loginPage.login(username, password);
	    }
}
