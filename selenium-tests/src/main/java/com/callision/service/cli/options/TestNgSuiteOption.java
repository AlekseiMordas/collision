package com.callision.service.cli.options;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;

import com.callision.service.runner.TestNgParameters;


public class TestNgSuiteOption implements ICliOption {

	private static final String DEFAULT_SUITE = "testng.xml";

	private static final String SPLITTER = ",";

	@Override
	public void parse(String[] values) {
		values = values[0].split(SPLITTER);
		TestNgParameters.getInstance().setSuites(values);
	}

	@SuppressWarnings("static-access")
	@Override
	public Option getOption() {
		return OptionBuilder.withArgName("path_to_config").isRequired(false)
				.hasArgs().withLongOpt("testng")
				.withDescription("Path to TestNG config file").create("tng");
	}

	@Override
	public String[] getDefaultValue() {
		return new String[] { DEFAULT_SUITE };
	}

}
