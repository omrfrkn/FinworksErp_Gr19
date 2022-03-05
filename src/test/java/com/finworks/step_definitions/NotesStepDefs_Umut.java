package com.finworks.step_definitions;

import com.finworks.pages.NotesPage_Umut;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class NotesStepDefs_Umut {

    NotesPage_Umut notesPage_umut = new NotesPage_Umut();
    Actions action = new Actions(Driver.get());


    @Then("the user navigate to {string} page_US")
    public void the_user_go_to_page_US(String module) {
        BrowserUtils.waitFor(4);

        notesPage_umut.navigateTo(module);
        BrowserUtils.waitFor(2);

    }

    @When("the user click {string} button_US")
    public void the_user_click__button_US(String buttonName) {
        notesPage_umut.getButton(buttonName).click();
        //BrowserUtils.waitFor(1);

    }

    @When("the user enters text as {string} in the text box_US")
    public void the_user_enters_text_as_in_the_text_box_US(String text) {
        notesPage_umut.textBox.sendKeys(text);
    }

    @When("the user selects status as {string}_US")
    public void the_user_selects_status_as__US(String statusStage) {
        notesPage_umut.getStatus(statusStage).click();
    }

    @When("the user click existing note as {string}_US")
    public void the_user_click_existing_note_as_US(String str) {

        notesPage_umut.getNote(str).click();
        BrowserUtils.waitFor(2);
    }

    @Then("the user should see sub page title as {string} - {string}_US")
    public void the_user_should_see_sub_page_title_as__US(String mainPageName, String subPageName) {


        String expectedSubTitle = mainPageName + " / " + subPageName;
        String actualSubTitle = notesPage_umut.mainPageTitle.getText() + " / " + notesPage_umut.subPageTitle.getText();

        Assert.assertEquals(expectedSubTitle, actualSubTitle);


    }


    @Then("the system deletes existing note {string} from {string} board_US")
    public void the_system_deletes_existing_note_from_kanban_board_US(String note,String column) {

        String exceptionMessage = null;
        BrowserUtils.waitFor(3);
        try {
            the_user_should_see_note_in_Column_US(note,column);
        } catch (Throwable e) {
            exceptionMessage = e.getMessage();
        }

        if (exceptionMessage != null) {
            Assert.assertTrue("verify that note is deleted", exceptionMessage.contains("no such element"));
        }
    }

    @When("the user drag and drop existing note {string} from {string} to {string} Column_US")
    public void the_user_drag_existing_note_from_Column_US(String note, String col1, String col2) {
        WebElement noteBlock = notesPage_umut.getNote(note);

        action.clickAndHold(noteBlock).dragAndDrop(noteBlock, notesPage_umut.getColumn(col2)).perform();
        BrowserUtils.waitFor(2);

    }


    @Then("the user should see note {string} in {string} Column_US")
    public void the_user_should_see_note_in_Column_US(String note, String column) {

        BrowserUtils.waitFor(2);
        String dataId = notesPage_umut.getColumn(column).getAttribute("data-id");
        String xpath = "//*[@data-id='" + dataId + "']//span[.='" + note + "']";

        WebElement expectedNote = Driver.get().findElement(By.xpath(xpath));
        WebElement actualNote = notesPage_umut.getNoteFromCertainColumn(column, note);

        Assert.assertEquals(expectedNote, actualNote);


    }

    @When("the user searches text as {string} by search box_US")
    public void the_user_enters_text_as_to_search_box_US(String text) {

        new NotesPage_Umut().search(text);

    }


    @Then("the user should see notes containing entered text {string}_US")
    public void the_user_should_only_see_notes_containing_entered_text_US(String text) {

        BrowserUtils.waitFor(2);
        List<WebElement> elements = Driver.get().findElements(By.xpath("//*[@class='oe_kanban_content ']//span[contains(.,'" + text + "')]"));


        for (WebElement element : elements) {
            Assert.assertTrue(element.getText().contains(text));
        }

    }


    @And("the user click {string} note {string} button_US")
    public void the_User_Click__note__Button_US(String note, String buttonName) {

        WebElement btn = notesPage_umut.getNoteButtons(buttonName, note);
        BrowserUtils.clickWithJS(btn);

    }

    @When("the user click note {string} button_US")
    public void the_User_Click_Note__Button_US(String buttonName, String note) {
        WebElement btn = notesPage_umut.getNoteButtons(buttonName, note);
        BrowserUtils.clickWithJS(btn);
        BrowserUtils.waitFor(3);
    }

    @Then("the user should see popup confirmation page_US")
    public void theUserShouldSeePopupConfirmationPage_US() {

        BrowserUtils.waitFor(3);
        Assert.assertEquals("Confirmation", notesPage_umut.confirmationPopUpTitle.getText());

    }

    @Given("the user should create note {string} in the {string} colum_US")
    public void the_system_should_have_existing_note__US(String note,String status){

        the_user_click__button_US("Create");
        new LoginStepDefs_Umut().the_user_should_be_on_the_page("New - Odoo");
        the_user_enters_text_as_in_the_text_box_US(note);
        the_user_selects_status_as__US(status);
        the_user_click__button_US("Save");
        new LoginStepDefs_Umut().the_user_should_be_on_the_page(note+" - Odoo");
        notesPage_umut.mainPageTitle.click();
        BrowserUtils.waitFor(3);

    }
}
