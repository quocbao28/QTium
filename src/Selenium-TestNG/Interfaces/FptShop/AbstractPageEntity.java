package FptShop;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class AbstractPageEntity {

	public static By SEARCH_TEXTBOX = QTiumElementDefinition.Xpath("//header//input");
	public static By SEARCH_BUTTON = QTiumElementDefinition.Xpath("//header//button");

	public static String DYNACMIC_CATEGORY = "//nav[@class='fs-menu']/div/ul/li/a[contains(text(),'%s')]";
	public static String DYNACMIC_BRAND = "//nav[@class='fs-menu']/div/ul/li/div/div/div/ul/li/a[contains(@title,'%s')]";
	
}
