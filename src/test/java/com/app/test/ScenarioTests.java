package com.app.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.scenarios.Scenario2;
import com.app.scenarios.Scenario4;

public class ScenarioTests {
	
	WebDriver driver;
	Scenario2 sc2;
	Scenario4 sc4;
	Properties prop;

	@BeforeMethod
	public void setup() throws FileNotFoundException, IOException {
		String rootFolder = System.getProperty("user.dir");
		prop = new Properties();
		prop.load(new FileInputStream(rootFolder + "//src//test//resources//data.properties"));
		driver = new ChromeDriver();
		sc2 = new Scenario2(driver, prop);
		sc4 = new Scenario4(driver);
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyScenario2() throws InterruptedException {
		driver.get(prop.getProperty("url1"));
		sc2.loginPage();
		sc2.verifyLogin();
	}
	
	@Test
	public void verifyScenario4() throws InterruptedException {
		driver.get(prop.getProperty("url2"));
		sc4.checkBag();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
