package FptShop;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class ShippingPageEntity {
	
	public static By CLIENT_NAME_TEXTBOX = QTiumElementDefinition.Id("uname");
	public static By CLIENT_PHONE_TEXTBOX = QTiumElementDefinition.Id("uphone");
	public static By CLIENT_EMAIL_TEXTBOX = QTiumElementDefinition.Id("uemail");
	public static By CLIENT_CONTINUE_BUTTON = QTiumElementDefinition.Id("ubtn");
	
	public static By SHOP_TO_RECEIVE_RADIO = QTiumElementDefinition.Xpath("//div[@id='lisuggest']//li[1]");
	public static By SHIP_CONTINUE_BUTTON = QTiumElementDefinition.Id("shipconti");
	public static By SHIP_SKIP_BUTTON = QTiumElementDefinition.Id("shipignore");
	public static By ADD_ORDER_BUTTON = QTiumElementDefinition.Id("AddOrder");
}
