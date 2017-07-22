package com.selenium;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IndependentDependentXpathTest{
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get("http://www.seleniumhq.org/download/");
	}

	@Test
	public void testIndependentDependentXpath() {
		//to find the independent dependent xpath in selenium download page
		WebElement element = driver.findElement(By.xpath("//td[.='Python']/../td[4]"));
		String text = element.getText();
		assertEquals("Download", text);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
