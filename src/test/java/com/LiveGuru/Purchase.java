package com.LiveGuru;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.OtherFunction;
import common.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.ProductPageObject;
import pageObjects.PurchasePageObject;
import pageObjects.RegisterPageObject;
import pageObjects.WishlistPageObject;
import testData.Register_Data;

public class Purchase extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	ProductPageObject productPage;
	WishlistPageObject wishlistPage;
	RegisterPageObject registerPage;
	PurchasePageObject purchasePage;
	String firstName, lastName, emailAddress, password, confirmPassword;
	String tvProduct, country, state, zip, address, city, telephone, methodPayment;

	@Parameters("browserName")
	@BeforeMethod
	public void before(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);

		tvProduct = "LG LCD";
		country = "United States";
		state = "New York";
		zip = "543432";
		address = "ABC";
		city = "New York";
		telephone = "123123123";
		methodPayment = "Check / Money order ";

		firstName = Register_Data.FIRST_NAME;
		lastName = Register_Data.LAST_NAME;
		emailAddress = firstName + lastName + OtherFunction.randomNumber() + "@gmail.com";
		password = Register_Data.PASSWORD;
		confirmPassword = Register_Data.PASSWORD;

		// Register
		registerPage = homePage.openRegisterPage();
		homePage = registerPage.createAnAccount(firstName, lastName, emailAddress, password, confirmPassword);
		Assert.assertTrue(homePage.isRegisterSuccessful());
		Assert.assertEquals(homePage.getWelcomeMessage(), "Hello, " + firstName + " " + lastName + "!");

	}

	@Test
	public void TC_10_Verify_user_is_able_to_purchase_product() {
		productPage = homePage.clickToTVTab();
		wishlistPage = productPage.addToWishlist(tvProduct);

		purchasePage = wishlistPage.clickToAddToCartButton();
		Assert.assertEquals(purchasePage.getSuccessMessage(), "LG LCD was added to your shopping cart.");

		purchasePage.estimateShippingAndTax(country, state, zip);
		purchasePage.updateTotal();
		double expectedTotal = purchasePage.calculateTotalContainsShippingAndTax();
		Assert.assertEquals(purchasePage.getGrandTotal(), expectedTotal);

		purchasePage.proceedToCheckoutButton();
		purchasePage.enterToBillingInformation(address, city, state, zip, country, telephone);
		purchasePage.continueShippingMethod();
		purchasePage.selectPaymentInformation(methodPayment);
		purchasePage.placeOrder();

		Assert.assertEquals(purchasePage.getPageTitle(), "YOUR ORDER HAS BEEN RECEIVED.");
		Assert.assertTrue(purchasePage.isNumberOrderDisplayed());

	}

	@AfterMethod
	public void after() {
		driver.close();
		driver.quit();
	}

}
