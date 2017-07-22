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

public class NonbreakableSpaceVerificationTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/nbsp.html").toURI().toURL().toString());
	}

	@Test
	public void testNonbreakableSpaceVerification() {
		WebElement element = driver.findElement(By.xpath("//div[.=' Java ']"));
		String actual = element.getText();
		assertEquals("Java", actual);
		WebElement element1 = driver.findElement(By.xpath("//div[contains(.,'Selenium')]"));
		String actual1 = element1.getText();
		assertEquals(" Selenium ", actual1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
