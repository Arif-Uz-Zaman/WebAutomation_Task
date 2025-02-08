package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductPage;
import utility.DataReader;

public class LogOutTest extends TestBase {
	
	String username = DataReader.getStringValue("username", "TestData");
	String password = DataReader.getStringValue("password", "TestData");

	@Test(groups="Logout Functionality Test")
	public void verifyLogOutFunctionality() {
		ProductPage productPage = new ProductPage();
		LoginPage loginPage = new LoginPage();
		
		// Step 1: Login with valid credentials
		login(username, password);
		
		// Step 2: click on the menu button
		productPage.clickOnMenuButton();
		
		// Step 3: click on the logout button
		productPage.clickOnLogoutButton();
		
		// Step 4: Verify the login page is displayed
		boolean isLoginPageDisplayed = loginPage.isLoginPageDisplayed();
		Assert.assertTrue(isLoginPageDisplayed, "Login page is not displayed after logout");
		
	}

}
