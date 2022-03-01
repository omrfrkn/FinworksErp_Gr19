
Feature: FinWorksErp Login Feature

  Background:
    Given the user is on the login page_KT

  Scenario Outline: The user should be able to login with valid credentials_KT

    When the user enters "<email>" and "<password>"_KT
    Then the title contains "#Inbox - Odoo"_KT
    And the user should be able to see own name as a "<username>"_KT
    Examples:
      | username            | email                      | password         |
      | SalesManager16      | salesmanager16@info.com    | salesmanager     |
      | POSManager116       | posmanager116@info.com     | posmanager       |
      | InventoryManager116 | imm116@info.com            | inventorymanager |
      | ExpensesManager16   | expensesmanager16@info.com | expensesmanager  |
      | ManufacturingUser16 | manuf_user16@info.com      | manufuser        |



  Scenario Outline: The users should not be able to login with invalid credentials_KT

    When user enters invalid "<email>" and "<password>"_KT
    Then user should be able too see error message as "Wrong login/password"_KT
    Examples:
      | email         |  | password |
      | jamal10@info.com |  | jamal10  |
      | oscar10@info.com |  | oscar    |


  Scenario Outline: The users should not be able to login with empty credentials_KT
    When the user enters missing "<email>" and "<password>"_KT
    Then user should be able to see warning message as "Please fill out this field."_KT

    Examples:
      | email              |  | password   |
      | posmanager10@info.com |  |            |
      |                       |  | posmanager |


  Scenario: Reset Password Button_KT
    When the user clicks the reset password button_KT
    Then the title contains "Reset password | Best solution for startups"_KT

  Scenario: TopTitle_KT
    Then the top title contains "Best solution for startups"_KT




