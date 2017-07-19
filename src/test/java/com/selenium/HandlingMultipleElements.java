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

public class HandlingMultipleElements {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/hme.html").toURI().toURL().toString());

	}

	@Test
	public void testHandlingMultipleElements() {
		List<WebElement> alllinks = driver.findElements(By.id("links"));
		int count = alllinks.size();
		for(int i=0;i<count;i++){
		String text = alllinks.get(i).getText();
		assertTrue(text.contains("Gmail"));
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
