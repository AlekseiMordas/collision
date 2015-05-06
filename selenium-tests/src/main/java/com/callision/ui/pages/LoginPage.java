package com.callision.ui.pages;

import org.openqa.selenium.WebDriver;

import com.callision.driver.annotation.FindBy;
import com.callision.driver.element.BrowserElement;
import com.callision.driver.page.Page;
import com.callision.driver.page.PageFactory;
import com.callision.service.bo.User;

public class LoginPage extends Page {

	private static final String URL_PAGE = "https://example.callision.com/";

	protected WebDriver driver;

	@FindBy(locator = "//input[@id='login']")
	private BrowserElement usernameInput;

	@FindBy(locator = "//input[@id='password']")
	private BrowserElement passwordInput;

	@FindBy(locator = "//*[@id='submit']")
	private BrowserElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage openPage() {
		driver.get(URL_PAGE);
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public MainPage doLogin(User user) {
		usernameInput.type(user.getUsername());
		passwordInput.type(user.getPassword());
		loginButton.click();
		return new MainPage(driver);
	}

	@Override
	public void checkPage() {
		String title = driver.getTitle();
		if (title.equals("Callision Login")) {
			throw new RuntimeException("Invalid title. Actual: " + title);
		}
	}

}
