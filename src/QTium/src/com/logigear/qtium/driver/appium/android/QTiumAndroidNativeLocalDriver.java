package com.logigear.qtium.driver.appium.android;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.logigear.qtium.QTiumConstants;
import com.logigear.qtium.driver.QTiumLocalDriver;

public class QTiumAndroidNativeLocalDriver extends QTiumLocalDriver {
	protected String _remoteAddress;
	protected String _appPackage;
	protected String _appActivity;
	protected String _version;
	protected String _deviceName;
	protected String _app;
	
	public void setRemoteAddress(String remoteAddress) {
		this._remoteAddress = remoteAddress;
	}
	
	public void setAppPackage(String appPackage) {
		this._appPackage = appPackage;
	}
	
	public void setAppActivity(String appActivity) {
		this._appActivity = appActivity;
	}

	public void setVersion(String version){
		_version = version;	
	}
	
	public void setDeviceName(String deviceName){
		_deviceName = deviceName;
	}
	
	public void setApp(String app){
		_app = app;
	}
	
	public QTiumAndroidNativeLocalDriver() {
	}

	
	@Override
	public String getDeviceName() {
		return QTiumConstants.DEVICE_ANDROID;
	} 

	@Override
	public String getProvider() {
		return "appium";
	}

	@Override
	public void createWebDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("appPackage", _appPackage);
		capabilities.setCapability("appActivity", _appActivity);
		capabilities.setCapability(CapabilityType.VERSION, _version);
		capabilities.setCapability("deviceName", _deviceName);
		capabilities.setCapability("app", _app);

		this._webDriver = new AppiumDriver(new URL(_remoteAddress),
				capabilities);
		if(_webDriver.getSessionId() == null){
			System.out.println("QTiumAndroidNativeLocalDriver - closed!");
		}else{
			System.out.println("QTiumAndroidNativeLocalDriver - OKKK!");
		}

	}

	@Override
	public String getApplicationType() {
		return QTiumConstants.APP_TYPE_NATIVE_APP;
	}

} // end class
