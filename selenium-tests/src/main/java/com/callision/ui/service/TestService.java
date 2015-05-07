package com.callision.ui.service;

import com.callision.browser.DriverManager;
import com.callision.driver.page.PageFactory;
import com.callision.service.bo.User;
import com.callision.ui.pages.CallsTabPage;
import com.callision.ui.pages.LoginPage;
import com.callision.ui.pages.MainPage;

public class TestService {
	
	public void doLogin(User user) {
		LoginPage loginPage = PageFactory.initElements(DriverManager.getDriver(), LoginPage.class);
		loginPage.openPage().doLogin(user).checkPage();
	}
	
	public void callToNumber(String phoneNumber) {
		MainPage mainPage = PageFactory.initElements(DriverManager.getDriver(), MainPage.class);
		mainPage.openCallsTab();
		mainPage.callToNumber(phoneNumber);
	}

	
	public void answerOnTheCall() {
		MainPage mainPage = PageFactory.initElements(DriverManager.getDriver(), MainPage.class);
		mainPage.answerOnTheCall();
	}
	
	public int getActiveCallsNumber() {
		MainPage mainPage = PageFactory.initElements(DriverManager.getDriver(), MainPage.class);
		return mainPage.getCallNumbers();
	}
}
