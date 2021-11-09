package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondariesPage extends BaseStrings73AutomationPage{
	
	@FindBy(xpath = "//label[contains(text(),'Date')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement dateBar;
	
	@FindBy(xpath = "//label[contains(text(),'Buyer Name')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement buyerName;
	
	@FindBy(xpath = "//label[contains(text(),'Seller Name')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement sellerName;
	
	@FindBy(xpath = "(//div[@class=\"mat-select-value\"])[1]")
	private WebElement currencyBar;
	
	@FindBy(xpath = "//label[contains(text(),'Valuation')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement valuation;
	
	@FindBy(xpath = "//label[contains(text(),'Instrument Type')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement instrumentType;
	
	@FindBy(xpath = "(//div[@class=\"mat-select-value\"])[2]")
	private WebElement transactionStatusBar;
	
	@FindBy(xpath = "//span[contains(text(),'Closed')]")
	private WebElement transactionStatus;
	
	@FindBy(xpath = "//button[@class=\"btn next-btn ng-star-inserted\"]")
	private WebElement preview;
	
	@FindBy(xpath = "//label[contains(text(),'Sold')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement sold;
	
	private static final Logger logger = Logger.getLogger(SecondariesPage.class.getName());

	public SecondariesPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void selectDate(String date) {
		logger.info("Starting of selectDate method");
		
		waitForElementVisibilty(dateBar);
		
		this.dateBar.click();
		
		WebElement selectDate = driver.findElement(By.xpath("//td[@aria-label= '"+date+"']"));
		
		waitForElementVisibilty(selectDate);
		
		clickOnElement(selectDate);
		
		logger.info("Ending of selectDate method");
	}
	
	public void selectCurrency(String currency) {
		logger.info("Starting of selectCurrency method");
		
		waitForElementVisibilty(currencyBar);
		
		this.currencyBar.click();
		
		WebElement selectCurrency = driver.findElement(By.xpath("//span[contains(text(),'"+currency+"')]"));
		
		waitForElementVisibilty(selectCurrency);
		
		clickOnElement(selectCurrency);
		
		logger.info("Ending of selectCurrency method");
	}
	
	public void setBuyerName(String buyername) {
		logger.info("Starting of setBuyerName method");
		
		waitForElementVisibilty(buyerName);
		
		this.buyerName.sendKeys(buyername);
		
		logger.info("Ending of setBuyerName method");
		
	}
	
	public void setSellerName(String sellername) {
		logger.info("Starting of setSellerName method");
		
		waitForElementVisibilty(sellerName);
		
		this.sellerName.sendKeys(sellername);
		
		logger.info("Ending of setSellerName method");
		
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
		
		this.instrumentType.sendKeys(instrumentTypeName);
		
		logger.info("Ending of setInstrumentType method");
		
	}
	
	public void selectTransactionStatus(String transactionStatusType){
		logger.info("Starting of selectTransactionStatus method");
		
		waitForElementVisibilty(transactionStatusBar);
		
		this.transactionStatusBar.click();
		
		WebElement transactionStatus = driver.findElement(By.xpath("//span[contains(text(),'"+transactionStatusType+"')]"));
		
		waitForElementVisibilty(transactionStatus);
		
		clickOnElement(transactionStatus);
		
		logger.info("Ending of selectTransactionStatus method");
		
	}
	
	public void clickOnPreview() throws InterruptedException {
		logger.info("Starting of clickOnPreview method");
		
		Thread.sleep(3000);
		
		this.scrollDown(1000);
		
		waitForElementVisibilty(preview);
		
		clickOnElement(preview);
		
		logger.info("Ending of clickOnPreview method");
	}
	
	public void setSoldPercentage(String soldPercentage) {
		logger.info("Starting of setSoldPercentage method");
		
		waitForElementVisibilty(sold);
		
		this.sold.clear();
		
		this.sold.sendKeys(soldPercentage);
		
		logger.info("Ending of setSoldPercentage method");
		
	}

}
