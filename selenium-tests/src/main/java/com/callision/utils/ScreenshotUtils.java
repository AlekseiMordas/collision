package com.callision.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenshotUtils {

	private static final String SCREENSHOTS = "screenshots";

	private static final Logger LOGGER = Logger
			.getLogger(ScreenshotUtils.class);

	private static final String DATE_FORMAT = "dd_MMM_yyyy__hh_mm_ssaa_SSS";

	private static String fileSeparator = System.getProperty("file.separator");

	public synchronized static void makeScreenshot(WebDriver driver,
			String fileName) {
		try {

			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

			File directory = new File("");
			directory = new File(directory.getAbsolutePath() + fileSeparator
					+ "test-output" + fileSeparator + "html" + fileSeparator
					+ SCREENSHOTS + fileSeparator);

			directory.mkdirs();

			fileName = fileName + "_" + dateFormat.format(date);

			File f = new File(directory, fileName + ".png");
			if (!f.exists()) {
				f.createNewFile();
			}

			byte[] scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.BYTES);

			try {
				FileUtils.writeByteArrayToFile(f, scrFile);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}

			String newFileNamePath = "<a href=\"" + SCREENSHOTS + "/"
					+ fileName + ".png" + "\">screenshot-" + fileName + "</a>";

			LOGGER.info(newFileNamePath);

		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
