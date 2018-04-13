package com.logigear.qtium.driver.selenium.pc;

import java.io.File;

import org.openqa.selenium.ie.InternetExplorerDriver;

import com.logigear.qtium.QTiumConstants;
import com.logigear.qtium.driver.QTiumLocalDriver;

public class QTiumWindowsIeLocalDriver extends QTiumLocalDriver {
	// TODO: hard code driver executable
	private String _ieDriverExecutable = "E:\\Workspace\\Eclipse workspace\\QTium Refactoring\\Selenium-TestNG\\Resources\\IEDriverServer.exe";

	public void setDriverExe(String driverExe) {
		this._ieDriverExecutable = driverExe;
	}

	@Override
	public String getDeviceName() {
		return QTiumConstants.DEVICE_PC;
	}

	public QTiumWindowsIeLocalDriver() {

	} // end method

	@Override
	public String getProvider() {
		return "selenium";
	}

	@Override
	public void createWebDriver() {
		File file = null;

		file = new File(_ieDriverExecutable);
		String sFile = file.getAbsolutePath();
		System.setProperty("webdriver.ie.driver", sFile);

		/*if(this._webDriver != null){
			System.out.println(">>>>>>>>>>> QTiumWindowsIeLocalDriver - driver is NOT NULL");
			if(this._webDriver.getSessionId() != null){
				this._webDriver.close();
				this._webDriver.quit();	
			}
			
		}*/
		
		if(this._webDriver == null){
			System.out.println("*** IE driver is NULL");
		}else{
			System.out.println("*** IE driver is NOT NULL");
		}
		this._webDriver = new InternetExplorerDriver();		
		
		System.out.println(">>>>>>>>>>> QTiumWindowsIeLocalDriver - driver is CREATED!!");
	}
	
	@Override
	public String getApplicationType() {
		return QTiumConstants.APP_TYPE_IE;
	}
	
} // end class
