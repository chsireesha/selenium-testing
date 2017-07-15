package com.selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AllbrowsersNavigationTest {

	@Test
	public void testFirefoxsNavigationTest() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		navigate(driver);
	}

	@Test
	public void testChromeNavigation() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		navigate(driver);
	}

	@Test
	public void testIENavigation() throws InterruptedException{
		WebDriver driver=new InternetExplorerDriver();
		navigate(driver);
	}
	
	private void navigate(WebDriver driver) throws InterruptedException {
		driver.get("https://www.google.com");
		driver.navigate().to("https://www.facebook.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.close();
	}
}
