@note
Feature: Notes Functionality

  Background:
    Given the user logged in_US
    And the user navigate to "Notes" page_US
    Then the user should see page title as "Notes - Odoo"_US


   @create
  Scenario: The user can create new note
    When the user click "Create" button_US
    Then the user should see page title as "New - Odoo"_US
    When the user enters text as "create test" in the text box_US
    And the user selects status as "This Week"_US
    When the user click "Save" button_US
    Then the user should see page title as "create test - Odoo"_US

   @edit
  Scenario: The user can edit an existing note
    Given the user should create note "edit test" in the "Later" colum_US
    When the user click existing note as "edit test"_US
    Then the user should see page title as "edit test - Odoo"_US
    And the user should see sub page title as "Notes" - "edit test"_US
    When the user enters text as " edited" in the text box_US
    And the user click "Save" button_US
    Then the user should see page title as "edit test edited - Odoo"_US
    And the user should see sub page title as "Notes" - "edit test edited"_US

   @delete
  Scenario:The user can delete an existing note
    Given the user should create note "delete test" in the "Later" colum_US
    When the user click "delete test" note "three dot" button_US
    And the user click "delete test" note "delete" button_US
    Then the user should see popup confirmation page_US
    When the user click "Ok" button_US
    Then the system deletes existing note "delete test" from "Later" board_US

   @drag
  Scenario: The user can change notes stage by dragging
     Given the user should create note "dragAndDrop test" in the "Notes" colum_US
    When the user drag and drop existing note "dragAndDrop test" from "Notes" to "Today" Column_US
    Then the user should see note "dragAndDrop test" in "Today" Column_US

   @search
  Scenario: The user can finds notes by using search box
    When the user searches text as "test" by search box_US
    Then the user should see notes containing entered text "test"_US


