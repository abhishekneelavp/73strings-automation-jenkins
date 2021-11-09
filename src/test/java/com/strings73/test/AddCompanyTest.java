package com.strings73.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.strings73.pages.BidDetailsPage;
import com.strings73.pages.FundsPage;
import com.strings73.pages.GeneralDetailsPage;
import com.strings73.pages.HistoricalFinancialsPage;
import com.strings73.pages.InvestmentSummaryPage;
import com.strings73.pages.LoginPage;
import com.strings73.pages.LogoutPage;
import com.strings73.pages.OthersPage;
import com.strings73.pages.PortfolioSummaryPage;
import com.strings73.pages.ProjectedFinancialsPage;
import com.strings73.pages.SecondariesPage;
import com.strings73.pages.ValuationMethodsPage;

public class AddCompanyTest extends BaseStrings73AutomationTest {

	private WebDriver addCompanyDriver = null;

	private FundsPage fundsPage = null;

	private PortfolioSummaryPage portfolioSummaryPage = null;

	private InvestmentSummaryPage investmentsummaryPage = null;

	private GeneralDetailsPage generalDetailsPage = null;

	private HistoricalFinancialsPage historicalFinancialsPage = null;

	private ProjectedFinancialsPage projectedFinancialsPage = null;

	private ValuationMethodsPage valuationMethodsPage = null;

	private BidDetailsPage bidDetailsPage = null;

	private SecondariesPage secondariesPage = null;

	private OthersPage othersPage = null;

	private LogoutPage logoutPage = null;

	private static final Logger logger = Logger.getLogger(AddCompanyTest.class.getName());

	@BeforeClass
	@Parameters({ "userName", "password", "browser" })
	public void initStrings73Login(String userName, String password, String browser) throws Exception {
		logger.info("Starting of initStrings73Login method in AddCompanyTest");

		this.addCompanyDriver = this.getWebDriver(browser);

		this.loginPage = new LoginPage(addCompanyDriver);

		this.fundsPage = new FundsPage(addCompanyDriver);

		this.portfolioSummaryPage = new PortfolioSummaryPage(addCompanyDriver);

		this.investmentsummaryPage = new InvestmentSummaryPage(addCompanyDriver);

		this.generalDetailsPage = new GeneralDetailsPage(addCompanyDriver);

		this.historicalFinancialsPage = new HistoricalFinancialsPage(addCompanyDriver);

		this.projectedFinancialsPage = new ProjectedFinancialsPage(addCompanyDriver);

		this.valuationMethodsPage = new ValuationMethodsPage(addCompanyDriver);

		this.bidDetailsPage = new BidDetailsPage(addCompanyDriver);

		this.secondariesPage = new SecondariesPage(addCompanyDriver);

		this.othersPage = new OthersPage(addCompanyDriver);

		this.logoutPage = new LogoutPage(addCompanyDriver);

		this.siteLogin(userName, password, addCompanyDriver);

		logger.info("Ending of initStrings73Login method in AddCompanyTest");
	}

	@Test(priority = 1, description = "Login Test")
	public void loginTest() {
		logger.info("Starting of loginTest method");

		String actualTitle = this.loginPage.getWebsiteTitle(addCompanyDriver);
		Assert.assertEquals(actualTitle, expectedAssertionsProp.getProperty("73strings.title"));

		logger.info("Ending of loginTest method");
	}

	@Test(priority = 2, description = "Fund Name")
	public void fundName() {
		logger.info("Starting of fundName method");

		String actualTitle = this.loginPage.getJenkinsText();
		Assert.assertEquals(actualTitle, expectedAssertionsProp.getProperty("val.pitch"));

		logger.info("Ending of fundName method");
	}

	@Test(priority = 3, description = "Navigating To Portfolio Summary Test")
	public void navigatingToPortfolioSummary() throws Exception {
		logger.info("Starting of navigatingToPortfolioSummary method");

		fundsPage.clickOnFund(testDataProp.getProperty("addcompany.fund.name"));

		logger.info("Ending of navigatingToPortfolioSummary method");
	}

	@Test(priority = 4, description = "Add Company Test")
	@Parameters({ "deviceName" })
	public void addCompany(String deviceName) throws Exception {
		logger.info("Starting of addCompany method");

		portfolioSummaryPage.clickOnAddCompanyButton();

		portfolioSummaryPage.setCompanyName(testDataProp.getProperty("addcompany.new.company.name"));

		portfolioSummaryPage.setInvestmentDate(testDataProp.getProperty("addcompany.year"),
				testDataProp.getProperty("addcompany.month"), testDataProp.getProperty("addcompany.date"));

		portfolioSummaryPage.clickOnSave();

		portfolioSummaryPage.clickOnOk();

		logger.info("Ending of addCompany method");
	}

	@Test(priority = 5, description = "Navigating To Invest Summary Page Test")
	public void navigatingToInvestSummaryPage() throws Exception {
		logger.info("Starting of navigatingToInvestSummaryPage method");

		portfolioSummaryPage.clickOnCompanyName(testDataProp.getProperty("addcompany.company.name"));

		logger.info("Ending of navigatingToInvestSummaryPage method");
	}

	@Test(priority = 7, description = "Navigating To Show Valuation Dates Test")
	public void navigatingToShowValuationDates() throws Exception {
		logger.info("Starting of navigatingToShowValuationDates method");

		investmentsummaryPage.clickOnMenu();

		investmentsummaryPage.clickOnShowValuationDates();

		logger.info("Ending of navigatingToShowValuationDates method");
	}

	@Test(priority = 8, description = "Navigating To General Details Test")
	public void navigatingToGeneralDetails() throws Exception {
		logger.info("Starting of navigatingToGeneralDetails method");

		investmentsummaryPage.clickOnEdit();

		logger.info("Ending of navigatingToGeneralDetails method");
	}

