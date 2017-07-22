package com.selenium;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HeightWidthndFontsizeVerificationTest {
	
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/login.html").toURI().toURL().toString());
	}

	@Test
	public void testHeightWidthndFontSize() {
		WebElement un = driver.findElement(By.id("username"));
		//to know the height and width of text field
		Dimension size = un.getSize();
		System.out.println(size);
		//to know the font-size of text field
		String cssValue = un.getCssValue("font-size");
		System.out.println(cssValue);
		assertTrue(cssValue.contains("px"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
