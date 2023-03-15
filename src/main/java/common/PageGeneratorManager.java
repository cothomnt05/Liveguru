package common;

import org.openqa.selenium.WebDriver;

import pageObjects.ComparePageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.ProductPageObject;
import pageObjects.PurchasePageObject;
import pageObjects.RegisterPageObject;
import pageObjects.ReviewPageObject;
import pageObjects.SearchPageObject;
import pageObjects.WishlistPageObject;

public class PageGeneratorManager {

	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static MyAccountPageObject getMyAccountPageObject(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}

	public static LoginPageObject getLogInPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static ProductPageObject getProductPageObject(WebDriver driver) {
		return new ProductPageObject(driver);
	}

	public static ComparePageObject getComparePageObject(WebDriver driver) {
		return new ComparePageObject(driver);
	}

	public static WishlistPageObject getWishlistPageObject(WebDriver driver) {
		return new WishlistPageObject(driver);
	}

	public static ReviewPageObject getReviewPageObject(WebDriver driver) {
		return new ReviewPageObject(driver);
	}

	public static PurchasePageObject getPurchasePageObject(WebDriver driver) {
		return new PurchasePageObject(driver);
	}

	public static SearchPageObject getSearchPageObject(WebDriver driver) {
		return new SearchPageObject(driver);
	}

}
