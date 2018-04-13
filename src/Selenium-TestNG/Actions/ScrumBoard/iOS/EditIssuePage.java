package ScrumBoard.iOS;


import java.util.HashMap;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.interactions.touch.Up;

import Common.Constants;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

import ScrumBoard.iOS.*;

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
			if(!title.isEmpty()||title!=null) {
				QTiumAutomation.enter(UpdateIssuePageEntity.Title, title);
			}
			if (!description.isEmpty()||description != null) {
				QTiumAutomation.enter(UpdateIssuePageEntity.Description,description);			
			}
			if (!estimate.isEmpty()||estimate != null) {
				QTiumAutomation.enter(UpdateIssuePageEntity.Estimate,estimate);
			}
			if(!spent.isEmpty()||spent!=null)
			{
				QTiumAutomation.enter(UpdateIssuePageEntity.Spent, spent);
			}
			if(!assignee.isEmpty()||assignee!=null)
			{
				WebElement element =  QTiumAutomation.getDriver().findElement(UpdateIssuePageEntity.Assignee);
				JavascriptExecutor js = (JavascriptExecutor)QTiumAutomation.getDriver();
				HashMap<String, Double> tapObject = new HashMap<String, Double>();
				tapObject.put("x", (double)element.getLocation().getX());
				tapObject.put("y", (double)element.getLocation().getY());
				tapObject.put("duration",0.1);
				js.executeScript("mobile: tap", tapObject);
				//js.executeScript("", arg1)
				//QTiumAutomation.click(UpdateIssuePageEntity.Assignee);
				//AppiumDriver driver = (AppiumDriver) QTiumAutomation.getDriver();
				//driver.executeScript("target.frontMostApp().mainWindow().tableViews()[0].cells()[\"Assignee\"].textFields()[0].tap();");
				
			}
			if(!component.isEmpty()||component != null)
			{
				//QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Component, component);
				QTiumAutomation.click(UpdateIssuePageEntity.Component);
				QTiumAutomation.enter(UpdateIssuePageEntity.PickerView, component);
				QTiumAutomation.click(UpdateIssuePageEntity.Button_ChooseValue);
			}
			
			if (!priority.isEmpty()||priority != null) {			
				//QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Priority, priority);
				QTiumAutomation.click(UpdateIssuePageEntity.Priority);
				QTiumAutomation.enter(UpdateIssuePageEntity.PickerView, priority);
				QTiumAutomation.click(UpdateIssuePageEntity.Button_ChooseValue);
			}
			if(!status.isEmpty()||priority!=null)
			{
				//QTiumAutomation.selectByVisibleText(CreateIssuePageEntity.Status, status);
				QTiumAutomation.click(UpdateIssuePageEntity.Status);
				QTiumAutomation.enter(UpdateIssuePageEntity.PickerView, status);
				QTiumAutomation.click(UpdateIssuePageEntity.Button_ChooseValue);
			}
		
	}	

	
	//----------------------------------- check actions-----------------------------------
	
	public void CheckPageDisplayed()
	{
		boolean isPagedisplayed = QTiumAutomation.isPageDisplayed(UpdateIssuePageEntity.PageTitle);
		QTiumAssert.verifyEquals(isPagedisplayed, true);
	}
	public void update(){
		QTiumAutomation.click(UpdateIssuePageEntity.Button_Edit);
	}
	public void edit(){
		QTiumAutomation.click(UpdateIssuePageEntity.Button_Done);
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
		    
			
		    isControlExists = QTiumAutomation.isElementExists(UpdateIssuePageEntity.Label_Title);
		    QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(UpdateIssuePageEntity.Label_Title);
			QTiumAssert.verifyEquals(textValue, title);
		    
		    
			isControlExists = QTiumAutomation.isElementExists(UpdateIssuePageEntity.Label_Description);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(UpdateIssuePageEntity.Label_Description);
			QTiumAssert.verifyEquals(textValue, description);
			
			
			isControlExists = QTiumAutomation.isElementExists(UpdateIssuePageEntity.Label_PriorityId);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(UpdateIssuePageEntity.Label_PriorityId);
			QTiumAssert.verifyEquals(textValue, priority);
			
			
			isControlExists = QTiumAutomation.isElementExists(UpdateIssuePageEntity.Label_ComponentId);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(UpdateIssuePageEntity.Label_ComponentId);
			QTiumAssert.verifyEquals(textValue, component);
			
			
			isControlExists = QTiumAutomation.isElementExists(UpdateIssuePageEntity.Label_Estimate);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(UpdateIssuePageEntity.Label_Estimate);
			QTiumAssert.verifyEquals(textValue, estimate);
			
			
			isControlExists = QTiumAutomation.isElementExists(UpdateIssuePageEntity.Label_Spent);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(UpdateIssuePageEntity.Label_Spent);
			QTiumAssert.verifyEquals(textValue, spent);
			
			
			isControlExists = QTiumAutomation.isElementExists(UpdateIssuePageEntity.Label_Assignee);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(UpdateIssuePageEntity.Label_Assignee);
			QTiumAssert.verifyEquals(textValue, assignee);
			
			
			isControlExists = QTiumAutomation.isElementExists(UpdateIssuePageEntity.Label_StatusId);
			QTiumAssert.verifyTrue(isControlExists);
			textValue = QTiumAutomation.getText(UpdateIssuePageEntity.Label_StatusId);
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
