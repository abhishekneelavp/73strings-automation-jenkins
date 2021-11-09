package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OthersPage extends BaseStrings73AutomationPage {

	@FindBy(xpath = "//div[@class=\"mat-select-value\"]")
	private WebElement anySurplusBar;

	@FindBy(xpath = "//span[contains(text(),'No')]")
	private WebElement anySurplus;

	@FindBy(xpath = "//button[@class = 'btn next-btn ng-star-inserted']")
	private WebElement nextButton;

	@FindBy(xpath = "//label[contains(text(),'Please choose the valuation models you want to use')]")
	private WebElement validationTextForValuationMethods;

	@FindBy(xpath = "//div[contains(text(),'General Details')]")
	private WebElement generalDetails;

	@FindBy(xpath = "//button[contains(text(), 'Submit')]")
	private WebElement submitButton;

	@FindBy(xpath = "//p[contains(text(),'Your application has been submitted successfully!')]")
	private WebElement yourApplicationHasBeenSubmittedSuccessfully;

	@FindBy(xpath = "//span[contains(text(),'Ok')]")
	private WebElement okButton;

	@FindBy(xpath = "//div[contains(text(),'Concluded Enterprise Value')]")
	private WebElement concludedEnterpriseValue;
	
	@FindBy(xpath="//*[contains(text(),'Select')]")
	private WebElement selectbutton;

	private static final Logger logger = Logger.getLogger(OthersPage.class.getName());

	public OthersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void selectAnySurplus() {
		logger.info("Starting of selectAnySurplus method");
		
		waitForElementVisibilty(anySurplusBar);
		
		this.anySurplusBar.click();
		
		waitForElementVisibilty(anySurplus);
		
		this.anySurplus.click();
		
		logger.info("Ending of selectAnySurplus method");
	
	}

	public void clickOnNext() {
		logger.info("Starting of clickOnNext method");
		
		waitForElementVisibilty(nextButton);
		
		clickOnElement(nextButton);
		
		logger.info("Ending of clickOnNext method");
	
	}

	public void clickOnSubmit() throws InterruptedException {
		logger.info("Starting of clickOnSubmit method");
				
		Thread.sleep(2000);
		
		this.scrollDown(1000);
		
		waitForElementVisibilty(submitButton);
	
		clickOnElement(submitButton);
		
		logger.info("Ending of clickOnSubmit method");
	
	}

	public void clickOnOk() throws InterruptedException {
		logger.info("Starting of clickOnOk method");
		
		WebDriverWait wait = new WebDriverWait(driver, 45000);
		wait.until(ExpectedConditions.visibilityOf(okButton));
		
		clickOnElement(okButton);
		
		logger.info("Ending of clickOnOk method");
	
	}

	public String getYourApplicationHasBeenSubmittedSuccessfullyText() {
		logger.info("Starting of getYourApplicationHasBeenSubmittedSuccessfullyText method");
		logger.info("Ending of getYourApplicationHasBeenSubmittedSuccessfullyText method");
		
		WebDriverWait wait = new WebDriverWait(driver, 30000);
		
		wait.until(ExpectedConditions.visibilityOf(yourApplicationHasBeenSubmittedSuccessfully));
		
		return yourApplicationHasBeenSubmittedSuccessfully.getText();
	
	}

	public String getValidationTextForValuationMethodsText() {
		logger.info("Starting of getValidationTextForValuationMethodsText method");
		logger.info("Ending of getValidationTextForValuationMethodsText method");
		
		return validationTextForValuationMethods.getText();
	
	}

	public String getGeneralDetailsText() {
		logger.info("Starting of getGeneralDetailsText method");
		logger.info("Ending of getGeneralDetailsText method");
		
		return generalDetails.getText();
	
	}

	public String getConcludedEnterpriseValueText() {
		logger.info("Starting of getConcludedEnterpriseValueText method");
		logger.info("Ending of getConcludedEnterpriseValueText method");
		
		return concludedEnterpriseValue.getText();
	
	}
}
