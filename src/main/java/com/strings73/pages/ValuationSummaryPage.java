package com.strings73.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValuationSummaryPage extends BaseStrings73AutomationPage{
	
	@FindBy(xpath = "//span[@class=\"lock\"]")
	private WebElement lock;
	
	@FindBy(xpath = "//span[@class=\"lock unlocked\"]")
	private WebElement unlock;
	
	@FindBy(xpath = "//span[contains(text(),'Ok')]")
	private WebElement okButton;
	
	@FindBy(xpath = "//div[contains(text(),'Trading Comps Approach')]/parent::div//following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement tradingCompsInputField;
	
	@FindBy(xpath = "//div[contains(text(),'Transaction Comps Approach')]/parent::div//following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement transactionCompsInputField;
	
	@FindBy(xpath = "//div[contains(text(),'Income Approach')]/parent::div//following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement incomeApproachInputField;
	
	@FindBy(xpath = "//div[contains(text(),'Custom Approach')]/parent::div//following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement customApproachInputField;
	
	@FindBy(xpath = "//div[contains(text(),'Calibration Approach')]/parent::div//following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement calibrationApproachInputField;
	
	@FindBy(xpath = "//*[contains(text(),' Investment Summary ')]")
	private WebElement investmentSummary;
	
	@FindBy(xpath="//span[contains(text(),' Portfolio Summary ')]")
	private WebElement portfolioSummary;
	
	//private static final Logger logger = Logger.getLogger(ValuationSummaryPage.class.getName());

	public ValuationSummaryPage(WebDriver driver) {
		
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLock() {
		
		waitForElementVisibilty(lock);
		
		clickOnElement(lock);
		
	}
	
	public void clickOnUnlock() {
		
		waitForElementVisibilty(unlock);
		
		clickOnElement(unlock);
		
	}
	
	public void clickOnOk() {
		
		waitForElementVisibilty(okButton);
		
		clickOnElement(okButton);
		
	}
	
	public void setTradingComps(String value) {
		
		waitForElementVisibilty(tradingCompsInputField);
		
		this.tradingCompsInputField.clear();
		
		this.tradingCompsInputField.sendKeys(value);
		
	}
	
	public void setTransactionComps(String value) {
		
		waitForElementVisibilty(transactionCompsInputField);
		
		this.transactionCompsInputField.clear();
		
		this.transactionCompsInputField.sendKeys(value);
		
	}
	
	public void setIncomeApproach(String value) {
		
		waitForElementVisibilty(incomeApproachInputField);
		
		this.incomeApproachInputField.clear();
		
		this.incomeApproachInputField.sendKeys(value);
		
	}
	
	public void setCustomApproach(String value) {
		
		waitForElementVisibilty(customApproachInputField);
		
		this.customApproachInputField.clear();
		
		this.customApproachInputField.sendKeys(value);
		
	}
	
	public void setCalibrationApproach(String value) {
		
		waitForElementVisibilty(calibrationApproachInputField);
		
		this.calibrationApproachInputField.clear();
		
		this.calibrationApproachInputField.sendKeys(value);
		
	}
	
	public void clickOnInvestmentSummary() {
		
		waitForElementVisibilty(investmentSummary);
			
	clickOnElement(investmentSummary);
		
	}
	public void clickOnPortfolioSummary() {
		waitForElementVisibilty(portfolioSummary);
		
		clickOnElement(portfolioSummary);
		
	}

}
