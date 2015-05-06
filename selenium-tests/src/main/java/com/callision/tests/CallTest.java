package com.callision.tests;

import org.testng.annotations.Test;

import com.callision.browser.Browser;
import com.callision.service.UserFactory;

public class CallTest extends BaseTest {
	private Browser sBrowser;

	@Test
	public void makeCall() {
		service.doLogin(UserFactory.getFirstUser());
	}

}
