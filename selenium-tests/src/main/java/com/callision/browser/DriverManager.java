package com.callision.browser;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import com.callision.driver.seleniumdriver.SeleniumDriver;
import com.callision.service.cli.configs.BrowserConfig;


public class DriverManager {

	private static ThreadLocal<SeleniumDriver> defaultDriver = new ThreadLocal<SeleniumDriver>();
	private static List<SeleniumDriver> drivers = Collections
			.synchronizedList(new LinkedList<SeleniumDriver>());
	
	private static final Logger LOGGER = Logger.getLogger(DriverManager.class);

	/**
	 * Get default instance of {@link IDriver}
	 * 
	 * @return
	 */
	public static SeleniumDriver getDriver() {
		if (null == defaultDriver.get()) {
			getNewDriver();
		}
		return defaultDriver.get();
	}


	public static void setDefaultDriver(SeleniumDriver driver) {
		defaultDriver.set(driver);
	}

	
	/**
	 * Close default browser and create new one instance of {@link IDriver}
	 * 
	 * @return
	 */
	public static SeleniumDriver reopenDefaultDriver() {
		closeDefaultDriver();
		getDriver();
		return defaultDriver.get();
	}

	/**
	 * Close default driver
	 */
	public static void closeDefaultDriver() {
		SeleniumDriver current = defaultDriver.get();
		if (null != current) {
			current.close();
			current.quit();
			drivers.remove(current);
		}
		defaultDriver.set(null);
	}

	public static boolean isDefaultDriverOpened() {
		return null != defaultDriver.get();
	}

	/**
	 * Trying to call driver.quit()
	 * 
	 * @param driver
	 */
	private static void closeDriver(SeleniumDriver driver) {
		LOGGER.info(
				"Trying to close browser (driver.quit()): "+driver);
		try {
			if(driver!=null){
				driver.close();
				driver.quit();
				drivers.remove(driver);
			}
		} catch (WebDriverException exc) {
			if (exc.getMessage()
					.contains(
							"Error communicating with the remote browser. It may have died.")) {
				LOGGER.warn(exc.getMessage());
			} else {
				throw new RuntimeException(
						"Error while closing browser.", exc);
			}
		}
	}

	/**
	 * Create new {@link IDriver} instance
	 * 
	 * @param factory
	 * @param driverType
	 * @return
	 */
	public static SeleniumDriver getNewDriver() {
		LOGGER.info("Create new instance of Driver.");
		SeleniumDriver driver = new SeleniumDriver(BrowserConfig.getBrowserType());;
		drivers.add(driver);
		defaultDriver.set(driver);
		return driver;
	}

	/**
	 * Trying to close all opened during test executing browsers (driver
	 * instances)
	 */
	public static void closeAllOpenedBrowsers() {
		LOGGER.info("Close all opened during tests executing browsers");
		for (SeleniumDriver driver : drivers) {
			closeDriver(driver);
		}
	}

}