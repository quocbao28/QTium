package ScrumBoard;


import org.openqa.selenium.By;

import Common.Constants;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

public class DeleteIssuePage {
	
	public static synchronized DeleteIssuePage getPage()
	{
		if(instance == null)
			instance = new DeleteIssuePage();
		return instance;
	}
	
	
	//----------------------------------- business actions -----------------------------------

	//----------------------------------- check actions-----------------------------------
	
	public void CheckPageDisplayed()
	{
		boolean isPagedisplayed = QTiumAutomation.isPageDisplayed(DeleteIssuePageEntity.PageTitle);
		QTiumAssert.verifyEquals(isPagedisplayed, true);
	}
	
//	public void CheckErrorMessageDisplayed(By element, String message){
//		String text = QTiumAutomation.getText(element);
//		QTiumAssert.verifyEquals(text, message);
//		
//	}
		


	private static DeleteIssuePage instance = null;
	private String userName, password;

	
}
