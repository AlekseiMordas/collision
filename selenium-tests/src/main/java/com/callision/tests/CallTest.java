package com.callision.tests;

import junit.framework.Assert;

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
		window2 = DriverManager.getNewDriver();
		service.doLogin(UserFactory.getSecondUser());
		DriverManager.setDefaultDriver(window1);
		service.callToNumber("1001");
		Assert.assertEquals(1, service.getActiveCallsNumber());
		DriverManager.setDefaultDriver(window2);
		service.answerOnTheCall();
		Assert.assertEquals(1, service.getActiveCallsNumber());
	}

}
