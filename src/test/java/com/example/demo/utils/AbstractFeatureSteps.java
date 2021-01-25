package com.example.demo.utils;

import com.example.demo.DemoApplication;
import com.example.demo.SpringActiveProfileResolver;
import com.example.demo.helpers.HttpClientHelpers;
import com.example.demo.specifications.RequestsSpecifications;
import com.example.demo.specifications.ResponseSpecifications;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT,
classes = DemoApplication.class)
@ActiveProfiles(resolver = SpringActiveProfileResolver.class)
public class AbstractFeatureSteps {
    
	@Autowired
	protected RequestsSpecifications requestSpecifications;
	
	@Autowired
	protected ResponseSpecifications responseSpecifications;
	
	@Autowired
	protected HttpClientHelpers httpClient;
	
	protected RequestSpecification reqSpec;
	
	protected ResponseSpecification respSpec;
	
	protected Response response;
}
