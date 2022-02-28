package com.finworks.step_definitions;

import com.finworks.pages.DashBoardPage_Kerem;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LogOutStepDefs_Kerem {

    @Then("the user should be able to logout and title as a {string}_KT")
    public void the_user_should_be_able_to_logout_and_title_as_a_Login_Best_solution_for_startups(String expectedTitle) {
        DashBoardPage_Kerem dashBoardPage = new DashBoardPage_Kerem();
        dashBoardPage.userName.click();
        dashBoardPage.logout.click();
        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
