package FptShop;

import com.logigear.selenium.QTiumAutomation;

public class CategoryPage {
	public static synchronized CategoryPage getCategoryPage()
	{
		if(instance == null)
			instance = new CategoryPage();
		return instance;
	}
	
	private static CategoryPage instance = null;

	public void selectBanner(int indexOfBanner) {
		QTiumAutomation.moveMouseToElement(CategoryPageEntity.ACTIVATED_BANNER);
		for (int i = 1; i < indexOfBanner; i++) {
			QTiumAutomation.click(CategoryPageEntity.NEXT_BANNER_BUTTON);
		}
		QTiumAutomation.click(CategoryPageEntity.ACTIVATED_BANNER);
	}
}
