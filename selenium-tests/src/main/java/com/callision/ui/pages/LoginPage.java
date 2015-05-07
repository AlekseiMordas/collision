package com.callision.ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.callision.browser.DriverManager;
import com.callision.driver.annotation.FindBy;
import com.callision.driver.element.BrowserElement;
import com.callision.driver.page.Page;
import com.callision.driver.page.PageFactory;
import com.callision.service.bo.User;

public class LoginPage extends Page {

	private static final Logger LOGGER = Logger.getLogger(LoginPage.class);
	private static final String URL_PAGE = "https://example.callision.com/";

	@FindBy(locator = "//input[@id='login']")
	private BrowserElement usernameInput;

	@FindBy(locator = "//input[@id='password']")
	private BrowserElement passwordInput;

	@FindBy(locator = "//*[@id='submit']")
	private BrowserElement loginButton;
	
	private final String PROGRESS_INDICATOR = "//body//*[contains(@class,'progress-bar')]";

	public LoginPage() {
		super();
	}

	public LoginPage openPage() {
		driver.get(URL_PAGE);
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public MainPage doLogin(User user) {
		usernameInput.type(user.getUsername());
		passwordInput.type(user.getPassword());
		loginButton.click();
	//driver.waitForElementDissappear(PROGRESS_INDICATOR, 60);
		return PageFactory.initElements(driver, MainPage.class);
	}

	@Override
	public void checkPage() {
		String title = driver.getTitle();
		if (title.equals("Callision Login")) {
			throw new RuntimeException("Invalid title. Actual: " + title);
		}
	}

}
