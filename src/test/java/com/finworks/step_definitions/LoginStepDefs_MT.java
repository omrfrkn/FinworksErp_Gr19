package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_MT;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDefs_MT {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }
    @When("the user enters the valid {string} information")
    public void the_user_enters_the_valid_information(String user) {
        String username = ConfigurationReader.get(user+"_email");
        String password = ConfigurationReader.get(user+"_password");

        LoginPage_MT loginPage = new LoginPage_MT();
        loginPage.login(username, password);
    }
    @When("the user should enter valid {string} and valid {string}")
    public void theUserShouldEnterValidAndValid(String userName,String password) {

        LoginPage_MT loginPage = new LoginPage_MT();
        loginPage.login(userName,password);
    }

    @Then("the user should able to get actual {string}")
    public void the_user_should_able_to_get_actual(String expectedUserType) {
        Assert.assertEquals(expectedUserType,new LoginPage_MT().actualUserName.getText().trim());
    }

    @When("the user enters the invalid_empty {string} or {string}")
    public void the_user_enters_the_invalid_empty_or(String userName, String passWord) {
        LoginPage_MT loginPage = new LoginPage_MT();
        loginPage.login(userName, passWord);
    }
    @Then("the user should get error message {string}")
    public void the_user_should_get_error_message(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage,new LoginPage_MT().error_message.getText().trim());
    }

    @Then("the user should able to get title {string}")
    public void theUserShouldAbleToGetTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle,Driver.get().getTitle());

    }

    @Then("the user should get caution message {string}")
    public void theUserShouldGetCautionMessage(String expectedMessage) {

        if((new LoginPage_MT().userName.getAttribute("value")).isEmpty()){
        Assert.assertEquals(expectedMessage,new LoginPage_MT().userName.getAttribute("validationMessage"));}
        else if ((new LoginPage_MT().userName.getAttribute("value")).isEmpty()){
        Assert.assertEquals(expectedMessage,new LoginPage_MT().password.getAttribute("validationMessage"));}

    }
    @When("the user clicks the reset password button")
    public void theUserClicksTheResetPasswordButton() {
        LoginPage_MT loginPage = new LoginPage_MT();
        loginPage.resetPasswordButton.click();
    }
}
