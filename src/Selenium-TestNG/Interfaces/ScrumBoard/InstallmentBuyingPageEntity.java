package ScrumBoard;

import org.openqa.selenium.By;

import com.logigear.selenium.QTiumElementDefinition;

public class InstallmentBuyingPageEntity {
	
	public static By HOME_CREDIT_BUTTON = QTiumElementDefinition.Xpath("//a[@class='tf-cmlink atModal tgs-1']");
	public static By FE_CREDIT_BUTTON = QTiumElementDefinition.Xpath("//a[@class='tf-cmlink atModal tgs-2']");
	
	public static By CLIENT_NAME_TEXTBOX = QTiumElementDefinition.Id("txtName");
	public static By CLIENT_PHONE_NUMBER_TEXTBOX = QTiumElementDefinition.Id("txtPhone");
	public static By CLIENT_ID_TEXTBOX = QTiumElementDefinition.Id("txtCmd");
	public static By CLIENT_BIRTH_DAY_TEXTBOX = QTiumElementDefinition.Id("num1");
	public static By CLIENT_BIRTH_MONTH_TEXTBOX = QTiumElementDefinition.Id("num2");
	public static By CLIENT_BIRTH_YEAR_TEXTBOX = QTiumElementDefinition.Id("num3");
	public static By CLIENT_CITY_DROPDOWN = QTiumElementDefinition.Id("sl-city");
	public static By CLIENT_DICSTRICT_DROPDOWN = QTiumElementDefinition.Id("sl-district");
	public static By CLIENT_ADDRESS_TEXTBOX = QTiumElementDefinition.Id("txtAddress");
	public static By CLIENT_GUARANTOR_PHONE_NUMBER_TEXTBOX = QTiumElementDefinition.Id("txtPhoneNumberGuarantor");
	public static By ADD_ORDER_BUTTON = QTiumElementDefinition.Id("AddOrderRecurring");
}
