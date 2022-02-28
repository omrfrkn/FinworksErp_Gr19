@hd
Feature: Authorized users should be able to login_HD

  Background:
    Given the user is on the login page_HD

  Scenario Outline: Login with valid credentials_HD
    When the user enters valid "<email>" and "<password>"_HD
    Then the user logins and the title is "#Inbox - Odoo"_HD
    And the username is "<username>"_HD
    Examples:
      | username            | email                      | password         |
      | SalesManager16      | salesmanager16@info.com    | salesmanager     |
      | POSManager116       | posmanager116@info.com     | posmanager       |
      | InventoryManager116 | imm116@info.com            | inventorymanager |
      | ExpensesManager16   | expensesmanager16@info.com | expensesmanager  |
      | ManufacturingUser16 | manuf_user16@info.com      | manufuser        |

  Scenario: Login with wrong email and valid password_HD
    When the user enters "posmanager116info.com" in Email box_HD
    And the user enters "posmanager" in Password box_HD
    And the user clicks on Log in button_HD
    Then the user should not be able to login_HD
    And "Wrong login/password" warning should appear below the Password box_HD

  Scenario: Login with valid email and without password_HD
    When the user enters "posmanager116@info.com" in Email box_HD
    And the user leaves Password box empty_HD
    And the user clicks on Log in button_HD
    Then the user should not be able to login_HD
    And "Please fill out this field." message should appear below the Password box_HD

  Scenario: Login without email and with valid password_HD
    When the user leaves Email box empty_HD
    And the user enters "posmanager" in Password box_HD
    And the user clicks on Log in button_HD
    Then the user should not be able to login_HD
    And "Please fill out this field." message should appear below the Email box_HD

  Scenario: Login without email and password_HD
    When the user leaves Email box empty_HD
    And the user leaves Password box empty_HD
    And the user clicks on Log in button_HD
    Then the user should not be able to login_HD
    And "Please fill out this field." message should appear below the Email box_HD