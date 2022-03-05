package com.finworks.pages;

import com.finworks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class NotesPage_Umut extends BasePage_Umut {


    @FindBy(css = "[accesskey='c']")
    public WebElement createBtn;

    @FindBy(xpath = "//div[@class='note-editable panel-body']")
    public WebElement textBox;

    @FindBy(css = "button[accesskey='c']")
    public WebElement statusNew;

    @FindBy(css = "[data-value='1709']")
    public WebElement statusToday;

    @FindBy(css = "[data-value='1710']")
    public WebElement statusThisWeek;

    @FindBy(css = "[data-value='1711']")
    public WebElement statusLater;

    @FindBy(css = "[data-value='1712']")
    public WebElement statusNotes;

    @FindBy(css = "button[accesskey='s']")
    public WebElement saveBtn;

    @FindBy(css = "button[accesskey='j']")
    public WebElement discardBtn;

    @FindBy(css = "[class='breadcrumb']>li>a")
    public WebElement mainPageTitle;

    @FindBy(css = "[class='breadcrumb']>[class='active']")
    public WebElement subPageTitle;

    @FindBy(xpath = "//h4[@class='modal-title']")
    public WebElement confirmationPopUpTitle;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement confirmationOkBtn;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default']")
    public WebElement confirmationCancelBtn;

    @FindBy(css = "[data-id='1708']")
    public WebElement columnNew;

    @FindBy(css = "[data-id='1709']")
    public WebElement columnToday;

    @FindBy(css = "[data-id='1710']")
    public WebElement columnThisWeek;

    @FindBy(css = "[data-id='1711']")
    public WebElement columnLater;

    @FindBy(css = "[data-id='1712']")
    public WebElement columnNotes;


    public WebElement getNote(String text) {
        String xpath = "//span[contains(@class,'content')]//span[.='" + text + "']";
        WebElement noteContent = Driver.get().findElement(By.xpath(xpath));
        return noteContent;
    }

    public WebElement getNoteFromCertainColumn(String column,String text){

        String dataId = new NotesPage_Umut().getColumn(column).getAttribute("data-id");
        String xpath= "//*[@data-id='" + dataId + "']//span[.='" + text + "']";

        return Driver.get().findElement(By.xpath(xpath));

    }

    public WebElement getNoteButtons(String buttonName, String note) {
        String dropdownXpath="//span[.='" + note + "']//..//preceding-sibling::div[contains(@class,'o_dropdown_kanban dropdown')]";

        String threeDotXpath = dropdownXpath+"//a[@class='dropdown-toggle btn']";
        WebElement threeDotBtn = Driver.get().findElement(By.xpath(threeDotXpath));

        String noteDeleteXpath=dropdownXpath+"//a[.='Delete']";
        WebElement noteDeleteBtn= Driver.get().findElement(By.xpath(noteDeleteXpath));

        WebElement selectedButton=null;

        switch (buttonName){

            case "three dot":
                selectedButton=threeDotBtn;
                break;
            case "delete":
                selectedButton=noteDeleteBtn;
                break;

        }

        if(selectedButton==null){
            System.out.println("Web element is not found");
        }

        return selectedButton;
    }

    public WebElement getButton(String buttonName) {

        List<Map<String, WebElement>> buttons = new ArrayList<>();

        Map<String, WebElement> create = new HashMap<>();
        create.put("Create", createBtn);
        Map<String, WebElement> save = new HashMap<>();
        save.put("Save", saveBtn);
        Map<String, WebElement> discard = new HashMap<>();
        discard.put("Discard", discardBtn);
        Map<String, WebElement> confirmOk = new HashMap<>();
        confirmOk.put("Ok", confirmationOkBtn);
        Map<String, WebElement> confirmCancel = new HashMap<>();
        confirmCancel.put("Cancel", confirmationCancelBtn);

        buttons.add(create);
        buttons.add(save);
        buttons.add(discard);
        buttons.add(confirmOk);
        buttons.add(confirmCancel);

        WebElement btn = null;

        for (Map<String, WebElement> button : buttons) {
            if (button.containsKey(buttonName)) {
                btn = button.get(buttonName);
            }
        }

        return btn;

    }

    public WebElement getStatus(String str) {

        WebElement statusStage = null;

        switch (str.toLowerCase()) {
            case "new":
                statusStage = statusNew;
                break;
            case "today":
                statusStage = statusToday;
                break;
            case "this week":
                statusStage = statusThisWeek;
                break;
            case "later":
                statusStage = statusLater;
                break;
            case "notes":
                statusStage = statusNotes;
                break;

        }

        return statusStage;
    }

    public WebElement getColumn(String columnName) {

        WebElement column =null;

        try {
            switch (columnName.toLowerCase()) {
                case "new":
                    column = columnNew;
                    break;
                case "today":
                    column = columnToday;
                    break;
                case "this week":
                    column = columnThisWeek;
                    break;
                case "later":
                    column = columnLater;
                    break;
                case "notes":
                    column = columnNotes;
                    break;

            }

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Column not found");
        }

        return column;
    }


}
