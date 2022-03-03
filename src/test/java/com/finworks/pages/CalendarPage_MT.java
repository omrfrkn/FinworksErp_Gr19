package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage_MT extends BasePage_MT {
    public CalendarPage_MT() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//ol/li")
    public WebElement actualView;
    @FindBy(xpath = "//button[contains(text(),'Today')]")
    public WebElement pageViewOption;
    @FindBy(xpath = "//span[@class='fa fa-arrow-right']")
    public WebElement rightArrow;
    @FindBy(xpath = "//span[@class='fa fa-arrow-left']")
    public WebElement leftArrow;

    public void navigateToView(String view) {
        String viewLocator = "//button[contains(text(),'"+view+"')]";

        try {
            BrowserUtils.waitForClickablility(By.xpath(viewLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(viewLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(viewLocator), 5);
        }

    }

}
