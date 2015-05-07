package com.callision.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeFactory extends BrowserFactory {
	private static final Logger LOGGER = Logger.getLogger(ChromeFactory.class);

	@Override
	public WebDriver createBrowser(boolean acceptUntrustedCerts,
			boolean assumeUntrustedIssuer) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--disable-user-media-security=true");
		
		DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
		chromeCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,
				acceptUntrustedCerts);
		chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
		LOGGER.info("Chrome profile was created");
		String chromeBinary = System.getProperty(" ");
		String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
		if (chromeBinary == null || chromeBinary.equals("")) {
			chromeBinary = "src/main/resources/drivers/chromedriver-" + os
					+ (os.equals("win") ? ".exe" : "");
		}
		if (!os.equals("lin")) {
			System.setProperty("webdriver.chrome.driver", chromeBinary);
		}
		return new ChromeDriver(chromeCapabilities);
	}

	@Override
	public WebDriver createBrowser() {
		return new ChromeDriver();
	}
}