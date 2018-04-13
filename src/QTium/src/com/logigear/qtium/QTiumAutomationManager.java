package com.logigear.qtium;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.logigear.qtium.driver.QTiumWebDriver;
import com.logigear.selenium.QTiumAutomation;


@Deprecated
public class QTiumAutomationManager {
//	private static ThreadLocal<QTiumAutomationData> _qtiumAutomationData = new ThreadLocal<QTiumAutomationData>();
	private static ThreadLocal<QTiumAutomation> _qtiumAutomation = new ThreadLocal<QTiumAutomation>();

	public static QTiumAutomation getAutomation(){
		//sessionId
		//TODO: check this attribute sessionId is ok for calling RemoteWebDriver.quit() only
		/*RemoteWebDriver remoteWebDriver = _qtiumAutomationData.get().getQTiumAutomation().getWebDriver();
		QTiumWebDriver qtiumWebDriver = _qtiumAutomationData.get().getQTiumAutomation().getQTiumDriver();
		
		boolean driverIsClosed = (remoteWebDriver != null) && (remoteWebDriver.getSessionId() == null);*/
		
		/*//driver is closed
		if((remoteWebDriver != null) && (remoteWebDriver.getSessionId() == null)){
			System.out.println("[info] QTiumAutomation::getAutomation - driver is closed!!");
			remoteWebDriver = null;
			//re-instance remote web driver 
			try {
				System.out.println("[info] QTiumAutomation::getAutomation - is creating RemoteWebDriver");
				qtiumWebDriver.createWebDriver();
			} catch (Exception e) {
				//TODO: need to re-factoring handle message here
				System.out.println("QTiumAutomationManager - exception: " + e.getMessage());
				//can not create RemoteWebDriver, so we returns null object QTiumAutomation here
				return null;
			} //end try-catch
		} //end if
*/		
//		return _qtiumAutomationData.get().getQTiumAutomation();
		return _qtiumAutomation.get();
	}

	/*public static void setAutomation(QTiumAutomationData automation) {
		_qtiumAutomationData.set(automation);
	}*/
	public static void setAutomation(QTiumAutomation automation) {
		_qtiumAutomation.set(automation);				
	}
	
	public static void remove() {
		_qtiumAutomation.remove();			
	}
}
