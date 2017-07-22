package com.selenium;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnableTextTransferTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/enable.html").toURI().toURL().toString());
	}

	@Test
	public void testEnableTextTransfer() {
		String un = driver.findElement(By.id("un")).getAttribute("value");
		WebElement fn = driver.findElement(By.id("fn"));
		fn.sendKeys(un);
		String attribute = fn.getAttribute("value");
		assertEquals("I Love Selenium", attribute);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
