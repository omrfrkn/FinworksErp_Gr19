Feature: User should be able to login_MT

  Background:
    Given the user is on the login page_MT
    When the user enters the valid "posmanager" information_MT

  Scenario: The user could use calendar functionality properly_MT

    When The user navigates to "Calendar" page_MT
    Then the user should able to get title "Meetings - Odoo"_MT
    And verify that user get "Weekly" calendar view_MT

  Scenario: User can create shortly an event on the calendar

    When User click on the desired days desired hour_MT
    And user can enter summary for the event_MT
    And user click on "create" button_MT
    Then verify that a meeting should saved on calendar_MT

  Scenario:User can create event on the calendar

    When User click on the desired days desired hour_MT
    And user can enter summary for the event_MT
    And user click on "edit" button_MT
    Then verify that user should reach pup up event craete page_MT

  Scenario Outline: User could fill/edit the following options
    When user edits "<Meeting Subject>", "<Reminders>", "<Duration>","<Location>" and "<Description>"
    And user selects "<Starting at>", "<Tags>","<Reminders>" and "<Attendees>"
    And user could select "Option" tag_MT
    And User clicks on save button
    Then verify that a meeting should saved on calendar_MT
    But verify that user should return calendar base page without save


  Scenario: Under meeting crating pup-up page in the Options page user could edit followings);
  -
    *   Recurrent (Check box)
    *   Privacy  (Select option)
    *   Show Time as (Select option)

  @wip
  Scenario Outline: User could navigate between calendar view options
    When The user navigates to "Calendar" page_MT
    And the user click on "<navigateOption>"
    Then verify user land on related "<navigateOption>" page
    Examples:
      | navigateOption |
      | Day            |
      | Week           |
      | Month          |
      | Today          |

    Scenario: User could navigate related calendar page forward-backward
      When the user click on "navigateOption" arrow
      Then verify that user should navigate to"right" on the  related view page


  Scenario: User could search meeting via search bar
    When user search "meeting" on search bar
    Then verify that user could reach meetings detailes
