package com.callision.service.cli.configs;

import com.callision.browser.Browsers;

public class BrowserConfig {

	private static Browsers browserType;
	
	public static Browsers getBrowserType() {
		return browserType;
	}

	public static void setBrowserType(Browsers type) {
		BrowserConfig.browserType = type;
	}

}
