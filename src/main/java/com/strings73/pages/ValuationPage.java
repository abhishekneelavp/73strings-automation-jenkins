package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValuationPage extends BaseStrings73AutomationPage {

	@FindBy(xpath = "(//a[contains(text(), 'Valuation')])[2]")
	private WebElement valuationTab;

	@FindBy(xpath = "//span[contains(text(),'Mergers & Acquisitions')]")
	private WebElement mergersAndAcquisitions;

	@FindBy(xpath = "//span[contains(text(),'Trading Comps')]")
	private WebElement tradingCompsTab;

	@FindBy(xpath = "//span[contains(text(),'Comparable Company List')]")
	private WebElement comparableCompanyList;

	@FindBy(xpath = "//span[contains(text(),'Income Approach')]")
	private WebElement incomeApproachTab;

	@FindBy(xpath = "//div[contains(text(),'General Inputs')]")
	private WebElement generalInputs;

	@FindBy(xpath = "(//*[contains(text(), 'Custom')])[1]")
	private WebElement customTab;
	
	@FindBy(xpath = "//*[contains(text(), 'Calibration')]")
	private WebElement calibrationTab;

	private static final Logger logger = Logger.getLogger(ValuationPage.class.getName());

	public ValuationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnValuationTab() throws InterruptedException {
		logger.info("Starting of clickOnValuationTab method");
		
		scrollDown(1000);
		
		waitForElementVisibilty(valuationTab);
		
		clickOnElement(valuationTab);
		
		logger.info("Ending of clickOnValuationTab method");
	
	}

	public void clickOnTradingCompsTab() throws InterruptedException {
		logger.info("Starting of clickOnTradingCompsTab method");
		
		scrollDown(1000);
		
		waitForElementVisibilty(tradingCompsTab);
		
		clickOnElement(tradingCompsTab);
		
		logger.info("Ending of clickOnTradingCompsTab method");
	
	}

	public void clickOnIncomeApproachTab() throws InterruptedException {
		logger.info("Starting of clickOnIncomeApproachTab method");
		
		scrollDown(1000);
		
		waitForElementVisibilty(incomeApproachTab);
		
		clickOnElement(incomeApproachTab);
		
		logger.info("Ending of clickOnIncomeApproachTab method");
	}

	public void clickOnCustomTab() {
		logger.info("Starting of clickOnCustomTab method");
		
		waitForElementVisibilty(customTab);
		
		clickOnElement(customTab);
		
		logger.info("Ending of clickOnCustomTab method");
	
	}
	
	public void clickOnCalibration() {
		logger.info("Starting of clickOnCalibration method");
		
		waitForElementVisibilty(calibrationTab);
		
		clickOnElement(calibrationTab);
		
		logger.info("Ending of clickOnCalibration method");
		
	}

	public String getMergersAndAcquisitionsText() {
		logger.info("Starting of getMergersAndAcquisitionsText method");
		logger.info("Ending of getMergersAndAcquisitionsText method");
		
		return mergersAndAcquisitions.getText();
	
	}

	public String getComparableCompanyListText() {
		logger.info("Starting of getComparableCompanyListText method");
		logger.info("Ending of getComparableCompanyListText method");
		
		return comparableCompanyList.getText();
	
	}

	public String getGeneralInputsText() {
		logger.info("Starting of getGeneralInputsText method");
		logger.info("Ending of getGeneralInputsText method");
	
		return generalInputs.getText();
	
	}

}
