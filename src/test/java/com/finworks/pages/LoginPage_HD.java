package com.finworks.pages;

import com.finworks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_HD {

    public LoginPage_HD(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "login")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(css = "[type='submit']")
    public WebElement loginButton;

    @FindBy(css = ".alert.alert-danger")
    public WebElement wrongLoginPasswordMessage;


    public void login(String email,String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}