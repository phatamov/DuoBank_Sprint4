Feature: Get Mortgage with Invalid token endpoint
  @api
  Scenario: Test GetMortgage with Invalid token

    When I send a Get request with invalid token to "/getmortagage.php" endpoint
    Then The status code should be 401
    And  The Body should contain the following message "Unauthorized"