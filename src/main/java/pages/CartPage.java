package pages;

import org.openqa.selenium.By;

import elements.Element;
import waits.ExplicitWait;

public class CartPage {
	
	private static final Element cartPageTitle = new Element(By.xpath("//span[@class='title' and contains(text(),'Your Cart')]"));
	private static final Element continueShoppingButton = new Element(By.id("continue-shopping"));
	private static final Element checkoutButton = new Element(By.id("checkout"));
	
	// check if the cart page title is displayed
	public boolean cartPageTitleIsDisplayed() {
		ExplicitWait.visibilityOfElementLocated(cartPageTitle.getLocator(), 5);
		return cartPageTitle.isDisplayed();
	}
	
	// click on the continue shopping button
	public void clickOnContinueShoppingButton() {
		ExplicitWait.elementToBeClickable(continueShoppingButton.getLocator(), 5);
		continueShoppingButton.click();
	}
	
	// click on the checkout button
	public void clickOnCheckoutButton() {
		ExplicitWait.elementToBeClickable(checkoutButton.getLocator(), 5);
		checkoutButton.click();
	}
	

}
