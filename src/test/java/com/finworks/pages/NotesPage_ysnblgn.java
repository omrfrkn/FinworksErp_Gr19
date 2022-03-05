package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

/**
 * @author ybilgin
 * @project FinworksErp_Gr19
 */


public class NotesPage_ysnblgn extends BasePage_ysnblgn{

    @FindBy(className = "o_searchview_input")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='note-editable panel-body']")
    public WebElement panelTextBox;

    @FindBy(xpath = "//button[@aria-label='kanban']")
    public WebElement kanbanButton;

    @FindBy(xpath = "//button[@aria-label='list']")
    public WebElement listButton;

    @FindBy(xpath = "//td[contains(@class,'modifier')]")
    public List<WebElement> existingNotes;

    @FindBy(xpath = "//td[contains(@class,'selector')]//input")
    public List<WebElement> noteCheckboxes;

    @FindBy(partialLinkText = "Delete")
    public WebElement noteDeleteBtn;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[2]")
    public WebElement actionDropDown;

    @FindBy(xpath = "(//*[@class='modal-footer']/button)[1]")
    public WebElement okBtnForDelete;

    @FindBy(xpath = "//span[@class='o_column_title'][1]/parent::div/../..//div[contains(@class,'kanban_card')]")
    public List<WebElement> sourceStageNotes;


    public void notesNavigateSubTab(String subTab){
        String locator = "//button[contains(text(),'"+subTab+"')]";
        BrowserUtils.waitForClickablility(By.xpath(locator),10);
        Driver.get().findElement(By.xpath(locator)).click();

    }

    public int countNotes(){
        Random rc = new Random();

        int noteSize = 0;
        if(existingNotes.size()!=1){
            noteSize = rc.nextInt(existingNotes.size()-1);
        }
        return noteSize;
    }

    public WebElement getRandomNoteElement(){
        return noteCheckboxes.get(countNotes());

    }

    public String getNoteStageName(String noteText){
        String locator = "//table[contains(@class,'table')]//td[.='"+noteText+"']/../td[4]";
        BrowserUtils.waitForVisibility(By.xpath(locator),5);
        return  Driver.get().findElement(By.xpath(locator)).getText();
    }

    public WebElement getTargetAccordingToStageTitle(String title){
        String locator = "//div/span[.='"+title+"']/../../..";
        BrowserUtils.waitForVisibility(By.xpath(locator),5);
        return  Driver.get().findElement(By.xpath(locator));
    }

    public String getNotesText(){
         return sourceStageNotes.get(0).getText();

    }
}
