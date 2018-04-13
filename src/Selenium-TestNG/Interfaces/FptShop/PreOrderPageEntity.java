package FptShop;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class PreOrderPageEntity {
	public static By BUY_NOW_BUTTON = QTiumElementDefinition.Xpath("//a[contains(@class,'btnOrderX')]");
	public static By CLIENT_NAME_TEXTBOX = QTiumElementDefinition.Xpath("//input[@id='FullName']");
	public static By CLIENT_PHONE_TEXTBOX = QTiumElementDefinition.Xpath("//input[@id='Phone']");
	public static By CLIENT_EMAIL_TEXTBOX = QTiumElementDefinition.Xpath("//input[@id='Email']");
	public static By SUBMIT_BUTTON = QTiumElementDefinition.Xpath("//input[@type='submit']");
	
	public static By SUCCESSFULLY_ORDER_OK_BUTTON = QTiumElementDefinition.Xpath("//div[@class='fp-okinfo']//p[@class='pd-ftok']/span");
}
