package com.callision.driver.seleniumdriver;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.callision.browser.Browsers;
import com.callision.browser.FirefoxFactory;

/**
 * @author Aleksei_Mordas
 * 
 */
public class SeleniumDriver implements WebDriver {

	private static final Logger LOGGER = Logger.getLogger(SeleniumDriver.class);

	private WebDriver driver;

	private static final int WAIT_CUSTOM = 5;

	public SeleniumDriver(String browserType) {

		Browsers browserOption = Browsers.valueOf(browserType.toUpperCase());
		switch (browserOption) {
		case FF:
			driver = new FirefoxFactory().createBrowser(true, false);
			driver.manage().timeouts()
					.implicitlyWait(WAIT_CUSTOM, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;
		default:
			throw new EnumConstantNotPresentException(Browsers.class,
					browserOption.name());
		}

	}

	@Override
	public void close() {
		LOGGER.info("Browser will be closed");
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void waitImplicitly(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	@Override
	public void get(String url) {
		LOGGER.info("Opening " + url);
		this.driver.get(url);
	}

	@Override
	public WebElement findElement(By by) {
		LOGGER.info("Find element by " + by);
		return this.driver.findElement(by);
	}

	@Override
	public String getPageSource() {
		LOGGER.info("Getting page source");
		return this.driver.getPageSource();
	}

	@Override
	public void quit() {
		LOGGER.info("Browser quite");
		this.driver.quit();
	}

	@Override
	public Navigation navigate() {
		LOGGER.info("Browser navigate");
		return this.driver.navigate();
	}

	@Override
	public Options manage() {
		LOGGER.info("Browser manage");
		return this.driver.manage();
	}

	@Override
	public String getCurrentUrl() {
		LOGGER.info("Getting current URL");
		return this.driver.getCurrentUrl();
	}

	public void refresh() {
		LOGGER.info("Browser refresh");
		this.driver.navigate().refresh();
	}

	@Override
	public String getTitle() {
		LOGGER.info("Getting title");
		return driver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		LOGGER.info("Finding elements by locator: " + by);
		return driver.findElements(by);
	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void type(String locator, String text) {
		driver.findElement(By.xpath(locator)).sendKeys(text);
		LOGGER.info("Type text '" + text + "' ...");

	}

	public void click(String locator) {
		LOGGER.info("Clicking element '" + locator + "' ...");
		driver.findElement(By.xpath(locator)).click();
		LOGGER.info("Element '" + locator + "' clicked successfully");
	}

	public void clear(String locator) {
		LOGGER.info("Clear element '" + locator + "' ...");
		driver.findElement(By.xpath(locator)).clear();

	}

	public boolean isElementExists(String locator) {
		try {
			LOGGER.info("Check is element exist" + " ...");
			driver.findElement(By.xpath(locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getViewText(String locator) {
		LOGGER.info("Getting element text '" + locator + "' ...");
		return driver.findElement(By.xpath(locator)).getText();
	}

	public org.openqa.selenium.Dimension getSize(String locator) {
		LOGGER.info("Getting element size '" + locator + "' ...");
		return driver.findElement(By.xpath(locator)).getSize();
	}

	public void waitForElement(final String locator, long timeOutInSeconds) {
		LOGGER.info("Waiting for element '" + locator + "' exists during "
				+ timeOutInSeconds + "sec timeout ...");
		new WebDriverWait(driver, timeOutInSeconds)
				.until(new ExpectedCondition<Boolean>() {
					@Override
					public Boolean apply(WebDriver d) {
						try {
							return d.findElement(By.xpath(locator))
									.isDisplayed();
						} catch (NoSuchElementException e) {
							return false;
						}
					}
				});

	}

	public String getAttribute(String foundBy, String attribute) {
		return driver.findElement(By.xpath(foundBy)).getAttribute(attribute);
	}
}
