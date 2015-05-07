package com.callision.ui.pages;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.callision.driver.annotation.FindBy;
import com.callision.driver.element.BrowserElement;
import com.callision.driver.page.Page;
import com.callision.driver.page.PageFactory;

public class MainPage extends Page {
	private static final Logger LOGGER = Logger.getLogger(MainPage.class);
	@FindBy(locator = "//body[not(contains(@style,'hidden'))]//*[@id='dialPad']/div/strong")
	private BrowserElement dialPad;
	
	@FindBy(locator = "//body//input[@id='dialNumF']")
	private BrowserElement dialNumberInput;
	
	@FindBy(locator = "//body//*[@id='dialEndCall']")
	private BrowserElement dialStartCallButton;
	
	@FindBy(locator = "//body//*[@class='calls_count']")
	private BrowserElement callsCountNumber;
	
	@FindBy(locator = "//body//*[@id='calls_tab']")
	private BrowserElement callsTab;
	
	@FindBy(locator = "//div[@class='results']/div[contains(@class,'listing')]")
	private BrowserElement resultList;
	
	@FindBy(locator = "//body[not(contains(@style,'hidden'))]//*[@class='inc-call-answer']")
	private BrowserElement answerOnTheCall;

	public MainPage() {
		super();
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
	
	public MainPage callToNumber(String phoneNumber) {
		dialPad.click();
		dialNumberInput.type(phoneNumber);
		dialStartCallButton.click();
		return PageFactory.initElements(driver, MainPage.class);
	}
	
	public CallsTabPage openCallsTab() {
		driver.getDriver().getWindowHandles().size();
		
		
		if(!callsTab.getAttribute("class").contains("active")){
			callsTab.click();
			waitForAjax();
		}
		return PageFactory.initElements(driver, CallsTabPage.class);
	}

	public MainPage answerOnTheCall() {
		try{
		answerOnTheCall.waitForElement(ONE_MINUTE_WAIT);}
		catch(RuntimeException ex){
			throw new RuntimeException("Call failed. There is no answer button");
		}
		answerOnTheCall.click();
		return PageFactory.initElements(driver, MainPage.class);
	}
	
	public int getCallNumbers() {
		return Integer.parseInt(callsCountNumber.getText().trim());
	}
	

}
