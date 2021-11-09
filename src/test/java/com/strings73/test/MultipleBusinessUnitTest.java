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
import com.strings73.pages.MultipleBusinessUnitPage;
import com.strings73.pages.OthersPage;
import com.strings73.pages.PortfolioSummaryPage;
import com.strings73.pages.ProjectedFinancialsPage;
import com.strings73.pages.SecondariesPage;
import com.strings73.pages.ValuationMethodsPage;
import com.strings73.pages.ValuationSummaryPage;
import com.strings73.util.MyScreenRecorder;

public class MultipleBusinessUnitTest extends BaseStrings73AutomationTest {
	private WebDriver driver = null;

	private FundsPage fundsPage = null;

	private PortfolioSummaryPage portfolioSummaryPage = null;

	private MultipleBusinessUnitPage multipleBusinessUnitPage = null;

	private InvestmentSummaryPage investmentsummaryPage = null;

	private ValuationSummaryPage valuationSummaryPage = null;

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

		this.driver = this.getWebDriver(browser);

		this.loginPage = new LoginPage(driver);

		this.fundsPage = new FundsPage(driver);

		this.portfolioSummaryPage = new PortfolioSummaryPage(driver);

		this.valuationMethodsPage = new ValuationMethodsPage(driver);

		this.multipleBusinessUnitPage = new MultipleBusinessUnitPage(driver);

		this.investmentsummaryPage = new InvestmentSummaryPage(driver);

		this.generalDetailsPage = new GeneralDetailsPage(driver);

		this.historicalFinancialsPage = new HistoricalFinancialsPage(driver);

		this.projectedFinancialsPage = new ProjectedFinancialsPage(driver);

		this.valuationMethodsPage = new ValuationMethodsPage(driver);

		this.valuationSummaryPage = new ValuationSummaryPage(driver);

		this.bidDetailsPage = new BidDetailsPage(driver);

		this.secondariesPage = new SecondariesPage(driver);

		this.othersPage = new OthersPage(driver);

		this.logoutPage = new LogoutPage(driver);

		this.siteLogin(userName, password, driver);

