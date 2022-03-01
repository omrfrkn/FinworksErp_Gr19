package com.finworks.step_definitions;
import com.finworks.pages.LoginPage_semih;
import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class login_stepDefs_semih {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        BrowserUtils.waitForPageToLoad(2);
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("The user enters salesmanager15@info.com and salesmanager")
    public void the_user_enters_salesmanager15_info_com_and_salesmanager() {

        String username = ConfigurationReader.get("salesmanager_email");
        String password = ConfigurationReader.get("salesmanager_password");
        BrowserUtils.waitForPageToLoad(2);

        LoginPage_semih loginPage = new LoginPage_semih();
        loginPage.login(username,password);
    }

    @When("The user enters posmanager10@info.com and posmanager")
    public void the_user_enters_posmanager10_info_com_and_posmanager(){

        String username = ConfigurationReader.get("posmanager_email");
        String password = ConfigurationReader.get("posmanager_password");
        BrowserUtils.waitForPageToLoad(2);

        LoginPage_semih loginPage = new LoginPage_semih();
        loginPage.login(username, password);
    }

    @When("The user enters imm10@info.com and inventorymanager")
    public void the_user_enters_imm10_info_com_and_inventorymanager(){

        String username = ConfigurationReader.get("inventorymanager_email");
        String password = ConfigurationReader.get("inventorymanager_password");
       BrowserUtils.waitForPageToLoad(2);

        LoginPage_semih loginPage = new LoginPage_semih();
        loginPage.login(username, password);
    }

    @When("The user enters expensesmanager10@info.com and expensesmanager")
    public void the_user_enters_expensesmanager10_info_com_and_expensesmanager(){

        String username = ConfigurationReader.get("expensesmanager_email");
        String password = ConfigurationReader.get("expensesmanager_password");
       BrowserUtils.waitForPageToLoad(2);

        LoginPage_semih loginPage = new LoginPage_semih();
        loginPage.login(username, password);
    }

    @When("The user enters manuf_user10@info.com and password")
    public void the_user_enters_manuf_user10_info_com_and_password(){

        String username = ConfigurationReader.get("manufuser_email");
        String password = ConfigurationReader.get("manufuser_password");
        BrowserUtils.waitForPageToLoad(2);
        LoginPage_semih loginPage = new LoginPage_semih();
        loginPage.login(username, password);
    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {

        String expectedTitle= "#Inbox - Odoo";
        String actualTitle= Driver.get().getTitle();
        BrowserUtils.waitForPageToLoad(2);
        Assert.assertEquals(expectedTitle,actualTitle);
    }





}
