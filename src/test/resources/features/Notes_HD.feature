
Feature: Notes Module_HD

  Background:
    Given the user is on the Notes page_HD

  Scenario: User creates a new note_HD
    When the user clicks on Create button_HD
    Then the note panel pops up on the page_HD
    When the user enters "Group 19" on the note panel_HD
    And the user clicks on Save button_HD
    Then the page title is "Group 19"_HD
    When the user clicks on Notes tab_HD
    Then the note "Group 19" appears on the page_HD


  Scenario: User edits an existing note_HD
    When the user clicks on an existing note_HD
    Then the note panel pops up on the page_HD
    When the user replaces the text with "EU7" on the note panel_HD
    And the user clicks on Save button_HD
    And the page title is "EU7"_HD
    And the user clicks on Notes tab_HD
    Then the note "EU7" appears on the page_HD


  Scenario: User finds note by using search function_HD
    When the user enters note name "EU7" in Search box_HD
    And the user hits enter_HD
    Then the note "EU7" appears on the page alone if it exists_HD


  Scenario: User deletes an existing note_HD
    When the user clicks on Dropdown Toggle button_HD
    And the user clicks on Delete option_HD
    Then a confirmation box pops up_HD
    When the user clicks on Ok button_HD
    Then the note is deleted_HD


   Scenario: User changes the note stage name_HD
    When the user clicks on Configuration dropdown on the right of the note stage name_HD
    Then the Edit Stage option appears in the dropdown menu_HD
    When the user clicks on Edit Stage option_HD
    Then the Edit Column panel pops up on the page_HD
    When the user clears the Stage Name box and enters "Weekend"_HD
    And the user clicks on Save button on Edit Column panel_HD
    Then the name of stage becomes "Weekend"_HD