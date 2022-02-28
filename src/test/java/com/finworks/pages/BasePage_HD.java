package com.finworks.pages;

import com.finworks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage_HD {

    public BasePage_HD() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[class='oe_topbar_name']")
    public WebElement userName;

    @FindBy(linkText = "Log out")
    public WebElement logOutLink;
}