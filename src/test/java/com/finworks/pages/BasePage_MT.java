package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage_MT {
    public BasePage_MT() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToModule(String tab) {
        String tabLocator = "//span[contains(text(),'"+tab+"')]";

        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }

    }
}
