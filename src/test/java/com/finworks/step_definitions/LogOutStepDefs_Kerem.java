package com.finworks.step_definitions;

import com.finworks.pages.DashBoardPage_Kerem;
import com.finworks.pages.LogOutPage_Kerem;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOutStepDefs_Kerem {

    @Then("the user should be able to logout and title as a {string}_KT")
    public void the_user_should_be_able_to_logout_and_title_as_a_Login_Best_solution_for_startups(String expectedTitle) {
        DashBoardPage_Kerem dashBoardPage = new DashBoardPage_Kerem();
        dashBoardPage.userName.click();
        dashBoardPage.logout.click();
        String actualTitle = Driver.get().getTitle();
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("the user navigates to back")
    public void the_user_navigates_to_back() {
        Driver.get().navigate().back();
    }

    @Then("the user should be able to see opoUps Message as {string}")
    public void the_user_should_be_able_to_see_opoUps_Message_as(String expectedPopupsMessage) {
        String actualMessage = new LogOutPage_Kerem().popUpsText.getText();
        Assert.assertEquals(expectedPopupsMessage, actualMessage);

    }

}
