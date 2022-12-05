package com.abc.automate;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
public class TestToDo {
@BeforeAll
	public void setup (){
		RestAssured.
				filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

		RestAssured.baseURI = "https://api.zippopotam.us";
	}

@Test
@DisplayName("Validate if San Francisco Exists")
	public void validateEndpoint(){

	String[] vectest= new String[1];
	vectest[0] = "[San Francisco]";

	given().
		when().
				get("/us/94105").
				then().
				statusCode(200).
				assertThat().body("places.'place name'", equalTo(vectest[0]));
	}

}
