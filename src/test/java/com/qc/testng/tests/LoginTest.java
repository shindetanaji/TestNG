package com.qc.testng.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest extends BaseIntegration{
	
	@BeforeSuite
	public void setup() throws IOException {
		doSetup();
	}
	
	@BeforeMethod
	public void locateElement() {
		email = driver.findElement(By.id("email"));
		pass = driver.findElement(By.id("password"));
		signin = driver.findElement(By.id("submit"));
	}
	
	@Test(dataProvider = "loginData")
	public void doLogin(String testName, String uName, String uPass) {
		tName = testName;
		cf.enterValueIntoTextBox(email, uName);
		cf.enterValueIntoTextBox(pass, uPass);
		cf.clickOnButton(signin);
	}
	
	@AfterMethod
	public void doAssert() throws InterruptedException {
		String actResult = driver.getTitle();
		if(tName.equals("Both are valid")) {
			expResult = "Queue Codes | Dashboard";
			doLogout();
		}else {
			expResult = loginPageTitle;
		}
		cf.doAssert(actResult, actResult);
		Thread.sleep(2000);
	}
	
	public void doLogout() {
		logout = driver.findElement(By.id("hlogout"));
		cf.clickOnButton(logout);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
