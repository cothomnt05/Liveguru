package com.LiveGuru;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.ComparePageObject;
import pageObjects.HomePageObject;
import pageObjects.ProductPageObject;
import pageObjects.PurchasePageObject;

public class Product extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	ProductPageObject productPage;
	ComparePageObject comparePage;
	PurchasePageObject purchasePage;
	String productName, discountCodes, productNameCompare;

	@Parameters("browserName")
	@BeforeMethod
	public void before(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);

		productName = "Sony Xperia";
		discountCodes = "GURU50";
		productNameCompare = "IPhone";

	}

	@Test
	public void TC_04_Verify_that_cost_of_product_in_list_page_and_detail_page_are_equal() {
		productPage = homePage.clickToMobileTab();
		String costInListPage = productPage.getCostOfProductInListPage(productName);

		productPage.chooseProductByName(productName);
		String costInDetailsPage = productPage.getCostOfProductInDetailsPage();
		Assert.assertEquals(costInListPage, costInDetailsPage);

	}

	@Test
	public void TC_05_Verify_discount_coupon_works_correctly() {
		productPage = homePage.clickToMobileTab();
		purchasePage = productPage.addToCart(productName);
		Assert.assertEquals(purchasePage.getSuccessMessage(), productName + " was added to your shopping cart.");

		purchasePage.inputCouponCodes(discountCodes);
		double expectedTotalCost = purchasePage.calculateCostAfterDiscount();

		Assert.assertEquals(purchasePage.getGrandTotal(), expectedTotalCost);
	}

	@Test
	public void TC_06_Verify_that_you_can_not_add_more_500_items_of_product() {
		productPage = homePage.clickToMobileTab();
		purchasePage = productPage.addToCart(productName);

		purchasePage.updateQuantity("501");
		Assert.assertEquals(purchasePage.getErrorMessage(),
				"Some of the products cannot be ordered in requested quantity.");
		Assert.assertTrue(purchasePage.isItemMessageErrorMaximumQuantity());

		purchasePage.clearCart();
		Assert.assertEquals(purchasePage.getPageTitle(), "SHOPPING CART IS EMPTY");
		Assert.assertTrue(purchasePage.isNoItemsMessageDisplayed());

	}

	@Test
	public void TC_07_Verify_that_you_are_able_to_compare_two_products() {
		productPage = homePage.clickToMobileTab();
		productPage.addToCompare(productName);
		Assert.assertEquals(productPage.getSucessMessage(),
				"The product " + productName + " has been added to comparison list.");
		productPage.addToCompare(productNameCompare);
		Assert.assertEquals(productPage.getSucessMessage(),
				"The product " + productNameCompare + " has been added to comparison list.");

		comparePage = productPage.openCompareWindown();
		Assert.assertEquals(comparePage.getTitlePage(), "COMPARE PRODUCTS");
		Assert.assertTrue(comparePage.isProductDisplayedAtComparePageByName(productName));
		Assert.assertTrue(comparePage.isProductDisplayedAtComparePageByName(productNameCompare));

		productPage = comparePage.closeWindow();
		Assert.assertEquals(productPage.getPageTitle(), "MOBILE");

	}

	@AfterMethod
	public void after() {
		driver.close();
		driver.quit();
	}

}
