package Tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductPage;
import utility.DataReader;

public class LoginTest extends TestBase {

	String username = DataReader.getStringValue("username", "TestData");
	String password = DataReader.getStringValue("password", "TestData");
	String invalidUsername = RandomStringUtils.randomAlphabetic(10);
	String invalidPassword = RandomStringUtils.randomAlphabetic(10);
	
	@Test(groups="Login Functionality Test")
	public void verifyLoginWithValidCredentials() {
		ProductPage productPage = new ProductPage();
		// Step 1: Login with valid credentials
		login(username,password);
		
		// Step 2: Verify the product page is displayed
		Assert.assertTrue(productPage.productTitleIsDisplayed());
	}
	
	@Test(groups="Login Functionality Test")
    public void verifyLoginWithInvalidUsername() {

		LoginPage loginPage = new LoginPage();
		
		// Step 1: Login with invalid username and valid password
		login(invalidUsername, password);
		
		// Step 2: Verify the error message is displayed
		Assert.assertTrue(loginPage.errorMessageIsDisplayed());
	}
	
	@Test(groups="Login Functionality Test")
	public void verifyLoginWithInvalidPassword() {

		LoginPage loginPage = new LoginPage();
		
		// Step 1: Login with valid username and invalid password
		login(username, invalidPassword);
		
		// Step 2: Verify the error message is displayed
		Assert.assertTrue(loginPage.errorMessageIsDisplayed());
	}
	
	@Test(groups="Login Functionality Test")
	public void verifyLoginWithInvalidCredentials() {

		LoginPage loginPage = new LoginPage();
		
		// Step 1: Login with invalid username and invalid password
		login(invalidUsername, invalidPassword);
		
		// Step 2: Verify the error message is displayed
		Assert.assertTrue(loginPage.errorMessageIsDisplayed());
	}

}
