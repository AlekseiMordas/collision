package com.callision.ui.service;

import com.callision.service.bo.User;
import com.callision.ui.pages.LoginPage;
import com.callision.ui.pages.MainPage;

public class TestService {
	
	public void doLogin(User user) {
		LoginPage loginPage = new LoginPage();
		loginPage.openPage().doLogin(user).checkPage();
	}
	
	public void callToNumber(String phoneNumber) {
		MainPage mainPage = new MainPage();
		mainPage.openCallsTab();
		mainPage.callToNumber(phoneNumber);
	}

}
