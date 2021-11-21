package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetMortgageWithValidStepDefsByNG {

    static {
        baseURI = "http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/api";
    }

    RequestSpecification requestSpecification;
    Response response;


    @When("I send a new Get request to {string} endpoint")
    public void i_send_a_new_get_request_to_endpoint(String endpoint) {
        response = requestSpecification.when().log().all().
                get(endpoint);
    }
    @Then("The response code should be {int}")
    public void the_response_code_should_be(Integer statusCode) {
        response.then().log().all().
                statusCode(statusCode);
    }


    @Then("The response body should contain the following message: {string}")
    public void the_response_body_should_contain_the_following_message(String message) {
       response.then().
               body("success: 1, status: 200, mortagage_applications", equalTo(message));
    }


}


