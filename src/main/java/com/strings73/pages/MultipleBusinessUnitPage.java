package com.strings73.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleBusinessUnitPage extends BaseStrings73AutomationPage {

	@FindBy(xpath = "//input[@type=\"number\"]")
	private WebElement noOfUnits;

	@FindBy(xpath = "(//i[@class=\"far fa-edit primary-color-medium action-icon ng-star-inserted\"])[1]")
	private WebElement editUnit;

	@FindBy(xpath = "//*[contains(text(),'Ok')]")
	private WebElement okButton;

	@FindBy(xpath = "(//i[@class=\"far fa-edit primary-color-medium action-icon ng-star-inserted\"])[2]")
	private WebElement editUnit1;

	@FindBy(xpath = "(//i[@class=\"far fa-edit primary-color-medium action-icon ng-star-inserted\"])[3]")
	private WebElement editUnit2;

	public MultipleBusinessUnitPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void Enterunits(String units) {
		
		waitForElementVisibilty(noOfUnits);
		this.noOfUnits.clear();
		this.noOfUnits.sendKeys(units);
	}

	public void clickOnEditButton() {
		
		waitForElementVisibilty(editUnit);
		
		this.editUnit.click();
	}

	public void clickOnOkButton() {
		
		waitForElementVisibilty(okButton);
		
		this.okButton.click();
	}

	public void clickOnEditButton1() {
		
		waitForElementVisibilty(editUnit1);
		
		this.editUnit1.click();
	}

	public void clickOnEditButton2() {
		
		waitForElementVisibilty(editUnit2);
		
		this.editUnit2.click();
	}
}
