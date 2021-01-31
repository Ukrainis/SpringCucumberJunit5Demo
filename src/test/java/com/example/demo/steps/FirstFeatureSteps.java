package com.example.demo.steps;

import com.example.demo.utils.AbstractFeatureSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

public class FirstFeatureSteps extends AbstractFeatureSteps {

    String userName;
    
    @Given("^I preparing GET, DELETE request specification$")
    public void makeRequestSpecStep() {
        reqSpec = requestSpecifications.getDefaultRequestSpecification();
    }

    @When("^I make GET request to (.*) endpoint$")
    public void makeGetRequest(String endpoint) {
        response = httpClient.restGet(reqSpec, endpoint);
    }

    @Then("^I should see (.*) response code with json body$")
    public void responseCodeShouldBeWithJson(int expectStatusCode) {
        response.then().spec(responseSpecifications.getDefaultResponseSpecification(expectStatusCode));
    }

    @Then("^I should see (.*) response code without json body$")
    public void responseCodeShouldBeWithoutJson(int expectStatusCode) {
        response.then().statusCode(expectStatusCode);
    }

    @When("^I am taking username using (.*) json path$")
    public void takingUserNameByJsonPath(String jsonPath) {
        userName = response.jsonPath().getString(jsonPath);
    }

    @When("^I make DELETE request to remove previously found user$")
    public void removingUserUsingUserName() {
        response = httpClient.restDelete(reqSpec, "/user/" + userName + "/delete");
    }
}
