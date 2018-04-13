package ScrumBoard.iOS;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		}
		
		else if(!title.isEmpty()) {
			QTiumAutomation.enter(CreateIssuePageEntity.Title, title);
		}
		else{
			WebElement webElement = QTiumAutomation.getDriver().findElement(CreateIssuePageEntity.Title);
			webElement.clear();
		}
		if (description == null) {
			QTiumAutomation.enter(CreateIssuePageEntity.Description, "valid issues description");			
		}
		else if(!description.isEmpty()) {
			QTiumAutomation.enter(CreateIssuePageEntity.Description, description);
		}
		else{
			WebElement webElement = QTiumAutomation.getDriver().findElement(CreateIssuePageEntity.Description);
			webElement.clear();
		}
		if (estimate == null) {
			QTiumAutomation.enter(CreateIssuePageEntity.Estimate, "0");
		}
		else if(!estimate.isEmpty())
		{
			QTiumAutomation.enter(CreateIssuePageEntity.Estimate, estimate);
		}
		else{
			WebElement webElement = QTiumAutomation.getDriver().findElement(CreateIssuePageEntity.Estimate);
			webElement.clear();
		}
		if (spent == null) {
			QTiumAutomation.enter(CreateIssuePageEntity.Spent, "0");
		}
		
		else if(!spent.isEmpty())
		{
			QTiumAutomation.enter(CreateIssuePageEntity.Spent, spent);
		}
		else{
			WebElement webElement = QTiumAutomation.getDriver().findElement(CreateIssuePageEntity.Spent);
			webElement.clear();
		}
		if (assignee == null) {
			QTiumAutomation.enter(CreateIssuePageEntity.Assignee, "tam.pham");
		}
		else if(!assignee.isEmpty())
		{
			QTiumAutomation.enter(CreateIssuePageEntity.Assignee, assignee);
		}
		else{
			WebElement webElement = QTiumAutomation.getDriver().findElement(CreateIssuePageEntity.Assignee);
			webElement.clear();
		}
		if(component != null)
		{
			//QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Component, component);
			QTiumAutomation.click(CreateIssuePageEntity.Component);
			QTiumAutomation.enter(CreateIssuePageEntity.PickerView, component);
			QTiumAutomation.click(CreateIssuePageEntity.Button_ChooseValue);
		}
		else
		{
			//QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Component, "TAMobile");
			QTiumAutomation.click(CreateIssuePageEntity.Component);
			QTiumAutomation.enter(CreateIssuePageEntity.PickerView, "TAMobile");
			QTiumAutomation.click(CreateIssuePageEntity.Button_ChooseValue);
		}
		
		if (priority != null) {			
			//QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Priority, priority);
			QTiumAutomation.click(CreateIssuePageEntity.Priority);
			QTiumAutomation.enter(CreateIssuePageEntity.PickerView, priority);
			QTiumAutomation.click(CreateIssuePageEntity.Button_ChooseValue);
		}
		else
		{
			//QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Priority, "Low");
			QTiumAutomation.click(CreateIssuePageEntity.Priority);
			QTiumAutomation.enter(CreateIssuePageEntity.PickerView, "Low");
			QTiumAutomation.click(CreateIssuePageEntity.Button_ChooseValue);
		}

		if(status == null)
		{
			//QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Status, "To Do");
			QTiumAutomation.click(CreateIssuePageEntity.Status);
			QTiumAutomation.enter(CreateIssuePageEntity.PickerView, "To Do");
			QTiumAutomation.click(CreateIssuePageEntity.Button_ChooseValue);
		}
		else if(!status.isEmpty())
		{
			//QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Status, status);
			QTiumAutomation.click(CreateIssuePageEntity.Status);
			QTiumAutomation.enter(CreateIssuePageEntity.PickerView, status);
			QTiumAutomation.click(CreateIssuePageEntity.Button_ChooseValue);
		}
		
	}	
	void Sleep(long miliSecond){
		try {
			Thread.sleep(miliSecond);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void confirmErrorMessage(){
		QTiumAutomation.click(CreateIssuePageEntity.Button_Confirm_Message);
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
			textValue = QTiumAutomation.getAttribute(CreateIssuePageEntity.Label_Title,"name");
			QTiumAssert.verifyEquals(textValue, title);
		    
		    
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Description);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getAttribute(CreateIssuePageEntity.Label_Description,"name");
			QTiumAssert.verifyEquals(textValue, description);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Priority);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getAttribute(CreateIssuePageEntity.Label_PriorityId,"name");
			QTiumAssert.verifyEquals(textValue, priority);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Component);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getAttribute(CreateIssuePageEntity.Label_ComponentId,"name");
			QTiumAssert.verifyEquals(textValue, component);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Estimate);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getAttribute(CreateIssuePageEntity.Label_Estimate,"name");
			QTiumAssert.verifyEquals(textValue, estimate);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Spent);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getAttribute(CreateIssuePageEntity.Label_Spent,"name");
			QTiumAssert.verifyEquals(textValue, spent);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Assignee);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getAttribute(CreateIssuePageEntity.Label_Assignee,"name");
			QTiumAssert.verifyEquals(textValue, assignee);
			
			
			isControlExists = QTiumAutomation.isElementExists(CreateIssuePageEntity.Status);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getAttribute(CreateIssuePageEntity.Label_StatusId,"name");
			QTiumAssert.verifyEquals(textValue, status);
			
			
	
		
		
	}


	
}
