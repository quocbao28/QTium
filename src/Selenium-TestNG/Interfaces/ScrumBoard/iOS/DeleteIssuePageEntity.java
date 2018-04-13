package ScrumBoard.iOS;

import org.openqa.selenium.By;
import com.logigear.selenium.QTiumElementDefinition;

public class DeleteIssuePageEntity {
	public static String PageTitle = "Delete - QTium";
	
	public static By Accept = QTiumElementDefinition.Name("btnDelete");
	public static By Cancel = QTiumElementDefinition.Name("btnCancel");
	public static By DeleteMessageConfirm = QTiumElementDefinition.Xpath("html/body/div[1]/div[2]/h3");
	public static By Button_Create = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]");
	public static By Button_Edit = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	public static By Button_Done = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");
	public static By Button_Logout = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[4]");
	public static By TableView = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]");
	public static By Switch_Delete = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIASwitch[1]");
	public static By Button_Delete = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]");
	public static By AlertView = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]");
	public static By Tabbar_Todo = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]");
	public static By Tabbar_Inprogress = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[2]");
	public static By Tabbar_Done = QTiumElementDefinition.Xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[3]");
	
}
