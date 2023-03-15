package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.ProductPageUI;
import pageUIs.PurchasePageUI;

public class PurchasePageObject extends BasePage {
	private WebDriver driver;

	public PurchasePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputCouponCodes(String discountCodes) {
		inputDiscount(discountCodes);
		clickToApplyButton();
	}

	public void inputDiscount(String discountCodes) {
		sendkeyToElement(PurchasePageUI.DISCOUNT_CODES_TEXTBOX, discountCodes);
	}

	public void clickToApplyButton() {
		clickToElement(PurchasePageUI.APPLY_BUTTON);
	}

	public double calculateCostAfterDiscount() {
		return getSubtotal() - getDiscount();
	}

	public double getDiscount() {
		String discountText = getTextElement(PurchasePageUI.DISCOUNT_VALUE);
		double discountInt = Integer.parseInt(discountText.replace("-$", "").replace(".", "")) / 100;
		return discountInt;
	}

	public double getSubtotal() {
		String subtotal = getTextElement(PurchasePageUI.SUBTOTAL_COST);
		double subtotalInt = Integer.parseInt(subtotal.replace("$", "").replace(".", "")) / 100;
		return subtotalInt;
	}

	public double getGrandTotal() {
		String grandTotal = getTextElement(PurchasePageUI.GRAND_TOTAL);
		double grandTotalInt = Integer.parseInt(grandTotal.replace("$", "").replace(".", "")) / 100;
		return grandTotalInt;
	}

	public void updateQuantity(String quantityValue) {
		inputToQuantityTextbox(quantityValue);
		clickToUpdateQuantity();
	}

	public void inputToQuantityTextbox(String quantityValue) {
		sendkeyToElement(PurchasePageUI.QTY_TEXTBOX, quantityValue);
	}

	public void clickToUpdateQuantity() {
		clickToElement(PurchasePageUI.UPDATE_QTY_BUTTON);
	}

	public String getErrorMessage() {
		return getTextElement(PurchasePageUI.ERROR_MESSAGE);
	}

	public void clearCart() {
		clickToElement(PurchasePageUI.EMPTY_CART_BUTTON);
	}

	public String getPageTitle() {
		return getTextElement(ProductPageUI.PAGE_TITLE);
	}

	public boolean isNoItemsMessageDisplayed() {
		return isElementDisplayed(PurchasePageUI.NO_ITEMS_IN_CART_MESSAGE);
	}

	public boolean isItemMessageErrorMaximumQuantity() {
		return isElementDisplayed(PurchasePageUI.ITEM_MESSAGE_ERROR_MAXIMUM_QUANTITY);
	}

	public String getSuccessMessage() {
		return getTextElement(PurchasePageUI.SUCCESS_MESSAGE);
	}

	public void estimateShippingAndTax(String country, String state, String zip) {
		chooseCountryAtDropdown(country);
		chooseStateAtDropdown(state);
		inputToZipTextbox(zip);
		clickToEstimateButton();
	}

	public void chooseCountryAtDropdown(String country) {
		selectItemInDefaultDropdown(PurchasePageUI.COUNTRY_DROPDOWN, country);
	}

	public void chooseStateAtDropdown(String state) {
		selectItemInDefaultDropdown(PurchasePageUI.STATE_DROPDOWN, state);
	}

	public void inputToZipTextbox(String zip) {
		sendkeyToElement(PurchasePageUI.ZIP_TEXTBOX, zip);
	}

	public void clickToEstimateButton() {
		clickToElement(PurchasePageUI.ESTIMATE_BUTTON);
	}

	public void updateTotal() {
		clickToFlatRateRadio();
		clickToUpdateTotalButton();
	}

	public void clickToFlatRateRadio() {
		clickToElement(PurchasePageUI.SHIPPING_AND_TAX_RADIO);
	}

	public void clickToUpdateTotalButton() {
		clickToElement(PurchasePageUI.UPDATE_TOTAL_BUTTON);
	}

	public double calculateTotalContainsShippingAndTax() {
		return getSubtotal() + getShippingAndTaxCost();
	}

	public double getShippingAndTaxCost() {
		String shippingAndTax = getTextElement(PurchasePageUI.SHIPPING_AND_TAX_COST);
		double shippingAndTaxCost = Integer.parseInt(shippingAndTax.replace("$", "").replace(".", "")) / 100;

		return shippingAndTaxCost;
	}

	public void proceedToCheckoutButton() {
		clickToElement(PurchasePageUI.PROCEED_TO_CHECKOUT_BUTTON);
	}

	public void enterToBillingInformation(String address, String city, String state, String zip, String country,
			String telephone) {
		inputToAddressTextbox(address);
		inputToCityTextbox(city);
		chooseStateAtDropdownInBilling(state);
		inputToZipTextboxInBilling(zip);
		chooseCountryAtDropdownInBilling(country);
		inputToTelephoneTextbox(telephone);
		clickToContinueInBilling();
	}

	public void inputToAddressTextbox(String address) {
		sendkeyToElement(PurchasePageUI.ADDRESS_TEXTBOX, address);
	}

	public void inputToCityTextbox(String city) {
		sendkeyToElement(PurchasePageUI.CITY_TEXTBOX, city);
	}

	public void chooseStateAtDropdownInBilling(String state) {
		selectItemInDefaultDropdown(PurchasePageUI.STATE_DROPDOWN_IN_BILLING, state);
	}

	public void inputToZipTextboxInBilling(String zip) {
		sendkeyToElement(PurchasePageUI.ZIP_TEXTBOX_IN_BILLING, zip);
	}

	public void chooseCountryAtDropdownInBilling(String country) {
		selectItemInDefaultDropdown(PurchasePageUI.COUNTRY_DROPDOWN_IN_BILLING, country);
	}

	public void inputToTelephoneTextbox(String telephone) {
		sendkeyToElement(PurchasePageUI.TELEPHONE_TEXTBOX, telephone);
	}

	public void clickToContinueInBilling() {
		clickToElement(PurchasePageUI.CONTINUE_BILLING_INFORMATION);
	}

	public void continueShippingMethod() {
		clickToElement(PurchasePageUI.CONTINUE_SHIPPING_METHOD);
	}

	public void selectPaymentInformation(String methodPayment) {
		clickToElement(PurchasePageUI.PAYMENT_INFORMATION_BY_METHOD_NAME(methodPayment));
		clickToElement(PurchasePageUI.CONTINUE_PAYMENT_INFORMATION);
	}

	public void placeOrder() {
		clickToElement(PurchasePageUI.PLACE_ORDER_BUTTON);
		sleepInSecond(3);
	}

	public boolean isNumberOrderDisplayed() {
		return isElementDisplayed(PurchasePageUI.NUMBER_ORDER);
	}

}
