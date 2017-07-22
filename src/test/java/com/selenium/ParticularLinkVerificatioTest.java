package com.selenium;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParticularLinkVerificatioTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get("https://www.google.co.in/search?q=google+news&oq=google+news&gs_l=psy-ab.3..0i131k1l3j0.10074.15768.0.16918.11.11.0.0.0.0.302.2171.0j2j7j1.10.0....0...1.1.64.psy-ab..1.10.2167...0i67k1.xS8777B53Jg");
	}

	@Test
	public void testParticularLink() {
		WebElement element = driver.findElement(By.xpath("//a[.='Google News India: Latest News & Breaking Headlines - The Hindu']"));
		int y = element.getLocation().getY();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,"+y+")");
		element.click();
		String title = driver.getTitle();
		assertTrue(title.contains("news"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
