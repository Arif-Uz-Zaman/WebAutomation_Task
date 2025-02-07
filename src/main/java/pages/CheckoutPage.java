package pages;

import org.json.JSONObject;
import org.openqa.selenium.By;

import elements.Element;
import waits.ExplicitWait;

public class CheckoutPage {
	
	private final Element checkoutYourInformationPageTitle = new Element(By.xpath("//span[@class='title' and contains(text(),'Checkout: Your Information')]"));
	private final Element checkoutOverviewPageTitle = new Element(By.xpath("//span[@class='title' and contains(text(),'Checkout: Overview')]"));
	private final Element firstName = new Element(By.id("first-name"));
	private final Element lastName = new Element(By.id("last-name"));
	private final Element postalCode = new Element(By.id("postal-code"));
	private final Element continueButton = new Element(By.id("continue"));
	private final Element cancelButton = new Element(By.id("cancel"));
	private final Element finishButton = new Element(By.id("finish"));
	private final Element sucessMessage = new Element(By.xpath("//h2[@class='complete-header' and text()='Thank you for your order!']"));
	
	
	
	public boolean checkoutYourInformationPageTitleIsDisplayed() {
		return checkoutYourInformationPageTitle.isDisplayed();
	}
	
	public boolean checkoutOverviewPageTitleIsDisplayed() {
		return checkoutOverviewPageTitle.isDisplayed();
	}
	
	public void enterFirstName(String name) {
		ExplicitWait.elementToBeClickable(firstName.getLocator(), 5);
		firstName.getElement().sendKeys(name);
	}
	
	public void enterLastName(String name) {
		ExplicitWait.elementToBeClickable(lastName.getLocator(), 5);
		lastName.getElement().sendKeys(name);
	}
	
	public void enterPostalCode(String code) {
		ExplicitWait.elementToBeClickable(postalCode.getLocator(), 5);
		postalCode.getElement().sendKeys(code);
	}
	
	public void clickOnContinueButton() {
		ExplicitWait.elementToBeClickable(continueButton.getLocator(), 5);
		continueButton.click();
	}
	
	public void clickOnCancelButton() {
		ExplicitWait.elementToBeClickable(cancelButton.getLocator(), 5);
		cancelButton.click();
	}
	
	public void clickOnFinishButton() {
		ExplicitWait.elementToBeClickable(finishButton.getLocator(), 5);
		finishButton.click();
	}
	
	public boolean isSucessMessageIsDisplayed() {
		ExplicitWait.visibilityOfElementLocated(sucessMessage.getLocator(), 5);
		return sucessMessage.isDisplayed();
	}

	public void enterShippingInformation(JSONObject shippingInfo) {
	    String firstName = shippingInfo.getString("firstName");
	    String lastName = shippingInfo.getString("lastName");
	    String postalCode = shippingInfo.getString("postalCode");

	    enterFirstName(firstName);
	    enterLastName(lastName);
	    enterPostalCode(postalCode);
	}
	

	
	
	
	

}
