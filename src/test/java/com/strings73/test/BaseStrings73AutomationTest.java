package com.strings73.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.strings73.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseStrings73AutomationTest {

	protected static String browserDriverPath = null;

	protected static Map<String, String> chromeDriverMap = new HashMap<String, String>();

	protected String loginURL = "https://aiplatform.73strings.com/platform/app-management/#/auth";

	private static final Logger logger = Logger.getLogger(BaseStrings73AutomationTest.class.getName());

	protected static WebDriver driver = null;

	protected LoginPage loginPage = null;

	protected static Properties testDataProp = null;

	protected static Properties expectedAssertionsProp = null;

	public static ThreadLocal<WebDriver> webDriverPool = new ThreadLocal<WebDriver>();

	@BeforeSuite
	@Parameters({ "siteURL" })
	public void initTestData(String siteURL) {

		if (siteURL != null) {
			this.loginURL = siteURL;
			chromeDriverMap.put("90", "src/main/resources/drivers/chromedriver90.exe");
			chromeDriverMap.put("89", "src/main/resources/drivers/chromedriver89.exe");
			chromeDriverMap.put("86", "src/main/resources/drivers/chromedriver86.exe");
			chromeDriverMap.put("87", "src/main/resources/drivers/chromedriver87.exe");
		}

		if (testDataProp == null) {
			FileReader testDataReader = null;
			FileReader assertionsReader = null;
			try {
				testDataReader = new FileReader("src/main/resources/testdata.properties");
				assertionsReader = new FileReader("src/main/resources/expectedassertions.properties");

				testDataProp = new Properties();
				testDataProp.load(testDataReader);

				expectedAssertionsProp = new Properties();
				expectedAssertionsProp.load(assertionsReader);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					testDataReader.close();
					assertionsReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		logger.debug("Site URL : " + this.loginURL);
	}

	/**
	 * This method is used for get driver
	 * 
	 * @param webDriver
	 * @return
	 */

	protected synchronized WebDriver getWebDriver(String browser) {
		logger.info("Starting of method getWebDriver");

		String osPath = System.getProperty("os.name");

		if (osPath.contains("Linux")) {

			if (browser.equalsIgnoreCase("Firefox")) {

				WebDriverManager.firefoxdriver().setup();

				FirefoxOptions options = new FirefoxOptions();

				options.setHeadless(true);

				options.addArguments("--no-sandbox");

				driver = new FirefoxDriver(options);

			} else if (browser.equalsIgnoreCase("Chrome")) {

				WebDriverManager.chromedriver().setup();

				ChromeOptions options = new ChromeOptions();

				options.setHeadless(true);

				options.addArguments("--no-sandbox");

				driver = new ChromeDriver(options);

			}

		} else if (osPath.contains("Mac OS X")) {

			browserDriverPath = "/usr/bin/safaridriver";

			if (browser.equalsIgnoreCase("Chrome")) {

				WebDriverManager.chromedriver().setup();

				driver = new ChromeDriver();

			} else if (browserDriverPath.contains("safaridriver")) {

				System.setProperty("webdriver.safari.driver", browserDriverPath);

				driver = new SafariDriver();

				logger.debug("Safari driver path " + browserDriverPath);

			}

		} else {

			if (browser.equalsIgnoreCase("Chrome")) {

				WebDriverManager.chromedriver().setup();

				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("Firefox")) {

				WebDriverManager.firefoxdriver().setup();

				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("Chromium")) {

				WebDriverManager.chromiumdriver().setup();

				driver = new EdgeDriver();

			} else if (browser.equalsIgnoreCase("IEDriverServer")) {

				WebDriverManager.iedriver().setup();

				driver = new InternetExplorerDriver();

			}
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		logger.info("***************** Driver Successfully Created **************** " + driver.getTitle());

		logger.info("End of method getWebDriver");

		webDriverPool.set(driver);

		return driver;

	}

	public static synchronized WebDriver getDriver() {

		return webDriverPool.get();

	}

	public void siteLogin(String userName, String password, WebDriver driver) throws Exception {
		logger.debug("Login URL " + loginURL);

		driver.get(loginURL);

		this.loginPage.loginToStrings(userName, password);

	}

	public void goToSite(WebDriver driver) throws Exception {
		logger.debug("Login URL" + loginURL);

		driver.get(loginURL);

	}

	/**
	 * This method is used for returning chrome browser version.
	 * 
	 * @param driverInfo
	 * @return
	 */
	public String getChromeDriverVersion(String driverInfo) {
		logger.info("Starting of getChromeDriverVersion method ");

		String tVersion = driverInfo.split("is")[2];

		tVersion = tVersion.split("with")[0];

		tVersion = (tVersion.split("\\.")[0]).trim();

		logger.debug("Chrome browser Version : " + tVersion);

		logger.info("Ending of getChromeDriverVersion method ");

		return tVersion;

	}

}
