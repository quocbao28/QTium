package ScrumBoard;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class ScrumBoardPageEntity {
	//----------------------Title of ScrumBoard Page--------------------------------
	public static String PageTitle = "Board - QTium";
	
	//----------------------Interfaces of ScrumBoard Page---------------------------
	public static By Label_Title = By.xpath("//label[@for='Title']");
	public static By Label_Description = By.xpath("//label[@for='Description']");
	public static By Label_PriorityId = By.xpath("//label[@for='PriorityId']");
	public static By Label_ComponentId = By.xpath("//label[@for='ComponentId']");
	public static By Label_Estimate = By.xpath("//label[@for='Estimate']");
	public static By Label_Spent = By.xpath("//label[@for='Spent']");
	public static By Label_Assignee = By.xpath("//label[@for='Assignee']");
	public static By Label_StatusId = By.xpath("//label[@for='StatusId']");

	
	public static By CreateIssue = QTiumElementDefinition.Id("btnCreate");
	
	public static By Delete = QTiumElementDefinition.Name("btnDelete");
	//public static By Create = QTiumElementDefinition.Xpath("//span[text()='Create']");
	public static By Update = QTiumElementDefinition.Xpath("//span[text()='Update']");
	
	public static By OK = QTiumElementDefinition.Xpath("//span[text()='OK']");
	public static By UserStoryDetail = QTiumElementDefinition.Xpath("//div[@id='infoDialog']/table");
	public static By Close = QTiumElementDefinition.Xpath("//span[text()='Close']");	
	
	public static By LogOff = QTiumElementDefinition.Id("btnLogoff");
	public static By LoggedInUser = QTiumElementDefinition.Id("loggedInUser");
	
	public static By ExpandUserBannerButton = QTiumElementDefinition.Xpath(".//*[@id='btnNavToggle']");	
	
	
	
	
	public static By SuccessMessage = QTiumElementDefinition.Id("infoMessage");
																 
	
	public static  String IssueById = "//div[@id='%s']";
	public static  String IssueHeaderById = IssueById + "/../button";
	public static  String IssueBodyById = IssueById;
	public static  String ButtonInIssueById = IssueBodyById + "/div/a[@id='btn%s%s']";
	public static  String CellInIssueById = IssueBodyById + "/table/tbody/tr/td[@id='%s']";
	
	
	public static  String StoryBoardByTitle = "/html/body/div[2]/div[2]/div/div/div/article/div[./div[text()='%s']]";
	public static  String StoryBoardHeaderByTitle = StoryBoardByTitle + "/div[1]";
	public static  String StoryBoardBodyByTitle = StoryBoardByTitle + "/div[2]";
	public static  String ButtonInStoryBoardByTitle = StoryBoardBodyByTitle + "/div/a[text()='%s']";
	public static  String StoryBoardCellByTitle = StoryBoardBodyByTitle + "/table/tbody/tr[%d]/td[%d]";
	
	
	
	
	
	
	
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
