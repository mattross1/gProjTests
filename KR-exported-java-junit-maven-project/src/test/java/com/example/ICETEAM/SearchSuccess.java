package com.example.ICETEAM;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class SearchSuccess {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\gd\\Downloads\\KR-exported-java-junit-maven-project\\lib\\chromedriver.exe");
	    ChromeOptions opts = new ChromeOptions();
	    LoggingPreferences logpref = new LoggingPreferences();
	    logpref.enable(LogType.BROWSER, Level.ALL);
	    opts.setCapability(CapabilityType.LOGGING_PREFS, logpref);
	    
	    driver = new ChromeDriver(opts);
	    
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testSearchSuccess() throws Exception {
    driver.get("http://iceteam.ddns.net/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Signup'])[1]/preceding::span[3]")).click();
    driver.findElement(By.id("mat-input-0")).click();
    driver.findElement(By.id("mat-input-0")).clear();
    driver.findElement(By.id("mat-input-0")).sendKeys("123");
    driver.findElement(By.id("mat-input-0")).sendKeys(Keys.ENTER);
    Thread.sleep(1000);
  }

  @After
  public void tearDown() throws Exception {
	  LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs = entry.getAll();
		int found = 0;
		for (LogEntry l : logs) {
			if (String.valueOf(l).indexOf("success.search") != -1) {
				found = 1;
			}
		}
	driver.quit();
	assertEquals(found, 1);
	if (found == 0)
	{
		fail("Expected Output Not Found!");
	}
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
