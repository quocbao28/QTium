package ScrumBoard.iOS;


import org.openqa.selenium.By;

import Common.Constants;
import ScrumBoard.iOS.LoginPageEntity;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

public class LoginPage {
	
	public static synchronized LoginPage getLoginPage()
	{
		if(instance == null)
			instance = new LoginPage();
		return instance;
	}
	
	
	//----------------------------------- business actions -----------------------------------

	public void Open() throws Exception {
		QTiumAutomation.open();
		//QTiumAutomation.openURL(Constants.SCRUM_BOARD_URL);
	}
	
	public void FillLoginInfor(String userName, String password){
		QTiumAutomation.enter(LoginPageEntity.UserName, userName);
		QTiumAutomation.enter(LoginPageEntity.Password, password);		
	}
//	public void FillLoginInforAndClick(String userName, String password){
//		QTiumAutomation.enter(LoginPageEntity.UserName, userName);
//		QTiumAutomation.enter(LoginPageEntity.Password, password);	
//		QTiumAutomation.click(LoginPageEntity.Login);
//	}
	
	public void Login(String userName, String password){
		FillLoginInfor(userName, password);
		QTiumAutomation.click(LoginPageEntity.Login);
	}
	
	public void Login(){
		Login(
				userName="tam.pham",
				password="QTium123"
		);
		QTiumAutomation.isPageDisplayed(ScrumBoardPageEntity.PageTitle);
		
		
	}
	
	
	//----------------------------------- check actions-----------------------------------
	
	public void CheckPageDisplayed()
	{
		boolean isPagedisplayed = QTiumAutomation.isPageDisplayed(LoginPageEntity.PageTitle);
		QTiumAssert.verifyEquals(isPagedisplayed, true);
		
	}
	
	public void CheckErrorMessageDisplayed(By element, String message){
		String text = QTiumAutomation.getText(element);
		QTiumAssert.verifyEquals(text, message);
		
	}
	public void confirmMessage(){
		QTiumAutomation.click(LoginPageEntity.Button_Confirm_Message);
	}	
	private static LoginPage instance = null;
	private String userName, password;
	
	public void CheckAllControls() {
		boolean isUsername = QTiumAutomation.isElementExists(LoginPageEntity.UserName);
		QTiumAssert.verifyEquals(isUsername, true);
		
		boolean isPassword = QTiumAutomation.isElementExists(LoginPageEntity.Password);
		QTiumAssert.verifyEquals(isPassword, true);
		
		//boolean isRememberMe = QTiumAutomation.isElementExists(LoginPageEntity.RememberMe);
		//QTiumAssert.verifyEquals(isRememberMe,true);
	
		//boolean isSignIn = QTiumAutomation.isElementExists(LoginPageEntity.Login);
		//QTiumAssert.verifyEquals(isSignIn,true);
		
		//String strUserName = QTiumAutomation.getAttribute(LoginPageEntity, "value");
		//QTiumAssert.verifyEquals(strUserName, "");
		
		//String strPassword = QTiumAutomation.getText(LoginPageEntity.Password);
		//QTiumAssert.verifyEquals(strPassword, "");
		
		//String isRememberMeLabel = QTiumAutomation.getText(LoginPageEntity.rememberLabel);
		//QTiumAssert.verifyEquals(isRememberMeLabel, "Remember me");

		String strLoginButton = QTiumAutomation.getAttribute(LoginPageEntity.Login, "value");
		QTiumAssert.verifyEquals(strLoginButton, "Login");
				
	}
	public void checkLoginScreen(By element){
		boolean isExist = QTiumAutomation.isElementExists(element);
		QTiumAssert.verifyTrue(isExist, true);
	}


	
}
