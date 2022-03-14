package org.mir.testing;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jsonpayload.PayLoadFactory;
import utils.ReUsableMethods;

public class AddBookInLibrary {

	// http://216.10.245.166/Library/Addbook.php

	static String isbn = ReUsableMethods.getAlphaString(4);
	static String aisle = ReUsableMethods.getNumericString(4);

	@Test(dataProvider = "dataForAddBook")
	public void addBook(String isbn, String aisle) {

		RestAssured.baseURI = "http://216.10.245.166/";

		given().log().all().contentType(ContentType.JSON).when().body(PayLoadFactory.addBookInLibrary(isbn, aisle))
				.post("Library/Addbook.php").then().log().all().assertThat().statusCode(200);

	}

	@DataProvider(name = "dataForAddBook")
	public String[][] data() {
		return new String[][] { { "1123", "abc" }, { "1456", "def" }, { "1789", "ghi" }, { "1159", "jkl" } };
	}

	// =========================================================================

	@Test()
	public void addBookWithRandom() {

		RestAssured.baseURI = "http://216.10.245.166/";

		given().log().all().contentType(ContentType.JSON).when().body(PayLoadFactory.addBookInLibrary(isbn, aisle))
				.post("Library/Addbook.php").then().log().all().assertThat().statusCode(200);

	}

}
