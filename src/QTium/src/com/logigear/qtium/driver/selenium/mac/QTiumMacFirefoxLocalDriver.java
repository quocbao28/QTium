package com.logigear.qtium.driver.selenium.mac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.logigear.qtium.QTiumConstants;
import com.logigear.qtium.driver.QTiumLocalDriver;
import com.logigear.selenium.QTiumSetting;

public class QTiumMacFirefoxLocalDriver extends QTiumLocalDriver {

	@Override
	public String getDeviceName() {
		return QTiumConstants.DEVICE_MAC;
	}

	public QTiumMacFirefoxLocalDriver() {		
		System.out.println("QTiumWindowsFirefoxLocalDriver - ctor");
	}

	@Override
	public String getProvider() {
		return "selenium";
	}

	@Override
	public void createWebDriver() {
		try{
			this._webDriver = new FirefoxDriver();
		}catch(Exception ex){
			System.err.println("FireFox - createWebDriver - exception: " + ex.getMessage());
		}
		_webDriver.manage().timeouts().pageLoadTimeout(QTiumSetting.getObjecWait(), TimeUnit.SECONDS);		
	}
	
	@Override
	public String getApplicationType() {
		return QTiumConstants.APP_TYPE_FIREFOX;
	}
}
