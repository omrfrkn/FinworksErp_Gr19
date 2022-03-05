package com.finworks.pages;

import com.finworks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage_Ismail {

    public BasePage_Ismail() {
        PageFactory.initElements(Driver.get(), this);}

    @FindBy(css = ".oe_topbar_name")
    public WebElement userMenu;

    // Be carereful!
}
