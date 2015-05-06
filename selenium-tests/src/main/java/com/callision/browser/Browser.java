package com.callision.browser;

import org.apache.log4j.Logger;

import com.callision.driver.seleniumdriver.SeleniumDriver;


/**
 * @author Aleksei_Mordas
 *
 */
public class Browser {

	private static final Logger LOGGER = Logger.getLogger(Browser.class);

	private static Browser instanceBrowser;

	private final SeleniumDriver driver;

	private Browser(String browserType) {
		driver = new SeleniumDriver(browserType);
	}

	public static Browser getInstance(String browserType) {
		if (instanceBrowser == null) {
			instanceBrowser = new Browser(browserType);
		}
		return instanceBrowser;
	}

	public void close() {
		driver.quit();
		instanceBrowser = null;
	}

	public SeleniumDriver getSeleniumDriver() {
		return driver;
	}

	public void get(String url) {
		LOGGER.info("Opening " + url);
		this.driver.get(url);
	}

	public void quit() {
		LOGGER.info("Browser quite");
		this.driver.quit();
	}
}
