package ScrumBoard;


import org.openqa.selenium.By;

import Common.Constants;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

public class EditIssuePage {
	
	public static synchronized EditIssuePage getPage()
	{
		if(instance == null)
			instance = new EditIssuePage();
		return instance;
	}
	
	
	//----------------------------------- business actions -----------------------------------
	
	public void FillIssueData(
			String title, 
			String description,
			String priority, 
			String component, 
			String estimate, 
			String spent,
			String assignee,
			String status)
	{
		if (title == null) {
			QTiumAutomation.enter(CreateIssuePageEntity.Title, "Valid issue title");
		}else {
			QTiumAutomation.enter(CreateIssuePageEntity.Title, title);
		}
		
		if (description == null) {
			QTiumAutomation.enter(CreateIssuePageEntity.Description, "valid issues description");			
		}else {
			QTiumAutomation.enter(CreateIssuePageEntity.Description, description);
		}

		if (priority != null) {			
			QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Priority, priority);
		}
		else
		{
			QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Priority, "Low");
		}

		if(component != null)
		{
			QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Component, component);
		}
		else
		{
			QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Component, "TAMobile");
		}
		
		if (estimate == null) {
			QTiumAutomation.enter(CreateIssuePageEntity.Estimate, "0");
		}
		else
		{
			QTiumAutomation.enter(CreateIssuePageEntity.Estimate, estimate);
		}

		if (spent == null) {
			QTiumAutomation.enter(CreateIssuePageEntity.Spent, "0");
		}
		else
		{
			QTiumAutomation.enter(CreateIssuePageEntity.Spent, spent);
		}
		
		if (assignee == null) {
			QTiumAutomation.enter(CreateIssuePageEntity.Assignee, "tam.pham");
		}
		else
		{
			QTiumAutomation.enter(CreateIssuePageEntity.Assignee, assignee);
		}
		
		if(status == null)
		{
			QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Status, "To Do");
		}
		else
		{
			QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Status, status);
		}
		
	}	

	
	//----------------------------------- check actions-----------------------------------
	
	public void CheckPageDisplayed()
	{
		boolean isPagedisplayed = QTiumAutomation.isPageDisplayed(UpdateIssuePageEntity.PageTitle);
		QTiumAssert.verifyEquals(isPagedisplayed, true);
	}
	
	public void CheckErrorMessageDisplayed(By element, String message){
		String text = QTiumAutomation.getText(element);
		QTiumAssert.verifyEquals(text, message);
		
	}
		
	private static EditIssuePage instance = null;

	public void CheckAllControls(
			String title,
			String description,
			String priority,
			String component,
			String estimate,
			String spent,
			String assignee,
			String status) {
			
			
		    String textValue="";
		    boolean isControlExists = false;
		    
			
		    isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Title);
		    QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Title);
			QTiumAssert.verifyEquals(textValue, title);
		    
		    
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Description);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Description);
			QTiumAssert.verifyEquals(textValue, description);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Priority);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Priority);
			QTiumAssert.verifyEquals(textValue, priority);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Component);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Component);
			QTiumAssert.verifyEquals(textValue, component);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Estimate);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Estimate);
			QTiumAssert.verifyEquals(textValue, estimate);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Spent);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Spent);
			QTiumAssert.verifyEquals(textValue, spent);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Assignee);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Assignee);
			QTiumAssert.verifyEquals(textValue, assignee);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Status);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Status);
			QTiumAssert.verifyEquals(textValue, status);
			
			
			
			
			
			
			
			
			
			
//			
//		    
//		    
//			
//			
//			
//			
//			
//			
//		    
//		    
//			boolean islabelTitleExists = QTiumAutomation.isElementExists(ScrumBoardPageEntity.Label_Title);
//			textValue = QTiumAutomation.getText(ScrumBoardPageEntity.Label_Title);
//			QTiumAssert.verifyEquals(textValue, "Title");
//			
//			boolean islabelDescriptionExists = QTiumAutomation.isElementExists(ScrumBoardPageEntity.Label_Description);
//			
//			
//			boolean islabelPriorityIdExists = QTiumAutomation.isElementExists(ScrumBoardPageEntity.Label_PriorityId);
//			
//			
//			boolean islabelComponentIdExists = QTiumAutomation.isElementExists(ScrumBoardPageEntity.Label_ComponentId);
//			;
//			
//			boolean islabelEstimateExists = QTiumAutomation.isElementExists(ScrumBoardPageEntity.Label_Estimate);
//			
//			
//			boolean islabelSpentExists = QTiumAutomation.isElementExists(ScrumBoardPageEntity.Label_Spent);
//			
//			
//			boolean islabelAssigneeExists = QTiumAutomation.isElementExists(ScrumBoardPageEntity.Label_Assignee);
//			
//			
//			boolean islabelStatusIdExists = QTiumAutomation.isElementExists(ScrumBoardPageEntity.Label_StatusId);		
//			
//			
//			boolean isTitleExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Title);
//			boolean isDescriptionExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Description);
//			boolean isPriorityIdExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Priority);
//			boolean isComponentIdExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Component);
//			boolean isEstimateExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Estimate);
//			boolean isSpentExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Spent);
//			boolean isAssigneeExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Assignee);
//			boolean isStatusIdExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Status);		
//			
//			boolean isSubmitExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Submit);
//			boolean isCancelExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Cancel);
//			
//			
//			QTiumAssert.verifyTrue(islabelTitleExists);
//			QTiumAssert.verifyTrue(islabelDescriptionExists);
//			QTiumAssert.verifyTrue(islabelPriorityIdExists);
//			QTiumAssert.verifyTrue(islabelComponentIdExists);
//			QTiumAssert.verifyTrue(islabelEstimateExists);
//			QTiumAssert.verifyTrue(islabelSpentExists);
//			QTiumAssert.verifyTrue(islabelAssigneeExists);
//			QTiumAssert.verifyTrue(islabelStatusIdExists);
//			
//			
//			QTiumAssert.verifyTrue(isTitleExists);
//			QTiumAssert.verifyTrue(isDescriptionExists);
//			QTiumAssert.verifyTrue(isPriorityIdExists);
//			QTiumAssert.verifyTrue(isComponentIdExists);
//			QTiumAssert.verifyTrue(isEstimateExists);
//			QTiumAssert.verifyTrue(isSpentExists);
//			QTiumAssert.verifyTrue(isAssigneeExists);
//			QTiumAssert.verifyTrue(isStatusIdExists);
//			
//			QTiumAssert.verifyTrue(isSubmitExists);
//			QTiumAssert.verifyTrue(isCancelExists);
		
		
	}


	
}
