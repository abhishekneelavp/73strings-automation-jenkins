package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralDetailsPage extends BaseStrings73AutomationPage {

	@FindBy(xpath = "//label[contains(text(),'Name of the Company')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/following-sibling::div/input")
	private WebElement nameOfCompany;

	@FindBy(xpath = "//label[contains(text(),'Business Description')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/textarea")
	private WebElement businessDescription;

	@FindBy(xpath = "//label[contains(text(),'HQ Country')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement hqCountryName;

	@FindBy(xpath = "(//label[contains(text(),'Country')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input)[2]")
	private WebElement countryName;

	@FindBy(xpath = "//label[contains(text(),'Website')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/following-sibling::div/input")
	private WebElement websiteAddress;

	@FindBy(xpath = "//label[contains(text(),'Industry')]/parent::div/parent::element-header/following-sibling::div/mat-form-field/div/div/div/input")
	private WebElement setIndustry;

	@FindBy(xpath = "//div[@class=\"mat-select-value\"]")
	private WebElement currencyBar;

	@FindBy(xpath = "//button[@class=\"btn next-btn ng-star-inserted\"]")
	private WebElement nextButton;

	@FindBy(xpath = "//label[contains(text(),'Currency')]")
	private WebElement currencyText;

	private static final Logger logger = Logger.getLogger(GeneralDetailsPage.class.getName());

	public GeneralDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void setNameOfCompany(String companyName) {
		logger.info("Starting of setNameOfCompany method");
		
		waitForElementVisibilty(nameOfCompany);

		this.nameOfCompany.sendKeys(companyName);

		logger.info("Ending of setNameOfCompany method");
	}

	public void enterBusinessDescription(String description) {
		logger.info("Starting of enterBusinessDescription method");
		
		waitForElementVisibilty(businessDescription);

		this.businessDescription.sendKeys(description);

		logger.info("Ending of enterBusinessDescription method");
	}

	public void setHQCountry(String hqCountry) throws InterruptedException {
		logger.info("Starting of setHQCountry method");
		
		waitForElementVisibilty(hqCountryName);

		this.hqCountryName.sendKeys(hqCountry);
		
		Thread.sleep(2000);
		
		WebElement selectCountry = driver.findElement(By.xpath("//span[contains(text(),'"+hqCountry+"')]"));
		
		waitForElementVisibilty(selectCountry);

		clickOnElement(selectCountry);

		logger.info("Ending of setHQCountry method");
	}

	public void setCountry(String country) throws InterruptedException {
		logger.info("Starting of setCountry method");
		
		waitForElementVisibilty(countryName);

		this.countryName.sendKeys(country);
		
		Thread.sleep(2000);
		
		WebElement selectCountry = driver.findElement(By.xpath("//span[contains(text(),'"+country+"')]"));
		
		waitForElementVisibilty(selectCountry);

		clickOnElement(selectCountry);

		logger.info("Ending of setCountry method");
	}

	public void setWebsite(String website) {
		logger.info("Starting of setWebsite method");

		scrollDown(1000);
		
		waitForElementVisibilty(websiteAddress);

		this.websiteAddress.sendKeys(website);

		logger.info("Ending of setWebsite method");
	}

	public void setIndustry(String industry) throws InterruptedException {
		logger.info("Starting of setIndustry method");
		
		waitForElementVisibilty(setIndustry);

		this.setIndustry.sendKeys(industry);
		
		Thread.sleep(20000);
		
		WebElement selectIndustry = driver.findElement(By.xpath("//*[contains(text(),'"+industry+"')]"));
		
		Thread.sleep(35000);

		clickOnElement(selectIndustry);
		
		//selectIndustry.click();

		logger.info("Ending of setIndustry method");
	}

	public void selectCurrency(String currency) throws InterruptedException {
		logger.info("Starting of selectCurrency method");
		
		Thread.sleep(10000);

		clickOnElement(currencyBar);
		
		Thread.sleep(6000);
		
		WebElement currencyName = driver.findElement(By.xpath("//span[contains(text(),'"+currency+"')]"));
		
		//waitForElementVisibilty(currencyName);
		
		clickOnElement(currencyName);

		logger.info("Ending of selectCurrency method");
	}

	public void clickOnNext() {
		logger.info("Starting of clickOnNext method");
		
		waitForElementVisibilty(nextButton);

		clickOnElement(nextButton);

		logger.info("Ending of clickOnNext method");
	}

	public String getCurrencyText() {
		logger.info("Starting of getCurrencyText method");
		logger.info("Ending of getCurrencyText method");

		return currencyText.getText();
	}
}
