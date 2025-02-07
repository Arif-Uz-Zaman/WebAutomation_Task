package Tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;
import utility.DataReader;

public class SortingProductsTest extends TestBase {
	
	String username = DataReader.getStringValue("username", "TestData");
	String password = DataReader.getStringValue("password", "TestData");
	
	@Test
	public void verifyProductSortingFunctionality() {
		ProductPage productPage = new ProductPage();
		login(username, password);
		boolean PriceShowInLowToHigh  = productPage.verifyProductSortingByPrice( "Price (low to high)");
		Assert.assertTrue(PriceShowInLowToHigh, "Price is not showing in low to high order");
		
		boolean PriceShowInHighToLow  = productPage.verifyProductSortingByPrice( "Price (high to low)");
		Assert.assertTrue(PriceShowInHighToLow, "Price is not showing in high to low order");
		
		boolean NameShowInAtoZ  = productPage.verifyProductSortingByName( "Name (A to Z)");
		Assert.assertTrue(NameShowInAtoZ, "Name is not showing in A to Z order");
		
		boolean NameShowInZtoA  = productPage.verifyProductSortingByName( "Name (Z to A)");
		Assert.assertTrue(NameShowInZtoA, "Name is not showing in Z to A order");
		
	}
	

}
