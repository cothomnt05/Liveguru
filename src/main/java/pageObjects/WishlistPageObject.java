package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.BasePageUI;
import pageUIs.WishlistPageUI;

public class WishlistPageObject extends BasePage {
	private WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getSucessMessage() {
		return getTextElement(WishlistPageUI.SUCCESS_MESSAGE);
	}

	public void openShareWishlistForm() {
		clickToShareWishlistButton();

	}

	public void clickToShareWishlistButton() {
		clickToElement(WishlistPageUI.SHARE_WISHLIST_BUTTON);
	}

	public void shareWishlist(String emailWishlist, String messageWishlist) {
		inputToEmailTextbox(emailWishlist);
		inputToMessageTextbox(messageWishlist);
		clickToShareWishlistButton();

	}

	public void inputToEmailTextbox(String emailWishlist) {
		sendkeyToElement(WishlistPageUI.EMAIL_TEXTBOX, emailWishlist);
	}

	public void inputToMessageTextbox(String messageWishlist) {
		sendkeyToElement(WishlistPageUI.MESSAGE_TEXTBOX, messageWishlist);
	}

	public void openMyWishlistPage() {
		clickToAccountDropdown();
		clickToMyWishlistLink();

	}

	public void clickToMyWishlistLink() {
		clickToElement(BasePageUI.MY_WISHLISH_LINK);
	}

	public boolean isProductNameDisplayedAtWishlistPage(String wishlistName) {
		return isElementDisplayed(WishlistPageUI.WISHLIST_ITEM_BY_NAME(wishlistName));
	}

	public PurchasePageObject clickToAddToCartButton() {
		clickToElement(WishlistPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getPurchasePageObject(driver);
	}
}
