package com.callision.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.callision.browser.DriverManager;
import com.callision.driver.seleniumdriver.SeleniumDriver;
import com.callision.ui.service.TestService;

public class BaseTest {

	protected SeleniumDriver driver1;
	protected TestService service;

	@BeforeClass(alwaysRun = true)
	public void suiteSetUp() {
		driver1 = DriverManager.getDriver();
	}

	@AfterClass(alwaysRun = true)
	public void suiteTearDown() {
		DriverManager.closeAllOpenedBrowsers();
	}
}
