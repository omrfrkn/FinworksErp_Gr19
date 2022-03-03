@login
Feature: User should be able to login_MT

  Background:
    Given the user is on the login page_MT


  Scenario: Login as a valid user_MT
    When the user enters the valid "posmanager" information_MT
    Then the user should able to get title "#Inbox - Odoo"_MT


  Scenario Outline:
    When the user should enter valid "<userName>" and valid "<passWord>"_MT
    Then the user should able to get title "#Inbox - Odoo"_MT
    And the user should able to get actual "<userType>"_MT
    Examples:
      | userName                   | passWord         | userType            |
      | salesmanager15@info.com    | salesmanager     | SalesManager15      |
      | posmanager10@info.com      | posmanager       | POSManager10        |
      | imm10@info.com             | inventorymanager | InventoryManager10  |
      | expensesmanager10@info.com | expensesmanager  | ExpensesManager10   |
      | manuf_user10@info.com      | manufuser        | ManufacturingUser10 |

  Scenario Outline:
    When the user enters the invalid_empty "<userName>" or "<passWord>"_MT
    Then the user should get error message "Wrong login/password"_MT
    Examples:
      | userName              | passWord   |
      | posmanager10@info.com | password   |
      | username              | posmanager |


  Scenario Outline:
    When the user enters the invalid_empty "<userName>" or "<passWord>"_MT
    Then the user should get caution message "Lütfen bu alanı doldurun."_MT
    Examples:
      | userName              | passWord   |
      | posmanager10@info.com |            |
      |                       | posmanager |
      |                       |            |

  Scenario: Reset Password FUNCTIONALITY_MT
    When the user clicks the reset password button_MT
    Then the user should able to get title "Reset password | Best solution for startups"_MT
