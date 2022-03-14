package org.mir.stepDefination;

import static io.restassured.RestAssured.given;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import enums.APIResourcesRahul;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import jsonpayload.PayLoadFactory;
import pojo.payload.AddPlacePOJO;
import utils.ReUsableMethods;
import utils.SpecBuilder;

public class ReusuableStepDefination {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReusuableStepDefination.class);

	RequestSpecification requestSp;
	Response response;
	ResponseSpecification responseSp;
	public static String placeId;

	@Given("User add place payload")
	public void addPayload() {

		LOGGER.info("User add place payload");
		requestSp = given().spec(SpecBuilder.requestSpecification()).body(AddPlacePOJO.addPayLoad());

	}

	@When("User calls {string} with Post http request")
	public void callHTTPMethod(String httpMethod) {

		response = requestSp.when().post("maps/api/place/add/json");
	}
	
	@Then("User verify in response body place_id is created")
	public void getPlaceId() {
		placeId = ReUsableMethods.getJsonPathValue(response, "place_id");
	}

	@Then("The API call is success with status code {int}")
	public void statusCode(Integer code) {

		response.then().spec(SpecBuilder.responseSpecification()).statusCode(200);
	}

	@Then("{string} in response body is {string}")
	public void statusOk(String key, String value) {

		Assert.assertEquals(ReUsableMethods.getJsonPathValue(response, key), value);
	}

	@Given("User add place payload with {string} {string} {string}")
	public void addPlaceWithDifferentDataSets(String name, String phone, String address) {

		requestSp = given().spec(SpecBuilder.requestSpecification())
				.body(AddPlacePOJO.addPayLoad(name, phone, address));
	}

	@When("User calls {string} with {string} http request")
	public void callResourceDynamically(String resource, String httpMethod) {

		String httpM = APIResourcesRahul.valueOf(resource).getResource();

		System.out.println(httpM);

		if (httpMethod.equalsIgnoreCase("POST")) {
			response = requestSp.when().post(httpM);
		} else if (httpMethod.equalsIgnoreCase("GET")) {
			response = requestSp.when().get(httpM);
		} else if (httpMethod.equalsIgnoreCase("DELETE")) {
			response = requestSp.when().delete(httpM);
		}

	}
	
	@Then("User verify place_id created maps to {string} using {string} with {string} http request")
	public void getPlaceIdRespectToName(String expectedName, String resource, String httpM) {
		
		placeId = ReUsableMethods.getJsonPathValue(response, "place_id");
		requestSp = given().spec(SpecBuilder.requestSpecification()).queryParam("place_id", placeId);
		callResourceDynamically(resource, httpM);
		
	}


	@Then("User verify place_id created maps to {string} using {string}")
	public void getPlaceIdRespectToName(String expectedName, String resource) {

		placeId = ReUsableMethods.getJsonPathValue(response, "place_id");

		requestSp = given().spec(SpecBuilder.requestSpecification()).queryParam("place_id", placeId);

		callResourceDynamically(resource, "GET");

		String actualName = ReUsableMethods.getJsonPathValue(response, "name");

		Assert.assertEquals(actualName, expectedName, actualName + " is not equal to " + expectedName);
	}

	@Given("User added DeletePlace Payload")
	public void deletePlaceById() {
		requestSp = given().spec(SpecBuilder.requestSpecification()).body(PayLoadFactory.placeById(placeId));

	}
	
	
	@When("User performe GET for the post number {string}")
	public void someOperation(String name)
	{
		when().get(String.format("http://localhost:300/posts/%s", name));
	}

}




































