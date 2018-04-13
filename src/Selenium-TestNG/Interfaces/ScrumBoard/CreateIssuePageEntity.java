package ScrumBoard;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class CreateIssuePageEntity {
	
	public static String PageTitle = "Create issue - QTium";
	
	public static By TitleErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='Title']");
	public static By DescriptionErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='Description']");
	public static By PriorityErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='PriorityId']");
	public static By ComponentErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='ComponentId']");
	public static By EstimateErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='Estimate']");
	public static By SpentErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='Spent']");
	public static By AssigneeErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='Assignee']");
	public static By StatusErrorMessage = QTiumElementDefinition.Xpath("//span[@data-valmsg-for='StatusId']");
	
	
	public static By Label_Title = By.xpath("//label[@for='Title']");
	public static By Label_Description = By.xpath("//label[@for='Description']");
	public static By Label_PriorityId = By.xpath("//label[@for='PriorityId']");
	public static By Label_ComponentId = By.xpath("//label[@for='ComponentId']");
	public static By Label_Estimate = By.xpath("//label[@for='Estimate']");
	public static By Label_Spent = By.xpath("//label[@for='Spent']");
	public static By Label_Assignee = By.xpath("//label[@for='Assignee']");
	public static By Label_StatusId = By.xpath("//label[@for='StatusId']");
	

	public static By Id = QTiumElementDefinition.Name("Id");
	public static By Title = QTiumElementDefinition.Name("Title");	
	public static By Description = QTiumElementDefinition.Name("Description");
	public static By Priority = QTiumElementDefinition.Name("PriorityId");
	public static By Component = QTiumElementDefinition.Name("ComponentId");
	public static By Status = QTiumElementDefinition.Name("StatusId");
	public static By Estimate = QTiumElementDefinition.Name("Estimate");
	public static By Spent = QTiumElementDefinition.Name("Spent");
	public static By Assignee = QTiumElementDefinition.Name("Assignee");
	

	
	
	
	
	public static By Submit = QTiumElementDefinition.Name("btnSubmit");
	public static By Cancel = QTiumElementDefinition.Name("btnCancel");
	
}
