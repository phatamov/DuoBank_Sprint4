Feature: Test POST login in isolation
@api
  Scenario: Test POST login with Invalid password


    Given I add the following payload with invalid password
       |email                  | password |
       | duotech2021@gmail.com |          |
    When I send a new POST request to "/login.php" endpoint
    Then I should receive response status code # 401
    And The response body should contain error message "Please fill in all required fields"

