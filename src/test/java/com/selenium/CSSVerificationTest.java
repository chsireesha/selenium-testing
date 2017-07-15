package com.selenium;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSSVerificationTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/css.html").toURI().toURL().toString());

	}
	@Test
	public void test() {
		driver.findElement(By.tagName("input")).sendKeys("abcd");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("1234");
		String title = driver.getTitle();
		assertEquals("css verification", title);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}

