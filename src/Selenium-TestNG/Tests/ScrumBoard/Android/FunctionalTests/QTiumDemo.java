package ScrumBoard.Android.FunctionalTests;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Android.DashboardScreenEntity;
import Android.IssueScreenEntity;
import Android.LoginScreenEntity;
import Common.Common;
import Common.Constants;
import ScrumBoard.Android.DashboardScreen;
import ScrumBoard.Android.ScreenFactory;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

public class QTiumDemo {
	
	@BeforeClass
	public void set_up() throws Exception {
		Common.config();
	}

	@AfterMethod()
	public void after_test_case_execution() throws Exception {
		QTiumAutomation.close();
	}

	@Test(description = "Sign-In success")
	public void TC001_Sign_In_Layout() throws Exception {
		//ScreenFactory.LoginScreen().Open();
		QTiumAutomation.open();
		ScreenFactory.LoginScreen().CheckAllControls();
	}
	
	
	@Test(description = "User cannot sign in with invalid credentials")
	public void TC003_User_cannot_sign_in_with_invalid_credentials()
			throws Exception {

		// Signing in with invalid username displays the error message
		// "Incorrect user name or password"
		//ScreenFactory.LoginScreen().Open();
		QTiumAutomation.open();
		ScreenFactory.LoginScreen().Login(userName = "", password = "QTium123");

		ScreenFactory.LoginScreen().CheckErrorMessageDisplayed(
				LoginScreenEntity.LogInErrorMessage,
				message = "Enter your user name.");

		// Sign in with different data - special characters, un-registered
		// username & enter valid data for password

		ScreenFactory.LoginScreen().Login(userName = "`~!#$%^&*()_+|}{\\][:'?></,",
				password = "QTium123");

		ScreenFactory.LoginScreen().CheckErrorMessageDisplayed(
				LoginScreenEntity.LogInErrorMessage,
				message = "Incorrect user name or password.");

		ScreenFactory.LoginScreen().Login(userName = "testlogin",
				password = "QTium123");

		ScreenFactory.LoginScreen().CheckErrorMessageDisplayed(
				LoginScreenEntity.LogInErrorMessage,
				message = "Incorrect user name or password.");

		// Sign in without entering anything for password & enter valid data for
		// username

		ScreenFactory.LoginScreen().Login(userName = "tam.pham", password = "");

		ScreenFactory.LoginScreen().CheckErrorMessageDisplayed(
				LoginScreenEntity.LogInErrorMessage,
				message = "Enter your password.");

		// Sign in with different data - space, special characters for password
		// & enter valid data for username

		ScreenFactory.LoginScreen().Login(userName = "tam.pham",
				password = "`~!#$%^&*()_+|}{\\][:'?></,");

		ScreenFactory.LoginScreen().CheckErrorMessageDisplayed(
				LoginScreenEntity.LogInErrorMessage,
				message = "Incorrect user name or password.");

		ScreenFactory.LoginScreen().Login(userName = "tam.pham", password = " ");

		ScreenFactory.LoginScreen().CheckErrorMessageDisplayed(
				LoginScreenEntity.LogInErrorMessage,
				message = "Enter your password.");

		// Sign in with valid username but mismatched password

		ScreenFactory.LoginScreen().Login(userName = "tam.pham",
				password = "Pass1234");

		ScreenFactory.LoginScreen().CheckErrorMessageDisplayed(
				LoginScreenEntity.LogInErrorMessage,
				message = "Incorrect user name or password.");

		// Sign in with valid user name for password field and valid password
		// for user name field

		ScreenFactory.LoginScreen().Login(userName = "Pass1234",
				password = "tam.pham");

		ScreenFactory.LoginScreen().CheckErrorMessageDisplayed(
				LoginScreenEntity.LogInErrorMessage,
				message = "Incorrect user name or password.");
	}
	
	@Test(description = "Existing user can sign in successfully with valid credentials")
	public void TC004_Sign_in_successfully_with_valid_credentials()
			throws Exception {
		QTiumAutomation.open();

		ScreenFactory.LoginScreen().Login(userName = "tam.pham",
				password = "QTium123");

		ScreenFactory.LoginScreen().CheckLoginSuccess();;

	}
	
	
	@Test(description = "All components of the Create an Issue page are displayed as designed ")
	public void TC005_Create_Issue_Layout() throws Exception {
		QTiumAutomation.open();

		ScreenFactory.LoginScreen().Login();

		QTiumAutomation.click(DashboardScreenEntity.CreateIssue);

		ScreenFactory
		.CreateIssueScreen()
		.CheckAllControls(
				 "Title",
				"Description",
				"Priority",
				"Component",
				"Estimate",
				"Spent",
				"Assignee",
				"Status"
				);

	}
	
