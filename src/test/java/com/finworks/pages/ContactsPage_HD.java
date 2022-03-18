package com.finworks.pages;

import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage_HD extends BasePage_HD {

    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    @FindBy(xpath = "(//span[@class='oe_menu_text'])[4]")
    public WebElement contactsTab;

    @FindBy(css = ".o_form_sheet")
    public WebElement contactInformationForm;

    @FindBy(css = "[name='name']")
    public WebElement nameBox;

    @FindBy(css = "[name='street']")
    public WebElement streetBox;

    @FindBy(css = "[name='city']")
    public WebElement cityBox;

    @FindBy(xpath = "(//*[@class='o_input ui-autocomplete-input'])[3]")
    public WebElement countryDropdown;

    @FindBy(xpath = "(//*[@class='o_input ui-autocomplete-input'])[4]")
    public WebElement tagsDropdown;

    @FindBy(css = "[name='mobile']")
    public WebElement mobileBox;

    @FindBy(css = "[name='email']")
    public WebElement emailBox;

    @FindBy(xpath = "(//*[@class='breadcrumb']//li)[2]")
    public WebElement contactNameControlPanel;

    @FindBy(css = ".o_searchview_input")
    public WebElement searchBox;

    @FindBy(css = ".o_form_sheet")
    public WebElement contactForm;

    @FindBy(css = "[accesskey='a']")
    public WebElement editButton;

    @FindBy(xpath = "(//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[3]")
    public WebElement actionDropdown;

    @FindBy(linkText = "Delete")
    public WebElement deleteOption;

    @FindBy(css = "[class='btn btn-sm btn-primary']")
    public WebElement deleteOK;


    public void navigateToContactsPage() {
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage_HD loginPageHd = new LoginPage_HD();
        loginPageHd.login("posmanager116@info.com", "posmanager");
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        contactsTab.click();
    }
}