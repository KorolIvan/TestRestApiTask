Feature: Getting currency data for past date
  As a user I should be able to get currency data from past date

  Scenario: Get currency request return the data for expected date
    Given I perform to GET method for "/api/2010-01-12" currency rates
    Given I sending request to get currency rates
    Then the date is equals to "2010-01-12" date

  Scenario: Verify that user will receive last currency rate when sent request with future date
    Given I perform to GET method for "/api/2022-01-12" currency rates
    When I sending request to get currency rates
    Then the date is equals to today date