package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductPage;
import utility.DataReader;

public class LogOutTest extends TestBase {
	
	String username = DataReader.getStringValue("username", "TestData");
	String password = DataReader.getStringValue("password", "TestData");

	@Test
	public void verifyLogOutFunctionality() {
		login(username, password);
		ProductPage productPage = new ProductPage();
		LoginPage loginPage = new LoginPage();
		productPage.clickOnMenuButton();
		productPage.clickOnLogoutButton();
		boolean isLoginPageDisplayed = loginPage.isLoginPageDisplayed();
		Assert.assertTrue(isLoginPageDisplayed, "Login page is not displayed after logout");
		
	}

}
