package ScrumBoard;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class AbstractPageEntity {
	//-------------------------Interfaces of Login Page------------------------------
	
		public static By SEARCH_TEXTBOX = QTiumElementDefinition.Xpath("//header//input");
		public static By SEARCH_BUTTON = QTiumElementDefinition.Xpath("//header//button");
}
