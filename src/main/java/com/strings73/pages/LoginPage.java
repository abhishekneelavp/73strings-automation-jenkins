package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseStrings73AutomationPage{

	@FindBy(id = "mat-input-0")
	private WebElement email;

	@FindBy(id = "mat-input-1")
	private WebElement password;

	@FindBy(xpath = "//*[contains(text(),'Login')]")
	private WebElement login;

	@FindBy(xpath = "//p[contains(text(),'Jenkins')]")
	private WebElement jenkins;
	
	@FindBy(xpath = "//p[contains(text(),'Login failed. Please provide valid user name and p')]")
	private WebElement invalidEmailText;

	@FindBy(xpath = "//p[contains(text(),'Please provide valid user name and password. Login')]")
	private WebElement invalidPasswordText;
	
	@FindBy(xpath = "//span[contains(text(),'Ok')]")
	private WebElement ok;

	private static final Logger logger = Logger.getLogger(LoginPage.class.getName());

	public LoginPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void setUsername(String strUsername) {
		logger.info("Starting of setUsername method");
		
		waitForElementVisibilty(email);
		
		this.email.clear();

		this.email.sendKeys(strUsername);

		logger.info("Ending of setUsername method");
	}

	public void setPassword(String strPassword) {
		logger.info("Starting of setPassword method");
		
		waitForElementVisibilty(password);
		
		this.password.clear();

		this.password.sendKeys(strPassword);

		logger.info("Ending of setPassword method");
	}

	public void clickLogin() {
		logger.info("Starting of clickLogin method");
		
		waitForElementVisibilty(login);

		this.login.click();

		logger.info("Ending of clickLogin method");
	}

	public void loginToStrings(String strUserName, String strPassword) {
		logger.info("Starting of loginToStrings method");

		this.setUsername(strUserName);

		this.setPassword(strPassword);

		this.clickLogin();

		logger.info("Ending of loginToStrings method");
	}

	public String getWebsiteTitle(WebDriver driver) {
		logger.info("Starting of getWebsiteTitle method");
		logger.info("Ending of getWebsiteTitle method");

		return driver.getTitle();
	}

	public String getJenkinsText() {
		logger.info("Starting of getValPitchText method");
		logger.info("Ending of getValPitchText method");

		return jenkins.getText();
	}
	
	public void clickOnOk() {
		logger.info("Starting of clickOnOk method");
		
		waitForElementVisibilty(ok);
		
		this.ok.click();
		
		logger.info("Ending of clickOnOk method");
	}

	public String getLoginText() {
		logger.info("Starting of getLoginText method");
		logger.info("Ending of getLoginText method");

		return login.getText();
	}
	
	public String getInvalidEmailText() {
		logger.info("Starting of getInvalidEmailText method");
		logger.info("Ending of getInvalidEmailText method");
		
		return invalidEmailText.getText();
	}

	public String getInvalidPasswordText() {
		logger.info("Starting of getInvalidPasswordText method");
		logger.info("Ending of getInvalidPasswordText method");
		
		return invalidPasswordText.getText();
	}

}