Feature: Login functionality
  As a user
  I want to login to the booking.com
  So that I can total flights for the given filters

  @Regression
  Scenario: To search total flight
    Given User is on the flight booking page
    When User clicks one-way button
    And User enters leaving from location
    And User enters going to location
    And User Enters travel date
    And User adds travelers
    And User clicks search button
    Then User gets total flights