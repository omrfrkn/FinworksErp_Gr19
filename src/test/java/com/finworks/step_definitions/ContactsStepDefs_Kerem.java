package com.finworks.step_definitions;

import com.finworks.pages.ContactsPage_Kerem;
import com.finworks.pages.LoginPage_Kerem;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsStepDefs_Kerem {
    WebDriverWait wait = new WebDriverWait(Driver.get(),10);
    ContactsPage_Kerem ctpage = new ContactsPage_Kerem();
    Actions actions = new Actions(Driver.get());

    @Given("the user is on the {string} page_KT")
    public void the_user_is_on_the_page_KT(String tab) {
        new LoginPage_Kerem().login(ConfigurationReader.get("posmanager_email"), ConfigurationReader.get("posmanager_password"));
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        ctpage.navigateTo(tab);
        String expectedTitle = "Contacts - Odoo";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("the user writes Contact's name as {string}_KT")
    public void the_user_writes_Contact_s_name_as__KT(String contactsName) {
        ctpage.createButton.click();
        BrowserUtils.waitForPageToLoad(10);
        ctpage.nameBox.sendKeys(contactsName);
    }

    @When("the user writes first address as a {string}_KT")
    public void the_user_writes_first_address_as_a__KT(String address) {
        ctpage.addressBox.sendKeys(address);
    }

    @When("the user writes city as {string}_KT")
    public void the_user_writes_city_as__KT(String city) {
        ctpage.cityBox.sendKeys(city);
    }

    @When("the user clicks the dropdown button for country_KT")
    public void the_user_clicks_the_dropdown_button_for_country_KT() {
        ctpage.dropDownForCountry.click();
    }

    @When("the user select country {string}_KT")
    public void the_user_select_country__KT(String country) {
        BrowserUtils.waitForPageToLoad(10);
        ctpage.dropDownForCountry.click();
        Driver.get().findElement(By.xpath("//a[.='Search More...']")).click();
        BrowserUtils.waitForPageToLoad(7);
        ctpage.searchBoxforCountry.sendKeys(country+ Keys.ENTER);
        WebElement searchCountry = Driver.get().findElement(By.xpath("//td[.='"+country+"']"));
        wait.until(ExpectedConditions.elementToBeClickable(searchCountry));
        searchCountry.click();
        BrowserUtils.waitFor(3);
    }

    @Then("the user sees the {string} selected in the options_KT")
    public void the_user_sees_the_selected_in_the_options_KT(String country) {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertEquals(ctpage.dropDownForCountry.getAttribute("value"),country);
    }

    @Then("the {string} contact visible for existing_KT")
    public void the_contact_visible_for_existing_KT(String contact) {
        String actualVisible = Driver.get().findElement(By.xpath("//span[.='"+contact+"']")).getText();
        Assert.assertEquals(contact,actualVisible);
    }

    @When("the user clicks existing contacts {string}_KT")
    public void the_user_clicks_existing_contacts__KT(String contact) {
        Driver.get().findElement(By.xpath("//span[.='"+contact+"']")).click();
    }

    @When("the user clicks the edit button_KT")
    public void the_user_clicks_the_edit_button_KT() {
        BrowserUtils.waitForClickablility(ctpage.editButton,10);
        ctpage.editButton.click();
    }

    @When("the user changes Contact's name as {string}_KT")
    public void the_user_changes_Contact_s_name_as__KT(String newContactName) {
        ctpage.nameBox.clear();
        ctpage.nameBox.sendKeys(newContactName);
    }


    @When("the user changes to first address as a {string}_KT")
    public void the_user_changes_to_first_address_as_a__KT(String newAddress) {
        BrowserUtils.waitForPageToLoad(5);
        ctpage.addressBox.clear();
        ctpage.addressBox.sendKeys(newAddress);
    }

    @When("the user changes city as {string}_KT")
    public void the_user_changes_city_as__KT(String newCity) {
        ctpage.cityBox.clear();
        ctpage.cityBox.sendKeys(newCity);
    }

    @When("the user changes country {string}_KT")
    public void the_user_changes_country__KT(String newCountry) {
        BrowserUtils.waitForPageToLoad(10);
        ctpage.dropDownForCountry.click();
        Driver.get().findElement(By.xpath("//a[.='Search More...']")).click();
        BrowserUtils.waitForPageToLoad(7);
        ctpage.searchBoxforCountry.sendKeys(newCountry+ Keys.ENTER);
        WebElement searchCountry = Driver.get().findElement(By.xpath("//td[.='" + newCountry + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(searchCountry));
        searchCountry.click();
        BrowserUtils.waitFor(3);
    }

    @When("the user clicks the Action and {string} button_KT")
    public void the_user_clicks_the_Action_and_button_KT(String deleteOption) {
            ctpage.action.click();
            Driver.get().findElement(By.linkText(deleteOption)).click();
    }

    @Then("the contact is deleted {string}_KT")
    public void the_contact_is_deleted__KT(String deletedContact) {
        ctpage.navigateTo("Contacts");
        BrowserUtils.waitForPageToLoad(5);
        ctpage.searchButton.sendKeys(deletedContact+Keys.ENTER);
        BrowserUtils.waitForVisibility(ctpage.afterDeleteMessage,10);
        Assert.assertTrue(ctpage.afterDeleteMessage.isDisplayed());
    }



}
