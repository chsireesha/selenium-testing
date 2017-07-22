package com.selenium;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinkVerification {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/brokenlinks.html").toURI().toURL().toString());

	}

	@Test
	public void testBrokenLinkVerification() throws InterruptedException {
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		int count = alllinks.size();
		System.out.println(count);
		boolean foundBrokenLink = false;
		for(int i=0;i<count;i++)
		{
			WebElement element = alllinks.get(i);
			element.click();
			Thread.sleep(3000);
			String title = driver.getTitle();
			if(title.contains("Problem loading page")) {
				foundBrokenLink = true;
			}
			driver.navigate().back();
			 alllinks = driver.findElements(By.xpath("//a"));
		}
		assertTrue(foundBrokenLink);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
