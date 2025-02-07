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
		login(username,password);
		Assert.assertTrue(productPage.productTitleIsDisplayed());
	}
	
	@Test(groups="Login Functionality Test")
    public void verifyLoginWithInvalidUsername() {

		LoginPage loginPage = new LoginPage();
		login(invalidUsername, password);
		Assert.assertTrue(loginPage.errorMessageIsDisplayed());
	}
	
	@Test(groups="Login Functionality Test")
	public void verifyLoginWithInvalidPassword() {

		LoginPage loginPage = new LoginPage();
		login(username, invalidPassword);
		Assert.assertTrue(loginPage.errorMessageIsDisplayed());
	}
	
	@Test(groups="Login Functionality Test")
	public void verifyLoginWithInvalidCredentials() {

		LoginPage loginPage = new LoginPage();
		login(invalidUsername, invalidPassword);
		Assert.assertTrue(loginPage.errorMessageIsDisplayed());
	}

}
