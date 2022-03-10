package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NotesPage_Kerem extends BasePage_Kerem{

    @FindBy(css = "button[accesskey='c']")
    public WebElement createButton;

    @FindBy(xpath = "//button[contains(text(),'Import')]")
    public WebElement importButton;

    @FindBy(css = "div[class='note-editable panel-body']")
    public WebElement notesArea;

    @FindBy(css = "button[accesskey='s']")
    public WebElement saveButton;

    @FindBy(css = "button[accesskey='j']")
    public WebElement discardButton;

    @FindBy(css = "div>ol>li[class='active']")
    public WebElement topTitle;

    @FindBy(className = "o_searchview_input")
    public WebElement searchButton;

    @FindBy(css = "button[class='btn btn-sm btn-primary']")
    public WebElement deleteOkButton;

    @FindBy(css = "button[class='btn btn-sm btn-default']")
    public WebElement deleteCancelButton;

    @FindBy(className = "modal-title")
    public WebElement popUps;

    @FindBy(css = "[data-value='3994']")
    public WebElement newType;

    @FindBy(css = "[data-value='1524']")
    public WebElement todayType;

    @FindBy(css = "[data-value='1525']")
    public WebElement thisWeekType;

    @FindBy(css = "[data-value='1526']")
    public WebElement laterType;

    @FindBy(css = "[data-value='3998']")
    public WebElement weekendType;


    @FindBy(xpath = "//div[data-id='3994']")
    public WebElement newColumn;

    @FindBy(xpath = "//div[data-id='1524']")
    public WebElement todayColumn;

    @FindBy(xpath = "//div[data-id='1525']")
    public WebElement thisWeekColumn;

    @FindBy(xpath = "//div[data-id='1526']")
    public WebElement laterColumn;

    @FindBy(xpath = "//div[data-id='3998']")
    public WebElement weekendColumn;



    public WebElement turnStageName(String type){
        WebElement stageName = null;

        switch (type){
            case "New":
                stageName = newType;
                break;
            case "Today":
                stageName = todayType;
                break;
            case "This Week":
                stageName = thisWeekType;
                break;
            case "Later":
                stageName = laterType;
                break;
            case "Weekend":
                stageName = weekendType;
                break;
        }
        return stageName;

    }

    public void dropDown(String note){

        String dropdown = "//span[.='"+note+"']//..//preceding-sibling::div[contains(@class,'o_dropdown_kanban dropdown')]";
        String threeDot = dropdown+"//a[@class='dropdown-toggle btn']";
        String deleteButton = dropdown + "//a[.='Delete']";

        WebElement threeDotButton = Driver.get().findElement(By.xpath(dropdown));
        threeDotButton.click();
        WebElement deleteNote = Driver.get().findElement(By.xpath(deleteButton));

      deleteNote.click();
    }

    public List<String> getMessages(){
       return BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//span[@class='oe_kanban_content ']/span")));

    }

    public List<String> getMessageinColumns(String column){

        List<String> elementsText = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//span[normalize-space()='"+column+"']/../../..//span[@class='oe_kanban_content ']")));
          return  elementsText;
    }




}
