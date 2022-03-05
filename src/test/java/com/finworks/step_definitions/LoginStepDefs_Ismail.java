package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_Ismail;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs_Ismail {


    LoginPage_Ismail loginPage = new LoginPage_Ismail();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("User enters valid {string} and {string}")
    public void user_enters_valid_and(String string, String string2) {

        loginPage.login(string,string2);
    }

    @Then("User should see page title as {string}")
    public void user_should_see_page_title_as(String expectedTitle) {
        BrowserUtils.waitFor(4);
        Assert.assertEquals(expectedTitle,Driver.get().getTitle());
    }

    @When("The user enters the invalid {string} or {string}")
    public void the_user_enters_the_invalid_or(String userName, String passWord) {
        new LoginPage_Ismail().login(userName,passWord);
    }

    @Then("The user should get error message {string}")
    public void the_user_should_get_error_message(String expectedMessage) {
        String actualMessage =  loginPage.error_message.getText();
        Assert.assertEquals("verify warning message", expectedMessage, actualMessage);
    }

}
