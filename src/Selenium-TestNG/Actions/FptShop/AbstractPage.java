package FptShop;

import com.logigear.selenium.QTiumAutomation;

public class AbstractPage {

	public static synchronized AbstractPage getAbstractPage() {
		if (instance == null)
			instance = new AbstractPage();
		return instance;
	}

	private static AbstractPage instance = null;

	// search for an item at HomePage
	public void searchItem(String itemName) {
		QTiumAutomation.enter(AbstractPageEntity.SEARCH_TEXTBOX, itemName);
		QTiumAutomation.click(AbstractPageEntity.SEARCH_BUTTON);
	}

	// hover mouse over a category at HomePage
	public void hoverOverCategory(String categoryName) {
		QTiumAutomation.moveMouseToElement(AbstractPageEntity.DYNACMIC_CATEGORY, categoryName);
	}

	// select a category at HomePage
	public void selectCategory(String categoryName) {
		QTiumAutomation.click(AbstractPageEntity.DYNACMIC_CATEGORY, categoryName);
	}

	// select a brand of a category
	public void selectBrand(String categoryName, String brandName) {
		this.hoverOverCategory(categoryName);
		QTiumAutomation.click(AbstractPageEntity.DYNACMIC_BRAND, brandName);
	}
}