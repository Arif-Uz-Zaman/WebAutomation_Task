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
	
	
	@Test
	public void verifyCheckOutProcess() {
		ProductPage productPage = new ProductPage();
		CartPage cartPage = new CartPage();
		CheckoutPage checkOutPage = new CheckoutPage();
		login(username, password);
		productPage.addProductToCart(firstProductName);
		productPage.clickOnCartIcon();
		cartPage.clickOnCheckoutButton();
		checkOutPage.enterShippingInformation(shippingInformation);
		checkOutPage.clickOnContinueButton();
		Assert.assertTrue(productPage.isProductInCart(firstProductName), "First product item is not appears in the summary");
		checkOutPage.clickOnFinishButton();
		Assert.assertTrue(checkOutPage.isSucessMessageIsDisplayed(), "Order is not placed successfully");
		
	}

}
