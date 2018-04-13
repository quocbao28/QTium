package ScrumBoard.iOS;


import io.appium.java_client.MobileBy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Common.Constants;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;
import com.logigear.selenium.QTiumElementDefinition;
import com.logigear.selenium.QTiumSetting;

import ScrumBoard.iOS.*;

public class ScrumBoardPage {
	
	
	public static synchronized ScrumBoardPage getPage()
	{
		if(instance == null)
			instance = new ScrumBoardPage();
		return instance;
	}	
	
	//----------------------------------- business actions -----------------------------------	
	
	
	
	
	
	//----------------------------------- check actions-----------------------------------	
	
	
	
	public void logOffIfLogin()
	{
		Boolean isLogin = QTiumAutomation.isElementExists(ScrumBoardPageEntity.LogOff);
		if(isLogin){
			String titleButton = QTiumAutomation.getText(ScrumBoardPageEntity.LogOff);
			Boolean isLogInPage = titleButton.equals("Logout");
			if(isLogInPage == false)
			{
				logOff();
			}
		}
		
	}
	
	
	

	public void CheckPageDisplayed()
	{
		boolean isPagedisplayed = QTiumAutomation.isPageDisplayed(ScrumBoardPageEntity.PageTitle);
		QTiumAssert.verifyEquals(isPagedisplayed, true);

	}

//	public void CheckPageDisplayed(String pageTitle)
//	{
//		boolean isPagedisplayed = QTiumAutomation.isPageDisplayed(pageTitle);
//		QTiumAssert.verifyEquals(isPagedisplayed, true);
//
//	}
	

	private static ScrumBoardPage instance = null;
//	public void fillData(
//			String title, 
//			String description,
//			String priority, 
//			String component, 
//			String estimate, 
//			String spent,
//			String assignee,
//			String status)
//	{
//		QTiumAutomation.enter(ScrumBoardPageEntity.Title, title);
//		QTiumAutomation.enter(ScrumBoardPageEntity.Description, description);
//		if(priority.trim().equals("") == false)
//		{
//			QTiumAutomation.selectByVisibleText(ScrumBoardPageEntity.Priority, priority);
//		}
//		if(component.trim().equals("") == false)
//		{
//			QTiumAutomation.selectByVisibleText(ScrumBoardPageEntity.Component, component);
//		}
//		QTiumAutomation.enter(ScrumBoardPageEntity.Estimate, estimate);
//		QTiumAutomation.enter(ScrumBoardPageEntity.Spent, spent);
//		QTiumAutomation.enter(ScrumBoardPageEntity.Assignee, assignee);
//		if(status.trim().equals("") == false)
//		{
//			QTiumAutomation.selectByVisibleText(ScrumBoardPageEntity.Status, status);
//		}
//	}
	public void checkScrumBoardErrorMessage(	By forTitle, String titleMessage, 
									By forDescription, String descriptionMessage,
									By forPriority, String priorityMessage, 
									By forComponent, String componentMessage, 
									By forEstimate, String estimateMessage, 
									By forSpent, String spentMessage,
									By forAssignee, String assigneeMessage,
									By forStatus, String statusMessage)
	{
		String szTitleMessage = QTiumAutomation.getText(forTitle);
		String szDescriptionMessage = QTiumAutomation.getText(forDescription);
		String szPriorityMessage = QTiumAutomation.getText(forPriority);
		String szComponentMessage = QTiumAutomation.getText(forComponent);
		String szEstimateMessage = QTiumAutomation.getText(forEstimate);
		String szSpentMessage = QTiumAutomation.getText(forSpent);
		String szAssigneeMessage = QTiumAutomation.getText(forAssignee);
		String szStatusMessage = QTiumAutomation.getText(forStatus);
		
		QTiumAssert.verifyEquals(szTitleMessage, titleMessage);
		QTiumAssert.verifyEquals(szDescriptionMessage, descriptionMessage);
		QTiumAssert.verifyEquals(szPriorityMessage, priorityMessage);
		QTiumAssert.verifyEquals(szComponentMessage, componentMessage);
		QTiumAssert.verifyEquals(szEstimateMessage, estimateMessage);
		QTiumAssert.verifyEquals(szSpentMessage, spentMessage);
		QTiumAssert.verifyEquals(szAssigneeMessage, assigneeMessage);
		QTiumAssert.verifyEquals(szStatusMessage, statusMessage);
	}

	public void checkSuccessMessageDisplayed(boolean isDisplay) 
	{	
		String successMessage = QTiumAutomation.getText(ScrumBoardPageEntity.SuccessMessage);
		if(isDisplay == false)
		{
			QTiumAssert.verifyEquals(successMessage.trim(), "");
		}
	}

