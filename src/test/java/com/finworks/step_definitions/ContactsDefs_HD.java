package com.finworks.step_definitions;

import com.finworks.pages.ContactsPage_HD;
import com.finworks.utilities.BrowserUtils;
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

import java.util.List;

public class ContactsDefs_HD {

    ContactsPage_HD contactsPageHd = new ContactsPage_HD();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
    Actions actions = new Actions(Driver.get());
    int countExpectedName = 0;


    @Given("the user is logged in and on the Contacts page_HD")
    public void the_user_is_logged_in_and_on_the_Contacts_page_HD() {
        contactsPageHd.navigateToContactsPage();
    }

    @Then("contact information form pops up on the page_HD")
    public void contact_information_form_pops_up_on_the_page_HD() {
        Assert.assertTrue("Contact Info Form pops up", contactsPageHd.contactInformationForm.isDisplayed());
    }

    @When("the user enters {string} as a contact name in the name box_HD")
    public void the_user_enters_as_a_contact_name_in_the_name_box_HD(String contactName) {
        contactsPageHd.nameBox.sendKeys(contactName);
    }

    @When("the user completes the form_HD")
    public void the_user_completes_the_form_HD() {
        contactsPageHd.streetBox.sendKeys("Uluyol");
        contactsPageHd.cityBox.sendKeys("Bursa");
        contactsPageHd.countryDropdown.sendKeys("Turkey");

        contactsPageHd.tagsDropdown.click();
        BrowserUtils.waitFor(1);
        contactsPageHd.tagsDropdown.sendKeys("Retailer");
        BrowserUtils.waitFor(1);
        contactsPageHd.tagsDropdown.sendKeys(Keys.ENTER);

        contactsPageHd.mobileBox.sendKeys("555-1234567");
        contactsPageHd.emailBox.sendKeys("huseyin@company.com");
    }

    @Then("the page title contains {string}_HD")
    public void the_page_title_contains__HD(String contactName) {
        wait.until(ExpectedConditions.titleIs(contactName+" - Odoo"));
        String actualTitle = Driver.get().getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals("Titles should match", contactName+" - Odoo", actualTitle);
    }

    @Then("{string} appears on the control panel_HD")
    public void appears_on_the_control_panel_HD(String contactName) {
        String actualText = contactsPageHd.contactNameControlPanel.getText();
        System.out.println(actualText);
        Assert.assertEquals("Text should match", contactName, actualText);
    }

    @When("the user enters contact name {string} in Search box_HD")
    public void the_user_enters_contact_name_in_Search_box_HD(String contactName) {
        wait.until(ExpectedConditions.titleIs("Contacts - Odoo"));
        contactsPageHd.searchBox.sendKeys(contactName + Keys.TAB);
    }

    @Then("the contact {string} appears on the page if it exists_HD")
    public void the_contact_appears_on_the_page_if_it_exists_HD(String expectedContactName) {
        List<WebElement> actualContactsList = Driver.get().findElements(By.xpath("//*[@class='o_kanban_record_title oe_partner_heading']"));

        for (WebElement actualContact : actualContactsList) {
            if(actualContact.getText().equals(expectedContactName)){
                Assert.assertEquals(expectedContactName, actualContact.getText());
                System.out.println("TESTER NOTE: Contact name is found!");
                countExpectedName ++;
            }
        }

        if(countExpectedName==0) {
            System.out.println("TESTER WARNING: The contact name you are searching does NOT exist in contacts list!");
        }else if(countExpectedName>1){
            System.out.println("TESTER WARNING: Your search results more than one match!");
        }
    }

    @When("the user clicks on contact {string}_HD")
    public void the_user_clicks_on_contact__HD(String expectedContactName) {
        List<WebElement> actualContactsList = Driver.get().findElements(By.xpath("//*[@class='o_kanban_record_title oe_partner_heading']"));
        for (WebElement actualContact : actualContactsList) {
           if(actualContact.getText().equals(expectedContactName)){
               actualContact.click();
           }
        }
    }

    @Then("the contact form pops up on the page_HD")
    public void the_contact_form_pops_up_on_the_page_HD() {
        Assert.assertTrue("Contact form pops up",contactsPageHd.contactForm.isDisplayed());

    }

    @When("the user clicks on Edit button_HD")
    public void the_user_clicks_on_Edit_button_HD() {
        contactsPageHd.editButton.click();
    }

    @When("the user replaces the contact name with {string}_HD")
    public void the_user_replaces_the_contact_name_with__HD(String newContactName) {

        String text = contactsPageHd.contactNameControlPanel.getText();
        System.out.println("HD contact name: "+text);
        System.out.println("HD length: "+text.length());

        int lengthOfContactName = contactsPageHd.contactNameControlPanel.getText().length();
        contactsPageHd.nameBox.sendKeys(Keys.HOME);
        for (int i=0; i<lengthOfContactName; i++) {
            contactsPageHd.nameBox.sendKeys(Keys.DELETE);
        }
        contactsPageHd.nameBox.sendKeys(newContactName);
    }

    @When("the user clicks on Action dropdown_HD")
    public void the_user_clicks_on_Action_dropdown_HD() {
        wait.until(ExpectedConditions.elementToBeClickable(contactsPageHd.actionDropdown));
        contactsPageHd.actionDropdown.click();
    }

    @When("the user clicks on Delete option on dropdown_HD")
    public void the_user_clicks_on_Delete_option_on_dropdown_HD() {
        contactsPageHd.deleteOption.click();
    }

    @When("the user clicks on Ok button on confirmation box_HD")
    public void the_user_clicks_on_Ok_button_on_confirmation_box_HD() {
        contactsPageHd.deleteOK.click();
        BrowserUtils.waitFor(2);
        contactsPageHd.contactsTab.click();
        wait.until(ExpectedConditions.titleIs("Contacts - Odoo"));
    }

    @Then("the contact {string} is deleted_HD")
    public void the_contact_is_deleted_HD(String contactName) {

        Driver.get().navigate().refresh();
        contactsPageHd.searchBox.sendKeys(contactName + Keys.TAB);
        BrowserUtils.waitFor(3);

        int countExpectedName2=0;

        List<WebElement> actualContactsList = Driver.get().findElements(By.xpath("//*[@class='o_kanban_record_title oe_partner_heading']"));

        for (WebElement actualContact : actualContactsList) {
            if(actualContact.getText().equals(contactName)){
                countExpectedName2++;
                System.out.println("TESTER WARNING: After delete, there is a match with your query!");
                }
            }
            System.out.println("Matching queries BEFORE delete: " + countExpectedName);
            System.out.println("Matching queries AFTER delete: " + countExpectedName2);
            Assert.assertTrue("one difference means "+contactName+ " is DELETED", (countExpectedName - countExpectedName2 == 1));
    }


    @Then("a prompt alert displays on the page with warning: {string}_HD")
    public void a_prompt_alert_displays_on_the_page_with_warning__HD(String string) {
        WebElement alert = Driver.get().findElement(By.cssSelector(".o_notification_manager"));
        String alertText = alert.getText();
        System.out.println("HD Alert text: " + alertText);
        Assert.assertTrue("Prompt alert appears", alert.isDisplayed());
        System.out.println("HD Alert displayed "+alert.isDisplayed());
    }

    @When("the user hits space bar once when cursor is in the name_HD")
    public void the_user_hits_space_bar_once_when_cursor_is_in_the_name_HD() {
        contactsPageHd.nameBox.sendKeys(Keys.SPACE);
    }
}