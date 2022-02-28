package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_HD;
import com.finworks.pages.NotesPage_HD;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LogoutDefs_HD {

    NotesPage_HD notesPageHd = new NotesPage_HD();

    @Given("the user is logged in_HD")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage_HD loginPageHd = new LoginPage_HD();
        loginPageHd.login("posmanager116@info.com", "posmanager");
    }

    @When("the user clicks on the user topbar_HD")
    public void the_user_clicks_on_the_user_topbar() {
        notesPageHd.userName.click();
    }

    @Then("the Log out option appears in the drop-down menu_HD")
    public void the_Log_out_option_appears_in_the_drop_down_menu() {
        String logOutLinkText = notesPageHd.logOutLink.getText();
        Assert.assertEquals("Options should match", "Log out", logOutLinkText);
    }

    @When("the user clicks on Log out option_HD")
    public void the_user_clicks_on_Log_out_option() {
        notesPageHd.logOutLink.click();
    }

    @Then("the user logouts and lands on the login page_HD")
    public void the_user_logouts_and_lands_on_the_login_page() {
        String expectedTitle = "Login | Best solution for startups";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Titles should match", expectedTitle, actualTitle);
    }
}