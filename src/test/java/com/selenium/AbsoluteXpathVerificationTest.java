package com.selenium;
import static org.junit.Assert.*;
import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbsoluteXpathVerificationTest {
	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
		driver.get(new File("./html/abs.html").toURI().toURL().toString());
	}
	@Test
	public void testAbsoluteXpathVerification() {
		String text = driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td[2]")).getText();
		assertTrue(text.contains("sunday"));
		String actual = driver.findElement(By.xpath("html/body/table/tbody/tr[5]/td[1]")).getText();
		assertEquals("4", actual);
		String text2 = driver.findElement(By.xpath("html/body/table/tbody/tr[7]|td[2]/tr[7]|td[1]")).getText();
		assertEquals("6 friday", text2);
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
}
