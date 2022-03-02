@login
Feature:Login functionality

  Scenario Outline: Login with valid credentials
    Given the user is on the login page_sb
    When The user enters "<email>" and "<password>"_sb
    Then the user should be able to login_sb
    Examples:
      | email                      | password         |
      | salesmanager15@info.com    | salesmanager     |
      | posmanager10@info.com      | posmanager       |
      | imm10@info.com             | inventorymanager |
      | expensesmanager10@info.com | expensesmanager  |
      | manuf_user10@info.com      | manufuser        |


  Scenario Outline: Login with invalid credentials
    Given the user is on the login page_sb
    When The user enters "<email>" and "<password>"_sb
    Then the user should see error message_sb
    Examples:
      | email                      | password         |
      | salesmanager15@info.com    | salesman         |
      | posmanager10@info.com      | posman           |
      | imm10@info.com             | inven            |
      | expensesmanager10          | expensesman      |
