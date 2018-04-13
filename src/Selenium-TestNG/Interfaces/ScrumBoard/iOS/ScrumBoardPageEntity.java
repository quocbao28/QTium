package ScrumBoard.iOS;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class ScrumBoardPageEntity {
	//----------------------Title of ScrumBoard Page--------------------------------
	public static String PageTitle = "Board - QTium";
	
	//----------------------Interfaces of ScrumBoard Page---------------------------
	public static By Label_Id = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
	public static By Label_Title = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
	public static By Label_Description = By.xpath("/UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]");
	public static By Label_PriorityId = By.xpath("/UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[8]/UIAStaticText[1]");
	public static By Label_ComponentId = By.xpath("/UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[7]/UIAStaticText[1]");
	public static By Label_Estimate = By.xpath("/UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]");
	public static By Label_Spent = By.xpath("/UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIAStaticText[1]");
	public static By Label_Assignee = By.xpath("/UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIAStaticText[1]");
	public static By Label_StatusId = By.xpath("/UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[9]/UIAStaticText[1]");
	

	public static By Id = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]");
	public static By Title = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIATextField[1]");
	public static By Description = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIATextField[1]");
	public static By Priority = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[8]/UIATextField[1]");
	public static By Component = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[7]/UIATextField[1]");
	public static By Status = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[10]/UIATextField[1]");
	public static By Estimate = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIATextField[1]");
	public static By Spent = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIATextField[1]");
	public static By Assignee = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIATextField[1]");

	
	public static By CreateIssue = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	public static By Button_EditIssue = MobileBy.IosUIAutomation(".navigationBar().buttons()[\"Edit\"]");
	public static By Button_Done = MobileBy.IosUIAutomation(".navigationBar().buttons()[\"Done\"]");
	public static By Title_Navigator = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");
	public static By Tab_ToDo = MobileBy.IosUIAutomation(".tabBar().buttons()[0]");
	public static By Tab_InProgress = MobileBy.IosUIAutomation(".tabBar().buttons()[1]");
	public static By Tab_Done = MobileBy.IosUIAutomation(".tabBar().buttons()[2]");
	
	
	public static By Delete = QTiumElementDefinition.Name("btnDelete");
	//public static By Create = QTiumElementDefinition.Xpath("//span[text()='Create']");
	public static By Update = QTiumElementDefinition.Xpath("//span[text()='Update']");
	
	public static By OK = QTiumElementDefinition.Xpath("//span[text()='OK']");
	public static By UserStoryDetail = QTiumElementDefinition.Xpath("//div[@id='infoDialog']/table");
	public static By Close = QTiumElementDefinition.Xpath("//span[text()='Close']");	
	
	public static By LogOff = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[5]");
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
