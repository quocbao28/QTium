package ScrumBoard.Android;


import org.openqa.selenium.By;
import Android.LoginScreenEntity;
import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

public class LoginScreen {
	
	public static synchronized LoginScreen getLoginScreen()
	{
		if(instance == null)
			instance = new LoginScreen();
		return instance;
	}
	
	
	public void FillLoginInfor(String userName, String password){
		QTiumAutomation.enter(LoginScreenEntity.UserName, userName);
		QTiumAutomation.enter(LoginScreenEntity.Password, password);		
	}
	
	public void Login(String userName, String password){
		FillLoginInfor(userName, password);
		QTiumAutomation.click(LoginScreenEntity.Login);
	}
	
	public void Login(){
		Login(
				userName="tam.pham",
				password="QTium123"
		);		
	}
	
	public void CheckPageDisplayed()
	{
		boolean isPagedisplayed = QTiumAutomation.isPageDisplayed(LoginScreenEntity.PageTitle);
		QTiumAssert.verifyEquals(isPagedisplayed, true);
	}
	
	public void CheckLoginSuccess()
	{
		String text = QTiumAutomation.getText(LoginScreenEntity.BarTitle);
		QTiumAssert.verifyEquals(text, "ScrumBoard - Dashboard");
	}
	
	public void CheckErrorMessageDisplayed(By element, String message){
		String text = QTiumAutomation.getText(element);
		QTiumAssert.verifyEquals(text, message);
		
	}
	
	public void CheckAllControls() {
		boolean isUsername = QTiumAutomation.isElementExists(LoginScreenEntity.UserName);
		QTiumAssert.verifyEquals(isUsername, true);
		
		boolean isPassword = QTiumAutomation.isElementExists(LoginScreenEntity.Password);
		QTiumAssert.verifyEquals(isPassword, true);
		
		boolean isSignIn = QTiumAutomation.isElementExists(LoginScreenEntity.Login);
		QTiumAssert.verifyEquals(isSignIn,true);
		
		String strUserName = QTiumAutomation.getText(LoginScreenEntity.UserName);
		QTiumAssert.verifyEquals(strUserName, "");
		
		String strPassword = QTiumAutomation.getText(LoginScreenEntity.Password);
		QTiumAssert.verifyEquals(strPassword, "");

		String strLoginButton = QTiumAutomation.getAttribute(LoginScreenEntity.Login, "text");
		QTiumAssert.verifyEquals(strLoginButton, "Login");
				
	}

	
		
	private static LoginScreen instance = null;
	private String userName, password;

}
