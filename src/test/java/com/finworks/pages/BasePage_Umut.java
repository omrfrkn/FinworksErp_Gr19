package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage_Umut {

    public BasePage_Umut() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "oe_topbar_name")
    public WebElement userName;

    @FindBy(xpath = "//a[@data-menu='logout']")
    public WebElement logoutBtn;

    @FindBy(className = "o_searchview_input")
    public WebElement searchBox;

    public String getUserName() {
        return userName.getText();
    }

    public void navigateTo(String tab) {
        String locator = "//div[@class='navbar-collapse collapse']//a[contains(.,'" + tab + "')]";
        BrowserUtils.waitForClickablility(By.xpath(locator), 5);
        Driver.get().findElement(By.xpath(locator)).click();
    }

    public void logout() {
        userName.click();
        logoutBtn.click();
        BrowserUtils.waitFor(2);
    }

    public void search(String searchText){

        searchBox.sendKeys(searchText);
        searchBox.sendKeys(Keys.ENTER);

    }


}
