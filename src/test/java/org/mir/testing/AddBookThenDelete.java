package org.mir.testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import jsonpayload.PayLoadFactory;
import utils.ReUsableMethods;

public class AddBookThenDelete {

	// http://216.10.245.166/Library/Addbook.php

	static String isbn = ReUsableMethods.getAlphaString(4);
	static String aisle = ReUsableMethods.getNumericString(4);

	static String id = "";

	// "Msg": "successfully added",
	// "ID": "gndf25885"

	@Test(priority = 1)
	public void addBook() {

		RestAssured.baseURI = "http://216.10.245.166/";

		String stringResponse = given().log().all().contentType(ContentType.JSON).when()
				.body(PayLoadFactory.addBookInLibrary(isbn, aisle)).post("Library/Addbook.php").then().log().all()
				.assertThat().statusCode(200).body("Msg", equalTo("successfully added")).extract().response()
				.asPrettyString();

		JsonPath js = new JsonPath(stringResponse);
		id = js.getString("ID");
		System.out.println("Id from response body: "+id);

	}

	@Test(priority = 2)
	public void deleteBookThatJustAdded() {

		RestAssured.baseURI = "http://216.10.245.166/";

		given().log().all().contentType(ContentType.JSON).when().body(PayLoadFactory.deleteBookFromLibrary(id))
				.post("Library/Addbook.php").then().log().all().assertThat().statusCode(200);

	}

}
