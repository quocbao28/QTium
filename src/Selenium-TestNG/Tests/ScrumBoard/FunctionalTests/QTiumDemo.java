package ScrumBoard.FunctionalTests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.Common;
import Common.Constants;
import ScrumBoard.CreateIssuePageEntity;
import ScrumBoard.DeleteIssuePageEntity;
import ScrumBoard.LoginPageEntity;
import ScrumBoard.PageFactory;
import ScrumBoard.ScrumBoardPageEntity;
import ScrumBoard.UpdateIssuePageEntity;

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

	 
	@Test(description = "Sign-In Layout")
	public void TC001_Sign_In_Layout() throws Exception {
		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().CheckAllControls();
	}

	@Test(description = "Remember Me checkbox")
	public void TC002_Remember_Me_checkbox() throws Exception {

		// User DOES NOT sign in automatically when "Remember Me" Check box is
		// unchecked

		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		QTiumAutomation.setCheckbox(LoginPageEntity.RememberMe, false);

		PageFactory.LoginPage().Login();

		QTiumAutomation.close();

		PageFactory.LoginPage().Open();

		// check User is landed on the Sign In page.
		PageFactory.LoginPage().CheckPageDisplayed();

		QTiumAutomation.close();
		// User DOES sign in automatically when "Remember Me" Check box is
		// checked

		PageFactory.LoginPage().Open();
		
		QTiumAutomation.setCheckbox(LoginPageEntity.RememberMe, true);

		PageFactory.LoginPage().Login();
		
		
		QTiumAutomation.close();

		PageFactory.LoginPage().Open();

		// Check 'User is automatically signed in and landed on the Qtium Scrum
		// Board page
		PageFactory.ScrumBoardPage().CheckPageDisplayed();

		// Post execution
		PageFactory.ScrumBoardPage().logOff();

	}

	@Test(description = "User cannot sign in with invalid credentials")
	public void TC003_User_cannot_sign_in_with_invalid_credentials()
			throws Exception {

		// Signing in with invalid username displays the error message
		// "Incorrect user name or password"
		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().Login(userName = "", password = "QTium123");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.UserNameErrorMessage,
				message = "Enter your user name.");

		// Sign in with different data - special characters, un-registered
		// username & enter valid data for password

		PageFactory.LoginPage().Login(userName = "`~!#$%^&*()_+|}{\\][:'?></,",
				password = "QTium123");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.LogInErrorMessage,
				message = "Incorrect user name or password.");

		PageFactory.LoginPage().Login(userName = "testlogin",
				password = "QTium123");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.LogInErrorMessage,
				message = "Incorrect user name or password.");

		// Sign in without entering anything for password & enter valid data for
		// username

		PageFactory.LoginPage().Login(userName = "tam.pham", password = "");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.PasswordErrorMessage,
				message = "Enter your password.");

		// Sign in with different data - space, special characters for password
		// & enter valid data for username

		PageFactory.LoginPage().Login(userName = "tam.pham",
				password = "`~!#$%^&*()_+|}{\\][:'?></,");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.LogInErrorMessage,
				message = "Incorrect user name or password.");

		PageFactory.LoginPage().Login(userName = "tam.pham", password = " ");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.PasswordErrorMessage,
				message = "Enter your password.");

		// Sign in with valid username but mismatched password

		PageFactory.LoginPage().Login(userName = "tam.pham",
				password = "Pass1234");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.LogInErrorMessage,
				message = "Incorrect user name or password.");

		// Sign in with valid user name for password field and valid password
		// for user name field

		PageFactory.LoginPage().Login(userName = "Pass1234",
				password = "tam.pham");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.LogInErrorMessage,
				message = "Incorrect user name or password.");
	}

	@Test(description = "Existing user can sign in successfully with valid credentials")
	public void TC004_Sign_in_successfully_with_valid_credentials()
			throws Exception {
		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().Login(userName = "tam.pham",
				password = "QTium123");

		PageFactory.ScrumBoardPage().CheckPageDisplayed();

		PageFactory.ScrumBoardPage().CheckUserProfileIsDisplayed(userName);

		PageFactory.ScrumBoardPage().logOff();
	}

	@Test(description = "All components of the Create an Issue page are displayed as designed ")
	public void TC005_Create_Issue_Layout() throws Exception {
		PageFactory.LoginPage().Open();

		PageFactory.LoginPage().Login();

		QTiumAutomation.click(ScrumBoardPageEntity.CreateIssue);

		PageFactory
		.CreateIssuePage()
		.CheckAllControls(
				 "Title",
				"Description",
				"Priority",
				"Component",
				"Estimate (Hour)",
				"Spent (Hour)",
				"Assignee",
				"Status"
				);

		// Post execution
		PageFactory.ScrumBoardPage().logOff();
	}

	@Test(description = "User cannot create a new issue with invalid inputs for required fields")
	public void TC006_Create_issue_with_invalid_inputs_for_required_fields()
			throws Exception {

		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().Login();

		QTiumAutomation.click(ScrumBoardPageEntity.CreateIssue);
		QTiumAutomation.isPageDisplayed(CreateIssuePageEntity.PageTitle);
		// 4
		
		PageFactory.CreateIssuePage().FillIssueData(
				title = "",
				description = "For testing",
				priority = Constants.VALID_INPUT_VALUE,
				component = Constants.VALID_INPUT_VALUE,
				estimate = Constants.VALID_INPUT_VALUE,
				spent = Constants.VALID_INPUT_VALUE, 
				assignee = "tam.pham",
				status = Constants.VALID_INPUT_VALUE);
		
		QTiumAutomation.click(CreateIssuePageEntity.Submit);

		PageFactory.CreateIssuePage().CheckErrorMessageDisplayed(
				CreateIssuePageEntity.TitleErrorMessage,
				message = "The Title field is required.");
		
		
		
		// 5
		
		// Click Submit with over 50 characters for Title &  valid inputs for Description and Assignee
		PageFactory.CreateIssuePage().FillIssueData(
				title = Constants.STRING_GREATER_THAN_50_CHARACTERS,
				
				description = Constants.VALID_INPUT_VALUE,
				priority = Constants.VALID_INPUT_VALUE,
				component = Constants.VALID_INPUT_VALUE,
				estimate = Constants.VALID_INPUT_VALUE,
				spent = Constants.VALID_INPUT_VALUE, 
				assignee = Constants.VALID_INPUT_VALUE,
				status = Constants.VALID_INPUT_VALUE);
		
		QTiumAutomation.click(CreateIssuePageEntity.Submit);
		
		PageFactory.CreateIssuePage().CheckErrorMessageDisplayed(
				CreateIssuePageEntity.TitleErrorMessage,
				message = "Title must not be over 50 characters.");
		
		
		// 6
		PageFactory.CreateIssuePage().FillIssueData(
				title = "An internal request",
				description = "",
				priority = Constants.VALID_INPUT_VALUE,
				component = Constants.VALID_INPUT_VALUE,
				estimate = Constants.VALID_INPUT_VALUE,
				spent = Constants.VALID_INPUT_VALUE, 
				assignee = "tam.pham",
				status = Constants.VALID_INPUT_VALUE);
		
		QTiumAutomation.click(CreateIssuePageEntity.Submit);

		PageFactory.CreateIssuePage().CheckErrorMessageDisplayed(
				CreateIssuePageEntity.DescriptionErrorMessage,
				message = "The Description field is required.");
		
		
		// 7
		
		PageFactory.CreateIssuePage().FillIssueData(
				title = "An internal request",
				description = Constants.STRING_GREATER_THAN_500_CHARACTERS,
				priority = Constants.VALID_INPUT_VALUE,
				component = Constants.VALID_INPUT_VALUE,
				estimate = Constants.VALID_INPUT_VALUE,
				spent = Constants.VALID_INPUT_VALUE, 
				assignee = "tam.pham",
				status = Constants.VALID_INPUT_VALUE);
		
		QTiumAutomation.click(CreateIssuePageEntity.Submit);

		PageFactory.CreateIssuePage().CheckErrorMessageDisplayed(
				CreateIssuePageEntity.DescriptionErrorMessage,
				message = "Description must not be over 500 characters.");
		
		
		
		
		// 8
		
		PageFactory.CreateIssuePage().FillIssueData(
				title = "An internal request",
				description = "From QA team",
				priority = Constants.VALID_INPUT_VALUE,
				component = Constants.VALID_INPUT_VALUE,
				estimate = Constants.VALID_INPUT_VALUE,
				spent = Constants.VALID_INPUT_VALUE, 
				assignee = "",
				status = Constants.VALID_INPUT_VALUE);
		
		QTiumAutomation.click(CreateIssuePageEntity.Submit);

		PageFactory.CreateIssuePage().CheckErrorMessageDisplayed(
				CreateIssuePageEntity.AssigneeErrorMessage,
				message = "The Assignee field is required.");
		

		PageFactory.ScrumBoardPage().logOff();
	}

	@Test(description = "Existing User can create new issue sucessfully")
	public void TC007_Create_issue_with_valid_inputs_for_required_fields_successfully()
			throws Exception {
		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().Login();

		if (cardId.isEmpty()) {
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
		cardId = "";
	}

	@Test(description = "Existing User can edit an existing issue sucessfully")
	public void TC008_User_can_edit_existing_issue_successfully()
			throws Exception {
		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().Login();

		if (cardId.isEmpty()) {
			cardId = PageFactory.ScrumBoardPage().createScrumBoard(
					title = "Scrum Meeting Request",
					description = "all QA folks are invited to this meeting",
					priority = "Medium", 
					component = "Database",
					estimate = "10", 
					spent = "0", 
					assignee = "tam.pham",
					status = "To Do");
		}

		// VP
		PageFactory.ScrumBoardPage().checkSummaryIssue(cardId,
				title = "Scrum Meeting Request",
				description = "all QA folks are invited to this meeting",
				estimate = "10.00", 
				spent = "0.00", 
				assignee = "tam.pham",
				component = "Database", 
				priority = "Medium", 
				status = "To Do");

		PageFactory.ScrumBoardPage().DoIssueAction(cardId, "Edit");

		// VP
		PageFactory.EditIssuePage().CheckPageDisplayed();

		PageFactory.CreateIssuePage().FillIssueData(
				title = "Scrum Meeting Invitation",
				description = "all QA folks are invited to this meeting",
				priority = "High", 
				component = "Function", 
				estimate = "5",
				spent = "5", 
				assignee = "huy.ly",
				status = "To Do");
		QTiumAutomation.click(UpdateIssuePageEntity.Submit);

		PageFactory.ScrumBoardPage().CheckPageDisplayed();

		// VP
		PageFactory.ScrumBoardPage().checkSummaryIssue(cardId,
				title = "Scrum Meeting Invitation",
				description = "all QA folks are invited to this meeting",
				estimate = "5.00", 
				spent = "5.00", 
				assignee = "huy.ly",
				component = "Function", 
				priority = "High", 
				status = "To Do");

		PageFactory.ScrumBoardPage().logOff();
		cardId = "";
	}

	@Test(description = "Existing User can delete an existing issue sucessfully")
	public void TC009_User_can_delete_existing_issue_successfully()
			throws Exception {
		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().Login();

		if (cardId.isEmpty()) {
			cardId = PageFactory.ScrumBoardPage().createScrumBoard(
					title = "Scrum Meeting Request",
					description = "all QA folks are invited to this meeting",
					priority = "Medium", component = "Database",
					estimate = "10", spent = "0", assignee = "tam.pham",
					status = "To Do");
		}
		PageFactory.ScrumBoardPage().DoIssueAction(cardId, "Delete");

		// VP
		PageFactory.DeleteIssuePage().CheckPageDisplayed();

		QTiumAutomation.click(DeleteIssuePageEntity.Accept);

		// VP
		PageFactory.ScrumBoardPage().CheckPageDisplayed();

		// VP
		PageFactory.ScrumBoardPage().checkIssueExists(cardId, false);
		cardId = "";

	}

	@AfterClass
	public void tear_down() {
		
		//QTiumAutomation.close();
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
