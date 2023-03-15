package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.ProductPageUI;

public class ProductPageObject extends BasePage {
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getCostOfProductInListPage(String productName) {
		return getTextElement(ProductPageUI.PRODUCT_PRICE_BY_NAME(productName));
	}

	public void chooseProductByName(String productName) {
		clickToElement(ProductPageUI.PRODUCT_NAME(productName));
	}

	public String getCostOfProductInDetailsPage() {
		return getTextElement(ProductPageUI.PRODUCT_PRICE_IN_DETAILS_PAGE);
	}
	
	public PurchasePageObject addToCart(String productName) {
		clickToElement(ProductPageUI.ADD_TO_CART_BY_NAME(productName));
		return PageGeneratorManager.getPurchasePageObject(driver);
	}
	
	public void addToCompare(String productName) {
		clickToElement(ProductPageUI.ADD_TO_COMPARE_BY_NAME(productName));
	}

	public ComparePageObject openCompareWindown() {
		clickToElement(ProductPageUI.COMPARE_BUTTON);
		switchToWindowByTitle("Products Comparison List - Magento Commerce");
		return PageGeneratorManager.getComparePageObject(driver);
	}

	public String getSucessMessage() {
		return getTextElement(ProductPageUI.SUCCESS_MESSAGE);
	}

	public WishlistPageObject addToWishlist(String tvProduct) {
		clickToElement(ProductPageUI.ADD_TO_WISHLIST_BY_NAME(tvProduct));
		return PageGeneratorManager.getWishlistPageObject(driver);
	}

	public ReviewPageObject clickToAddToReviewLink() {
		clickToElement(ProductPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getReviewPageObject(driver);
	}

	public String getPageTitle() {
		return getTextElement(ProductPageUI.PAGE_TITLE);
	}

}
