package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class LoginPage_Ismail  extends  BasePage{
    public static Label wrongPasswordEmailAlert;

    @FindBy(id = "login")
    public static WebElement userName;

    @FindBy(id ="password")
    public static WebElement password;

    @FindBy(css =".btn-primary")
    public static WebElement logIn;

    @FindBy(linkText = "Reset Password")
    public WebElement resetPasswordButton;

    @FindBy(xpath = "//p[1]")
    public WebElement error_message;

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement actualUserName;

    @FindBy(xpath = "//a[@data-menu='logout']")
    public WebElement logOutLink;

    public void login(String userNameStr, String passwordStr) {
        BrowserUtils.waitFor(3);
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        logIn.click();
    }

    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(actualUserName);
        BrowserUtils.clickWithJS(logOutLink);
    }
}