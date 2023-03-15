package com.LiveGuru;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.OtherFunction;
import common.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.RegisterPageObject;
import testData.Register_Data;

public class Register extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	LoginPageObject loginPage;
	String firstName, lastName, emailAddress, password, confirmPassword;

	@Parameters("browserName")
	@BeforeClass
	public void before(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);

		firstName = Register_Data.FIRST_NAME;
		lastName = Register_Data.LAST_NAME;
		emailAddress = firstName + lastName + OtherFunction.randomNumber() + "@gmail.com";
		password = Register_Data.PASSWORD;
		confirmPassword = Register_Data.PASSWORD;
	}

	@Test
	public void TC_01_Register_success_to_system() {
		registerPage = homePage.openRegisterPage();
		homePage = registerPage.createAnAccount(firstName, lastName, emailAddress, password, confirmPassword);
		Assert.assertTrue(homePage.isRegisterSuccessful());
		Assert.assertEquals(homePage.getWelcomeMessage(), "Hello, " + firstName + " " + lastName + "!");
	}

	@Test
	public void TC_02_Verify_user_information_is_correct_after_registered_successfully() {
		myAccountPage = homePage.openMyAccountPage();
		myAccountPage.clickToAccountInformationTab();
		Assert.assertEquals(myAccountPage.getFirstName(), firstName);
		Assert.assertEquals(myAccountPage.getLastName(), lastName);
		Assert.assertEquals(myAccountPage.getEmailAddress(), emailAddress);

		homePage = myAccountPage.logout();
	}

	@Test
	public void TC_03_Login_Success_To_System() {
		loginPage = homePage.openLogInPage();
		homePage = loginPage.login(emailAddress, password);
		Assert.assertTrue(homePage.isLoginSucessful());
	}

	@AfterClass
	public void after() {
		driver.close();
		driver.quit();
	}

}
