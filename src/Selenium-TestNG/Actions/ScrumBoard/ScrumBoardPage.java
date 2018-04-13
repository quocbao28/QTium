package ScrumBoard;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Common.Constants;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;
import com.logigear.selenium.QTiumSetting;

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
		boolean isLogInPage = QTiumAutomation.isPageDisplayed(LoginPageEntity.PageTitle);
		if(isLogInPage == false)
		{
			logOff();
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
		QTiumAutomation.isPageDisplayed(CreateIssuePageEntity.PageTitle);
		
		
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
		QTiumAutomation.click(CreateIssuePageEntity.Submit);
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
	
	public void logOff() {
		
		System.out.println("log off");
		expandUserProfile();
		QTiumAutomation.click(ScrumBoardPageEntity.LogOff);
		QTiumAutomation.isPageDisplayed(LoginPageEntity.PageTitle);
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
					String cardId,
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
		PageFactory.ScrumBoardPage().expendStory(cardId);		
		
		By bytitle = By.xpath(String.format(ScrumBoardPageEntity.IssueHeaderById, cardId));
		By byid = By.xpath(String.format(ScrumBoardPageEntity.CellInIssueById, cardId, "cardId"));
		By bydescription = By.xpath(String.format(ScrumBoardPageEntity.CellInIssueById, cardId, "description"));
		By byestimate = By.xpath(String.format(ScrumBoardPageEntity.CellInIssueById, cardId, "estimate"));
		By byspent = By.xpath(String.format(ScrumBoardPageEntity.CellInIssueById, cardId, "spent"));
		By byassignee = By.xpath(String.format(ScrumBoardPageEntity.CellInIssueById, cardId, "assignee"));
		By bycomponent = By.xpath(String.format(ScrumBoardPageEntity.CellInIssueById, cardId, "component"));
		By bypriority = By.xpath(String.format(ScrumBoardPageEntity.CellInIssueById, cardId, "priority"));
		By bystatus = By.xpath(String.format(ScrumBoardPageEntity.CellInIssueById, cardId, "status"));
		
		By detail = By.xpath(String.format(ScrumBoardPageEntity.ButtonInIssueById, cardId, "Detail", cardId));
		By edit = By.xpath(String.format(ScrumBoardPageEntity.ButtonInIssueById, cardId, "Edit", cardId));
		By delete = By.xpath(String.format(ScrumBoardPageEntity.ButtonInIssueById, cardId, "Delete", cardId));
		
		
		String titleContent = QTiumAutomation.getText(bytitle);
		String idContent = QTiumAutomation.getText(byid);
		String descriptionContent = QTiumAutomation.getText(bydescription);
		String estimateContent = QTiumAutomation.getText(byestimate);
		String spentContent = QTiumAutomation.getText(byspent);
		String assigneeContent = QTiumAutomation.getText(byassignee);
		String componentContent = QTiumAutomation.getText(bycomponent);
		String priorityContent = QTiumAutomation.getText(bypriority);
		String statusContent = QTiumAutomation.getText(bystatus);
		String detailContent = QTiumAutomation.getText(detail);
		String editContent = QTiumAutomation.getText(edit);
		String deleteContent = QTiumAutomation.getText(delete);
		
		
		QTiumAssert.verifyEquals(idContent, cardId);
		QTiumAssert.verifyEquals(titleContent, title);
		QTiumAssert.verifyEquals(descriptionContent, description);
		QTiumAssert.verifyEquals(estimateContent, estimate);
		QTiumAssert.verifyEquals(spentContent, spent);
		QTiumAssert.verifyEquals(assigneeContent, assignee);
		QTiumAssert.verifyEquals(componentContent, component);
		QTiumAssert.verifyEquals(priorityContent, priority);
		QTiumAssert.verifyEquals(statusContent, status);
		QTiumAssert.verifyEquals(detailContent, "Detail");
		QTiumAssert.verifyEquals(editContent, "Edit");
		QTiumAssert.verifyEquals(deleteContent, "Delete");
		
		
		
	}



	public void CheckUserProfileIsDisplayed(String user) {
		System.out.println("check tam.pham");
		expandUserProfile();
		String userName = QTiumAutomation.getText(By.xpath("//b[@id='loggedInUser']"));
		QTiumAssert.verifyEquals(userName, user);
		
	}
	
}
