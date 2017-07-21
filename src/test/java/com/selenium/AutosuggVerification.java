package com.selenium;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutosuggVerification {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get("https://www.google.com");
	}

	@Test
	public void testAutosuggVerification() throws InterruptedException {
		WebElement element = driver.findElement(By.id("lst-ib"));
		element.sendKeys("selenium");
		Thread.sleep(5000);
		List<WebElement> autosugg = driver.findElements(By.xpath("//div[contains(.,'selenium')]"));
		int count = autosugg.size();
		System.out.println(count);
		for(WebElement element1:autosugg)
		{
			assertTrue(element1.getText().toLowerCase().contains("selenium"));
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
