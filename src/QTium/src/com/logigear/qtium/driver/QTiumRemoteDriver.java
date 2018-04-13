package com.logigear.qtium.driver;

public abstract class QTiumRemoteDriver extends QTiumWebDriver {
	//default hub url 
	protected String _hubUrl = "http://localhost:4444/wd/hub";
	
	public void setHubUrl(String hubUrl){
		this._hubUrl = hubUrl;
	}	
	
	public void setHubInfo(String ip, String port){
		String _hubUrl = "http://%s:%s/wd/hub";
		this._hubUrl = String.format(_hubUrl, ip, port);
	}	
}
