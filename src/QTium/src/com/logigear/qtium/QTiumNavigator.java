package com.logigear.qtium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import com.logigear.qtium.driver.QTiumDriverManager;

public class QTiumNavigator {
	
	/**
	 * Open a web page or start native application on Max OS X
	 * @param url
	 * @throws Exception
	 */
	public static void open(String url) throws Exception{
		//TODO check the platform => throws warning
		//get exist WebDriver or create a new WebDriver
		WebDriver webDriver = QTiumDriverManager.getAndCheckWebDriver();
		webDriver.manage().window().setSize(new Dimension(1366, 768));
//		webDriver.manage().window().maximize();

		//use that driver to open new url
		webDriver.get(url);
		webDriver.manage().deleteAllCookies();
		Thread.sleep(3000);
	}
	
	/**
	 * Start native application on Android
	 * @param url
	 * @throws Exception
	 */
	public static void open() throws Exception{
		//TODO check the platform => throws warning
		//get exist WebDriver or create a new WebDriver
		
		/*WebDriver webDriver = */QTiumDriverManager.getAndCheckWebDriver();		
	}
}
