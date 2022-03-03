package com.finworks.step_definitions;

import com.finworks.pages.LoginPage_tarik;
import com.finworks.pages.NotesPage_tarik;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import javax.sql.rowset.BaseRowSet;

public class NotesStepDefs_tarik {

    NotesPage_tarik notesPage_tarik=new NotesPage_tarik();

    @Given("User should be able to log in application_tarik")
    public void user_should_be_able_to_log_in_application_tarik() {
        new LoginPage_tarik().login();
    }
    @And("User should be able to navigate {string} module_tarik")
    public void user_should_be_able_to_navigate_module_tarik(String moduleName) {
        notesPage_tarik.navigateToModule(moduleName);
        BrowserUtils.waitFor(4);
    }
    @When("User clicks create button_tarik")
    public void user_clicks_create_button_tarik() {
        BrowserUtils.waitFor(4);
        notesPage_tarik.createButton.click();
    }

    @And("User enter note as {string}_tarik")
    public void user_enter_note_as__tarik(String notes) {
        BrowserUtils.waitFor(3);
        notesPage_tarik.notesPanel.sendKeys(notes);
    }

    @When("User clicks save button_tarik")
    public void user_clicks_save_button() {
        notesPage_tarik.saveButton.click();
    }

    @Then("User should be able to see page title as {string}_tarik")
    public void user_should_be_able_to_see_page_title_as__tarik(String expectedTitle) {
        BrowserUtils.waitFor(2);
        String actualPageTitle = Driver.get().getTitle();
        Assert.assertEquals("Verify page title", expectedTitle, actualPageTitle);
    }
    @When("User clicks on the note which want to edit_tarik")
    public void user_clicks_on_the_note_which_want_to_edit_tarik() {
        BrowserUtils.waitFor(5);
        notesPage_tarik.existingNote.click();
    }
    @And("User writes key word {string}  in the search box and presses enter_tarik")
    public void user_writes_key_word_in_the_search_box_and_presses_enter_tarik(String keyWord) {
        notesPage_tarik.searchBox.sendKeys(keyWord + Keys.ENTER);
    }
    @Then("User should only see notes about to key word on the page and notes should contains {string}_tarik")
    public void user_should_only_see_notes_about_to_key_word_on_the_page_and_notes_should_contains__tarik(String searchingKeyWord) {
        String findingNote = notesPage_tarik.existingNote.getText();
        Assert.assertTrue("verify notes contain keyword", findingNote.contains(searchingKeyWord));
    }
    @When("User hover over the note to delete_tarik")
    public void user_hover_over_the_note_to_delete_tarik() {
        BrowserUtils.waitFor(2);
        Actions actions=new Actions(Driver.get());
        actions.moveToElement(notesPage_tarik.existingNote).perform();
        BrowserUtils.waitFor(2);
    }
    @And("User clicks three vertical dot icon and drop-down menu is displayed_tarik")
    public void user_clicks_three_vertical_dot_icon_and_drop_down_menu_is_displayed_tarik() {
        notesPage_tarik.treeDot.click();
    }
    @And("User clicks delete button and confirmation pop-up menu is opened_tarik")
    public void user_clicks_delete_button_and_confirmation_pop_up_menu_is_opened_tarik() {
        BrowserUtils.waitFor(2);
        notesPage_tarik.deleteButton.click();
    }
    @Then("User clicks Ok button on the confirmation pop-up_tarik")
    public void user_clicks_Ok_button_on_the_confirmation_pop_up_tarik() {
        BrowserUtils.waitFor(2);
        notesPage_tarik.pouUpOk.click();
    }
    @When("User clicks gear icon between stage name and plus sign_tarik")
    public void user_clicks_gear_icon_between_stage_name_and_plus_sign_tarik() {
        Actions actions=new Actions(Driver.get());
        actions.moveToElement(notesPage_tarik.stageNameHoverOver).perform();
        BrowserUtils.waitFor(1);
        notesPage_tarik.gearIcon.click();
    }
    @And("User clicks Edit Stage button on the dropdown menu_tarik")
    public void user_clicks_Edit_Stage_button_on_the_dropdown_menu_tarik() {
      notesPage_tarik.gearIconEdit.click();
    }

    @And("User writes {string} in the stage name input box_tarik")
    public void user_writes_in_the_stage_name_input_box_tarik(String stageName) {
        notesPage_tarik.clearExistingText(notesPage_tarik.stageInputBox, stageName );
    }
    @And("User clicks Save button_tarik")
    public void user_clicks_Save_button_tarik() {notesPage_tarik.popUpSave.click();}

    @Then("User should see new stage name as {string}_tarik")
    public void user_should_see_new_stage_name_as__tarik(String expectedStageName) {
        BrowserUtils.waitFor(2);
        String actualStageName=notesPage_tarik.stageName.getText();
        Assert.assertEquals("verify stage name", expectedStageName,actualStageName);

// extra code to rename stage name as default one "New"
        BrowserUtils.waitFor(3);
        Actions actions=new Actions(Driver.get());
        actions.moveToElement(notesPage_tarik.stageNameHoverOver).perform();
        BrowserUtils.waitFor(1);
        notesPage_tarik.gearIcon.click();
        notesPage_tarik.gearIconEdit.click();
        notesPage_tarik.clearExistingText(notesPage_tarik.stageInputBox, "New" );
        notesPage_tarik.popUpSave.click();
        BrowserUtils.waitFor(2);
    }




}
