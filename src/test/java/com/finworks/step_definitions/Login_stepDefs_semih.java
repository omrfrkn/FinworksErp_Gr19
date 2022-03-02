package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_semih;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login_stepDefs_semih1 {
    @Given("the user is on the login page_sb")
    public void the_user_is_on_the_login_page_sb() {
        BrowserUtils.waitForPageToLoad(5);
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("The user enters {string} and {string}_sb")
    public void the_user_enters_and__sb(String email, String password) {
        BrowserUtils.waitForPageToLoad(5);
        LoginPage_semih loginPage = new LoginPage_semih();
        loginPage.login(email,password);
    }

    @Then("the user should be able to login_sb")
    public void the_user_should_be_able_to_login_sb() {
        String expectedTitle= "#Inbox - Odoo";
        BrowserUtils.waitFor(3);
        String actualTitle= Driver.get().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Then("the user shouldn't be able to login_sb")
    public void the_user_shouldn_t_be_able_to_login_sb() {
        String expectedMessage= "Wrong login/password";
        BrowserUtils.waitFor(3);
        String actualMessage= new LoginPage_semih().errorMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
