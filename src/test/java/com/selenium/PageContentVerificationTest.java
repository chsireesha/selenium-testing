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

public class PageContentVerificationTest {

	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws MalformedURLException {
		driver=new FirefoxDriver();
		driver.get(new File("./html/pagetitle.html").toURI().toURL().toString());
	}
	@Test
	public void testVerifyPageTitle() {
		String title = driver.getTitle();
		assertEquals("Selenium Introduction", title);
	}

	@Test
	public void testVerifyHeaderContent() {
		WebElement headertitle = driver.findElement(By.tagName("h1"));
		assertEquals("Verify Page title", headertitle.getText());
	}

	@Test
	public void testVerifyParagraphText(){
		WebElement paratitle = driver.findElement(By.tagName("p"));
		assertEquals("This will verify the page title of current page.", paratitle.getText());
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}
}
