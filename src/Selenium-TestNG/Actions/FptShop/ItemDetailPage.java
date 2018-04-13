package FptShop;

import com.logigear.selenium.QTiumAutomation;

public class ItemDetailPage {
	public static synchronized ItemDetailPage getItemDetailPage()
	{
		if(instance == null)
			instance = new ItemDetailPage();
		return instance;
	}
	
	private static ItemDetailPage instance = null;
	
	public void buyNow() {
		QTiumAutomation.click(ItemDetailPageEntity.BUYNOW_BUTTON);
	}
	
	public void installmentBuying() {
		QTiumAutomation.click(ItemDetailPageEntity.INSTALLMENT_BUYING_BUTTON);
	}
}
