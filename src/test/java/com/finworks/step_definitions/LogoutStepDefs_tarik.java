package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_tarik;
import com.finworks.pages.LogoutPage_tarik;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class LogoutStepDefs_tarik {

    LoginPage_tarik loginPageTarik = new LoginPage_tarik();
    LogoutPage_tarik logoutPage_tarik = new LogoutPage_tarik();

    @Given("User is logged in using following {string} and {string}_tarik")
    public void user_is_logged_in_using_following_and(String email, String password) {
        loginPageTarik.login(email, password);
    }

    @When("User clicks username right side on the topbar_tarik")
    public void user_clicks_username_right_side_on_the_topbar() {
        logoutPage_tarik.userMenu.click();

    }

    @And("User clicks Log out in the user drop down menu_tarik")
    public void user_clicks_Log_out_in_the_user_drop_down_menu() {
        logoutPage_tarik.logOut.click();
        BrowserUtils.waitFor(1);
    }

    @Then("User is redirected login page and title should be  {string}_tarik")
    public void user_is_redirected_login_page_and_title_should_be(String expectedTitle) {
        BrowserUtils.waitFor(1);
        String actualPageTitle = Driver.get().getTitle();
        System.out.println("expectedPageTitle = " + expectedTitle);
        System.out.println("actualPageTitle = " + actualPageTitle);
        Assert.assertEquals("Verify page title", expectedTitle, actualPageTitle);
    }

}
