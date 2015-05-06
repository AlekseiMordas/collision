package com.callision.service.cli.options;

import org.apache.commons.cli.Option;

import com.callision.browser.Browsers;
import com.callision.service.cli.configs.BrowserConfig;



public class BrowserTypeOption implements ICliOption {

	private final String DEFAULT_VALUE = Browsers.FF.getType();

	@Override
	public String[] getDefaultValue() {
		return new String[] { DEFAULT_VALUE };
	}

	@Override
	public Option getOption() {
		return new Option("browser", "browser", true, "Browser type");
	}

	@Override
	public void parse(String[] values) {
		BrowserConfig.setBrowserType(values[0].toUpperCase());

	}

}
