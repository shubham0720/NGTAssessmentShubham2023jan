package com.app.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.scenarios.LoginPage;
import com.app.scenarios.Cart;

public class ScenarioTests {
	
	WebDriver driver;
	LoginPage sc2;
	Cart sc4;
	Properties prop;

	@BeforeMethod
	public void setup() throws FileNotFoundException, IOException {
		String rootFolder = System.getProperty("user.dir");
		prop = new Properties();
		prop.load(new FileInputStream(rootFolder + "//src//test//resources//data.properties"));
		driver = new ChromeDriver();
		sc2 = new LoginPage(driver, prop);
		sc4 = new Cart(driver);
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyScenario2() throws InterruptedException {
		driver.get(prop.getProperty("url1"));
		sc2.loginPage();
		String pageTitle = driver.getTitle();
		String expectedTitle = "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
		Assert.assertEquals(pageTitle, expectedTitle, "User not yet logged in");
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='desktop-userTitle']")).isDisplayed());
	}
	
	@Test
	public void verifyScenario4() throws InterruptedException {
		driver.get(prop.getProperty("url2"));
		sc4.checkBag();
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='step step3']")).isDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
