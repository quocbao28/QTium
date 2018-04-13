package com.logigear.qtium;

import com.logigear.qtium.helper.xml.DeviceConfigItem;
import com.logigear.selenium.QTiumAutomation;

public class QTiumAutomationData {
	protected QTiumAutomation _automation;
	protected DeviceConfigItem _deviceConfigItem;
	
	public QTiumAutomationData(QTiumAutomation qtiumAutomation, DeviceConfigItem deviceConfigItem){
		_automation = qtiumAutomation;
		_deviceConfigItem = deviceConfigItem;
	}
	
	public QTiumAutomation getQTiumAutomation(){
		return _automation;
	}
	
	public DeviceConfigItem getDeviceConfigItem(){
		return _deviceConfigItem;
	}
}
