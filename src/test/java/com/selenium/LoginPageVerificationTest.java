package com.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPageVerificationTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/link.html").toURI().toURL().toString());
	}

	@Test
	public void testLoginPageVerification() throws Exception {
		checkLogin("abcd");
		driver.get(new File("./html/link.html").toURI().toURL().toString());
		checkLogin("dfsdf");
	}

	private void checkLogin(String userName) {
		driver.findElement(By.linkText("Login")).click();
		String title = driver.getTitle();
		assertEquals("Login",title);
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("passwd")).sendKeys("1234");
		driver.findElement(By.id("button")).click();
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.contains("login_successful.html"));
		String text = driver.findElement(By.id("username")).getText();
		assertEquals(userName, text);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
