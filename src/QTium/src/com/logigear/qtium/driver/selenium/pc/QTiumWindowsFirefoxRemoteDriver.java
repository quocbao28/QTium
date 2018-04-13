package com.logigear.qtium.driver.selenium.pc;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.logigear.qtium.QTiumConstants;
import com.logigear.qtium.driver.QTiumRemoteDriver;

public class QTiumWindowsFirefoxRemoteDriver extends QTiumRemoteDriver {
	
	@Override
	public String getDeviceName() {
		return QTiumConstants.DEVICE_PC;
	}

	public QTiumWindowsFirefoxRemoteDriver() {

	} // end method

	@Override
	public String getProvider() {
		return "selenium";
	}

	@Override
	public void createWebDriver() throws MalformedURLException {
		Capabilities desiredCapabilities = DesiredCapabilities.firefox();
		
		this._webDriver = new RemoteWebDriver(new URL(_hubUrl),desiredCapabilities);
	}
	
	@Override
	public String getApplicationType() {
		return QTiumConstants.APP_TYPE_FIREFOX;
	}
	
} // end class
