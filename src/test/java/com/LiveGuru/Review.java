package com.LiveGuru;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.ProductPageObject;
import pageObjects.ReviewPageObject;

public class Review extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	ProductPageObject productPage;
	ReviewPageObject reviewPage;
	String tvProduct, ratingvalue, review, summary, nickname;

	@Parameters("browserName")
	@BeforeMethod
	public void before(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);

		tvProduct = "Samsung LCD";
		ratingvalue = "4";
		review = "Good";
		summary = "test";
		nickname = "Automation";

	}

	@Test
	public void TC_09_Verify_you_can_Add_your_Review() {
		productPage = homePage.clickToTVTab();
		productPage.chooseProductByName(tvProduct);
		reviewPage = productPage.clickToAddToReviewLink();
		reviewPage.review("", "", "", "");
		Assert.assertEquals(reviewPage.getValidateRatingField(), "Please select one of each of the ratings above");
		Assert.assertEquals(reviewPage.getValidateReviewField(), "THIS IS A REQUIRED FIELD.");
		Assert.assertEquals(reviewPage.getValidateSummaryField(), "THIS IS A REQUIRED FIELD.");
		Assert.assertEquals(reviewPage.getValidateNicknameField(), "THIS IS A REQUIRED FIELD.");

		reviewPage.review(ratingvalue, review, summary, nickname);
		Assert.assertEquals(reviewPage.getSuccessMessage(), "Your review has been accepted for moderation.");
	}

	@AfterMethod
	public void after() {
		driver.close();
		driver.quit();
	}

}
