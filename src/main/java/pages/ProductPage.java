package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import elements.Element;
import waits.ExplicitWait;

public class ProductPage {

    private final Element productTitle = new Element(By.xpath("//span[@class='title' and contains(text(),'Products')]"));
    private final Element cartIcon = new Element(By.xpath("//a[contains(@class, 'shopping_cart_link')]"));
    private final Element cartBadge = new Element(By.xpath("//span[@class='shopping_cart_badge']"));
    private final Element sortingDropdown = new Element(By.className("product_sort_container"));
    private final Element itemNames = new Element(By.className("inventory_item_name"));
    private final Element itemPrices = new Element(By.className("inventory_item_price"));
	private final Element menuButton = new Element(By.id("react-burger-menu-btn"));
	private final Element logoutButton = new Element(By.id("logout_sidebar_link"));


    // Access product element by name
    private Element getProductElement(String productName) {
        return new Element(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
    }
    
    // Access Add to cart button by product name
    private Element getAddToCartButton(String productName) {
        return new Element(By.xpath("//div[text()='" + productName + "']/following::button[contains(@id, 'add-to-cart')][1]"));
    }

    // Access Remove button by product name
    private Element getRemoveButton(String productName) {
        return new Element(By.xpath("//div[text()='" + productName + "']/following::button[contains(@id, 'remove')][1]"));
    }
    
    // Get product names from the product page
    private List<String> getProductNames() {
        List<WebElement> productElements = itemNames.getElements();
        List<String> productNames = new ArrayList<>();
        
        for (WebElement element : productElements) {
            productNames.add(element.getText());
        }

        return productNames;
    }

    // Get product prices from the product page
    private List<Double> getProductPrices() {
        List<WebElement> priceElements = itemPrices.getElements();
        List<Double> prices = new ArrayList<>();

        for (WebElement e : priceElements) {
            String priceText = e.getText().replace("$", "").trim();
            prices.add(Double.parseDouble(priceText));
        }

        return prices;
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
	
	// select sorting option from dropdown
    public void selectSortingOption(String sortingOption) {
        ExplicitWait.elementToBeClickable(sortingDropdown.getLocator(), 5);
        Select dropdown = new Select(sortingDropdown.getElement());
        dropdown.selectByVisibleText(sortingOption);
    }

    // Verify product sorting by name
    public boolean verifyProductSortingByName(String sortingOption) {
        selectSortingOption(sortingOption);
        List<String> productNamesAfterSorting = getProductNames();
        System.out.println(productNamesAfterSorting);
        List<String> sortedList = new ArrayList<>(productNamesAfterSorting);
        Collections.sort(sortedList);

        if (sortingOption.contains("(Z to A)")) {
            Collections.reverse(sortedList);
        }

        return productNamesAfterSorting.equals(sortedList);
    }

    // Verify product sorting by price
    public boolean verifyProductSortingByPrice(String sortingOption) {
        selectSortingOption(sortingOption);
        List<Double> productPricesAfterSorting = getProductPrices();
        System.out.println(productPricesAfterSorting);
        List<Double> sortedPrices = new ArrayList<>(productPricesAfterSorting);
        Collections.sort(sortedPrices);

        if (sortingOption.contains("(high to low)")) {
            Collections.reverse(sortedPrices);
        }

        return productPricesAfterSorting.equals(sortedPrices);
    }
    
    // Click on menu button
	public void clickOnMenuButton() {
		ExplicitWait.elementToBeClickable(menuButton.getLocator(), 5);
		menuButton.click();
	}
	
	// Click on logout button
	public void clickOnLogoutButton() {
		ExplicitWait.elementToBeClickable(logoutButton.getLocator(), 5);
		logoutButton.click();
	}
	
	

    
}
