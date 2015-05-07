package com.callision.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.callision.driver.annotation.FindBy;
import com.callision.driver.element.BrowserElement;
import com.callision.driver.page.Page;
import com.callision.driver.page.PageFactory;

public class MainPage extends Page {

	@FindBy(locator = "//*[@class='webphone']/*[@id='dialPad']//span")
	private BrowserElement dialPad;
	
	@FindBy(locator = "//input[@id='dialNumF']")
	private BrowserElement dialNumberInput;
	
	@FindBy(locator = "//*[@id='dialEndCall']")
	private BrowserElement dialStartCallButton;
	
	@FindBy(locator = "//*[@class='calls_count']")
	private BrowserElement callsCountNumber;
	
	@FindBy(locator = "//*[@id='calls_tab']")
	private BrowserElement callsTab;
	
	@FindBy(locator = "//div[@class='results']/div[contains(@class,'listing')]")
	private BrowserElement resultList;

	public MainPage() {
		super();
	}

	@Override
	public void checkPage() {
	//	dialPad.waitForElement(ONE_MINUTE_WAIT);
	}

	public List<WebElement> getSearchedResults() {
		By by = By.xpath(resultList.getFoundBy());
		List<WebElement> list = driver.findElements(by);
		return list;
	}
	
	public MainPage callToNumber(String phoneNumber) {
		dialPad.click();
		dialNumberInput.type(phoneNumber);
		dialStartCallButton.click();
		return PageFactory.initElements(driver, MainPage.class);
	}
	
	public CallsTabPage openCallsTab() {
		if(!callsTab.getAttribute("class").contains("active")){
			callsTab.click();
			waitForAjax();
		}
		return PageFactory.initElements(driver, CallsTabPage.class);
	}

	
	

}
