package FptShop;

import com.logigear.selenium.QTiumAutomation;

public class CartPage {
	public static synchronized CartPage getCartPage()
	{
		if(instance == null)
			instance = new CartPage();
		return instance;
	}
	
	private static CartPage instance = null;
	
	public void checkOut() {
		QTiumAutomation.click(CartPageEntity.CHECKOUT_BUTTON);
	}
}
