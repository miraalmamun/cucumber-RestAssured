package org.mir.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jsonpayload.PayLoadFactory;
import utils.ReUsableMethods;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HoldResponseBodyAndExtractValue {
	
	//https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123
	
	@Test
	public void getPlace_idFromResponseBody()
	{ 
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		
		
		RequestSpecification body = given().log().all().queryParam("key", "qaclick123").
		header("Content-Type","application/json").
		body(PayLoadFactory.addPlace());
		
		
		Response post = body.when().post("maps/api/place/add/json");
		
		
		ValidatableResponse validate = post.then().assertThat().statusCode(200).body("status", equalTo("OK")).	
				                       header("Server", "Apache/2.4.18 (Ubuntu)");
		
		String asString = validate.extract().response().asPrettyString();
		
		System.out.println(asString);
		
		
		//Get place_id from response body and hold it in a variable
		
		//JsonPath takes input as Stringy, File, InputStream, Reader, URL
		
		
		//Extract place_id from response body
		
		//JsonPath jsp = new JsonPath(asString);
		JsonPath jsp =ReUsableMethods.getJsonPath(asString);
		String placeId = jsp.getString("place_id");
		System.out.println(placeId);
		
		String[] newAddress = new String[] {"Flushing NY","Bangla"};
		
		RequestSpecification requestBody = given().log().all().queryParam("key", "qaclick123").
		header("Content-Type","application/json").
		body(PayLoadFactory.update(placeId, newAddress));
		
		Response responseBody = requestBody.when().put("/maps/api/place/update/json");
		
		ValidatableResponse finalResponse = responseBody.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated")).	
        header("Server", "Apache/2.4.18 (Ubuntu)");
		
		String responseBodyAsString = finalResponse.extract().response().asPrettyString();
		
		System.out.println(responseBodyAsString);
		
		//Get Place 
		
		String getResponseBody = given().log().all().queryParam("key", "qaclick123").
		queryParam("place_id", placeId).when().post("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asPrettyString();
		
		//Varify changed address match with new address
		
		JsonPath jPath = new JsonPath(getResponseBody);
		
		String actualAddress = jPath.getString("address");
		
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress[0],"Address is not match");
		
		
		
		
		
	}

}
