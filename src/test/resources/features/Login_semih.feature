@login
Feature:Login functionality

  Scenario Outline: Login with valid credentials
    Given the user is on the login page
    When The user enters <email> and <password>
    Then the user should be able to login
    Examples:
    |email                       | password        |
    |salesmanager15@info.com     |salesmanager     |
    |posmanager10@info.com       |posmanager       |
    |imm10@info.com              |inventorymanager |
    |expensesmanager10@info.com  |expensesmanager  |
    |manuf_user10@info.com       |manufuser        |