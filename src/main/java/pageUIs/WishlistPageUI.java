package pageUIs;

public class WishlistPageUI {
	public static String SUCCESS_MESSAGE = "//li[@class = 'success-msg']//span";
	public static String SHARE_WISHLIST_BUTTON = "//button[@title = 'Share Wishlist']";
	public static String EMAIL_TEXTBOX = "//textarea[@id = 'email_address']";
	public static String MESSAGE_TEXTBOX = "//textarea[@id = 'message']";

	public static String WISHLIST_ITEM_BY_NAME(String productName) {
		return "//td[contains(@class , 'customer-wishlist-item-info')]/h3[@class = 'product-name']/a[text() = '"
				+ productName + "']";
	}
	
	public static String ADD_TO_CART_BUTTON = "//form[@id = 'wishlist-view-form']//button[@title = 'Add to Cart']";
}
