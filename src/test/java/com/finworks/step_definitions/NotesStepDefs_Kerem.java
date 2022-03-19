package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_Kerem;
import com.finworks.pages.NotesPage_Kerem;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotesStepDefs_Kerem {

    NotesPage_Kerem ntpage = new NotesPage_Kerem();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    @Given("the user is on the {string} Page_KT")
    public void the_user_is_on_the_Page_KT(String tab) {
        new LoginPage_Kerem().login(ConfigurationReader.get("posmanager_email"), ConfigurationReader.get("posmanager_password"));
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        ntpage.navigateTo(tab);
        String expectedTitle = "Notes - Odoo";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("the user clicks the Create button_KT")
    public void the_user_clicks_the_Create_button_KT() {
        ntpage.createButton.click();
    }

    @When("the user writes {string} on the note area_KT")
    public void the_user_writes_on_the_note_area_KT(String notes) {
        BrowserUtils.waitForClickablility(ntpage.notesArea, 5);
        ntpage.notesArea.sendKeys(notes);
    }

    @When("the user clicks the Save button_KT")
    public void the_user_clicks_the_Save_button_KT() {
        ntpage.saveButton.click();
       BrowserUtils.waitFor(2);
    }

    @When("the title is {string}_KT")
    public void the_title_is__KT(String expectedTitle) {
        wait.until(ExpectedConditions.titleIs(expectedTitle + " - Odoo"));
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle + " - Odoo", actualTitle);
    }

    @When("the user clicks the {string} tab_KT")
    public void the_user_clicks_the_tab_KT(String tab) {
        ntpage.navigateTo(tab);
    }

    @Then("the {string} note visible_KT")
    public void the_note_visible_KT(String note) {
        WebElement notes = Driver.get().findElement(By.xpath("//*[.='" + note + "']"));
        Assert.assertTrue(notes.isDisplayed());
    }

    @When("the user clicks existing note {string}_KT")
    public void the_user_clicks_existing_note_KT(String oldNote) {
        WebElement note = Driver.get().findElement(By.xpath("//*[.='" + oldNote + "']"));
        note.click();
    }

    @When("user changes the note to {string}_KT")
    public void user_changes_the_note_to__KT(String newNote) {
        BrowserUtils.waitForClickablility(ntpage.notesArea, 10);
        ntpage.notesArea.clear();
        ntpage.notesArea.sendKeys(newNote);
    }

    @When("the user clicks the Search button_KT")
    public void the_user_clicks_the_Search_button_KT() {
        ntpage.searchButton.click();
    }

    @When("the user writes {string} in the search button_KT")
    public void the_user_writes_in_the_search_button_KT(String notes) {
        ntpage.searchButton.sendKeys(notes + Keys.ENTER);
        BrowserUtils.waitForPageToLoad(5);
    }

    @Then("the {string} note visible for existing_KT")
    public void the_note_visible_for_existing_KT(String noteTab) {
        WebElement notes = Driver.get().findElement(By.xpath("//span[.='" + noteTab + "']"));
        Assert.assertTrue(notes.isDisplayed());
    }


    @When("the user goes the existing note {string}_KT")
    public void the_user_goes_the_existing_note_KT(String existingNote) {
        WebElement notes = Driver.get().findElement(By.xpath("//span[.='" + existingNote + "']"));
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(notes).pause(5).perform();
    }

    @When("the user clicks the Dropdown and Delete button_KT")
    public void the_user_clicks_the_Dropdown_and_Delete_button_KT() {
        String note = "EU8 Started";
        ntpage.dropDown(note);
    }

    @Then("Confirmation pop-up_KT")
    public void confirmation_pop_up_KT() {
        Assert.assertTrue(ntpage.popUps.isDisplayed());
    }

    @When("the user clicks OK button_KT")
    public void the_user_clicks_OK_button_KT() {
        ntpage.deleteOkButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("the note is deleted {string}_KT")
    public void the_note_is_deleted_KT(String deletedMessage) {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertFalse(ntpage.getMessages().contains(deletedMessage));
    }

    @When("the user clicks the {string} note_KT")
    public void the_user_clicks_the_note_KT(String note) {
        WebElement notes = Driver.get().findElement(By.xpath("//span[.='" + note + "']"));
        notes.click();
    }

    @When("the user selects new type {string}_KT")
    public void the_user_selects_new_type__KT(String timeType) {
        ntpage.turnStageName(timeType).click();
    }


    @Then("the user sees the {string} under the {string} tab_KT")
    public void the_user_sees_the_under_the_tab_KT(String note, String timeType) {
        BrowserUtils.waitForPageToLoad(3);
        Assert.assertTrue(ntpage.getMessageinColumns(timeType).contains(note));
    }


}
