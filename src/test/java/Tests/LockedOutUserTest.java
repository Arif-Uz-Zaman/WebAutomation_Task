package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utility.DataReader;

public class LockedOutUserTest extends TestBase {
	 String lockedUsername = DataReader.getStringValue("lockedUsername", "TestData");
     String Password = DataReader.getStringValue("password", "TestData");

	@Test(groups="Locked-Out User Validation Test")
    public void verifyALockedUserCantLogin() {
		
		// Step 1: Login with locked out user credentials
		login(lockedUsername, Password);
		LoginPage loginPage = new LoginPage();
		
		// Step 2: Verify the error message is displayed
		boolean isErrorMessageDisplayed = loginPage.isLockedOutUserErrorMessageDisplayed();
		Assert.assertTrue(isErrorMessageDisplayed, "Error message for locked out user is not displayed");
	}

}
