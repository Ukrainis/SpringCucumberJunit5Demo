package com.example.demo.specifications;

import org.springframework.stereotype.Service;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

@Service
public class ResponseSpecifications {

    ResponseSpecification rSpecification;

    public ResponseSpecification getDefaultResponseSpecification(int statusCodeExpected) {
        rSpecification = null;
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        rSpecification = builder.expectStatusCode(statusCodeExpected)
                    .expectContentType(ContentType.JSON)
                    .log(LogDetail.ALL)
                    .build();
        return rSpecification;
    }
}