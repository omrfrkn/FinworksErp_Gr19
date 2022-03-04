package com.finworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotesPage_tarik extends BasePage_tarik {

    @FindBy(css = ".o-kanban-button-new")
    public WebElement createButton;

    @FindBy(css = ".active:nth-child(2)")
    public WebElement notesName;

    @FindBy(css = ".ui-autocomplete-input")
    public WebElement tagInput;

    @FindBy(css = ".panel-body")
    public WebElement notesPanel;

    @FindBy(css = ".o_kanban_group:nth-child(1) > .oe_kanban_color_0")
    public WebElement existingNote;

    @FindBy(xpath = "(//div[@class='o_dropdown_kanban dropdown'])[1]")
    public WebElement treeDot;


    @FindBy(css = ".o_form_button_save")
    public WebElement saveButton;


    @FindBy(linkText = "Delete")
    public WebElement deleteButton;

    @FindBy(css = ".btn-primary>span")
    public WebElement pouUpOk;


    @FindBy(css = ".o_searchview_input")
    public WebElement searchBox;

    @FindBy(xpath = "(//span[contains(@class,'o_kanban_config')])[1]")
    public WebElement gearIcon;


    @FindBy(xpath = "(//*[@class='o_column_edit'])[1]")
    public WebElement gearIconEdit;

    @FindBy(css=".o_field_char")
    public WebElement stageInputBox;

    @FindBy(css = ".btn-primary>span")
    public WebElement popUpSave;

    @FindBy(xpath = "(//span[@class='o_column_title'])[1]")
    public WebElement stageName;

    @FindBy(css = ".o_kanban_group:nth-child(1) .o_column_title")
    public WebElement stageNameHoverOver;


}

