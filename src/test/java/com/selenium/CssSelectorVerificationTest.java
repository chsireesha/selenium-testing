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

public class CssSelectorVerificationTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/cssselector.html").toURI().toURL().toString());
	}

	@Test
	public void testCssSelectorVerification() {
		WebElement element = driver.findElement(By.cssSelector("input[name='fname']"));
		element.sendKeys("selenium");
		WebElement element1 = driver.findElement(By.cssSelector("input[name='lname']"));
		element1.sendKeys("testing");
		driver.findElement(By.cssSelector("button[value='Submit']")).click();
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.contains("login.html"));
		driver.navigate().back();
	    driver.findElement(By.cssSelector("button[value='Reset']")).click();
	    element = driver.findElement(By.cssSelector("input[name='fname']"));
	    String attribute = element.getAttribute("value");
	    assertTrue(attribute.isEmpty());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
