package FptShop;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

public class InstallmentBuyingPage {
	public static synchronized InstallmentBuyingPage getInstallmentBuyingPage()
	{
		if(instance == null)
			instance = new InstallmentBuyingPage();
		return instance;
	}
	
	private static InstallmentBuyingPage instance = null;
	
	public void selectInstallmentBuyingMethod(String installmentMethod) throws Exception {
		if(installmentMethod == "HOME") {
			QTiumAutomation.scrollPageToElement(InstallmentBuyingPageEntity.HOME_CREDIT_BUTTON);
			QTiumAutomation.click(InstallmentBuyingPageEntity.HOME_CREDIT_BUTTON);}
		else {
			QTiumAutomation.scrollPageToElement(InstallmentBuyingPageEntity.FE_CREDIT_BUTTON);
			QTiumAutomation.click(InstallmentBuyingPageEntity.FE_CREDIT_BUTTON);}
	}
	
	public void fillInformationInstallmentBuying(String clientName, String clientPhone, String clientId, String clientBirthDay, String clientBirthMonth,
			String clientBirthYear, int clientCity, int clientDistrict, String clientAddress, String clientGuarantorPhone) throws Exception {
		QTiumAutomation.enter(InstallmentBuyingPageEntity.CLIENT_NAME_TEXTBOX, clientName);
		QTiumAutomation.enter(InstallmentBuyingPageEntity.CLIENT_PHONE_NUMBER_TEXTBOX, clientPhone);
		QTiumAutomation.enter(InstallmentBuyingPageEntity.CLIENT_ID_TEXTBOX, clientId);
		QTiumAutomation.enter(InstallmentBuyingPageEntity.CLIENT_BIRTH_DAY_TEXTBOX, clientBirthDay);
		QTiumAutomation.enter(InstallmentBuyingPageEntity.CLIENT_BIRTH_MONTH_TEXTBOX, clientBirthMonth);
		QTiumAutomation.enter(InstallmentBuyingPageEntity.CLIENT_BIRTH_YEAR_TEXTBOX, clientBirthYear);
		QTiumAutomation.selectByIndex(InstallmentBuyingPageEntity.CLIENT_CITY_DROPDOWN, clientCity);
		QTiumAutomation.selectByIndex(InstallmentBuyingPageEntity.CLIENT_DICSTRICT_DROPDOWN, clientDistrict);
		QTiumAutomation.enter(InstallmentBuyingPageEntity.CLIENT_ADDRESS_TEXTBOX, clientAddress);
		QTiumAutomation.enter(InstallmentBuyingPageEntity.CLIENT_GUARANTOR_PHONE_NUMBER_TEXTBOX, clientGuarantorPhone);
		QTiumAutomation.scrollPageToElement(InstallmentBuyingPageEntity.ADD_ORDER_BUTTON);
		QTiumAutomation.click(InstallmentBuyingPageEntity.ADD_ORDER_BUTTON);
	}

	public void checkInstallmentBuyingResult() {		
		boolean isElementDisplayed = QTiumAutomation.isElementDisplayed(OrderResultPageEntity.SUCCESSFULLY_ORDER_LABEL);
		QTiumAssert.verifyTrue(isElementDisplayed);
	}
}
