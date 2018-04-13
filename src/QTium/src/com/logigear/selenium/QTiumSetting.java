package com.logigear.selenium;

public class QTiumSetting {

	private static int objecWait = 60;
	/*private static String port;
	private static String ipAddress;
	private static boolean runWithGrid = false;
	private static String userBrowser = "IE";
	private static String ieDriverExecutable;
	private static String chromeDriverExecutable; 
	private static String platForm;
	private static String remoteAddress;*/
	
	/**
	 * Set time out for wait control, element. Default is 60 seconds
	 * @param objecWait: second
	 */
	public static void setObjecWait(int objecWait) {
		QTiumSetting.objecWait = objecWait;
	}
	public static int getObjecWait() {
		return objecWait;
	}
	/**
	 * Set browser to open include: Chrome, Firefox, IE.
	 * @param userBrowser
	 *//*
	protected static void setUserBrowser(String userBrowser) {
		QTiumSetting.userBrowser = userBrowser;
	}
	
	public static String getUserBrowser() {
		return userBrowser;
	}
	*//**
	 * Set path for IE Driver Executable (e.g: QTiumSetting.setIeDriverExecutable("C:\\IEDriverServer.exe");)
	 * @param ieDriverExecutable
	 *//*
	public static void setIeDriverExecutable(String ieDriverExecutable) {
		QTiumSetting.ieDriverExecutable = ieDriverExecutable;
	}
	*//**
	 * Get path of IE Driver Executable
	 * @return
	 *//*
	public static String getIeDriverExecutable() {
		return ieDriverExecutable;
	}
	*//**
	 * Set path for Chrome Driver Executable (e.g: QTiumSetting.setIeDriverExecutable("C:\\chromedriver.exe");)
	 * @param ieDriverExecutable
	 *//*
	public static void setChromeDriverExecutable(String chromeDriverExecutable) {
		QTiumSetting.chromeDriverExecutable = chromeDriverExecutable;
	}
	public static String getChromeDriverExecutable() {
		return chromeDriverExecutable;
	}
	protected static void setPort(String port) {
		QTiumSetting.port = port;
	}
	public static String getPort() {
		return port;
	}
	protected static void setIpAddress(String ipAddress) {
		QTiumSetting.ipAddress = ipAddress;
	}
	public static String getIpAddress() {
		return ipAddress;
	}
	protected static void setRunWithGrid(boolean runWithGrid) {
		QTiumSetting.runWithGrid = runWithGrid;
	}
	public static boolean isRunWithGrid() {
		return runWithGrid;
	}
	protected static void setPlatForm(String platForm) {
		QTiumSetting.platForm = platForm;
	}
	public static String getPlatForm() {
		return platForm;
	}
	protected static void setRemoteAddress(String remoteAddress) {
		QTiumSetting.remoteAddress = remoteAddress;
	}
	public static String getRemoteAddress() {
		return remoteAddress;
	}
*/	

}
