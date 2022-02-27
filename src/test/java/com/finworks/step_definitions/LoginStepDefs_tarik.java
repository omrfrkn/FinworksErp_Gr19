package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_tarik;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginStepDefs_tarik {

    LoginPage_tarik loginPage_tarik = new LoginPage_tarik();
    boolean flag = false;

    @When("User enters valid {string} and {string}")
    public void user_enters_valid_and(String email, String password) {
        loginPage_tarik.login(email, password);
    }
    @Then("User should see page title {string}")
    public void user_should_see_page_title(String expectedTitle) {
        BrowserUtils.waitFor(7);
        String actualPageTitle = Driver.get().getTitle();
        System.out.println("expectedPageTitle = " + expectedTitle);
        System.out.println("actualPageTitle = " + actualPageTitle);
        Assert.assertEquals("Verify page title", expectedTitle, actualPageTitle);
    }
    @When("User enters invalid {string} and {string}")
    public void user_enters_invalid_and(String email, String password) {
        loginPage_tarik.login(email, password);
    }
    @Then("User should see {string} warning message")
    public void user_should_see_warning_message(String expectedMessage) {
        String actualMessage = loginPage_tarik.wrongPasswordEmailAlert.getText();
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals("verify warning message", expectedMessage, actualMessage);
    }
    @When("User does not enter {string} or {string}")
    public void user_does_not_enter_or(String email, String password) {
        loginPage_tarik.login(email, password);
        if (email.isEmpty()) {
            flag = true;
        }
    }
    @Then("User should see {string} error message")
    public void user_should_see_error_message(String expectedMessage) {
        String actualMessage;
        if (flag) {
            WebElement username = Driver.get().findElement(By.name("login"));
            actualMessage = username.getAttribute("validationMessage");
        } else {
            WebElement password = Driver.get().findElement(By.name("password"));
            actualMessage = password.getAttribute("validationMessage");
        }
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals("verify warning message", expectedMessage, actualMessage);
    }
}
