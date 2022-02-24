package com.finworks.pages;
import com.finworks.pages.BasePage;
import com.finworks.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author ybilgin
 * @project FinworksErp
 */


public class LoginPage_ysnblgn extends BasePage_ysnblgn {

    @FindBy(id = "login")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "[type='submit']")
    public WebElement loginBtn;

    @FindBy(linkText = "Reset Password")
    public WebElement resetPassword;

    @FindBy(css = ".alert.alert-danger")
    public WebElement errorMessage;

    public void login(){
        this.username.sendKeys(ConfigurationReader.get("posmanager_email"));
        this.password.sendKeys(ConfigurationReader.get("posmanager_password"));
        loginBtn.click();
    }

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();
    }




}
