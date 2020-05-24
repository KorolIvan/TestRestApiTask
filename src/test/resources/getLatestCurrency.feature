Feature: Is it latest currency present?
  User expected to get last currency rate.

  Scenario: Latest endpoint return status SUCCESS
    Given I perform to GET method for "/api/latest" currency rates
    When I sending request to get currency rates
    Then status is equals SUCCESS

  Scenario: Latest currency rate collecting took less than 5 sec
    Given I perform to GET method for "/api/latest" currency rates
    When I sending request to get currency rates
    Then data collecting took less than 5 seconds


  Scenario: Latest endpoint contain up to date data
    Given I perform to GET method for "/api/latest" currency rates
    When I sending request to get currency rates
    Then the date is equals to today date