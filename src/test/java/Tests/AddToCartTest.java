package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductPage;
import utility.DataReader;


public class AddToCartTest extends TestBase {
	
	String username = DataReader.getStringValue("username", "TestData");
	String password = DataReader.getStringValue("password", "TestData");
	String firstProductName = DataReader.getStringValue("firstProuctName", "TestData");
	String secondProductName = DataReader.getStringValue("secondProductName", "TestData");
	
	@Test(groups="Add To Cart Functionality Test")
	public void verifyAddToCartFunctionality () {
		ProductPage productPage = new ProductPage();
		login(username, password);
		Assert.assertTrue(productPage.productTitleIsDisplayed());
		productPage.addProductToCart(firstProductName);
		productPage.addProductToCart(secondProductName);
		productPage.clickOnCartIcon();
		Assert.assertTrue(productPage.isProductInCart(firstProductName), "First product is not in the cart");
		Assert.assertTrue(productPage.isProductInCart(secondProductName), "Second product is not in the cart");
		
	}
	
	@Test(groups="Add To Cart Functionality Test")
    public void verifyCartBadgeCountUpdatesCorrectly() {
        // Step 1: Login with valid credentials
		ProductPage productPage = new ProductPage();
		login(username, password);
		Assert.assertTrue(productPage.productTitleIsDisplayed());
		productPage.addProductToCart(firstProductName);
		productPage.addProductToCart(secondProductName);

        // Step 3: Remove the first product
        productPage.removeProductFromCart(firstProductName);

        //System.out.println(productPage.getCartBadgeText());
        
        // Step 4: Verify the cart badge count updates correctly
        Assert.assertEquals(productPage.getCartBadgeText(), 1, "Expected to show 1 in the cart badge after removal");

        // Step 5: Add the first product again
		productPage.addProductToCart(firstProductName);

        // Step 6: Verify the cart badge count updates correctly
        Assert.assertEquals(productPage.getCartBadgeText(), 2,"Expected to show 2 in the cart badge after re-adding");

        // Step 7: Remove both products
        productPage.removeProductFromCart(firstProductName);
        productPage.removeProductFromCart(secondProductName);

        // Step 8: Verify the cart badge count is 0
        Assert.assertEquals(productPage.getCartBadgeText(),0,"Expected to show 0 in the cart badge afetr removing all items");
        
        
    }
	
	
}
