package com.callision.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.callision.driver.annotation.FindBy;
import com.callision.driver.element.BrowserElement;
import com.callision.driver.page.Page;

public class MainPage extends Page {

	protected WebDriver driver;

	@FindBy(locator = "//div[@id='dialPad']")
	private BrowserElement dialPad;

	@FindBy(locator = "//div[@class='results']/div[contains(@class,'listing')]")
	private BrowserElement resultList;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void checkPage() {
		dialPad.waitForElement(ONE_MINUTE_WAIT);
	}

	public List<WebElement> getSearchedResults() {
		By by = By.xpath(resultList.getFoundBy());
		List<WebElement> list = driver.findElements(by);
		return list;
	}

}
