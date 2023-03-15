package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.CompareProductUI;

public class ComparePageObject extends BasePage {
	private WebDriver driver;

	public ComparePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTitlePage() {
		return getTextElement(CompareProductUI.PAGE_TITLE);
	}

	public boolean isProductDisplayedAtComparePageByName(String productName) {
		return isElementDisplayed(CompareProductUI.PRODUCT_NAME(productName));
	}

	public ProductPageObject closeWindow() {
		clickToElement(CompareProductUI.CLOSE_WINDOW_BUTTON);
		switchToWindowByTitle("Mobile");
		return PageGeneratorManager.getProductPageObject(driver);
	}
}
