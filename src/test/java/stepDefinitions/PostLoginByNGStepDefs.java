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


public class PostLoginByNGStepDefs {

    static{
        baseURI = "http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/api";
    }

    RequestSpecification requestSpecification;
    Response response;
    Map<String, String> map;

    @Given("I add the following payload")
    public void i_add_the_following_payload(List<Map<String, String>> dataTable) {
        map = dataTable.get(0);
        response = (Response) requestSpecification.given().log().all().
                body("{\n" +
                        "  \"email\": \"" + map.get("email") + "\",\n" +
                        "  \"password\": \"" + map.get("password") + "\",\n" + "}");
    }


    @When("I send a POST request to {string} endpoint")
    public void i_send_a_post_request_to_endpoint(String endpoint) {
        requestSpecification.when().log().all().
                post(endpoint);

    }
    @Then("I should receive response status code {int}")
    public void i_should_receive_response_status_code(Integer statusCode) {
        response.then().log().all().
                statusCode(statusCode);

    }
    @Then("The response body should contain the following message {string} and valid token for authorization")
    public void the_response_body_should_contain_the_following_message_and_valid_token_for_authorization(String message) {
        response.then().
                body("You have successfully logged in", equalTo(message));
    }


}
