package com.finworks.pages;

import com.finworks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage_tarik {
    public BasePage_tarik() {PageFactory.initElements(Driver.get(), this);}

    @FindBy(css = ".oe_topbar_name")
    public WebElement userMenu;
}
