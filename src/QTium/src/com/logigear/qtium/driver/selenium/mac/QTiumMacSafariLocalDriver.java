package com.logigear.qtium.driver.selenium.mac;

import org.openqa.selenium.safari.SafariDriver;

import com.logigear.qtium.QTiumConstants;
import com.logigear.qtium.driver.QTiumLocalDriver;

public class QTiumMacSafariLocalDriver extends QTiumLocalDriver {

	@Override
	public String getDeviceName() {
		return QTiumConstants.DEVICE_MAC;
	}

	public QTiumMacSafariLocalDriver() {

	} // end method

	@Override
	public String getProvider() {
		return "selenium";
	}

	@Override
	public void createWebDriver() {
		try {
			this._webDriver = new SafariDriver();
		} catch (Exception ex) {
			System.err.println("Safari - createWebDriver - exception: "
					+ ex.getMessage());
		}
		System.out.println("[info] Safari driver is created.");
	}

	@Override
	public String getApplicationType() {
		return QTiumConstants.APP_TYPE_CHROME;
	}
} // end class
