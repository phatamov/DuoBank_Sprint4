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

public class GetMortgageStepDefsByNG {

    static{
        baseURI = "http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/api";
    }

RequestSpecification requestSpecification;
Response response;


    @When("I send a GET request to {string} endpoint")
    public void i_send_a_get_request_to_endpoint(String endpoint) {
        response = requestSpecification.when().log().all().
                get(endpoint);

    }
    @Then("The response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        response.then().log().all().
                statusCode(statusCode);
    }
    @Then("The response body should contain the following tabs : {string},{string}, {string}, {string} , {string};")
    public void the_response_body_should_contain_the_following_tabs(String id, String b_firstName , String b_lastName, String b_middleName, String total_loan_amount) {
      response.then().
              body("id", equalTo(id)).
              body("b_firstName",equalTo(b_firstName)).
              body("b_lastName", equalTo(b_lastName)).
              body("b_middleName", equalTo(b_middleName)).
              body("total_loan_amount", equalTo(total_loan_amount));

    }

}