	@Test(description = "User cannot create a new issue with invalid inputs for required fields")
	public void TC006_Create_issue_with_invalid_inputs_for_required_fields()
			throws Exception {

		QTiumAutomation.open();

		ScreenFactory.LoginScreen().Login();

		QTiumAutomation.click(DashboardScreenEntity.CreateIssue);
		
		// 4
		
		ScreenFactory.CreateIssueScreen().FillIssueData(
				title = "",
				description = "For testing",
				priority = Constants.VALID_INPUT_VALUE,
				component = Constants.VALID_INPUT_VALUE,
				estimate = Constants.VALID_INPUT_VALUE,
				spent = Constants.VALID_INPUT_VALUE, 
				assignee = "tam.pham",
				status = Constants.VALID_INPUT_VALUE);
		
		QTiumAutomation.click(IssueScreenEntity.Save);

		ScreenFactory.CreateIssueScreen().CheckErrorMessageDisplayed(
				IssueScreenEntity.Message,
				message = "The Title field is required.");
		
		
		
		// 5
		
		// Click Submit with over 50 characters for Title &  valid inputs for Description and Assignee
		ScreenFactory.CreateIssueScreen().FillIssueData(
				title = Constants.STRING_GREATER_THAN_50_CHARACTERS,
				
				description = Constants.VALID_INPUT_VALUE,
				priority = Constants.VALID_INPUT_VALUE,
				component = Constants.VALID_INPUT_VALUE,
				estimate = Constants.VALID_INPUT_VALUE,
				spent = Constants.VALID_INPUT_VALUE, 
				assignee = Constants.VALID_INPUT_VALUE,
				status = Constants.VALID_INPUT_VALUE);
		
		QTiumAutomation.click(IssueScreenEntity.Save);
		
		ScreenFactory.CreateIssueScreen().CheckErrorMessageDisplayed(
				IssueScreenEntity.Message,
				message = "Title must not be over 50 characters.");
		
		
		// 6
		ScreenFactory.CreateIssueScreen().FillIssueData(
				title = "An internal request",
				description = "",
				priority = Constants.VALID_INPUT_VALUE,
				component = Constants.VALID_INPUT_VALUE,
				estimate = Constants.VALID_INPUT_VALUE,
				spent = Constants.VALID_INPUT_VALUE, 
				assignee = "tam.pham",
				status = Constants.VALID_INPUT_VALUE);
		
		QTiumAutomation.click(IssueScreenEntity.Save);

		ScreenFactory.CreateIssueScreen().CheckErrorMessageDisplayed(
				IssueScreenEntity.Message,
				message = "The Description field is required.");
		
		
		// 7
		
		/*ScreenFactory.CreateIssueScreen().FillIssueData(
				title = "An internal request",
				description = Constants.STRING_GREATER_THAN_500_CHARACTERS,
				priority = Constants.VALID_INPUT_VALUE,
				component = Constants.VALID_INPUT_VALUE,
				estimate = Constants.VALID_INPUT_VALUE,
				spent = Constants.VALID_INPUT_VALUE, 
				assignee = "tam.pham",
				status = Constants.VALID_INPUT_VALUE);
		
		QTiumAutomation.click(IssueScreenEntity.Save);

		ScreenFactory.CreateIssueScreen().CheckErrorMessageDisplayed(
				IssueScreenEntity.Message,
				message = "Description must not be over 500 characters.");*/
		
		
		// 8
		
		ScreenFactory.CreateIssueScreen().FillIssueData(
				title = "An internal request",
				description = "From QA team",
				priority = Constants.VALID_INPUT_VALUE,
				component = Constants.VALID_INPUT_VALUE,
				estimate = Constants.VALID_INPUT_VALUE,
				spent = Constants.VALID_INPUT_VALUE, 
				assignee = "",
				status = Constants.VALID_INPUT_VALUE);
		
		QTiumAutomation.click(IssueScreenEntity.Save);

		ScreenFactory.CreateIssueScreen().CheckErrorMessageDisplayed(
				IssueScreenEntity.Message,
				message = "The Assignee field is required.");
		

		//PageFactory.ScrumBoardPage().logOff();
	}

