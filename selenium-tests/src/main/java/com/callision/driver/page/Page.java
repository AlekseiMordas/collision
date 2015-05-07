package com.callision.driver.page;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.callision.browser.DriverManager;
import com.callision.driver.element.WaitConditions;
import com.callision.driver.seleniumdriver.SeleniumDriver;

public abstract class Page {
	protected static final int ONE_MINUTE_WAIT = 60000;
	protected static final int THREE_MINUTE_WAIT = 180000;
	private static final Logger LOGGER = Logger.getLogger(DriverManager.class);
	public abstract void checkPage();
	
	public SeleniumDriver driver;
	
	protected Page(){
		this.driver = DriverManager.getDriver();	
	}
	
	public void waitForAjax()
	{
		LOGGER.debug("Waiting for completing of all ajax requests");
		WebDriverWait wait = new WebDriverWait(driver.getDriver(), 60);
		wait.until(WaitConditions.ajaxToFinishLoading());
	}

}