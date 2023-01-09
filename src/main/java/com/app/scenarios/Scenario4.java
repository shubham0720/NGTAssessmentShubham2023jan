package com.app.scenarios;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Scenario4 {

	WebDriver driver;

	public Scenario4(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkBag() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")).click();
		Thread.sleep(3000);
		String emptyBagText = driver.findElement(By.xpath("//div[@class='emptyCart-base-emptyText']")).getText();
		String expectedEmptyBagText = "Hey, it feels so light!";
		if(emptyBagText.equals(expectedEmptyBagText)) {
			driver.navigate().back();
			driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("wallet");
			driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();
			Thread.sleep(7000);
			driver.findElement(By.xpath("//div[@class='product-productMetaInfo']")).click();
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[normalize-space()='ADD TO BAG']")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("GO TO BAG")).click();
			Thread.sleep(5000);
		}
		else {
			System.out.println("Not empty");
		}
	}

}
