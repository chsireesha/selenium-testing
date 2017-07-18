package com.selenium;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupIndexVerificationTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/groupindex.html").toURI().toURL().toString());
	}

	@Test
	public void testGroupIndexVerification() {
		String text = driver.findElement(By.xpath("(//input[1])[1]")).getAttribute("value");
		assertEquals("A", text);
		String text1 = driver.findElement(By.xpath("(//input[1])[2]")).getAttribute("value");
		assertEquals("C", text1);
		String text2 = driver.findElement(By.xpath("(//input[2])[1]")).getAttribute("value");
		assertEquals("B", text2);
		String text3 = driver.findElement(By.xpath("(//input[2])[2]")).getAttribute("value");
		assertEquals("D", text3);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
