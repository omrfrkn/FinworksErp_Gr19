package com.finworks.pages;

import com.finworks.utilities.BrowserUtils;
import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage_semih extends BasePage {

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/button[1]/span")
    public WebElement okBtn;

    @FindBy(xpath = "//*[contains(text(),'Contacts')]")
    public WebElement contactBtn;

    @FindBy(xpath = "(//*[contains(text(),'Create')])[1]")
    public WebElement createBtn;

    @FindBy(css = "[name='name']")
    public WebElement nameField;

    @FindBy(css = "[name='street']")
    public WebElement streetField;

    @FindBy(css = "[name='city']")
    public WebElement cityField;

    @FindBy(id = "[id='o_field_input_34']")
    public WebElement stateField;

    @FindBy(id = "[id='o_field_input_35']")
    public WebElement zipCodeField;

    @FindBy(xpath = "//*[@id='o_field_input_39']")
    public WebElement jobPosition;

    @FindBy(id = "[id='o_field_input_40']")
    public WebElement phone;

    @FindBy(id = "[id='o_field_input_41']")
    public WebElement mobile;

    @FindBy(id = "[id='o_field_input_43']")
    public WebElement email;

    @FindBy(xpath = "(//*[contains(text(),'Save')])[1]")
    public WebElement saveBtn;

    @FindBy(xpath = "//*[@class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(xpath = "(//*[@class='oe_kanban_global_click o_res_partner_kanban o_kanban_record'])[22]")
    public WebElement user1;

    @FindBy(xpath = "//*[@class='btn btn-primary btn-sm o_form_button_edit']")
    public WebElement editBtn;



   public void login_as_a_point_of_sales_manager (){
       Driver.get().get(ConfigurationReader.get("url"));
       LoginPage_semih login = new LoginPage_semih();
       BrowserUtils.waitFor(1);
       login.userName.sendKeys("posmanager10@info.com");
       login.pword.sendKeys("posmanager");
       login.LoginBtn.click();

   }


}
