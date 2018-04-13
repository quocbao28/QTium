package Android;

import org.openqa.selenium.By;

public class LoginScreenEntity extends AndroidScreenEntity {
	
	//-------------------------Title of Login Page-----------------------------------
	public static String PageTitle = "Scrumboard";
	
	//-------------------------Interfaces of Login Page------------------------------
	
	public static By UserName = ByUIA("resourceId", "com.logigear.scrumboard:id/editText1");
	public static By Password = ByUIA("resourceId", "com.logigear.scrumboard:id/editText2");
	public static By Login = ByUIA("resourceId", "com.logigear.scrumboard:id/button1");
	public static By LogInErrorMessage = ByUIA("resourceId","com.logigear.scrumboard:id/tvMessage");
	public static By BarTitle = ByUIA("resourceId","android:id/action_bar_title");
}
