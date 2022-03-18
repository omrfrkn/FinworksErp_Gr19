
Feature: As I registered user, I want to use Contacts Module functionalities so that I can manage and use contact information_HD

  Background:
    Given the user is logged in and on the Contacts page_HD

  Scenario: User creates a new contact_HD
    When the user clicks on Create button_HD
    Then contact information form pops up on the page_HD
    When the user enters "name1" as a contact name in the name box_HD
    And the user completes the form_HD
    And the user clicks on Save button_HD
    Then the page title contains "name1"_HD
    And "name1" appears on the control panel_HD

  Scenario: User finds contact by using search function_HD
    When the user enters contact name "name1" in Search box_HD
    And the user hits enter_HD
    Then the contact "name1" appears on the page if it exists_HD

  Scenario: User edits an existing contact_HD
    When the user enters contact name "name1" in Search box_HD
    And the user hits enter_HD
    Then the contact "name1" appears on the page if it exists_HD
    When the user clicks on contact "name1"_HD
    Then the contact form pops up on the page_HD
    When the user clicks on Edit button_HD
    And the user replaces the contact name with "name2"_HD
    And the user clicks on Save button_HD
    Then the page title contains "name2"_HD
    And "name2" appears on the control panel_HD

  Scenario: User deletes an existing contact_HD
    When the user enters contact name "name2" in Search box_HD
    And the user hits enter_HD
    Then the contact "name2" appears on the page if it exists_HD
    When the user clicks on contact "name2"_HD
    Then the contact form pops up on the page_HD
    When the user clicks on Action dropdown_HD
    And the user clicks on Delete option on dropdown_HD
    Then a confirmation box pops up_HD
    When the user clicks on Ok button on confirmation box_HD
    Then the contact "name2" is deleted_HD

  Scenario: User can not create a new contact without a name_HD
    When the user clicks on Create button_HD
    Then contact information form pops up on the page_HD
    When the user clicks on Save button_HD
    Then a prompt alert displays on the page with warning: "!The following fields are invalid: Name"_HD

  Scenario: User can not create a new contact with empty space_HD
    When the user clicks on Create button_HD
    Then contact information form pops up on the page_HD
    When the user hits space bar once when cursor is in the name_HD
    And the user clicks on Save button_HD
    Then a prompt alert displays on the page with warning: "!The following fields are invalid: Name"_HD