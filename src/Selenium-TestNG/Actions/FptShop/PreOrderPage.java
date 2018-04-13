package FptShop;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

public class PreOrderPage {
	public static synchronized PreOrderPage getPreOrderPage() {
		if (instance == null)
			instance = new PreOrderPage();
		return instance;
	}

	private static PreOrderPage instance = null;

	// click Order Now button & fill client info at PreOrderPage
	public void orderNow(String clientName, String clientPhone, String clientEmail) {
		QTiumAutomation.click(PreOrderPageEntity.BUY_NOW_BUTTON);
		QTiumAutomation.enter(PreOrderPageEntity.CLIENT_NAME_TEXTBOX, clientName);
		QTiumAutomation.enter(PreOrderPageEntity.CLIENT_PHONE_TEXTBOX, clientPhone);
		// QTiumAutomation.enter(PreOrderPageEntityCLIENT_EMAIL_TEXTBOX, clientEmail);
		QTiumAutomation.click(PreOrderPageEntity.SUBMIT_BUTTON);
	}

	// check PreOrder Successfully
	public void checkPreOrderResult() {
		QTiumAssert.verifyTrue(QTiumAutomation.isControlClickable(PreOrderPageEntity.SUCCESSFULLY_ORDER_OK_BUTTON));
	}
}
