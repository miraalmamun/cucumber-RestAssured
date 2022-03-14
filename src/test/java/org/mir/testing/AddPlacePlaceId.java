package org.mir.testing;

import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class AddPlacePlaceId {
	
	
	
	
	
	public static String filepath = "C:/Users/miraa/STS4Project/BddCucumberRestNote/src/main/resources/alljsonfiles/addplace.json";
	
	public static void main(String[] args) throws Exception {
		
RestAssured.baseURI="https://rahulshettyacademy.com/";
		
		RequestSpecification rsp = given().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get(filepath))));
		
		//Response response =
				String asString = rsp.when().post("maps/api/place/add/json").asPrettyString();
				
				JsonPath path = new JsonPath(asString);
				
				System.out.println(path.getString("place_id"));
				
				System.out.println(asString);
		
		//ValidatableResponse header = response.then().log().all().assertThat().statusCode(200).body("status", equalTo("OK"))
		//.header("Server", "Apache/2.4.18 (Ubuntu)");
		
		
		//System.out.println(header.toString());
	}

}
