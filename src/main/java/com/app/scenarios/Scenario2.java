package com.app.scenarios;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Scenario2 {
	
	WebDriver driver;
	Properties prop;

	public Scenario2(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}
	
	public void loginPage() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='mobileNumberPass']")).sendKeys(prop.getProperty("email"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='form-control has-feedback']")).sendKeys(prop.getProperty("password"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn primary  lg block submitButton']")).click();
		Thread.sleep(34000);
		driver.findElement(By.xpath("//button[@class='btn primary  lg block submitButton']")).click();
		Thread.sleep(3000);
	}
	
	public void verifyLogin() {
		String pageTitle = driver.getTitle();
		String expectedTitle = "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
		Assert.assertEquals(pageTitle, expectedTitle, "User not yet logged in");
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='desktop-userTitle']")).isDisplayed());
	}

}
