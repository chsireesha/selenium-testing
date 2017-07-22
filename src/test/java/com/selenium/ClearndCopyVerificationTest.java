package com.selenium;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClearndCopyVerificationTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/enb.html").toURI().toURL().toString());
	}

	@Test
	public void testClearndCopyVerification() {
		WebElement un = driver.findElement(By.id("un"));
		//by passing shortcut we can delete the data
		un.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
		un.sendKeys("Selenium");
		//by passing shortcut we can copy paste the value from one textbox to other
		un.sendKeys(Keys.CONTROL+"ac");
		WebElement fn = driver.findElement(By.id("fn"));
		fn.sendKeys(Keys.CONTROL+"v");
		String text = fn.getAttribute("value");
		assertTrue(text.contains("Selenium"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