	public void checkDefaultValue(By forTitle, String titleValue, 
									By forDescription, String descriptionValue,
									By forPriority, String priorityValue, 
									By forComponent, String componentValue, 
									By forEstimate, String estimateValue, 
									By forSpent, String spentValue,
									By forAssignee, String assigneeValue,
									By forStatus, String statusValue) 
	{
		String szTitle = QTiumAutomation.getText(forTitle);
		String szDescription = QTiumAutomation.getText(forDescription);
		String szPriority = QTiumAutomation.getSelectedComboboxItemText(forPriority);
		String szComponent = QTiumAutomation.getSelectedComboboxItemText(forComponent);
		String szEstimate = QTiumAutomation.getAttribute(forEstimate, "value");
		String szSpent = QTiumAutomation.getAttribute(forSpent, "value");
		String szAssignee = QTiumAutomation.getText(forAssignee);
		String szStatus = QTiumAutomation.getSelectedComboboxItemText(forStatus);
		
		QTiumAssert.verifyEquals(szTitle, titleValue);
		QTiumAssert.verifyEquals(szDescription, descriptionValue);
		QTiumAssert.verifyEquals(szPriority, priorityValue);
		QTiumAssert.verifyEquals(szComponent, componentValue);
		QTiumAssert.verifyEquals(szEstimate, estimateValue);
		QTiumAssert.verifyEquals(szSpent, spentValue);
		QTiumAssert.verifyEquals(szAssignee, assigneeValue);
		QTiumAssert.verifyEquals(szStatus, statusValue);
		
		
	}

	public String createScrumBoard() 
	{
		String id = "";
		String title, description, priority, component, estimate, spent, assignee, status;
		id = createScrumBoard(	
				title = "New Scrum Board",
				description = "Create new card successfully", 
				priority = "High", 
				component = "Database", 
				estimate = "10", 
				spent = "0", 
				assignee = "Tam.Pham", 
				status = "To Do");
		return id;
	}	
	public String createScrumBoard(
			String title,
			String description,
			String priority,
			String component,
			String estimate,
			String spent,
			String assignee,
			String status 
			) 
	{
		String id = "";
		//1. click on create button
		QTiumAutomation.click(ScrumBoardPageEntity.CreateIssue);
		checkCreateScreen();
		
		
		//2. fillData("dsadsad",123)
		PageFactory.CreateIssuePage().FillIssueData(	
				title,
				description, 
				priority, 
				component, 
				estimate, 
				spent, 
				assignee, 
				status);
				//3. click on submit button
		QTiumAutomation.click(CreateIssuePageEntity.Done);
		id = getIdFromSuccessMessage();
		return id;
	}	
	
	private String getIdFromSuccessMessage()
	{
		String successMessage =  "";
		try
		{
			successMessage = QTiumAutomation.getText(ScrumBoardPageEntity.SuccessMessage);
		}
		catch(Exception ex)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		long timeout = QTiumSetting.getObjecWait()*1000;
		
		long getTickCount = System.currentTimeMillis();
		while ("".equals(successMessage)) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			successMessage = QTiumAutomation.getText(ScrumBoardPageEntity.SuccessMessage);
			if ((System.currentTimeMillis()-getTickCount) > timeout) {
				break;
			}
		}
				
