Feature: Getmortgage with Valid Credentials endpoint positive test
  @api
  Scenario: Test Get GetMortgage with valid credentials

    When I send a new Get request to "/getmortagage.php" endpoint
    Then The response code should be 200
    And The response body should contain the following message: "success: 1, status: 200, mortagage_applications"