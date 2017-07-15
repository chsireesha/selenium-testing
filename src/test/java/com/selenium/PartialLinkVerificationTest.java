package com.selenium;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PartialLinkVerificationTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/partiallink.html").toURI().toURL().toString());

	}

	@Test
	public void testLinkVerification() throws InterruptedException, MalformedURLException {
		driver.findElement(By.partialLinkText("Log")).click();
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.contains("login.html"));
		String title = driver.getTitle();
		assertEquals("Login", title);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
