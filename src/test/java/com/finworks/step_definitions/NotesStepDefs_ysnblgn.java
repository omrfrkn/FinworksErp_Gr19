package com.finworks.step_definitions;

import com.finworks.pages.DashBoardPage_ysnblgn;
import com.finworks.pages.LoginPage_ysnblgn;
import com.finworks.pages.NotesPage_ysnblgn;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author ybilgin
 * @project FinworksErp_Gr19
 */


public class NotesStepDefs_ysnblgn {


    NotesPage_ysnblgn notesPage = new NotesPage_ysnblgn();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
    String noteText;

    @Given("the user navigates to {string} page_YB")
    public void theUserNavigatesTo_YB(String tabName) {
        new LoginPage_ysnblgn().login();
        new DashBoardPage_ysnblgn().navigateTo(tabName);
    }

    @When("the user clicks on {string} button_YB")
    public void the_user_clicks_on_button_YB(String subTabStr) {
        notesPage.notesNavigateSubTab(subTabStr);
    }

    @When("the user writes a note as {string} in the panel textbox_YB")
    public void the_user_writes_a_note_as_in_the_panel_body_YB(String text) {
        notesPage.panelTextBox.clear();
        notesPage.panelTextBox.sendKeys(text);
    }


    @When("the user clicks on an existing note_YB")
    public void theUserClicksOnAnExistingNote_YB() {
        notesPage.listButton.click();
        int countNote = notesPage.countNotes();
        notesPage.existingNotes.get(countNote).click();
    }

    @When("the user enters a note summary as {string} in the search box_YB")
    public void theUserEntersNoteNameAsInTheSearchBox_YB(String noteSummary) {
        wait.until(ExpectedConditions.titleIs("Notes - Odoo"));
        notesPage.listButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(notesPage.existingNotes));
        notesPage.searchBox.sendKeys(noteSummary + Keys.ENTER);

    }

    @Then("the user should see note summary as {string} in the web table_YB")
    public void theUserShouldSeeNoteSummaryAsInTheWebTable_YB(String expectedNoteSummary) {
        BrowserUtils.waitFor(2);
        //wait.until(ExpectedConditions.visibilityOfAllElements(notesPage.existingNotes));
        for (WebElement actualNoteSummary : notesPage.existingNotes) {
            Assert.assertEquals(expectedNoteSummary,actualNoteSummary.getText());
        }
    }

    @When("the user selects an existing note's checkbox_YB")
    public void theUserSelectsAnExistingNoteSCheckbox_YB() {

        notesPage.listButton.click();
        notesPage.getRandomNoteElement().click();

    }

    @And("the user clicks on Delete button_YB")
    public void theUserClicksOnDeleteButton_YB() {
        notesPage.actionDropDown.click();
        notesPage.noteDeleteBtn.click();
    }

    @And("the user clicks on Ok button on the pop up_YB")
    public void theUserClicksOnOkButtonOnThePopUp_YB() {
        BrowserUtils.waitForClickablility(notesPage.okBtnForDelete,3);
        notesPage.okBtnForDelete.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(notesPage.existingNotes));
    }

    @Then("the user should not see deleted note in the web table_YB")
    public void theUserShouldNotSeeDeletedNoteInTheWebTable_YB() {
        BrowserUtils.waitFor(2);
        List<WebElement> elements = notesPage.noteCheckboxes;

        for (WebElement actualElement : elements) {
            if(elements.size()!=0){
                String expectedElement = notesPage.getRandomNoteElement().getText();
                Assert.assertTrue(actualElement.getText().contains(expectedElement));
            }
        }
    }


    @When("the user moves an existing note to {string} stage_YB")
    public void theUserMovesAnExistingNoteToStage_YB(String expStageTitleName) {

        WebElement source = notesPage.sourceStageNotes.get(0);
        WebElement target = notesPage.getTargetAccordingToStageTitle(expStageTitleName);

        noteText = source.getText();

        Actions actions = new Actions(Driver.get());
        actions.dragAndDrop(source,target).pause(3).perform();

    }

    @Then("the user should see that note's stage name changed as {string}_YB")
    public void theUserShouldSeeThatNotesStageNameChangedAs_YB(String expectedStageName) {

        notesPage.listButton.click();
        String actualStageName = notesPage.getNoteStageName(noteText);
        System.out.println(actualStageName);

        Assert.assertEquals(expectedStageName,actualStageName);
    }
}
