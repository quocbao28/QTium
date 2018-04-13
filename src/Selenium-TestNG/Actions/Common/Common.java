package Common;

import java.io.File;

import com.logigear.selenium.QTiumSetting;

public class Common {

	public static void config() {
		// Configure browser to launch
		QTiumSetting.setObjecWait(15);
		/*QTiumSetting.setChromeDriverExecutable(new File("Resources","chromedriver.exe").getAbsolutePath());
		QTiumSetting.setIeDriverExecutable(new File("Resources","IEDriverServer.exe").getAbsolutePath());*/
		
	}

}
