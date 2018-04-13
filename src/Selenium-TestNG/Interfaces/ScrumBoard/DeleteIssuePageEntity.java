package ScrumBoard;

import org.openqa.selenium.By;
import com.logigear.selenium.QTiumElementDefinition;

public class DeleteIssuePageEntity {
	public static String PageTitle = "Delete - QTium";
	
	public static By Accept = QTiumElementDefinition.Name("btnDelete");
	public static By Cancel = QTiumElementDefinition.Name("btnCancel");
	public static By DeleteMessageConfirm = QTiumElementDefinition.Xpath("html/body/div[1]/div[2]/h3");
}
