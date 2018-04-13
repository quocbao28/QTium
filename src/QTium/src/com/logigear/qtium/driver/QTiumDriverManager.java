package com.logigear.qtium.driver;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.internal.Killable;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.remote.UnreachableBrowserException;

import com.logigear.qtium.QTiumConstants;

public class QTiumDriverManager {
	private static ThreadLocal<QTiumWebDriver> _qtiumWebDriver = new ThreadLocal<QTiumWebDriver>();

	protected static WebDriver getDriver() {
		return _qtiumWebDriver.get().getWebDriver();
	}

	public QTiumDriverManager() {
	}

	public static QTiumWebDriver getQTiumDriver() {
		return _qtiumWebDriver.get();
	}

	public static void setQTiumDriver(QTiumWebDriver driver) {
		_qtiumWebDriver.set(driver);
	}

	public static void removeDriver() {
		_qtiumWebDriver.remove();
	}

	/*public static void setQTiumDriver(DeviceConfigItem deviceConfigItem) {
		try {
			QTiumWebDriver qtiumDriver = QTiumLocalDriverFactory
					.createInstance(deviceConfigItem);
			setQTiumDriver(qtiumDriver);
		} catch (InstantiationException e) {
			// TODO Handle exception
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Handle exception
			e.printStackTrace();
		}
	}*/

	protected static boolean isBrowserStillOpen(WebDriver webDriver) {
		try {
			return ((RemoteWebDriver)webDriver).getSessionId() != null;
			/*webDriver.getTitle();
			return true;*/
		} catch (UnreachableBrowserException e) {
			return false;
		} catch (NoSuchWindowException e) {
			return false;
		} catch (SessionNotFoundException e) {
			return false;
		}
	}

	public static WebDriver getAndCheckWebDriver() throws Exception {
		WebDriver webDriver = getDriver();
		if (webDriver != null) {
			if (isBrowserStillOpen(webDriver)) {
				return webDriver;
			} else {
				System.out.println("Webdriver has been closed meanwhile. Let's re-create it.");
				closeWebDriver();
			}
		}

		getQTiumDriver().createWebDriver();
		return getDriver();
	}

	public static void closeWebDriver() {
		WebDriver webDriver = getDriver();
		//removeDriver();

		if (webDriver != null) {
			System.out.println(" === CLOSE WEBDRIVER: " + Thread.currentThread().getId() + " -> " + webDriver);

			try {
				
			/*	boolean isSafariOniOS = getQTiumDriver().getDeviceName().equalsIgnoreCase(QTiumConstants.DEVICE_IOS)
						&& getQTiumDriver().getApplicationType().equalsIgnoreCase(QTiumConstants.APP_TYPE_SAFARI);
				if(isSafariOniOS){
					webDriver.close();	
				}
				
				webDriver.quit();	*/
				//check WebDriver is quited before close or quit
				RemoteWebDriver remoteWebDriver = (RemoteWebDriver) webDriver;
				if(remoteWebDriver != null){
					if(remoteWebDriver.getSessionId() != null){
						boolean isSafariOniOS = getQTiumDriver().getDeviceName().equalsIgnoreCase(QTiumConstants.DEVICE_IOS)
								&& getQTiumDriver().getApplicationType().equalsIgnoreCase(QTiumConstants.APP_TYPE_SAFARI);
						if(isSafariOniOS){
							webDriver.close();	
						}
						
						webDriver.quit();	
					}					
				}
			} catch (UnreachableBrowserException ignored) {
				// It happens for Firefox. It's ok: browser is already closed.
			} catch (WebDriverException cannotCloseBrowser) {
				System.err.println("Cannot close browser normally: "
						+ cannotCloseBrowser.getMessage());
			} finally {
				killBrowser(webDriver);
				webDriver = null;
			}
		}
	}

	protected static void killBrowser(WebDriver webdriver) {
		if (webdriver instanceof Killable) {
			try {
				((Killable) webdriver).kill();
			} catch (Exception e) {
				System.err.println("Failed to kill browser " + webdriver + ':');
				e.printStackTrace();
			}
		}
	}
}
