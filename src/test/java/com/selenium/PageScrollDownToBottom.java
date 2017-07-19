package com.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageScrollDownToBottom {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get("http://www.seleniumhq.org/");
	}

	@Test
	public void testPageScrollDownToBottom() throws Exception {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
