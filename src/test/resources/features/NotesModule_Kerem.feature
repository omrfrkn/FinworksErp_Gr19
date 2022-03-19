@notes
Feature: FinWorksErp NotesModule_KT

  Background:
    Given the user is on the "Notes" Page_KT

  Scenario: User should be able to create new note_KT
    When the user clicks the Create button_KT
    And the user writes "EU7 Mission Completed" on the note area_KT
    When the user clicks the Save button_KT
    And the title is "EU7 Mission Completed"_KT
    When the user clicks the "Notes" tab_KT
    Then the "EU7 Mission Completed" note visible_KT


  Scenario: User should be able to edit existing note_KT
    When the user clicks existing note "EU7 Mission Completed"_KT
    And user changes the note to "EU8 Started"_KT
    When the user clicks the Save button_KT
    And the title is "EU8 Started"_KT
    When the user clicks the "Notes" tab_KT
    Then the "EU8 Started" note visible_KT


  Scenario: User should be able to find notes by using search function_KT
    When the user clicks the Search button_KT
    And the user writes "EU8 Started" in the search button_KT
    Then the "EU8 Started" note visible for existing_KT


  Scenario Outline: User should be able to change the note stage name according to his/her needs.
    When the user clicks the "EU8 Started" note_KT
    And the user selects new type "<Column>"_KT
    When the user clicks the Save button_KT
    When the user clicks the "Notes" tab_KT
    Then the user sees the "EU8 Started" under the "<Column>" tab_KT
    Examples:
      | Column    |
      | Today     |
      | This Week |
      | Later     |
      | Weekend   |
      | New       |


  Scenario: User should be able to delete an existing note_KT
    When the user goes the existing note "EU8 Started"_KT
    And the user clicks the Dropdown and Delete button_KT
    Then Confirmation pop-up_KT
    When the user clicks OK button_KT
    Then the note is deleted "EU8 Started"_KT







