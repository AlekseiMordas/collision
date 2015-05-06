package com.callision.driver.element;

import org.openqa.selenium.WebDriver;

public abstract class Element {

	public abstract void setFoundBy(String foundBy);

	public abstract void setFoundBy(int index);

	public abstract void setDriver(WebDriver driver);

	public abstract boolean isExists();

	public abstract void waitForElement(long timeoutSeconds);

	public abstract String getLocator();

	public abstract String getFoundBy();

}