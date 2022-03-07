@login
Feature: FinworksErp Login Feature

  Background:
    Given the user is on the login page_YB

  Scenario Outline: Login Function With Valid Credentials
    When the user logs in with "<email>" and "<password>"_YB
    Then the user should see the title "#Inbox - Odoo"_YB
    And the user should see own username as "<username>"_YB
    Examples:
      | username            | email                      | password         |
      | SalesManager16      | salesmanager16@info.com    | salesmanager     |
      | POSManager116       | posmanager116@info.com     | posmanager       |
      | InventoryManager116 | imm116@info.com            | inventorymanager |
      | ExpensesManager16   | expensesmanager16@info.com | expensesmanager  |
      | ManufacturingUser16 | manuf_user16@info.com      | manufuser        |

  Scenario Outline: the user should NOT be able to login with invalid credentials
    When the user logs in with "<username>" and "<password>"_YB
    Then "Wrong login/password" error message should appear_YB

    Examples:
      | username              | password   |
      | wrong                 | wrong      |
      | posmanager10@info.com | wrong      |
      | wrong                 | posmanager |

  Scenario Outline: the user should NOT be able to login with empty credentials
    When the user logs in with "<username>" and "<password>"_YB
    Then "Please fill out this field." warning message should appear_YB

    Examples:
      | username | password |
      |          | wrong    |
      | wrong    |          |
      |          |          |