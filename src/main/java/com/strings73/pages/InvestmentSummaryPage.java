 package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvestmentSummaryPage extends BaseStrings73AutomationPage{
	
	@FindBy(xpath = "//i[@class=\"fas fa-ellipsis-v ellipsis-icon\"]")
	private WebElement menu;

	@FindBy(xpath = "//button[contains(text(),'Show valuation dates')]")
	private WebElement showValuationDates;

	@FindBy(xpath = "//th[contains(text(),'Valuation Amount')]")
	private WebElement valuationAmount;

	@FindBy(xpath = "//i[@class=\"fa fa-edit action-icon grey-text icon-active\"]")
	private WebElement edit;
	
	@FindBy(xpath = "//label[contains(text(),'Name of the Company')]")
	private WebElement nameOfTheCompanyText;
	
	@FindBy(xpath = "(//input[starts-with(@id,'mat-input-')])[1]")
	private WebElement datePicker;
	
	@FindBy(xpath = "//*[@class=\"mat-calendar-arrow\"]")
	private WebElement dateArrow;
	
	@FindBy(xpath = "//*[contains(text(),'Add')]//parent::button//parent::td//button")
	private WebElement add;
	
	@FindBy(xpath = "//span[contains(text(),'Ok')]")
	private WebElement okButton;
	
	@FindBy(xpath = "(//div[@id='highcharts-mcjajth-0']/*/*/*/*/*[1])[1]")
	private WebElement navBar;
	
	@FindBy(xpath = "(//i[starts-with(@class, 'fas fa-binoculars')])[1]")
	private WebElement binocularIcon;
	
	
	
	private static final Logger logger = Logger.getLogger(InvestmentSummaryPage.class.getName());

	public InvestmentSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenu() {
		logger.info("Starting of clickOnMenu method");
		
		waitForElementVisibilty(menu);

		clickOnElement(menu);

		logger.info("Ending of clickOnMenu method");
	}

	public void clickOnShowValuationDates() {
		logger.info("Starting of clickOnShowValuationDates method");
		
		waitForElementVisibilty(showValuationDates);

		clickOnElement(showValuationDates);

		logger.info("Ending of clickOnShowValuationDates method");
	}

	public void clickOnEdit() throws InterruptedException {
		logger.info("Starting of clickOnEdit method");
		
		sleep(3000);
		
		waitForElementVisibilty(edit);

		clickOnElement(edit);
		
		Thread.sleep(15000);

		logger.info("Ending of clickOnEdit method");
	}
	
	public void clickOnDatePicker() {
		logger.info("Starting of clickOnDatePicker method");
		
		waitForElementVisibilty(datePicker);
		
		this.datePicker.click();
		
		logger.info("Ending of clickOnDatePicker method");
		
	}
	
	public void selectFutureDate(String futureValuationDate) {
		logger.info("Starting of selectFutureDate method");
		
		WebElement futureDate = driver.findElement(By.xpath("//td[@aria-label='"+futureValuationDate+"']"));
		
		waitForElementVisibilty(futureDate);
		
		futureDate.click();
		
		logger.info("Ending of selectFutureDate method");
		
	}
	
	public void clickOnAdd() throws InterruptedException {
		logger.info("Starting of clickOnAdd method");
		
		waitForElementVisibilty(add);
		
		clickOnElement(add);
		
		
		
		logger.info("Ending of clickOnAdd method");
		
	}
	
	public void clickOnOk() throws InterruptedException {
		logger.info("Starting of clickOnOk method");
		
		waitForElementVisibilty(okButton);
		
		this.okButton.click();
		
		logger.info("Ending of clickOnOk method");
	}
	
	public void clickOnNavBar() {
		logger.info("Starting of clickOnNavBar method");
		
		waitForElementVisibilty(navBar);
		
		this.navBar.click();
		
		logger.info("Ending of clickOnNavBar method");	
	}
	
	public String getValuationAmountText() {
		logger.info("Starting of getValuationAmountText method");
		logger.info("Ending of getValuationAmountText method");

		return valuationAmount.getText();
	}

	public String getNameOfTheCompanyText() {
		logger.info("Starting of getNameOfTheCompanyText method");
		logger.info("Ending of getNameOfTheCompanyText method");

		return nameOfTheCompanyText.getText();
	}
	
	public String getCompanyNameValuationIsInitiatedText(String companyName) {
		logger.info("Starting of getCompanyNameValuationIsInitiatedText method");

		WebElement companyValuation = driver.findElement(By.xpath("//p[starts-with(text(),'" + companyName + "' )]"));

		logger.info("Ending of getCompanyNameValuationIsInitiatedText method");

		return companyValuation.getText();

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
	
	public void setRollOverDate(String year, String month, String futureValuationDate) {
		logger.info("Starting of setRollOverDate method");
		
		clickOnDatePicker();
		
		clickOnDateArrow();
		
		selectYear(year);
		
		selectMonth(month);
		
		selectFutureDate(futureValuationDate);
		
		logger.info("Ending of setRollOverDate method");
		
	}
	
	public void clickOnBinocularIcon() {
		logger.info("Starting of clickOnBinocularIcon method");
		
		waitForElementVisibilty(binocularIcon);
		
		clickOnElement(binocularIcon);
		
		logger.info("Ending of clickOnBinocularIcon method");
		
	}
	
}
