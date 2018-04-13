package FptShop;

import Common.Constants;

import com.logigear.selenium.QTiumAutomation;

import FptShop.AbstractPage;

public class HomePage extends AbstractPage {

	public static synchronized HomePage getHomePage() {
		if (instance == null)
			instance = new HomePage();
		return instance;
	}

	private static HomePage instance = null;

	// ----------------------------------- business actions
	// -----------------------------------

	public void Open() throws Exception {
		QTiumAutomation.openURL(Constants.FPTSHOP_URL);
	}
}
