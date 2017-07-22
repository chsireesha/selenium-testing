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
import org.openqa.selenium.support.ui.Select;

public class HandlingListboxVerificationTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/hndlnglb.html").toURI().toURL().toString());

	}

	@Test
	public void testHandlingListbox() {
		WebElement element = driver.findElement(By.id("types"));
		Select select=new Select(element);
		select.selectByIndex(2);
		select.selectByValue("d");
		select.selectByVisibleText("Kit Kat");
		assertTrue(select.isMultiple());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