		logger.info("Ending of initStrings73Login method in AddCompanyTest");
	}

	@Test(priority = 1, description = "Login Test")
	public void loginTest() {
		logger.info("Starting of loginTest method");

		String actualTitle = this.loginPage.getWebsiteTitle(driver);
		Assert.assertEquals(actualTitle, expectedAssertionsProp.getProperty("73strings.title"));

		logger.info("Ending of loginTest method");
	}

	@Test(priority = 2, description = "Fund Name")
	public void fundName() {
		logger.info("Starting of fundName method");

		String actualTitle = this.loginPage.getJenkinsText();
		Assert.assertEquals(actualTitle, expectedAssertionsProp.getProperty("jenkins"));

		logger.info("Ending of fundName method");
	}

	@Test(priority = 3, description = "Navigating To Portfolio Summary Test")
	public void navigatingToPortfolioSummary() throws Exception {
		logger.info("Starting of navigatingToPortfolioSummary method");

		fundsPage.impicitWait();

		fundsPage.clickOnFund(testDataProp.getProperty("addcompany.fund.name"));

		logger.info("Ending of navigatingToPortfolioSummary method");
	}

	@Test(priority = 4, description = "Add Company Test")
	public void addCompany() throws Exception {
		logger.info("Starting of addCompany method");

		Thread.sleep(120000);

		portfolioSummaryPage.clickOnAddCompanyButton();

		portfolioSummaryPage.setCompanyName(testDataProp.getProperty("addcompany.new.company.name"));

		portfolioSummaryPage.setInvestmentDate(testDataProp.getProperty("addcompany.year"),
				testDataProp.getProperty("addcompany.month"), testDataProp.getProperty("addcompany.date"));

		Thread.sleep(3000);
		multipleBusinessUnitPage.Enterunits(testDataProp.getProperty("units"));

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

	@Test(priority = 6, description = "Navigating To Show Valuation Dates Test")
	public void navigatingToShowValuationDates() throws Exception {
		logger.info("Starting of navigatingToShowValuationDates method");

		investmentsummaryPage.clickOnMenu();

		Thread.sleep(3000);

		investmentsummaryPage.clickOnShowValuationDates();

		logger.info("Ending of navigatingToShowValuationDates method");
	}

	@Test(priority = 7, description = "Navigating To General Details Test")
	public void navigatingToGeneralDetails() throws Exception {
		logger.info("Starting of navigatingToGeneralDetails method");

		Thread.sleep(5000);

		investmentsummaryPage.clickOnEdit();
		logger.info("Ending of navigatingToGeneralDetails method");
	}

	@Test(priority = 8, description = "Filling General Details Test")
	public void fillingGeneralDetails() throws Exception {
		logger.info("Starting of fillingGeneralDetails method");

		generalDetailsPage.setNameOfCompany(testDataProp.getProperty("addcompany.company.name"));

		generalDetailsPage.enterBusinessDescription(testDataProp.getProperty("addcompany.description"));

		generalDetailsPage.setHQCountry(testDataProp.getProperty("addcompany.hq.country"));

		generalDetailsPage.setWebsite(testDataProp.getProperty("addcompany.website"));

		generalDetailsPage.setCountry(testDataProp.getProperty("addcompany.country"));

		Thread.sleep(3000);

		generalDetailsPage.setIndustry(testDataProp.getProperty("addcompany.industry"));

		Thread.sleep(3000);

		generalDetailsPage.selectCurrency(testDataProp.getProperty("addcompany.currency"));

		Thread.sleep(3000);

		generalDetailsPage.clickOnNext();

		logger.info("Ending of fillingGeneralDetails method");
	}

	@Test(priority = 9, description = "Filling Details In Historical Financials Test")
	public void fillingDetailsInhistoricalFinancials() throws Exception {
		logger.info("Starting of fillingDetailsInhistoricalFinancials method");

		historicalFinancialsPage.selectYearEndMonth();

		historicalFinancialsPage.selectTypeOfFinancials();

		historicalFinancialsPage.clickOnBrowse(testDataProp.getProperty("historical.excel.file.historical"));

		historicalFinancialsPage.clickOnNext();

		logger.info("Ending of fillingDetailsInhistoricalFinancials method");
	}

	@Test(priority = 10, description = "Filling Details In Projected Financials Test")
	public void fillingDetailsInProjectedFinancials() throws Exception {
		logger.info("Starting of fillingDetailsInProjectedFinancials method");

		projectedFinancialsPage.setDebtToEquity(testDataProp.getProperty("projected.debttoequity"));

		projectedFinancialsPage.selectYearEndMonth();

		projectedFinancialsPage.selectTypeOfFinancials();

		projectedFinancialsPage.clickOnBrowse(testDataProp.getProperty("projected.excel.file.projected"));

		secondariesPage.clickOnPreview();
		logger.info("Ending of fillingDetailsInProjectedFinancials method");
	}

	@Test(priority = 11, description = "Submitting Application Test")
	public void submitApplication() throws Exception {
		logger.info("Starting of submitApplication method");

		othersPage.clickOnSubmit();

		logger.info("Ending of submitApplication method");
	}

	@Test(priority = 12, description = "Navigating To Valuation")
	public void navigatingToValuationSummary1() throws Exception {
		logger.info("Starting of navigatingToValuationSummary method");

		othersPage.clickOnOk();

		logger.info("Ending of navigatingToValuationSummary method");
	}

	@Test(priority = 13, description = "Navigating To Show Valuation Test")
	public void navigatingToShowValuation() throws Exception {
		logger.info("Starting of navigatingToShowValuation method");

		investmentsummaryPage.clickOnMenu();

		investmentsummaryPage.clickOnShowValuationDates();
		Thread.sleep(140000);
		investmentsummaryPage.clickOnEdit();

		multipleBusinessUnitPage.clickOnEditButton1();
		Thread.sleep(40000);
		logger.info("Ending of navigatingToShowValuation method");
	}

	@Test(priority = 14, description = "Filling General Details Test")
	public void fillingGeneralDetails1() throws Exception {
		logger.info("Starting of fillingGeneralDetails method");

		generalDetailsPage.setNameOfCompany(testDataProp.getProperty("addcompany.company.name"));

		generalDetailsPage.enterBusinessDescription(testDataProp.getProperty("addcompany.description"));

		generalDetailsPage.setHQCountry(testDataProp.getProperty("addcompany.hq.country"));

		generalDetailsPage.setWebsite(testDataProp.getProperty("addcompany.website"));

		generalDetailsPage.setCountry(testDataProp.getProperty("addcompany.country"));

		Thread.sleep(3000);

		generalDetailsPage.setIndustry(testDataProp.getProperty("addcompany.industry"));

		Thread.sleep(3000);

		generalDetailsPage.selectCurrency(testDataProp.getProperty("addcompany.currency"));

		Thread.sleep(3000);

		historicalFinancialsPage.clickOnNext();
		logger.info("Ending of fillingGeneralDetails method");
	}

	@Test(priority = 15, description = "Filling Details In Historical Financials Test")
	public void fillingDetailsInhistoricalFinancials1() throws Exception {
		logger.info("Starting of fillingDetailsInhistoricalFinancials method");

		historicalFinancialsPage.selectYearEndMonth();

		historicalFinancialsPage.selectTypeOfFinancials();

		historicalFinancialsPage.clickOnBrowse(testDataProp.getProperty("historical.excel.file.historical"));

		historicalFinancialsPage.clickOnNext();

		logger.info("Ending of fillingDetailsInhistoricalFinancials method");
	}

	@Test(priority = 16, description = "Filling Details In Projected Financials Test")
	public void fillingDetailsInProjectedFinancials1() throws Exception {
		logger.info("Starting of fillingDetailsInProjectedFinancials method");

		projectedFinancialsPage.setDebtToEquity(testDataProp.getProperty("projected.debttoequity"));

		projectedFinancialsPage.selectYearEndMonth();

		projectedFinancialsPage.selectTypeOfFinancials();

		projectedFinancialsPage.clickOnBrowse(testDataProp.getProperty("projected.excel.file.projected"));

		projectedFinancialsPage.clickOnNext();

		logger.info("Ending of fillingDetailsInProjectedFinancials method");
	}

	@Test(priority = 17, description = "Choosing Surplus Assets")
	public void choosingSurplusAssets1() throws Exception {
		logger.info("Starting of choosingSurplusAssets method");

		othersPage.selectAnySurplus();

		othersPage.clickOnNext();

		logger.info("Ending of choosingSurplusAssets method");
	}

	@Test(priority = 18, description = "Selecting Valuation Methods Test")
	public void selectingValuationMethods1() throws Exception {
		logger.info("Starting of selectingValuationMethods method");

		valuationMethodsPage.selectComparableTransactionApproach();

		valuationMethodsPage.selectComparableCompanyApproach();

		valuationMethodsPage.selectIncomeApproach();

		logger.info("Ending of selectingValuationMethods method");
	}

	@Test(priority = 19, description = "Last Funding Details Test")
	public void lastFundingDetails1() throws Exception {
		logger.info("Starting of lastFundingDetails method");

		valuationMethodsPage.scrollDown(1000);

		valuationMethodsPage.clickOnNext();

		logger.info("Ending of lastFundingDetails method");
	}

	@Test(priority = 20, description = "Bid Details Test")
	public void bidDetails1() throws Exception {
		logger.info("Starting of bidDetails method");

		bidDetailsPage.clickOnNext();

		logger.info("Ending of bidDetails method");
	}

	@Test(priority = 21, description = "Secondaries Test")
	public void secondaries1() throws Exception {
		logger.info("Starting of secondaries method");

		secondariesPage.clickOnPreview();

		logger.info("Ending of secondaries method");
	}

	@Test(priority = 22, description = "Submitting Application Test")
	public void submitApplication1() throws Exception {
		logger.info("Starting of submitApplication method");

		othersPage.clickOnSubmit();

		logger.info("Ending of submitApplication method");
	}

	@Test(priority = 23, description = "Navigating To Valuation")
	public void navigatingToValuation() throws Exception {
		logger.info("Starting of navigatingToValuationSummary method");

		othersPage.clickOnOk();

		Thread.sleep(120000);

		valuationSummaryPage.clickOnInvestmentSummary();
		logger.info("Ending of navigatingToValuationSummary method");
	}

	@Test(priority = 24, description = "Navigating To Show Valuation Test")
	public void navigatingToShowValuation2() throws Exception {
		logger.info("Starting of navigatingToShowValuation method");

		investmentsummaryPage.clickOnMenu();

		investmentsummaryPage.clickOnShowValuationDates();
		Thread.sleep(140000);

		logger.info("Ending of navigatingToShowValuation method");
	}

	@Test(priority = 25, description = "Navigating To General Details Test")
	public void navigatingToGeneralDetails2() throws Exception {
		logger.info("Starting of navigatingToGeneralDetails method");

		investmentsummaryPage.clickOnEdit();
		multipleBusinessUnitPage.clickOnEditButton2();
		Thread.sleep(5000);
		logger.info("Ending of navigatingToGeneralDetails method");
	}

	@Test(priority = 26, description = "Filling General Details Test")
	public void fillingGeneralDetails2() throws Exception {
		logger.info("Starting of fillingGeneralDetails method");

		generalDetailsPage.setNameOfCompany(testDataProp.getProperty("addcompany.company.name"));

		generalDetailsPage.enterBusinessDescription(testDataProp.getProperty("addcompany.description"));

		generalDetailsPage.setHQCountry(testDataProp.getProperty("addcompany.hq.country"));

		generalDetailsPage.setWebsite(testDataProp.getProperty("addcompany.website"));

		generalDetailsPage.setCountry(testDataProp.getProperty("addcompany.country"));

		Thread.sleep(3000);

		generalDetailsPage.setIndustry(testDataProp.getProperty("addcompany.industry"));

		Thread.sleep(3000);

		generalDetailsPage.selectCurrency(testDataProp.getProperty("addcompany.currency"));

		Thread.sleep(3000);

		generalDetailsPage.clickOnNext();

		logger.info("Ending of fillingGeneralDetails method");
	}

	@Test(priority = 27, description = "Filling Details In Historical Financials Test")
	public void fillingDetailsInhistoricalFinancials2() throws Exception {
		logger.info("Starting of fillingDetailsInhistoricalFinancials method");

		historicalFinancialsPage.selectYearEndMonth();

		historicalFinancialsPage.selectTypeOfFinancials();

		historicalFinancialsPage.clickOnBrowse(testDataProp.getProperty("historical.excel.file.historical"));

		historicalFinancialsPage.clickOnNext();

		logger.info("Ending of fillingDetailsInhistoricalFinancials method");
	}

	@Test(priority = 28, description = "Filling Details In Projected Financials Test")
	public void fillingDetailsInProjectedFinancials2() throws Exception {
		logger.info("Starting of fillingDetailsInProjectedFinancials method");

		projectedFinancialsPage.setDebtToEquity(testDataProp.getProperty("projected.debttoequity"));

		projectedFinancialsPage.selectYearEndMonth();

		projectedFinancialsPage.selectTypeOfFinancials();

		projectedFinancialsPage.clickOnBrowse(testDataProp.getProperty("projected.excel.file.projected"));

		projectedFinancialsPage.clickOnNext();

		logger.info("Ending of fillingDetailsInProjectedFinancials method");
	}

	@Test(priority = 29, description = "Choosing Surplus Assets")
	public void choosingSurplusAssets2() throws Exception {
		logger.info("Starting of choosingSurplusAssets method");

		othersPage.selectAnySurplus();

		othersPage.clickOnNext();

		logger.info("Ending of choosingSurplusAssets method");
	}

	@Test(priority = 30, description = "Selecting Valuation Methods Test")
	public void selectingValuationMethods2() throws Exception {
		logger.info("Starting of selectingValuationMethods method");

		valuationMethodsPage.selectComparableTransactionApproach();

		valuationMethodsPage.selectComparableCompanyApproach();

		valuationMethodsPage.selectIncomeApproach();

		logger.info("Ending of selectingValuationMethods method");
	}

	@Test(priority = 31, description = "Last Funding Details Test")
	public void lastFundingDetails2() throws Exception {
		logger.info("Starting of lastFundingDetails method");

		valuationMethodsPage.scrollDown(1000);

		valuationMethodsPage.clickOnNext();

		logger.info("Ending of lastFundingDetails method");
	}

	@Test(priority = 32, description = "Bid Details Test")
	public void bidDetails2() throws Exception {
		logger.info("Starting of bidDetails method");

		bidDetailsPage.clickOnNext();

		logger.info("Ending of bidDetails method");
	}

	@Test(priority = 33, description = "Secondaries Test")
	public void secondaries2() throws Exception {
		logger.info("Starting of secondaries method");

		secondariesPage.clickOnPreview();

		logger.info("Ending of secondaries method");
	}

	@Test(priority = 34, description = "Submitting Application Test")
	public void submitApplication2() throws Exception {
		logger.info("Starting of submitApplication method");

		othersPage.clickOnSubmit();

		logger.info("Ending of submitApplication method");
	}

	@Test(priority = 35, description = "Navigating To Valuation")
	public void navigatingToValuationSummary() throws Exception {
		logger.info("Starting of navigatingToValuationSummary method");

		othersPage.clickOnOk();

		Thread.sleep(120000);

		valuationSummaryPage.clickOnInvestmentSummary();

		logger.info("Ending of navigatingToValuationSummary method");
	}

	@Test(priority = 36, description = "Navigating To Show Valuation Test")
	public void navigatingToShowValuation1() throws Exception {
		logger.info("Starting of navigatingToShowValuation method");

		investmentsummaryPage.clickOnMenu();

		investmentsummaryPage.clickOnShowValuationDates();
		Thread.sleep(140000);

		logger.info("Ending of navigatingToShowValuation method");
	}

	@Test(priority = 37, description = "Starting of Roll Over Process Test")
	public void rollOver() throws Exception {
		logger.info("Starting of rollOver method");

		investmentsummaryPage.setRollOverDate(testDataProp.getProperty("rollover.future.valuation.year"),
				testDataProp.getProperty("rollover.future.valuation.month"),
				testDataProp.getProperty("rollover.future.valuation.date"));
		Thread.sleep(3000);

		investmentsummaryPage.clickOnAdd();

		logger.info("Ending of rollOver method");
	}

	@Test(priority = 38, description = "Pop Up Window Test")
	public void popUpWindow() throws Exception {
		logger.info("Starting of popUpWindow method");

		investmentsummaryPage.clickOnOk();

		logger.info("Ending of popUpWindow method");
	}

	@Test(priority = 39, description = "Navigating to Application Preview Tab Test")
	public void navigatingToApplicationPreviewTab() throws Exception {
		logger.info("Starting of navigatingToApplicationPreviewTab method");

		investmentsummaryPage.clickOnEdit();

		Thread.sleep(5000);

		logger.info("Ending of navigatingToApplicationPreviewTab method");
	}

	@Test(priority = 40, description = "Submitting Application")
	public void rollOversubmitApplication() throws Exception {
		logger.info("Starting of submitApplication method");

		othersPage.scrollDown(1000);

		othersPage.clickOnSubmit();

		logger.info("Ending of submitApplication method");

	}

	@Test(priority = 41, description = "Navigating To Valuation")
	public void rollOverNavigatingToValuationSummary() throws Exception {
		logger.info("Starting of navigatingToValuationSummary method");

		othersPage.clickOnOk();

		Thread.sleep(50000);
		investmentsummaryPage.clickOnMenu();

		investmentsummaryPage.clickOnShowValuationDates();
		Thread.sleep(140000);

		logger.info("Ending of navigatingToValuationSummary method");
	}

	@Test(priority = 42, description = "Navigating to Application Preview Tab Test")
	public void navigatingToApplicationPreviewTab1() throws Exception {
		logger.info("Starting of navigatingToApplicationPreviewTab method");

		investmentsummaryPage.clickOnEdit();

		Thread.sleep(5000);
		multipleBusinessUnitPage.clickOnEditButton1();
		Thread.sleep(5000);
		logger.info("Ending of navigatingToApplicationPreviewTab method");
	}

	@Test(priority = 43, description = "Submitting Application")
	public void rollOversubmitApplication1() throws Exception {
		logger.info("Starting of submitApplication method");

		othersPage.scrollDown(1000);

		othersPage.clickOnSubmit();

		logger.info("Ending of submitApplication method");

	}

	@Test(priority = 44, description = "Navigating To Valuation")
	public void rollOverNavigatingToValuationSummary1() throws Exception {
		logger.info("Starting of navigatingToValuationSummary method");

		othersPage.clickOnOk();

		Thread.sleep(50000);
		valuationSummaryPage.clickOnInvestmentSummary();

		investmentsummaryPage.clickOnMenu();

		investmentsummaryPage.clickOnShowValuationDates();
		Thread.sleep(140000);

		logger.info("Ending of navigatingToValuationSummary method");
	}

	@Test(priority = 45, description = "Navigating to Application Preview Tab Test")
	public void navigatingToApplicationPreviewTab2() throws Exception {
		logger.info("Starting of navigatingToApplicationPreviewTab method");

		investmentsummaryPage.clickOnEdit();

		Thread.sleep(5000);
		multipleBusinessUnitPage.clickOnEditButton2();
		Thread.sleep(5000);
		logger.info("Ending of navigatingToApplicationPreviewTab method");
	}

	@Test(priority = 46, description = "Submitting Application")
	public void rollOversubmitApplication2() throws Exception {
		logger.info("Starting of submitApplication method");

		othersPage.scrollDown(1000);

		othersPage.clickOnSubmit();

		logger.info("Ending of submitApplication method");

	}

	@Test(priority = 47, description = "Navigating To Valuation")
	public void rollOverNavigatingToValuationSummary2() throws Exception {
		logger.info("Starting of navigatingToValuationSummary method");

		othersPage.clickOnOk();

		logger.info("Ending of navigatingToValuationSummary method");
	}

	@Test(priority = 48, description = "Navigating To Portfolio Summary Page Test")
	public void portfolioSummary() throws Exception {
		logger.info("Starting of portfolioSummary method");

		valuationSummaryPage.clickOnPortfolioSummary();

		//othersPage.clickOnOk();
		
		logger.info("Ending of portfolioSummary method");

	}

	@Test(priority = 49, description = "Delete Company Test")
	public void deleteCompany() throws Exception {
		logger.info("Starting of deleteCompany method");

		MyScreenRecorder.startRecording("deleteCompany");

		portfolioSummaryPage.clickOnDeleteIcon();

		portfolioSummaryPage.clickOnCheckbox(testDataProp.getProperty("delete.company.name"));

		portfolioSummaryPage.clickOnDelete();

		portfolioSummaryPage.clickOnYes();

		String actualText = portfolioSummaryPage.getDeletedSuccessfullyText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("deleted.successfully"));

		portfolioSummaryPage.clickOnDeleteOk();

		MyScreenRecorder.stopRecording();

		logger.info("Ending of deleteCompany method");

	}

	@Test(priority = 50, description = "Logout Test")
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

			if (driver != null) {

				driver.quit();

				logger.debug("Driver quit successfully");
			}

		} catch (Exception ex) {

			logger.error(ex.getMessage());

		}
	}
}
