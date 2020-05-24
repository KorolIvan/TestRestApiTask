Feature: Is there clear exceptions present
  As a user I expect to see the clear errors

  Scenario: Bad endpoint path returns 400 Bad Request status
    Given I perform to GET method for "/api" currency rates
    When I sending request to get currency rates
    Then status is equals Bad Request