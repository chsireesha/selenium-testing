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

public class CheckboxAndRadiobuttonVerification {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/checkbox.html").toURI().toURL().toString());
	}

	@Test
	public void testCheckboxAndRadiobutton() {
		//to check whether the checkbox is selected or not
		WebElement element = driver.findElement(By.name("vehicle"));
		element.click();
		assertTrue(element.isSelected());
		//to check whether the radio button is selected or not
		WebElement element1 = driver.findElement(By.name("gender"));
		element1.click();
		assertTrue(element1.isSelected());
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
