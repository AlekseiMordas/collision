package com.callision.tests;

import org.testng.annotations.Test;

import com.callision.browser.Browsers;
import com.callision.browser.DriverManager;
import com.callision.service.UserFactory;
import com.callision.ui.service.TestService;

public class CallTest extends BaseTest {
	
	@Test
	public void makeCall() {
		service = new TestService();
		service.doLogin(UserFactory.getFirstUser());
		DriverManager.getNewDriver(Browsers.FF);
		service.doLogin(UserFactory.getSecondUser());
		DriverManager.setDefaultDriver(driver1);
		service.callToNumber("1001");
	}

}
