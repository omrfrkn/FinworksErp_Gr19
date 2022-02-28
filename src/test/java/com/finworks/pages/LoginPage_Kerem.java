package com.finworks.pages;

import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Kerem {

    public LoginPage_Kerem(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "login")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    @FindBy(linkText = "Reset Password")
    public WebElement resetPasswordButton;

    @FindBy(css = "p[class='alert alert-danger']")
    public WebElement wrongValidMessage;

    @FindBy(xpath = "//a/b")
    public WebElement sigInButton;

    @FindBy(className = "navbar-brand")
    public WebElement topTitle;

    public void login(String email, String password){
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

    public void loginAsPosManager(){
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

}
