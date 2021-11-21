package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.ConfigReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITestsGA {

    static{

        baseURI = "http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/api";

    }

    RequestSpecification requestSpecification;
    Response response;
    String api_user = ConfigReader.getProperty("api_user");
    String api_password = ConfigReader.getProperty("api_password");

    String api_user1 = ConfigReader.getProperty("api_user1");
    String api_password1 = ConfigReader.getProperty("api_password1");
    String jwtToken;
    int validId;


    @Given("I add the header {string} {string}")
    public void iAddTheHeader(String string, String string2) {
        requestSpecification = given().
                header("Authorization", jwtToken);


    }
    @When("I send a GET request to {string} endpoint")
    public void iSendAGETRequestToEndpoint(String endpoint) {
        response = requestSpecification.when().log().all().
                get(endpoint);


    }


    @Then("The response status code should be {int}")
    public void theResponseStatusCodeShouldBe(Integer int1) {

        response.then().log().all().
                statusCode(200);

    }


    @Given("I am authorized at endpoint {string}")
    public void iAmAuthorizedAtEndpoint(String endpoint) {

        response = given().log().all().header("Content-Type", "application/json").body("{\n" +
                " \"email\": \"" + api_user + "\",\n" +
                "\"password\": \"" + api_password + "\" \n" +
                "}").post(endpoint);

        String jsonString = response.asString();
        jwtToken = JsonPath.from(jsonString).get("token");


        System.out.println("TOKEN   " + jwtToken);
        System.out.println("JSONSTRING" + jsonString);


    }



    @Given("Valid id number at the endpoint {string}")
    public void validIdNumber(String endpoint) {
        response = given().log().all().header("Authorization", jwtToken).get(endpoint);
        String validId1 = response.path("mortagage_applications[0].id");
        validId  = Integer.parseInt(validId1);



    }


    @When("I send a POST request to {string} endpoint using a valid id number")
    public void iSendAPOSTRequestToEndpointUsingAValidIdNumber(String endpoint) {
        response = given().log().all().header("Authorization", jwtToken).body(
                "{  \"id\" : "+ validId +" }").post(endpoint);
    }



    @Given("I am authorized as a user at endpoint {string}")
    public void iAmAuthorizedAsAUserAtEndpoint(String endpoint) {
        response = given().log().all().header("Content-Type", "application/json").body("{\n" +
                " \"email\": \"" + api_user1 + "\",\n" +
                "\"password\": \"" + api_password1 + "\" \n" +
                "}").post(endpoint);

        String jsonString = response.asString();
        System.out.println("RESPONSETOSTRING " + response.toString());
        jwtToken = JsonPath.from(jsonString).get("token");

    }

    @When("I send a GET request to {string} endpoint with user token")
    public void iSendAGETRequestToEndpointWithUserToken(String endpoint) {
        response = given().log().all().header("Authorization", jwtToken).get(endpoint);


    }

    @Then("The id should be {int}")
    public void theIdShouldBe(Integer id) {

        String mortgage_id = response.path("mortagage_applications[0].id");
        System.out.println("MORTGAGE" + mortgage_id);
        Integer mortgage_id1 = Integer.parseInt(mortgage_id);

        Assert.assertEquals(id, mortgage_id1);


    }


    @Then("The name should be {string}")
    public void theNameShouldBe(String name) {
        String mortgage_name = response.path("mortagage_applications[0].b_firstName");
        Assert.assertEquals(name, mortgage_name);

    }




    @When("I send a GET request to {string} endpoint without a valid token")
    public void iSendAGETRequestToEndpointWithoutAValidToken(String endpoint) {
        response = given().log().all().get(endpoint);

    }
    @Then("The body status should be {int}")
    public void theBodyStatusShouldBe(Integer int1) {
        response.then().log().all().
                body("status", equalTo(401));


    }
    @Then("The body message should be {string}")
    public void theBodyMessageShouldBe(String message) {
        response.then().log().all().
                body("message", is("Unauthorized"));
    }


    @When("I send a POST request to {string} endpoint")
    public void iSendAPOSTRequestToEndpoint(String endpoint) {

        String bodyContains = "{\n" + " \"id\": \"33335\"" + "}";
        System.out.println( " BODYCONTAINS" + bodyContains);

        response = given().log().all().header("Authorization", jwtToken).body(bodyContains).post(endpoint);


    }



    @Then("The body should contain {string}")
    public void theBodyShouldContain(String string) {
        response.then().log().all().
                body(containsString("single_application"));


    }







}
