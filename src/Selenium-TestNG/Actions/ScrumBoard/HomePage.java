package ScrumBoard;

import org.openqa.selenium.By;

import Common.Constants;
import ScrumBoard.AbstractPage;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

public class HomePage {

	public static synchronized HomePage getHomePage() {
		if (instance == null)
			instance = new HomePage();
		return instance;
	}

	private static HomePage instance = null;

	// ----------------------------------- business actions
	// -----------------------------------

	public void Open() throws Exception {
		QTiumAutomation.openURL(Constants.FPTSHOP_URL);
	}

	// ----------------------------------- check
	// actions-----------------------------------

	public void CheckPageDisplayed() {
		boolean isPagedisplayed = QTiumAutomation.isPageDisplayed(LoginPageEntity.PageTitle);
		QTiumAssert.verifyEquals(isPagedisplayed, true);

	}

	public void CheckErrorMessageDisplayed(By element, String message) {
		String text = QTiumAutomation.getText(element);
		QTiumAssert.verifyEquals(text, message);

	}

	public void CheckAllControls() {
		boolean isUsername = QTiumAutomation.isElementExists(LoginPageEntity.UserName);
		QTiumAssert.verifyEquals(isUsername, true);

		boolean isPassword = QTiumAutomation.isElementExists(LoginPageEntity.Password);
		QTiumAssert.verifyEquals(isPassword, true);

		boolean isRememberMe = QTiumAutomation.isElementExists(LoginPageEntity.RememberMe);
		QTiumAssert.verifyEquals(isRememberMe, true);

		boolean isSignIn = QTiumAutomation.isElementExists(LoginPageEntity.Login);
		QTiumAssert.verifyEquals(isSignIn, true);

		String strUserName = QTiumAutomation.getText(LoginPageEntity.UserName);
		QTiumAssert.verifyEquals(strUserName, "");

		String strPassword = QTiumAutomation.getText(LoginPageEntity.Password);
		QTiumAssert.verifyEquals(strPassword, "");

		String isRememberMeLabel = QTiumAutomation.getText(LoginPageEntity.rememberLabel);
		QTiumAssert.verifyEquals(isRememberMeLabel, "Remember me");

		String strLoginButton = QTiumAutomation.getAttribute(LoginPageEntity.Login, "value");
		QTiumAssert.verifyEquals(strLoginButton, "Log in");

	}
}
