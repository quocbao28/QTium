package com.logigear.qtium.driver.selenium.pc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.logigear.qtium.QTiumConstants;
import com.logigear.qtium.driver.QTiumLocalDriver;
import com.logigear.selenium.QTiumSetting;

public class QTiumWindowsFirefoxLocalDriver extends QTiumLocalDriver {

	@Override
	public String getDeviceName() {
		return QTiumConstants.DEVICE_PC;
	}

	public QTiumWindowsFirefoxLocalDriver() {		
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
