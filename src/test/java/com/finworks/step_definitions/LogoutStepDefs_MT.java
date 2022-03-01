package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_MT;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LogoutStepDefs_MT {

    @Then("the user should able to logout_MT")
    public void the_user_should_able_to_logout() {
        LoginPage_MT loginPage = new LoginPage_MT();
        loginPage.logOut();
        System.out.println("Expected Title = " + Driver.get().getTitle());
        Assert.assertTrue("Logout function doesn't work properly, please check", Driver.get().getTitle().equals("Login | Best solution for startups"));
    }
}
