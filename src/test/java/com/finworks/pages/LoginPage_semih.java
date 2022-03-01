package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_semih {

    @FindBy(id = "login")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(className = "btn btn-primary")
    public WebElement LoginBtn;


    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        LoginBtn.click();
    }
}