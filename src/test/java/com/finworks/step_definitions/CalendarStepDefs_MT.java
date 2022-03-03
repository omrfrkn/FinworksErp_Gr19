package com.finworks.step_definitions;

import com.finworks.pages.CalendarPage_MT;
import com.finworks.pages.LoginPage_MT;
import com.finworks.utilities.ConfigurationReader_MT;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarStepDefs_MT {

    @When("The user navigates to {string} page_MT")
    public void the_user_navigates_to_page_MT(String tab) {
        new CalendarPage_MT().navigateToModule(tab);

    }

    @Then("verify that user get {string} calendar view_MT")
    public void verify_that_user_get_calendar_view_MT(String View) {
        String expectedView = ConfigurationReader_MT.get(View);
        Assert.assertEquals(expectedView,new CalendarPage_MT().actualView.getText());

    }
    @And("the user click on {string}")
    public void the_user_click_on(String navigateOption) {
        new CalendarPage_MT().navigateToView(navigateOption);

    }

    @Then("verify user land on related {string} page")
    public void verify_user_land_on_related_page(String expectedPageView) {
        String viewLocator= "//button[contains(text(),'"+expectedPageView+"')]";
        String actualPageViev=Driver.get().findElement(By.xpath(viewLocator)).getText().trim();
        Assert.assertEquals(expectedPageView, actualPageViev);

    }


}
