package pages;

import org.openqa.selenium.By;

import elements.Element;
import waits.ExplicitWait;

public class LoginPage {
	
	private final Element usernameField = new Element(By.id("user-name"));
	private final Element passwordField = new Element(By.id("password"));
	private final Element loginButton = new Element(By.id("login-button"));
	private final Element errorMessage = new Element(By.xpath("//h3[@data-test='error' and contains(text(),'Username and password do not match')]"));
	
	
	public void enterUsername(String username) {
		ExplicitWait.elementToBeClickable(usernameField.getLocator(), 5);
		usernameField.getElement().sendKeys(username);
	}
	
	public void enterPassword(String password) {
		ExplicitWait.elementToBeClickable(passwordField.getLocator(), 5);
		passwordField.getElement().sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		ExplicitWait.elementToBeClickable(loginButton.getLocator(), 5);
		loginButton.click();
	}
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickOnLoginButton();
	}
	
	public boolean errorMessageIsDisplayed() {
		ExplicitWait.visibilityOfElementLocated(errorMessage.getLocator(), 5);
		return errorMessage.isDisplayed();
	}

}
