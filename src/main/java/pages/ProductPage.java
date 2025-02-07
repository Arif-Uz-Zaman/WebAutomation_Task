package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import elements.Element;
import waits.ExplicitWait;

public class ProductPage {

    private final Element productTitle = new Element(By.xpath("//span[@class='title' and contains(text(),'Products')]"));
    private final Element cartIcon = new Element(By.xpath("//a[contains(@class, 'shopping_cart_link')]"));
    private final Element cartBadge = new Element(By.xpath("//span[@class='shopping_cart_badge']"));

    // Access product element by name
    private Element getProductElement(String productName) {
        return new Element(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
    }
    
    // Access Add to cart button b product name
    private Element getAddToCartButton(String productName) {
        return new Element(By.xpath("//div[text()='" + productName + "']/following::button[contains(@id, 'add-to-cart')][1]"));
    }

    // Access Remove button by product name
    private Element getRemoveButton(String productName) {
        return new Element(By.xpath("//div[text()='" + productName + "']/following::button[contains(@id, 'remove')][1]"));
    }

    // Verify if product title is displayed
    public boolean productTitleIsDisplayed() {
        ExplicitWait.visibilityOfElementLocated(productTitle.getLocator(), 5);
        return productTitle.isDisplayed();
    }

    // Select a product dynamically by name
    public void selectProduct(String productName) {
        Element productElement = getProductElement(productName);
        ExplicitWait.visibilityOfElementLocated(productElement.getLocator(), 5);
        productElement.click();
    }

    // Add product to cart
    public void addProductToCart(String productName) {
        Element addToCartButton = getAddToCartButton(productName);
        ExplicitWait.elementToBeClickable(addToCartButton.getLocator(), 5);
        addToCartButton.click();
    }

    // Remove product from cart
    public void removeProductFromCart(String productName) {
        Element removeButton = getRemoveButton(productName);
        ExplicitWait.elementToBeClickable(removeButton.getLocator(), 5);
        removeButton.click();
    }

    // Verify if product is in cart
    public boolean isProductInCart(String productName) {
        Element cartItem = getProductElement(productName);
        ExplicitWait.visibilityOfElementLocated(cartItem.getLocator(), 5);
        return cartItem.isDisplayed();
    }
    
    // Click on cart icon
	public void clickOnCartIcon() {
		ExplicitWait.elementToBeClickable(cartIcon.getLocator(), 5);
		cartIcon.click();
	}
	
	// Get cart badge text
	public int getCartBadgeText() {
	    try {
	        
	        if (cartBadge.isDisplayed()) {
	            return Integer.parseInt(cartBadge.getText());
	        } else {
	            return 0; // Return 0 if badge is not displayed
	        }
	    } catch (NoSuchElementException e) {
	        return 0; 
	    }
	}
	

    
}
