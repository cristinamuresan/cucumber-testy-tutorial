package org.fasttrackit.login;

import com.sdl.selenium.web.utils.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Cristina on 7/7/2015.
 */

public class YahooLoginSteps extends TestBase{
    
    @Given("^I acces \"([^\"]*)\"$")
    public void I_acces(String arg1 ) {
        driver.get("https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=https%3a//mail.yahoo.com");
    }

    @And("^I insert correct credentials$")
    public void I_insert_correct_credentials() throws Throwable {
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("bcristinabianca");
        Utils.sleep(2000);

        WebElement password = driver.findElement(By.id("login-passwd"));
        password.sendKeys("A.12!ab");
        Utils.sleep(2000);
    }

    @When("^I click button$")
    public void I_click_button() throws Throwable {
        WebElement button = driver.findElement(By.id("login-signin"));
        button.click();
        Utils.sleep(5000);
    }

    @Then("^I check if home page appears$")
    public void I_check_if_home_page_appears() throws Throwable {
        WebElement home = driver.findElement(By.id("Compose"));
        Assert.assertNotNull(home);
    }

    @Given("^I access \"([^\"]*)\"$")
    public void I_access(String arg1)  {
        driver.get("https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=https%3a//mail.yahoo.com");
    }

    @When("^I enter \"([^\"]*)\" credentials$")
    public void I_enter_credentials(String arg1) {
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("bcristinabianca");
        Utils.sleep(2000);
    }

    @Then("^I expect \"([^\"]*)\" error message$")
    public void I_expect_error_message(String expectedMessage) throws Throwable {
        WebElement error = driver.findElement(By.id("mbr-login-error"));
        assertThat(error.getText(), is(expectedMessage));
    }

    @When("^I enter \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_enter_credentials(String arg1, String arg2) throws Throwable {
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys(arg1);
        //Utils.sleep(2000);

        WebElement password = driver.findElement(By.id("login-passwd"));
        password.sendKeys(arg2);
        //Utils.sleep(2000);
    }
}
