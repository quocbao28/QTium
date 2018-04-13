package Common;



public class Constants {

	//Variables for browser
	public static String FIREFOX_BROWSER = "Firefox";
	public static String IE_BROWSER = "IE";
	public static String CHROME_BROWSER = "Chrome";
	
	//Variable for url
	
	public static String SCRUM_BOARD_URL = "http://192.168.190.117:3333";	
	public static String CRM_URL = "http://crm.logigear.com/";
	public static String GOOGLE_URL = "http://www.google.com.vn/";
	public static String Username = "john";
	public static String Password ="tester";
	public static String YAHOO_URL ="http://login.yahoo.com";
	
	
	public static String TITLE_ERROR_IS_REQUIRED = "The Title field is required.";
	public static String DESCRIPTION_ERROR_IS_REQUIRED = "The Description field is required.";
	public static String ESTIMATE_ERROR_IS_REQUIRED = "The Estimate (Hour) field is required.";
	public static String SPENT_ERROR_IS_REQUIRED = "The Spent (Hour) field is required.";
	public static String ASSIGNEE_ERROR_IS_REQUIRED = "The Assignee field is required.";
	
	public static String TITLE_ERROR_IS_OUT_OF_RANGE = "Title must not be over 50 characters.";
	public static String DESCRIPTION_ERROR_IS_OUT_OF_RANGE = "Description must not be over 500 characters.";
	public static String ESTIMATE_ERROR_IS_OUT_OF_RANGE = "The field Estimate (Hour) must be between 0 and 48.";
	public static String SPENT_ERROR_IS_OUT_OF_RANGE = "The field Spent (Hour) must be between 0 and 48.";
	public static String ASSIGNEE_ERROR_IS_OUT_OF_RANGE = "The field Assignee must be a string or array type with a maximum length of '20'.";
	
	
	
	public static String ESTIMATE_ERROR_IS_INVALID = "The field Estimate (Hour) must be a number.";
	public static String SPENT_ERROR_IS_INVALID = "The field Spent (Hour) must be a number.";
	
	
	public static String USERNAME_ERROR_IS_REQUIRED = "The User Name field is required.";
	public static String PASSWORD_ERROR_IS_REQUIRED = "The Password field is required.";
	public static String LOGIN_ERROR = "Incorrect user name or password.";
	
	
	public static String REMEMBERME_LABEL = "Remember me"; 
	
	//---------- Test Data --------
	public static String STRING_GREATER_THAN_500_CHARACTERS = "In ABT keywords are called actions. Actions are the tasks that are executed in a test and function like building-blocks that can be combined in any order to design a test. This allows non-technical test engineers and business analysts to design their tests as a series of actions, and then execute the tests automatically without writing code.ABT test design takes place in a spreadsheet-like UI within TestArchitect. All test assets, actions, test data and any necessary GUI interface information, are stored in their own spreadsheets that are called �modules�. Users then create individual test modules using actions that call assets from the other modules when the tests are executed.";
	public static String STRING_GREATER_THAN_50_CHARACTERS = "Actions are the tasks that are executed in a test and function like building-blocks that can be combined in any order to design a test.";
	public static String VALID_INPUT_VALUE = null;
	
	//-------------------------CCV---------------------------//
//	public static final String CCV_NAME = "DANIELLE BLOMFIELD";
//	public static final String CCV_NUMBER = "4242424242424242";
//	public static final String CCV_EXPIRATION_YEAR = "2021";
//	public static final String CCV_EXPIRATION_MONTH = "Mar";
//	public static final String CID = "910";
//	public static final String CCV_ADDRESS = "New York";
//	public static final String CCV_CITY = "New York";
//	public static final String CCV_ZIPCODE = "60000";
	
	
	// FPT Shop Data
	
	public static String FPTSHOP_URL = "https://fptshop.com.vn";
	
	public static final int ObjectWait = 10;
	public static final long timeOut = 30;
	public static final int TimeWait = 10;
	
	// ---------------------------------Order an item----------------------------------//
	public static final String ITEM_NAME = "iPhone X 256GB";
	public static final String CLIENT_NAME = "[ecom test] don hang";
	public static final String CLIENT_PHONE = "0943717477";
	public static final String CLIENT_EMAIL = "datnt86@fpt.com.vn";
	public static final String PAYMENT_METHOD = "HOME";
	public static final String ITEM_CATEGORY = "ĐIỆN THOẠI";
	public static final String ITEM_BRAND = "Apple (iPhone)";
	
	//----------------------------------Installment Buying Info-------------------------//	
	public static final String CLIENT_ID = "111111111";
	public static final String CLIENT_BIRTH_DAY = "1";
	public static final String CLIENT_BIRTH_MONTH = "1";
	public static final String CLIENT_BIRTH_YEAR = "1991";
	public static final int CLIENT_CITY = 2;
	public static final int CLIENT_DISTRICT = 2;
	public static final String CLIENT_ADDRESS = "009 Dang Duc Thuat";
	public static final String CLIENT_GUARANTOR_PHONE = "0909090909";
	
	// Banner
	public static final int INDEX_OF_BANNER = 2;
	
}
