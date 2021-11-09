package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectedFinancialsPage extends BaseStrings73AutomationPage {

	@FindBy(xpath = "//body/app-root[1]/div[1]/app-saf[1]/div[2]/div[1]/div[2]/div[1]/div[1]/question-landing-page[1]/div[2]/div[3]/element[1]/div[1]/dropdown-element[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]/span[1]")
	private WebElement yearEndMonthBar;

	@FindBy(xpath = "//span[contains(text(),'December')]")
	private WebElement yearEndMonth;

	@FindBy(xpath = "//body/app-root[1]/div[1]/app-saf[1]/div[2]/div[1]/div[2]/div[1]/div[1]/question-landing-page[1]/div[2]/div[4]/element[1]/div[1]/dropdown-element[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]/span[1]")
	private WebElement typeOfFinancialsBar;

	@FindBy(xpath = "//span[contains(text(),'Annual')]")
	private WebElement typeOfFinancials;

	@FindBy(xpath = "//input[@type = 'file']")
	private WebElement browse;

	@FindBy(xpath = "//button[@class = 'btn next-btn ng-star-inserted']")
	private WebElement nextButton;

	@FindBy(xpath = "//label[contains(text(),'Do you have any Surplus Assets?')]")
	private WebElement doYouHaveAnySurplusAssets;
	
	@FindBy(xpath = "//label[contains(text(),'Debt to Equity')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement debtToEquity;

	private static final Logger logger = Logger.getLogger(ProjectedFinancialsPage.class.getName());

	public ProjectedFinancialsPage(WebDriver driver) {
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

	public void clickOnBrowse(String excelFileProjected) throws InterruptedException {
		logger.info("Starting of clickOnBrowse method");
		
		String osPath = System.getProperty("os.name");
		
		if (osPath.contains("Linux")) {
		
			browse.sendKeys(TEST_FILE_PATH + "/" + excelFileProjected);
		
		} else if(osPath.contains("Mac OS X")){
			
			browse.sendKeys(TEST_FILE_PATH + "/" + excelFileProjected);
			
		} else {
			
			browse.sendKeys(TEST_FILE_PATH + "\\" + excelFileProjected);
		
		}
		
		Thread.sleep(3000);
		
		scrollDown(1000);
		
		logger.info("Ending of clickOnBrowse method");
	
	}

	public String getDoYouHaveAnySurplusAssetsText() {
		logger.info("Starting of getDoYouHaveAnySurplusAssetsText method");
		logger.info("Ending of getDoYouHaveAnySurplusAssetsText method");
		
		return doYouHaveAnySurplusAssets.getText();
	
	}
	
	public void setDebtToEquity(String debtToEquityValue) {
		logger.info("Starting of setDebtToEquity method");
		
		waitForElementVisibilty(debtToEquity);
		
		this.debtToEquity.clear();
		
		this.debtToEquity.sendKeys(debtToEquityValue);
		
		logger.info("Ending of setDebtToEquity method");
		
	}

}
