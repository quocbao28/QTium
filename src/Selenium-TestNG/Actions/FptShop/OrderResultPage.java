package FptShop;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

public class OrderResultPage {
	public static synchronized OrderResultPage getOrderResultPage()
	{
		if(instance == null)
			instance = new OrderResultPage();
		return instance;
	}
	
	private static OrderResultPage instance = null;
	
	public void checkOrderResult() {
		boolean isElementDisplayed = QTiumAutomation.isElementDisplayed(OrderResultPageEntity.SUCCESSFULLY_ORDER_LABEL);
		QTiumAssert.verifyTrue(isElementDisplayed);
	}
}
