package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_Umut extends BasePage_Umut {

    @FindBy(id = "login")
    public WebElement emailInputBox;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement errorMessage;


    public void login() {

        emailInputBox.sendKeys(ConfigurationReader.get("posmanager_email"));
        passwordInputBox.sendKeys(ConfigurationReader.get("posmanager_password"));
        loginBtn.click();
        BrowserUtils.waitFor(4);
    }

    public void login(String email, String password) {
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        loginBtn.click();
        BrowserUtils.waitFor(4);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void verifyValidationMessage(String expectedMessage) {
        boolean isRequiredEmail = Boolean.parseBoolean(new LoginPage_Umut().emailInputBox.getAttribute("required"));
        boolean isRequiredPassword = Boolean.parseBoolean(new LoginPage_Umut().passwordInputBox.getAttribute("required"));

        boolean isEmptyEmail = new LoginPage_Umut().emailInputBox.getAttribute("value").isEmpty();
        boolean isEmptyPassword = new LoginPage_Umut().passwordInputBox.getAttribute("value").isEmpty();

        if (isRequiredPassword && isEmptyPassword) {
            Assert.assertEquals(expectedMessage, new LoginPage_Umut().passwordInputBox.getAttribute("validationMessage"));
        } else if (isRequiredEmail && isEmptyEmail) {
            Assert.assertEquals(expectedMessage, new LoginPage_Umut().emailInputBox.getAttribute("validationMessage"));

        }
    }


}
