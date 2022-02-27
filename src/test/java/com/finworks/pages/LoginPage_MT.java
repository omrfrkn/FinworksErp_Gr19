package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_MT extends BasePage{
    public LoginPage_MT() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "login")
    public WebElement userName;

    @FindBy(id ="password")
    public WebElement password;

    @FindBy(css =".btn-primary")
    public WebElement logIn;

    @FindBy(linkText = "Reset Password")
    public WebElement resetPasswordButton;

    @FindBy(tagName = "p")
    public WebElement error_message;

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement actualUserName;

    @FindBy(xpath = "//a[@data-menu='logout']")
    public WebElement logOutLink;

    public void login(String userNameStr, String passwordStr) {
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