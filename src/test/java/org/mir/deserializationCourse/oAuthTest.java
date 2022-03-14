package org.mir.deserializationCourse;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.parsing.Parser;
import pojo.course.Api;
import pojo.course.GetCourse;
import pojo.course.WebAutomation;

/**
 * @author miraa
 * 
 *         What I am doing here? Coverting Json Response into Java object Why?
 *         It's help us to parse Complex Response Body If response json not
 *         complex then better to use JsonPath to perse the path.
 * 
 *         Why we parsing?
 * 
 *         For Validation
 *
 */

public class oAuthTest {

	public static void main(String[] args) throws InterruptedException {

		String accessToken = "ya29.A0ARrdaM-lT39mlKHnG0-a6sdJR95VXSAgTa-E9R0wjmJyV6g5hYuF7piP3BNTtAyN0ooyu0YWicH_WvSNv0iXA6G38-MoVwmqQUC3--cq2KXeReAA9YrFORZmAlaRU-Q2Cc77ST2rgdJl9lW3J6-VRK4T8hAN";

		GetCourse gc = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON).when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);

		System.out.println(gc.getUrl());

		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());

		List<Api> apiCourses = gc.getCourses().getApi();
		for (int i = 0; i < apiCourses.size(); i++) {
			if (apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println(apiCourses.get(i).getPrice());
			}
		}

		// Get the course names of WebAutomation
		ArrayList<String> a = new ArrayList<String>();

		List<WebAutomation> w = gc.getCourses().getWebAutomation();

		for (int j = 0; j < w.size(); j++) {
			a.add(w.get(j).getCourseTitle());
		}

	}

}
