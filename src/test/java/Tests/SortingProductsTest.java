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
	
	@Test(groups="Sorting Products Validation Test")
	public void verifyProductSortingFunctionality() {
		ProductPage productPage = new ProductPage();
		
		// Step 1: Login with valid credentials
		login(username, password);
		
		// step 2: Verify the product is sorted by price low to high order
		boolean PriceShowInLowToHigh  = productPage.verifyProductSortingByPrice( "Price (low to high)");
		Assert.assertTrue(PriceShowInLowToHigh, "Price is not showing in low to high order");
		
		// step 3: Verify the product is sorted by price high to low order
		boolean PriceShowInHighToLow  = productPage.verifyProductSortingByPrice( "Price (high to low)");
		Assert.assertTrue(PriceShowInHighToLow, "Price is not showing in high to low order");
		
		// step 4: Verify the product is sorted by name A to Z order
		boolean NameShowInAtoZ  = productPage.verifyProductSortingByName( "Name (A to Z)");
		Assert.assertTrue(NameShowInAtoZ, "Name is not showing in A to Z order");
		
		// step 5: Verify the product is sorted by name Z to A order
		boolean NameShowInZtoA  = productPage.verifyProductSortingByName( "Name (Z to A)");
		Assert.assertTrue(NameShowInZtoA, "Name is not showing in Z to A order");
		
	}
	

}
