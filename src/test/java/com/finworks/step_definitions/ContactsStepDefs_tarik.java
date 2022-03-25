package com.finworks.step_definitions;

import com.finworks.pages.ContactsPage_tarik;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContactsStepDefs_tarik {

    ContactsPage_tarik contactsPage_tarik = new ContactsPage_tarik();
    WebDriverWait wait = new WebDriverWait(Driver.get(),10);

    @When("User enters contact name as {string} in the name box_tarik")
    public void user_enters_contact_name_as_in_the_name_box_tarik(String sampleName) {
        contactsPage_tarik.nameInputBox.sendKeys(sampleName);
    }
    @Then("User should see {string} near the avatar_tarik")
    public void user_should_see_near_the_avatar(String expectedSavingName) {
        assertEquals("Verify saving name", expectedSavingName, contactsPage_tarik.savingName.getText());
    }

    @When("User enters contact name as {string} in the search box and presses enter_tarik")
    public void user_enters_contact_name_as_in_the_search_box_and_presses_enter_tarik(String searchingName) {
        BrowserUtils.waitFor(3);
        contactsPage_tarik.searchBox.sendKeys(searchingName + Keys.TAB);
    }

    @When("User clicks on contact which is title {string} _tarik")
    public void user_clicks_on_contact_which_is_title__tarik(String string) {
        wait.until(ExpectedConditions.elementToBeClickable(contactsPage_tarik.searchingContact));
        contactsPage_tarik.searchingContact.click();
    }

    @When("User clicks Edit button_tarik")
    public void user_clicks_Edit_button_tarik() {
        wait.until(ExpectedConditions.elementToBeClickable(contactsPage_tarik.editButton));
        contactsPage_tarik.editButton.click();
    }




}
