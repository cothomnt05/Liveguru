package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.ProductPageUI;
import pageUIs.ReviewPageUI;

public class ReviewPageObject extends BasePage {
	private WebDriver driver;

	public ReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getSucessMessage() {
		return getTextElement(ProductPageUI.SUCCESS_MESSAGE);
	}

	public void review(String ratingValue, String review, String summary, String nickname) {
		if (!ratingValue.equals("")) {
			chooseRatingValue(ratingValue);
		}

		if (!review.equals("")) {
			inputToReviewTextbox(review);
		}

		if (!summary.equals("")) {
			inputToSummaryTextbox(summary);
		}

		if (!nickname.equals("")) {
			inputToNicknameTextbox(nickname);
		}

		clickToSubmitReviewButton();
	}

	public void chooseRatingValue(String ratingValue) {
		clickToElement(ReviewPageUI.RATINGS_BY_VALUE(ratingValue));
	}

	public void inputToReviewTextbox(String review) {
		sendkeyToElement(ReviewPageUI.THROUGHT_TEXTBOX, review);
	}

	public void inputToSummaryTextbox(String summary) {
		sendkeyToElement(ReviewPageUI.SUMMARY_TEXTBOX, summary);
	}

	public void inputToNicknameTextbox(String nickname) {
		sendkeyToElement(ReviewPageUI.NICKNAME_TEXTBOX, nickname);
	}

	public void clickToSubmitReviewButton() {
		clickToElement(ReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public String getValidateRatingField() {
		return getTextElement(ReviewPageUI.VALIDATE_RATING);
	}

	public String getValidateReviewField() {
		return getTextElement(ReviewPageUI.VALIDATE_REVIEW);
	}

	public String getValidateSummaryField() {
		return getTextElement(ReviewPageUI.VALIDATE_SUMMARY);
	}

	public String getValidateNicknameField() {
		return getTextElement(ReviewPageUI.VALIDATE_NICKNAME);
	}

	public String getSuccessMessage() {
		return getTextElement(ReviewPageUI.SUCCESS_MESSAGE);
	}

}
