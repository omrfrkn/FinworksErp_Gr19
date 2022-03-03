package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_MT;
import com.finworks.utilities.ConfigurationReader_MT;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginStepDefs_MT {
    @Given("the user is on the login page_MT")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader_MT.get("url");
        Driver.get().get(url);
    }
    @When("the user enters the valid {string} information_MT")
    public void the_user_enters_the_valid_information(String user) {
        String username = ConfigurationReader_MT.get(user+"_email");
        String password = ConfigurationReader_MT.get(user+"_password");

        LoginPage_MT loginPage = new LoginPage_MT();
        loginPage.login(username, password);
    }
    @When("the user should enter valid {string} and valid {string}_MT")
    public void theUserShouldEnterValidAndValid(String userName,String password) {

        LoginPage_MT loginPage = new LoginPage_MT();
        loginPage.login(userName,password);
    }

    @Then("the user should able to get actual {string}_MT")
    public void the_user_should_able_to_get_actual(String expectedUserType) {
        Assert.assertEquals(expectedUserType,new LoginPage_MT().actualUserName.getText().trim());
    }

    @When("the user enters the invalid_empty {string} or {string}_MT")
    public void the_user_enters_the_invalid_empty_or(String userName, String passWord) {
        LoginPage_MT loginPage = new LoginPage_MT();
        loginPage.login(userName, passWord);
    }
    @Then("the user should get error message {string}_MT")
    public void the_user_should_get_error_message(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage,new LoginPage_MT().error_message.getText().trim());
    }

    @Then("the user should able to get title {string}_MT")
    public void theUserShouldAbleToGetTitle(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertEquals(expectedTitle,Driver.get().getTitle());

    }
    @When("the user clicks the reset password button_MT")
    public void theUserClicksTheResetPasswordButton() {
        LoginPage_MT loginPage = new LoginPage_MT();
        loginPage.resetPasswordButton.click();
    }

    @Then("the user should get caution message {string}_MT")
    public void theUserShouldGetCautionMessage(String expectedMessage) {

        if((new LoginPage_MT().userName.getAttribute("value")).isEmpty()){
        Assert.assertEquals(expectedMessage,new LoginPage_MT().userName.getAttribute("validationMessage"));}
        else if ((new LoginPage_MT().userName.getAttribute("value")).isEmpty()){
        Assert.assertEquals(expectedMessage,new LoginPage_MT().password.getAttribute("validationMessage"));}

    }

}
