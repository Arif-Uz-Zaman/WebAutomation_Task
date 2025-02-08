package pages;

import org.openqa.selenium.By;

import elements.Element;
import waits.ExplicitWait;

public class LoginPage {
	
	private final Element usernameField = new Element(By.id("user-name"));
	private final Element passwordField = new Element(By.id("password"));
	private final Element loginButton = new Element(By.id("login-button"));
	private final Element errorMessage = new Element(By.xpath("//h3[@data-test='error' and contains(text(),'Username and password do not match')]"));
	private final Element loginPageTitle = new Element(By.xpath("//div[@class='login_logo']"));
	private final Element lockedOutUserErrorMessage = new Element(By.xpath("//h3[@data-test='error' and contains(text(),'Sorry, this user has been locked out')]"));
	
	// check if the login page is displayed
	public boolean isLoginPageDisplayed() {
		ExplicitWait.visibilityOfElementLocated(loginPageTitle.getLocator(), 5);
		return loginPageTitle.isDisplayed();
	}

	// enter the username
	public void enterUsername(String username) {
		ExplicitWait.elementToBeClickable(usernameField.getLocator(), 5);
		usernameField.getElement().sendKeys(username);
	}
	
	// enter the password
	public void enterPassword(String password) {
		ExplicitWait.elementToBeClickable(passwordField.getLocator(), 5);
		passwordField.getElement().sendKeys(password);
	}
	
	// click on the login button
	public void clickOnLoginButton() {
		ExplicitWait.elementToBeClickable(loginButton.getLocator(), 5);
		loginButton.click();
	}
	
	// login with the username and password
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickOnLoginButton();
	}
	
	// check if the error message is displayed
	public boolean errorMessageIsDisplayed() {
		ExplicitWait.visibilityOfElementLocated(errorMessage.getLocator(), 5);
		return errorMessage.isDisplayed();
	}
	
	// check if the locked out user error message is displayed
	public boolean isLockedOutUserErrorMessageDisplayed() {
		ExplicitWait.visibilityOfElementLocated(lockedOutUserErrorMessage.getLocator(), 5);
		return lockedOutUserErrorMessage.isDisplayed();
	}

}
