package Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.logigear.selenium.QTiumAutomation;

public class AndroidScreenEntity {
	public static By ByUIA(String by, String value) {
		String pattern = "new UiSelector().%s(\"%s\")";
		String full = String.format(pattern, by, value);
		
		return MobileBy.AndroidUIAutomator(full);
	}
	
	public static By ByUIA(String byParent, String valueParent, String byChild, String valueChild ) {
		String pattern = "new UiSelector().%s(\"%s\").childSelector(new UiSelector().%s(\"%s\"))";
		String full = String.format(pattern, byParent, valueParent, byChild,valueChild);
		
		return MobileBy.AndroidUIAutomator(full);
	}
	
	
	public static void SelectSpinnerItem(By parent, String item){
		QTiumAutomation.click(parent);
		QTiumAutomation.click(ByUIA("text", item));
	}
	
	
	
	
}
