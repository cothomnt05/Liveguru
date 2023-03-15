package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.LogInPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public HomePageObject login(String emailAddress, String password) {
		inputToEmailAddress(emailAddress);
		inputToPassword(password);
		clickToLoginButton();
		
		return PageGeneratorManager.getHomePageObject(driver);
	}
	
	public void inputToEmailAddress(String emailAddress) {
		sendkeyToElement(LogInPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	
	public void inputToPassword(String password) {
		sendkeyToElement(LogInPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void clickToLoginButton() {
		clickToElement(LogInPageUI.LOGIN_BUTTON);
	}


}
