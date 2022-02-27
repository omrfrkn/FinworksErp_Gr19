package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_HD;
import com.finworks.pages.NotesPage_HD;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginDefs_HD {

    LoginPage_HD loginPageHd = new LoginPage_HD();

    @Given("the user is on the login page_HD")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters valid {string} and {string}_HD")
    public void the_user_enters_valid_and(String email, String password) {
        loginPageHd.login(email, password);
    }

    @Then("the user logins and the title is {string}_HD")
    public void the_user_logins_and_the_title_is(String expectedPageTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.titleIs(expectedPageTitle));
        String actualPageTitle = Driver.get().getTitle();
        Assert.assertEquals("Verify the titles are same", expectedPageTitle, actualPageTitle);
    }

    @Then("the username is {string}_HD")
    public void the_username_is(String expectedUserName) {
        NotesPage_HD notesPageHd = new NotesPage_HD();
        String actualUserName = notesPageHd.userName.getText();
        Assert.assertEquals("Verify the titles are same", expectedUserName, actualUserName);
    }

    @When("the user enters {string} in Email box_HD")
    public void the_user_enters_in_Email_box(String email) {
        loginPageHd.emailInput.sendKeys(email);
    }

    @When("the user enters {string} in Password box_HD")
    public void the_user_enters_in_Password_box(String validPassword) {
        loginPageHd.passwordInput.sendKeys(validPassword);
    }

    @When("the user clicks on Log in button_HD")
    public void the_user_clicks_on_Log_in_button() {
        loginPageHd.loginButton.click();
    }

    @Then("the user should not be able to login_HD")
    public void the_user_should_not_be_able_to_login() {
        String loginPageTitle = "Login | Best solution for startups";
        String actualPageTitle = Driver.get().getTitle();
        Assert.assertEquals("Page titles should match", loginPageTitle,actualPageTitle);
    }

    @Then("{string} warning should appear below the Password box_HD")
    public void warning_should_appear_below_the_Password_box(String expectedWarning) {
        String actualWarning = loginPageHd.wrongLoginPasswordMessage.getText();
        Assert.assertEquals("Warnings should match", expectedWarning, actualWarning);
    }

    @When("the user leaves Password box empty_HD")
    public void the_user_leaves_Password_box_empty() {
        loginPageHd.passwordInput.sendKeys("");
    }

    @Then("{string} message should appear below the Password box_HD")
    public void message_should_appear_below_the_Password_box(String expectedMessage) {
        String actualMessage = loginPageHd.passwordInput.getAttribute("validationMessage");
        Assert.assertEquals("Messages should match", expectedMessage,actualMessage);
    }

    @When("the user leaves Email box empty_HD")
    public void the_user_leaves_Email_box_empty() {
        loginPageHd.emailInput.sendKeys("");
    }

    @Then("{string} message should appear below the Email box_HD")
    public void message_should_appear_below_the_Email_box(String expectedMessage) {
        String actualMessage = loginPageHd.emailInput.getAttribute("validationMessage");
        Assert.assertEquals("Messages should match", expectedMessage,actualMessage);
    }
}