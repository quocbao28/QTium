package ScrumBoard.iOS.FunctionalTests;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Common;
import Common.Constants;
import ScrumBoard.iOS.*;

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
	public void TC001_t() throws Exception {
		PageFactory.LoginPage().Open();
		QTiumAutomation.click(MobileBy.IosUIAutomation(".tableViews()[\"Empty list\"].cells()[\"Scrum Meeting Request, all QA folks are invited to this meeting\"]"));
		String Xpath = ".tableViews()[0].cells()[\"Title\", \"SubTitle\"]";
		Xpath =  Xpath.replace("SubTitle","all QA folks are invited to this meeting");
		Xpath = Xpath.replace("Title","Scrum Meeting Request");
		By Cell = MobileBy.IosUIAutomation(Xpath);
		QTiumAutomation.click(Cell);
		
	}
	
	@Test(description = "Sign-In Layout")
	public void TC001_Sign_In_Layout() throws Exception {
		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().CheckAllControls();
	}

	@Test(description = "Remember Me checkbox")
	public void TC002_Remember_Me_checkbox() throws Exception {

		/*// User DOES NOT sign in automatically when "Remember Me" Check box is
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
		PageFactory.ScrumBoardPage().logOff();*/

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
				LoginPageEntity.Label_Message_AlertView,
				message = "Enter your user name.");
		PageFactory.LoginPage().confirmMessage();
		// Sign in with different data - special characters, un-registered
		// username & enter valid data for password

		/*PageFactory.LoginPage().Login(userName = "`~!#$%^&*()_+|}{\\][:'?></,",
				password = "QTium123");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.LogInErrorMessage,
				message = "Incorrect user name or password.");*/

		PageFactory.LoginPage().Login(userName = "testlogin",
				password = "QTium123");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.Label_Message_AlertView,
				message = "Incorrect user name or password.");
		PageFactory.LoginPage().confirmMessage();
		// Sign in without entering anything for password & enter valid data for
		// username

		PageFactory.LoginPage().Login(userName = "tam.pham", password = "");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.Label_Message_AlertView,
				message = "Enter your password.");
		PageFactory.LoginPage().confirmMessage();
		// Sign in with different data - space, special characters for password
		// & enter valid data for username

		/*PageFactory.LoginPage().Login(userName = "tam.pham",
				password = "`~!#$%^&*()_+|}{\\][:'?></,");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.Label_Message_AlertView,
				message = "Incorrect user name or password.");*/

		PageFactory.LoginPage().Login(userName = "tam.pham", password = " ");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.Label_Message_AlertView,
				message = "Enter your password.");
		PageFactory.LoginPage().confirmMessage();
		// Sign in with valid username but mismatched password

		PageFactory.LoginPage().Login(userName = "tam.pham",
				password = "Pass1234");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.Label_Message_AlertView,
				message = "Incorrect user name or password.");
		PageFactory.LoginPage().confirmMessage();
		// Sign in with valid user name for password field and valid password
		// for user name field

		PageFactory.LoginPage().Login(userName = "Pass1234",
				password = "tam.pham");

		PageFactory.LoginPage().CheckErrorMessageDisplayed(
				LoginPageEntity.Label_Message_AlertView,
				message = "Incorrect user name or password.");
		PageFactory.LoginPage().confirmMessage();
	}

	@Test(description = "Existing user can sign in successfully with valid credentials")
	public void TC004_Sign_in_successfully_with_valid_credentials()
			throws Exception {
		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().Login(userName = "tam.pham",
				password = "QTium123");

		//PageFactory.ScrumBoardPage().CheckPageDisplayed();

		PageFactory.ScrumBoardPage().CheckUserProfileIsDisplayed(userName);

		PageFactory.ScrumBoardPage().logOff();
	}

	@Test(description = "All components of the Create an Issue page are displayed as designed ")
	public void TC005_Create_Issue_Layout() throws Exception {
		PageFactory.LoginPage().Open();

		PageFactory.LoginPage().Login();
		QTiumAutomation.waitForControl(ScrumBoardPageEntity.CreateIssue, 2000);
		QTiumAutomation.click(ScrumBoardPageEntity.CreateIssue);

		PageFactory
		.CreateIssuePage()
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
		
		// Post execution
		PageFactory.ScrumBoardPage().backToMain();
		PageFactory.ScrumBoardPage().logOff();
	}

	@Test(description = "User cannot create a new issue with invalid inputs for required fields")
	public void TC006_Create_issue_with_invalid_inputs_for_required_fields()
			throws Exception {

		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().Login();

		QTiumAutomation.click(ScrumBoardPageEntity.CreateIssue);
		//QTiumAutomation.isPageDisplayed(CreateIssuePageEntity.PageTitle);
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
		
		QTiumAutomation.click(CreateIssuePageEntity.Done);

		PageFactory.CreateIssuePage().CheckErrorMessageDisplayed(
				CreateIssuePageEntity.Label_Message_AlertView,"Create unsuccessful");
		PageFactory.CreateIssuePage().confirmErrorMessage();
		
		
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
		
		QTiumAutomation.click(CreateIssuePageEntity.Done);
		
		PageFactory.CreateIssuePage().CheckErrorMessageDisplayed(
				CreateIssuePageEntity.Label_Message_AlertView,
				"Create unsuccessful");
		PageFactory.CreateIssuePage().confirmErrorMessage();
		
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
		
		QTiumAutomation.click(CreateIssuePageEntity.Done);

		PageFactory.CreateIssuePage().CheckErrorMessageDisplayed(
				CreateIssuePageEntity.Label_Message_AlertView,
				"Create unsuccessful");
		PageFactory.CreateIssuePage().confirmErrorMessage();
		
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
		
		QTiumAutomation.click(CreateIssuePageEntity.Done);

		PageFactory.CreateIssuePage().CheckErrorMessageDisplayed(
				CreateIssuePageEntity.Label_Message_AlertView,
				"Create unsuccessful");
		PageFactory.CreateIssuePage().confirmErrorMessage();
		
		
		
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
		
		QTiumAutomation.click(CreateIssuePageEntity.Done);

		PageFactory.CreateIssuePage().CheckErrorMessageDisplayed(
				CreateIssuePageEntity.Label_Message_AlertView,
				"Create unsuccessful");
		PageFactory.CreateIssuePage().confirmErrorMessage();
		PageFactory.ScrumBoardPage().backToMain();
		PageFactory.ScrumBoardPage().logOff();
	}

	@Test(description = "Existing User can create new issue sucessfully")
	public void TC007_Create_issue_with_valid_inputs_for_required_fields_successfully()
			throws Exception {
		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().Login();
		QTiumAutomation.click(ScrumBoardPageEntity.CreateIssue);
		PageFactory.CreateIssuePage().FillIssueData(
					title = "Scrum Meeting Request",
					description = "all QA folks are invited to this meeting",
					priority = "Medium", component = "Database",
					estimate = "10", spent = "0", assignee = "tam.pham",
					status = "To Do");
		QTiumAutomation.click(CreateIssuePageEntity.Done);
		QTiumAutomation.click(ScrumBoardPageEntity.Tab_ToDo);
		// VP
		PageFactory.ScrumBoardPage().clickTableCell(title = "Scrum Meeting Request", description ="all QA folks are invited to this meeting");
		

		// VP
		PageFactory.ScrumBoardPage().checkSummaryIssue(
				title = "Scrum Meeting Request",
				description = "all QA folks are invited to this meeting",
				estimate = "10", spent = "0", assignee = "tam.pham",
				component = "Database", priority = "Medium", status = "To Do");
		PageFactory.ScrumBoardPage().backToMain();
		PageFactory.ScrumBoardPage().deleteCard(title = "Scrum Meeting Request", description= "all QA folks are invited to this meeting");
		PageFactory.ScrumBoardPage().logOff();
	}

	@Test(description = "Existing User can edit an existing issue sucessfully")
	public void TC008_User_can_edit_existing_issue_successfully()
			throws Exception {
		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().Login();
		QTiumAutomation.click(ScrumBoardPageEntity.CreateIssue);
		PageFactory.CreateIssuePage().FillIssueData(
					title = "Scrum Meeting Request",
					description = "all QA folks are invited to this meeting",
					priority = "Medium", component = "Database",
					estimate = "10", spent = "0", assignee = "tam.pham",
					status = "To Do");
		QTiumAutomation.click(CreateIssuePageEntity.Done);
		QTiumAutomation.click(ScrumBoardPageEntity.Tab_ToDo);
		// VP
		PageFactory.ScrumBoardPage().clickTableCell(title = "Scrum Meeting Request", description ="all QA folks are invited to this meeting");
		// VP
		PageFactory.ScrumBoardPage().checkSummaryIssue(
				title = "Scrum Meeting Request",
				description = "all QA folks are invited to this meeting",
				estimate = "10", spent = "0", assignee = "tam.pham",
				component = "Database", priority = "Medium", status = "To Do");
		//PageFactory.ScrumBoardPage().backToMain();
		//PageFactory.ScrumBoardPage().clickTableCell(title = "Scrum Meeting Request", description ="all QA folks are invited to this meeting");
		PageFactory.EditIssuePage().edit();
		
		// VP
		PageFactory
		.EditIssuePage()
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

		PageFactory.EditIssuePage().FillIssueData(
				title = "Scrum Meeting Invitation",
				description = "all QA folks are invited to this meeting",
				priority = "High", 
				component = "Function", 
				estimate = "5",
				spent = "5", 
				assignee = "",
				status = "To Do");
		PageFactory.EditIssuePage().update();

		PageFactory.ScrumBoardPage().clickTableCell(title = "Scrum Meeting Invitation", description ="all QA folks are invited to this meeting");

		// VP
		PageFactory.ScrumBoardPage().checkSummaryIssue(
				title = "Scrum Meeting Invitation",
				description = "all QA folks are invited to this meeting",
				estimate = "5.00", 
				spent = "5.00", 
				assignee = "tam.pham",
				component = "Function", 
				priority = "High", 
				status = "To Do");
		PageFactory.ScrumBoardPage().backToMain();
		PageFactory.ScrumBoardPage().deleteCard(title = "Scrum Meeting Invitation", description= "all QA folks are invited to this meeting");
		PageFactory.ScrumBoardPage().logOff();
	}

	@Test(description = "Existing User can delete an existing issue sucessfully")
	public void TC009_User_can_delete_existing_issue_successfully()
			throws Exception {
		PageFactory.LoginPage().Open();
		PageFactory.ScrumBoardPage().logOffIfLogin();
		PageFactory.LoginPage().Login();

		QTiumAutomation.click(ScrumBoardPageEntity.CreateIssue);
		PageFactory.CreateIssuePage().FillIssueData(
					title = "Scrum Meeting Request",
					description = "all QA folks are invited to this meeting",
					priority = "Medium", component = "Database",
					estimate = "10", spent = "0", assignee = "tam.pham",
					status = "To Do");
		QTiumAutomation.click(CreateIssuePageEntity.Done);
		QTiumAutomation.click(ScrumBoardPageEntity.Tab_ToDo);
		// VP
		PageFactory.ScrumBoardPage().clickTableCell(title = "Scrum Meeting Request", description ="all QA folks are invited to this meeting");
		// VP
		PageFactory.ScrumBoardPage().checkSummaryIssue(
				title = "Scrum Meeting Request",
				description = "all QA folks are invited to this meeting",
				estimate = "10", spent = "0", assignee = "tam.pham",
				component = "Database", priority = "Medium", status = "To Do");
		PageFactory.ScrumBoardPage().backToMain();
		
		PageFactory.ScrumBoardPage().deleteCard(title = "Scrum Meeting Request", description= "all QA folks are invited to this meeting");

		PageFactory.ScrumBoardPage().CheckAfterDelete(title= "Scrum Meeting Request", description= "all QA folks are invited to this meeting");
		
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
