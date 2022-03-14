package org.mir.testing;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AddPlace {
	
	/**
	 * Validate if Add Place API is working as expected
	 * Add place ,Update Place with new Address,Get place to validate if new address is 
	 * present in response body
	 * 
	 * API response is coming from rigt Server as you expecting if not it might be hacked
	 * It is a very important assertion(Server validation is important)
	 * 
	 * 
	 * RestAssured works On three principle.
	 * given - all input details
	 * when- Submit the API with resource and http method
	 * then-validate the response
	 */
	
	@Test
	public void addplace()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"9176356542\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"https://rahulshettyacademy.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "    \r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "").when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)");
		
		//JsonPath path = new JsonPath(""[]);
		//You can assert body lavel as well body("scope", equalTo("APP"))
		//Please add import static org.hamcrest.Matchers.*;
		
		//Add place->Update Place with New Address->Get Place to validate if New address is present in
		
		
	}

}
