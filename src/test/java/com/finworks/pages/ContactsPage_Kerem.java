package com.finworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage_Kerem extends BasePage_Kerem{

    @FindBy(css = "button[accesskey='c']")
    public WebElement createButton;

    @FindBy(css = "button[accesskey='a']")
    public WebElement editButton;

    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement nameBox;

    @FindBy(xpath = "//span[@title='Edit']")
    public WebElement uploadPhoto;

    @FindBy(xpath = "//span[@title='Clear']")
    public WebElement deletePhoto;

    @FindBy(className = "oe_view_nocontent_create")
    public WebElement afterDeleteMessage;

    @FindBy(name = "image")
    public WebElement photoArea;

    @FindBy(name = "street")
    public WebElement addressBox;

    @FindBy(name = "city")
    public WebElement cityBox;

    @FindBy(className = "o_searchview_input")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@name='country_id']//input[@type='text']")
    public WebElement dropDownForCountry;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[3]")
    public WebElement countryText;

    @FindBy(css = "button[accesskey='s']")
    public WebElement saveButton;

    @FindBy(css = "button[accesskey='j']")
    public WebElement discardButton;

    @FindBy(xpath = "(//div[@class='btn-group o_dropdown'])[3]")
    public WebElement action;

    @FindBy(xpath = "(//input[@placeholder='Search...'])[2]")
    public WebElement searchBoxforCountry;








}
