package com.logigear.testng;

import java.io.File;
import java.net.URL;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.logigear.log4j.Log4jConstants;

public class QTiumTestSuiteListener implements ISuiteListener {

	private boolean _usingLog = false;
	private String _log4jConfigPath;

	@Override
	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ISuite suite) {
		readConfiguration(suite);

		if (_usingLog) {
			URL log4jURL = null;

			// get default
			if (_log4jConfigPath == null) {
				_log4jConfigPath = "/com/logigear/log4j/log4j.xml";
				log4jURL = this.getClass().getResource(_log4jConfigPath);
				if (log4jURL != null) {
					DOMConfigurator.configure(log4jURL);
				} // end if
			}else
				DOMConfigurator.configure(_log4jConfigPath);

			
		} // end if
	} // end method

	private void readConfiguration(ISuite suite) {
		String strUsingLog4j = suite.getParameter(Log4jConstants.PARAM_LOG4J);
		// _logPath = suite.getParameter(Log4jConstants.PARAM_QTIUM_LOG_PATH);

		if ((strUsingLog4j != null)
				&& (strUsingLog4j.trim().equalsIgnoreCase("1") 
						|| strUsingLog4j.trim().equalsIgnoreCase("true"))) {
			_usingLog = true;

			_log4jConfigPath = suite.getParameter(Log4jConstants.PARAM_LOG4J_CONFIG_PATH);
			
			if(_log4jConfigPath != null){
				File log4jConfigFile = new File(_log4jConfigPath);
				
				if(!log4jConfigFile.exists()){
					_log4jConfigPath = null;
				} //end if
				
			} //end if

		} else
			_usingLog = false;

	} // end method
}
