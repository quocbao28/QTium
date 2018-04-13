package ScrumBoard.Android;


import org.openqa.selenium.By;

import Android.IssueScreenEntity;
import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

public class EditIssueScreen {
	
	private static EditIssueScreen instance = null;
	
	public static synchronized EditIssueScreen getEditIssueScreen()
	{
		if(instance == null)
			instance = new EditIssueScreen();
		return instance;
	}
	
	

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
		    
			
		    isControlExists = QTiumAutomation.isElementExists(IssueScreenEntity.Title);
		    QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(IssueScreenEntity.Label_Title);
			QTiumAssert.verifyEquals(textValue, title);
		    
		    
			isControlExists = QTiumAutomation.isElementExists(IssueScreenEntity.Description);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(IssueScreenEntity.Label_Description);
			QTiumAssert.verifyEquals(textValue, description);
			
			
			isControlExists = QTiumAutomation.isElementExists(IssueScreenEntity.Priority);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(IssueScreenEntity.Label_PriorityId);
			QTiumAssert.verifyEquals(textValue, priority);
			
			
			isControlExists = QTiumAutomation.isElementExists(IssueScreenEntity.Component);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(IssueScreenEntity.Label_ComponentId);
			QTiumAssert.verifyEquals(textValue, component);
			
			
			isControlExists = QTiumAutomation.isElementExists(IssueScreenEntity.Estimate);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(IssueScreenEntity.Label_Estimate);
			QTiumAssert.verifyEquals(textValue, estimate);
			
			
			isControlExists = QTiumAutomation.isElementExists(IssueScreenEntity.Spent);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(IssueScreenEntity.Label_Spent);
			QTiumAssert.verifyEquals(textValue, spent);
			
			
			isControlExists = QTiumAutomation.isElementExists(IssueScreenEntity.Assignee);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(IssueScreenEntity.Label_Assignee);
			QTiumAssert.verifyEquals(textValue, assignee);
			
			
			isControlExists = QTiumAutomation.isElementExists(IssueScreenEntity.Status);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(IssueScreenEntity.Label_StatusId);
			QTiumAssert.verifyEquals(textValue, status);
	}
	
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
			//QTiumAutomation.enter(IssueScreenEntity.Title, "Valid issue title");
		}else {
			QTiumAutomation.enter(IssueScreenEntity.Title, title);
		}
		
		if (description == null) {
			//QTiumAutomation.enter(IssueScreenEntity.Description, "valid issues description");			
		}else {
			QTiumAutomation.enter(IssueScreenEntity.Description, description);
		}

		if (priority != null) {			
			//QTiumAutomation.selectByVisibleText(IssueScreenEntity.Priority, priority);
			IssueScreenEntity.SelectSpinnerItem(IssueScreenEntity.Priority, priority);
		}
		else
		{
			//QTiumAutomation.selectByVisibleText(IssueScreenEntity.Priority, "Low");
			//IssueScreenEntity.SelectSpinnerItem(IssueScreenEntity.Priority, "Low");
		}

		if(component != null)
		{
			IssueScreenEntity.SelectSpinnerItem(IssueScreenEntity.Component, component);
			//QTiumAutomation.selectByVisibleText(IssueScreenEntity.Component, component);
		}
		else
		{
			//IssueScreenEntity.SelectSpinnerItem(IssueScreenEntity.Component, "TAMobile");
		}
		
		if (estimate == null) {
			//QTiumAutomation.enter(IssueScreenEntity.Estimate, "0");
		}
		else
		{
			QTiumAutomation.enter(IssueScreenEntity.Estimate, estimate);
		}

		if (spent == null) {
			//QTiumAutomation.enter(IssueScreenEntity.Spent, "0");
		}
		else
		{
			QTiumAutomation.enter(IssueScreenEntity.Spent, spent);
		}
		
		if (assignee == null) {
			//QTiumAutomation.enter(IssueScreenEntity.Assignee, "tam.pham");
		}
		else
		{
			QTiumAutomation.enter(IssueScreenEntity.Assignee, assignee);
		}
		
		if(status == null)
		{
			//IssueScreenEntity.SelectSpinnerItem(IssueScreenEntity.Status, "To Do");
		}
		else
		{
			IssueScreenEntity.SelectSpinnerItem(IssueScreenEntity.Status, status);
		}
		
	}

	public void CheckErrorMessageDisplayed(By element, String message){
		String text = QTiumAutomation.getText(element);
		QTiumAssert.verifyEquals(text, message);
		QTiumAutomation.click(IssueScreenEntity.MessageOK);
		
	}


	
}
