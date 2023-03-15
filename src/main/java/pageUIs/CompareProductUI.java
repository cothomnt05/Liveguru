package pageUIs;

public class CompareProductUI {
	public static String PRODUCT_NAME(String productName) {
		return "//h2[@class = 'product-name']/a[text() = '" + productName + "']";
	}

	public static String PAGE_TITLE = "//div[contains(@class,'page-title')]/h1";

	public static String CLOSE_WINDOW_BUTTON = "//button[@title = 'Close Window']";
}
