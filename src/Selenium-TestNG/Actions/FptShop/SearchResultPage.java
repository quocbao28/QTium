package FptShop;

import com.logigear.selenium.QTiumAutomation;

public class SearchResultPage {
	
	public static synchronized SearchResultPage getSearchResultPage()
	{
		if(instance == null)
			instance = new SearchResultPage();
		return instance;
	}
	
	private static SearchResultPage instance = null;
	
	public void selectItem(String itemName) {
		QTiumAutomation.scrollPageToElement(SearchResultPageEntity.ITEM_LINK, itemName);
		QTiumAutomation.click(SearchResultPageEntity.ITEM_LINK, itemName);
	}
}
