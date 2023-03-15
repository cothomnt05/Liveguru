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
import pageObjects.RegisterPageObject;
import pageObjects.WishlistPageObject;
import testData.Register_Data;

public class Wishlist extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	ProductPageObject productPage;
	WishlistPageObject wishlistPage;
	RegisterPageObject registerPage;
	String firstName, lastName, emailAddress, password, confirmPassword;
	String tvProduct, emailWishlist, messageWishlist;

	@Parameters("browserName")
	@BeforeMethod
	public void before(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);

		tvProduct = "LG LCD";
		emailWishlist = "test@gmail.com";
		messageWishlist = "test wishlist";

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
	public void TC_08_Verify_you_can_share_wishlist_to_other_people_using_email() {
		productPage = homePage.clickToTVTab();
		wishlistPage = productPage.addToWishlist(tvProduct);

		Assert.assertEquals(wishlistPage.getSucessMessage(),
				tvProduct + " has been added to your wishlist. Click here to continue shopping.");

		wishlistPage.openShareWishlistForm();
		wishlistPage.shareWishlist(emailWishlist, messageWishlist);

		Assert.assertEquals(wishlistPage.getSucessMessage(), "Your Wishlist has been shared.");
		wishlistPage.openMyWishlistPage();

		Assert.assertTrue(wishlistPage.isProductNameDisplayedAtWishlistPage(tvProduct));
	}

	@AfterMethod
	public void after() {
		driver.close();
		driver.quit();
	}

}
