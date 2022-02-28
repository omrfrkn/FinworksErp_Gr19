@login
Feature: FinworksErp Login Feature

  Background:
    Given the user is on the login page

  Scenario Outline: Login Function With Valid Credentials
    When the user logged in with "<email>" and "<password>"
    Then the user should see the title "#Inbox - Odoo"
    And the user should see own username as "<username>"
    Examples:
      | username            | email                      | password         |
      | SalesManager16      | salesmanager16@info.com    | salesmanager     |
      | POSManager116       | posmanager116@info.com     | posmanager       |
      | InventoryManager116 | imm116@info.com            | inventorymanager |
      | ExpensesManager16   | expensesmanager16@info.com | expensesmanager  |
      | ManufacturingUser16 | manuf_user16@info.com      | manufuser        |

  Scenario Outline: the user should NOT be able to login with invalid credentials
    When the user logged in with "<username>" and "<password>"
    Then "Wrong login/password" error message should appear

    Examples:
      | username              | password   |
      | wrong                 | wrong      |
      | posmanager10@info.com | wrong      |
      | wrong                 | posmanager |

  Scenario Outline: the user should NOT be able to login with empty credentials
    When the user logged in with "<username>" and "<password>"
    Then "Please fill out this field." warning message should appear

    Examples:
      | username | password |
      |          | wrong    |
      | wrong    |          |
      |          |          |