package pageUIs;

public class PurchasePageUI {
	public static String DISCOUNT_CODES_TEXTBOX = "//input[@id= 'coupon_code']";

	public static String APPLY_BUTTON = "//button[@value = 'Apply']";

	public static String COUPON_APPLY_SUCCESSFUL = "//span[text() = 'Coupon code \"GURU50\" was applied.']";

	public static String DISCOUNT_VALUE = "//table[@id = 'shopping-cart-totals-table']/tbody//td[contains(text(),'Discount')]/following-sibling::td/span";

	public static String GRAND_TOTAL = "//table[@id = 'shopping-cart-totals-table']//strong/span[@class = 'price']";

	public static String SUBTOTAL_COST = "//table[@id = 'shopping-cart-totals-table']/tbody//td[contains(text(),'Subtotal')]//following-sibling::td/span";

	public static String QTY_TEXTBOX = "//input[@title = 'Qty']";

	public static String UPDATE_QTY_BUTTON = "//td[@class = 'product-cart-actions']//button[contains(@class, 'btn-update')]";

	public static String ERROR_MESSAGE = "//li[@class = 'error-msg']//span";

	public static String ITEM_MESSAGE_ERROR_MAXIMUM_QUANTITY = "//p[@class = 'item-msg error' and contains(text(),'The maximum quantity allowed for purchase is 500.')]";

	public static String EMPTY_CART_BUTTON = "//button[@id = 'empty_cart_button']";

	public static String PAGE_TITLE = "//div[contains(@class , 'page-title')]/h1";

	public static String NO_ITEMS_IN_CART_MESSAGE = "//div[@class = 'cart-empty']/p[text() = 'You have no items in your shopping cart.']";

	public static String SUCCESS_MESSAGE = "//li[@class = 'success-msg']//span";

	public static String COUNTRY_DROPDOWN = "//li[@class = 'shipping-country']//select";

	public static String STATE_DROPDOWN = "//li[@class = 'shipping-region']//select";

	public static String ZIP_TEXTBOX = "//li[@class = 'shipping-postcode']//input";

	public static String ESTIMATE_BUTTON = "//button[@title = 'Estimate']";

	public static String SHIPPING_AND_TAX_RADIO = "//input[@name = 'estimate_method']";

	public static String SHIPPING_AND_TAX_COST = "//input[@name = 'estimate_method']//following-sibling::label/span";

	public static String UPDATE_TOTAL_BUTTON = "//button[@title = 'Update Total']";

	public static String PROCEED_TO_CHECKOUT_BUTTON = "//div[@class = 'cart-totals']//button[@title = 'Proceed to Checkout']";

	public static String ADDRESS_TEXTBOX = "//form[@id = 'co-billing-form']//input[@title = 'Street Address']";

	public static String CITY_TEXTBOX = "//form[@id = 'co-billing-form']//input[@title = 'City']";

	public static String ZIP_TEXTBOX_IN_BILLING = "//form[@id = 'co-billing-form']//input[@title = 'Zip']";

	public static String STATE_DROPDOWN_IN_BILLING = "//label[@for = 'billing:region_id']//following-sibling::div/select";

	public static String COUNTRY_DROPDOWN_IN_BILLING = "//label[@for = 'billing:country_id']//following-sibling::div/select";

	public static String TELEPHONE_TEXTBOX = "//form[@id = 'co-billing-form']//input[@title = 'Telephone']";

	public static String CONTINUE_BILLING_INFORMATION = "//form[@id= 'co-billing-form']//button[@title = 'Continue']";

	public static String CONTINUE_SHIPPING_METHOD = "//div[@id= 'shipping-method-buttons-container']//button";

	public static String PAYMENT_INFORMATION_BY_METHOD_NAME(String methodName) {
		return "//dl[@id = 'checkout-payment-method-load']//label[text() = '" + methodName + "']";
	}

	public static String CONTINUE_PAYMENT_INFORMATION = "//div[@id = 'payment-buttons-container']/button";
	
	public static String PLACE_ORDER_BUTTON = "//button[@title = 'Place Order']";
	
	public static String NUMBER_ORDER = "//p[text() = 'Your order # is: ']";

}
