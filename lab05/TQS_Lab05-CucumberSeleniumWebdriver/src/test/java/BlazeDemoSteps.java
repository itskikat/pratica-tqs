import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BlazeDemoSteps {

    private WebDriver webDriver;

    @When("I navigate to {string}")
    public void iNavigateTo(String url){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get(url);
    }

    @And("I select {string} as my departure city")
    public void iSelectDeparture(String departure_city){
        webDriver.manage().window().setSize(new Dimension(2560, 1004));
        webDriver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = webDriver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = '" + departure_city + "']")).click();
        }
        {
            WebElement element = webDriver.findElement(By.name("fromPort"));
            String value = element.getAttribute("value");
            String locator = String.format("option[@value='%s']", value);
            String selectedText = element.findElement(By.xpath(locator)).getText();
            assertThat(selectedText, is(departure_city));
        }
    }

    @And("I select {string} as my destination city")
    public void iSelectDestination(String destination_city){
        webDriver.manage().window().setSize(new Dimension(2560, 1004));
        webDriver.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = webDriver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = '" + destination_city + "']")).click();
        }
        {
            WebElement element = webDriver.findElement(By.name("toPort"));
            String value = element.getAttribute("value");
            String locator = String.format("option[@value='%s']", value);
            String selectedText = element.findElement(By.xpath(locator)).getText();
            assertThat(selectedText, is(destination_city));
        }
    }

    @And("I click {string}")
    public void iClickButton(String btn_name){
        webDriver.manage().window().setSize(new Dimension(2560, 1004));
        String btnname = webDriver.findElement(By.cssSelector(".btn-primary")).getAttribute("value");
        assertThat(btnname, is(btn_name));
        webDriver.findElement(By.cssSelector(".btn-primary")).click();

    }

    @Then("I should be presented with results including {string}")
    public void iShouldBePresentedResultsIncluding(String result){
        assertThat(webDriver.findElement(By.cssSelector("h3")).getText(), is(result));
    }

    // SCENARIO 2 (EXTRA STEPS)
    @And("I want to fly from {string} to {string}")
    public void iWantToFlyFromTo(String from, String to){
        webDriver.manage().window().setSize(new Dimension(2560, 1004));
        webDriver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = webDriver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = '" + from + "']")).click();
        }
        webDriver.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = webDriver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = '" + to + "']")).click();
        }
    }

    @And("I enter my personal information")
    public void iEnterMyPersonalInformation(){
        webDriver.findElement(By.cssSelector(".btn-primary")).click();
        webDriver.findElement(By.cssSelector("tr:nth-child(2) .btn")).click();
        webDriver.findElement(By.cssSelector(".control-group:nth-child(2)")).click();
        webDriver.findElement(By.id("inputName")).click();
        webDriver.findElement(By.id("inputName")).sendKeys("Francisca");
        webDriver.findElement(By.id("address")).sendKeys("123 Street");
        webDriver.findElement(By.id("city")).sendKeys("Anytown");
        webDriver.findElement(By.id("state")).sendKeys("Stateless");
        webDriver.findElement(By.id("zipCode")).sendKeys("12345");
        webDriver.findElement(By.id("cardType")).click();
        {
            WebElement dropdown = webDriver.findElement(By.id("cardType"));
            dropdown.findElement(By.xpath("//option[. = 'American Express']")).click();
        }
        webDriver.findElement(By.id("creditCardNumber")).click();
        webDriver.findElement(By.id("creditCardNumber")).sendKeys("999999999");
        webDriver.findElement(By.id("creditCardYear")).click();
        webDriver.findElement(By.id("creditCardYear")).sendKeys("2019");
        webDriver.findElement(By.id("nameOnCard")).click();
        webDriver.findElement(By.id("nameOnCard")).sendKeys("Francisca Barros");
        webDriver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("I should be presented with results, including the amount {string}")
    public void iShouldBePresentedResultsAmount(String amount){
        webDriver.findElement(By.cssSelector("body")).click();
        String web_amount = webDriver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText();
        assertThat(web_amount, is(amount));
        webDriver.quit();
    }
}
