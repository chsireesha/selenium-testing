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

public class EnableDisableVerificationTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/disable.html").toURI().toURL().toString());
	}

	@Test
	public void testEnableVerification() {
		WebElement un = driver.findElement(By.id("un"));
		if(un.isEnabled()){
			un.clear();
			un.sendKeys("Testing");
		}
		else
		{
			String attribute = un.getAttribute("value");
			assertEquals("Selenium", attribute);
		}
		WebElement fn = driver.findElement(By.id("fn"));
		if(fn.isEnabled()){
			fn.clear();
			fn.sendKeys("Selenium");
		}
		else
		{
			String attribute = fn.getAttribute("value");
			assertEquals("Testing", attribute);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
