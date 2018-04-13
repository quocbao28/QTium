package ScrumBoard;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class LoginPageEntity {

	//-------------------------Title of Login Page-----------------------------------
	public static String PageTitle = "Login - QTium";
	
	//-------------------------Interfaces of Login Page------------------------------
	
	public static By UserName = QTiumElementDefinition.Id("userName");
	public static By Password = QTiumElementDefinition.Id("password");
	public static By Login = QTiumElementDefinition.Id("btnLogIn");
	public static By RememberMe = QTiumElementDefinition.Id("IsRememberMe");
	public static By rememberLabel = QTiumElementDefinition.Xpath(".//*[@id='formLogin']/div/div[3]/div/label");
	public static By UserNameErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='UserName']");
	public static By PasswordErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='Password']");
	public static By LogInErrorMessage = QTiumElementDefinition.Xpath("//html//body//div//div[2]//div[1]//div//ul//li");
}
