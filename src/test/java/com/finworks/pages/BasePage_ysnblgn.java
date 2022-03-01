package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ybilgin
 * @project FinworksErp
 */


public abstract class BasePage_ysnblgn {

    public BasePage_ysnblgn() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "oe_topbar_name")
    public WebElement username;

    @FindBy(linkText = "Log out")
    public WebElement logout;

    public String getUserName(){

        return username.getText();
    }

    public void navigateTo(String tab){
        String locator = "//div[@class='navbar-collapse collapse']//a[contains(.,'"+ tab +"')]";
        BrowserUtils.waitForClickablility(By.xpath(locator),5);
        Driver.get().findElement(By.xpath(locator)).click();
    }

    public void logout(){
        BrowserUtils.clickWithJS(logout);
    }



}
