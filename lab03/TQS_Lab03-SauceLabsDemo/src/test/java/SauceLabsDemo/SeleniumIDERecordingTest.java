package SauceLabsDemo;

// Generated by Selenium IDE
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class SeleniumIDERecordingTest {

  WebDriver browser;

  @BeforeEach
  void setUp() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    browser = new ChromeDriver();
  }

  @AfterEach
  void tearDown() {
    browser.close();
  }


  @Test
  public void seleniumIDERecording() {
    browser.get("https://blazedemo.com/");
    browser.manage().window().setSize(new Dimension(2560, 1004));
    browser.findElement(By.name("fromPort")).click();
    {
      WebElement dropdown = browser.findElement(By.name("fromPort"));
      dropdown.findElement(By.xpath("//option[. = 'Boston']")).click();
    }
    {
      WebElement element = browser.findElement(By.name("fromPort"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("Boston"));
    }
    browser.findElement(By.name("toPort")).click();
    {
      WebElement dropdown = browser.findElement(By.name("toPort"));
      dropdown.findElement(By.xpath("//option[. = 'Berlin']")).click();
    }
    {
      WebElement element = browser.findElement(By.name("toPort"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("Berlin"));
    }
    browser.findElement(By.cssSelector(".btn-primary")).click();
    assertThat(browser.findElement(By.cssSelector("h3")).getText(), is("Flights from Boston to Berlin:"));
    browser.findElement(By.cssSelector("tr:nth-child(2) .btn")).click();
    browser.findElement(By.cssSelector(".control-group:nth-child(2)")).click();
    assertThat(browser.findElement(By.cssSelector("h2")).getText(), is("Your flight from TLV to SFO has been reserved."));
    browser.findElement(By.id("inputName")).click();
    browser.findElement(By.id("inputName")).sendKeys("Francisca");
    browser.findElement(By.id("address")).sendKeys("123 Street");
    browser.findElement(By.id("city")).sendKeys("Anytown");
    browser.findElement(By.id("state")).sendKeys("Stateless");
    browser.findElement(By.id("zipCode")).sendKeys("12345");
    browser.findElement(By.id("cardType")).click();
    {
      WebElement dropdown = browser.findElement(By.id("cardType"));
      dropdown.findElement(By.xpath("//option[. = 'American Express']")).click();
    }
    {
      WebElement element = browser.findElement(By.id("cardType"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("American Express"));
    }
    browser.findElement(By.id("creditCardNumber")).click();
    browser.findElement(By.id("creditCardNumber")).sendKeys("999999999");
    browser.findElement(By.id("creditCardYear")).click();
    browser.findElement(By.id("creditCardYear")).sendKeys("2019");
    browser.findElement(By.id("nameOnCard")).click();
    browser.findElement(By.id("nameOnCard")).sendKeys("Francisca Barros");
    browser.findElement(By.cssSelector(".btn-primary")).click();
    browser.findElement(By.cssSelector("body")).click();
    assertThat(browser.getTitle(), is("BlazeDemo Confirmation"));
    assertThat(browser.findElement(By.cssSelector("h1")).getText(), is("Thank you for your purchase today!"));
  }
}
