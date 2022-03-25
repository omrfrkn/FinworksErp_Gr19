package com.finworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage_tarik extends BasePage_tarik {


    @FindBy (css = ".o-kanban-button-new")
    public WebElement createButton;

    @FindBy (xpath = "//input[@placeholder='Name']")
    public WebElement nameInputBox;

    @FindBy (css = ".o_form_button_save")
    public WebElement saveButton;

    @FindBy (css = ".o_searchview_input")
    public WebElement searchBox;

    @FindBy (css = ".oe_kanban_global_click")
    public WebElement searchingContact;

    @FindBy (css = "span[name='name']")
    public WebElement savingName;

    @FindBy (xpath = "//button[@accesskey='a']")
    public WebElement editButton;

    @FindBy (css = "#o_field_input_36")
    public WebElement countryDropDown;








}
