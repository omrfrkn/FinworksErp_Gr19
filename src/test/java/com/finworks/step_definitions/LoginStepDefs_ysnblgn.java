package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_ysnblgn;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


/**
 * @author ybilgin
 * @project FinworksErp
 */


public class LoginStepDefs_ysnblgn {
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {

        Driver.get().get(ConfigurationReader.get("url"));
    }
    
    @When("the user logged in")
    public void the_user_logged_in() {
        new LoginPage_ysnblgn().login();
    }

    @When("the user logged in with {string} and {string}")
    public void the_user_logged_in(String username, String password) {
        new LoginPage_ysnblgn().login(username,password);
    }

    @Then("the user should see the title {string}")
    public void the_user_should_see_the_title(String expectedTitle) {
        BrowserUtils.waitFor(5);
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());
    }

    @Then("the user should see own username as {string}")
    public void the_user_should_see_own_username_as(String expectedUserName) {
        Assert.assertEquals(expectedUserName,new LoginPage_ysnblgn().getUserName());

    }

    @Then("{string} error message should appear")
    public void error_message_should_appear(String expectedErrorMessage) {
        if(expectedErrorMessage.equals("Wrong login/password"))
            Assert.assertEquals(expectedErrorMessage,new LoginPage_ysnblgn().errorMessage.getText());
    }

    @Then("{string} warning message should appear")
    public void warningMessageShouldAppear(String expectedWarningMessage) {
        if(new LoginPage_ysnblgn().username.getAttribute("value").isEmpty()){
            Assert.assertEquals(expectedWarningMessage,new LoginPage_ysnblgn().username.getAttribute("validationMessage"));
        }else if(new LoginPage_ysnblgn().password.getAttribute("value").isEmpty()){
            Assert.assertEquals(expectedWarningMessage,new LoginPage_ysnblgn().password.getAttribute("validationMessage"));
        }
    }
}
