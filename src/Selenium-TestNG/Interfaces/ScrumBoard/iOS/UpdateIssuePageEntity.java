package ScrumBoard.iOS;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class UpdateIssuePageEntity {
	public static String PageTitle = "Edit Card - QTium";
	public static By TitleErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='Title']");
	public static By DescriptionErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='Description']");
	public static By EstimateErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='Estimate']");
	public static By AssigneeErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='Assignee']");
	public static By SpentErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='Spent']");
	public static By Submit = QTiumElementDefinition.Name("btnSubmit");
	public static By Cancel = QTiumElementDefinition.Name("btnCancel");
	
	public static By Title = MobileBy.IosUIAutomation(".tableViews()[0].cells()[1].textFields()[0]");
	public static By Description =MobileBy.IosUIAutomation(".tableViews()[0].cells()[2].textFields()[0]");
	public static By Priority = MobileBy.IosUIAutomation(".tableViews()[0].cells()[7].textFields()[0]");
	public static By Component = MobileBy.IosUIAutomation(".tableViews()[0].cells()[6].textFields()[0]");
	public static By Status = MobileBy.IosUIAutomation(".tableViews()[0].cells()[8].textFields()[0]");
	public static By Estimate = MobileBy.IosUIAutomation(".tableViews()[0].cells()[3].textFields()[0]");
	public static By Spent = MobileBy.IosUIAutomation(".tableViews()[0].cells()[4].textFields()[0]");
	public static By Assignee = MobileBy.IosUIAutomation(".tableViews()[0].cells()[\"Assignee\"].textFields()[0]");
	public static By Button_Edit = MobileBy.IosUIAutomation(".navigationBar().rightButton()");
	public static By Button_Done = MobileBy.IosUIAutomation(".navigationBar().rightButton()");
	
	//public static By Assignee = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIATextField[1]");
	//public static By Component = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[7]/UIATextField[1]");
	
	public static By Label_Id = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]");
	public static By Label_Title = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
	public static By Label_Description = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]");
	public static By Label_PriorityId = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[8]/UIAStaticText[1]");
	public static By Label_ComponentId = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[7]/UIAStaticText[1]");
	public static By Label_Estimate = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]");
	public static By Label_Spent = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIAStaticText[1]");
	public static By Label_Assignee = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIAStaticText[1]");
	public static By Label_StatusId = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[7]/UIAStaticText[1]");
	
	public static By Button_ChooseValue = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIAToolbar[1]/UIAButton[1]");
	public static By PickerView = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIAPicker[1]/UIAPickerWheel[1]");
}
