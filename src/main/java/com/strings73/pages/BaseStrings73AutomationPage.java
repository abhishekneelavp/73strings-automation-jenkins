package com.strings73.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseStrings73AutomationPage {

	protected WebDriver driver = null;

	private static final Logger logger = Logger.getLogger(BaseStrings73AutomationPage.class.getName());

	public static String TEST_FILE_PATH = null;

	public BaseStrings73AutomationPage(WebDriver driver) {

		this.driver = driver;

		if (TEST_FILE_PATH == null) {

			TEST_FILE_PATH = getTestFilePath();

			logger.debug("In Constructor " + TEST_FILE_PATH);

		}

		PageFactory.initElements(driver, this);

	}

	public String getTestFilePath() {

		String path = "src/test/resources";

		File file = new File(path);

		return file.getAbsolutePath();

	}

	protected void selectDropdown(String id, String value) {
		logger.info("Starting of selectDropdown method");

		Select conditions = new Select(driver.findElement(By.id(id)));

		conditions.selectByValue(value);

		logger.info("Ending of selectDropdown method");

	}

	/*
	 * public void clickOnWebElement(WebElement webelement) {
	 * logger.info("Starting of clickOnWebElement method");
	 * 
	 * JavascriptExecutor jsExec = (JavascriptExecutor) driver;
	 * 
	 * jsExec.executeScript("arguments[0].click();", webelement);
	 * 
	 * logger.info("Ending of clickOnWebElement method");
	 * 
	 * }
	 */

	public void scrollDown(int scroll) {
		logger.info("Starting of scrollDown method");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, " + scroll + ")");

		logger.info("Ending of scrollDown method");

	}

	public void refresh() {
		logger.info("Starting of refresh method");

		driver.navigate().refresh();

		logger.info("Ending of refresh method");

	}

	public void selectDateByJS(WebElement element, String dateVal) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('value', '" + dateVal + "');", element);

	}

	public void navigateBack() {
		logger.info("Starting of navigateBack method");

		driver.navigate().back();

		logger.info("Ending of navigateBack method");

	}

	public void impicitWait() {

		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

	}
	
	public void clickOnElement(WebElement webelement) {
		
		try {
			
			webelement.click();
			
		} catch (Exception e) {
			
			JavascriptExecutor jsExec = (JavascriptExecutor) driver;

			jsExec.executeScript("arguments[0].click();", webelement);
			
		}
		
	}
	
	public void mouseHover(WebElement element) {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
	}
	
	public void sleep(int sec) {
		
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			
		}
		
	}
	public void switchToNewWindow() {
		logger.info("Starting of switchToNewWindow method");

		// To Open new window and check Assertions
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));

		logger.info("Ending of switchToNewWindow method");
	}

	public void closeWindow() {
		logger.info("Starting of closeWindow method");

		// Recent window will be closed and returns back
		driver.close();
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));

		logger.info("Ending of closeWindow method");
	}
	
	public void waitForElementVisibilty(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(this.driver, 300);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

	
	
	
}
