package com.finworks.pages;

import com.finworks.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ybilgin
 * @project FinworksErp
 */


public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    
}