	@Test(priority = 9, description = "Filling General Details Test")
	public void fillingGeneralDetails() throws Exception {
		logger.info("Starting of fillingGeneralDetails method");

		generalDetailsPage.setNameOfCompany(testDataProp.getProperty("addcompany.company.name"));

		generalDetailsPage.enterBusinessDescription(testDataProp.getProperty("addcompany.description"));

		generalDetailsPage.setHQCountry(testDataProp.getProperty("addcompany.hq.country"));

		generalDetailsPage.setWebsite(testDataProp.getProperty("addcompany.website"));

		generalDetailsPage.setCountry(testDataProp.getProperty("addcompany.country"));

		generalDetailsPage.setIndustry(testDataProp.getProperty("addcompany.industry"));

		generalDetailsPage.selectCurrency(testDataProp.getProperty("addcompany.currency"));

		generalDetailsPage.clickOnNext();

		logger.info("Ending of fillingGeneralDetails method");
	}

	@Test(priority = 10, description = "Filling Details In Historical Financials Test")
	public void fillingDetailsInhistoricalFinancials() throws Exception {
		logger.info("Starting of fillingDetailsInhistoricalFinancials method");

		historicalFinancialsPage.selectYearEndMonth();

		historicalFinancialsPage.selectTypeOfFinancials();

		historicalFinancialsPage.clickOnBrowse(testDataProp.getProperty("historical.excel.file.historical"));

		historicalFinancialsPage.clickOnNext();

		logger.info("Ending of fillingDetailsInhistoricalFinancials method");
	}

	@Test(priority = 11, description = "Filling Details In Projected Financials Test")
	public void fillingDetailsInProjectedFinancials() throws Exception {
		logger.info("Starting of fillingDetailsInProjectedFinancials method");

		projectedFinancialsPage.setDebtToEquity(testDataProp.getProperty("projected.debttoequity"));

		projectedFinancialsPage.selectYearEndMonth();

		projectedFinancialsPage.selectTypeOfFinancials();

		projectedFinancialsPage.clickOnBrowse(testDataProp.getProperty("projected.excel.file.projected"));

		projectedFinancialsPage.impicitWait();

		projectedFinancialsPage.clickOnNext();

		logger.info("Ending of fillingDetailsInProjectedFinancials method");
	}

	@Test(priority = 12, description = "Choosing Surplus Assets")
	public void choosingSurplusAssets() throws Exception {
		logger.info("Starting of choosingSurplusAssets method");

		othersPage.selectAnySurplus();

		othersPage.clickOnNext();

		String actualText = othersPage.getValidationTextForValuationMethodsText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("validation.text.for.valuation.methods"));

		logger.info("Ending of choosingSurplusAssets method");
	}

	@Test(priority = 13, description = "Selecting Valuation Methods Test")
	public void selectingValuationMethods() throws Exception {
		logger.info("Starting of selectingValuationMethods method");

		valuationMethodsPage.selectComparableTransactionApproach();

		valuationMethodsPage.selectComparableCompanyApproach();

		valuationMethodsPage.selectIncomeApproach();

		logger.info("Ending of selectingValuationMethods method");
	}

	@Test(priority = 14, description = "Last Funding Details Test")
	public void lastFundingDetails() throws Exception {
		logger.info("Starting of lastFundingDetails method");

		valuationMethodsPage.scrollDown(1000);

		valuationMethodsPage.clickOnNext();

		valuationMethodsPage.impicitWait();

		String actualText = valuationMethodsPage.getBidderNameText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("bidder.name"));

		logger.info("Ending of lastFundingDetails method");
	}

	@Test(priority = 15, description = "Bid Details Test")
	public void bidDetails() throws Exception {
		logger.info("Starting of bidDetails method");

		bidDetailsPage.scrollDown(1000);

		bidDetailsPage.clickOnNext();

		bidDetailsPage.impicitWait();

		String actualText = bidDetailsPage.getBuyerNameText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("buyer.name"));

		logger.info("Ending of bidDetails method");
	}

	@Test(priority = 16, description = "Secondaries Test")
	public void secondaries() throws Exception {
		logger.info("Starting of secondaries method");

		secondariesPage.scrollDown(1000);

		secondariesPage.clickOnPreview();

		secondariesPage.impicitWait();

		String actualText = othersPage.getGeneralDetailsText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("general.details"));

		logger.info("Ending of secondaries method");
	}

	@Test(priority = 17, description = "Submitting Application Test")
	public void submitApplication() throws Exception {
		logger.info("Starting of submitApplication method");

		othersPage.scrollDown(1000);

		othersPage.clickOnSubmit();

		String actualText = othersPage.getYourApplicationHasBeenSubmittedSuccessfullyText();
		Assert.assertEquals(actualText,
				expectedAssertionsProp.getProperty("your.application.has.been.submitted.successfully"));

		logger.info("Ending of submitApplication method");
	}

	@Test(priority = 18, description = "Navigating To Valuation")
	public void navigatingToValuationSummary() throws Exception {
		logger.info("Starting of navigatingToValuationSummary method");

		othersPage.clickOnOk();

		Thread.sleep(120000);

		logger.info("Ending of navigatingToValuationSummary method");
	}

	@Test(priority = 19, description = "Logout Test")
	public void logoutTest() throws Exception {
		logger.info("Starting of logoutTest method");

		logoutPage.clickOnLogoutIcon();

		String actualText = logoutPage.getLoginText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("login"));

		logger.info("Ending of logoutTest method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (addCompanyDriver != null) {

				addCompanyDriver.quit();

				logger.debug("Add Company Driver quit successfully");
			}

		} catch (Exception ex) {

			logger.error(ex.getMessage());

		}
	}
}
