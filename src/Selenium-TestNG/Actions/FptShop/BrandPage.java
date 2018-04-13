package FptShop;

import com.logigear.selenium.QTiumAutomation;

public class BrandPage {

	public static synchronized BrandPage getBrandPage()
	{
		if(instance == null)
			instance = new BrandPage();
		return instance;
	}
	
	private static BrandPage instance = null;

	// select an item at BrandPage
	public void selectItem(String itemName) {		
		QTiumAutomation.click(BrandPageEntity.DYNAMIC_ITEM, itemName);
	}
}
