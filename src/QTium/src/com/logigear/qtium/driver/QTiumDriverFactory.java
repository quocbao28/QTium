package com.logigear.qtium.driver;

import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.Iterator;

import com.logigear.qtium.helper.ClassLoaderHelper;
import com.logigear.qtium.helper.ReflectionHelper;
import com.logigear.qtium.helper.xml.DeviceConfigItem;

public class QTiumDriverFactory {
	public static QTiumWebDriver createInstance(DeviceConfigItem deviceConfigItem) throws InstantiationException, IllegalAccessException {
		QTiumWebDriver driver = null;
		String device = deviceConfigItem.getDevice();
		String provider = deviceConfigItem.getProvider();
		String appType = deviceConfigItem.getApptype();
		boolean isGrid = false;
		
		if(deviceConfigItem.getGridConfigItem() != null)
			isGrid = deviceConfigItem.getGridConfigItem().isUsingGrid();
		
		Class<?> driverClass;
		try {
			driverClass = ClassLoaderHelper.getDriverClass(device, provider, appType, isGrid);
			Object objDriver = driverClass.newInstance();
			//set all property
			Hashtable<String, String> providerProperties = deviceConfigItem.getProviderProperties();
			Iterator<String> keyIterator = providerProperties.keySet().iterator();
			while(keyIterator.hasNext()){
				String attr = keyIterator.next();
				String value = (String)providerProperties.get(attr);
				//14-Jul-2014 - fix bug
				String setFuncName = String.format("set%s", attr);
				ReflectionHelper.invokeFunctionStr(objDriver, setFuncName, value, true);
			}
			
			if(isGrid){
				ReflectionHelper.invokeFunctionEx(objDriver, "setHubInfo", deviceConfigItem.getGridConfigItem().getIp(), deviceConfigItem.getGridConfigItem().getPort());
			}
			
			/*ReflectionHelper.invokeFuntion(objDriver, "createWebDriver");*/
			driver = (QTiumWebDriver) objDriver;
		} catch (URISyntaxException e) {
			
		}
				
		return driver;
	}
}
