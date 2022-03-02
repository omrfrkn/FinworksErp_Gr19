package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_semih extends BasePage {

    @FindBy(id = "login")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement LoginBtn;

    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement errorMessage;

    public void login(String email, String password) {
        userName.sendKeys(email);
        this.password.sendKeys(password);
        LoginBtn.click();
    }
}