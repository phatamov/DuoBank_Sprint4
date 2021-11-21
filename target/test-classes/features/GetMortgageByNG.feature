Feature: Getmortgage endpoint positive test
@api
  Scenario: Test GET GetMortgage in isolation

    When I send a GET request to "/getmortagage.php" endpoint
    Then The response status code should be 200
    And The response body should contain the following tabs : "id","b_firstName", "b_lastName", "b_middleName" , "total_loan_amount";

