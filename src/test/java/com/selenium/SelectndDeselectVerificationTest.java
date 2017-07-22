package com.selenium;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectndDeselectVerificationTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/selanddes.html").toURI().toURL().toString());

	}

	@Test
	public void testSelectndDeselectVerification() {
		List<String> items = new ArrayList<String>(5);
		items.add("idly");
		items.add("dosa");
		items.add("vada");
		items.add("poori");
		items.add("chapati");
		WebElement listbox = driver.findElement(By.id("items"));
		Select select=new Select(listbox);
		List<WebElement> options = select.getOptions();
		int count = options.size();
		System.out.println(count);
		for(int i=0;i<items.size();i++)
		{
			select.selectByIndex(i);
			String text = options.get(i).getText();
			assertTrue(items.contains(text));
			select.deselectByIndex(i);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
