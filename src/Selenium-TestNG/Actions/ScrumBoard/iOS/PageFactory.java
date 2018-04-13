package ScrumBoard.iOS;

public class PageFactory {

	public static LoginPage LoginPage()
	{
		return LoginPage.getLoginPage();
	}
	
	public static ScrumBoardPage ScrumBoardPage()
	{
		return ScrumBoardPage.getPage();
	}
	
	public static DeleteIssuePage DeleteIssuePage()
	{
		return DeleteIssuePage.getPage();
	}
	
	public static CreateIssuePage CreateIssuePage()
	{
		return CreateIssuePage.getPage();
	}
	public static EditIssuePage EditIssuePage()
	{
		return EditIssuePage.getPage();
	}
	
}