package com.callision.driver.element;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;

import com.callision.driver.seleniumdriver.SeleniumDriver;


public class BrowserElement extends Element {

	protected SeleniumDriver driver;

	protected String foundBy;

	@Override
	public void setDriver(WebDriver driver) {
		Class<? extends WebDriver> driverClass = driver.getClass();
		if (!driverClass.equals(SeleniumDriver.class)) {
			throw new RuntimeException("Driver class " + driverClass
					+ " is invalid for BrowserElement");
		}
		this.driver = (SeleniumDriver) driver;
	}

	@Override
	public boolean isExists() {
		return driver.isElementExists(foundBy);
	}

	@Override
	public void waitForElement(long timeoutSeconds) {
		try {
			driver.waitForElement(foundBy, timeoutSeconds);
		} catch (NoSuchElementException e) {
			throw new RuntimeException("Failed to wait element "
					+ e.getMessage());
		}

	}

	public void waitImplicitly(int seconds) {
		driver.waitImplicitly(seconds);
	}

	@Override
	public String getFoundBy() {
		return foundBy;
	}

	@Override
	public void setFoundBy(String foundBy) {
		this.foundBy = foundBy;
	}

	@Override
	public void setFoundBy(int foundBy) {
		this.foundBy = String.valueOf(foundBy);
	}

	@Override
	public String getLocator() {
		return getFoundBy();
	}

	public void click() {
		driver.click(foundBy);
	}

	public void type(String text) {
		driver.type(foundBy, text);
	}

	public void clear() {
		driver.clear(foundBy);
	}

	public String getAttribute(String name) {
		return driver.getAttribute(foundBy, name);
	}

	public String getText() {
		return driver.getViewText(foundBy);
	}
	
}
