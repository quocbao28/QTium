package ScrumBoard.Android;

public class ScreenFactory {

	public static LoginScreen LoginScreen()
	{
		return LoginScreen.getLoginScreen();
	}
	
	public static CreateIssueScreen CreateIssueScreen()
	{
		return CreateIssueScreen.getCreateIssueScreen();
	}
	
	public static EditIssueScreen EditIssueScreen()
	{
		return EditIssueScreen.getEditIssueScreen();
	}
	
}