package com.finworks.step_definitions;

import com.finworks.pages.BasePage;
import com.finworks.pages.ContactPage_semih;
import com.finworks.pages.LoginPage_semih;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Concacts_stepDefs_semih extends BasePage {


    ContactPage_semih contacts = new ContactPage_semih();
    int countExpectedName = 0;

    @Given("the user should be logged in as a {string} with password {string}_sb")
    public void the_user_should_be_logged_in_as_a_with_password__sb(String email, String password) {

        contacts.login_as_a_point_of_sales_manager();
    }

    @Given("the user navigated to contact page_sb")
    public void the_user_navigated_to_contact_page_sb() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));

        contacts.contactBtn.click();
    }

    @When("the user clicks on create button_sb")
    public void the_user_clicks_on_create_button_sb() throws InterruptedException {
        //BrowserUtils.waitForClickablility(contacts.okBtn,2);
        //contacts.okBtn.click();
        BrowserUtils.waitForClickablility(contacts.createBtn, 5);
        //Thread.sleep(2000);
        contacts.createBtn.click();

    }

    @When("the user enter contact name as {string}_sb")
    public void the_user_enter_contact_name_as_sb(String user1) throws InterruptedException {
        // Thread.sleep(2000);
        BrowserUtils.waitForVisibility(contacts.nameField, 10);
        contacts.nameField.sendKeys(user1);
    }

    @When("the user enter contact info_sb")
    public void the_user_enter_contact_info_sb() {
        // contacts.streetField.sendKeys("Jason Ave" );
        //BrowserUtils.waitFor(2);
        // contacts.cityField.sendKeys("Newyork");
        //   BrowserUtils.waitFor(2);
        // contacts.stateField.sendKeys("Newyork");
        // BrowserUtils.waitFor(2);
        // contacts.zipCodeField.sendKeys("35900");
        //BrowserUtils.waitFor(3);
        //contacts.jobPosition.sendKeys("manager");
        //   BrowserUtils.waitFor(3);
        //contacts.phone.sendKeys("0761234567");
        //  BrowserUtils.waitFor(3);
        // contacts.mobile.sendKeys("0761234567");
        //  BrowserUtils.waitFor(3);
        //contacts.email.sendKeys("smh@gmail.com");

    }

    @When("the user click on save button_sb")
    public void the_user_click_on_save_button_sb() {

        BrowserUtils.waitForClickablility(contacts.saveBtn, 4);

        contacts.saveBtn.click();
    }

    @Then("the page title should have company name and contact name_sb")
    public void the_page_title_should_have_company_name_and_contact_name_sb() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

        wait.until(ExpectedConditions.titleIs("user1 - Odoo"));
        String expectedTitle = "user1 - Odoo";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @When("the user enter contact name as {string} in the search box_sb")
    public void the_user_enter_contact_name_as_in_the_search_box_sb(String string) {
        contacts.searchBox.sendKeys("user1");

    }

    @When("the user hits the enter_sb")
    public void the_user_hits_the_enter_sb() {
        contacts.searchBox.sendKeys(Keys.ENTER);
    }


    @Then("user1 should appear on the page_sb")
    public void user1_should_appear_on_the_page_sb() {
        List<WebElement> actualContactsList = Driver.get().findElements(By.xpath("//*[@class='o_kanban_record_title oe_partner_heading']"));
        String expectedUserName = "user1";
        for (WebElement actualContact : actualContactsList) {

            if (actualContact.getText().equals(expectedUserName)) {
                Assert.assertEquals(expectedUserName, actualContact.getText());

            }
        }

        if (countExpectedName == 0) {
            System.out.println("TESTER WARNING: The contact name you are searching does NOT exist in contacts list!");
        } else if (countExpectedName > 1) {
            System.out.println("TESTER WARNING: Your search results more than one match!");
        }
    }




    @When("the user clicks on contact_sb")
    public void the_user_clicks_on_contact_sb() {
        contacts.user1.click();
    }

    @When("the user clicks on edit button_sb")
    public void the_user_clicks_on_edit_button_sb() {
        contacts.editBtn.click();
    }
    @When("the user change the user name as {string}_sb")
    public void the_user_change_the_user_name_as__sb (String string){
        contacts.user1.sendKeys("string");

    }
    @When("the user hits the save button_sb")
    public void the_user_hits_the_save_button_sb () {
        contacts.saveBtn.click();

    }
    @Then("user name should be changed as {string}_sb")
    public void user_name_should_be_changed_as__sb (String string){
        String expectedUserName = "user2";
        String actualUserName = contacts.user1.getText();
        Assert.assertEquals(actualUserName,expectedUserName);


    }

    }






