package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.Browser;

// Element class to define the methods for the elements
public class Element extends BaseElement {

	private final By locator;

	public Element(By locator) {
		super(locator);
		this.locator = locator;

	}

	public WebElement getElement() {
		return Browser.getDriver().findElement(locator);
	}

	public By getLocator() {
		return locator;
	}
}
