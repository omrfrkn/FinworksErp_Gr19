package com.finworks.step_definitions;

import com.finworks.pages.DashBoardPage_Kerem;
import com.finworks.pages.LoginPage_Kerem;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs_Kerem {

    LoginPage_Kerem loginPage = new LoginPage_Kerem();

    @Given("the user is on the login page_KT")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters {string} and {string}_KT")
    public void the_user_enters_and(String email, String password) {

        loginPage.login(email, password);
        BrowserUtils.waitFor(2);
    }

    @Then("the title contains {string}_KT")
    public void the_title_contains(String expectedTitle) {
        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the user should be able to see own name as a {string}_KT")
    public void the_user_should_be_able_to_see_own_name_as_a(String expectedName) {
        String actualName = new DashBoardPage_Kerem().getUserName();
        Assert.assertEquals(expectedName,actualName);
    }


    @Then("user should be able too see error message as {string}_KT")
    public void user_should_be_able_too_see_error_message_as(String expectedMessage) {
        BrowserUtils.waitFor(2);
        String actualMessage = loginPage.wrongValidMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("user should be able to see warning message as {string}_KT")
    public void user_should_be_able_to_see_warning_message_as(String expectedMessage) {
        if (loginPage.emailBox.getAttribute("value").isEmpty()){
            Assert.assertEquals(expectedMessage,loginPage.emailBox.getAttribute("validationMessage"));
        }else if (loginPage.passwordBox.getAttribute("value").isEmpty()){
            Assert.assertEquals(expectedMessage,loginPage.passwordBox.getAttribute("validationMessage"));
        }
    }


    @When("user enters invalid {string} and {string}_KT")
    public void user_enters_invalid_and(String email, String password) {
        loginPage.login(email,password);
    }

    @When("the user enters missing {string} and {string}_KT")
    public void the_user_enters_missing_and(String email, String password) {
        loginPage.login(email, password);
    }

    @When("the user clicks the reset password button_KT")
    public void the_user_clicks_the_reset_password_button() {
        loginPage.resetPasswordButton.click();
    }

    @Then("the top title contains {string}_KT")
    public void the_top_title_contains(String expectedTopTittle) {
        String actualtopTittle = loginPage.topTitle.getText();
        Assert.assertEquals(expectedTopTittle,actualtopTittle);
    }




}
