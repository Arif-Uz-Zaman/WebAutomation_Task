package Tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;
import utility.DataReader;


public class CheckOutProcessTest extends TestBase {

	String username = DataReader.getStringValue("username", "TestData");
	String password = DataReader.getStringValue("password", "TestData");
	String firstProductName = DataReader.getStringValue("firstProuctName", "TestData");
	JSONObject shippingInformation = DataReader.getJsonObject("shipingInformation", "TestData");
	
	
	@Test(groups="Checkout Process Validation Test")
	public void verifyCheckOutProcess() {
		ProductPage productPage = new ProductPage();
		CartPage cartPage = new CartPage();
		CheckoutPage checkOutPage = new CheckoutPage();
		
		// Step 1: Login with valid credentials
		login(username, password);
		
		// Step 2: add the first product to the cart
		productPage.addProductToCart(firstProductName);
		
		// Step 3: Click on the cart icon
		productPage.clickOnCartIcon();
		
		// Step 4: Click on the checkout button
		cartPage.clickOnCheckoutButton();
		
		// Step 5: Verify the checkout your information page is displayed
		checkOutPage.enterShippingInformation(shippingInformation);
		
		// Step 6: Click on the continue button
		checkOutPage.clickOnContinueButton();
		
		// Step 7: Verify first product item is in the summary
		Assert.assertTrue(productPage.isProductInCart(firstProductName), "First product item is not appears in the summary");
		
		// Step 8: Click on the finish button
		checkOutPage.clickOnFinishButton();
		
		// Step 9: Verify the order is placed successfully
		Assert.assertTrue(checkOutPage.isSucessMessageIsDisplayed(), "Order is not placed successfully");
		
	}

}
