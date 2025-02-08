package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utility.DataReader;

public class LockedOutUserTest extends TestBase {
	 String lockedUsername = DataReader.getStringValue("lockedUsername", "TestData");
     String Password = DataReader.getStringValue("password", "TestData");

	@Test
    public void verifyALockedUserCantLogin() {
		login(lockedUsername, Password);
		LoginPage loginPage = new LoginPage();
		boolean isErrorMessageDisplayed = loginPage.isLockedOutUserErrorMessageDisplayed();
		Assert.assertTrue(isErrorMessageDisplayed, "Error message for locked out user is not displayed");
	}

}
