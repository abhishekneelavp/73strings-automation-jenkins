package com.strings73.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EctAnalysisPage extends BaseStrings73AutomationPage {
	@FindBy(xpath = "//input[@id=\"mat-input-0\"]")
	private WebElement emailField;

	@FindBy(xpath = "//input[@type=\"password\"]")
	private WebElement passwordField;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	private WebElement loginButton;

	@FindBy(xpath = "//p[contains(text(),'val_pitch')]")
	private WebElement clickFund;

	@FindBy(xpath = "(//span[contains(text(),'Adobe')])[1]")
	private WebElement company;

	@FindBy(xpath = "//i[@class=\"fas fa-ellipsis-v ellipsis-icon\"]")
	private WebElement threeDots;

	@FindBy(xpath = "//button[contains(text(),'Show valuation dates')]")
	private WebElement showValuationDates;

	@FindBy(xpath = "(//i[@class=\"fas fa-binoculars action-icon icon-active ng-star-inserted\"])[1]")
	private WebElement binocularIcon;

	@FindBy(xpath = "//img[@class=\"lock-button ng-star-inserted\"]")
	private WebElement unlock;
	
	@FindBy(xpath = "(//div[@ng-reflect-disabled=\"false\"])[4]")
	private WebElement forwardButtonForHeader;

	@FindBy(xpath = "//a[contains(text(),' ECT Analysis ')]")
	private WebElement ectAnalysis;

	@FindBy(xpath = "//input[@data-placeholder=\"Start typing to see suggestions\"]")
	private WebElement ticker;

	@FindBy(xpath = "(//div[@class=\"mat-select-arrow\"])[1]")
	private WebElement quatar;

	@FindBy(xpath = "//mat-option[@value=\"Q4 2020\"]")
	private WebElement quatarDropdown;

	@FindBy(xpath = "(//div[@class=\"mat-select-arrow-wrapper\"])[2]")
	private WebElement lookBack;

	@FindBy(xpath = "//mat-option[@value=\"4\"]")
	private WebElement lookBackDropdown;

	@FindBy(xpath = "(//span[contains(text(),'Fetch')])[1]")
	private WebElement fetch1;

	@FindBy(xpath = "(//div[@style=\"background: rgb(200, 253, 179);\"])[1]")
	private WebElement ktdPercentage;

	@FindBy(xpath = "(//td[@class=\"td-stylling textAlignCenter ng-star-inserted\"])[61]")
	private WebElement faPercentage;

	@FindBy(xpath = "//input[@placeholder=\"Add keyword here...\"]")
	private WebElement addKeyWord;

	@FindBy(xpath = "//span[contains(text(),'Fetch Keyword Data')]")
	private WebElement fetchKeywordData;

	@FindBy(xpath = "(//mat-icon[contains(text(),'cancel')])[12]")
	private WebElement cancel;

	public EctAnalysisPage(WebDriver driver) {
		
		super(driver);
		
		PageFactory.initElements(driver, this);
	}

	public void userEmail(String userName) {
		
		waitForElementVisibilty(emailField);
		
		this.emailField.sendKeys(userName);
	}

	public void userPassword(String password) {
		
		waitForElementVisibilty(passwordField);
		
		this.passwordField.sendKeys(password);
	}

	public void clickOnLogin() {
		
		waitForElementVisibilty(loginButton);
		
		this.loginButton.click();
	}

	public void clickOnFund() {
		
		waitForElementVisibilty(clickFund);
		
		this.clickFund.click();
	}

	public void selectCompany() {
		
		waitForElementVisibilty(company);
		
		this.company.click();
	}

	public void clickOn3dots() {
		
		waitForElementVisibilty(threeDots);
		
		this.threeDots.click();
	}

	public void ClickOnshowValuationDates() {
		
		waitForElementVisibilty(showValuationDates);
		
		this.showValuationDates.click();
	}

	public void clickOnBinacularIcon() {
		
		waitForElementVisibilty(binocularIcon);
		
		this.binocularIcon.click();
	}

	public void clickOnLock() {
		
		waitForElementVisibilty(unlock);
		
		this.unlock.click();
	}

	public void clickOnEctAnalysisIcon() throws InterruptedException {
		
		//waitForElementVisibilty(forwardButtonForHeader);
		
		//this.forwardButtonForHeader.click();
		
		waitForElementVisibilty(ectAnalysis);
		
		this.ectAnalysis.click();
	}

	public void clickOnTicker(String addticker) throws InterruptedException {
		
		waitForElementVisibilty(ticker);
		
		this.ticker.click();
		
		waitForElementVisibilty(ticker);
		
		this.ticker.sendKeys(addticker);
	}

	public void clickOnQuatar() throws InterruptedException {
		
		waitForElementVisibilty(quatar);
		
		this.quatar.click();
		
		waitForElementVisibilty(quatarDropdown);
		
		this.quatarDropdown.click();
	}

	public void clickOnLookBook() throws InterruptedException {
		
		waitForElementVisibilty(lookBack);
		
		this.lookBack.click();
		
		this.lookBackDropdown.click();
	}

	public void clickOnFetch() throws InterruptedException {
		
		waitForElementVisibilty(fetch1);
		
		this.fetch1.click();
		
	}

	public void inspectKeyTopicDistribution() throws InterruptedException {
		
		this.scrollDown(300);
		
		waitForElementVisibilty(ktdPercentage);
		
		this.ktdPercentage.click();
	}

	public void inspectFundamentalAnalysis() throws InterruptedException {
		
		this.scrollDown(500);
	    
		waitForElementVisibilty(faPercentage);
		
		this.faPercentage.click();
	}

	public void inspectKeywordTimeSeries(String keyword) throws InterruptedException {
		
		this.scrollDown(700);
		
		waitForElementVisibilty(addKeyWord);
		
		this.addKeyWord.sendKeys(keyword);
	}

	public void clickOnFetchKeyWord() {
		
		waitForElementVisibilty(fetchKeywordData);
		
		this.fetchKeywordData.click();
	}

	public void deleteKeyword() {
		
		waitForElementVisibilty(cancel);
		
		this.cancel.click();

	}

	public void inspectGeographicalFocus() {
		
		this.scrollDown(800);

	}

	public void inspectTopicSentiment() {
		
		this.scrollDown(900);
		
	}

	public void inspectControversialTopics() {
		
		this.scrollDown(1000);
		
	}

	public void inspectExecutiveSummary() throws InterruptedException {
		
		this.scrollDown(1000);
		Thread.sleep(3000);
		this.scrollDown(-1000);
		Thread.sleep(3000);
		this.scrollDown(-500);
		Thread.sleep(3000);
		this.scrollDown(-100);
	
		
		
	}

}
