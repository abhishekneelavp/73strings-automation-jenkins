package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundsPage extends BaseStrings73AutomationPage {

	@FindBy(xpath = "//span[contains(text(),'Add Report')]")
	private WebElement addReportButton;

	@FindBy(xpath = "//h4[contains(text(),'Create a Report')]")
	private WebElement createReportPopUp;

	@FindBy(xpath = "//input[starts-with(@id, 'mat-input-')]")
	private WebElement reportNameBar;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement reportCreateButton;

	@FindBy(xpath = "//span[contains(text(),'Add Fund')]")
	private WebElement addFundButton;

	@FindBy(xpath = "//h4[contains(text(),'Create a Fund')]")
	private WebElement createFundPopUp;

	@FindBy(xpath = "//input[starts-with(@id, 'mat-input-')]")
	private WebElement fundNameBar;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement fundCreateButton;

	@FindBy(xpath = "//span[contains(text(),'Portfolio')]")
	private WebElement portfolioSummary;

	@FindBy(xpath = "//*[contains(text(), 'User Assignment')]")
	private WebElement userassignment;
	// *[@id="myDropdown"]
	
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	private WebElement saveButton;

	private static final Logger logger = Logger.getLogger(FundsPage.class.getName());

	public FundsPage(WebDriver driver) {

		super(driver);
		
		PageFactory.initElements(driver, this);

	}

	public void clickOnAddFund() {
		logger.info("Starting of clickOnAddFund method");
		
		waitForElementVisibilty(addFundButton);

		this.addFundButton.click();

		logger.info("Ending of clickOnAddFund method");

	}

	public void setFundName(String newFundName) {
		logger.info("Starting of setFundName method");
		
		waitForElementVisibilty(fundNameBar);

		this.fundNameBar.sendKeys(newFundName);

		logger.info("Ending of setFundName method");

	}

	public void clickOnFundCreateButton() {
		logger.info("Starting of clickOnFundCreateButton method");
		
		waitForElementVisibilty(fundCreateButton);

		this.fundCreateButton.click();

		logger.info("Ending of clickOnFundCreateButton method");

	}

	public void clickOnFund(String fundName) {
		logger.info("Starting of clickOnFund method");

		WebElement fund = driver.findElement(By.xpath("//p[contains(text(),'" + fundName + "')]"));
		
		waitForElementVisibilty(fund);

		fund.click();

		logger.info("Ending of clickOnFund method");

	}

	public void clickOnHambugerIcon(String fundName) throws InterruptedException {
		logger.info("Starting of clickOnHambugerIcon method");

		Thread.sleep(5000);

		WebElement hamburger = driver
				.findElement(By.xpath("//p[contains(text(), '" + fundName + "')]/parent::div/parent::div/button/i"));

		mouseHover(hamburger);

		// clickOnElement(hamburger);

		logger.info("Ending of clickOnHambugerIcon method");

	}

	public void clickOnAccessType(String userName) {
		logger.info("Starting of clickOnAccessType method");

		WebElement accessTypeDropdown = driver.findElement(By.xpath("//td[contains(text(), '" + userName
				+ "')]/following-sibling::td/following-sibling::td/*/div/div/div/*/div/div[starts-with(@class, 'mat-select-arrow-wrapper ng-tns-c141-')]"));

		clickOnElement(accessTypeDropdown);

		logger.info("Ending of clickOnAccessType method");

	}

	public void selectAccessType(String access) {

		WebElement accessType = driver.findElement(By.xpath("(//span[contains(text(),'" + access + "')])[1]"));

		clickOnElement(accessType);

	}

	public void clickOnAddReport() {
		logger.info("Starting of clickOnAddReport method");

		this.addReportButton.click();

		logger.info("Ending of clickOnAddReport method");

	}

	public void setReportName(String newReportName) {
		logger.info("Starting of setReportName method");

		this.reportNameBar.sendKeys(newReportName);

		logger.info("Ending of setReportName method");

	}

	public void clickOnReportCreateButton() {
		logger.info("Starting of clickOnReportCreateButton method");

		this.reportCreateButton.click();

		logger.info("Ending of clickOnReportCreateButton method");

	}

	public void clickOnReport(String reportName) {
		logger.info("Starting of clickOnReport method");

		WebElement report = driver.findElement(By.xpath("//p[contains(text(),'" + reportName + "')]"));

		report.click();

		logger.info("Ending of clickOnReport method");
	}

	public void clickOnUserAssignment() {
		logger.info("Starting of clickOnUserAssignment method");

		mouseHover(userassignment);

		logger.info("Ending of clickOnUserAssignment method");

	}

	public String getCreateReportPopUpText() {
		logger.info("Starting of getCreateReportPopUpText method");
		logger.info("Ending of getCreateReportPopUpText method");

		return createReportPopUp.getText();

	}

	public String getCreateFundPopUpText() {
		logger.info("Starting of getCreateFundPopUpText method");
		logger.info("Ending of getCreateFundPopUpText method");

		return createFundPopUp.getText();

	}

	public String getPortfolioSummaryText() {
		logger.info("Starting of getPortfolioSummaryText method");
		logger.info("Ending of getPortfolioSummaryText method");

		return portfolioSummary.getText();

	}
	
	public void clickOnSave() {
		logger.info("Starting of clickOnSave method");
		
		clickOnElement(saveButton);
		
		logger.info("Ending of clickOnSave method");
		
	}

}
