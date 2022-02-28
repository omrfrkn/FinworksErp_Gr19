package com.finworks.pages;

import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotesPage_HD extends BasePage_HD {

    Actions actions = new Actions(Driver.get());
    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    @FindBy(xpath = "(//span[@class='oe_menu_text'])[3]")
    public WebElement notesTab;

    @FindBy(css = "[accesskey='c']")
    public WebElement createButton;

    @FindBy(css = "[class='o_form_sheet']")
    public WebElement notePanel;

    @FindBy(css = "[class='note-handle']")
    public WebElement noteEditablePanel;

    @FindBy(css = "[class='note-editable panel-body']")
    public WebElement notePanelFinal;

    @FindBy(css = "[accesskey='s']")
    public WebElement saveButton;

    @FindBy(xpath = "(//a[@class='dropdown-toggle btn'])[1]")
    public WebElement dropdownToggleButton;

    @FindBy(xpath = "(//a[@data-type='delete'])[1]")
    public WebElement deleteButton;

    @FindBy(css = ".modal-title")
    public WebElement confirmationBox;

    @FindBy(xpath = "(//*[@class='modal-footer']/button)[1]")
    public WebElement deleteOkButton;

    @FindBy(xpath = "(//*[@class='o_kanban_config dropdown'])[1]")
    public WebElement configDropdownButton;

    @FindBy(xpath = "(//*[@class='o_column_edit'])[1]")
    public WebElement editStageButton;

    @FindBy(className = "modal-content")
    public WebElement editColumnPanel;

    @FindBy(xpath = "(//table//td[2])[1]/input")
    public WebElement stageNameBox;

    @FindBy(xpath = "//*[@class='btn btn-sm btn-primary']")
    public WebElement saveStageNameButton;

    @FindBy(xpath = "(//*[@class='o_column_title'])[1]")
    public WebElement stageNameTitle;

    @FindBy(css = ".o_searchview_input")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@class='oe_kanban_content ']")
    public WebElement noteNames;

    @FindBy(xpath = "//*[@class='o_facet_values']")
    public WebElement searchValue;



    public void navigateToNotesPage() {
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage_HD loginPageHd = new LoginPage_HD();
        loginPageHd.login("posmanager116@info.com", "posmanager");
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        notesTab.click();
    }

    public void changeStageName(){
        actions.moveToElement(stageNameTitle).perform();
        configDropdownButton.click();
        editStageButton.click();

        stageNameBox.sendKeys(Keys.HOME);
        int lengthStageTitle = stageNameTitle.getText().length();
            for (int i = 0; i < lengthStageTitle; i++) {
                stageNameBox.sendKeys(Keys.DELETE);
            }
        actions.moveToElement(stageNameBox).click().sendKeys("New").perform();
        saveStageNameButton.click();
    }
}