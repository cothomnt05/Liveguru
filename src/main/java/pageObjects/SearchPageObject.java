package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Object.Product;
import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.LogInPageUI;
import pageUIs.SearchPageUI;

public class SearchPageObject extends BasePage {
	private WebDriver driver;

	public SearchPageObject(WebDriver driver) {
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

	public void searchByPrice(String priceFrom, String priceTo) {
		sendkeyToElement(SearchPageUI.PRICE_FROM_TEXTBOX, priceFrom);
		sendkeyToElement(SearchPageUI.PRICE_TO_TEXTBOX, priceTo);
		clickToElement(SearchPageUI.SEARCH_BUTTON);

	}

	public List<Product> getListItemSearch() {
		List<Product> products = new ArrayList<Product>();
		List<WebElement> proNames = getWebElements(SearchPageUI.PRODUCT_NAME);
		List<WebElement> proPrices = getWebElements(SearchPageUI.PRICE);
		for (int i = 0; i < proNames.size(); i++) {
			String name = proNames.get(i).getText();
			double price = Integer.parseInt(proPrices.get(i).getText().trim().replace("$", "").replace(".", "")) / 100;
			Product pro = new Product(name, price);
			products.add(pro);
		}

		for (int i = 0; i < proNames.size(); i++) {
			System.out.println(products.get(i).getName() + " " + products.get(i).getPrice());
		}
		
		System.out.println("----------------------------------");

		return products;

	}

}
