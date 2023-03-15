package pageUIs;

public class ProductPageUI {
	public static String PRODUCT_NAME(String productName) {
		return "//h2[@class= 'product-name']/a[text() = '" + productName + "']";
	}

	public static String PRODUCT_PRICE_BY_NAME(String productName) {
		return "//h2[@class= 'product-name']/a[text() = '" + productName
				+ "']//parent::h2/following-sibling::div//span[@class='price']";
	}

	public static String PRODUCT_PRICE_IN_DETAILS_PAGE = "//div[@class = 'product-shop']//span[@class = 'price']";

	public static String ADD_TO_CART_BY_NAME(String productName) {
		return "//a[text() = '" + productName
				+ "']/parent::h2[@class= 'product-name']//following-sibling::div[@class = 'actions']/button";
	}

	public static String ADD_TO_COMPARE_BY_NAME(String productName) {
		return "//h2[@class = 'product-name']/a[text() = '" + productName
				+ "']/parent::h2//following-sibling::div[@class = 'actions']//a[text() = 'Add to Compare']";
	}

	public static String ADD_TO_WISHLIST_BY_NAME(String productName) {
		return "//h2[@class = 'product-name']/a[text() = '" + productName
				+ "']/parent::h2//following-sibling::div[@class = 'actions']//a[text() = 'Add to Wishlist']";
	}
	
	public static String PAGE_TITLE = "//div[contains(@class , 'page-title')]/h1";

	public static String COMPARE_BUTTON = "//button[@title = 'Compare']";

	public static String SUCCESS_MESSAGE = "//li[@class = 'success-msg']//span";

	public static String ADD_YOUR_REVIEW_LINK = "//a[text() = 'Add Your Review']";

}
