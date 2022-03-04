package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage_tarik {
    public BasePage_tarik() {PageFactory.initElements(Driver.get(), this);}

    @FindBy(css = ".oe_topbar_name")
    public WebElement userMenu;

    public void navigateToModule (String moduleName){
        WebElement module=Driver.get().findElement(By.linkText(moduleName));
        module.click();
        BrowserUtils.waitFor(1);
    }

    public void clearExistingText (WebElement elementName, String newText) {

        elementName.clear();
        BrowserUtils.waitFor(1);
        elementName.sendKeys(newText);
    }
}
