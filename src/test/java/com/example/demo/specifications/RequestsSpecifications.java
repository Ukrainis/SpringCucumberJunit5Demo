package com.example.demo.specifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.DemoApplicationProperties;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

@Service
public class RequestsSpecifications {
	
	@Autowired
	DemoApplicationProperties properties;
	RequestSpecification reqSpecification;
	RequestSpecBuilder builder;
	
	public RequestSpecification getDefaultRequestSpecification() {
		builder = getRequestSpecBuilderWithFilters();
		reqSpecification = builder.setBaseUri(properties.getBaseUrl())
		.setAccept(ContentType.JSON)
		.log(LogDetail.ALL)
		.build();
		return reqSpecification;
	}
	
	private RequestSpecBuilder getRequestSpecBuilderWithFilters() {
		builder = null;
		builder = new RequestSpecBuilder();
		builder.addFilter(new AllureRestAssured());
		return builder;
	}
}