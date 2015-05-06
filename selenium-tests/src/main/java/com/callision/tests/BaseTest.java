package com.callision.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.callision.browser.Browser;
import com.callision.service.cli.configs.BrowserConfig;
import com.callision.ui.service.TestService;

public class BaseTest {

	protected Browser browser;
	protected TestService service;

	@BeforeClass(alwaysRun = true)
	public void suiteSetUp() {
		browser = Browser.getInstance(BrowserConfig.getBrowserType());
		service = new TestService(browser.getSeleniumDriver());
	}

	@AfterClass(alwaysRun = true)
	public void suiteTearDown() {
		browser.close();
	}
}
