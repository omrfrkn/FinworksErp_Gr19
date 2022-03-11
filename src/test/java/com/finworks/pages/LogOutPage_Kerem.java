package com.finworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage_Kerem extends BasePage_Kerem{

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement okButtonPopUps;

    @FindBy(className = "modal-title")
    public WebElement popUpsText;
}
