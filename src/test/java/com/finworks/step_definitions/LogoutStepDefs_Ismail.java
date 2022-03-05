package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_Ismail;
import com.finworks.pages.LogoutPage_Ismail;
import com.finworks.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.UsernameAndPassword;

public class LogoutStepDefs_Ismail {



    LogoutPage_Ismail logoutPageIsmail = new LogoutPage_Ismail();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        LoginPage_Ismail loginPageIsmail= new LoginPage_Ismail();

    }

    @When("the user click user menu")
    public void the_user_click_user_menu() {
      logoutPageIsmail.logOut.click();
        BrowserUtils.waitFor(1);

    }

    @Then("the user should able to logout")
    public void the_user_should_able_to_logout() {
        new LoginPage_Ismail().logOut();
    }




}
