package org.mir.serializationPlace;



import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.payload.AddPlacePOJO;

public class AddPlaceTest {
	
	@Test
	public void createAdd()
	{
		
		
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","Application/Json").body(AddPlacePOJO.addPayLoad())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
		
	}

}
