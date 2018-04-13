package com.logigear.qtium.driver.appium.android;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.logigear.qtium.QTiumConstants;
import com.logigear.qtium.driver.QTiumLocalDriver;

public class QTiumAndroidChromeLocalDriver extends QTiumLocalDriver {
	protected String _remoteAddress;

	public void setRemoteAddress(String remoteAddress) {
		this._remoteAddress = remoteAddress;
	}

	public QTiumAndroidChromeLocalDriver() {
	}

	@Override
	public String getDeviceName() {
		return QTiumConstants.DEVICE_ANDROID;
	} // end method

	@Override
	public String getProvider() {
		return "appium";
	}

	@Override
	public void createWebDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability(CapabilityType.PLATFORM, Platform.ANDROID);

		/*
		 * if (QTiumAutomation.getDriver() != null) { AppiumDriver driver =
		 * (AppiumDriver) QTiumAutomation.getDriver(); driver.quit(); }
		 */

		this._webDriver = new AppiumDriver(new URL(_remoteAddress),
				capabilities);

	}

	@Override
	public String getApplicationType() {
		return QTiumConstants.APP_TYPE_CHROME;
	}

} // end class
