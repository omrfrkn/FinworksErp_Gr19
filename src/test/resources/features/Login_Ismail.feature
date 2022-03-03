@smoke
Feature: User should be able to login

  Background:
    Given The user is on the login page

  @valid
  Scenario Outline:User should be able to login with valid credentials
    When User enters valid "<userName>" and "<passWord>"
    Then User should see page title as "#Inbox - Odoo"

    Examples:
      | userName                   | passWord         |
      | posmanager116@info.com     | posmanager       |
      | salesmanager16@info.com    | salesmanager     |
      | imm116@info.com            | inventorymanager |
      | expensesmanager16@info.com | expensesmanager  |
      | manuf_user16@info.com      | manufuser        |

  @invalid
  Scenario Outline: User can NOT login with invalid credentials
    When The user enters the invalid "<userName>" or "<passWord>"
    Then The user should get error message "Wrong login/password"
    Examples:
      | userName                | passWord      |
      | posmanager10@info.com   | wrongPassword |
      | salesmanager16@info.com | wrongPassword |
      | wrongMail               | wrongPassword |
