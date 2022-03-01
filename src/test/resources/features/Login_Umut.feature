@login @smoke
Feature: Login Functionality

  Background:
    Given the user is on the login page_US

  @Valid
  Scenario Outline: User can login with valid credentials

    When the user enters valid email "<email>"_US
    And the user enters valid password "<password>"_US
    When the user click login button_US
    Then the user should see page title as "#Inbox - Odoo"_US
    And the user should see own username as "<username>"_US

    Examples:
      | username            | email                      | password         |
      | SalesManager10      | salesmanager10@info.com    | salesmanager     |
      | POSManager10        | posmanager10@info.com      | posmanager       |
      | InventoryManager10  | imm10@info.com             | inventorymanager |
      | ExpensesManager10   | expensesmanager10@info.com | expensesmanager  |
      | ManufacturingUser10 | manuf_user10@info.com      | manufuser        |

  @InValid
  Scenario Outline:User can NOT login with invalid credentials
    When the user logins with "<email>" and "<password>"_US
    Then system should shows "Wrong login/password" error message_US

    Examples:
      | email                 | password   |
      | Wemail                | posmanager |
      | posmanager10@info.com | Wpassword  |
      | Wemail                | Wpassword  |

  @emptyCred
  Scenario Outline: User can NOT login with empty fields
    When the user logins with "<email>" and "<password>"_US
    Then system should shows "Please fill out this field." validation message_US

    Examples:
      | email                 | password   |
      |                       | posmanager |
      | posmanager10@info.com |            |
      |                       |            |






