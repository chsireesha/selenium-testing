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

public class XpathTraversingVerification {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/rel.html").toURI().toURL().toString());
	}

	@Test
	public void testXpathTraversing() {
		//forward-traversing
		WebElement element = driver.findElement(By.xpath("//tbody/tr[1]|td"));
		String text = element.getText();
		assertTrue(text.contains("300"));
		//backward-traversing using /..
		WebElement element1 = driver.findElement(By.xpath("//td[.='java']/../.."));
		String text2 = element1.getText();
		assertTrue(text2.contains("java"));
		//backward-traversing using parent
		WebElement element2 = driver.findElement(By.xpath("//td[.='400']/parent::*"));
		String text3 = element2.getText();
		assertEquals("java 400", text3);
		//backward-traversing using ancestor
		WebElement element3 = driver.findElement(By.xpath("//td[.='java']/ancestor::body"));
		String text4 = element3.getText();
		assertTrue(text4.contains("sql"));
}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	driver.close();
	}
}
