package com.logigear.qtium.driver.selenium.pc;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;

import com.logigear.qtium.QTiumConstants;
import com.logigear.qtium.driver.QTiumLocalDriver;

public class QTiumWindowsChromeLocalDriver extends QTiumLocalDriver {
	//TODO: hard code driver executable
	private String _chromeDriverExecutable;// = "E:\\Workspace\\Eclipse workspace\\QTium Refactoring\\Selenium-TestNG\\Resources\\chromedriver.exe";
	
	public void setDriverExe(String driverExe){
		this._chromeDriverExecutable = driverExe;
	}
	
	@Override
	public String getDeviceName() {
		return QTiumConstants.DEVICE_PC;
	}

	public QTiumWindowsChromeLocalDriver() {
		
	} //end method
	
	@Override
	public String getProvider() {
		return "selenium";
	}

	@Override
	public void createWebDriver() {
		File file = null;
		
		file = new File(_chromeDriverExecutable);
		String sFile = file.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", sFile);
		
		if(this._webDriver == null){
			System.out.println("*** Chrome driver is NULL");
		}else{
			System.out.println("*** Chrome driver is NOT NULL");
		}
		try{
			this._webDriver = new ChromeDriver();
		}catch(Exception ex){
			System.out.println("Chrome - createWebDriver - exception: " + ex.getMessage());
		}
		System.out.println("[info] Chrome driver is created.");
	}

	@Override
	public String getApplicationType() {
		return QTiumConstants.APP_TYPE_CHROME;
	}
} //end class
