package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BidDetailsPage extends BaseStrings73AutomationPage {

	@FindBy(xpath = "//label[contains(text(),'Date')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement dateBar;

	@FindBy(xpath = "//td[@aria-label=\"July 8, 2021\"]")
	private WebElement date;

	@FindBy(xpath = "//label[contains(text(),'Bidder Name')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement bidderName;

	@FindBy(xpath = "//div[@class=\"mat-select-value\"]")
	private WebElement currencyBar;

	@FindBy(xpath = "//span[contains(text(),'EUR - Euro')]")
	private WebElement currency;

	@FindBy(xpath = "//label[contains(text(),'Instrument Type')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement instrumentType;

	@FindBy(xpath = "//label[contains(text(),'Amount')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement amount;

	@FindBy(xpath = "//label[contains(text(),'Valuation')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement valuation;

	@FindBy(xpath = "//mat-radio-button[@ng-reflect-value=\"Equity Value\"]")
	private WebElement equityValue;
	
	@FindBy(xpath = "//button[@class = 'btn next-btn ng-star-inserted']")
	private WebElement nextButton;
	
	@FindBy(xpath = "//label[contains(text(),'Buyer Name')]")
	private WebElement buyerName;

	private static final Logger logger = Logger.getLogger(BidDetailsPage.class.getName());

	public BidDetailsPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void selectDate(String date) {
		logger.info("Starting of selectDate method");
		
		waitForElementVisibilty(dateBar);

		this.dateBar.click();

		WebElement selectDate = driver.findElement(By.xpath("//td[@aria-label= '" + date + "']"));
		
		waitForElementVisibilty(selectDate);

		clickOnElement(selectDate);
		
		logger.info("Ending of selectDate method");
	}
	
	public void setBidderName(String bidderValue) {
		logger.info("Starting of setBidderName method");
		
		waitForElementVisibilty(bidderName);
		
		this.bidderName.sendKeys(bidderValue);
		
		logger.info("Ending of setBidderName method");
		
	}
	
	public void selectCurrency(String currency) {
		logger.info("Starting of selectCurrency method");
		
		waitForElementVisibilty(currencyBar);
		
		this.currencyBar.click();
		
		WebElement currencyName = driver.findElement(By.xpath("//span[contains(text(),'"+currency+"')]"));
		
		waitForElementVisibilty(currencyName);
		
		clickOnElement(currencyName);
		
		logger.info("Ending of selectCurrency method");
	
	}
	
	public void setAmount(String amountvalue) {
		logger.info("Starting of setAmount method");
		
		waitForElementVisibilty(amount);
		
		this.amount.clear();
		
		this.amount.sendKeys(amountvalue);
		
		logger.info("Ending of setAmount method");
		
	}
	
	public void setValuation(String valuationValue) {
		logger.info("Starting of setValuation method");
		
		waitForElementVisibilty(valuation);
		
		this.valuation.clear();
		
		this.valuation.sendKeys(valuationValue);
		
		logger.info("Ending of setValuation method");
		
	}
	
	public void setInstrumentType(String instrumentTypeName) {
		logger.info("Starting of setInstrumentType method");
		
		waitForElementVisibilty(instrumentType);
		
		this.instrumentType.clear();
		
		this.instrumentType.sendKeys(instrumentTypeName);
		
		logger.info("Ending of setInstrumentType method");
		
	}
	
	public void clickOnNext() throws InterruptedException {
		logger.info("Starting of clickOnNext method");
		
		Thread.sleep(3000);
		
		this.scrollDown(1000);
		
		waitForElementVisibilty(nextButton);
		
		clickOnElement(nextButton);
		
		logger.info("Ending of clickOnNext method");
	
	}
	
	public String getBuyerNameText() {
		logger.info("Starting of getBuyerNameText method");
		logger.info("Ending of getBuyerNameText method");
	
		return buyerName.getText();
	
	}

}
