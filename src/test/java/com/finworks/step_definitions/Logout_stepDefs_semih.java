package com.finworks.step_definitions;

import com.finworks.pages.BasePage;
import com.finworks.pages.LoginPage_semih;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout_stepDefs_semih extends BasePage {

    @Given("the user logged in a sales manager_sb")
    public void the_user_logged_in_a_sales_manager_sb() {
        String email = ConfigurationReader.get("salesmanager_email");
        String password = ConfigurationReader.get("salesmanager_password");

        BrowserUtils.waitForPageToLoad(2);
        LoginPage_semih loginPage= new LoginPage_semih();
        loginPage.login(email,password);
    }
    @When("the user click on user menu_sb")
    public void the_user_click_on_user_menu_sb() {
       userMenu.click();

    }
    @When("click on logout button_sb")
    public void click_on_logout_button_sb() {
        logoutBtn.click();
    }
    @Then("the user should be land on login page_sb")
    public void the_user_should_be_land_on_login_page_sb() {
        String expectedTitle= "Login | Best solution for startups";
        BrowserUtils.waitFor(3);
        String actualTitle= Driver.get().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

}
