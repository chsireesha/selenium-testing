package com.selenium;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Text;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class HandlingMultipleElementsVerification {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get("https://www.google.com");
	}

	@Test
	public void testHandlingMultipleElementsVerification() throws InterruptedException {
		WebElement element = driver.findElement(By.id("lst-ib"));
		element.sendKeys("selenium");
		element.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		int count = alllinks.size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			String text = alllinks.get(i).getText();
			if(text.length()>0){
				System.out.println(text);
			}
		}
		assertTrue("Use precise location", true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
