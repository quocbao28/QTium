package ScrumBoard;

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
}
