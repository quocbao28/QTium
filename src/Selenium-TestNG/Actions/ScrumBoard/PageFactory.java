package ScrumBoard;

public class PageFactory {
	
	public static HomePage HomePage()
	{
		return HomePage.getHomePage();
	}

	public static AbstractPage AbstractPage()
	{		
		return AbstractPage.getAbstractPage();
	}
	
	public static SearchResultPage SearchResultPage()
	{
		return SearchResultPage.getSearchResultPage();
	}
	
	public static ItemDetailPage ItemDetailPage()
	{
		return ItemDetailPage.getItemDetailPage();
	}
	
	public static InstallmentBuyingPage InstallmentBuyingPage()
	{
		return InstallmentBuyingPage.getInstallmentBuyingPage();
	}
	
	
///////////////////////////////////////////////////////
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