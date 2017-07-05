package com.selenium;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class ColorAndFontVerificationTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws MalformedURLException {
		driver = new FirefoxDriver();
		driver.get(new File("./html/colors.html").toURI().toURL().toString());
	}

	@Test
	public void testVerifyBackgroundColor() {
		WebElement e = driver.findElement(By.tagName("body"));
		String actual = e.getCssValue("background-color");
		String expected = Color.fromString("pink").asRgba();
		assertEquals(expected, actual);
	}

	@Test
	public void testFirstHeaderAttributes(){
		checkHeaderAttributes("h1","black","red","32px");
	}

	@Test
	public void testSecondHeaderAttributes() {
		checkHeaderAttributes("h2", "black", "blue", "24px");
	}

	@Test
	public void testThirdtHeaderAttributes() {
		checkHeaderAttributes("h3", "black", "orange", "18.7167px");
	}

	@Test
	public void testFourthtHeaderAttributes() { 
		checkHeaderAttributes("h4", "black", "green", "16px");
	}

	@Test
	public void testFifthtHeaderAttributes() {
		checkHeaderAttributes("h5", "black", "yellow", "13.2833px");
	}

	private void checkHeaderAttributes(String header, String textColor, String backgroundColor, String font) {
		WebElement e1 = driver.findElement(By.tagName(header));
		String actual = e1.getCssValue("font-size");
		assertEquals(font, actual);
		actual = e1.getCssValue("color");
		String expected = Color.fromString(textColor).asRgba();
		assertEquals(expected, actual);
		actual = e1.getCssValue("background-color");
		expected = Color.fromString(backgroundColor).asRgba();
		assertEquals(expected, actual);
	}

	@AfterClass
	public static void tearDownAfterClass(){
		driver.close();
	}
}
