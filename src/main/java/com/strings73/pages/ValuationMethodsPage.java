package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValuationMethodsPage extends BaseStrings73AutomationPage{

	@FindBy(xpath = "//span[contains(text(), 'Comparable Transaction Approach')]")
	private WebElement comparableTransactionApproach;

	@FindBy(xpath = "//span[contains(text(), 'Comparable Company Approach')]")
	private WebElement comparableCompanyApproach;

	@FindBy(xpath = "//span[contains(text(), 'Income Approach')]")
	private WebElement incomeApproach;
	
	@FindBy(xpath = "//span[contains(text(), ' Price of Recent Investment ')]")
	private WebElement pori;

	@FindBy(xpath = "//span[contains(text(), ' Bid Details')]")
	private WebElement bidDetails;

	@FindBy(xpath = "//span[contains(text(), 'Secondaries')]")
	private WebElement secondaries;
	
	@FindBy(xpath = "//label[contains(text(),'Funding Date')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement fundingDateBar;
	
	@FindBy(xpath = "//td[@aria-label=\"July 8, 2021\"]")
	private WebElement fundingDate;
	
	@FindBy(xpath = "//label[contains(text(),'Investor Name')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement investorName;
	
	@FindBy(xpath = "//label[contains(text(),'Last Funding Amount')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement lastFundingAmount;
	
	@FindBy(xpath = "//label[contains(text(),'Stake Acquired')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement stakeAquired;
	
	@FindBy(xpath = "//label[contains(text(),'Bidder Name')]")
	private WebElement bidderName;
	
	@FindBy(xpath = "//button[@class = 'btn next-btn ng-star-inserted']")
	private WebElement nextButton;
	
	private static final Logger logger = Logger.getLogger(ValuationMethodsPage.class.getName());

	public ValuationMethodsPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void selectComparableTransactionApproach() {
		logger.info("Starting of selectComparableTransactionApproach method");
		
		waitForElementVisibilty(comparableTransactionApproach);
		
		clickOnElement(comparableTransactionApproach);
		
		logger.info("Ending of selectComparableTransactionApproach method");
	
	}

	public void selectComparableCompanyApproach() {
		logger.info("Starting of selectComparableCompanyApproach method");
		
		waitForElementVisibilty(comparableCompanyApproach);
	
		clickOnElement(comparableCompanyApproach);
		
		logger.info("Ending of selectComparableCompanyApproach method");
	
	}

	public void selectIncomeApproach() {
		logger.info("Starting of selectIncomeApproach method");
		
		waitForElementVisibilty(incomeApproach);
		
		clickOnElement(incomeApproach);
		
		logger.info("Ending of selectIncomeApproach method");
	
	}
	
	public void selectPori() {
		logger.info("Starting of selectPori method");
		
		waitForElementVisibilty(pori);
		
		clickOnElement(pori);
		
		logger.info("Ending of selectPori method");
		
	}
	
	public void selectBidDetails() {
		logger.info("Starting of selectBidDetails method");
		
		waitForElementVisibilty(bidDetails);
		
		clickOnElement(bidDetails);
		
		logger.info("Ending of selectBidDetails method");
		
	}
	
	public void selectSecondaries() {
		logger.info("Starting of selectSecondaries method");
		
		waitForElementVisibilty(secondaries);
		
		clickOnElement(secondaries);
		
		logger.info("Ending of selectSecondaries method");
		
	}
	
	public void setLastFundingAmount(String fundingAmount) {
		logger.info("Starting of setLastFundingAmount method");
		
		waitForElementVisibilty(lastFundingAmount);
		
		this.lastFundingAmount.clear();
		
		this.lastFundingAmount.sendKeys(fundingAmount);
		
		logger.info("Ending of setLastFundingAmount method");
		
	}
	
	public void setFundingDate(String fundingDateValue) {
		logger.info("Starting of setFundingDate method");
		
		waitForElementVisibilty(fundingDateBar);
		
		clickOnElement(fundingDateBar);
		
		waitForElementVisibilty(fundingDate);
		
		this.fundingDate.sendKeys(fundingDateValue);
		
		logger.info("Ending of setFundingDate method");
		
	}
	
	public void setStakeAcquired(String stakeAcquiredValue) {
		logger.info("Starting of setStakeAcquired method");
		
		waitForElementVisibilty(stakeAquired);
		
		this.stakeAquired.clear();
		
		this.stakeAquired.sendKeys(stakeAcquiredValue);
		
		logger.info("Ending of setStakeAcquired method");
		
	}
	
	public void setInvestorName(String investorname) {
		logger.info("Starting of setInvestorName method");
		
		waitForElementVisibilty(investorName);
		
		this.investorName.sendKeys(investorname);
		
		logger.info("Ending of setInvestorName method");
		
	}
	
	public String getBidderNameText() {
		logger.info("Starting of getBidderNameText method");
		logger.info("Ending of getBidderNameText method");
		
		return bidderName.getText();
	
	}
	
	public void clickOnNext() {
		logger.info("Starting of clickOnNext method");
		
		waitForElementVisibilty(nextButton);
		
		clickOnElement(nextButton);
		
		logger.info("Ending of clickOnNext method");
	
	}
}
