package com.logigear.qtium.driver.appium.mac;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.logigear.qtium.QTiumConstants;
import com.logigear.qtium.driver.QTiumLocalDriver;

public class QTiumMacLocalDriver  extends QTiumLocalDriver {
	protected String _remoteAddress;
	protected String _appPath;
	@Override
	public String getDeviceName() {
		return QTiumConstants.DEVICE_MAC;
	}

	@Override
	public String getProvider() {
		return "appium";
	}

	public void setremoteaddress(String remoteaddress) {
		this._remoteAddress = remoteaddress;
	}
	public void setapppath(String apppath) {
		this._appPath = apppath;
	}
	@Override
	public void createWebDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.MAC);
		//capabilities.setCapability("app", _appPath);
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		//capabilities.setCapability(CapabilityType.PLATFORM, Platform.ANDROID);
		
		/*
		 * if (QTiumAutomation.getDriver() != null) { AppiumDriver driver =
		 * (AppiumDriver) QTiumAutomation.getDriver(); driver.quit(); }
		 */
		this._webDriver = new RemoteWebDriver(new URL(this._remoteAddress), capabilities);
		//this._webDriver.get(this._appPath);
		//this._webDriver.switchTo();
	}

	@Override
	public String getApplicationType() {
		return QTiumConstants.APP_TYPE_NATIVE_APP;
	}
}
