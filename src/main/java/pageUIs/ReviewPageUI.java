package pageUIs;

public class ReviewPageUI {
	public static String RATINGS_BY_VALUE(String valueRatings) {
		return "//input[@name = 'ratings[1]' and @value = '" + valueRatings + "']";
	}

	public static String THROUGHT_TEXTBOX = "//textarea[@id = 'review_field']";
	public static String SUMMARY_TEXTBOX = "//input[@id = 'summary_field']";
	public static String NICKNAME_TEXTBOX = "//input[@id = 'nickname_field']";
	public static String SUBMIT_REVIEW_BUTTON = "//button[@title = 'Submit Review']";

	public static String VALIDATE_RATING = "//input[@name = 'validate_rating']//following-sibling::div";
	public static String VALIDATE_REVIEW = "//textarea[@id = 'review_field']//following-sibling::div";
	public static String VALIDATE_SUMMARY = "//input[@id = 'summary_field']//following-sibling::div";
	public static String VALIDATE_NICKNAME = "//input[@id = 'nickname_field']//following-sibling::div";

	public static String SUCCESS_MESSAGE = "//li[@class = 'success-msg']//span";
}
