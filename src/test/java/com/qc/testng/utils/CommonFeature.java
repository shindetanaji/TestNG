package com.qc.testng.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonFeature {

	public void clickOnButton(WebElement ele) {
		ele.click();
	}
	
	public void enterValueIntoTextBox(WebElement ele, String value) {
		ele.clear();
		ele.sendKeys(value);
	}
	
	public void doAssert(String actResult, String expResult) {
		Assert.assertEquals(actResult, expResult);
	}
	
	public void applyWaitToVisibleElement(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public String handleAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		String actResult = alt.getText();
		alt.accept();
		return actResult;
	}
}
