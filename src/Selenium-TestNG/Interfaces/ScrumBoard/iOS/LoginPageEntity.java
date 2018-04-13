package ScrumBoard.iOS;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class LoginPageEntity {

	//-------------------------Title of Login Page-----------------------------------
	public static String PageTitle = "Login - QTium";
	
	//-------------------------Interfaces of Login Page------------------------------
	
	public static By UserName = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]");
	public static By Password = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]");
	public static By Login = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]");
	public static By AlertView = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]");
	public static By Label_Message_AlertView = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]");
	public static By Button_Confirm_Message = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIATableView[1]");
	public static By RememberMe = QTiumElementDefinition.Id("IsRememberMe");
	public static By rememberLabel = QTiumElementDefinition.Xpath(".//*[@id='formLogin']/div/div[3]/div/label");
	public static By UserNameErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='UserName']");
	public static By PasswordErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='Password']");
	public static By LogInErrorMessage = QTiumElementDefinition.Xpath("//html//body//div//div[2]//div[1]//div//ul//li");
}
