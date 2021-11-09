package com.strings73.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsAnaylsisPage extends BaseStrings73AutomationPage {

	@FindBy(xpath = "//input[@id=\"mat-input-0\"]")
	private WebElement emailField;

	@FindBy(xpath = "//input[@type=\"password\"]")
	private WebElement passwordField;

	@FindBy(xpath = "//*[contains(text(),'Login')]")
	private WebElement loginButton;

	@FindBy(xpath = "//i[@class=\"fas fa-ellipsis-v ellipsis-icon\"]")
	private WebElement threeDots;

	@FindBy(xpath = "(//i[@class=\"fas fa-binoculars action-icon icon-active ng-star-inserted\"])[1]")
	private WebElement binocularIcon;

	@FindBy(xpath = "//img[@class=\"lock-button ng-star-inserted\"]")
	private WebElement unlock;

	@FindBy(xpath = "(//div[@ng-reflect-disabled=\"false\"])[4]")
	private WebElement forwardButton;

	@FindBy(xpath = "//a[contains(text(),'News Analysis - Beta')]")
	private WebElement newsAnaylsis;

	@FindBy(xpath = "//input[@aria-autocomplete=\"list\"]")
	private WebElement searchBar;

	@FindBy(xpath = "//span[contains(text(),'Fetch')]")
	private WebElement fetchButton;

	@FindBy(xpath = "(//div[@class=\"mat-radio-inner-circle\"])[1]")
	private WebElement nonNegativeNews;

	@FindBy(xpath = "(//b[contains(text(),'Negative News')])[2]")
	private WebElement negativeNews;

	@FindBy(xpath = "//span[contains(text(),'News Article')]")
	private WebElement newsArticle;

	public NewsAnaylsisPage(WebDriver driver) {
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

	public void clickOnFund(String fundName) {

		WebElement clickFund = driver.findElement(By.xpath("//p[contains(text(),'" + fundName + "')]"));

		waitForElementVisibilty(clickFund);

		clickFund.click();

	}

	public void selectCompany(String company1) {

		WebElement company = driver.findElement(By.xpath("(//span[contains(text(),'" + company1 + "')])[1]"));

		waitForElementVisibilty(company);

		company.click();
	}

	public void clickOn3dots() {

		waitForElementVisibilty(threeDots);

		this.threeDots.click();
	}

	public void ClickOnOption(String three3otsOptions) {

		WebElement options = driver.findElement(By.xpath("//button[contains(text(),'" + three3otsOptions + "')]"));

		waitForElementVisibilty(options);

		options.click();
	}

	public void clickOnBinacularIcon() {

		waitForElementVisibilty(binocularIcon);

		this.binocularIcon.click();
	}

	public void clickOnLock() throws InterruptedException {

		waitForElementVisibilty(unlock);

		this.unlock.click();
		Thread.sleep(6000);
	}

	public void clickOnForward() {

		waitForElementVisibilty(forwardButton);

		try {

			this.forwardButton.click();

		} catch (Exception e) {

		}
	}

	public void clickOnNewsAnaylsis() {

		waitForElementVisibilty(newsAnaylsis);

		this.newsAnaylsis.click();
	}

	public void enterSearchBar(String companyName) {

		waitForElementVisibilty(searchBar);

		this.searchBar.sendKeys(companyName);
	}

	public void clickOnFetchButton() {

		waitForElementVisibilty(fetchButton);

		this.fetchButton.click();
	}

	public void clickOnNonNegativeNews() {

		waitForElementVisibilty(nonNegativeNews);

		this.nonNegativeNews.click();
	}

	public void clickOnNegativeNews() {

		waitForElementVisibilty(negativeNews);

		this.negativeNews.click();
	}

	public void clickOnNewsArticle() throws InterruptedException {

		this.scrollDown(1000);

		waitForElementVisibilty(newsArticle);

		this.newsArticle.click();
		Thread.sleep(5000);
		
		this.scrollDown(-1000);
		
		Thread.sleep(3000);
	}

}
