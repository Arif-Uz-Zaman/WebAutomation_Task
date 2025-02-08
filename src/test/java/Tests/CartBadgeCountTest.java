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
	public void verifyAddToCartFunctionality () {
		ProductPage productPage = new ProductPage();
		login(username, password);
		Assert.assertTrue(productPage.productTitleIsDisplayed());
		productPage.addProductToCart(firstProductName);
		productPage.addProductToCart(secondProductName);
		productPage.clickOnCartIcon();
		int cartCount = productPage.getCartBadgeText();
		Assert.assertEquals(cartCount, 2, "Expected to show 2 in the cart badge");
		
	}

}
