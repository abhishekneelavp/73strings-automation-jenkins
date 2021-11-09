package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PortfolioSummaryPage extends BaseStrings73AutomationPage {

	@FindBy(xpath = "//span[contains(text(),'Add Company')]")
	private WebElement addCompanyText;

	@FindBy(xpath = "//img[@src=\"assets/imgs/add_icon.svg\"]")
	private WebElement addCompanyIcon;

	@FindBy(xpath = "//button[contains(text(),'Add Company')]")
	private WebElement addCompanyButton;

	@FindBy(xpath = "(//input[starts-with(@id, 'mat-input-')])[2]")
	private WebElement setCompanyName;

	@FindBy(xpath = "(//input[starts-with(@id, 'mat-input-')])[1]")
	private WebElement newFundCompanyName;

	@FindBy(xpath = "//mat-select[@id=\"mat-select-5\"]")
	private WebElement securityDropdown;

	@FindBy(xpath = "//mat-select[@id=\"mat-select-5\"]")
	private WebElement newFundSecurityDropdown;

//	@FindBy(xpath = "(//input[starts-with(@id, 'mat-input-')])[3]")
//	private WebElement investmentDate;

	@FindBy(xpath = "(//input[starts-with(@id, 'mat-input-')])[3]")
	private WebElement investmentDate;
	
	@FindBy(xpath = "//*[@class=\"mat-calendar-arrow\"]")
	private WebElement dateArrow;

	@FindBy(xpath = "(//input[starts-with(@id, 'mat-input-')])[2]")
	private WebElement newFundInvestmentDate;

	@FindBy(xpath = "(//input[starts-with(@id, 'mat-input-')])[4]")
	private WebElement noOfBusinessUnits;

	@FindBy(xpath = "(//input[starts-with(@id, 'mat-input-')])[3]")
	private WebElement newFundNoOfBusinessUnits;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement save;

	@FindBy(xpath = "(//span[contains(text(),'Ok' )])")
	private WebElement ok;

	@FindBy(xpath = "//button[@class=\"btn-delete-icon ng-star-inserted\"]")
	private WebElement deleteIcon;

	@FindBy(xpath = "//span[contains(text(),'Delete Company')]")
	private WebElement deleteCompanyText;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElement delete;

	@FindBy(xpath = "//span[contains(text(),'Delete Companies')]")
	private WebElement deleteCompaniesText;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	private WebElement yesButton;

	@FindBy(xpath = "//span[contains(text(),'Deleted Successfully!')]")
	private WebElement deletedSuccessfullyText;

	@FindBy(xpath = "//button[@class=\"btn btn-save\"]")
	private WebElement deletedOk;

	@FindBy(xpath = "//div[@class=\"modal-header\"]")
	private WebElement outsideClick;

	@FindBy(xpath = "//div[starts-with(@class, 'mat-select-arrow ng-tns-')]")
	private WebElement currencyDropdown;

	@FindBy(xpath = "//button[@class=\"btn-download-icon\"]")
	private WebElement downloadButton;

	@FindBy(xpath = "//i[@class=\"fas fa-ellipsis-v ellipsis-icon\"]")
	private WebElement menu;

	@FindBy(xpath = "//button[contains(text(),'Show Fund Summary')]")
	private WebElement showFundSummary;

	@FindBy(xpath = "//button[contains(text(),'Currency Dashboard')]")
	private WebElement currencyDashboard;

	@FindBy(xpath = "//button[contains(text(),'Go To Dashboard')]")
	private WebElement goToDashboard;

	@FindBy(xpath = "//button[contains(text(),'Go To Approval Matrix')]")
	private WebElement goToApprovalMatrix;

	@FindBy(xpath = "(//span[contains(text(), 'Add')])[1]")
	private WebElement gainerAddButton;

	@FindBy(xpath = "(//span[contains(text(), 'Add')])[2]")
	private WebElement loserAddButton;

	@FindBy(xpath = "(//span[contains(text(), 'Add')])[4]")
	private WebElement addButton;

	@FindBy(xpath = "(//div[@class=\"mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin\"])[1]")
	private WebElement gainersCheckbox;

	@FindBy(xpath = "(//div[@class=\"mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin\"])[2]")
	private WebElement losersCheckbox;

	@FindBy(xpath = "(//i[@class=\"far fa-trash-alt font-size\"])[1]")
	private WebElement deleteGainer;

	@FindBy(xpath = "(//i[@class=\"far fa-trash-alt font-size\"])[2]")
	private WebElement deleteLoser;

	private static final Logger logger = Logger.getLogger(PortfolioSummaryPage.class.getName());

	public PortfolioSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddCompanyIcon() {
		logger.info("Starting of clickOnAddCompanyIcon method");
		
		waitForElementVisibilty(addCompanyIcon);

		this.addCompanyIcon.click();

		logger.info("Ending of clickOnAddCompanyIcon method");

	}

	public void clickOnAddCompanyButton() {
		logger.info("Starting of clickOnAddCompanyButton method");

		scrollDown(500);
		
		waitForElementVisibilty(addCompanyButton);

		this.addCompanyButton.click();

		logger.info("Ending of clickOnAddCompanyButton method");

	}

	public void setCompanyName(String newCompanyName) throws InterruptedException {
		logger.info("Starting of setCompanyName method");
		
		waitForElementVisibilty(setCompanyName);

		this.setCompanyName.sendKeys(newCompanyName);

		waitForElementVisibilty(outsideClick);

		this.outsideClick.click();

		logger.info("Ending of setCompanyName method");

	}

	public void setNewFundCompanyName(String newCompanyName) throws InterruptedException {
		logger.info("Starting of setNewFundCompanyName method");
		
		waitForElementVisibilty(newFundCompanyName);

		this.newFundCompanyName.sendKeys(newCompanyName);

		waitForElementVisibilty(outsideClick);

		this.outsideClick.click();

		logger.info("Ending of setNewFundCompanyName method");
	}

	public void selectCompanyName(String companyName) {
		logger.info("Starting of selectCompanyName method");

		WebElement selectCompany = driver.findElement(By.xpath("(//span[contains(text(), '" + companyName + "')])[1]"));
		
		waitForElementVisibilty(selectCompany);

		selectCompany.click();

		logger.info("Ending of selectCompanyName method");
	}

	public void clickOnSecurityDroprdown() {
		logger.info("Starting of clickOnSecurityDroprdown method");
		
		waitForElementVisibilty(securityDropdown);
		
		clickOnElement(securityDropdown);

		logger.info("Ending of clickOnSecurityDroprdown method");
	}

	public void clickOnNewFundSecurityDropdown() {
		logger.info("Starting of clickOnNewFundSecurityDropdown method");
		
		waitForElementVisibilty(newFundSecurityDropdown);

		clickOnElement(newFundSecurityDropdown);

		logger.info("Ending of clickOnNewFundSecurityDropdown method");
	}

	public void selectSecurity(String securityType) {
		logger.info("Starting of selectSecurity method");

		WebElement security = driver.findElement(By.xpath("//mat-option[@value = '" + securityType + "']"));
		
		waitForElementVisibilty(security);

		clickOnElement(security);

		logger.info("Ending of selectSecurity method");
	}

	public void clickOnInvestmentDate() {
		logger.info("Starting of clickOnInvestmentDate method");
		
		waitForElementVisibilty(investmentDate);

		this.investmentDate.click();

		logger.info("Ending of clickOnInvestmentDate method");

	}

	public void clickOnNewFundInvestmentDate() {
		logger.info("Starting of clickOnNewFundInvestmentDate method");
		
		waitForElementVisibilty(newFundInvestmentDate);

		this.newFundInvestmentDate.click();

		logger.info("Ending of clickOnNewFundInvestmentDate method");
	}

	public void selectInvestmentDate(String date) {
		logger.info("Starting of selectInvestmentDate method");

		WebElement selectDate = driver.findElement(By.xpath("//td[@aria-label= '" + date + "']"));
		
		waitForElementVisibilty(selectDate);

		clickOnElement(selectDate);

		logger.info("Ending of selectInvestmentDate method");

	}

	public void setNoOfBusinessUnits(String businessUnits) {
		logger.info("Starting of setNoOfBusinessUnits method");
		
		waitForElementVisibilty(noOfBusinessUnits);

		this.noOfBusinessUnits.clear();

		this.noOfBusinessUnits.sendKeys(businessUnits);

		logger.info("Ending of setNoOfBusinessUnits method");

	}

	public void setNewFundNoOfBusinessUnits(String businessUnits) {
		logger.info("Starting of setNewFundNoOfBusinessUnits method");
		
		waitForElementVisibilty(newFundNoOfBusinessUnits);

		this.newFundNoOfBusinessUnits.clear();

		this.newFundNoOfBusinessUnits.sendKeys(businessUnits);

		logger.info("Ending of setNewFundNoOfBusinessUnits method");
	}

	public void clickOnSave() {
		logger.info("Starting of clickOnSave method");
		
		waitForElementVisibilty(save);

		this.save.click();

		logger.info("Ending of clickOnSave method");

	}

	public void clickOnOk() {
		logger.info("Starting of clickOnOk method");
		
		waitForElementVisibilty(ok);

	    clickOnElement(ok);

		logger.info("Ending of clickOnOk method");

	}

	public void clickOnCompanyName(String companyName) throws InterruptedException {
		logger.info("Starting of clickOnCompanyName method");
     
		   scrollDown(1300);
		
           Thread.sleep(6000);
		
		WebElement company = driver.findElement(By.xpath("(//span[contains(text(), '" + companyName + "')])[1]"));
		
		waitForElementVisibilty(company);

		clickOnElement(company);

		logger.info("Ending of clickOnCompanyName method");

	}

	public String getCompanyNameValuationIsInitiatedText(String companyName) {
		logger.info("Starting of getCompanyNameValuationIsInitiatedText method");

		WebElement companyValuation = driver.findElement(By.xpath("//p[starts-with(text(),'" + companyName + "' )]"));

		logger.info("Ending of getCompanyNameValuationIsInitiatedText method");

		return companyValuation.getText();

	}
	/*
	 * public boolean isBMWGroupValuationIsInitiatedDisable() {
	 * logger.info("Starting of isCreateShipmentDisable method");
	 * logger.info("Ending of isCreateShipmentDisable method");
	 * 
	 * return bmwGroupValuationIsInitiated.isEnabled();
	 * 
	 * }
	 */

	public String getAddCompanyText() {
		logger.info("Starting of getAddCompanyText method");
		logger.info("Ending of getAddCompanyText method");

		return addCompanyText.getText();

	}

	public String getCompanyNameText(String companyName) {
		logger.info("Starting of getCompanyNameText method");

		WebElement companyNameText = driver
				.findElement(By.xpath("(//span[contains(text(),'" + companyName + "')])[1]"));

		logger.info("Ending of getCompanyNameText method");

		return companyNameText.getText();
	}

	public void clickOnDeleteIcon() {
		logger.info("Starting of clickOnDeleteIcon method");
		
		waitForElementVisibilty(deleteIcon);

		clickOnElement(deleteIcon);

		logger.info("Ending of clickOnDeleteIcon method");
	}

	public void clickOnCheckbox(String companyName) {
		logger.info("Starting of clickOnCheckbox method");

		WebElement checkBox = driver.findElement(By.xpath("(//span[contains(text(), '" + companyName + "')])[3]"));
		
		waitForElementVisibilty(checkBox);

		clickOnElement(checkBox);

		logger.info("Ending of clickOnCheckbox method");
	}

	public void clickOnDelete() {
		logger.info("Starting of clickOnDelete method");
		
		waitForElementVisibilty(delete);

		clickOnElement(delete);

		logger.info("Ending of clickOnDelete method");
	}

	public void clickOnYes() {
		logger.info("Starting of clickOnYes method");
		
		waitForElementVisibilty(yesButton);

		clickOnElement(yesButton);

		logger.info("Ending of clickOnYes method");
	}

	public void clickOnDeleteOk() {
		logger.info("Starting of clickOnDeleteOk method");
		
		waitForElementVisibilty(deletedOk);

		clickOnElement(deletedOk);

		logger.info("Ending of clickOnDeleteOk method");
	}

	public String getDeleteCompanyText() {
		logger.info("Starting of getDeleteCompanyText method");
		logger.info("Ending of getDeleteCompanyText method");

		return deleteCompanyText.getText();
	}

	public String getDeleteCompaniesText() {
		logger.info("Starting of getDeleteCompaniesText method");
		logger.info("Ending of getDeleteCompaniesText method");

		return deleteCompaniesText.getText();
	}

	public String getDeletedSuccessfullyText() {
		logger.info("Starting of getDeletedSuccessfullyText method");
		logger.info("Ending of getDeletedSuccessfullyText method");

		return deletedSuccessfullyText.getText();
	}

	public void clickOnCurrencyDropdown() {
		logger.info("Starting of clickOnCurrencyDropdown method");
		
		waitForElementVisibilty(currencyDropdown);

		this.currencyDropdown.click();

		logger.info("Ending of clickOnCurrencyDropdown method");

	}

	public void selectCurrency(String currency) {
		logger.info("Starting of selectCurrency method");

		WebElement currencyName = driver.findElement(By.xpath("//span[contains(text(),'" + currency + "')]"));
		
		waitForElementVisibilty(currencyName);

		currencyName.click();

		scrollDown(700);

		logger.info("Ending of selectCurrency method");

	}

	public String getChangedCurrencyText(String changedCurrency) {
		logger.info("Starting of getChangedCurrencyText method");

		WebElement currencyText = driver
				.findElement(By.xpath("(//td[contains(text(), '" + changedCurrency + "')])[1]"));

		logger.info("Ending of getChangedCurrencyText method");

		return currencyText.getText();

	}

	public void clickOnDownloadButton() {
		logger.info("Starting of clickOnDownloadButton method");
		
		waitForElementVisibilty(downloadButton);

		clickOnElement(downloadButton);

		logger.info("Ending of clickOnDownloadButton method");

	}

	public void clickOnMenu() {
		logger.info("Starting of clickOnMenu method");
		
		waitForElementVisibilty(menu);

		clickOnElement(menu);

		logger.info("Ending of clickOnMenu method");

	}

	public void clickOnShowFundSummary() {
		logger.info("Starting of clickOnShowFundSummary method");
		
		waitForElementVisibilty(showFundSummary);

		clickOnElement(showFundSummary);

		logger.info("Ending of clickOnShowFundSummary method");

	}

	public void clickOnGainersAddButton() {
		logger.info("Starting of clickOnGainersAddButton method");
		
		waitForElementVisibilty(gainerAddButton);

		clickOnElement(gainerAddButton);

		logger.info("Ending of clickOnGainersAddButton method");
	}

	public void clickOnLosersAddButton() {
		logger.info("Starting of clickOnLosersAddButton method");
		
		waitForElementVisibilty(loserAddButton);

		clickOnElement(loserAddButton);

		logger.info("Ending of clickOnLosersAddButton method");
	}

	public void selectTopGainer() {
		logger.info("Starting of selectTopGainer method");
		
		waitForElementVisibilty(gainersCheckbox);

		clickOnElement(gainersCheckbox);

		logger.info("Ending of selectTopGainer method");
	}

	public void selectTopLoser() {
		logger.info("Starting of selectTopLoser method");
		
		waitForElementVisibilty(losersCheckbox);

		clickOnElement(losersCheckbox);

		logger.info("Ending of selectTopLoser method");
	}

	public void clickOnAddButton() {
		logger.info("Starting of clickOnAddButton method");
		
		waitForElementVisibilty(addButton);

		clickOnElement(addButton);

		logger.info("Ending of clickOnAddButton method");
	}

	public void clickOnDeleteGainer() {
		logger.info("Starting of clickOnDeleteGainer method");
		
		waitForElementVisibilty(deleteGainer);

		clickOnElement(deleteGainer);

		logger.info("Ending of clickOnDeleteGainer method");
	}

	public void clickOnDeleteLoser() {
		logger.info("Starting of clickOnDeleteLoser method");
		
		waitForElementVisibilty(deleteLoser);

		clickOnElement(deleteLoser);

		logger.info("Ending of clickOnDeleteLoser method");
	}

	public void clickOnCurrencyDashboard() {
		logger.info("Starting of clickOnCurrencyDashboard method");
		
		waitForElementVisibilty(currencyDashboard);

		clickOnElement(currencyDashboard);

		logger.info("Ending of clickOnCurrencyDashboard method");

	}

	public void clickOnGoToDashboard() {
		logger.info("Starting of clickOnGoToDashboard method");
		
		waitForElementVisibilty(goToDashboard);

		clickOnElement(goToDashboard);

		logger.info("Ending of clickOnGoToDashboard method");

	}

	public void clickOnGoToApprovalMatrix() {
		logger.info("Starting of clickOnGoToApprovalMatrix method");
		
		waitForElementVisibilty(goToApprovalMatrix);

		clickOnElement(goToApprovalMatrix);

		logger.info("Ending of clickOnGoToApprovalMatrix method");

	}
	
	public void clickOnDateArrow() {
		logger.info("Starting of clickOnDateArrow method");
		
		waitForElementVisibilty(dateArrow);
		
		clickOnElement(dateArrow);
		
		logger.info("Ending of clickOnDateArrow method");
		
	}
	
	public void selectYear(String year) {
		logger.info("Starting of selectYear method");
		
		WebElement yearValue = driver.findElement(By.xpath("//div[text() = '"+year+"']"));
		
		waitForElementVisibilty(yearValue);
		
		clickOnElement(yearValue);
		
		logger.info("Ending of selectYear method");
		
	}
	
	public void selectMonth(String month) {
		logger.info("Starting of selectMonth method");
		
		WebElement monthValue = driver.findElement(By.xpath("//div[contains(text(),'"+month+"')]"));
		
		waitForElementVisibilty(monthValue);
		
		clickOnElement(monthValue);
		
		logger.info("Ending of selectMonth method");
		
	}
	
	public void setInvestmentDate(String year, String month, String date) {
		logger.info("Starting of setInvestmentDate method");
		
		clickOnInvestmentDate();
		
		clickOnDateArrow();
		
		selectYear(year);
		
		selectMonth(month);
		
		selectInvestmentDate(date);
		
		logger.info("Ending of setInvestmentDate method");
		
	}

}
