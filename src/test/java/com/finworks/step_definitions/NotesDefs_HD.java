package com.finworks.step_definitions;

import com.finworks.pages.NotesPage_HD;
import com.finworks.utilities.BrowserUtils;
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


public class NotesDefs_HD {

    NotesPage_HD notesPageHd = new NotesPage_HD();
    Actions actions = new Actions(Driver.get());
    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);


    @Given("the user is on the Notes page_HD")
    public void the_user_is_on_the_Notes_page() {
        notesPageHd.navigateToNotesPage();
    }

    @When("the user clicks on Create button_HD")
    public void the_user_clicks_on_Create_button() {
        notesPageHd.createButton.click();
    }

    @Then("the note panel pops up on the page_HD")
    public void the_note_panel_pops_up_on_the_page() {
        Assert.assertTrue("Note Panel pops up", notesPageHd.notePanel.isDisplayed());
    }

    @When("the user enters {string} on the note panel_HD")
    public void the_user_enters_on_the_note_panel(String noteName) {
        actions.moveToElement(notesPageHd.notePanelFinal).click().sendKeys(noteName).perform();
    }

    @When("the user clicks on Save button_HD")
    public void the_user_clicks_on_Save_button() {
        notesPageHd.saveButton.click();
    }

    @Then("the page title is {string}_HD")
    public void the_page_title_is(String noteName) {
        wait.until(ExpectedConditions.titleIs(noteName+" - Odoo"));
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Titles should match", noteName+" - Odoo", actualTitle);
    }

    @When("the user clicks on Notes tab_HD")
    public void the_user_clicks_on_Notes_tab() {
        notesPageHd.notesTab.click();
    }

    @Then("the note {string} appears on the page_HD")
    public void the_note_appears_on_the_page(String noteName) {
        BrowserUtils.waitFor(2);
        WebElement newNote = Driver.get().findElement(By.xpath("//*[.='"+noteName+"']"));
        Assert.assertTrue("Note appears on the page", newNote.isDisplayed());
    }

    @When("the user clicks on an existing note_HD")
    public void the_user_clicks_on_an_existing_note() {
        String noteName = "Group 19";
        Driver.get().findElement(By.xpath("//*[.='"+noteName+"']")).click();
    }

    @When("the user replaces the text with {string} on the note panel_HD")
    public void the_user_replaces_the_text_with_on_the_note_panel(String noteName) {
        int lengthOfNoteName = notesPageHd.notePanelFinal.getText().length();
        notesPageHd.notePanelFinal.sendKeys(Keys.HOME);
           for (int i=0; i<lengthOfNoteName; i++) {
                notesPageHd.notePanelFinal.sendKeys(Keys.DELETE);
        }
        actions.moveToElement(notesPageHd.notePanelFinal).sendKeys(noteName).perform();
    }

    @When("the user enters note name {string} in Search box_HD")
    public void the_user_enters_note_name_in_Search_box(String noteName) {
        wait.until(ExpectedConditions.titleIs("Notes - Odoo"));
        notesPageHd.searchBox.sendKeys(noteName + Keys.TAB);
    }

    @When("the user hits enter_HD")
    public void the_user_hits_enter() {
        actions.sendKeys(notesPageHd.searchBox, Keys.ENTER);
        BrowserUtils.waitFor(5);
    }

    @Then("the note {string} appears on the page alone if it exists_HD")
    public void the_note_appears_on_the_page_alone_if_it_exists(String expectedNoteName) {
        for (WebElement actualNotes : Driver.get().findElements(By.xpath("//*[@class='oe_kanban_content ']"))) {
            System.out.println(actualNotes.getText());
            Assert.assertEquals(expectedNoteName, actualNotes.getText());
        }
    }

    @When("the user clicks on Dropdown Toggle button_HD")
    public void the_user_clicks_on_Dropdown_Toggle_button () {
        BrowserUtils.clickWithJS(notesPageHd.dropdownToggleButton);
    }

    @When("the user clicks on Delete option_HD")
    public void the_user_clicks_on_Delete_option() {
        BrowserUtils.clickWithJS(notesPageHd.deleteButton);
    }

    @Then("a confirmation box pops up_HD")
    public void a_confirmation_box_pops_up() {
        Assert.assertTrue("Confirmation box is displayed", notesPageHd.confirmationBox.isDisplayed());
    }

    @When("the user clicks on Ok button_HD")
    public void the_user_clicks_on_Ok_button() {
        notesPageHd.deleteOkButton.click();
        Driver.get().navigate().refresh();
    }

    @Then("the note is deleted_HD")
    public void the_note_is_deleted() {
        String noteName = "EU7";
        String exceptionMessage = null;

        try{
            Driver.get().findElement(By.xpath("//*[.='"+noteName+"']"));
        }catch(Throwable e){
            exceptionMessage = e.getMessage();
        }
        Assert.assertTrue("Note is deleted", exceptionMessage.contains("no such element"));
    }

    @When("the user clicks on Configuration dropdown on the right of the note stage name_HD")
    public void the_user_clicks_on_Configuration_dropdown_on_the_right_of_the_note_stage_name() {
        actions.moveToElement(notesPageHd.stageNameTitle).perform();
        notesPageHd.configDropdownButton.click();
    }

    @Then("the Edit Stage option appears in the dropdown menu_HD")
    public void the_Edit_Stage_option_appears_in_the_dropdown_menu() {
        String editStageLinkText = notesPageHd.editStageButton.getText();
        Assert.assertEquals("Options should match", "Edit Stage", editStageLinkText);
    }

    @When("the user clicks on Edit Stage option_HD")
    public void the_user_clicks_on_Edit_Stage_option() {
        notesPageHd.editStageButton.click();
    }

    @Then("the Edit Column panel pops up on the page_HD")
    public void the_Edit_Column_panel_pops_up_on_the_page() {
        Assert.assertTrue("Edit Panel displays", notesPageHd.editColumnPanel.isDisplayed());
    }

    @When("the user clears the Stage Name box and enters {string}_HD")
    public void the_user_clears_the_Stage_Name_box_and_enters(String stageName) {
        notesPageHd.stageNameBox.sendKeys(Keys.HOME);
        int lengthStageTitle = notesPageHd.stageNameTitle.getText().length();
            for (int i=0; i<lengthStageTitle; i++) {
                notesPageHd.stageNameBox.sendKeys(Keys.DELETE);
            }
        actions.moveToElement(notesPageHd.stageNameBox).sendKeys(stageName).perform();
    }

    @When("the user clicks on Save button on Edit Column panel_HD")
    public void the_user_clicks_on_Save_button_on_Edit_Column_panel() {
        notesPageHd.saveStageNameButton.click();
    }

    @Then("the name of stage becomes {string}_HD")
    public void the_name_of_stage_becomes(String stageName) {
        wait.until(ExpectedConditions.textToBePresentInElement(notesPageHd.stageNameTitle,stageName));
        Assert.assertEquals("Stage names should match", notesPageHd.stageNameTitle.getText(), stageName);

        BrowserUtils.waitFor(3);
        notesPageHd.changeStageName();
    }
}