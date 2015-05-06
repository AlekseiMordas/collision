package com.callision.service.runner;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.IConfigurationListener;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.callision.browser.Browser;
import com.callision.service.cli.configs.BrowserConfig;
import com.callision.utils.ScreenshotUtils;



public class SuiteListener implements ISuiteListener, ITestListener,
		IConfigurationListener {

	private static final Logger LOGGER = Logger.getLogger(SuiteListener.class);


	@Override
	public void onTestFailure(ITestResult result) {
		ScreenshotUtils.makeScreenshot(Browser.getInstance(BrowserConfig.getBrowserType())
				.getSeleniumDriver().getDriver(), result
				.getTestContext().getName() + "_" + result.getName());
		LOGGER.info("================================== TEST "
				+ result.getName()
				+ " FAILED ==================================");
	}

	@Override
	public void onTestStart(ITestResult result) {

		LOGGER.info("================================== TEST "
				+ result.getName()
				+ " STARTED ==================================");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LOGGER.info("================================== TEST "
				+ result.getName()
				+ " SUCCESS ==================================");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LOGGER.info("================================== TEST "
				+ result.getName()
				+ " SKIPPED ==================================");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

	@Override
	public void onStart(ISuite suite) {

	}

	@Override
	public void onFinish(ISuite suite) {

		boolean isFailed = false;

		IResultMap failedConfigs;
		IResultMap failedTests;
		IResultMap skippedConfigs;
		IResultMap skippedTests;

		Map<String, ISuiteResult> suiteResults = suite.getResults();

		for (ISuiteResult res : suiteResults.values()) {
			failedConfigs = res.getTestContext().getFailedConfigurations();
			failedTests = res.getTestContext().getFailedTests();
			skippedConfigs = res.getTestContext().getSkippedConfigurations();
			skippedTests = res.getTestContext().getSkippedTests();

			if (failedConfigs.size() != 0 || failedTests.size() != 0
					|| skippedConfigs.size() != 0 || skippedTests.size() != 0) {
				isFailed = true;
				break;
			}
		}

		if (!isFailed && !suiteResults.isEmpty()) {
			BuildResult.setExitResult(BuildResult.SUCCESS);
		}
	}

	@Override
	public void onStart(ITestContext context) {
		LOGGER.info("================================== TEST "
				+ context.getName().toUpperCase()
				+ " STARTED ==================================");
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {

	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {

	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {

	}

}