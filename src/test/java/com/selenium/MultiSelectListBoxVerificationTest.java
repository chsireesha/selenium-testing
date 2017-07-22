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

public class MultiSelectListBoxVerificationTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/mslb.html").toURI().toURL().toString());

	}

	@Test
	public void testMultiSelectListBoxVerification() {
		WebElement element = driver.findElement(By.xpath("//option[text()='vada']/following-sibling::*[1]"));
		String actual = element.getText();
		assertEquals("poori", actual);
		WebElement element1 = driver.findElement(By.xpath("//option[text()='vada']/following-sibling::*[last()]"));
		String actual1 = element1.getText();
		assertEquals("chapati", actual1);
		WebElement element2 = driver.findElement(By.xpath("//option[text()='vada']/preceding-sibling::*[1]"));
		String actual2 = element2.getText();
		assertEquals("dosa", actual2);
		WebElement element3 = driver.findElement(By.xpath("//option[text()='vada']/preceding-sibling::*[last()]"));
		String actual3 = element3.getText();
		assertEquals("idly", actual3);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
