package com.finworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage_Ismail extends BasePage_Ismail {

    @FindBy(linkText = "Log out")
    public WebElement logOut;
}
