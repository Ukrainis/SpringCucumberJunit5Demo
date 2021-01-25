package com.example.demo.helpers;

import static io.restassured.RestAssured.given;

import org.springframework.stereotype.Service;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Service
public class HttpClientHelpers {

    private Response response;

    public Response restGet(RequestSpecification rSpecification, String url) {
        response = given().spec(rSpecification).when().get(url);
        return response;
    }
}
