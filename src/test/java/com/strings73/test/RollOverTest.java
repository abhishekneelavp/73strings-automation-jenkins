package com.strings73.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.strings73.pages.FundsPage;
import com.strings73.pages.InvestmentSummaryPage;
import com.strings73.pages.LoginPage;
import com.strings73.pages.LogoutPage;
import com.strings73.pages.OthersPage;
import com.strings73.pages.PortfolioSummaryPage;

public class RollOverTest extends BaseStrings73AutomationTest {

	private WebDriver rollOverDriver = null;

	private FundsPage fundsPage = null;

	private PortfolioSummaryPage portfolioSummaryPage = null;

	private InvestmentSummaryPage investmentsummaryPage = null;

	private OthersPage othersPage = null;

	private LogoutPage logoutPage = null;

	private static final Logger logger = Logger.getLogger(RollOverTest.class.getName());

	@BeforeClass
	@Parameters({ "userName", "password", "browser" })
	public void initStrings73Login(String userName, String password, String browser) throws Exception {
		logger.info("Starting of initStrings73Login method in RollOverTest");

		this.rollOverDriver = this.getWebDriver(browser);

		this.loginPage = new LoginPage(rollOverDriver);

		this.fundsPage = new FundsPage(rollOverDriver);

		this.portfolioSummaryPage = new PortfolioSummaryPage(rollOverDriver);

		this.investmentsummaryPage = new InvestmentSummaryPage(rollOverDriver);

		this.othersPage = new OthersPage(rollOverDriver);

		this.logoutPage = new LogoutPage(rollOverDriver);

		this.siteLogin(userName, password, rollOverDriver);

		logger.info("Ending of initStrings73Login method in RollOverTest");
	}

	@Test(priority = 1, description = "Navigating To Portfolio Summary Test")
	public void navigatingToPortfolioSummary() throws Exception {
		logger.info("Starting of navigatingToPortfolioSummary method");

		fundsPage.clickOnFund(testDataProp.getProperty("rollover.fund.name"));

		String actualText = fundsPage.getPortfolioSummaryText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("portfolio.summary"));

		logger.info("Ending of navigatingToPortfolioSummary method");
	}

	@Test(priority = 2, description = "Navigating To Invest Summary Page Test")
	public void navigatingToInvestSummaryPage() throws Exception {
		logger.info("Starting of navigatingToInvestSummaryPage method");

		portfolioSummaryPage.clickOnCompanyName(testDataProp.getProperty("rollover.company.name"));

		String actualText = portfolioSummaryPage.getCompanyNameText(testDataProp.getProperty("rollover.company.name"));
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("company.name"));

		logger.info("Ending of navigatingToInvestSummaryPage method");
	}

	@Test(priority = 3, description = "Navigating To Show Valuation Test")
	public void navigatingToShowValuation() throws Exception {
		logger.info("Starting of navigatingToShowValuation method");

		investmentsummaryPage.clickOnMenu();

		investmentsummaryPage.clickOnShowValuationDates();

		String actualText = investmentsummaryPage.getValuationAmountText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("valuation.amount"));

		logger.info("Ending of navigatingToShowValuation method");
	}

	@Test(priority = 4, description = "Starting of Roll Over Process Test")
	public void rollOver() throws Exception {
		logger.info("Starting of rollOver method");

		investmentsummaryPage.setRollOverDate(testDataProp.getProperty("rollover.future.valuation.year"),
				testDataProp.getProperty("rollover.future.valuation.month"),
				testDataProp.getProperty("rollover.future.valuation.date"));

		investmentsummaryPage.clickOnAdd();

		String actualText = investmentsummaryPage
				.getCompanyNameValuationIsInitiatedText(testDataProp.getProperty("rollover.company.name"));
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("company.name.valuation.is.initiated"));

		logger.info("Ending of rollOver method");
	}

	@Test(priority = 5, description = "Pop Up Window Test")
	public void popUpWindow() throws Exception {
		logger.info("Starting of popUpWindow method");

		try {
			
			investmentsummaryPage.clickOnOk();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		logger.info("Ending of popUpWindow method");
	}

	@Test(priority = 6, description = "Navigating to Application Preview Tab Test")
	public void navigatingToApplicationPreviewTab() throws Exception {
		logger.info("Starting of navigatingToApplicationPreviewTab method");

		investmentsummaryPage.clickOnEdit();

		logger.info("Ending of navigatingToApplicationPreviewTab method");
	}

	@Test(priority = 7, description = "Submitting Application")
	public void submitApplication() throws Exception {
		logger.info("Starting of submitApplication method");

		Thread.sleep(3000);

		othersPage.scrollDown(1000);

		othersPage.clickOnSubmit();

		String actualText = othersPage.getYourApplicationHasBeenSubmittedSuccessfullyText();
		Assert.assertEquals(actualText,
				expectedAssertionsProp.getProperty("your.application.has.been.submitted.successfully"));

		logger.info("Ending of submitApplication method");

	}

	@Test(priority = 8, description = "Navigating To Valuation")
	public void navigatingToValuationSummary() throws Exception {
		logger.info("Starting of navigatingToValuationSummary method");

		othersPage.clickOnOk();

		othersPage.impicitWait();

		String actualText = othersPage.getConcludedEnterpriseValueText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("concluded.enterprise.value"));

		logger.info("Ending of navigatingToValuationSummary method");
	}

	@Test(priority = 9, description = "Logout Test")
	public void logoutTest() throws Exception {
		logger.info("Starting of logoutTest method");

		logoutPage.impicitWait();

		logoutPage.clickOnLogoutIcon();

		String actualText = logoutPage.getLoginText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("login"));

		logger.info("Ending of logoutTest method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (rollOverDriver != null) {

				rollOverDriver.quit();

				logger.debug("Roll Over Driver quit successfully");
			}

		} catch (Exception ex) {

			logger.error(ex.getMessage());

		}
	}

}
