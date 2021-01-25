package com.example.demo.specifications;

import com.example.demo.configuration.DemoApplicationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

@Service
public class RequestSpecifications {
    
    @Autowired
    DemoApplicationProperties demoApplicationProperties;

    public RequestSpecification getBaseSpecification() {
        RequestSpecBuilder rSpecBuilder = getBuilderWithFilters();
        RequestSpecification rSpec = rSpecBuilder.setBaseUri(demoApplicationProperties.getBaseUrl())
        .log(LogDetail.ALL)
        .build();
        return rSpec;
    }

    private RequestSpecBuilder getBuilderWithFilters() {
        RequestSpecBuilder rSpecBuilder = new RequestSpecBuilder();
        rSpecBuilder.addFilter(new AllureRestAssured());
        return rSpecBuilder;
    }
}
