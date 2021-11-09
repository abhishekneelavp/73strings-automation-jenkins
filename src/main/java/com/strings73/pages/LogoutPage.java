package com.strings73.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BaseStrings73AutomationPage {

	@FindBy(xpath = "//*[@class=\"fa fa-power-off\"]")
	private WebElement logoutIcon;

	@FindBy(xpath = "//strong[contains(text(),'Login')]")
	private WebElement login;
	
	@FindBy(xpath = "//button[@id='dropdownBasic1']")
	private WebElement accountName;

	@FindBy(xpath = "//div[contains(text(),'Logout')]")
	private WebElement logoutButton;

	private static final Logger logger = Logger.getLogger(LogoutPage.class.getName());

	public LogoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnLogoutIcon() {
		logger.info("Starting of clickOnLogout method");
		
		waitForElementVisibilty(logoutIcon);

		clickOnElement(logoutIcon);

		logger.info("Ending of clickOnLogout method");
	}
	
	public void clickOnLogout() {
		logger.info("Starting of clickOnLogout method");
		
		waitForElementVisibilty(accountName);
		
		clickOnElement(accountName);
		
		waitForElementVisibilty(logoutButton);
		
		clickOnElement(logoutButton);
		
		logger.info("Ending of clickOnLogout method");
	
	}

	public String getLoginText() {
		logger.info("Starting of getLoginText method");
		logger.info("Ending of getLoginText method");

		return login.getText();
	}
}
