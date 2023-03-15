package com.LiveGuru;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Object.Product;
import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.SearchPageObject;

public class Search extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	SearchPageObject searchPage;
	List<Product> listItem1;
	List<Product> listItem2;

	@Parameters("browserName")
	@BeforeMethod
	public void before(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		listItem1 = new ArrayList<Product>();
		listItem2 = new ArrayList<Product>();

	}

	@Test
	public void TC_11_Verify_search_functionality() {
		searchPage = homePage.clickToAdvanceSearchLink();
		searchPage.searchByPrice("0", "150");
		listItem1 = searchPage.getListItemSearch();

		searchPage.backToPage();

		searchPage.searchByPrice("151", "1000");
		listItem2 = searchPage.getListItemSearch();

	}

	@AfterMethod
	public void after() {
		driver.close();
		driver.quit();
	}

}