		String id = "";
		successMessage = successMessage.trim();
		if(successMessage.length() > 0)
		{
			int idxOfend = successMessage.indexOf(" has been submitted successfully.");
			int startLength = ("Card with ID: ").length();			
			id = successMessage.substring(startLength, idxOfend);
		}
		return id;
	}
	
	
	public boolean isStoryCollapse(String id)
	{		
		boolean isCollapse = false;
		By issueBody = By.xpath(String.format(ScrumBoardPageEntity.IssueBodyById, id));
		boolean isIssueBodyExists = QTiumAutomation.isElementExists(issueBody);
		if(isIssueBodyExists)
		{
			String css = QTiumAutomation.getAttribute(issueBody, "class");
			if(css.equals("panel-body collapse"))
			{
				isCollapse = true;
			}
		}
		return isCollapse;
	}
	public void expendStory(String id)
	{	
		if(isStoryCollapse(id) == true)
		{
			QTiumAutomation.click(By.xpath(String.format(ScrumBoardPageEntity.IssueHeaderById, id)));
		}
		try {
			Thread.sleep((long) 1000.0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void DeleteScrumBoard(String CardId) {
		
		DoIssueAction(CardId, "Delete");
		QTiumAutomation.click(DeleteIssuePageEntity.Accept);
	}

	public void clickScrumBoardAction(String id, String action)
	{	
		QTiumAutomation.click(By.xpath(String.format(ScrumBoardPageEntity.ButtonInIssueById, id, action, id)));
	}

	
	
	public void checkDetailValue(
			By forTitle, String titleValue,
			By forType, String typeValue,
			By forPriority, String priorityValue,
			By forComponent, String componentValue,
			By forStatus, String statusValue,
			By forResolution, String resolutionValue,			 
			By forAssignee, String assigneeValue, 
			By forEstimate, String estimateValue, 
			By forSpent, String spentValue,			
			By forDescription, String descriptionValue
			) 
	{
		String szType = QTiumAutomation.getText(forType).trim();
		String szTitle = QTiumAutomation.getText(forTitle).trim();
		String szDescription = QTiumAutomation.getText(forDescription).trim();
		String szPriority = QTiumAutomation.getText(forPriority).trim();
		String szComponent = QTiumAutomation.getText(forComponent).trim();
		String szEstimate = QTiumAutomation.getText(forEstimate).trim();
		String szSpent = QTiumAutomation.getText(forSpent).trim();
		String szAssignee = QTiumAutomation.getText(forAssignee).trim();
		String szStatus = QTiumAutomation.getText(forStatus).trim();
		String szResolution = QTiumAutomation.getText(forResolution).trim();
		
		QTiumAssert.verifyEquals(szTitle, titleValue);
		QTiumAssert.verifyEquals(szType, typeValue);		
		QTiumAssert.verifyEquals(szDescription, descriptionValue);
		QTiumAssert.verifyEquals(szPriority, priorityValue);
		QTiumAssert.verifyEquals(szComponent, componentValue);
		QTiumAssert.verifyEquals(Double.valueOf(szEstimate), Double.valueOf(estimateValue));
		QTiumAssert.verifyEquals(Double.valueOf(szSpent), Double.valueOf(spentValue));
		QTiumAssert.verifyEquals(szAssignee, assigneeValue);
		QTiumAssert.verifyEquals(szStatus, statusValue);
		QTiumAssert.verifyEquals(szResolution, resolutionValue);
	
	}

	
	public void checkIssueExists(String cardId, boolean exists) {
		boolean isExists = QTiumAutomation.isElementExists(By.xpath(String.format(ScrumBoardPageEntity.IssueById, cardId)));
		QTiumAssert.verifyEquals(isExists, exists);		
	}
	public void clickTableCell(String title, String description){
		//By Cell = MobileBy.IosUIAutomation("tableViews()[0].cells()[]");
		//QTiumAutomation.click(MobileBy.IosUIAutomation(".tableViews()[\"Empty list\"].cells()[\"Scrum Meeting Request, all QA folks are invited to this meeting\"]"));
		String Xpath = ".tableViews()[\"Empty list\"].cells()[\"Title, SubTitle\"]";
		Xpath =  Xpath.replace("SubTitle",description);
		Xpath = Xpath.replace("Title",title);
		By Cell = MobileBy.IosUIAutomation(Xpath);
		QTiumAutomation.click(Cell);
	}
	public void logOff() {
		
		System.out.println("log off");
		//expandUserProfile();
		//Sleep(1000);
		String xPath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[Number]";
		for(int i=3;i<=5;i++){
			String xPathLogOff = xPath.replaceAll("Number",Integer.toString(i) );
			boolean isExist = QTiumAutomation.isElementExists(QTiumElementDefinition.Xpath(xPathLogOff));
			if(isExist){
				String name = QTiumAutomation.getAttribute(QTiumElementDefinition.Xpath(xPathLogOff), "name");
				if(name.equals("Logout")){
					QTiumAutomation.click(QTiumElementDefinition.Xpath(xPathLogOff));
				}
			}
		}
		//QTiumAutomation.click(ScrumBoardPageEntity.LogOff);
		QTiumAutomation.waitForControl(LoginPageEntity.Login);
		PageFactory.LoginPage().checkLoginScreen(LoginPageEntity.Login);
	}

	public boolean isUserProfileDisplay()
	{
		WebElement logOffButton = QTiumAutomation.findElement(ScrumBoardPageEntity.LogOff);
		return logOffButton.isDisplayed();
	}
	public void expandUserProfile()
	{
		boolean isUserProfileDisplay = isUserProfileDisplay();
		if(isUserProfileDisplay == false)
		{
			QTiumAutomation.click(ScrumBoardPageEntity.ExpandUserBannerButton);
		}
	}
	
	public void DoIssueAction(String cardId, String action) {
		 //1. Select a card to update
		  PageFactory.ScrumBoardPage().expendStory(cardId);
		  //2. Click edit link
		  PageFactory.ScrumBoardPage().clickScrumBoardAction(cardId, action);
		
	}

	public void checkSummaryIssue(
					String title,
					String description,
					String estimate,
					String spent,
					String assignee,
					String component,
					String priority,
					String status									
				) 
	{			
		
		
		
		String titleContent = QTiumAutomation.getText(UpdateIssuePageEntity.Title);
		
		String descriptionContent = QTiumAutomation.getText(UpdateIssuePageEntity.Description);
		String estimateContent = QTiumAutomation.getText(UpdateIssuePageEntity.Estimate);
		String spentContent = QTiumAutomation.getText(UpdateIssuePageEntity.Spent);
		String assigneeContent = QTiumAutomation.getText(UpdateIssuePageEntity.Assignee);
		String componentContent = QTiumAutomation.getText(UpdateIssuePageEntity.Component);
		String priorityContent = QTiumAutomation.getText(UpdateIssuePageEntity.Priority);
		String statusContent = QTiumAutomation.getText(UpdateIssuePageEntity.Status);
		
		QTiumAssert.verifyEquals(titleContent, title);
		QTiumAssert.verifyEquals(descriptionContent, description);
		QTiumAssert.verifyEquals(estimateContent, estimate);
		QTiumAssert.verifyEquals(spentContent, spent);
		QTiumAssert.verifyEquals(assigneeContent, assignee);
		QTiumAssert.verifyEquals(componentContent, component);
		QTiumAssert.verifyEquals(priorityContent, priority);
		QTiumAssert.verifyEquals(statusContent, status);
	}



	public void CheckUserProfileIsDisplayed(String user) {
		System.out.println("check tam.pham");
		expandUserProfile();
		String userName = QTiumAutomation.getAttribute(ScrumBoardPageEntity.Title_Navigator, "value");
		QTiumAssert.verifyEquals(userName, user);
		
	}
	public void backToMain(){
		QTiumAutomation.click(CreateIssuePageEntity.Back);
	}
	public void deleteCard(String title, String description){
		QTiumAutomation.click(ScrumBoardPageEntity.Button_EditIssue);
		String XpathSwitch = ".tableViews()[\"Empty list\"].cells()[\"Title, SubTitle\"].switches()[\"Delete Title, SubTitle\"]";
		XpathSwitch =  XpathSwitch.replaceAll("SubTitle",description);
		XpathSwitch = XpathSwitch.replaceAll("Title",title);
		By cellEdit = MobileBy.IosUIAutomation(XpathSwitch);
		QTiumAutomation.click(cellEdit);
		
		/*String xPathTemp = ".tableViews()[\"Empty list\"].cells()[\"Card number #45937, Card description for number #45937\"].switches()[\"Delete Card number #45937, Card description for number #45937\"]";
		By swtfdfd = MobileBy.IosUIAutomation(xPathTemp);
		
		QTiumAutomation.click(ScrumBoardPageEntity.Button_EditIssue);
		By tableView = MobileBy.IosUIAutomation(".tableViews()[\"Empty list\"]");
		String value = QTiumAutomation.getAttribute(tableView, "value");
		int indexOfRow = value.indexOf("of");
		int currentIndex=0;
		String subString = value.substring(indexOfRow+3);
		int countOfTable = Integer.parseInt(subString);
		String Xpath = ".tableViews()[\"Empty list\"].cells()[index].switches()[\"Title, SubTitle\"]";
		Xpath =  Xpath.replaceAll("SubTitle",description);
		Xpath = Xpath.replaceAll("Title",title);
		
		for(int i=0;i<indexOfRow;i++){
			String XpathSwitch = Xpath.replace("index", Integer.toString(i));
			System.out.print(XpathSwitch);
			By cellEdit = MobileBy.IosUIAutomation(XpathSwitch);
			if(QTiumAutomation.isChecked(cellEdit)){
				currentIndex = i;
				QTiumAutomation.click(cellEdit);
				break;
			}
		}*/
		
		String XpathDelete = ".tableViews()[\"Empty list\"].cells()[\"Title, SubTitle\"].buttons()[\"Delete\"]";
		XpathDelete =  XpathDelete.replace("SubTitle",description);
		XpathDelete = XpathDelete.replace("Title",title);
		By cellDelete = MobileBy.IosUIAutomation(XpathDelete);
		QTiumAutomation.click(cellDelete);
		QTiumAutomation.click(ScrumBoardPageEntity.Button_Done);
	}
	public void CheckAfterDelete(String title, String description){
		String Xpath = ".tableViews()[\"Empty list\"].cells()[\"Title, SubTitle\"]";
		Xpath =  Xpath.replace("SubTitle",title);
		Xpath = Xpath.replace("Title",description);
		By Cell = MobileBy.IosUIAutomation(Xpath);
		boolean isExist = QTiumAutomation.isElementExists(Cell);
		QTiumAssert.verifyEquals(isExist, "false");
	}
	public void Sleep(long mseconds){
		try {
			Thread.sleep(mseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void checkCreateScreen(){
		boolean isExist = QTiumAutomation.isElementExists(CreateIssuePageEntity.Label_Title);
		QTiumAssert.verifyEquals(isExist, true);
		String text = QTiumAutomation.getText(CreateIssuePageEntity.Label_Title);
		QTiumAssert.verifyEquals(text, "Title");
	}
	
	
	
}

