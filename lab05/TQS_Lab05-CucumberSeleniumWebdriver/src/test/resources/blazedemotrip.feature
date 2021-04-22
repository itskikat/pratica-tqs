Feature: Travel Agency

  Scenario: Search for flights
    When I navigate to "https://blazedemo.com/"
    And I select "Philadelphia" as my departure city
    And I select "Rome" as my destination city
    And I click "Find Flights"
    Then I should be presented with results including "Flights from Philadelphia to Rome:"

  Scenario: Purchase a flight
    When I navigate to "https://blazedemo.com/"
    And I want to fly from "Philadelphia" to "Rome"
    And I enter my personal information
    Then I should be presented with results, including the amount "555 USD"


