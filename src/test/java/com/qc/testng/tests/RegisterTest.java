package com.qc.testng.tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest extends BaseIntegration {

	@BeforeSuite
	public void setup() throws IOException {
		doSetup();
	}
	
	@BeforeTest
	public void redirectToRegisterPage() {
		if (driver.getTitle().equals(loginPageTitle)) {
			regPageLink = driver.findElement(By.linkText("Register a new membership"));
			regPageLink.click();
		}
	}

	@BeforeMethod
	public void locateElement() {
		rName = driver.findElement(By.id("name"));
		rName.clear();
		rMobile = driver.findElement(By.id("mobile"));
		rMobile.clear();
		rEmail = driver.findElement(By.id("email"));
		rEmail.clear();
		rPass = driver.findElement(By.id("password"));
		rPass.clear();
		rSubmit = driver.findElement(By.tagName("button"));
	}

	@Test(dataProvider = "registerData")
	public void doRegister(String testName, String uName, String uMobile, String uEmail, String uPass) {
		tName = testName;
		rName.sendKeys(uName);
		rMobile.sendKeys(uMobile);
		rEmail.sendKeys(uEmail);
		rPass.sendKeys(uPass);
		rSubmit.click();
	}

	@AfterMethod
	public void doAssert() throws InterruptedException {
		if (tName.equals("All are valid")) {
			actResult = cf.handleAlert(driver);
			expResult = "User registered successfully.";
		} else {
			actResult = driver.getTitle();
			expResult = "Queue Codes | Registration Page";
		}
		Assert.assertEquals(actResult, expResult);
		Thread.sleep(2000);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
