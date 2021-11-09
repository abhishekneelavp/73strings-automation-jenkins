package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistoricalFinancialsPage extends BaseStrings73AutomationPage {

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/app-saf[1]/div[2]/div[1]/div[2]/div[1]/div[1]/question-landing-page[1]/div[2]/div[2]/element[1]/div[1]/dropdown-element[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]/span[1]")
	private WebElement yearEndMonthBar;

	@FindBy(xpath = "//span[contains(text(),'December')]")
	private WebElement yearEndMonth;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/app-saf[1]/div[2]/div[1]/div[2]/div[1]/div[1]/question-landing-page[1]/div[2]/div[3]/element[1]/div[1]/dropdown-element[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]/span[1]")
	private WebElement typeOfFinancialsBar;

	@FindBy(xpath = "//span[contains(text(),'Annual')]")
	private WebElement typeOfFinancials;

	@FindBy(xpath = "//input[@type = 'file']")
	private WebElement browse;

	@FindBy(xpath = "//button[@class = 'btn next-btn ng-star-inserted']")
	private WebElement nextButton;

	@FindBy(xpath = "//label[contains(text(),'Debt to Equity')]")
	private WebElement debtToEquity;

	private static final Logger logger = Logger.getLogger(HistoricalFinancialsPage.class.getName());

	public HistoricalFinancialsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void selectYearEndMonth() {
		logger.info("Starting of selectYearEndMonth method");
		
		waitForElementVisibilty(yearEndMonthBar);
		
		clickOnElement(yearEndMonthBar);
		
		waitForElementVisibilty(yearEndMonth);
		
		clickOnElement(yearEndMonth);
		
		logger.info("Ending of selectYearEndMonth method");
	}

	public void selectTypeOfFinancials() {
		logger.info("Starting of selectTypeOfFinancials method");
		
		waitForElementVisibilty(typeOfFinancialsBar);
		
		clickOnElement(typeOfFinancialsBar);
		
		waitForElementVisibilty(typeOfFinancials);
		
		clickOnElement(typeOfFinancials);
		
		logger.info("Ending of selectTypeOfFinancials method");
	}

	public void clickOnNext() {
		logger.info("Starting of clickOnNext method");
		
		waitForElementVisibilty(nextButton);
		
		clickOnElement(nextButton);
		
		logger.info("Ending of clickOnNext method");
	}

	public void clickOnBrowse(String excelFileHistorical) throws InterruptedException {
		logger.info("Starting of clickOnBrowse method");
		
		String osPath = System.getProperty("os.name");
		
		if (osPath.contains("Linux")) {
			
			browse.sendKeys(TEST_FILE_PATH + "/" + excelFileHistorical);
			
		} else if(osPath.contains("Mac OS X")){
			
			browse.sendKeys(TEST_FILE_PATH + "/" + excelFileHistorical);
			
		} else {
			
			browse.sendKeys(TEST_FILE_PATH + "\\" + excelFileHistorical);
		}
		
		Thread.sleep(3000);
		
		scrollDown(1000);
		
		logger.info("Ending of clickOnBrowse method");
	}

	public String getDebtToEquityText() {
		logger.info("Starting of getDebtToEquityText method");
		logger.info("Ending of getDebtToEquityText method");
		
		return debtToEquity.getText();
	}
}
