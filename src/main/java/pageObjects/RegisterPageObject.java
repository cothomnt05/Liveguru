package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public HomePageObject createAnAccount(String firstName, String lastName, String emailAddress, String password,
			String confirmPassword) {
		inputToFirstNameTextbox(firstName);
		inputToLastNameTextbox(lastName);
		inputToEmailAddressTextbox(emailAddress);
		inputToPasswordTextbox(password);
		inputToConfirmPasswordTextbox(confirmPassword);
		clickToRegisterButton();
		
		return PageGeneratorManager.getHomePageObject(driver);
	}
	
	public void inputToFirstNameTextbox(String firstName) {
		sendkeyToElement(RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}
	
	public void inputToLastNameTextbox(String lastName) {
		sendkeyToElement(RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}
	
	public void inputToEmailAddressTextbox(String emailAddress) {
		sendkeyToElement(RegisterPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}
	
	public void inputToPasswordTextbox(String password) {
		sendkeyToElement(RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		sendkeyToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}
	
	public void clickToRegisterButton() {
		clickToElement(RegisterPageUI.REGISTER_BUTTON);
	}

}
