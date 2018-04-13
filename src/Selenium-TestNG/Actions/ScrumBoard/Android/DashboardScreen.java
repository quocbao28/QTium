package ScrumBoard.Android;


import Android.DashboardScreenEntity;

import com.logigear.selenium.QTiumAssert;
import com.logigear.selenium.QTiumAutomation;

public class DashboardScreen {
	
	
	public static synchronized DashboardScreen getPage()
	{
		if(instance == null)
			instance = new DashboardScreen();
		return instance;
	}	
	
	
	public void CheckPageDisplayed()
	{
		String text = QTiumAutomation.getText(DashboardScreenEntity.BarTitle);
		QTiumAssert.verifyEquals(text, "ScrumBoard - Dashboard");

	}
	
	public static boolean CheckListItemExist(String title, String description){
		return DashboardScreenEntity.CheckListItemExist(title, description);
	}
	
	
	public static void ClickListItem(String title){
		DashboardScreenEntity.ClickListItem(title);
	}

	private static DashboardScreen instance = null;
	
}