	@Test(description = "Existing User can create new issue sucessfully")
	public void TC007_Create_issue_with_valid_inputs_for_required_fields_successfully()
			throws Exception {
		/*PageFactory.LoginPage().Open();

		PageFactory.LoginPage().Login();

		if (cardId == "") {
			cardId = PageFactory.ScrumBoardPage().createScrumBoard(
					title = "Scrum Meeting Request",
					description = "all QA folks are invited to this meeting",
					priority = "Medium", component = "Database",
					estimate = "10", spent = "0", assignee = "tam.pham",
					status = "To Do");
		}
		System.out.println("C007 " + cardId);
		// VP
		PageFactory.ScrumBoardPage().checkIssueExists(cardId, true);

		// VP
		PageFactory.ScrumBoardPage().checkSummaryIssue(cardId,
				title = "Scrum Meeting Request",
				description = "all QA folks are invited to this meeting",
				estimate = "10.00", spent = "0.00", assignee = "tam.pham",
				component = "Database", priority = "Medium", status = "To Do");

		PageFactory.ScrumBoardPage().logOff();
		
		*/

		QTiumAutomation.open();

		ScreenFactory.LoginScreen().Login();

		QTiumAutomation.click(DashboardScreenEntity.CreateIssue);
		
		// 4
		
		ScreenFactory.CreateIssueScreen().FillIssueData(
				title = "Scrum Meeting Invitation",
				description = "all QA folks are invited to this meeting",
				priority = "Medium", component = "Database",
				estimate = "10", spent = "0", assignee = "tam.pham",
				status = "To Do");
		
		QTiumAutomation.click(IssueScreenEntity.Save);
		
		DashboardScreen.CheckListItemExist("Create new Card", "all QA folks are invited to this meeting");

		
	}

	@Test(description = "Existing User can edit an existing issue sucessfully")
	public void TC008_User_can_edit_existing_issue_successfully()
			throws Exception {
		QTiumAutomation.open();

		ScreenFactory.LoginScreen().Login();
		int rand = new Random().nextInt(50000);
		String currentTitle = "Card number #"+ rand;
		String currentDescription = "Card description for number #"+ rand; 
		//Create a card for editing
		QTiumAutomation.click(DashboardScreenEntity.CreateIssue);
		ScreenFactory.CreateIssueScreen().FillIssueData(
				title = currentTitle,
				description = currentDescription,
				priority = "Medium", 
				component = "Database",
				estimate = "10", 
				spent = "0", 
				assignee = "tam.pham",
				status = "To Do");
		
		QTiumAutomation.click(IssueScreenEntity.Save);
		
		DashboardScreen.CheckListItemExist(currentTitle, currentDescription);
		
		DashboardScreen.ClickListItem(currentTitle);
		
		
		QTiumAutomation.click(IssueScreenEntity.Edit);
		
		String newDescription = "This deciption is edited #"+ rand;
		
		//QTiumAutomation.clearTextField(IssueScreenEntity.Description);
		
		ScreenFactory.EditIssueScreen().FillIssueData(
				title = null,
				description = newDescription,
				priority = null, 
				component = null,
				estimate = null, 
				spent = null, 
				assignee = null,
				status = null);

		QTiumAutomation.click(IssueScreenEntity.SaveEdit);
		
		boolean isItemExist = DashboardScreen.CheckListItemExist(currentTitle, newDescription);
		
		QTiumAssert.verifyTrue(isItemExist);
		
	}
	
	@Test(description = "Existing User can delete an existing issue sucessfully")
	public void TC009_User_can_delete_existing_issue_successfully()
			throws Exception {
	
		QTiumAutomation.open();
		
		ScreenFactory.LoginScreen().Login();

		DashboardScreen.ClickListItem("Scrum Meeting Invitation");
		
		QTiumAutomation.click(IssueScreenEntity.Delete);
		
		QTiumAutomation.click(IssueScreenEntity.DeleteConfirmButton);

		boolean isItemExist = DashboardScreen.CheckListItemExist("Scrum Meeting Invitation", "all QA folks are invited to this meeting");
		
		QTiumAssert.verifyTrue(!isItemExist);
	}
	

	@AfterClass
	public void tear_down() {
		//QTiumAutomation.closeBrowser();
	}

	String cardId = "";
	String userName, password, message;
	private String resolutionValue, typeValue, titleValue, descriptionValue,
			priorityValue, componentValue, estimateValue, spentValue,
			assigneeValue, statusValue;
	private String type, title, description, priority, component, estimate,
			spent, assignee, status;
	private String titleError, descriptionError, priorityError, componentError,
			estimateError, spentError, assigneeError, statusError;
	private By forResolution, forType, forTitle, forDescription, forPriority,
			forComponent, forEstimate, forSpent, forAssignee, forStatus;
}
