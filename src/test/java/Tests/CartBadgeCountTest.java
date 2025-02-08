package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductPage;
import utility.DataReader;

public class CartBadgeCountTest extends TestBase {
	
	String username = DataReader.getStringValue("username", "TestData");
	String password = DataReader.getStringValue("password", "TestData");
	String firstProductName = DataReader.getStringValue("firstProuctName", "TestData");
	String secondProductName = DataReader.getStringValue("secondProductName", "TestData");
	
	@Test(groups="Cart Badge Count Validation Test")
	public void verifyCartBadgeCountShowCorrectly() {
		ProductPage productPage = new ProductPage();
		
		// Step 1: Login with valid credentials
		login(username, password);
		
		// Step 2: Verify the product page is displayed
		Assert.assertTrue(productPage.productTitleIsDisplayed());
		
		// Step 3: Add the first product to the cart
		productPage.addProductToCart(firstProductName);
		
		// Step 4: Add the second product to the cart
		productPage.addProductToCart(secondProductName);
		
		// Step 5: Click on the cart icon
		productPage.clickOnCartIcon();
		
		// Step 6: Verify cart badge count is 2
		int cartCount = productPage.getCartBadgeText();
		Assert.assertEquals(cartCount, 2, "Expected to show 2 in the cart badge");
		
	}

}
