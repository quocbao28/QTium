package FptShop;

import com.logigear.selenium.QTiumAutomation;

public class ShippingPage {

	public static synchronized ShippingPage getShippingPage() {
		if (instance == null)
			instance = new ShippingPage();
		return instance;
	}

	private static ShippingPage instance = null;

	// fill client info
	public void fillClientInfo(String clientName, String clientPhone, String clientEmail) {
		QTiumAutomation.enter(ShippingPageEntity.CLIENT_NAME_TEXTBOX, clientName);
		QTiumAutomation.enter(ShippingPageEntity.CLIENT_PHONE_TEXTBOX, clientPhone);
		// QTiumAutomation.enter(ShippingPageEntity.CLIENT_EMAIL_TEXTBOX, clientEmail);
		QTiumAutomation.click(ShippingPageEntity.CLIENT_CONTINUE_BUTTON);
	}

	// select address
	public void selectPlaceToReceive() {
//		QTiumAutomation.click(ShippingPageEntity.SHOP_TO_RECEIVE_RADIO);
//		QTiumAutomation.click(ShippingPageEntity.SHIP_CONTINUE_BUTTON);
		QTiumAutomation.click(ShippingPageEntity.SHIP_SKIP_BUTTON);
	}

	// select payment
	public void selectPayment() {
		QTiumAutomation.click(ShippingPageEntity.ADD_ORDER_BUTTON);
	}

	// fill client info, select address & select payment
	public void selectShipping(String clientName, String clientPhone, String clientEmail) {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fillClientInfo(clientName, clientPhone, clientEmail);
		this.selectPlaceToReceive();
		this.selectPayment();
	}
}
