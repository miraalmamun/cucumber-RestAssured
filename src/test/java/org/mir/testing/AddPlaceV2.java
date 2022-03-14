package org.mir.testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import jsonpayload.PayLoadFactory;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddPlaceV2 {
	
	//https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123
	
	@Test
	public void addplace()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(PayLoadFactory.addPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("status", equalTo("OK"))
		.header("Server", "Apache/2.4.18 (Ubuntu)");
	}

}
