package ScrumBoard;


import org.openqa.selenium.By;

import Common.Constants;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

public class CreateIssuePage {
	
	public static synchronized CreateIssuePage getPage()
	{
		if(instance == null)
			instance = new CreateIssuePage();
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
		boolean isPagedisplayed = QTiumAutomation.isPageDisplayed(CreateIssuePageEntity.PageTitle);
		QTiumAssert.verifyEquals(isPagedisplayed, true);
	}
	
	public void CheckErrorMessageDisplayed(By element, String message){
		String text = QTiumAutomation.getText(element);
		QTiumAssert.verifyEquals(text, message);
		
	}
		
	private static CreateIssuePage instance = null;

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
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Label_Title);
			QTiumAssert.verifyEquals(textValue, title);
		    
		    
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Description);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Label_Description);
			QTiumAssert.verifyEquals(textValue, description);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Priority);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Label_PriorityId);
			QTiumAssert.verifyEquals(textValue, priority);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Component);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Label_ComponentId);
			QTiumAssert.verifyEquals(textValue, component);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Estimate);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Label_Estimate);
			QTiumAssert.verifyEquals(textValue, estimate);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Spent);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Label_Spent);
			QTiumAssert.verifyEquals(textValue, spent);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Assignee);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Label_Assignee);
			QTiumAssert.verifyEquals(textValue, assignee);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Status);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(CreateIssuePageEntity.Label_StatusId);
			QTiumAssert.verifyEquals(textValue, status);
			
			
	
		
		
	}


	
}
