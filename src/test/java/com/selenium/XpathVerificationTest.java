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

public class XpathVerificationTest {
	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/xpath.html").toURI().toURL().toString());
	}
	@Test
	public void testXpathVerification() {
		WebElement un = driver.findElement(By.xpath("html/body/input[1]"));
		un.sendKeys("abcde");
		String attribute = un.getAttribute("value");
		assertEquals("abcde", attribute);
		WebElement pwd = driver.findElement(By.xpath("html/body/input[2]"));
		pwd.sendKeys("12345");
		String attribute1 = pwd.getAttribute("value");
		assertEquals("12345", attribute1);
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
	
}
