package common;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePageObject;
import pageObjects.MyAccountPageObject;
import pageUIs.BasePageUI;

public class BasePage {
	private WebDriver driver;
	private long longTimeOut = 15;
	private long shortTimeOut = 10;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageUrl(String pageUrl) {
		this.driver.get(pageUrl);
	}

	public String getTitle() {
		return this.driver.getTitle();
	}

	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}

	public String getPageSource() {
		return this.driver.getPageSource();
	}

	public void backToPage() {
		this.driver.navigate().back();
	}

	public void forwardToPage() {
		this.driver.navigate().forward();
	}

	public void refreshCurrentPage() {
		this.driver.navigate().refresh();
	}

	public Alert waitAlertPresence() {
		WebDriverWait explicitWait = new WebDriverWait(this.driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		waitAlertPresence().accept();
	}

	public void cancelAlert() {
		waitAlertPresence().dismiss();
	}

	public String getTextAlert() {
		return waitAlertPresence().getText();
	}

	public void sendkeyToAlert(String value) {
		waitAlertPresence().sendKeys(value);
	}

	public void switchToWindowByID(String windowID) {
		Set<String> allWindowIDs = this.driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(windowID)) {
				this.driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToWindowByTitle(String tabTitle) {
		Set<String> allWindowIDs = this.driver.getWindowHandles();
		for (String id : allWindowIDs) {
			this.driver.switchTo().window(id);
			String actualTitle = this.driver.getTitle();
			if (actualTitle.equals(tabTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(String parentID) {
		Set<String> allWindowIDs = this.driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				this.driver.switchTo().window(id);
				this.driver.close();
			}
			this.driver.switchTo().window(parentID);
		}
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getWebElement(String locator) {
		return this.driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getWebElements(String locator) {
		return this.driver.findElements(getByXpath(locator));
	}

	public void clickToElement(String locator) {
		waitForElementVisible(locator).click();
	}

	public void sendkeyToElement(String locator, String value) {
		WebElement element = waitForElementVisible(locator);
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDefaultDropdown(String locator, String textItem) {
		Select select = new Select(waitForElementVisible(locator));
		select.selectByVisibleText(textItem);
	}

	public String getSelectedItemInDropdown(String locator) {
		Select select = new Select(waitForElementVisible(locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(String locator) {
		Select select = new Select(waitForElementVisible(locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		waitForElementVisible(parentLocator).click();
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	public String getAttributeValue(String locator, String attributeName) {
		return waitForElementVisible(locator).getAttribute(attributeName);
	}

	public String getTextElement(String locator) {
		return waitForElementVisible(locator).getText();
	}

	public String getCssValue(String locator, String propertyName) {
		return waitForElementVisible(locator).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementsSize(String locator) {
		return getWebElements(locator).size();
	}

	public void checkToDefaultCheckboxRadio(String locator) {
		WebElement element = waitForElementVisible(locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(String locator) {
		WebElement element = waitForElementVisible(locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(String locator) {
		try {
			return getWebElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void overrideGlobalTimeout(long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isElementUndisplayed(String locator) {
		overrideGlobalTimeout(shortTimeOut);
		List<WebElement> elements = getWebElements(locator);
		overrideGlobalTimeout(longTimeOut);

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementEnabled(String locator) {
		return waitForElementVisible(locator).isEnabled();
	}

	public boolean isElementSelected(String locator) {
		return waitForElementVisible(locator).isSelected();
	}

	public void switchToFrameIframe(String locator) {
		this.driver.switchTo().frame(waitForElementVisible(locator));
	}

	public void switchToDefaultContent() {
		this.driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(String locator) {
		Actions action = new Actions(this.driver);
		action.moveToElement(waitForElementVisible(locator)).perform();
	}

	public void pressKeyToElement(String locator, Keys key) {
		Actions action = new Actions(this.driver);
		action.sendKeys(waitForElementVisible(locator), key).perform();
	}

	public void scrollToBottomPage() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
		WebElement element = waitForElemenPresence(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(locator));
	}

	public void scrollToElement(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(locator));
	}

	public String getElementValidationMessage(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(locator));
	}

	public WebElement waitForElemenPresence(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(this.driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
	}

	public WebElement waitForElementVisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(this.driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForAllElementVisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(this.driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}

	public void waitForElementInVisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(this.driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForElementUndisplayed(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(this.driver, shortTimeOut);
		overrideGlobalTimeout(shortTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		overrideGlobalTimeout(longTimeOut);
	}

	public void waitForAllElementInVisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(this.driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElements(locator)));
	}

	public void waitForElementClickable(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(this.driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public HomePageObject logout() {
		clickToAccountDropdown();
		clickToLogOutLink();

		return PageGeneratorManager.getHomePageObject(driver);
	}

	public void clickToAccountDropdown() {
		clickToElement(BasePageUI.ACCOUNT_DROPDOWN);
	}

	public void clickToLogOutLink() {
		clickToElement(BasePageUI.LOGOUT_LINK);
	}

	public MyAccountPageObject openMyAccountPage() {
		clickToElement(BasePageUI.MY_ACCOUNT_LINK_AT_FOOTER);

		return PageGeneratorManager.getMyAccountPageObject(driver);
	}

}
