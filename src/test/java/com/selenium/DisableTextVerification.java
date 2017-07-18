package com.selenium;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DisableTextVerification {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/dis.html").toURI().toURL().toString());
	}

	@Test
	public void testDisableTextVerification() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//entering the value into the textbox which is disabled
		WebElement element = driver.findElement(By.id("fn"));
		js.executeScript("document.getElementById('fn').value='I love selenium'");
		String attribute = element.getAttribute("value");
		assertEquals("I love selenium", attribute);
		//removing the value from the textbox
		js.executeScript("document.getElementById('fn').value=''");
		String attribute1 = element.getAttribute("value");
		assertEquals("", attribute1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
