package com.finworks.step_definitions;


import com.finworks.pages.LoginPage_Umut;
import io.cucumber.java.en.When;

public class LogoutStepDefs_Umut {

    @When("the user click user menu")
    public void the_user_click_user_menu() {
        new LoginPage_Umut().userName.click();
    }

    @When("the user click logout button")
    public void the_user_click_logout_button() {
        new LoginPage_Umut().logoutBtn.click();
    }
}
