package com.finworks.step_definitions;


import com.finworks.pages.LoginPage_Umut;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs_Umut {

    @Given("the user is on the login page_US")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

        String expectedPageTitle = "Login | Best solution for startups";
        String actualPageTitle = Driver.get().getTitle();

        Assert.assertEquals("verify login page title", expectedPageTitle, actualPageTitle);
    }

    @When("the user logged in_US")
    public void the_user_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage_Umut().login();
    }

    @When("the user enters valid email {string}_US")
    public void the_user_enters_valid_email(String validEmail) {
        new LoginPage_Umut().emailInputBox.sendKeys(validEmail);
    }

    @When("the user enters valid password {string}_US")
    public void the_user_enters_valid_password(String validPassword) {
        new LoginPage_Umut().passwordInputBox.sendKeys(validPassword);
    }

    @When("the user click login button_US")
    public void the_user_click_login_button() {
        new LoginPage_Umut().loginBtn.click();
        BrowserUtils.waitFor(5);
    }

    @Then("the user should see page title as {string}_US")
    public void the_user_should_be_on_the_page(String expectedPageTitle) {
        String actualPageTitle = Driver.get().getTitle();
        Assert.assertEquals("verify page title", expectedPageTitle, actualPageTitle);
    }

    @Then("the user should see own username as {string}_US")
    public void the_user_should_see_own_username_as(String expectedUserName) {
        String actualUserName = new LoginPage_Umut().getUserName();
        Assert.assertEquals("verify username", expectedUserName, actualUserName);
    }

    @When("the user logins with {string} and {string}_US")
    public void the_user_logins_with_and(String email, String password) {
        new LoginPage_Umut().login(email, password);
    }

    @Then("system should shows {string} error message_US")
    public void system_should_shows_error_message(String expectedMessage) {
        String actualMessage = new LoginPage_Umut().getErrorMessage();
        Assert.assertEquals("verify error message for invalid credentials", expectedMessage, actualMessage);
    }

    @Then("system should shows {string} validation message_US")
    public void system_should_shows_required_attribute_error_message(String expectedMessage) {

        new LoginPage_Umut().verifyValidationMessage(expectedMessage);

    }

}
