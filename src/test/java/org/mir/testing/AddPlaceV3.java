package org.mir.testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AddPlaceV3 {
	
	
	
	//Convert Files into Byte and then convert Byte into String
	//Byte format is integer type
	String filepath = "C:/Users/miraa/STS4Project/BddCucumberRestNote/src/main/resources/alljsonfiles/addplace.json";
	
	@Test
	public void addplace() throws Exception
	{
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get(filepath))))
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("status", equalTo("OK"))
		.header("Server", "Apache/2.4.18 (Ubuntu)");
	}

}
