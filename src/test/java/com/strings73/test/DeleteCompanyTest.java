package com.strings73.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.strings73.pages.FundsPage;
import com.strings73.pages.LoginPage;
import com.strings73.pages.LogoutPage;
import com.strings73.pages.PortfolioSummaryPage;
import com.strings73.util.MyScreenRecorder;

public class DeleteCompanyTest extends BaseStrings73AutomationTest{
	
	private WebDriver driver = null;
	
	private FundsPage fundsPage = null;
	
	private PortfolioSummaryPage portfolioSummaryPage = null;
	
	private LogoutPage logoutPage = null;
	
	private static final Logger logger = Logger.getLogger(DeleteCompanyTest.class.getName());

	@BeforeClass
	@Parameters({ "userName", "password", "browser" })
	public void initStrings73Login(String userName, String password, String browser) throws Exception {
		logger.info("Starting of initStrings73Login method in DeleteCompanyTest");
		
		this.driver = this.getWebDriver(browser);
		
		this.loginPage = new LoginPage(driver);
		
		this.fundsPage = new FundsPage(driver);
		
		this.portfolioSummaryPage = new PortfolioSummaryPage(driver);
		
		this.logoutPage = new LogoutPage(driver);
		
		this.siteLogin(userName, password, driver);
		
		logger.info("Ending of initStrings73Login method in DeleteCompanyTest");
	
	}
	
	@Test(priority = 1, description = "Fund Name")
	public void fundName() {
		logger.info("Starting of fundName method");
		
		String actualTitle = this.loginPage.getJenkinsText();
		
		Assert.assertEquals(actualTitle, expectedAssertionsProp.getProperty("val.pitch"));
		
		logger.info("Ending of fundName method");
	
	}
	
	@Test(priority = 2, description = "Navigating To Portfolio Summary Page Test")
	public void portfolioSummary() throws Exception {
		logger.info("Starting of portfolioSummary method");
		
		MyScreenRecorder.startRecording("portfolioSummary");
		
		fundsPage.clickOnFund(testDataProp.getProperty("delete.fund.name"));
		
		fundsPage.refresh();
		
		String actualText = fundsPage.getPortfolioSummaryText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("portfolio.summary"));
		
		MyScreenRecorder.stopRecording();
		
		logger.info("Ending of portfolioSummary method");
	
	}
	
	@Test(priority = 3, description = "Delete Company Test")
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
	
	@Test(priority = 4, description = "Logout Test")
	public void logoutTest() throws Exception {
		logger.info("Starting of logoutTest method");
		
		MyScreenRecorder.startRecording("logoutTest");
		
		logoutPage.clickOnLogoutIcon();
		
		String actualText = logoutPage.getLoginText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("login"));
		
		MyScreenRecorder.stopRecording();
		
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
