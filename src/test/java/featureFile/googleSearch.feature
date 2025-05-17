Feature: automation task
@test
  Scenario: User search for Mercedes A Class in google
    Given User opens google search
    When User search for Mercedes A Class
    Then Validate User can see engine specifications or mentions horsepower for the Mercedes A Class