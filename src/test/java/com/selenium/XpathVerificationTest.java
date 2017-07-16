package com.selenium;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XpathVerificationTest {
	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/xpath.html").toURI().toURL().toString());
	}
	@Test
	public void testXpathVerification() {
		driver.findElement(By.xpath("html/body/input[1]")).sendKeys("abcd");
		driver.findElement(By.xpath("html/body/input[2]")).sendKeys("1234");
		String pageSource = driver.getPageSource();
		assertTrue(pageSource.contains("text"));
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
