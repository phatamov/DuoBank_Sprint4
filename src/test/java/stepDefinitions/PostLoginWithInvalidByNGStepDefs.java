package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;


public class PostLoginWithInvalidByNGStepDefs {

    static {
        baseURI = "http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/api";
    }

    RequestSpecification requestSpecification;
    Response response;
    Map<String, String> map;

    @Given("I add the following payload with invalid password")
    public void i_add_the_following_payload_with_invalid_password(List<Map<String, String>> dataTable) {
        map = dataTable.get(0);
        response = (Response) requestSpecification.given().log().all().
                body("{\n" +
                        "  \"email\": \"" + map.get("email") + "\",\n" +
                        "  \"password\": \"" + map.get("password") + "\",\n" + "}");
    }

    @When("I send a new POST request to {string} endpoint")
    public void i_send_a_new_post_request_to_endpoint(String endpoint) {
        requestSpecification.when().log().all().
                post(endpoint);
    }

    @Then("I should receive response status code # {int}")
    public void i_should_receive_response_status_code(Integer statusCode) {
        response.then().log().all().
                statusCode(statusCode);
    }

    @Then("The response body should contain error message {string}")
    public void the_response_body_should_contain_error_message(String message) {
        response.then().
                body("Invalid password", equalTo(message));
    }

}
