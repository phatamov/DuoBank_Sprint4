package stepDefinitions.ApiTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class EmploymentAndIncomeAPIStepDefs {
RequestSpecification requestSpecification;
    Response response;

    @Given("The base, URI is up and running")
public void the_base_uri_is_up_and_running() {

}
    @Then("I am at mortagagedetails.php API ENDPOINT")
public void i_am_at_mortagagedetails_php_api_endpoint() {
         requestSpecification = given ( ).header ( "Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9sb2NhbGhvc3RcL2xvYW5cL2FwaSIsImF1ZCI6Imh0dHA6XC9cL2xvY2FsaG9zdFwvbG9hblwvYXBpIiwiaWF0IjoxNjMxOTA3NjYyLCJleHAiOjE2MzE5MTEyNjIsImRhdGEiOnsidXNlcl9pZCI6IjM1NjYiLCJ0eXBlIjoiMiJ9fQ.95tFy7PNbBmGQATO2Ei5DDi5wzYF5H5IraJC61Ot2Yo" );


    }



    @When("I'm adding new  applicant information")
public void i_m_adding_new_applicant_information() {
 response = requestSpecification.when ( ).log ( ).all ( ).get ( "/mortagagedetails.php" );

}
    @Then("I'm  pulling new data back from the database tablet")
public void i_m_pulling_new_data_back_from_the_database_tablet() {
         response.then ( ).log ( ).all ( ).statusCode ( 200 );
          response.then ( ).log ( ).all ( ). body ( "id", Matchers.equalTo ( 4 ) );
}
    @Then("I'm verifying if the information is a match and stored in the correct order.")
public void i_m_verifying_if_the_information_is_a_match_and_stored_in_the_correct_order() {



}
}
