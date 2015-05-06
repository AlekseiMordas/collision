package com.callision.ui.service;

import com.callision.driver.seleniumdriver.SeleniumDriver;
import com.callision.service.bo.User;
import com.callision.ui.pages.LoginPage;

public class TestService {
	private SeleniumDriver driver;

	public TestService(SeleniumDriver driver) {
		this.driver = driver;
	}

	public void doLogin(User user) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin(user).checkPage();
	}

}
