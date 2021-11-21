Feature: Test POST login request
@api
  Scenario: Test POST login in isolation


    Given I add the following payload
       |email                  | password |
       | duotech2021@gmail.com | duotechb5 |
    When I send a POST request to "/login.php" endpoint
    Then I should receive response status code 200
    And The response body should contain the following message "you have successfully logged in" and valid token for authorization

