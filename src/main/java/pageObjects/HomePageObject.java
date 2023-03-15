package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.BasePageUI;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public RegisterPageObject openRegisterPage() {
		clickToAccountDropdown();
		clickToRegisterLink();

		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public void clickToRegisterLink() {
		clickToElement(BasePageUI.REGISTER_LINK);
	}

	public boolean isRegisterSuccessful() {
		return isElementDisplayed(HomePageUI.REGISTER_SUCCESSFULLY_MESSAGE);
	}

	public LoginPageObject openLogInPage() {
		clickToAccountDropdown();
		clickToLoginLink();

		return PageGeneratorManager.getLogInPageObject(driver);
	}

	public void clickToLoginLink() {
		clickToElement(BasePageUI.LOGIN_LINK);
	}

	public boolean isLoginSucessful() {
		return isElementDisplayed(HomePageUI.LOGIN_SUCCESSFULLY);
	}

	public ProductPageObject clickToMobileTab() {
		clickToElement(HomePageUI.MOBILE_TAB);
		return PageGeneratorManager.getProductPageObject(driver);
	}

	public String getWelcomeMessage() {
		return getTextElement(HomePageUI.WELCOME_MESSAGE);
	}

	public ProductPageObject clickToTVTab() {
		clickToElement(HomePageUI.TV_TAB);
		return PageGeneratorManager.getProductPageObject(driver);
	}

	public SearchPageObject clickToAdvanceSearchLink() {
		clickToElement(BasePageUI.ADVANCE_SEARCH_LINK);
		return PageGeneratorManager.getSearchPageObject(driver);
	}

}
