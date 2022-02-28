package com.finworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LogoutPage_tarik extends BasePage_tarik {

    @FindBy(linkText = "Log out")
    public WebElement logOut;
}
