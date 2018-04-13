package Android;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumAutomation;

public class DashboardScreenEntity extends AndroidScreenEntity {
	//----------------------Title of ScrumBoard Page--------------------------------
	public static String PageTitle = "ScrumBoard - Dashboard";
	
	//----------------------Interfaces of ScrumBoard Page---------------------------
/*	public static By Label_Title = By.xpath("//label[@for='Title']");
	public static By Label_Description = By.xpath("//label[@for='Description']");
	public static By Label_PriorityId = By.xpath("//label[@for='PriorityId']");
	public static By Label_ComponentId = By.xpath("//label[@for='ComponentId']");
	public static By Label_Estimate = By.xpath("//label[@for='Estimate']");
	public static By Label_Spent = By.xpath("//label[@for='Spent']");
	public static By Label_Assignee = By.xpath("//label[@for='Assignee']");
	public static By Label_StatusId = By.xpath("//label[@for='StatusId']");*/

	
	public static By CreateIssue = ByUIA("description", "Add");
	public static By BarTitle = ByUIA("resourceId","android:id/action_bar_title");
	public static By ListCards = ByUIA("resourceId","android:id/com.logigear.scrumboard:id/lvCards");
	
	
	/*public static By Delete = QTiumElementDefinition.Name("btnDelete");
	//public static By Create = QTiumElementDefinition.Xpath("//span[text()='Create']");
	public static By Update = QTiumElementDefinition.Xpath("//span[text()='Update']");
	
	public static By OK = QTiumElementDefinition.Xpath("//span[text()='OK']");
	public static By UserStoryDetail = QTiumElementDefinition.Xpath("//div[@id='infoDialog']/table");
	public static By Close = QTiumElementDefinition.Xpath("//span[text()='Close']");	
	
	public static By LogOff = QTiumElementDefinition.Id("btnLogoff");
	public static By LoggedInUser = QTiumElementDefinition.Id("loggedInUser");
	
	public static By ExpandUserBannerButton = QTiumElementDefinition.Xpath("html/body/div[1]/div[1]/div/div/div[1]/button");	
	
	
	
	
	public static By SuccessMessage = QTiumElementDefinition.Id("infoMessage");
	
	public static  String IssueById = "/html/body/div/div[2]/div[2]/div/div/div[2]/article/div[./div[@id='%s']]";
	public static  String IssueHeaderById = IssueById + "/div[1]";
	public static  String IssueBodyById = IssueById + "/div[2]";
	public static  String ButtonInIssueById = IssueBodyById + "/div/a[@id='btn%s%s']";
	public static  String CellInIssueById = IssueBodyById + "/table/tbody/tr/td[@id='%s']";
	
	
	public static  String StoryBoardByTitle = "/html/body/div[2]/div[2]/div/div/div/article/div[./div[text()='%s']]";
	public static  String StoryBoardHeaderByTitle = StoryBoardByTitle + "/div[1]";
	public static  String StoryBoardBodyByTitle = StoryBoardByTitle + "/div[2]";
	public static  String ButtonInStoryBoardByTitle = StoryBoardBodyByTitle + "/div/a[text()='%s']";
	public static  String StoryBoardCellByTitle = StoryBoardBodyByTitle + "/table/tbody/tr[%d]/td[%d]";
	
	*/
	
	public static boolean CheckListItemExist(String title, String description){
		By Title = ByUIA("text", title);
		By Description = ByUIA("text", description);
		
		boolean isTitleExist = QTiumAutomation.isElementExists(Title);
		boolean isDescriptionExist = QTiumAutomation.isElementExists(Description);
		return isTitleExist && isDescriptionExist;
	}
	
	public static void ClickListItem(String title){
		By Title = ByUIA("text", title);
		QTiumAutomation.click(Title);
	}
	
	
	public static void setScrumBoardPageEntity(String flatform)
	{
		if(flatform.toLowerCase().equals(""))
		{
			setScrumBoardPageEntityForNativeApp();
			
		}
		else
		{
			
		}
	}
	public static void setScrumBoardPageEntityForNativeApp()
	{
		
	}
}
