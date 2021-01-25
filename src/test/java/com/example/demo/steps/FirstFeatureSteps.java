package com.example.demo.steps;

import com.example.demo.utils.AbstractFeatureSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstFeatureSteps extends AbstractFeatureSteps {
    
    @Given("^I preparing GET request specification$")
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
}
