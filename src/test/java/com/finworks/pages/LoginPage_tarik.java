package com.finworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_tarik extends BasePage_tarik{

    @FindBy(css = "#login")
    public WebElement emailInputBox;

    @FindBy(css = "#password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signButton;

    @FindBy(css = ".alert-danger")
    public WebElement wrongPasswordEmailAlert;

    public void login(String email, String password) {
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        signButton.click();
    }
}
