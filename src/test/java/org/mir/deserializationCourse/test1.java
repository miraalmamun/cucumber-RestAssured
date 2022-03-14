package org.mir.deserializationCourse;


import static io.restassured.RestAssured.given;

import io.restassured.parsing.Parser;


public class test1 {

	public static void main(String[] args) throws InterruptedException {
	
		    
		String accessToken = "ya29.A0ARrdaM-lT39mlKHnG0-a6sdJR95VXSAgTa-E9R0wjmJyV6g5hYuF7piP3BNTtAyN0ooyu0YWicH_WvSNv0iXA6G38-MoVwmqQUC3--cq2KXeReAA9YrFORZmAlaRU-Q2Cc77ST2rgdJl9lW3J6-VRK4T8hAN";		    
		String r2=    given().contentType("application/json").
				 queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)
				 .when()
           .get("https://rahulshettyacademy.com/getCourse.php")
		.asString();
		System.out.println(r2);

	
	
	}
	

}
